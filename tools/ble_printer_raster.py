"""Печать на D30-класс принтере по BLE GATT (сервис 0xff00 / ff02).

Протокол (polskafan/phomemo_d30 + Vibe-D30 docs):
  1) магическая инициализация: 1f 11 38 / 1f 11 12 1f 11 13 / 1f 11 09 /
     1f 11 11 / 1f 11 19 / 1f 11 07 / 1f 11 0a 1f 11 02 02
  2) заголовок: 1f 11 24 00 + ESC @ + GS v 0 00 + ширина(байты,LE16) + высота(строки,LE16)
  3) растр: 1 бит/пиксель, MSB first, 1 = чернила
  4) подвал: ESC d 00

python tools\ble_printer_raster.py            # 12 мм (96 px), как D30
python tools\ble_printer_raster.py --wide     # 58 мм (384 px)
python tools\ble_printer_raster.py --no-init  # без магической инициализации
"""
import asyncio
import struct
import sys

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient
from PIL import Image, ImageDraw, ImageFont

MAC = "86:67:7a:06:78:05"
FF02 = "0000ff02-0000-1000-8000-00805f9b34fb"
FF03 = "0000ff03-0000-1000-8000-00805f9b34fb"

WIDE = "--wide" in sys.argv
NO_INIT = "--no-init" in sys.argv
width_px = 384 if WIDE else 96
height_px = 96 if WIDE else 48
width_b = width_px // 8

INIT = [
    b"\x1f\x11\x38",
    b"\x1f\x11\x12\x1f\x11\x13",
    b"\x1f\x11\x09",
    b"\x1f\x11\x11",
    b"\x1f\x11\x19",
    b"\x1f\x11\x07",
    b"\x1f\x11\x0a\x1f\x11\x02\x02",
]


def render() -> bytes:
    img = Image.new("L", (width_px, height_px), 255)
    d = ImageDraw.Draw(img)
    font = ImageFont.load_default(size=40 if WIDE else 22)
    d.text((width_px // 2, height_px // 2), "TEST", fill=0, anchor="mm", font=font)
    img = img.convert("1")
    out = bytearray()
    for y in range(height_px):
        for j in range(width_b):
            b = 0
            for k in range(8):
                if img.getpixel((j * 8 + k, y)) > 127:
                    b |= 1 << (7 - k)
            out.append(b)
    return bytes(out)


async def main() -> int:
    raster = render()
    header = (
        b"\x1f\x11\x24\x00"
        + b"\x1b\x40"
        + b"\x1d\x76\x30\x00"
        + struct.pack("<H", width_b)
        + struct.pack("<H", height_px)
    )
    footer = b"\x1b\x64\x00"

    print(f"Подключение к {MAC} ...")
    client = BleakClient(MAC, timeout=20)
    try:
        await client.connect()
    except Exception as e:  # noqa: BLE001
        print(f"ОШИБКА подключения: {e}")
        return 2
    print(f"Подключено, MTU: {client.mtu_size}")

    def handler(_c, d: bytearray):
        print(f"  << ff03: {bytes(d).hex(' ')}")

    for svc in list(client.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF03 and "notify" in ch.properties:
                await client.start_notify(ch, handler)

    ff02 = None
    for svc in list(client.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF02:
                ff02 = ch
                break
    if ff02 is None:
        print("ff02 не найдена")
        return 3

    if not NO_INIT:
        print(f"\n=== магическая инициализация ===")
        for p in INIT:
            print(f">> {p.hex(' ')}")
            await client.write_gatt_char(ff02, p, response=True)
            await asyncio.sleep(0.15)
        await asyncio.sleep(0.5)

    print(f"\n=== печать: {width_px}x{height_px} px, {len(raster)} байт ===")
    print(f">> header: {header.hex(' ')}")
    await client.write_gatt_char(ff02, header, response=True)
    await asyncio.sleep(0.2)
    chunk = 180
    for i in range(0, len(raster), chunk):
        await client.write_gatt_char(ff02, raster[i:i + chunk], response=True)
        await asyncio.sleep(0.05)
    print(f">> footer: {footer.hex(' ')}")
    await client.write_gatt_char(ff02, footer, response=True)
    await asyncio.sleep(3)
    print("Готово — проверьте ленту.")
    return 0


if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

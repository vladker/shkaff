"""Тест без магической инициализации + разные характеристики.

Пробуем:
  1) ff02 без magic init
  2) Microchip UART 8841
  3) ff02 с magic init ПОСЛЕ raster header (вместо ДО)
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
FF01 = "0000ff01-0000-1000-8000-00805f9b34fb"
MICROCHIP_8841 = "49535343-8841-4e2d-8071-4a6038000000"
MICROCHIP_ACA3 = "49535343-aca3-4e2d-8071-4a6038000000"

width_b = 12
height_px = 48
width_px = width_b * 8

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
    font = ImageFont.load_default(size=22)
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


def build_header(h: int) -> bytes:
    return (
        b"\x1b\x40"
        + b"\x1d\x76\x30\x00"
        + struct.pack("<H", width_b)
        + struct.pack("<H", h)
    )


def build_header_magic(h: int) -> bytes:
    return (
        b"\x1f\x11\x24\x00"
        + b"\x1b\x40"
        + b"\x1d\x76\x30\x00"
        + struct.pack("<H", width_b)
        + struct.pack("<H", h)
    )


async def try_write(client, ch_uuid: str, data: bytes, label: str):
    for svc in list(client.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == ch_uuid.lower():
                wnr = "write-without-response" in ch.properties
                wr = "write" in ch.properties
                if not (wr or wnr):
                    print(f"  [{label}] {ch_uuid}: нет write")
                    return False
                try:
                    await client.write_gatt_char(ch, data, response=wr)
                    print(f"  [{label}] OK ({len(data)} bytes)")
                    return True
                except Exception as e:
                    print(f"  [{label}] ОШИБКА: {e}")
                    return False
    print(f"  [{label}] {ch_uuid} не найдена")
    return False


async def main():
    raster = render()
    footer = b"\x1b\x64\x00"

    print(f"Подключение к {MAC} ...")
    client = BleakClient(MAC, timeout=20)
    try:
        await client.connect()
    except Exception as e:
        print(f"ОШИБКА: {e}")
        return 1
    print(f"Подключено, MTU: {client.mtu_size}\n")

    def handler(_c, d: bytearray):
        print(f"  << {bytes(d).hex(' ')}")

    for svc in list(client.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF03 and "notify" in ch.properties:
                await client.start_notify(ch, handler)

    tests = [
        ("TEST 1: ff02, без init", FF02, build_header(height_px) + raster + footer),
        ("TEST 2: ff02, magic init + header+raster", FF02, b"".join(INIT) + build_header_magic(height_px) + raster + footer),
        ("TEST 3: 8841 (UART TX), без init", MICROCHIP_8841, build_header(height_px) + raster + footer),
        ("TEST 4: aca3 (UART), magic init", MICROCHIP_ACA3, b"".join(INIT) + build_header_magic(height_px) + raster + footer),
    ]

    for label, uuid, data in tests:
        print(f"--- {label} ---")
        await asyncio.sleep(1)
        await try_write(client, uuid, data, label)

    print("\nВсе отправлены. Проверьте ленту — что напечаталось?")
    await asyncio.sleep(3)
    return 0


if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

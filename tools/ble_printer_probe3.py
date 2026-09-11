"""Тест 2: разные характеристики + печать текстом (без растра).

Тест A: Microchip UART (8841) — текст ESC/POS "Hello"
Тест B: Microchip UART (8841) — растр D30
Тест C: ff02 — текст ESC/POS "Hello"
Тест D: fec7 (fee7) — текст ESC/POS
Тест E: e7810a71/bef8d6c9 — текст ESC/POS
"""
import asyncio
import struct
import sys

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient
from PIL import Image, ImageDraw, ImageFont

MAC = "86:67:7a:06:78:05"

UART_TX   = "49535343-1e4d-4bd9-ba61-23c647249616"
UART_RX   = "49535343-8841-43f4-a8d4-ecbe34729bb3"
UART_MID  = "49535343-aca3-481c-91ec-d85e28a60318"
FEC7      = "0000fec7-0000-1000-8000-00805f9b34fb"
BEF8      = "bef8d6c9-9c21-4c9e-b632-bd58c1009f9f"
FF02      = "0000ff02-0000-1000-8000-00805f9b34fb"
FF01      = "0000ff01-0000-1000-8000-00805f9b34fb"
FF03      = "0000ff03-0000-1000-8000-00805f9b34fb"

TEXT_ESCPOS = b"\x1b\x40" + b"TEST HELLO\n\r\x1b\x64\x00"

width_b = 12
height_px = 48

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
    img = Image.new("L", (96, 48), 255)
    d = ImageDraw.Draw(img)
    font = ImageFont.load_default(size=22)
    d.text((48, 24), "TEST", fill=0, anchor="mm", font=font)
    img = img.convert("1")
    out = bytearray()
    for y in range(48):
        for j in range(width_b):
            b = 0
            for k in range(8):
                if img.getpixel((j * 8 + k, y)) > 127:
                    b |= 1 << (7 - k)
            out.append(b)
    return bytes(out)


async def main():
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
    c = BleakClient(MAC, timeout=20)
    try:
        await c.connect()
    except Exception as e:
        print(f"ОШИБКА: {e}")
        return 1
    print(f"Подключено, MTU: {c.mtu_size}\n")

    def handler(_ch, data: bytearray):
        print(f"  << {bytes(data).hex(' ')}")

    for svc in list(c.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF03 and "notify" in ch.properties:
                await c.start_notify(ch, handler)

    async def wr(uuid, data, label, wait=0.5):
        for svc in list(c.services):
            for ch in svc.characteristics:
                if ch.uuid.lower() == uuid.lower():
                    try:
                        await c.write_gatt_char(ch, data, response=True)
                        print(f"  [{label}] OK ({len(data)} bytes)")
                        await asyncio.sleep(wait)
                        return True
                    except Exception as e:
                        print(f"  [{label}] ERR: {e}")
                        await asyncio.sleep(wait)
                        return False
        print(f"  [{label}] {uuid} NOT FOUND")
        return False

    tests = [
        ("A: UART 8841 + текст", UART_RX, TEXT_ESCPOS),
        ("B: UART 8841 + init + raster", UART_RX, b"".join(INIT) + header + raster + footer),
        ("C: ff02 + текст (без init)", FF02, TEXT_ESCPOS),
        ("D: ff02 + текст + init", FF02, b"".join(INIT) + TEXT_ESCPOS),
        ("E: fec7 + текст", FEC7, TEXT_ESCPOS),
        ("F: bef8 + текст", BEF8, TEXT_ESCPOS),
        ("G: UART aca3 + текст", UART_MID, TEXT_ESCPOS),
        ("H: ff02 + init + raster + без 1f112400", FF02, b"".join(INIT) + b"\x1b\x40\x1d\x76\x30\x00" + struct.pack("<H", width_b) + struct.pack("<H", height_px) + raster + footer),
    ]

    for label, uuid, data in tests:
        print(f"\n--- {label} ---")
        await wr(uuid, data, label, wait=1)

    print("\n\nВсе отправлены. Проверьте ленту.")
    await asyncio.sleep(3)
    return 0


if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

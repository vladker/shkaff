"""58мм BLE принтер: растр с чанкованием по MTU (use write-with-response + chunks).

Проба с чанками ≤ 170 байт через write-with-response.
"""
import asyncio
import struct
import sys

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient

MAC = "86:67:7a:06:78:05"
FF02 = "0000ff02-0000-1000-8000-00805f9b34fb"
FF03 = "0000ff03-0000-1000-8000-00805f9b34fb"

W = 384
WB = W // 8
H = 40
CHUNK = 170

def make_pattern() -> bytes:
    out = bytearray()
    for y in range(H):
        row = bytearray(WB) if (y // 8) % 2 == 1 else bytearray([0xFF] * WB)
        out += row
    return bytes(out)

async def main():
    pat = make_pattern()
    print(f"Паттерн {W}x{H} = {len(pat)} байт, chunk={CHUNK}")

    c = BleakClient(MAC, timeout=20)
    await c.connect()
    print(f"MTU={c.mtu_size}\n")

    def h(_c, d: bytearray):
        print(f"  << {d.hex(' ')}")

    for svc in list(c.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF03 and "notify" in ch.properties:
                await c.start_notify(ch, h)

    ff02 = None
    for svc in list(c.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF02:
                ff02 = ch
    if ff02 is None:
        print("ff02 not found")
        return 1

    header_plain = b"\x1b\x40" + b"\x1d\x76\x30\x00" + struct.pack("<H", WB) + struct.pack("<H", H)
    footer = b"\x1b\x64\x00"

    async def send_chunked(data, label):
        try:
            for i in range(0, len(data), CHUNK):
                await c.write_gatt_char(ff02, data[i:i+CHUNK], response=True)
                await asyncio.sleep(0.02)
            print(f"  [{label}] sent {len(data)} bytes in chunks")
        except Exception as e:
            print(f"  [{label}] ERR: {e}")

    tests = {
        "10-plain-chunked":      header_plain + pat + footer,
        "11-init+plain-chunked": b"\x1f\x11\x38\x1f\x11\x12\x1f\x11\x13\x1f\x11\x09\x1f\x11\x11\x1f\x11\x19\x1f\x11\x07\x1f\x11\x0a\x1f\x11\x02\x02" + header_plain + pat + footer,
        "12-text-HELLO":         b"\x1b\x40HELLO\n\r",
        "13-feed-only":          b"\x1b\x64\x08",
    }

    for name, data in tests.items():
        print(f"\n=== {name} ===")
        await asyncio.sleep(1)
        await send_chunked(data, name)
        await asyncio.sleep(3)

    print("\n\nПроверьте ленту.")
    await asyncio.sleep(1)
    await c.disconnect()
    return 0

if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))
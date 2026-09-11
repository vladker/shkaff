"""58мм BLE принтер: систематический перебор упаковок растра через ff02.

Паттерн: чёрные горизонтальные полосы на всю 384px ширину (58мм).
Высота 100px. Отправляем через ff02 разными упаковками.
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

W = 384          # 58mm width in px
WB = W // 8      # 48 bytes per row
H = 40           # rows

def make_pattern() -> bytes:
    out = bytearray()
    for y in range(H):
        row = bytearray(WB)
        if (y // 8) % 2 == 0:
            for j in range(WB):
                row[j] = 0xFF
        out += row
    return bytes(out)

def esc_pos_raster(data, height=H):
    return (b"\x1b\x40" + b"\x1d\x76\x30\x00" +
            struct.pack("<H", WB) + struct.pack("<H", height) + data)

INIT = [
    b"\x1f\x11\x38",
    b"\x1f\x11\x12\x1f\x11\x13",
    b"\x1f\x11\x09",
    b"\x1f\x11\x11",
    b"\x1f\x11\x19",
    b"\x1f\x11\x07",
    b"\x1f\x11\x0a\x1f\x11\x02\x02",
]

async def main():
    pat = make_pattern()
    print(f"Паттерн {W}x{H}, {len(pat)} байт")

    c = BleakClient(MAC, timeout=20)
    await c.connect()
    print(f"MTU={c.mtu_size}\n")

    def h(_c, d: bytearray):
        print(f"  << {d.hex(' ')}")

    for svc in list(c.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == FF03 and "notify" in ch.properties:
                await c.start_notify(ch, h)

    header_plain = b"\x1b\x40" + b"\x1d\x76\x30\x00" + struct.pack("<H", WB) + struct.pack("<H", H)
    footer = b"\x1b\x64\x00"

    es = esc_pos_raster(pat)

    tests = {
        "1-plain-GSv0":            header_plain + pat + footer,
        "2-len16-total":           struct.pack("<H", len(es)) + es,
        "3-len16-data":            struct.pack("<H", len(pat)) + header_plain + pat + footer,
        "4-len32-type":            struct.pack("<I", len(es)) + es,
        "5-raw-noescpos":          pat,
        "6-init+GSv0":             b"".join(INIT) + header_plain + pat + footer,
        "7-1f112400+GSv0":         b"\x1f\x11\x24\x00" + header_plain + pat + footer,
        "8-prefix1f11+len+GSv0":   b"\x1f\x11" + struct.pack("<H", len(es)) + es,
        "9-2xbytes-first-high":    struct.pack(">H", len(es)) + es,
    }

    for name, data in tests.items():
        print(f"\n=== {name} ({len(data)} bytes) ===")
        await asyncio.sleep(0.8)
        for svc in list(c.services):
            for ch in svc.characteristics:
                if ch.uuid.lower() == FF02:
                    try:
                        await c.write_gatt_char(ch, data, response=False)
                        print("  sent (wnr)")
                    except Exception as e:
                        print(f"  wnr ERR {e}")
                    break
        # feed the tape to separate tests: ESC d n (print n lines of blank)
        for svc in list(c.services):
            for ch in svc.characteristics:
                if ch.uuid.lower() == FF02:
                    try:
                        await c.write_gatt_char(ch, b"\x1b\x64\x06", response=False)
                    except Exception:
                        pass
                    break
        await asyncio.sleep(2.5)

    print("\n\n=== ВСЕ ФОРМАТЫ ОТПРАВЛЕНЫ ===")
    print("Проверьте, в каком участке ленты напечатались полосы.")
    print("Порядок: 1-plain, 2-len16, 3-len16data, 4-len32, 5-raw,")
    print("         6-init, 7-1f112400, 8-prefix1f11, 9-big-endian")
    await asyncio.sleep(2)
    await c.disconnect()
    return 0

if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

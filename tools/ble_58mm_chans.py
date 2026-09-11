"""Перебор каналов с чанкованием по MTU. Паттерн: чёрные полосы 384px.

Каждый канал: ff02, 8841 (UART RX), aca3, fec7, bef8.
Каждая комбинация: с 1f112400-магией и без.
Все пишем чанками по 170 байт.
"""
import asyncio
import struct
import sys

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient

MAC = "86:67:7a:06:78:05"
W = 384
WB = W // 8
H = 24
CHUNK = 170

CHANS = {
    "ff02":  "0000ff02-0000-1000-8000-00805f9b34fb",
    "8841":  "49535343-8841-43f4-a8d4-ecbe34729bb3",
    "aca3":  "49535343-aca3-481c-91ec-d85e28a60318",
    "fec7":  "0000fec7-0000-1000-8000-00805f9b34fb",
    "bef8":  "bef8d6c9-9c21-4c9e-b632-bd58c1009f9f",
}

def make_pattern() -> bytes:
    out = bytearray()
    for y in range(H):
        row = bytearray(WB) if (y // 6) % 2 == 1 else bytearray([0xFF] * WB)
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
            if ch.uuid.lower() in ("0000ff03-0000-1000-8000-00805f9b34fb",) and "notify" in ch.properties:
                await c.start_notify(ch, h)

    header_plain = struct.pack("<H", WB) + struct.pack("<H", H)
    full_plain = b"\x1b\x40" + b"\x1d\x76\x30\x00" + header_plain
    full_magic = b"\x1f\x11\x24\x00" + full_plain
    footer = b"\x1b\x64\x00"

    variants = {
        "plain":  full_plain  + pat + footer,
        "magic":  full_magic  + pat + footer,
    }

    async def send(uuid, data, response, label):
        char = None
        for svc in list(c.services):
            for ch in svc.characteristics:
                if ch.uuid.lower() == uuid.lower():
                    char = ch
                    break
        if char is None:
            print(f"  [{label}] char not found")
            return
        try:
            for i in range(0, len(data), CHUNK):
                await c.write_gatt_char(char, data[i:i+CHUNK], response=response)
                await asyncio.sleep(0.02)
            print(f"  [{label}] send {len(data)}B response={response}")
        except Exception as e:
            print(f"  [{label}] ERR: {e}")

    for cname, uuid in CHANS.items():
        for vname, data in variants.items():
            for rsp in (False, True):
                label = f"{cname}/{vname}/rsp={rsp}"
                print(f"--- {label} ---")
                await asyncio.sleep(0.5)
                await send(uuid, data, rsp, label)
                await asyncio.sleep(2.5)
                # feed the tape
                char = None
                for svc in list(c.services):
                    for ch in svc.characteristics:
                        if ch.uuid.lower() == CHANS["ff02"]:
                            char = ch
                            break
                if char:
                    try:
                        await c.write_gatt_char(char, b"\x1b\x64\x08", response=False)
                    except Exception:
                        pass

    print("\n\n=== ВСЁ ОТПРАВЛЕНО ===")
    print("Проверьте ленту: какие каналы и варианты напечатались.")
    await c.disconnect()
    return 0

if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))
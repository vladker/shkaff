"""Финальный пробник: разблокировка через 0xfee7 + попытка печати."""
import asyncio
import sys

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient

MAC = "86:67:7a:06:78:05"
FEC7 = "0000fec7-0000-1000-8000-00805f9b34fb"
FEC8 = "0000fec8-0000-1000-8000-00805f9b34fb"
FF02 = "0000ff02-0000-1000-8000-00805f9b34fb"
FF03 = "0000ff03-0000-1000-8000-00805f9b34fb"
BEF8 = "bef8d6c9-9c21-4c9e-b632-bd58c1009f9f"

TEXT = b"\x1b\x40" + b"TEST\n\r"

async def main():
    c = BleakClient(MAC, timeout=20)
    await c.connect()
    print(f"MTU={c.mtu_size}")

    msgs = []
    def h(_c, d: bytearray):
        msgs.append(bytes(d))
        print(f"  << {d.hex(' ')}")

    for svc in list(c.services):
        for ch in svc.characteristics:
            uuid = ch.uuid.lower()
            if ("notify" in ch.properties or "indicate" in ch.properties) and uuid in [
                "0000ff03-0000-1000-8000-00805f9b34fb",
                "0000fec8-0000-1000-8000-00805f9b34fb",
                "0000ff01-0000-1000-8000-00805f9b34fb",
                "00002af0-0000-1000-8000-00805f9b34fb",
            ]:
                await c.start_notify(ch, h)

    async def wr(uuid, data, label):
        for svc in list(c.services):
            for ch in svc.characteristics:
                if ch.uuid.lower() == uuid.lower():
                    msgs.clear()
                    try:
                        await c.write_gatt_char(ch, data, response=True)
                        print(f"  >> {label}: {data.hex(' ')} OK")
                    except Exception as e:
                        print(f"  >> {label}: ERR {e}")
                    await asyncio.sleep(1.5)
                    if msgs:
                        for m in msgs:
                            print(f"    respuesta: {m.hex(' ')}")
                    else:
                        print(f"    sin respuesta")
                    return

    # 1. fee7 unlock
    print("=== 1. fee7 unlock ===")
    await wr(FEC7, b"\x01", "fee7 unlock")
    await wr(FEC7, b"\x01\x01", "fee7 unlock2")
    await wr(FEC7, b"\x00", "fee7 reset")

    # 2. befd8d6c9
    print("=== 2. bef8d6c9 (e7810a71) ===")
    await wr(BEF8, b"\x01", "bef8 cmd")
    await wr(BEF8, b"\x02", "bef8 cmd2")

    # 3. ff02 text (no init)
    print("=== 3. ff02 text ===")
    await wr(FF02, TEXT, "text")

    # 4. ff02 + fe7d UART RX
    UART_RX = "49535343-8841-43f4-a8d4-ecbe34729bb3"
    print("=== 4. UART RX text ===")
    await wr(UART_RX, TEXT, "uart_text")

    print("\n=== 5. Сбор 8 сек ===")
    msgs.clear()
    await asyncio.sleep(8)
    for m in msgs:
        print(f"  << {m.hex(' ')}")

    await c.disconnect()
    return 0

if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

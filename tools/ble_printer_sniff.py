"""Подбор протокола BLE-принтера P1_7805.

Канал управления, вероятно, сервис 0xff00: запись 0xff02, ответы 0xff01/0xff03.
Пробуем различные фрейминги и одиночные командные байты, логим все notify.
"""
import asyncio
import struct
import sys
import time

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient

MAC = "86:67:7a:06:78:05"
CTRL_WRITE = "0000ff02-0000-1000-8000-00805f9b34fb"
DATA_8841 = "49535343-8841-43f4-a8d4-ecbe34729bb3"
DATA_ACA3 = "49535343-aca3-481c-91ec-d85e28a60318"

TEXT = b"\x1b\x40PROBE\r\n\x1b\x64\x02"


def find_char(client, uuid: str):
    for svc in list(client.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == uuid.lower():
                return ch
    return None


async def main() -> int:
    t0 = time.time()
    print(f"Подключение к {MAC} ...")
    client = BleakClient(MAC, timeout=20)
    try:
        await client.connect()
    except Exception as e:  # noqa: BLE001
        print(f"ОШИБКА подключения: {e}")
        return 2
    print(f"Подключено, MTU: {client.mtu_size}")

    def make_handler(ch):
        def handler(_c, data: bytearray):
            print(f"  [{time.time() - t0:6.1f}с] << {ch.uuid[:8]}…: {bytes(data).hex(' ')}")
        return handler

    for svc in list(client.services):
        for ch in svc.characteristics:
            if "notify" in ch.properties or "indicate" in ch.properties:
                try:
                    await client.start_notify(ch, make_handler(ch))
                except Exception:  # noqa: BLE001
                    pass

    ctrl = find_char(client, CTRL_WRITE)
    c8841 = find_char(client, DATA_8841)
    caca3 = find_char(client, DATA_ACA3)

    async def try_write(tag: str, ch, payload: bytes):
        print(f"[{time.time() - t0:6.1f}с] >> {tag}: {payload.hex(' ')}")
        try:
            await client.write_gatt_char(ch, payload, response="write" in ch.properties)
        except Exception as e:  # noqa: BLE001
            print(f"         ошибка: {e}")
        await asyncio.sleep(1.0)

    print("\n=== 1) одиночные командные байты в 0xff02 ===")
    for cmd in range(0x00, 0x30):
        await try_write(f"cmd={cmd:02x}", ctrl, bytes([cmd]))
    await asyncio.sleep(1)

    print("\n=== 2) фрейминги с текстом ===")
    await try_write("raw-ctrl", ctrl, TEXT)
    await try_write("le16-ctrl", ctrl, struct.pack("<H", len(TEXT)) + TEXT)
    await try_write("be16-ctrl", ctrl, struct.pack(">H", len(TEXT)) + TEXT)
    await try_write("cmd01+data", ctrl, b"\x01" + TEXT)
    await try_write("cmd02+data", ctrl, b"\x02" + TEXT)
    await try_write("cmd03+data", ctrl, b"\x03" + TEXT)
    await try_write("raw-8841", c8841, TEXT)
    await try_write("le16-8841", c8841, struct.pack("<H", len(TEXT)) + TEXT)
    await try_write("cmd01-8841", c8841, b"\x01" + TEXT)
    if caca3 is not None:
        await try_write("raw-aca3", caca3, TEXT)
    await asyncio.sleep(1)

    print("\nГотово. Сообщите: что напечаталось + какие << notify пришли.")
    return 0


if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

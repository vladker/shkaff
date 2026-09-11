"""Разовая диагностика BLE-принтера (P1_7805) с ПК.

Режимы:
  python tools\ble_printer_probe.py            # эксперимент: подписка на notify + тест в каждую writable
  python tools\ble_printer_probe.py --list     # только список GATT
  python tools\ble_printer_probe.py --print CH # печать одной метки в указанную характеристику (uuid)

Перед запуском: принтер в режиме сопряжения (обычно удержание FEED при включении),
телефон с приложением отключён (BLE — только один центральный за раз).
"""
import asyncio
import sys
import time

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient

MAC = "86:67:7a:06:78:05"

# порядок проб: от «самых похожих на печать» к стандартным
PROBE_ORDER = [
    ("49535343-8841-43f4-a8d4-ecbe34729bb3", "T8841"),
    ("49535343-aca3-481c-91ec-d85e28a60318", "TACA3"),
    ("0000ff02-0000-1000-8000-00805f9b34fb", "TFF02"),
    ("0000fec7-0000-1000-8000-00805f9b34fb", "TFEC7"),
    ("bef8d6c9-9c21-4c9e-b632-bd58c1009f9f", "TBEG8"),
    ("00002af1-0000-1000-8000-00805f9b34fb", "T2AF1"),
]


def escpos(marker: str) -> bytes:
    return (
        b"\x1b\x40"          # init
        + marker.encode("ascii")
        + b"\r\n"
        + b"\x1b\x64\x02"    # подать ленту
    )


def find_char(client, uuid: str):
    for svc in list(client.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == uuid.lower():
                return ch
    return None


async def main() -> int:
    args = sys.argv[1:]
    list_only = "--list" in args
    print_uuid = None
    if "--print" in args:
        print_uuid = args[args.index("--print") + 1]

    print(f"Подключение к {MAC} ...")
    client = BleakClient(MAC, timeout=20)
    try:
        await client.connect()
    except Exception as e:  # noqa: BLE001
        print(f"ОШИБКА подключения: {type(e).__name__}: {e}")
        return 2
    print("Подключено.")
    try:
        try:
            print(f"MTU: {client.mtu_size}")
        except Exception:  # noqa: BLE001
            pass

        services = list(client.services)
        if list_only:
            for svc in services:
                print(f"\n  сервис {svc.uuid}")
                for ch in svc.characteristics:
                    print(f"    характеристика {ch.uuid}  [{','.join(ch.properties) or '-'}]")
            return 0

        # подписка на все notify/indicate — ловим ответы прошивки
        t0 = time.time()

        def make_handler(ch):
            def handler(_c, data: bytearray):
                print(f"  [{time.time() - t0:5.1f}с] NOTIFY {ch.uuid[:13]}… : {data.hex(' ')}")
            return handler

        notified = 0
        for svc in services:
            for ch in svc.characteristics:
                if "notify" in ch.properties or "indicate" in ch.properties:
                    try:
                        await client.start_notify(ch, make_handler(ch))
                        notified += 1
                    except Exception as e:  # noqa: BLE001
                        print(f"  start_notify {ch.uuid[:13]}… не удалась: {e}")
        print(f"Подписка на {notified} notify-характеристик.\n")

        targets = []
        if print_uuid:
            ch = find_char(client, print_uuid)
            if ch is None:
                print(f"Характеристика {print_uuid} не найдена.")
                return 3
            targets = [(ch, print_uuid[:8].upper())]
        else:
            for uuid, marker in PROBE_ORDER:
                ch = find_char(client, uuid)
                if ch is not None:
                    targets.append((ch, marker))

        for ch, marker in targets:
            use_resp = "write" in ch.properties
            payload = escpos(marker)
            print(f"-> {marker}: {payload.hex(' ')}  (response={use_resp})")
            try:
                await client.write_gatt_char(ch, payload, response=use_resp)
                print("   отправлено")
            except Exception as e:  # noqa: BLE001
                print(f"   ОШИБКА: {type(e).__name__}: {e}")
            await asyncio.sleep(3)

        print("\nГотово. Сообщите, какие метки напечатались и были ли NOTIFY выше.")
        return 0
    finally:
        await client.disconnect()


if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

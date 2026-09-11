"""Диагностика: подписка на ВСЕ notify + попытка прочитать статус."""
import asyncio
import sys

if hasattr(sys.stdout, "reconfigure"):
    sys.stdout.reconfigure(encoding="utf-8")

from bleak import BleakClient

MAC = "86:67:7a:06:78:05"

async def main():
    print(f"Подключение к {MAC} ...")
    c = BleakClient(MAC, timeout=20)
    await c.connect()
    print(f"Подключено, MTU: {c.mtu_size}\n")

    # Собираем ВСЕ notify/indicate характеристики
    notifiable = []
    for svc in list(c.services):
        for ch in svc.characteristics:
            if "notify" in ch.properties or "indicate" in ch.properties:
                notifiable.append(ch)
                print(f"  notify: {ch.uuid} ({svc.uuid})")

    messages = []

    def handler(ch):
        def h(_c, data: bytearray):
            tag = str(ch.uuid)[:8]
            messages.append((tag, bytes(data)))
            print(f"  << {tag}: {bytes(data).hex(' ')}")
        return h

    for ch in notifiable:
        try:
            await c.start_notify(ch, handler(ch))
            print(f"  подписка на {ch.uuid} OK")
        except Exception as e:
            print(f"  подписка на {ch.uuid} ERR: {e}")

    # Попробуем прочитать readable характеристики
    print("\n=== READ ===")
    for svc in list(c.services):
        for ch in svc.characteristics:
            if "read" in ch.properties:
                try:
                    val = await c.read_gatt_char(ch)
                    print(f"  {ch.uuid} = {bytes(val).hex(' ')}  ({val!r})")
                except Exception as e:
                    print(f"  {ch.uuid} ERR: {e}")

    # Попробуем написать в ff02 маленький пакет и посмотреть ответ
    print("\n=== WRITE TEST: ff02 0x0a (newline) ===")
    for svc in list(c.services):
        for ch in svc.characteristics:
            if ch.uuid.lower() == "0000ff02-0000-1000-8000-00805f9b34fb":
                messages.clear()
                try:
                    await c.write_gatt_char(ch, b"\x0a", response=True)
                    print("  отправлено OK")
                except Exception as e:
                    print(f"  ERR: {e}")
                await asyncio.sleep(2)
                print(f"  ответов: {len(messages)}")
                for tag, data in messages:
                    print(f"    << {tag}: {data.hex(' ')}")

    # 10 секунд сбора всех notify
    print("\n=== Сбор notify 10 сек... ===")
    messages.clear()
    await asyncio.sleep(10)
    print(f"  получено {len(messages)} сообщений:")
    for tag, data in messages:
        print(f"    << {tag}: {data.hex(' ')}")

    await c.disconnect()
    return 0

if __name__ == "__main__":
    raise SystemExit(asyncio.run(main()))

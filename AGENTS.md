# AGENTS.md — «Шкаф» (shkaff)

Офлайн-приложение инвентаризации вещей на Android: вещи, ящики (locations), шкафы (storages), этикетки, сканер, разметка фото, бэкап/слияние, печать, локальный LLM-агент. Gradle-модули: `:app` (пакет `ru.vldkr.shkaff`) и `:llama` (JNI-обёртка `ru.vldkr.shkaff.llm.LlamaBridge` над llama.cpp из git-подмодуля `third_party/llama.cpp`, тег `b9999`).

`PLAN.md` — ТЗ и дорожная карта (M1–M13; M8–M13 — пользовательские истории US-A…US-H). Где `PLAN.md` и код расходятся — **код старший** (напр., FTS5, TFLite u2net, ML Kit в плане есть, в коде их нет).

## Команды (Windows)

- Сборка: `.\gradlew.bat :app:assembleDebug` (первый клон: `git submodule update --init third_party/llama.cpp`)
- Релизный APK: `.\gradlew.bat :app:assembleRelease` — подписан ключом из `keystore.properties` (файл в `.gitignore`, шаблон `keystore.properties.example`, сам ключ `keystore/upload-keystore.jks`). Без `keystore.properties` релиз подписывается debug-ключом.
- Юнит-тесты: `.\gradlew.bat :app:testDebugUnitTest` (JUnit4 + Robolectric; тесты — `sync/MergeEngineTest.kt`, `sync/MergeSanitizerTest.kt`, `sync/MergeSessionTest.kt`, `sync/BackupFormatTest.kt`, `domain/agent/LlmMemoryPlanTest.kt` в `app/src/test/`)
- Установка на смартфон: `adb install -r app\build\outputs\apk\debug\app-debug.apk` — **обязательный шаг в конце каждого комита** (после успешной сборки и тестов; adb: `C:\Users\vldkr\AppData\Local\Android\Sdk\platform-tools\adb.exe`, устройство: SM-S928B, Android 16)
- Room: схемы экспортируются в `app/schemas/` (KSP-арг). При изменении сущностей — поднять `version` в `ShkaffDatabase` + миграция.
- В базе включён `allowMainThreadQueries()` — не «чинить» без явной задачи.

## Архитектура — отличается от дефолтов

- **Нет Hilt и другого DI.** Инъекции — ручной синглтон `object Deps` (`di/Deps.kt`), инициализируется в `ShkaffApp.onCreate`. Репозитории: `Deps.items`, `Deps.locations`, `Deps.storages`, `Deps.attributes`; `Deps.deviceId` — UUID устройства (генерится при первом запуске, хранится в `schema_meta`).
- **JSON — `org.json`** (`data/AttrJson.kt`, `sync/Backup.kt`). kotlinx-serialization в проекте нет.
- ViewModel — простые классы без Hilt: `class DashboardVm : ViewModel()` + `val ui = MutableStateFlow(Ui())`; обновление через `LaunchedEffect(Unit) { vm.refresh() }`. Шаблон — `features/dashboard/Dashboard.kt`.
- Навигация — Navigation Compose со **строковыми роутами** (не type-safe), `NavHost` в `MainActivity.kt`. Экраны принимают `(nav: NavController, args)`. Bottom-nav: 3 вкладки (dashboard/items/storages).
- UI — Compose + Material 3, тема `ShkaffTheme` (`ui/theme/Theme.kt`), общие компоненты в `ui/components/Common.kt` (`EmptyState`, `SectionTitle`, `LocationMap`, `ItemRow`).
- Строки интерфейса — на русском.

## Модель данных

- Сущности: `data/db/Entities.kt` — `storage`, `location`, `item`, `annotation`, `label_template`, `attribute_def`, `printer_profile`, `conflict_log`, `schema_meta`, `tag`, `draft`, `user`, `loan`, `action_log`, `stack`, `stack_member`, `basket`, `basket_item`, `peer_db`.
- У всех: `id: String` (UUID через `util/newId()`), `created_at`/`updated_at` (эпоха, мс), **мягкое удаление** `deleted_at: Long?`, `device_last_modified` (UUID устройства).
- Иерархия: `storage` (само-вложенность) → `location` (`storage_id` + само-вложенность) → `item` (`location_id`). `annotation` привязана к `storage` и указывает на `location`.
- Атрибуты: JSON-строка `Map<String,String>` через `AttrJson`; словарь типов в `attribute_def` (сиется в `Deps.seedDefaultAttributes()`, только если таблица пуста).
- `annotation.points` — **нормализованные координаты 0..1** (JSON). Пиксели сохранять нельзя.
- Поиск — `LIKE` (`likeSearch` в DAO), FTS5 нет.
- DAO: `data/db/Daos.kt` (`observeAll`, `allWithDeleted`, `upsertAll`, `likeSearch`...), репозитории: `data/repository/`.
- Коды объектов (`storage.code`, `location.label`, `item.code`, `stack.code`): пустой код при создании → **ULID** (26 символов, Crockford base32, `newUlid()` в `util/Ids.kt`), если включена автогенерация (`Deps.numberingAuto()`, тумблер в Настройках); ручной код проверяется на дубль. Служебные QR-действия (`domain/actions/ActionCode.kt`, формат `shkaff:v1:<verb>:<entityType>:<ULID>`) тоже получают ULID на карточку.

## Бэкап и слияние

- `sync/MergeEngine.kt` (чистый Kotlin): LWW по `updated_at`; при равном `updated_at` и разных строках — побеждает сторона по флагу `remoteWins` + запись в `conflicts`; «удалено vs живо» — новее по `deleted_at`/`updated_at`.
- `sync/Backup.kt`: формат `"shkaff-backup"` v1 — `.json` это один JSON; `.zip` = `backup.json` + фото в каталоге `photos/` внутри архива (`exportToFile(..., photosDir)` / `importFromFile(..., photosDir)`; фото берутся по именам из `photo_path`, `barcode_photo_path`, `logo_path` и элементов `{"path": …}` в `label_docs.doc_json`). Старые версии приложения читают такой zip как раньше (только `backup.json`).
- `Backup.applyMerge` — `upsertAll` всех таблиц в одной транзакции.

## Федерация (пир-синхронизация по LAN, US-G2)

- `sync/PeerTrust.kt` — флаги доверия пир-базы: роль (US-G1) + область `all|some` по хранилищам (JSON в `peer_db.trust`).
- `sync/PeerScope.kt` (чистый Kotlin) — обрезает `MergeInput` до доверенных хранилищ и их поддерева; вещь без ящика видна всегда; стеки/корзины/выдачи срезаются по вложенным объектам.
- `sync/PeerServer.kt` — TCP-сервер (побайтовое чтение строк + байтовые кадры): `HELLO`/`PULL`/`PUSH`/`BYE`; PUSH принимают только роли с правом добавления; незнакомое устройство само становится пирам с доверием по умолчанию (`admin/all`).
- `sync/PeerClient.kt` — клиент: `hello`/`pull`/`push`, каждое действие — отдельное соединение.
- `sync/PeerSync.kt` — оркестрация: HELLO → PULL → merge (локальная выигрывает) → sanitize → apply или `MergeSession` (конфликты) → PUSH обратно.
- UI: `features/federation/FederationScreen.kt` (маршрут `"federation"`, пункт в Настройках). Тесты: `PeerTrustTest`, `PeerScopeTest` (org.json в юнит-тестах — только под `RobolectricTestRunner`).

## Печать, сканер и локальный LLM

- Печать этикеток: `data/printer/` — `PrintManager` + транспорты `BtSppTransport`/`BleSppTransport`/`UsbTransport`/`TcpTransport`/`ShareTransport`, растеризация в `BitmapRaster`. Профили принтеров — таблица `printer_profile`, экран `features/printers/` (роут `printers`).
- LLM: `llama/` (модуль `:llama`, `LlamaBridge` — единственный владелец нативных библиотек), `domain/agent/` (`Agent`, `AgentLoop`, `Tools`, `DeviceLlm`, `LlmRuntime`, `LlmDiscovery`, `VolumeEstimate`, `AttributeEstimate`), загрузка моделей — `data/llm/ModelStore.kt` + `ModelDownloadService.kt` (роут `llm-models`), экраны — `features/agent/` (роуты `agent`, `agent-volumes`, `agent-attributes`).
- `domain/agent/LlmRuntime.kt` подбирает `n_ctx` по свободной памяти (лестница 4096/2048/1024, чистая функция `planNCtx` + тест `LlmMemoryPlanTest`): при нехватке RAM llama.cpp зовёт `GGML_ABORT` и процесс падает без ошибки в UI, поэтому загрузка с `ERR_NO_RAM` отказывает явно.
- `llama/src/main/cpp/CMakeLists.txt` до `add_subdirectory` ставит `-Wl,-z,max-page-size=16384` (требование Google Play 16 KiБ для targetSdk ≥ 35) и `add_compile_options(-g0)` — иначе `libllama-common.so` тянет ~70 МиБ `.debug_*`, релизный APK 153 МиБ вместо 26 МиБ.
- В `release` оставлен только ABI `arm64-v8a` (в `debug` — плюс `x86_64` для эмулятора).

## Что уже есть / чего нет (не додумывать)

- Есть: CRUD storage/location/item, атрибуты, поиск, дашборд, экспорт в xlsx/csv (`export/` — минимальный OOXML-райтер без зависимостей + CSV с BOM; `features/export/` — SAF-сохранение и «Поделиться»), этикетки + LabelStudio (`features/labels/LabelGenerator.kt`, `features/labelstudio/`, таблица `label_docs`, роуты `labels/…`, `templates`), сканер (`features/scan/ScannerScreen.kt`, CameraX + ZXing-декод по кадрам), редактор разметки (`features/annotations/AnnotationScreen.kt`), печать по BT/USB/TCP, стэки/корзины/выдачи (`stack`, `basket`, `loan`), фрагменты и оценка объёмов/атрибутов через LLM, удаление фона — эвристика по цвету рамки (`util/ImageOps.removeBackground`), **не ML**, пир-синхронизация по LAN с флагами доверия (US-G2, см. раздел «Федерация»). Все экраны зарегистрированы в `NavHost` в `MainActivity.kt` (роуты `scan`, `annotations/{storageId}`, `labels/{type}/{id}/{templateId}`, `templates`, `printers`, `agent`, `llm-models`, `fragment` и др.).
- `util/ScanBus.kt` — заглушка (одно поле `lastCode`), HID-перехват сканеров не реализован.
- Нет: облачная синхронизация, FTS5, TFLite/u2net, ML Kit — только план в `PLAN.md`.
- Роуты `scan`, `annotations/{storageId}`, `labels/{itemId}/{templateId}`, `labels/{type}/{id}/{templateId}`, `templates`, `batch?from={from}` **зарегистрированы в `NavHost` в `MainActivity.kt`** (коммит 2404f4f3); сканер, разметка и этикетки достижимы.
- `util/ScanBus.kt` — заглушка (одно поле `lastCode`), HID-перехват сканеров не реализован.
- Нет: печать (ESC/POS), TFLite/u2net, ML Kit, облачная синхронизация — только план в `PLAN.md`.

## Фоновые агенты (очередь TODO)

Ночная регрессия, аудит и глубокий анализ (cron) боевой код и git НЕ трогают: не редактируют `app/`/`llama/`, не коммитят, не делают `adb install` (смартфон — прод пользователя). Пишут только в `TODO_AGENT.md` в корне репо (вне git; разделы «ДЕФЕКТЫ / РЕКОМЕНДАЦИИ / ИДЕИ / ОТКЛОНЕНО», записи `### T-NNN [S|M|L]`, статусы `NEW`/`ПОДТВЕРЖДЁН`/`ОТРКЛОНЁН`/`⚑ реализовано (хеш)`) и в `.tmp/` (протоколы, логи, временные репро-тесты — за собой удалять). Реализация T-xxx — только через интерактивную сессию обычным комитом (с `adb install` в конце).

## Правила кода

- Kotlin 100%, Coroutines/Flow; без LiveData, RxJava, Views/XML-layouts, AsyncTask.
- ID — только UUID; у каждой записи `updated_at` обязан обновляться при изменении (от него зависит слияние).
- Цвета/типографика — только `MaterialTheme`; минимальный тач-таргет 48dp; заголовки в списках — `maxLines = 1` + ellipsis.
- Комментировать только сложную бизнес-логику (слияние, координаты аннотаций, dpi/мм в этикетках).

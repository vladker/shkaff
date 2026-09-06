# AGENTS.md — «Шкаф» (shkaff)

Офлайн-приложение инвентаризации вещей на Android: вещи, ящики (locations), шкафы (storages), этикетки, сканер, разметка фото, бэкап/слияние. Один Gradle-модуль `:app`, пакет `ru.vldkr.shkaff`.

`PLAN.md` — ТЗ и дорожная карта (M1–M13; M8–M13 — пользовательские истории US-A…US-H). Где `PLAN.md` и код расходятся — **код старший** (напр., FTS5, TFLite u2net, ML Kit в плане есть, в коде их нет).

## Команды (Windows)

- Сборка: `.\gradlew.bat :app:assembleDebug`
- Юнит-тесты: `.\gradlew.bat :app:testDebugUnitTest`
- Зависимости для тестов (JUnit4, Robolectric, coroutines-test) объявлены, но **тестовых файлов пока нет** — `app/src/test/` пуст. `sync/MergeEngine.kt` и `sync/Backup.kt` — чистый Kotlin, их можно тестировать без эмулятора.
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

- Сущности: `data/db/Entities.kt` — `storage`, `location`, `item`, `annotation`, `label_template`, `attribute_def`, `printer_profile`, `conflict_log`, `schema_meta`.
- У всех: `id: String` (UUID через `util/newId()`), `created_at`/`updated_at` (эпоха, мс), **мягкое удаление** `deleted_at: Long?`, `device_last_modified` (UUID устройства).
- Иерархия: `storage` (само-вложенность) → `location` (`storage_id` + само-вложенность) → `item` (`location_id`). `annotation` привязана к `storage` и указывает на `location`.
- Атрибуты: JSON-строка `Map<String,String>` через `AttrJson`; словарь типов в `attribute_def` (сиется в `Deps.seedDefaultAttributes()`, только если таблица пуста).
- `annotation.points` — **нормализованные координаты 0..1** (JSON). Пиксели сохранять нельзя.
- Поиск — `LIKE` (`likeSearch` в DAO), FTS5 нет.
- DAO: `data/db/Daos.kt` (`observeAll`, `allWithDeleted`, `upsertAll`, `likeSearch`...), репозитории: `data/repository/`.

## Бэкап и слияние

- `sync/MergeEngine.kt` (чистый Kotlin): LWW по `updated_at`; при равном `updated_at` и разных строках — побеждает сторона по флагу `remoteWins` + запись в `conflicts`; «удалено vs живо» — новее по `deleted_at`/`updated_at`.
- `sync/Backup.kt`: формат `"shkaff-backup"` v1 — **один JSON** (в zip лежит единственный файл `backup.json`). **Фото в бэкап не попадают** (PLAN.md говорит об обратном — не опираться).
- `Backup.applyMerge` — `upsertAll` всех таблиц в одной транзакции.

## Что уже есть / чего нет (не додумывать)

- Есть: CRUD storage/location/item, атрибуты, поиск, дашборд, этикетки (`features/labels/LabelGenerator.kt`, ZXing, dpi по умолчанию 150), сканер (`features/scan/ScannerScreen.kt`, CameraX + ZXing-декод по кадрам), редактор разметки (`features/annotations/AnnotationScreen.kt`), удаление фона — эвристика по цвету рамки (`util/ImageOps.removeBackground`), **не ML**.
- ⚠️ **Мёртвые роуты:** `ScannerScreen`/`AnnotationScreen` навигают на `"labels/0/0"`, `LabelsScreen` — на `"templates"`, но роуты `labels/…`, `templates`, `scan`, `annotations/…` **не зарегистрированы в `NavHost` в `MainActivity.kt`**. Навигация на них упадёт; экраны сканера и разметки сейчас недостижимы. При подключении — добавить `composable(...)` в `MainActivity.kt`.
- `util/ScanBus.kt` — заглушка (одно поле `lastCode`), HID-перехват сканеров не реализован.
- Нет: печать (ESC/POS), TFLite/u2net, ML Kit, облачная синхронизация — только план в `PLAN.md`.

## Правила кода

- Kotlin 100%, Coroutines/Flow; без LiveData, RxJava, Views/XML-layouts, AsyncTask.
- ID — только UUID; у каждой записи `updated_at` обязан обновляться при изменении (от него зависит слияние).
- Цвета/типографика — только `MaterialTheme`; минимальный тач-таргет 48dp; заголовки в списках — `maxLines = 1` + ellipsis.
- Комментировать только сложную бизнес-логику (слияние, координаты аннотаций, dpi/мм в этикетках).

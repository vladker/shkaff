---
description: Очередная карточка kanban-борда .pi/kanban от начала до done (TDD → тесты → сборка → коммит)
---

Ты — исполнитель одной карточки борда `.pi/kanban` (режим grind, см. AGENTS.md и `.pi/skills/kanban-grind/SKILL.md`).

# Правила борда

Инструменты борда (если доступны): `kanban_list`, `kanban_take`, `kanban_move`, `kanban_comment` (плагин `.opencode/plugins/kanban`). Если их нет — правь карточки `…/tasks/T-XXXX.md` вручную строго по формату: `status`, `updated` (UTC ISO), `rev`+1, запись в `history:` (`at`/`action`/`by`/`from`/`to`/`reason`), комментарий блоком `<!-- kanban:comment at=… by=… -->`. Переходы только по `workflow.yaml` (`new → doing → waiting_device/done`). `by` — `opencode-main`.

# Ход работы (одна карточка за запуск; аргумент — id карточки, иначе выбери сам)

1. `kanban_list { status: "doing" }` — есть активная с `assignee: opencode-main`? Продолжай её. Иначе возьми новую: приоритет `[S]`, затем `[M]`, затем `[L]`; карточки-эпики и подшаги Hermes (`Подшаг …`) не брать — подшаги закрывать «покрыто T-XXXX» вместе с родителем. Захват: `kanban_take { id, agent: "opencode-main" }`.
2. Прочитай тело карточки (доказательство/исправление/критерий готовности) и, если есть id очереди `T-NNN` — запись в `TODO_AGENT.md`. Проверь `git status --short --ignore-submodules=all`: в дереве не должно чужих изменений этих файлов; чужое незакоммиченное — не трогать, карточку вернуть в `new` с комментарием.
3. Реализация: Kotlin/Compose по правилам AGENTS.md (Deps без DI, org.json, MaterialTheme/Ozon, строки по-русски). TDD: сначала RED-тест на чистую логику (тесты: `app/src/test`, JUnit4+Robolectric;org.json только под `RobolectricTestRunner`), затем GREEN.
4. Гейты: `.\gradlew.bat :app:testDebugUnitTest` затем `.\gradlew.bat :app:assembleDebug`. Известный флейк — записи T-079/T-078 в `TODO_AGENT.md`: падения из этих записей (те же классы/сообщения, что зафиксированы) не считают прогон красным; всё остальное — красным. 2 попытки на карточку, затем возврат в `new` с комментарием «провалено N попыток: <причина>».
5. Коммит: `git add <файлы>` (без `--ignore-submodules`) и `git commit -F <файл сообщения>`; заголовок `<эмодзи> <тип>: <описание>` (✨ feat / 🔧 fix / 🧹 chore / 📝 docs), тело — что и почему + строка «adb install отложен: SM-S928B не подключён (T-0058)», если `adb devices` пуст.
6. Закрытие: `kanban_move { id, to: "done", reason: "Реализовано <хеш>: …" }` + `kanban_comment` с хешем; в `TODO_AGENT.md` — `- Статус: ⚑ реализовано (<хеш>): <1 строка>`; план-пункты `PLAN_ONBOARDING.md` — `[x] (дата, хеш)` только доказанное.
7. Установка: `adb devices` пуст → маркер `.tmp-installNN.done` (NN = max существующего + 1) с текстом `NO_DEVICE <дата> — ждут установки: <список хешей>`. Есть устройство → `adb install -r app/build/outputs/apk/debug/app-debug.apk` и маркер `SUCCESS <дата>`.

Никогда: пуш, изменение подмодуля `third_party/llama.cpp`, правка чужих незакоммиченных файлов, больше одной карточки за прогон.

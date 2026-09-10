package ru.vldkr.shkaff.domain.access

// Права профилей (US-G1). Чистый Kotlin — матрица без Android.
// Пресеты из плана: admin — полный доступ; add — только добавление в хранилища;
// move — только перекладка внутри хранилищ; view — только просмотр.
enum class Role(val preset: String) {
    ADMIN("admin"),
    ADD("add"),
    MOVE("move"),
    VIEW("view");

    companion object {
        fun parse(s: String): Role = entries.firstOrNull { it.preset == s } ?: VIEW
    }
}

object Access {
    const val CREATE = "create" // создание storage/location/item
    const val EDIT = "edit"     // изменение/удаление существующего
    const val MOVE = "move"     // перекладка объекта между ящиками
    const val LEND = "lend"     // временная выдача и возврат
    const val ADMIN = "admin"   // профили, настройки
    const val EXPORT = "export" // экспорт/бэкап/печать
    const val VIEW = "view"

    // Правда — если профиль может делать действие (или это «чтение»).
    fun can(role: Role, action: String): Boolean = when (role) {
        Role.ADMIN -> true
        Role.ADD -> action == CREATE || action == VIEW
        Role.MOVE -> action == MOVE || action == VIEW
        Role.VIEW -> action == VIEW
    }

    // Человекочитаемое имя пресета.
    fun label(role: Role): String = when (role) {
        Role.ADMIN -> "Полный доступ"
        Role.ADD -> "Только добавление"
        Role.MOVE -> "Перекладка внутри хранилищ"
        Role.VIEW -> "Только просмотр"
    }
}
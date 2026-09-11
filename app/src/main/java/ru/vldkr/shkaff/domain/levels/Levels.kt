package ru.vldkr.shkaff.domain.levels

// Уровни иерархии хранилищ (US-C1). Чистый Kotlin — без Android.
// Базовая цепочка; список расширяем: приложение не ограничивает пользователя,
// свободное значение сохраняется как есть (уровни растут вертикально и горизонтально).
object Levels {

    // «объект» из плана — это вещь, а не контейнер: последний контейнер цепочки — пакет.
    val chain = listOf("Город", "Склад", "Комната", "Шкаф", "Полка", "Коробка", "Пакет")

    // Порядок внутри цепочки; -1 для неизвестных/своих уровней.
    fun rank(level: String): Int = chain.indexOf(level.trim())

    // Отображаемая метка уровня: значение из цепочки или «уровень» для своих.
    fun label(level: String): String = level.trim().ifBlank { "—" }

    // Хлебные крошки: путь от корня к узлу (защита от циклов).
    // Возвращает список имён от самого верхнего предка к текущему узлу включительно.
    fun <T> chainToRoot(
        startId: String?,
        byId: Map<String, T>,
        nameOf: (T) -> String,
        parentOf: (T) -> String?
    ): List<String> {
        if (startId == null || startId !in byId) return emptyList()
        val parts = mutableListOf<String>()
        val seen = mutableSetOf<String>()
        var cur = startId
        while (cur != null && cur in byId && seen.add(cur)) {
            val node = byId.getValue(cur)
            parts.add(0, nameOf(node))
            cur = parentOf(node)
        }
        return parts
    }
}
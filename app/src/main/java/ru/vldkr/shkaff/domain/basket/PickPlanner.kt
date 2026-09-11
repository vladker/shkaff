package ru.vldkr.shkaff.domain.basket

// Способы упорядочивания шагов извлечения (US-E1). Набор расширяем —
// «по близости к пользователю» закладывается тут же, если появится источник координат.
enum class BasketSort { ADDITION_ORDER, BY_LOCATION_COUNT, SMALL_FIRST, SHALLOW_DEPTH }

// Одна вещь корзины в терминах планировщика.
data class PickTask(
    val key: String, // basket_item.id — ключ для чекбокса «взято»
    val itemId: String,
    val itemName: String,
    val locationId: String?,
    // Путь от корня к месту: [Склад, Комната, Полка]; пуст, если места нет.
    val locationPath: List<String>,
    // Габариты для сортировки «мелкие сначала», л.
    val sizeLiters: Double = 0.0,
    val addedAt: Long = 0L
)

// Шаг извлечения: все вещи корзины из одной локации достаются за один заход.
data class PickStep(
    val locationId: String?,
    val path: List<String>,
    val tasks: List<PickTask>
) {
    val depth: Int get() = path.size
    val label: String get() = if (path.isEmpty()) "Без места" else path.joinToString(" → ")
}

object PickPlanner {
    // Группировка по локации + сортировка шагов и вещей внутри шага.
    fun plan(tasks: List<PickTask>, sort: BasketSort): List<PickStep> {
        if (tasks.isEmpty()) return emptyList()
        val steps = tasks.groupBy { it.locationId }.map { (locId, group) ->
            val items = when (sort) {
                BasketSort.SMALL_FIRST -> group.sortedWith(
                    compareBy<PickTask> { it.sizeLiters }.thenBy { it.itemName.lowercase() }
                )
                else -> group.sortedBy { it.addedAt }
            }
            PickStep(locationId = locId, path = group.first().locationPath, tasks = items)
        }
        return when (sort) {
            BasketSort.BY_LOCATION_COUNT -> steps.sortedWith(
                compareByDescending<PickStep> { it.tasks.size }.thenBy { it.path.joinToString("|") }
            )
            BasketSort.SHALLOW_DEPTH -> steps.sortedWith(
                compareBy<PickStep> { it.depth }.thenByDescending { it.tasks.size }.thenBy { it.path.joinToString("|") }
            )
            BasketSort.SMALL_FIRST, BasketSort.ADDITION_ORDER -> steps.sortedWith(
                compareBy<PickStep> { it.tasks.minOf { t -> t.addedAt } }.thenBy { it.path.joinToString("|") }
            )
        }
    }
}
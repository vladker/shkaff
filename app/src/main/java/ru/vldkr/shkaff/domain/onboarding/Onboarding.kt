package ru.vldkr.shkaff.domain.onboarding

// Чек-лист первого запуска (PLAN_ONBOARDING, П0.1). Чистый Kotlin.
// Шаги гасятся по реальным объектам БД — как чек-лист открытия ПВЗ: отметка привязана
// к сделанному, а не к нажатию «галочки». Маршруты — реальные роуты NavHost.
data class OnbStep(
    val id: String,
    val title: String,
    val hint: String,
    val route: String,
    val done: Boolean
)

object Onboarding {

    fun steps(storageCount: Int, locationCount: Int, itemCount: Int): List<OnbStep> = listOf(
        OnbStep(
            "storage", "Заведите шкаф",
            "Шкаф — место хранения: «Прихожая», «Гараж», «Балкон». Внутри будут ящики.",
            "storage-form/0", storageCount > 0
        ),
        OnbStep(
            "location", "Заведите ящик",
            "Ящик — то, где именно лежит вещь: полка, ящик комода, коробка на антресоли.",
            "storages", locationCount > 0
        ),
        OnbStep(
            "item", "Положите первую вещь",
            "Достаточно названия и фото — Шкаф сам подскажет подходящий ящик.",
            "item-wizard", itemCount > 0
        )
    )

    // Карточка живёт, пока есть незавершённые шаги и пользователь её не скрыл.
    fun showChecklist(steps: List<OnbStep>, dismissed: Boolean): Boolean =
        !dismissed && steps.any { !it.done }

    fun progress(steps: List<OnbStep>): String = "${steps.count { it.done }}/${steps.size}"
}

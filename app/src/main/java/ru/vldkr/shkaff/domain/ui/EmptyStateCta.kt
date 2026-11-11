package ru.vldkr.shkaff.domain.ui

/**
 * П1.4: пустое состояние обязано содержать ровно один явный CTA «что сделать».
 * Подпись CTA и право его показать (роли) решаются здесь — чистые функции,
 * экраны привязывают возвращённую подпись к конкретному действию.
 * null — CTA не показывается: у текущего профиля это действие не предусмотрено.
 */
object EmptyStateCta {

    /** Любой «Ничего не найдено» (Вещи/Хранилища/Продукты/Поиск): верни полный список. */
    const val RESET_SEARCH = "Сбросить поиск"

    /** Шаблоны этикеток создаются кнопкой «+» без ролевого гейта. */
    const val NEW_TEMPLATE = "Создать шаблон"

    /**
     * «Вещи» без запроса: активный фильтр тега прячет существующие вещи —
     * первым делом снимай фильтр, иначе (с правом CREATE) добавляй вещь.
     */
    fun itemsEmpty(filterActive: Boolean, canAdd: Boolean): String? = when {
        filterActive -> "Показать все вещи"
        canAdd -> "Добавить вещь"
        else -> null
    }

    /** Журнал пишется сам: под фильтром — снимай фильтр, без него — первое действие это вещь. */
    fun journalEmpty(filterActive: Boolean): String =
        if (filterActive) "Показать все записи" else "Добавить первую вещь"

    /** Корзинa: список «на вынос» начинается с самой корзины (нужен CREATE). */
    fun basketEmpty(canCreate: Boolean): String? = if (canCreate) "Создать корзину" else null

    /** Выдачу оформляет карточка вещи — читателю без LEND действовать здесь нечем. */
    fun loansEmpty(canManage: Boolean): String? = if (canManage) "Найти вещь для выдачи" else null

    /** «Члены семьи»: профили создаёт только админ. */
    fun profilesEmpty(isAdmin: Boolean): String? = if (isAdmin) "Создать профиль" else null
}

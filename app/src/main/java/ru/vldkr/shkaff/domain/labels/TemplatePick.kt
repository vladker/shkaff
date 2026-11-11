package ru.vldkr.shkaff.domain.labels

import ru.vldkr.shkaff.data.db.LabelTemplateEntity

// T-050: раньше запрашиваемый шаблон (templateId из роута или текущий выбор),
// отсутствующий в живом списке observeAll, молча подменялся list.firstOrNull() —
// этикетка уезжала на печать другим макетом. Разрешение выбора вынесено в чистую
// функцию: не найден → Missing, экран обязан спросить пользователя, а не гадать.

/** Результат разрешения запрошенного шаблона этикетки. */
sealed class TemplatePick {

    /** Запрошенный шаблон найден в живом списке. */
    data class Found(val template: LabelTemplateEntity) : TemplatePick() {
        override val resolved: LabelTemplateEntity? get() = template
    }

    /** Выбора не было — берём первый живой как начальный вариант (не дефект). */
    data class Defaulted(val template: LabelTemplateEntity) : TemplatePick() {
        override val resolved: LabelTemplateEntity? get() = template
    }

    /** Запрошенный шаблон исчез из живого списка (удалён) — нужен другой выбор. */
    object Missing : TemplatePick() {
        override val resolved: LabelTemplateEntity? get() = null
    }

    /** Живых шаблонов нет вообще и выбора не было. */
    object Empty : TemplatePick() {
        override val resolved: LabelTemplateEntity? get() = null
    }

    abstract val resolved: LabelTemplateEntity?
}

fun pickTemplate(list: List<LabelTemplateEntity>, wantedId: String?): TemplatePick {
    val id = wantedId?.takeIf { it.isNotBlank() }
    if (id != null) {
        return list.firstOrNull { it.id == id }
            ?.let { TemplatePick.Found(it) }
            ?: TemplatePick.Missing // не молча подменять первым — спросить пользователя
    }
    return list.firstOrNull()?.let { TemplatePick.Defaulted(it) } ?: TemplatePick.Empty
}

/** Баннер для обоих экранов (этикетка и серия): шаблон пропал, нужен новый выбор. */
const val TEMPLATE_DELETED_MSG = "Шаблон удалён, выберите другой"

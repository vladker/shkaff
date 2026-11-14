package ru.vldkr.shkaff.domain.labels

// T-048: цвета шаблона хранились как есть и битый значение («red», «#GG»)
// при печати молча становилось чёрным. Формат цвета — канон для формы
// шаблона: решётка + 6 hex-цифр (#RRGGBB); 8-значный #AARRGGBB тоже
// допустим — его понимает android.graphics.Color.parseColor.
object ColorHex {
    private val pattern = Regex("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$")

    fun isHexColor(s: String): Boolean = pattern.matches(s)
}

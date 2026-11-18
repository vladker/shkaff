package ru.vldkr.shkaff.util

// Русская плюрализация: «1 вещь», «2 вещи», «5 вещей».
fun pluralRu(
    n: Int,
    one: String,
    few: String,
    many: String,
): String = "$n ${pluralWordRu(n, one, few, many)}"

// Только форма слова без числа — когда число уже показано отдельно.
fun pluralWordRu(
    n: Int,
    one: String,
    few: String,
    many: String,
): String {
    val d10 = n % 10
    val d100 = n % 100
    return when {
        d10 == 1 && d100 != 11 -> one
        d10 in 2..4 && d100 !in 11..14 -> few
        else -> many
    }
}

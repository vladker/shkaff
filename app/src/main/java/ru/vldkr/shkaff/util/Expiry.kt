package ru.vldkr.shkaff.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object Expiry {

    enum class Status { EXPIRED, SOON, OK }

    private val PARSERS = listOf(
        DateTimeFormatter.ofPattern("dd.MM.yyyy"),
        DateTimeFormatter.ofPattern("d.M.yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("d/M/yyyy")
    )

    fun parse(value: String?): LocalDate? {
        val v = value?.trim().orEmpty()
        if (v.isEmpty()) return null
        for (p in PARSERS) {
            try {
                return LocalDate.parse(v, p)
            } catch (_: DateTimeParseException) {
            }
        }
        return null
    }

    fun normalize(value: String?): String? = parse(value)?.toString()

    fun daysUntil(date: LocalDate, today: LocalDate): Int =
        java.time.temporal.ChronoUnit.DAYS.between(today, date).toInt()

    fun status(date: LocalDate?, today: LocalDate, thresholdDays: Int): Status? {
        if (date == null) return null
        val d = daysUntil(date, today)
        return when {
            d < 0 -> Status.EXPIRED
            d <= thresholdDays -> Status.SOON
            else -> Status.OK
        }
    }

    fun isDue(date: LocalDate?, today: LocalDate, thresholdDays: Int): Boolean {
        val d = date?.let { daysUntil(it, today) } ?: return false
        // просроченные тоже показываем — их важно не пропустить
        return d <= thresholdDays
    }

    fun isDueForSort(days: Int, thresholdDays: Int): Boolean = days <= thresholdDays

    fun label(date: LocalDate?, today: LocalDate): String? {
        val d = date ?: return null
        val base = d.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        val days = daysUntil(d, today)
        return when {
            days < -1 -> "$base — истекло ${-days} дн. назад"
            days == -1 -> "$base — истекло вчера"
            days == 0 -> "$base — истекает сегодня"
            days == 1 -> "$base — завтра"
            else -> "$base — через $days дн."
        }
    }
}

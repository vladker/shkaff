package ru.vldkr.shkaff.util

import java.text.DateFormat
import java.util.Date

// Короткая локальная дата для журнала, выдач и подсказок.
fun formatDate(epoch: Long): String =
    DateFormat.getDateInstance(DateFormat.MEDIUM).format(Date(epoch))
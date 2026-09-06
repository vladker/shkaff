package ru.vldkr.shkaff.util

import java.util.UUID

fun newId(): String = UUID.randomUUID().toString()

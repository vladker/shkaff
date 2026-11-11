package ru.vldkr.shkaff.domain.llm

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException

/**
 * GGUF весят до 10 ГБ и раньше писались на диск вслепую — посреди загрузки
 * FileOutputStream бросал английское «No space left on device». Порог и
 * русские тексты — чистые функции, тестируются без Android.
 */
class StorageFitTest {
    private val mib = 1024L * 1024L
    private val gib = 1024L * mib

    @Test
    fun requiredSumsBothFilesMinusAlreadyDownloadedParts() {
        assertEquals(1000L, StorageFit.requiredBytes(1000L, 0L, null, 0L))
        assertEquals(700L, StorageFit.requiredBytes(1000L, 300L, null, 0L))
        assertEquals(800L, StorageFit.requiredBytes(1000L, 300L, 500L, 400L))
    }

    @Test
    fun oversizedPartsDoNotMakeRequiredNegative() {
        assertEquals(0L, StorageFit.requiredBytes(100L, 900L, 50L, 900L))
    }

    @Test
    fun fitsWhenFreeSpaceCoversFilePlusReserve() {
        // 1 ГиБ модели + резерв (десятая часть, не меньше 128 МиБ) влезает в 2 ГиБ.
        assertTrue(StorageFit.fits(1 * gib, 2 * gib))
        // Ровно «сам файл» без запаса — уже нет: система упирается в ноль байт.
        assertFalse(StorageFit.fits(1 * gib, 1 * gib))
        assertFalse(StorageFit.fits(1 * gib, 1 * gib + StorageFit.MIN_RESERVE - 1))
        assertTrue(StorageFit.fits(1 * gib, 1 * gib + StorageFit.MIN_RESERVE))
    }

    @Test
    fun reserveScalesWithModelSizeWithinCaps() {
        assertEquals(StorageFit.MIN_RESERVE, StorageFit.reserve(600 * mib))
        assertEquals(2 * gib / 10, StorageFit.reserve(2 * gib))
        assertEquals(StorageFit.MAX_RESERVE, StorageFit.reserve(20 * gib))
    }

    @Test
    fun unknownOrFinishedSizeAlwaysFits() {
        // Своя модель по ссылке: размер неизвестен (0) — предпроверка бессмысленна,
        // спасает только маппинг ENOSPC в середине загрузки.
        assertTrue(StorageFit.fits(0L, 0L))
        assertTrue(StorageFit.fits(-5L, 0L))
    }

    @Test
    fun notEnoughSpaceTextIsRussianAndActionable() {
        val t = StorageFit.notEnoughSpaceText(6 * gib, 2 * gib)
        assertTrue(t, t.contains("Недостаточно свободного места"))
        assertTrue(t, t.contains("Освободите"))
        assertFalse(t, t.contains("space"))
    }

    @Test
    fun androidEnospcIOExceptionIsRecognised() {
        // Реальная формулировка Android: java.io.IOException: write failed: ENOSPC (...)
        val e = IOException("write failed: ENOSPC (No space left on device)")
        assertTrue(StorageFit.isOutOfSpace(e))
        assertTrue(StorageFit.isOutOfSpace(IOException("No space left on device")))
    }

    @Test
    fun enospcFoundThroughCauseChain() {
        val inner = IOException("write failed: ENOSPC (No space left on device)")
        val mid = IOException("Не удалось сохранить файл", inner)
        assertTrue(StorageFit.isOutOfSpace(RuntimeException("Пакет упал", mid)))
    }

    @Test
    fun otherErrorsKeepTheirOwnMessage() {
        assertEquals("HTTP 500", StorageFit.errorText(IOException("HTTP 500")))
        assertEquals("Ошибка загрузки", StorageFit.errorText(IOException()))
        assertFalse(StorageFit.isOutOfSpace(IOException("Unable to resolve host")))
    }

    @Test
    fun outOfSpaceMapsToRussianReassuringText() {
        val t = StorageFit.errorText(IOException("write failed: ENOSPC (No space left on device)"))
        assertTrue(t, t.contains("закончилось свободное место"))
        assertTrue(t, t.contains("Скачать"))
    }

    @Test
    fun sizesFormatInHumanReadableRussianUnits() {
        assertEquals("6.0 ГБ", StorageFit.fmt(6 * gib))
        assertEquals("128 МБ", StorageFit.fmt(128 * mib))
    }
}

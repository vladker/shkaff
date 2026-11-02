package ru.vldkr.shkaff.domain.agent

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Контекст подбирается по свободной памяти: при нехватке RAM llama.cpp зовёт
 * GGML_ABORT, то есть приложение падает вместо ошибки в UI.
 */
class LlmMemoryPlanTest {
    private val mib = 1024L * 1024L
    private val gib = 1024L * mib

    @Test
    fun roomyDeviceGetsTheBiggestContext() {
        assertEquals(4096, planNCtx(512 * mib, 8 * gib))
    }

    @Test
    fun tightDeviceStepsDownTheLadder() {
        assertEquals(2048, planNCtx(512 * mib, 1400 * mib))
    }

    @Test
    fun noRoomEvenForTheSmallestContextMeansRefuseToLoad() {
        assertEquals(0, planNCtx(512 * mib, 800 * mib))
        assertEquals(0, planNCtx(512 * mib, 0L))
    }

    @Test
    fun appReservesAQuarterOfFreeMemoryButNeverLessThan256MiB() {
        // Резерв 256 МиБ из 300 МиБ свободных → на модель и KV-кэш не остаётся ничего.
        assertEquals(0, planNCtx(0L, 300 * mib))
        // Резерв четверть из 4 ГиБ → большая модель получает минимальный контекст.
        assertEquals(1024, planNCtx(2800 * mib, 4 * gib))
    }

    @Test
    fun biggerModelNeedsMoreRoomForTheSameContext() {
        assertEquals(4096, planNCtx(1 * gib, 3 * gib))
        assertEquals(2048, planNCtx(1800 * mib, 3 * gib))
    }

    @Test
    fun minNeedGrowsWithTheModelSize() {
        val mb = 512 * mib
        val need = minNeedBytes(mb)
        assertEquals(mb + 1024 * KV_BYTES_PER_TOKEN + GGML_BUFFER_BYTES, need)
        assertEquals(need + 100 * mib, minNeedBytes(mb + 100 * mib))
    }

    @Test
    fun minNeedIsExactlyTheSmallestRungThatPasses() {
        val mb = 900 * mib
        // Свободной ровно столько, чтобы прошёл минимальный контекст (резерв — четверть).
        val avail = minNeedBytes(mb) * 4 / 3
        assertEquals(1024, planNCtx(mb, avail))
        assertEquals(0, planNCtx(mb, avail - mib))
    }

    @Test
    fun ladderIsOrderedAndStartsWithAUsableContext() {
        assertEquals(4096, CTX_LADDER.first())
        assertEquals(1024, CTX_LADDER.last())
    }
}

package ru.vldkr.shkaff.util

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ScanBusTest {

    @Before
    fun setUp() = ScanBus.reset()

    @Test
    fun `publish кладёт код в lastCode и в живую очередь, дубликаты не схлопывает`() = runTest {
        val got = mutableListOf<String>()
        val job = launch(start = CoroutineStart.UNDISPATCHED) {
            ScanBus.codes.collect { got.add(it) }
        }
        ScanBus.publish("A1X")
        ScanBus.publish("A1X")
        ScanBus.publish("B2Y")
        testScheduler.advanceUntilIdle()
        assertEquals(listOf("A1X", "A1X", "B2Y"), got)
        assertEquals("B2Y", ScanBus.lastCode)
        job.cancel()
    }

    @Test
    fun `код без подписчика не теряется — ждёт в lastCode`() = runTest {
        ScanBus.publish("X9Z")
        val got = mutableListOf<String>()
        val job = launch(start = CoroutineStart.UNDISPATCHED) {
            ScanBus.codes.collect { got.add(it) }
        }
        assertEquals(emptyList<String>(), got) // реплея нет
        assertEquals("X9Z", ScanBus.lastCode)
        job.cancel()
    }
}

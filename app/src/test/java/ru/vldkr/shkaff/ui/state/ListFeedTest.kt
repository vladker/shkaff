package ru.vldkr.shkaff.ui.state

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

// T-040: подписка списка обязана различать «ещё грузится», «данные есть» и «поток упал».
// Без этого экран крутит вечный skeleton (Items) или враньё «Ничего не найдено» / «пока нет»
// до первой эмиссии БД (Search/Products/Storages).
@OptIn(ExperimentalCoroutinesApi::class)
class ListFeedTest {

    @Test
    fun `before first emission state is Loading`() = runTest(UnconfinedTestDispatcher()) {
        val feed = ListFeed<String>(backgroundScope) { flow { awaitCancellation() } }
        feed.start()
        advanceUntilIdle()
        assertEquals(UiState.Loading, feed.state.value)
    }

    @Test
    fun `data becomes Success and the gate turns loading off`() = runTest(UnconfinedTestDispatcher()) {
        val feed = ListFeed(backgroundScope) { flowOf("a", "b") }
        feed.start()
        advanceUntilIdle()
        assertEquals(UiState.Success("b"), feed.state.value)
        assertEquals(null, feed.gate.value)
    }

    @Test
    fun `upstream failure becomes Error instead of eternal Loading`() = runTest(UnconfinedTestDispatcher()) {
        val feed = ListFeed<String>(backgroundScope) { flow { emit("a"); throw IllegalStateException("no such table: item") } }
        feed.start()
        advanceUntilIdle()
        val st = feed.state.value
        assertTrue("ожидался UiState.Error, получено $st", st is UiState.Error)
        val msg = (st as UiState.Error).message
        assertTrue("текст ошибки пустой: $msg", msg.isNotBlank())
        assertTrue("текст ошибки должен объяснять сбой: $msg", msg.contains("no such table: item"))
        // после сбоя экран не обязан крутить скелетон вечно
        assertTrue("после сбоя гейт не Loading", feed.gate.value !is UiState.Loading)
    }

    @Test
    fun `retry re-subscribes to the source and recovers`() = runTest(UnconfinedTestDispatcher()) {
        var calls = 0
        val feed = ListFeed<String>(backgroundScope) {
            calls += 1
            if (calls == 1) flow { throw IllegalStateException("boom") } else flowOf("ok")
        }
        feed.start()
        advanceUntilIdle()
        assertTrue("после сбоя ожидался Error, получено ${feed.state.value}", feed.state.value is UiState.Error)
        feed.retry()
        advanceUntilIdle()
        assertEquals(UiState.Success("ok"), feed.state.value)
        assertEquals("retry обязан переподписаться к источнику", 2, calls)
    }

    @Test
    fun `scope cancellation is not reported as a data error`() {
        val s = TestScope(UnconfinedTestDispatcher())
        val feed = ListFeed(s) { flow { emit("a"); awaitCancellation() } }
        feed.start()
        s.advanceUntilIdle()
        assertEquals(UiState.Success("a"), feed.state.value)
        s.coroutineContext[Job]?.cancel()
        s.advanceUntilIdle()
        assertTrue("отмена области не должна оставлять Error", feed.state.value !is UiState.Error)
    }

    @Test
    fun `merge gate - error wins over loading and data`() {
        assertEquals(UiState.Error("базы нет"), mergeGate(UiState.Loading, UiState.Error("базы нет")))
        assertEquals(UiState.Error("базы нет"), mergeGate(UiState.Error("базы нет"), UiState.Loading))
    }

    @Test
    fun `merge gate - loading while any feed still loads`() {
        assertEquals(UiState.Loading, mergeGate(null, UiState.Loading))
        assertEquals(UiState.Loading, mergeGate(UiState.Loading, null))
    }

    @Test
    fun `merge gate - null when every feed has data`() {
        assertEquals(null, mergeGate(null, null))
    }

    @Test
    fun `merge feeds surfaces the failure of any subscription`() = runTest(UnconfinedTestDispatcher()) {
        val a = ListFeed(backgroundScope) { flowOf(1) }
        val b = ListFeed<Int>(backgroundScope) { flow { throw IllegalStateException("disk full") } }
        a.start(); b.start()
        advanceUntilIdle()
        val gate = mergeFeeds(listOf(a, b)).first()
        assertTrue("ожидался Error от упавшей подписки, получено $gate", gate is UiState.Error)
    }

    @Test
    fun `merge feeds keeps loading while any subscription still loads`() = runTest(UnconfinedTestDispatcher()) {
        val a = ListFeed(backgroundScope) { flowOf(1) }
        val b = ListFeed<Int>(backgroundScope) { flow { awaitCancellation() } }
        a.start(); b.start()
        advanceUntilIdle()
        assertEquals(UiState.Loading, mergeFeeds(listOf(a, b)).first())
    }
}

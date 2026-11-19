package ru.vldkr.shkaff.domain.agent

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference

// T-025: «Стоп» должен обрывать не только llama.cpp, но и живой HTTP-запрос
// к облаку/локальному серверу (иначе ответ ждётся до readTimeout = 90 с).
// Соединение создаётся через шов connectionFactory: заглушка блокирует
// responseCode до disconnect() — как настоящий сокет, но детерминированно
// (реальный сокет под Robolectric недосягаем и отравлял соседние тесты).
@RunWith(RobolectricTestRunner::class)
class ChatClientAbortTest {

    private class StubConnection(url: URL, private val started: CountDownLatch) : HttpURLConnection(url) {
        val disconnected = AtomicBoolean(false)

        override fun connect() = Unit

        override fun usingProxy(): Boolean = false

        override fun disconnect() {
            disconnected.set(true)
        }

        override fun getOutputStream(): OutputStream = ByteArrayOutputStream()

        override fun getResponseCode(): Int {
            started.countDown()
            // Подделка sun.net: читающий поток ждёт, пока соединение не оборвут, затем IOException.
            while (!disconnected.get()) Thread.sleep(10)
            throw IOException("connection closed by disconnect")
        }
    }

    @Test
    fun abortHttp_withoutLiveRequest_returnsFalse() {
        assertFalse(ChatClient.abortHttp())
    }

    @Test
    fun abortHttp_cancelsLiveRequest_insteadOfWaitingReadTimeout() {
        val original = ChatClient.connectionFactory
        val started = CountDownLatch(1)
        ChatClient.connectionFactory = { StubConnection(URL(it), started) }
        try {
            val settings =
                AgentSettings(
                    enabled = true,
                    provider = "local",
                    baseUrl = "http://127.0.0.1/v1",
                    model = "m",
                )
            val failure = AtomicReference<Throwable?>()
            val done = CountDownLatch(1)
            Thread {
                failure.set(
                    runCatching { runBlocking { ChatClient.complete(settings, listOf(ChatMessage("user", "привет"))) } }
                        .exceptionOrNull(),
                )
                done.countDown()
            }.start()

            assertTrue("запрос не дошёл до соединения", started.await(5, TimeUnit.SECONDS))
            assertTrue("abort не нашёл живого соединения", ChatClient.abortHttp())
            // «Стоп» срабатывает сразу, а не через readTimeout.
            assertTrue("запрос не прервался за 3 с", done.await(3, TimeUnit.SECONDS))
            assertTrue(
                "ожидали ошибку отмены, получили: ${failure.get()}",
                (failure.get()?.message ?: "").contains("отмен", ignoreCase = true),
            )
        } finally {
            ChatClient.connectionFactory = original
        }
    }

    @Test
    fun abortHttp_twiceWithoutRequest_isSafe() {
        ChatClient.abortHttp()
        assertFalse(ChatClient.abortHttp())
    }
}

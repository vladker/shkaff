package ru.vldkr.shkaff.domain.agent

import android.content.Context
import android.net.ConnectivityManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.di.Deps
import java.net.HttpURLConnection
import java.net.Inet4Address
import java.net.URL

/**
 * Автопоиск OpenAI-совместимого LLM-сервера (LM Studio/Ollama) в домашней Wi-Fi сети.
 *
 * Принцип: определяем подсеть телефона (IP + маска), затем параллельно опрашиваем
 * хосты `GET http://<ip>:<порт>/v1/models` — первый, кто отвечает 200 с JSON-списком
 * моделей, и есть сервер ИИ. Чистая логика (подбор кандидатов, разбор ответа) отделена
 * от сети и покрывается юнит-тестами.
 */
object LlmDiscovery {

    const val DEFAULT_PORT = 1234
    const val PARALLELISM = 16

    // Таймауты зонда короткие: большинство хостов в подсети отвечают RST мгновенно,
    // а «мёртвые» отпадают за connect-таймаут.
    private const val CONNECT_TIMEOUT_MS = 300
    private const val READ_TIMEOUT_MS = 800

    data class Found(
        val baseUrl: String,
        val models: List<String>,
    )

    // ---------- Чистая, тестируемая часть ----------

    /**
     * Кандидаты в подсети для IP с префиксом. Сеть/вещание и собственный адрес
     * исключаются. Подсеть шире /24 (корпоративные /16 и шире) сужаем до /24,
     * содержащего свой адрес: сканировать шире — долго и бессмысленно для домашней сети.
     */
    fun candidates(ip: String, prefix: Int): List<String> {
        val addr = ipToLong(ip) ?: return emptyList()
        if (prefix < 8 || prefix > 31) return emptyList()
        val effective = maxOf(prefix, 24)
        val mask = (0xFFFFFFFFL shl (32 - effective)) and 0xFFFFFFFFL
        val base = addr and mask
        val size = 1L shl (32 - effective)
        val out = mutableListOf<String>()
        for (i in 0L until size) {
            val a = base + i
            if (a == addr) continue
            if (i == 0L || i == size - 1) continue // адрес сети и вещания
            out.add(longToIp(a))
        }
        return out
    }

    fun ipToLong(ip: String): Long? {
        val parts = ip.split('.')
        if (parts.size != 4) return null
        var v = 0L
        for (p in parts) {
            val n = p.toIntOrNull() ?: return null
            if (n < 0 || n > 255) return null
            v = (v shl 8) or n.toLong()
        }
        return v
    }

    fun longToIp(v: Long): String {
        val x = v and 0xFFFFFFFFL
        return "${(x shr 24) and 0xFF}.${(x shr 16) and 0xFF}.${(x shr 8) and 0xFF}.${x and 0xFF}"
    }

    /** Порт из произвольного Base URL («http://192.168.1.11:8080/v1» → 8080); нет — значение по умолчанию. */
    fun portFromBaseUrl(url: String, default: Int = DEFAULT_PORT): Int {
        val m = Regex("://[^/:]+:(\\d+)").find(url) ?: return default
        return m.groupValues[1].toIntOrNull() ?: default
    }

    /** 127.0.0.1 в начало списка: при `adb reverse tcp:1234 tcp:1234` сервер доступен с телефона без Wi-Fi. */
    fun candidatesWithLocalhost(cands: List<String>): List<String> =
        listOf("127.0.0.1") + cands

    /** Имена моделей из ответа `GET /v1/models` (OpenAI-формат `data[].id`). */
    fun modelsFromResponse(raw: String): List<String> {
        val arr = JSONObject(raw).optJSONArray("data") ?: return emptyList()
        return (0 until arr.length()).mapNotNull {
            arr.optJSONObject(it)?.optString("id")?.trim()?.takeIf { s -> s.isNotBlank() }
        }
    }

    // ---------- Сетевая часть ----------

    /** IP и префикс (маска) активной сети устройства, напр. ("192.168.1.4", 24). */
    fun localNetwork(context: Context): Pair<String, Int>? {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val net = cm.activeNetwork ?: return null
        val lp = cm.getLinkProperties(net) ?: return null
        for (la in lp.linkAddresses) {
            val a = la.address
            if (a !is Inet4Address || a.isLoopbackAddress) continue
            val s = a.hostAddress ?: continue
            if (s.startsWith("127.") || s.startsWith("169.254.")) continue
            return s to la.prefixLength
        }
        return null
    }

    /**
     * Сканируем подсеть телефона в поисках LLM-сервера на [port].
     * @return найденный Base URL + список моделей, либо null, если сеть/сервер не найдены.
     */
    suspend fun discover(port: Int = DEFAULT_PORT): Found? {
        // Localhost — всегда; подсеть Wi-Fi — если сеть есть (работает и по USB через adb reverse)
        val net = localNetwork(Deps.app)
        val cands = candidatesWithLocalhost(
            if (net != null) candidates(net.first, net.second) else emptyList()
        )
        return coroutineScope {
            val semaphore = Semaphore(PARALLELISM)
            val jobs = cands.map { ip ->
                async(Dispatchers.IO) {
                    semaphore.withPermit { probe(ip, port) }
                }
            }
            // Важно: ждём каждый результат через await() — firstOrNull по «уже завершено»
            // роняет быстрый ответ localhost, если он ещё летит, а job потом отменяется.
            // 127.0.0.1 стоит первым, так что обычный путь (USB) завершается за ~50 мс.
            cands.zip(jobs).firstOrNull { (_, job) -> job.await().any { it.isNotBlank() } }
                ?.let { (ip, job) ->
                    Found(baseUrl = "http://$ip:$port/v1", models = job.await())
                }
        }
    }

    // Один зонд: GET /v1/models. Ломает тихо — в подсети полно хостов, которые не отвечают.
    private suspend fun probe(ip: String, port: Int): List<String> =
        withContext(Dispatchers.IO) {
            val url = "http://$ip:$port/v1/models"
            val conn = URL(url).openConnection() as HttpURLConnection
            try {
                conn.requestMethod = "GET"
                conn.connectTimeout = CONNECT_TIMEOUT_MS
                conn.readTimeout = READ_TIMEOUT_MS
                conn.setRequestProperty("Accept", "application/json")
                if (conn.responseCode !in 200..299) return@withContext emptyList()
                modelsFromResponse(conn.inputStream.bufferedReader(Charsets.UTF_8).readText())
            } catch (e: Exception) {
                emptyList()
            } finally {
                conn.disconnect()
            }
        }
}

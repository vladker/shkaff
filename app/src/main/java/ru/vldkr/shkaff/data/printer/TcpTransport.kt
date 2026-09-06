package ru.vldkr.shkaff.data.printer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket

class TcpTransport(
    private val host: String,
    private val port: Int,
    private val timeoutMs: Int = 5000
) : Transport {

    override suspend fun send(bytes: ByteArray): Result<Unit> = withContext(Dispatchers.IO) {
        runCatching {
            require(host.isNotBlank()) { "Не задан адрес принтера (IP)" }
            val p = port.coerceIn(1, 65535)
            Socket().use { s ->
                s.connect(InetSocketAddress(host.trim(), p), timeoutMs)
                s.soTimeout = timeoutMs
                s.outputStream.use { os ->
                    os.write(bytes)
                    os.flush()
                }
            }
        }
    }
}

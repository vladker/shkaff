package ru.vldkr.shkaff.domain.agent

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

// modelsFromResponse ходит в org.json → под Robolectric (конвенция проекта)
@RunWith(RobolectricTestRunner::class)
class LlmDiscoveryTest {

    @Test
    fun candidatesFor24Subnet() {
        val c = LlmDiscovery.candidates("192.168.1.4", 24)
        assertEquals(253, c.size) // 256 - сеть - вещание - сам
        assertTrue(c.contains("192.168.1.1"))
        assertFalse(c.contains("192.168.1.4"))  // свой адрес не трогаем
        assertFalse(c.contains("192.168.1.0"))  // адрес сети
        assertFalse(c.contains("192.168.1.255")) // broadcast
        assertTrue(c.all { it.startsWith("192.168.1.") })
    }

    @Test
    fun candidatesWiderThan24AreClampedTo24() {
        val c = LlmDiscovery.candidates("10.1.2.3", 16)
        assertTrue(c.all { it.startsWith("10.1.2.") })
        assertFalse(c.contains("10.1.2.3"))
        assertEquals(253, c.size) // 256 - сеть - вещание - сам
    }

    @Test
    fun candidatesForNarrowerSubnet() {
        // /25 = 128 адресов (192.168.1.128..255); минус сеть, вещание и сам = 125.
        // IP выбран внутри подсети, но не адресом сети и не вещанием — иначе «минус сам» не уменьшит счёт
        val c = LlmDiscovery.candidates("192.168.1.200", 25)
        assertEquals(125, c.size)
        assertTrue(c.all { it in "192.168.1.129".."192.168.1.254" })
        assertFalse(c.contains("192.168.1.128")) // адрес сети
        assertFalse(c.contains("192.168.1.255")) // вещание
        assertFalse(c.contains("192.168.1.200")) // сам
    }

    @Test
    fun candidatesWithLocalhost() {
        assertEquals(listOf("127.0.0.1"), LlmDiscovery.candidatesWithLocalhost(emptyList()))
        assertEquals(
            listOf("127.0.0.1", "192.168.1.11"),
            LlmDiscovery.candidatesWithLocalhost(listOf("192.168.1.11"))
        )
    }

    @Test
    fun candidatesRejectBadInput() {
        assertTrue(LlmDiscovery.candidates("192.168.1.4", 7).isEmpty())
        assertTrue(LlmDiscovery.candidates("192.168.1.4", 32).isEmpty())
        assertTrue(LlmDiscovery.candidates("не-ip", 24).isEmpty())
        assertTrue(LlmDiscovery.candidates("192.168.1.999", 24).isEmpty())
    }

    @Test
    fun ipLongRoundTrip() {
        val ip = "192.168.1.4"
        assertEquals(ip, LlmDiscovery.longToIp(LlmDiscovery.ipToLong(ip)!!))
        assertNull(LlmDiscovery.ipToLong("1.2.3"))
        assertNull(LlmDiscovery.ipToLong("256.0.0.1"))
        assertEquals("10.0.0.255", LlmDiscovery.longToIp(LlmDiscovery.ipToLong("10.0.0.255")!!))
    }

    @Test
    fun portFromBaseUrl() {
        assertEquals(1234, LlmDiscovery.portFromBaseUrl("http://192.168.1.11/v1"))
        assertEquals(8080, LlmDiscovery.portFromBaseUrl("http://192.168.1.11:8080/v1"))
        assertEquals(1234, LlmDiscovery.portFromBaseUrl("http://192.168.1.11:abc/v1"))
        assertEquals(1234, LlmDiscovery.portFromBaseUrl(""))
    }

    @Test
    fun modelsFromResponse() {
        val raw = """{"data":[{"id":"qwen/qwen3.8-27b","object":"model"},{"id":"  "},{"id":"qwen3.8-27b-uncensored"}]}"""
        assertEquals(listOf("qwen/qwen3.8-27b", "qwen3.8-27b-uncensored"), LlmDiscovery.modelsFromResponse(raw))
        assertTrue(LlmDiscovery.modelsFromResponse("""{"object":"list"}""").isEmpty())
    }
}

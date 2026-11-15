package ru.vldkr.shkaff.domain.ean

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.domain.agent.AgentSettings

/**
 * T-035: lookupByQuery обязан пробрасывать SearchException с понятной причиной
 * вместо тихого null (см. комментарий к SearchException в EanHeadlessBrowser).
 */
@RunWith(RobolectricTestRunner::class)
class EanSearchErrorPropagationTest {

    @Test
    fun пустой_запрос_бросает_SearchException_вместо_тихого_null() {
        val provider = EanHeadlessBrowser(settings = { AgentSettings() })
        val error = assertThrows(EanHeadlessBrowser.SearchException::class.java) {
            runBlocking { provider.lookupByQuery(EanHeadlessBrowser.SearchQuery()) }
        }
        assertEquals("Пустой запрос для поиска", error.message)
    }

    @Test
    fun выключенный_ИИ_бросает_SearchException_вместо_тихого_null() {
        val provider = EanHeadlessBrowser(settings = { AgentSettings(enabled = false) })
        val error = assertThrows(EanHeadlessBrowser.SearchException::class.java) {
            runBlocking { provider.lookupByQuery(EanHeadlessBrowser.SearchQuery(ean = "4600000000008")) }
        }
        assertEquals("ИИ выключен — включите его в настройках агента", error.message)
    }
}

package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.domain.access.Role

@RunWith(RobolectricTestRunner::class)
class PeerTrustTest {

    @Test
    fun roundTripAllScope() {
        val t = PeerTrust(Role.ADMIN, PeerTrust.SCOPE_ALL)
        val parsed = PeerTrust.parse(PeerTrust.toJson(t))
        assertEquals(Role.ADMIN, parsed.role)
        assertEquals(PeerTrust.SCOPE_ALL, parsed.scope)
        assertTrue(parsed.storages.isEmpty())
    }

    @Test
    fun roundTripSomeScope() {
        val t = PeerTrust(Role.VIEW, PeerTrust.SCOPE_SOME, listOf("s1", "s2"))
        val parsed = PeerTrust.parse(PeerTrust.toJson(t))
        assertEquals(Role.VIEW, parsed.role)
        assertEquals(PeerTrust.SCOPE_SOME, parsed.scope)
        assertEquals(listOf("s1", "s2"), parsed.storages)
    }

    @Test
    fun emptyJsonFallsBackToDefault() {
        val t = PeerTrust.parse("")
        assertEquals(PeerTrust.DEFAULT, t)
        val n = PeerTrust.parse(null)
        assertEquals(PeerTrust.DEFAULT, n)
    }

    @Test
    fun brokenJsonFallsBackToDefault() {
        val t = PeerTrust.parse("{не json")
        assertEquals(PeerTrust.DEFAULT, t)
    }

    @Test
    fun unknownRoleParsedAsView() {
        val t = PeerTrust.parse("""{"role":"superuser","scope":"all"}""")
        assertEquals(Role.VIEW, t.role)
    }

    @Test
    fun someScopeWithoutStoragesListIsEmpty() {
        val t = PeerTrust.parse("""{"role":"admin","scope":"some"}""")
        assertTrue(t.storages.isEmpty())
    }

    @Test
    fun labelShowsStorageCount() {
        assertEquals("вся база", PeerTrust.label(PeerTrust(Role.ADD, PeerTrust.SCOPE_ALL)))
        assertEquals(
            "хранилищ: 2",
            PeerTrust.label(PeerTrust(Role.ADD, PeerTrust.SCOPE_SOME, listOf("a", "b")))
        )
    }
}

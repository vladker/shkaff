package ru.vldkr.shkaff.domain.locations

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

// T-041: «призраки» в удалённом ящике — ссылка location_id на мягко удалённый ящик
// не должна считаться местом: вещь «без места», а не «на месте» в несуществующем ящике.
class LocationPlacementTest {

    private val live = setOf("L1", "L2")

    @Test
    fun `null link is no place`() {
        assertNull(LocationPlacement.resolve(null, live))
        assertFalse(LocationPlacement.hasPlace(null, live))
    }

    @Test
    fun `link to a live box is the place`() {
        assertEquals("L2", LocationPlacement.resolve("L2", live))
        assertTrue(LocationPlacement.hasPlace("L2", live))
    }

    @Test
    fun `ghost link to a deleted box is no place`() {
        assertNull(LocationPlacement.resolve("gone", live))
        assertFalse(LocationPlacement.hasPlace("gone", live))
    }

    @Test
    fun `empty live set makes every link a ghost`() {
        assertNull(LocationPlacement.resolve("L1", emptySet()))
        assertFalse(LocationPlacement.hasPlace("L1", emptySet()))
    }
}

package ru.vldkr.shkaff.domain.visual

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SchematicLayoutTest {

    @Test
    fun `empty input gives empty layout`() {
        assertTrue(SchematicLayout.layout(emptyList()).isEmpty())
    }

    @Test
    fun `single item fills the whole area`() {
        val b = SchematicLayout.layout(listOf("a" to "Ящик A"))
        assertEquals(1, b.size)
        assertEquals("a", b[0].locationId)
        assertTrue(b[0].rect.width > 0.8f)
        assertTrue(b[0].rect.height > 0.8f)
    }

    @Test
    fun `four items form a 2x2 grid without overlap`() {
        val items = (1..4).map { "loc$it" to "Ящик $it" }
        val blocks = SchematicLayout.layout(items)
        assertEquals(4, blocks.size)
        val centers = blocks.map { it.rect.left to it.rect.top }
        assertEquals(4, centers.toSet().size)
        // нет пересечений
        for (i in blocks.indices) {
            for (j in i + 1 until blocks.size) {
                val a = blocks[i].rect
                val b = blocks[j].rect
                assertFalse(a.left < b.right && a.right > b.left && a.top < b.bottom && a.bottom > b.top)
            }
        }
    }

    @Test
    fun `all rects stay inside unit square`() {
        val blocks = SchematicLayout.layout((1..13).map { "loc$it" to "Ящик $it" })
        blocks.forEach { b ->
            assertTrue(b.rect.left >= 0f && b.rect.top >= 0f)
            assertTrue(b.rect.right <= 1f && b.rect.bottom <= 1f)
        }
    }

    @Test
    fun `point in block center hits exactly that block`() {
        val items = listOf("a" to "A", "b" to "B", "c" to "C", "d" to "D")
        val blocks = SchematicLayout.layout(items)
        blocks.forEach { b ->
            val cx = (b.rect.left + b.rect.right) / 2f
            val cy = (b.rect.top + b.rect.bottom) / 2f
            val hits = blocks.filter { it.rect.contains(cx, cy) }
            assertEquals(1, hits.size)
            assertEquals(b, hits[0])
        }
    }

    @Test
    fun `blank labels fall back to generic name`() {
        val blocks = SchematicLayout.layout(listOf("a" to ""))
        assertEquals("Ящик", blocks[0].label)
    }

    @Test
    fun `repeated layout is stable`() {
        val items = (1..7).map { "loc$it" to "Ящик $it" }
        assertEquals(SchematicLayout.layout(items), SchematicLayout.layout(items))
    }
}
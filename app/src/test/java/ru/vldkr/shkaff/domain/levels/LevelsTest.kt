package ru.vldkr.shkaff.domain.levels

import org.junit.Assert.assertEquals
import org.junit.Test

class LevelsTest {

    private data class Node(val id: String, val name: String, val parent: String?)

    private val city = Node("c1", "Город", null)
    private val warehouse = Node("w1", "Склад", "c1")
    private val wardrobe = Node("s1", "Шкаф", "w1")

    @Test
    fun rankOrderDoesNotChange() {
        assertEquals(0, Levels.rank("Город"))
        assertEquals(4, Levels.rank("Полка"))
        assertEquals(6, Levels.rank("Пакет"))
        assertEquals(-1, Levels.rank("Стол"))
        assertEquals(-1, Levels.rank(""))
    }

    @Test
    fun chainToRootBuildsFullPathRootFirst() {
        val byId = listOf(city, warehouse, wardrobe).associateBy { it.id }
        val chain = Levels.chainToRoot("s1", byId, { it.name }, { it.parent })
        assertEquals(listOf("Город", "Склад", "Шкаф"), chain)
    }

    @Test
    fun chainToRootHandlesMissingRoot() {
        val orphan = Node("a", "Сирота", null)
        val chain = Levels.chainToRoot("a", mapOf("a" to orphan), { it.name }, { it.parent })
        assertEquals(listOf("Сирота"), chain)
    }

    @Test
    fun chainToRootStopsOnCycle() {
        val a = Node("a", "A", "b")
        val b = Node("b", "B", "a")
        val byId = listOf(a, b).associateBy { it.id }
        val chain = Levels.chainToRoot("a", byId, { it.name }, { it.parent })
        assertEquals(listOf("B", "A"), chain)
    }
}
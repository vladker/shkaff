package ru.vldkr.shkaff.domain.basket

import org.junit.Assert.assertEquals
import org.junit.Test

class PickPlannerTest {

    private fun task(
        key: String,
        locationId: String?,
        path: List<String>,
        size: Double = 0.0,
        addedAt: Long = 0L
    ) = PickTask(
        key = key, itemId = key, itemName = "Вещь $key",
        locationId = locationId, locationPath = path,
        sizeLiters = size, addedAt = addedAt
    )

    @Test
    fun groupsItemsOfSameLocationIntoOneStep() {
        val a = task("a", "loc1", listOf("Шкаф", "Полка 1"))
        val b = task("b", "loc1", listOf("Шкаф", "Полка 1"))
        val c = task("c", "loc2", listOf("Шкаф", "Полка 2"))
        val steps = PickPlanner.plan(listOf(a, b, c), BasketSort.ADDITION_ORDER)
        assertEquals(2, steps.size)
        val step1 = steps.first { it.locationId == "loc1" }
        assertEquals(2, step1.tasks.size)
    }

    @Test
    fun byLocationCountPutsBiggerStepFirst() {
        val a = task("a", "loc1", emptyList(), addedAt = 1)
        val b = task("b", "loc1", emptyList(), addedAt = 2)
        val c = task("c", "loc2", emptyList(), addedAt = 0)
        val steps = PickPlanner.plan(listOf(a, b, c), BasketSort.BY_LOCATION_COUNT)
        assertEquals("loc1", steps.first().locationId)
    }

    @Test
    fun shallowDepthFirst() {
        val a = task("a", "loc1", listOf("Шкаф", "Полка", "Коробка"), addedAt = 0)
        val b = task("b", "loc2", listOf("Шкаф"), addedAt = 1)
        val steps = PickPlanner.plan(listOf(a, b), BasketSort.SHALLOW_DEPTH)
        assertEquals("loc2", steps.first().locationId)
        assertEquals(1, steps.first().depth)
    }

    @Test
    fun smallFirstOrdersItemsInsideStep() {
        val a = task("a", "loc1", emptyList(), size = 50.0, addedAt = 1)
        val b = task("b", "loc1", emptyList(), size = 1.0, addedAt = 2)
        val steps = PickPlanner.plan(listOf(a, b), BasketSort.SMALL_FIRST)
        assertEquals(listOf("b", "a"), steps.first().tasks.map { it.key })
    }

    @Test
    fun itemsWithoutLocationGoToOwnStepLabeledNoPlace() {
        val a = task("a", null, emptyList())
        val steps = PickPlanner.plan(listOf(a), BasketSort.ADDITION_ORDER)
        assertEquals(1, steps.size)
        assertEquals("Без места", steps.first().label)
    }

    @Test
    fun emptyInputGivesEmptyPlan() {
        assertEquals(0, PickPlanner.plan(emptyList(), BasketSort.ADDITION_ORDER).size)
    }
}
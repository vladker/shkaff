package ru.vldkr.shkaff.data.catalog

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AttributeCatalogTest {

    @Test
    fun itemCategoriesHaveAtLeast30Entries() {
        assertTrue(AttributeCatalog.itemCategories.size >= 30)
    }

    @Test
    fun categoriesAreUnique() {
        assertEquals(AttributeCatalog.itemCategories.size, AttributeCatalog.itemCategories.distinct().size)
        assertEquals(AttributeCatalog.storageCategories.size, AttributeCatalog.storageCategories.distinct().size)
    }

    @Test
    fun categoriesForReturnsCorrectScope() {
        assertEquals(AttributeCatalog.itemCategories, AttributeCatalog.categoriesFor("item"))
        assertEquals(AttributeCatalog.storageCategories, AttributeCatalog.categoriesFor("storage"))
        assertEquals(AttributeCatalog.itemCategories, AttributeCatalog.categoriesFor("location"))
    }

    @Test
    fun specTiersAreValid() {
        val valid = setOf("min", "rec", "free")
        AttributeCatalog.specs.forEach { s ->
            assertTrue("Недопустимый tier у ${s.scope}/${s.key}: ${s.tier}", s.tier in valid)
        }
    }

    @Test
    fun specCategoryValuesAreValid() {
        AttributeCatalog.specs.forEach { s ->
            val ok = s.category == "*" || AttributeCatalog.categoriesFor(s.scope).contains(s.category)
            assertTrue("Недопустимая категория у ${s.scope}/${s.key}: ${s.category}", ok)
        }
    }

    @Test
    fun specKeysAreUniquePerScope() {
        AttributeCatalog.specs
            .groupBy { it.scope }
            .values
            .forEach { group ->
                val keys = group.map { it.key }
                assertEquals("Дубли ключей в scope=${group.first().scope}", keys.size, keys.distinct().size)
            }
    }

    @Test
    fun selectOptionsAreUnique() {
        AttributeCatalog.specs
            .filter { it.type == "select" }
            .forEach { s ->
                assertEquals("Дубли вариантов у ${s.scope}/${s.key}", s.options.size, s.options.distinct().size)
            }
    }
}

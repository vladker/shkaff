package ru.vldkr.shkaff.data

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AttrJsonTest {

    @Test
    fun parseOptionsReadsList() {
        assertEquals(listOf("a", "b"), AttrJson.parseOptions("""["a","b"]"""))
    }

    @Test
    fun parseOptionsToleratesBrokenOrEmpty() {
        assertEquals(emptyList<String>(), AttrJson.parseOptions("garbage"))
        assertEquals(emptyList<String>(), AttrJson.parseOptions(null))
        assertEquals(emptyList<String>(), AttrJson.parseOptions("[]"))
    }

    @Test
    fun parseOptionsSkipsBlankEntries() {
        assertEquals(listOf("a", "c"), AttrJson.parseOptions("""["a","","c"]"""))
    }

    @Test
    fun appendsNewOption() {
        assertEquals("""["a","b","c"]""", AttrJson.optionsWithNew("""["a","b"]""", "c"))
    }

    @Test
    fun trimsNewOption() {
        assertEquals("""["a","c"]""", AttrJson.optionsWithNew("""["a"]""", "  c  "))
    }

    @Test
    fun dedupesCaseInsensitive() {
        assertEquals("""["A","b"]""", AttrJson.optionsWithNew("""["A","b"]""", "a"))
        assertEquals("""["A","b"]""", AttrJson.optionsWithNew("""["A","b"]""", "B"))
    }

    @Test
    fun blankOptionKeepsListUnchanged() {
        assertEquals("""["a"]""", AttrJson.optionsWithNew("""["a"]""", "   "))
    }

    @Test
    fun appendsToEmptyAndBrokenJson() {
        assertEquals("""["x"]""", AttrJson.optionsWithNew("[]", "x"))
        assertEquals("""["x"]""", AttrJson.optionsWithNew("garbage", "x"))
        assertEquals("""["x"]""", AttrJson.optionsWithNew(null, "x"))
    }

    @Test
    fun roundTripThroughParseOptions() {
        val json = AttrJson.optionsWithNew("""["Электроника"]""", "Свет")
        assertEquals(listOf("Электроника", "Свет"), AttrJson.parseOptions(json))
    }
}

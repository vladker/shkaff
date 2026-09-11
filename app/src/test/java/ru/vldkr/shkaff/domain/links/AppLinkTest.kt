package ru.vldkr.shkaff.domain.links

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AppLinkTest {

    @Test
    fun urlForEncodesCode() {
        val url = AppLink.urlFor("DR-1")
        assertTrue(url.startsWith(AppLink.BASE))
        assertTrue(url.contains("app=1"))
        assertTrue(url.contains("code=DR-1"))
    }

    @Test
    fun urlForEncodesSpecialChars() {
        val url = AppLink.urlFor("A B&C")
        assertTrue(url.contains("code=A+B%26C"))
    }

    @Test
    fun parseRoundTrip() {
        val code = "DR-1"
        assertEquals(code, AppLink.parse(AppLink.urlFor(code)))
    }

    @Test
    fun parseRoundTripSpecialChars() {
        val code = "вещь/1 & №2"
        assertEquals(code, AppLink.parse(AppLink.urlFor(code)))
    }

    @Test
    fun parseRejectsForeignUrl() {
        assertNull(AppLink.parse("https://example.com?app=1&code=X"))
        assertNull(AppLink.parse("https://github.com/vldkr/other/releases?app=1&code=X"))
    }

    @Test
    fun parseRejectsAppLinkWithoutCode() {
        assertNull(AppLink.parse("${AppLink.BASE}?app=1"))
        assertNull(AppLink.parse("${AppLink.BASE}?code=DR-1"))
    }

    @Test
    fun isAppLinkFlag() {
        assertTrue(AppLink.isAppLink(AppLink.urlFor("X")))
        assertFalse(AppLink.isAppLink(AppLink.BASE))
    }
}
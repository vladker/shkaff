package ru.vldkr.shkaff.domain.labels

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

// T-048: HEX-цвета шаблона не валидировались — битый цвет молча печатался
// чёрным. Валидация формата — чистая функция domain/labels/ColorHex.
class ColorHexTest {

    @Test
    fun `accepts six-digit hex`() {
        assertTrue(ColorHex.isHexColor("#000000"))
        assertTrue(ColorHex.isHexColor("#FFFFFF"))
        assertTrue(ColorHex.isHexColor("#ff8800"))
        assertTrue(ColorHex.isHexColor("#0F1A2B"))
    }

    @Test
    fun `accepts eight-digit hex with alpha`() {
        assertTrue(ColorHex.isHexColor("#80FF8800"))
    }

    @Test
    fun `rejects malformed colors`() {
        assertFalse(ColorHex.isHexColor(""))
        assertFalse(ColorHex.isHexColor("black"))
        assertFalse(ColorHex.isHexColor("red"))
        assertFalse(ColorHex.isHexColor("FF8800")) // без решётки
        assertFalse(ColorHex.isHexColor("#GG8800")) // не hex-символы
        assertFalse(ColorHex.isHexColor("#FFF")) // сокращённая форма
        assertFalse(ColorHex.isHexColor("#FF880")) // 5 цифр
        assertFalse(ColorHex.isHexColor("#FF88000")) // 7 цифр
        assertFalse(ColorHex.isHexColor("#FF8800001")) // 9 цифр
        assertFalse(ColorHex.isHexColor(" #FF8800")) // ведущий пробел
        assertFalse(ColorHex.isHexColor("#FF8800 ")) // хвостовой пробел
    }
}

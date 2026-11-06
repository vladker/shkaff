package ru.vldkr.shkaff.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * HID-накопитель: клавиши аппаратного сканера ШК-кода приходят как быстрый клавиатурный
 * ввод, завершённый Enter. Отличаем от человека по межклавишному зазору и длине.
 */
class HidScanAccumulatorTest {

    // Обратная раскладка: символ → (keyCode, shift) — ключы android.view.KeyEvent.
    private fun keyFor(ch: Char): Pair<Int, Boolean> = when {
        ch in 'a'..'z' -> (29 + (ch - 'a')) to false
        ch in 'A'..'Z' -> (29 + (ch - 'A')) to true
        ch in '0'..'9' -> (7 + (ch - '0')) to false
        ch == ':' -> 74 to true   // semicolon+shift
        ch == '-' -> 69 to false
        else -> error("нет маппинга для '$ch'")
    }

    private fun type(acc: HidScanAccumulator, s: String, t0: Long, gapMs: Long): String? {
        var t = t0
        for (ch in s) {
            val (kc, sh) = keyFor(ch)
            acc.onKey(kc, sh, 0, t)
            t += gapMs
        }
        return acc.onKey(66, false, 0, t) // KEYCODE_ENTER
    }

    @Test
    fun `сканированный ULID возвращается как есть`() {
        val acc = HidScanAccumulator()
        val ulid = "01JBQ6ZGXWZ4NNRQ6H5K9MTV3E"
        val code = type(acc, ulid, t0 = 1000, gapMs = 4)
        assertEquals(ulid, code)
    }

    @Test
    fun `цифры EAN-13 без shift`() {
        val acc = HidScanAccumulator()
        val code = type(acc, "4600123456782", t0 = 0, gapMs = 2)
        assertEquals("4600123456782", code)
    }

    @Test
    fun `служебный код действия с двоеточиями`() {
        val acc = HidScanAccumulator()
        val sh = "shkaff:v1:open:01JBQ6ZGXW"
        val code = type(acc, sh, t0 = 0, gapMs = 3)
        assertEquals(sh, code)
    }

    @Test
    fun `человеческий набор с Enter не является сканом`() {
        val acc = HidScanAccumulator()
        val code = type(acc, "4600", t0 = 0, gapMs = 250)
        assertNull(code)
    }

    @Test
    fun `длинная пауза в середине обрывает хвост`() {
        val acc = HidScanAccumulator()
        // 'AB' быстро, пауза 500мс, потом 'C' и Enter — хвост 'C' короче минимума
        var t = 0L
        for (ch in "AB") { val (kc, sh) = keyFor(ch); acc.onKey(kc, sh, 0, t); t += 5 }
        t += 500
        val (kc, sh) = keyFor('C')
        acc.onKey(kc, sh, 0, t)
        assertNull(acc.onKey(66, false, 0, t + 4))
    }

    @Test
    fun `Enter на пустом буфере — null`() {
        val acc = HidScanAccumulator()
        assertNull(acc.onKey(66, false, 0, 1000))
    }

    @Test
    fun `прочая клавиша посередине обрывает последовательность`() {
        val acc = HidScanAccumulator()
        var t = 0L
        for (ch in "ABC") { val (kc, sh) = keyFor(ch); acc.onKey(kc, sh, 0, t); t += 5 }
        acc.onKey(23, false, 0, t) // DPAD_CENTER — не печатная
        t += 5
        for (ch in "DEF") { val (kc, sh) = keyFor(ch); acc.onKey(kc, sh, 0, t); t += 5 }
        // 'ABC'+'DEF' не склеились: вернётся только второй сегмент
        assertEquals("DEF", acc.onKey(66, false, 0, t))
    }

    @Test
    fun `переполнение буфера сбрасывает накопление`() {
        val acc = HidScanAccumulator(maxLen = 8)
        val code = type(acc, "ABCDEFGHIJKL", t0 = 0, gapMs = 3)
        assertNull(code)
    }

    @Test
    fun `скан не «склеивается» со следующим медленным`() {
        val acc = HidScanAccumulator()
        assertEquals("ABC", type(acc, "ABC", t0 = 0, gapMs = 4))
        assertNull(type(acc, "DE", t0 = 5000, gapMs = 4))
    }
}

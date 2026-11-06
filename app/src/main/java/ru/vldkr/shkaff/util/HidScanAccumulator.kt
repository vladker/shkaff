package ru.vldkr.shkaff.util

/**
 * Накопитель клавиш аппаратного сканера ШК-кода, который работает как HID-клавиатура:
 * все символы кода идут с крошечным межклавишным интервалом (< maxGapMs) и завершаются
 * Enter. Человеческий набор рвёт последовательность зазором. Класс свободен от
 * android.view.KeyEvent (коды ключей — int-константы), поэтому тестируется на JVM.
 *
 * onKey возвращает завершённый код на Enter, иначе null.
 */
class HidScanAccumulator(
    private val maxGapMs: Long = 50,
    private val minLength: Int = 3,
    private val maxLen: Int = 64,
) {
    private val buf = StringBuilder()
    private var lastAt = Long.MIN_VALUE / 2
    private var overflow = false

    fun onKey(keyCode: Int, shift: Boolean, repeat: Int, atMs: Long): String? {
        if (keyCode == ENTER) {
            val code = buf.toString()
            val over = overflow
            buf.setLength(0)
            overflow = false
            return if (!over && code.length >= minLength) code else null
        }
        val ch = CHARS[keyCode]?.let { if (shift) it.second else it.first }
            ?: run { buf.setLength(0); overflow = false; return null } // прочая клавиша обрывает последовательность
        if (repeat == 0 && atMs - lastAt > maxGapMs) { buf.setLength(0); overflow = false }
        lastAt = atMs
        if (buf.length >= maxLen) overflow = true else buf.append(ch)
        return null
    }

    private companion object {
        const val ENTER = 66 // android.view.KeyEvent.KEYCODE_ENTER

        // Shift-варианты цифр по индексу цифры: '0'(KEYCODE_0=7) → ')' и т.д.
        val SHIFT_DIGIT = charArrayOf(')', '!', '@', '#', '$', '%', '^', '&', '*', '(')

        // Коды ключей KeyEvent (US-раскладка): Pair(без shift, с shift).
        val CHARS: Map<Int, Pair<Char, Char>> = buildMap {
            for (i in 0 until 26) put(29 + i, ('a' + i) to ('A' + i)) // KEYCODE_A..KEYCODE_Z
            for (i in 0..9) put(7 + i, Character.forDigit(i, 10) to SHIFT_DIGIT[i]) // KEYCODE_0..KEYCODE_9
            put(62, ' ' to ' ')
            put(68, '`' to '~'); put(69, '-' to '_'); put(70, '=' to '+')
            put(71, '[' to '{'); put(72, ']' to '}'); put(73, '\\' to '|')
            put(74, ';' to ':'); put(75, '\'' to '"'); put(76, '/' to '?')
            put(55, ',' to '<'); put(56, '.' to '>') // после KEYCODE_Z=54
        }
    }
}

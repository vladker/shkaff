package ru.vldkr.shkaff.util

import java.security.SecureRandom
import java.util.UUID

fun newId(): String = UUID.randomUUID().toString()

// ULID: 128 бит = 48 бит времени (мс) + 80 бит случайных, Crockford base32 → 26 символов.
// Хронологически сортируемые, без неоднозначных букв (нет I, L, O, U) — удобно для печати.
private const val CROCKFORD = "0123456789ABCDEFGHJKMNPQRSTVWXYZ"
private val ulidRandom = SecureRandom()

fun newUlid(): String {
    val ts = System.currentTimeMillis() and 0x0000FFFFFFFFFFFFL
    val b = ByteArray(16)
    ulidRandom.nextBytes(b)
    b[0] = ((ts shr 40) and 0xFF).toByte()
    b[1] = ((ts shr 32) and 0xFF).toByte()
    b[2] = ((ts shr 24) and 0xFF).toByte()
    b[3] = ((ts shr 16) and 0xFF).toByte()
    b[4] = ((ts shr 8) and 0xFF).toByte()
    b[5] = (ts and 0xFF).toByte()
    val sb = StringBuilder(26)
    sb.append(CROCKFORD[(b[0].toInt() and 0xFF) ushr 5])
    var buf = b[0].toInt() and 0x1F
    var bufBits = 5
    var idx = 1
    while (sb.length < 26) {
        while (bufBits < 5 && idx < 16) {
            buf = (buf shl 8) or (b[idx].toInt() and 0xFF)
            bufBits += 8
            idx++
        }
        bufBits -= 5
        sb.append(CROCKFORD[(buf shr bufBits) and 0x1F])
    }
    return sb.toString()
}

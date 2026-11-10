package ru.vldkr.shkaff.ui.state

import org.junit.Assert.assertTrue
import org.junit.Test

// T-040: текст сбоя — единственное, что пользователь видит вместо списка; он обязан
// называть причину, а не молчать и не быть стек-трейсом.
class LoadErrorTextTest {

    @Test
    fun `failure keeps its reason`() {
        val t = loadErrorText(RuntimeException("no such table: item"))
        assertTrue("ожидался разборчивый заголовок: $t", t.contains("Не удалось загрузить данные"))
        assertTrue("ожидалась причина сбоя: $t", t.contains("no such table: item"))
    }

    @Test
    fun `database failure is named as a database problem`() {
        val root = Sqliteish("database disk image is malformed")
        val t = loadErrorText(RuntimeException("query failed", root))
        assertTrue("ожидалась честная формулировка про базу: $t", t.contains("базу данных"))
        assertTrue("ожидалась причина из БД: $t", t.contains("database disk image is malformed"))
    }

    @Test
    fun `exception without message falls back to its class name`() {
        val t = loadErrorText(IllegalStateException())
        assertTrue("ожидалось имя исключения: $t", t.contains("IllegalStateException"))
    }

    @Test
    fun `long message is truncated and a cause cycle cannot hang the walk`() {
        val long = loadErrorText(RuntimeException("x".repeat(5000)))
        assertTrue("текст не должен вылезать за экран: ${long.length}", long.length <= 300)

        val a = Link("a")
        val b = Link("b")
        a.link = b
        b.link = a // a → b → a: обход цепочки обязан остановиться
        val cycled = loadErrorText(a)
        assertTrue("цикличный cause не должен обнулять текст: $cycled", cycled.isNotBlank())

        val self = Link("сам")
        assertTrue("самопричинный cause не должен обнулять текст: $self", loadErrorText(self).isNotBlank())
    }
}

// имя класса содержит «sqlite» — так детектор распознаёт сбои Room/БД
private class Sqliteish(message: String) : RuntimeException(message)

// getCause возвращает link — цикл причин, который ломал бы наивный обход
private class Link(message: String) : RuntimeException(message) {
    var link: Throwable? = null
    override val cause: Throwable? get() = link ?: this
}

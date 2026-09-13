package ru.vldkr.shkaff.domain.agent

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

// Парсеры DuckDuckGo/HTML — без сети и без org.json: чистый JUnit4.
class WebToolsTest {

    private val sample = """
        <html><body>
        <div class="result results_links web-result">
          <div class="result__body">
            <h2 class="result__title"><a rel="nofollow" class="result__a" href="//duckduckgo.com/l/?uddg=https%3A%2F%2Fwww.example.com%2Fpage%3Fb%3Dc&amp;rut=abc">Example <b>Title</b></a></h2>
            <a class="result__snippet" href="//duckduckgo.com/l/?uddg=https%3A%2F%2Fwww.example.com%2Fpage%3Fb%3Dc&amp;rut=abc">Some <b>snippet</b> &amp; more.</a>
          </div>
        </div>
        <div class="result results_links web-result">
          <a rel="nofollow" class="result__a" href="https://second.example.org/item">Second result</a>
          <a class="result__snippet">Snippet two &gt; one</a>
        </div>
        </body></html>
    """.trimIndent()

    @Test
    fun parseDuckDuckGo_extractsTitleUrlAndSnippet() {
        val hits = parseDuckDuckGo(sample)
        assertEquals(2, hits.size)
        assertEquals("Example Title", hits[0].title)
        assertEquals("https://www.example.com/page?b=c", hits[0].url)
        assertEquals("Some snippet & more.", hits[0].snippet)
        assertEquals("Second result", hits[1].title)
        assertEquals("https://second.example.org/item", hits[1].url)
        assertEquals("Snippet two > one", hits[1].snippet)
    }

    @Test
    fun parseDuckDuckGo_emptyOnNoResults() {
        assertTrue(parseDuckDuckGo("<html><body>nothing here</body></html>").isEmpty())
    }

    @Test
    fun resolveDdgHref_decodesUddgRedirect() {
        assertEquals(
            "https://www.example.com/a?b=c",
            resolveDdgHref("//duckduckgo.com/l/?uddg=https%3A%2F%2Fwww.example.com%2Fa%3Fb%3Dc&rut=x")
        )
    }

    @Test
    fun resolveDdgHref_keepsPlainUrl() {
        assertEquals("https://example.org/x", resolveDdgHref("https://example.org/x"))
        assertEquals("", resolveDdgHref(""))
    }

    @Test
    fun decodeEntities_namedAndNumeric() {
        assertEquals(
            "a & b < c > d \"e\" 'f'",
            decodeEntities("a &amp; b &lt; c &gt; d &quot;e&quot; &#39;f&#39;")
        )
        assertEquals("«привет» …", decodeEntities("&#171;привет&#187; &#8230;"))
        assertEquals("copy stays", decodeEntities("copy stays"))
    }

    @Test
    fun htmlToText_stripsScriptsAndKeepsStructure() {
        val html = """
            <html><head><style>body{color:red}</style></head><body>
            <script>var x=1;</script>
            <h1>Заголовок</h1>
            <p>Первый&nbsp;абзац</p>
            <p>Второй<br/>абзац</p>
            </body></html>
        """.trimIndent()
        val text = htmlToText(html)
        assertTrue(text.contains("Заголовок"))
        assertTrue(text.contains("Первый абзац"))
        assertTrue(text.contains("Второй"))
        assertTrue(text.contains("абзац"))
        assertFalse(text.contains("color:red"))
        assertFalse(text.contains("var x"))
    }

    @Test
    fun htmlToText_collapsesWhitespaceAndKeepsParagraphBreaks() {
        assertEquals("a b\n\nc", htmlToText("<p>a   b</p><div></div><p>c</p>"))
    }
}

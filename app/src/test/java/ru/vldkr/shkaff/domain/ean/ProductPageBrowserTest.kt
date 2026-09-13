package ru.vldkr.shkaff.domain.ean

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ProductPageBrowserTest {

    @Test
    fun normalizeAddsHttpsWhenMissing() {
        assertEquals("https://example.com/p", normalizePageUrl("example.com/p"))
    }

    @Test
    fun normalizeKeepsHttpScheme() {
        assertEquals("http://example.com/p", normalizePageUrl("http://example.com/p"))
    }

    @Test
    fun normalizeProtocolRelative() {
        assertEquals("https://example.com/p", normalizePageUrl("//example.com/p"))
    }

    @Test
    fun normalizeTrimsWhitespace() {
        assertEquals("https://example.com/p", normalizePageUrl("  example.com/p  "))
    }

    @Test
    fun metaTagFindsContentRegardlessOfAttributeOrder() {
        val html = """<meta content="https://cdn/x.jpg" property="og:image" />"""
        assertEquals("https://cdn/x.jpg", metaTagValue(html, "property", "og:image"))
    }

    @Test
    fun metaTagByNameAttribute() {
        val html = """<meta name="description" content="Товарный опис" />"""
        assertEquals("Товарный опис", metaTagValue(html, "name", "description"))
    }

    @Test
    fun metaTagReturnsNullWhenAbsent() {
        val html = """<meta name="viewport" content="width=device-width" />"""
        assertNull(metaTagValue(html, "property", "og:image"))
    }

    @Test
    fun titlePrefersOgTitleOverTitleTag() {
        val html = """
            <head>
              <title>Raw &lt;title&gt;</title>
              <meta property="og:title" content="Og Title" />
            </head>
        """.trimIndent()
        assertEquals("Og Title", extractPageTitle(html))
    }

    @Test
    fun titleFallsBackToTitleTag() {
        val html = """<head><title>  Just Title  </title></head>"""
        assertEquals("Just Title", extractPageTitle(html))
    }

    @Test
    fun metaDescriptionExtracted() {
        val html = """<meta name="description" content="  Краткое описание товара  " />"""
        assertEquals("Краткое описание товара", extractMetaDescription(html))
    }

    @Test
    fun metaDescriptionBlankWhenMissing() {
        val html = """<html><body>hello</body></html>"""
        assertEquals("", extractMetaDescription(html))
    }

    @Test
    fun imageUrlFromOgImage() {
        val html = """
            <meta property="og:image" content="https://cdn/og.jpg" />
            <img src="/fallback.png" />
        """.trimIndent()
        assertEquals("https://cdn/og.jpg", extractProductImageUrl(html))
    }

    @Test
    fun imageUrlProtocolRelativeAbsolutized() {
        val html = """<meta name="twitter:image" content="//cdn/tw.png" />"""
        assertEquals("https://cdn/tw.png", extractProductImageUrl(html))
    }

    @Test
    fun imageUrlFromJsonLd() {
        val html = """<script type="application/ld+json">{"@type":"Product","image":"https://cdn/ld.jpg"}</script>"""
        assertEquals("https://cdn/ld.jpg", extractProductImageUrl(html))
    }

    @Test
    fun imageUrlFallsBackToFirstImgSrc() {
        val html = """
            <img src="/logo.svg" />
            <img data-src="https://cdn/product.webp" />
        """.trimIndent()
        assertEquals("https://cdn/product.webp", extractProductImageUrl(html))
    }

    @Test
    fun imageUrlNullWhenNothingFound() {
        val html = """<html><body>no images here</body></html>"""
        assertNull(extractProductImageUrl(html))
    }

    @Test
    fun findUrlInPlainText() {
        assertEquals(
            "https://ozon.ru/product/123",
            findUrlInText("https://ozon.ru/product/123")
        )
    }

    @Test
    fun findUrlInsideRussianText() {
        assertEquals(
            "https://ozon.ru/product/123",
            findUrlInText("вот товар — https://ozon.ru/product/123, смотрите")
        )
    }

    @Test
    fun findUrlStripsTrailingPunctuation() {
        assertEquals(
            "https://example.com/p/1",
            findUrlInText("Ссылка: https://example.com/p/1.")
        )
    }

    @Test
    fun findUrlAddsHttpsToBareDomain() {
        assertEquals(
            "https://www.ozon.ru/product/123",
            findUrlInText("заказ тут www.ozon.ru/product/123")
        )
    }

    @Test
    fun findUrlAddsHttpsToDomain() {
        assertEquals(
            "https://example.com/a/b?x=1",
            findUrlInText("example.com/a/b?x=1")
        )
    }

    @Test
    fun findUrlFromRealOzonPaste() {
        val pasted = """
            Термопринтер для этикеток и наклеек Bluetooth, портативный принтер для Android/iOS, без чернил
            https://ozon.ru/t/r9xbm4g
        """.trimIndent()
        assertEquals("https://ozon.ru/t/r9xbm4g", findUrlInText(pasted))
    }

    @Test
    fun findUrlNullWhenNoLink() {
        assertNull(findUrlInText("просто текст без ссылок, версия 1.2"))
    }

    @Test
    fun findUrlNullOnEmpty() {
        assertNull(findUrlInText("   "))
    }

    @Test
    fun findUrlIgnoresCyrillicQuotesAroundLink() {
        assertEquals(
            "https://example.com/p",
            findUrlInText("«https://example.com/p»")
        )
    }
}

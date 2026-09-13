package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f7499a = {"base", "basefont", "bgsound", "command", "link"};
    public static final String[] b = {"noframes", "style"};
    public static final String[] c = {"body", CompressorStreamFactory.BROTLI, "html"};
    public static final String[] d = {"body", CompressorStreamFactory.BROTLI, "html"};
    public static final String[] e = {"body", CompressorStreamFactory.BROTLI, "head", "html"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f7500f = {"basefont", "bgsound", "link", "meta", "noframes", "style"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f7501g = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "template", "title"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f7502h = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f7503i = {"h1", "h2", "h3", "h4", "h5", "h6"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f7504j = {"address", "div", "p"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f7505k = {"dd", "dt"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f7506l = {"b", "big", "code", "em", CellUtil.FONT, Complex.DEFAULT_SUFFIX, "s", "small", "strike", "strong", "tt", "u"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f7507m = {"applet", "marquee", "object"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f7508n = {"area", CompressorStreamFactory.BROTLI, "embed", "img", "keygen", "wbr"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f7509o = {"param", FirebaseAnalytics.Param.SOURCE, "track"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f7510p = {"action", "name", "prompt"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f7511q = {"caption", "col", "colgroup", TypedValues.AttributesType.S_FRAME, "head", "tbody", "td", "tfoot", "th", "thead", "tr"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f7512r = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f7513s = {"a", "b", "big", "code", "em", CellUtil.FONT, Complex.DEFAULT_SUFFIX, "nobr", "s", "small", "strike", "strong", "tt", "u"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f7514t = {"table", "tbody", "tfoot", "thead", "tr"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String[] f7515u = {"tbody", "tfoot", "thead"};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f7516v = {"td", "th", "tr"};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String[] f7517w = {"script", "style", "template"};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String[] f7518x = {"td", "th"};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f7519y = {"body", "caption", "col", "colgroup", "html"};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String[] f7520z = {"table", "tbody", "tfoot", "thead", "tr"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final String[] f7485A = {"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final String[] f7486B = {"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final String[] f7487C = {"table", "tbody", "tfoot", "thead", "tr"};

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final String[] f7488D = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final String[] f7489E = {"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final String[] f7490F = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final String[] f7491G = {"body", "caption", "col", "colgroup", "html", "td", "th"};

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final String[] f7492H = {"input", "keygen", "textarea"};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final String[] f7493I = {"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String[] f7494J = {"tbody", "tfoot", "thead"};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final String[] f7495K = {"head", "noscript"};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final String[] f7496L = {"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final String[] f7497M = {"base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "template", "title"};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final String[] f7498N = {"caption", "colgroup", "tbody", "tfoot", "thead"};
}

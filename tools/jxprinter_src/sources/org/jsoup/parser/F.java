package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class F implements Cloneable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f7545j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f7546k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f7547l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f7548m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f7549n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f7550o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f7551p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7552a;
    public final String b;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7553f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7554g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7555h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7556i = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", TypedValues.AttributesType.S_FRAME, "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center", "template", "dir", "applet", "marquee", "listing"};
        f7546k = new String[]{"object", "base", CellUtil.FONT, "tt", Complex.DEFAULT_SUFFIX, "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", CompressorStreamFactory.BROTLI, "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", FirebaseAnalytics.Param.SOURCE, "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", FirebaseAnalytics.Param.SOURCE, "track", "data", "bdi", "s", "strike", "nobr"};
        f7547l = new String[]{"meta", "link", "base", TypedValues.AttributesType.S_FRAME, "img", CompressorStreamFactory.BROTLI, "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", FirebaseAnalytics.Param.SOURCE, "track"};
        f7548m = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        f7549n = new String[]{"pre", "plaintext", "title", "textarea"};
        f7550o = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        f7551p = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (int i5 = 0; i5 < 69; i5++) {
            F f6 = new F(strArr[i5]);
            f7545j.put(f6.f7552a, f6);
        }
        for (String str : f7546k) {
            F f7 = new F(str);
            f7.c = false;
            f7.d = false;
            f7545j.put(f7.f7552a, f7);
        }
        for (String str2 : f7547l) {
            F f8 = (F) f7545j.get(str2);
            V4.h.notNull(f8);
            f8.e = true;
        }
        for (String str3 : f7548m) {
            F f9 = (F) f7545j.get(str3);
            V4.h.notNull(f9);
            f9.d = false;
        }
        for (String str4 : f7549n) {
            F f10 = (F) f7545j.get(str4);
            V4.h.notNull(f10);
            f10.f7554g = true;
        }
        for (String str5 : f7550o) {
            F f11 = (F) f7545j.get(str5);
            V4.h.notNull(f11);
            f11.f7555h = true;
        }
        for (String str6 : f7551p) {
            F f12 = (F) f7545j.get(str6);
            V4.h.notNull(f12);
            f12.f7556i = true;
        }
    }

    public F(String str) {
        this.f7552a = str;
        this.b = p051j0.i.i(str);
    }

    public static F a(String str) {
        V4.h.notNull(str);
        HashMap map = f7545j;
        F f6 = (F) map.get(str);
        if (f6 != null) {
            return f6;
        }
        String strTrim = str.trim();
        V4.h.notEmpty(strTrim);
        String strI = p051j0.i.i(strTrim);
        F f7 = (F) map.get(strI);
        if (f7 == null) {
            F f8 = new F(strTrim);
            f8.c = false;
            return f8;
        }
        if (strTrim.equals(strI)) {
            return f7;
        }
        try {
            F f9 = (F) super.clone();
            f9.f7552a = strTrim;
            return f9;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static F e(String str, D d) {
        V4.h.notNull(str);
        HashMap map = f7545j;
        F f6 = (F) map.get(str);
        if (f6 != null) {
            return f6;
        }
        String strB = d.b(str);
        V4.h.notEmpty(strB);
        String strI = p051j0.i.i(strB);
        F f7 = (F) map.get(strI);
        if (f7 == null) {
            F f8 = new F(strB);
            f8.c = false;
            return f8;
        }
        if (!d.f7543a || strB.equals(strI)) {
            return f7;
        }
        try {
            F f9 = (F) super.clone();
            f9.f7552a = strB;
            return f9;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Object clone() {
        try {
            return (F) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F)) {
            return false;
        }
        F f6 = (F) obj;
        return this.f7552a.equals(f6.f7552a) && this.e == f6.e && this.d == f6.d && this.c == f6.c && this.f7554g == f6.f7554g && this.f7553f == f6.f7553f && this.f7555h == f6.f7555h && this.f7556i == f6.f7556i;
    }

    public final int hashCode() {
        return (((((((((((((this.f7552a.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f7553f ? 1 : 0)) * 31) + (this.f7554g ? 1 : 0)) * 31) + (this.f7555h ? 1 : 0)) * 31) + (this.f7556i ? 1 : 0);
    }

    public final String toString() {
        return this.f7552a;
    }
}

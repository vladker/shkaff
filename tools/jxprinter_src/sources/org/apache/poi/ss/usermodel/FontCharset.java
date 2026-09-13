package org.apache.poi.ss.usermodel;

import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Removal(version = "6.0.0")
@Deprecated
public enum FontCharset {
    ANSI(0),
    DEFAULT(1),
    SYMBOL(2),
    MAC(77),
    SHIFTJIS(128),
    HANGEUL(129),
    JOHAB(130),
    GB2312(134),
    CHINESEBIG5(136),
    GREEK(161),
    TURKISH(162),
    VIETNAMESE(163),
    HEBREW(177),
    ARABIC(178),
    BALTIC(186),
    RUSSIAN(204),
    THAI(222),
    EASTEUROPE(238),
    OEM(255);

    private static FontCharset[] _table = new FontCharset[256];
    private int charset;

    static {
        for (FontCharset fontCharset : values()) {
            _table[fontCharset.getValue()] = fontCharset;
        }
    }

    FontCharset(int i5) {
        this.charset = i5;
    }

    public int getValue() {
        return this.charset;
    }

    public static FontCharset valueOf(int i5) {
        FontCharset[] fontCharsetArr = _table;
        if (i5 >= fontCharsetArr.length) {
            return null;
        }
        return fontCharsetArr[i5];
    }
}

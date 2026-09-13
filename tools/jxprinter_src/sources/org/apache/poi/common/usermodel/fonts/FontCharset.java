package org.apache.poi.common.usermodel.fonts;

import com.google.zxing.common.StringUtils;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.logging.log4j.LogManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontCharset {
    ANSI(0, "Cp1252"),
    DEFAULT(1, "Cp1252"),
    SYMBOL(2, ""),
    MAC(77, "MacRoman"),
    SHIFTJIS(128, "Shift_JIS"),
    HANGUL(129, "cp949"),
    JOHAB(130, "x-Johab"),
    GB2312(134, StringUtils.GB2312),
    CHINESEBIG5(136, "Big5"),
    GREEK(161, "Cp1253"),
    TURKISH(162, "Cp1254"),
    VIETNAMESE(163, "Cp1258"),
    HEBREW(177, "Cp1255"),
    ARABIC(178, "Cp1256"),
    BALTIC(186, "Cp1257"),
    RUSSIAN(204, "Cp1251"),
    THAI(222, "x-windows-874"),
    EASTEUROPE(238, "Cp1250"),
    OEM(255, "Cp1252");

    private static FontCharset[] _table = new FontCharset[256];
    private Charset charset;
    private int nativeId;

    static {
        for (FontCharset fontCharset : values()) {
            _table[fontCharset.getNativeId()] = fontCharset;
        }
    }

    FontCharset(int i5, String str) {
        this.nativeId = i5;
        if (str.length() > 0) {
            try {
                this.charset = Charset.forName(str);
                return;
            } catch (UnsupportedCharsetException unused) {
                LogManager.getLogger((Class<?>) FontCharset.class).atWarn().log("Unsupported charset: {}", str);
            }
        }
        this.charset = null;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getNativeId() {
        return this.nativeId;
    }

    public static FontCharset valueOf(int i5) {
        if (i5 < 0) {
            return null;
        }
        FontCharset[] fontCharsetArr = _table;
        if (i5 >= fontCharsetArr.length) {
            return null;
        }
        return fontCharsetArr[i5];
    }
}

package org.apache.poi.ss.format;

import java.util.Locale;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CellFormatter {
    protected final String format;
    protected final Locale locale;

    public CellFormatter(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    public static String quote(String str) {
        return "\"" + str + Chars.DQUOTE;
    }

    public String format(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        formatValue(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public abstract void formatValue(StringBuffer stringBuffer, Object obj);

    public String simpleFormat(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        simpleValue(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public abstract void simpleValue(StringBuffer stringBuffer, Object obj);

    public CellFormatter(Locale locale, String str) {
        this.locale = locale;
        this.format = str;
    }
}

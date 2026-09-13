package org.apache.poi.ss.format;

import androidx.exifinterface.media.ExifInterface;
import java.util.Formatter;
import java.util.Locale;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellGeneralFormatter extends CellFormatter {
    public CellGeneralFormatter() {
        this(LocaleUtil.getUserLocale());
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    /* JADX WARN: Code duplicated, block: B:30:0x006c A[LOOP:0: B:28:0x0066->B:30:0x006c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x007b  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        String str;
        boolean z6;
        Formatter formatter;
        int length;
        int i5;
        if (!(obj instanceof Number)) {
            if (obj instanceof Boolean) {
                stringBuffer.append(obj.toString().toUpperCase(Locale.ROOT));
                return;
            } else {
                stringBuffer.append(obj);
                return;
            }
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dDoubleValue == 0.0d) {
            stringBuffer.append('0');
            return;
        }
        double dLog10 = Math.log10(Math.abs(dDoubleValue));
        try {
            if (dLog10 <= 10.0d && dLog10 >= -9.0d) {
                if (((long) dDoubleValue) != dDoubleValue) {
                    str = "%1.9f";
                } else {
                    str = "%1.0f";
                    z6 = false;
                }
                formatter = new Formatter(stringBuffer, this.locale);
                formatter.format(this.locale, str, obj);
                formatter.close();
                if (z6) {
                    if (str.endsWith(ExifInterface.LONGITUDE_EAST)) {
                        length = stringBuffer.lastIndexOf(ExifInterface.LONGITUDE_EAST);
                    } else {
                        length = stringBuffer.length();
                    }
                    i5 = length - 1;
                    while (stringBuffer.charAt(i5) == '0') {
                        stringBuffer.deleteCharAt(i5);
                        i5--;
                    }
                    if (stringBuffer.charAt(i5) == '.') {
                        stringBuffer.deleteCharAt(i5);
                        return;
                    }
                    return;
                }
                return;
            }
            str = "%1.5E";
            formatter.format(this.locale, str, obj);
            formatter.close();
            if (z6) {
                if (str.endsWith(ExifInterface.LONGITUDE_EAST)) {
                    length = stringBuffer.lastIndexOf(ExifInterface.LONGITUDE_EAST);
                } else {
                    length = stringBuffer.length();
                }
                i5 = length - 1;
                while (stringBuffer.charAt(i5) == '0') {
                    stringBuffer.deleteCharAt(i5);
                    i5--;
                }
                if (stringBuffer.charAt(i5) == '.') {
                    stringBuffer.deleteCharAt(i5);
                    return;
                }
                return;
            }
            return;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
        z6 = true;
        formatter = new Formatter(stringBuffer, this.locale);
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        formatValue(stringBuffer, obj);
    }

    public CellGeneralFormatter(Locale locale) {
        super(locale, "General");
    }
}

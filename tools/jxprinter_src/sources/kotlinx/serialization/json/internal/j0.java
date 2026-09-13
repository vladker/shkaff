package kotlinx.serialization.json.internal;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j0 {
    private static final byte[] ESCAPE_MARKERS;
    private static final String[] ESCAPE_STRINGS;

    static {
        String[] strArr = new String[93];
        for (int i5 = 0; i5 < 32; i5++) {
            strArr[i5] = "\\u" + a(i5 >> 12) + a(i5 >> 8) + a(i5 >> 4) + a(i5);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        ESCAPE_STRINGS = strArr;
        byte[] bArr = new byte[93];
        for (int i6 = 0; i6 < 32; i6++) {
            bArr[i6] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        ESCAPE_MARKERS = bArr;
    }

    public static final char a(int i5) {
        int i6 = i5 & 15;
        return (char) (i6 < 10 ? i6 + 48 : i6 + 87);
    }

    public static final byte[] getESCAPE_MARKERS() {
        return ESCAPE_MARKERS;
    }

    public static final String[] getESCAPE_STRINGS() {
        return ESCAPE_STRINGS;
    }

    public static final void printQuoted(StringBuilder sb, String value) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        sb.append(Chars.DQUOTE);
        int length = value.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char cCharAt = value.charAt(i6);
            String[] strArr = ESCAPE_STRINGS;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i5, i6);
                sb.append(strArr[cCharAt]);
                i5 = i6 + 1;
            }
        }
        if (i5 != 0) {
            sb.append((CharSequence) value, i5, value.length());
        } else {
            sb.append(value);
        }
        sb.append(Chars.DQUOTE);
    }

    public static final Boolean toBooleanStrictOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (X3.W.equals(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (X3.W.equals(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ void getESCAPE_STRINGS$annotations() {
    }
}

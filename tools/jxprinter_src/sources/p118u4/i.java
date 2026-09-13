package p118u4;

import java.net.ProtocolException;
import okhttp3.I;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f8744a;
    public final int b;
    public final String c;

    public i(I i5, int i6, String str) {
        this.f8744a = i5;
        this.b = i6;
        this.c = str;
    }

    public static i parse(String str) throws ProtocolException {
        int i5;
        String strSubstring;
        boolean zStartsWith = str.startsWith("HTTP/1.");
        I i6 = I.HTTP_1_0;
        if (zStartsWith) {
            i5 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                i6 = I.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i5 = 4;
        }
        int i7 = i5 + 3;
        if (str.length() < i7) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            int i8 = Integer.parseInt(str.substring(i5, i7));
            if (str.length() <= i7) {
                strSubstring = "";
            } else {
                if (str.charAt(i7) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i5 + 4);
            }
            return new i(i6, i8, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8744a == I.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(Chars.SPACE);
        sb.append(this.b);
        String str = this.c;
        if (str != null) {
            sb.append(Chars.SPACE);
            sb.append(str);
        }
        return sb.toString();
    }
}

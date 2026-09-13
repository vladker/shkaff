package kotlinx.serialization.json.internal;

import com.google.common.base.Ascii;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1137m {
    public static final C1137m INSTANCE = new C1137m();
    public static final char[] ESCAPE_2_CHAR = new char[117];
    public static final byte[] CHAR_TO_TOKEN = new byte[126];

    static {
        for (int i5 = 0; i5 < 32; i5++) {
        }
        a('b', 8);
        a('t', 9);
        a('n', 10);
        a('f', 12);
        a('r', 13);
        a('/', 47);
        a(Chars.DQUOTE, 34);
        a(IOUtils.DIR_SEPARATOR_WINDOWS, 92);
        INSTANCE.getClass();
        for (int i6 = 0; i6 < 33; i6++) {
            CHAR_TO_TOKEN[i6] = Ascii.DEL;
        }
        byte[] bArr = CHAR_TO_TOKEN;
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void a(char c, int i5) {
        if (c != 'u') {
            ESCAPE_2_CHAR[c] = (char) i5;
        }
    }
}

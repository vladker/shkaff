package okhttp3.internal.http2;

import A3.AbstractC0157z;
import A4.C0173p;
import java.io.IOException;
import java.util.Locale;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: okhttp3.internal.http2.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC1363g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0173p f6614a = C0173p.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] c = new String[64];
    public static final String[] d = new String[256];

    static {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = d;
            if (i6 >= strArr.length) {
                break;
            }
            Object[] objArr = {Integer.toBinaryString(i6)};
            byte[] bArr = p107s4.d.f8235a;
            strArr[i6] = String.format(Locale.US, "%8s", objArr).replace(Chars.SPACE, '0');
            i6++;
        }
        String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i7 = iArr[0];
        strArr2[i7 | 8] = AbstractC0157z.s(new StringBuilder(), strArr2[i7], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            int i10 = iArr[0];
            String[] strArr3 = c;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i10]);
            sb.append('|');
            strArr3[i11 | 8] = AbstractC0157z.s(sb, strArr3[i9], "|PADDED");
        }
        while (true) {
            String[] strArr4 = c;
            if (i5 >= strArr4.length) {
                return;
            }
            if (strArr4[i5] == null) {
                strArr4[i5] = d[i5];
            }
            i5++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    public static String a(boolean z6, int i5, int i6, byte b6, byte b7) {
        String str;
        String strReplace;
        String[] strArr = b;
        if (b6 < strArr.length) {
            str = strArr[b6];
        } else {
            Object[] objArr = {Byte.valueOf(b6)};
            byte[] bArr = p107s4.d.f8235a;
            str = String.format(Locale.US, "0x%02x", objArr);
        }
        if (b7 == 0) {
            strReplace = "";
        } else {
            String[] strArr2 = d;
            if (b6 == 2 || b6 == 3) {
                strReplace = strArr2[b7];
            } else if (b6 == 4 || b6 == 6) {
                strReplace = b7 == 1 ? "ACK" : strArr2[b7];
            } else if (b6 == 7 || b6 == 8) {
                strReplace = strArr2[b7];
            } else {
                String[] strArr3 = c;
                String str2 = b7 < strArr3.length ? strArr3[b7] : strArr2[b7];
                if (b6 != 5 || (b7 & 4) == 0) {
                    strReplace = (b6 != 0 || (b7 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED");
                } else {
                    strReplace = str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
        }
        Object[] objArr2 = {z6 ? "<<" : ">>", Integer.valueOf(i5), Integer.valueOf(i6), str, strReplace};
        byte[] bArr2 = p107s4.d.f8235a;
        return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", objArr2);
    }

    public static void b(String str, Object... objArr) {
        byte[] bArr = p107s4.d.f8235a;
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static IOException ioException(String str, Object... objArr) throws IOException {
        byte[] bArr = p107s4.d.f8235a;
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}

package A4;

import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;

/* JADX INFO: renamed from: A4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0158a {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        C0172o c0172o = C0173p.Companion;
        BASE64 = c0172o.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = c0172o.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i5;
        char cCharAt;
        kotlin.jvm.internal.E.f(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i6 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i6];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt2 = str.charAt(i10);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i5 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i5 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i5 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i5 = 62;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '_') {
                    i5 = 63;
                } else if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i8 = (i8 << 6) | i5;
            i7++;
            if (i7 % 4 == 0) {
                bArr[i9] = (byte) (i8 >> 16);
                int i11 = i9 + 2;
                bArr[i9 + 1] = (byte) (i8 >> 8);
                i9 += 3;
                bArr[i11] = (byte) i8;
            }
        }
        int i12 = i7 % 4;
        if (i12 == 1) {
            return null;
        }
        if (i12 == 2) {
            bArr[i9] = (byte) ((i8 << 12) >> 16);
            i9++;
        } else if (i12 == 3) {
            int i13 = i8 << 6;
            int i14 = i9 + 1;
            bArr[i9] = (byte) (i13 >> 16);
            i9 += 2;
            bArr[i14] = (byte) (i13 >> 8);
        }
        if (i9 == i6) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i9);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String encodeBase64(byte[] bArr, byte[] map) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b = bArr[i5];
            int i7 = i5 + 2;
            byte b6 = bArr[i5 + 1];
            i5 += 3;
            byte b7 = bArr[i7];
            bArr2[i6] = map[(b & UnsignedBytes.MAX_VALUE) >> 2];
            bArr2[i6 + 1] = map[((b & 3) << 4) | ((b6 & UnsignedBytes.MAX_VALUE) >> 4)];
            int i8 = i6 + 3;
            bArr2[i6 + 2] = map[((b6 & 15) << 2) | ((b7 & UnsignedBytes.MAX_VALUE) >> 6)];
            i6 += 4;
            bArr2[i8] = map[b7 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b8 = bArr[i5];
            bArr2[i6] = map[(b8 & UnsignedBytes.MAX_VALUE) >> 2];
            bArr2[i6 + 1] = map[(b8 & 3) << 4];
            bArr2[i6 + 2] = DeletedArea3DPtg.sid;
            bArr2[i6 + 3] = DeletedArea3DPtg.sid;
        } else if (length2 == 2) {
            int i9 = i5 + 1;
            byte b9 = bArr[i5];
            byte b10 = bArr[i9];
            bArr2[i6] = map[(b9 & UnsignedBytes.MAX_VALUE) >> 2];
            bArr2[i6 + 1] = map[((b9 & 3) << 4) | ((b10 & UnsignedBytes.MAX_VALUE) >> 4)];
            bArr2[i6 + 2] = map[(b10 & 15) << 2];
            bArr2[i6 + 3] = DeletedArea3DPtg.sid;
        }
        return n0.toUtf8String(bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}

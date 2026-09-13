package B4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i5;
        char cCharAt;
        E.f(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            char cCharAt2 = str.charAt(i6);
            if (E.h(cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i7 = i6;
                while (i6 < length2) {
                    char cCharAt3 = str.charAt(i6);
                    if (E.h(cCharAt3, 128) < 0) {
                        int i8 = i7 + 1;
                        bArr[i7] = (byte) cCharAt3;
                        i6++;
                        while (true) {
                            i7 = i8;
                            if (i6 >= length2 || E.h(str.charAt(i6), 128) >= 0) {
                                break;
                            }
                            i8 = i7 + 1;
                            bArr[i7] = (byte) str.charAt(i6);
                            i6++;
                        }
                    } else {
                        if (E.h(cCharAt3, 2048) < 0) {
                            bArr[i7] = (byte) ((cCharAt3 >> 6) | 192);
                            i7 += 2;
                            bArr[i7 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || cCharAt3 >= 57344) {
                            bArr[i7] = (byte) ((cCharAt3 >> '\f') | 224);
                            bArr[i7 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i7 += 3;
                            bArr[i7 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (E.h(cCharAt3, 56319) > 0 || length2 <= (i5 = i6 + 1) || 56320 > (cCharAt = str.charAt(i5)) || cCharAt >= 57344) {
                            bArr[i7] = 63;
                            i6++;
                            i7++;
                        } else {
                            int iCharAt = (str.charAt(i5) + (cCharAt3 << '\n')) - 56613888;
                            bArr[i7] = (byte) ((iCharAt >> 18) | 240);
                            bArr[i7 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i7 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i7 += 4;
                            bArr[i7 + 3] = (byte) ((iCharAt & 63) | 128);
                            i6 += 2;
                        }
                        i6++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i7);
                E.e(bArrCopyOf, "copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i6] = (byte) cCharAt2;
            i6++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        E.e(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
    
        if ((r16[r5] & 192) == 128) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ec, code lost:
    
        if ((r16[r5] & 192) == 128) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B4.u.commonToUtf8String(byte[], int, int):java.lang.String");
    }
}

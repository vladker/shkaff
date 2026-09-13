package org.apache.commons.compress.archivers.cpio;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class CpioUtil {
    public static long byteArray2long(byte[] bArr, boolean z6) {
        if (bArr.length % 2 != 0) {
            throw new UnsupportedOperationException();
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        if (!z6) {
            for (int i5 = 0; i5 < length; i5 += 2) {
                byte b = bArr2[i5];
                int i6 = i5 + 1;
                bArr2[i5] = bArr2[i6];
                bArr2[i6] = b;
            }
        }
        long j6 = bArr2[0] & UnsignedBytes.MAX_VALUE;
        for (int i7 = 1; i7 < length; i7++) {
            j6 = (j6 << 8) | ((long) (bArr2[i7] & UnsignedBytes.MAX_VALUE));
        }
        return j6;
    }

    public static long fileType(long j6) {
        return j6 & 61440;
    }

    public static byte[] long2byteArray(long j6, int i5, boolean z6) {
        byte[] bArr = new byte[i5];
        if (i5 % 2 != 0 || i5 < 2) {
            throw new UnsupportedOperationException();
        }
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            bArr[i6] = (byte) (255 & j6);
            j6 >>= 8;
        }
        if (!z6) {
            for (int i7 = 0; i7 < i5; i7 += 2) {
                byte b = bArr[i7];
                int i8 = i7 + 1;
                bArr[i7] = bArr[i8];
                bArr[i8] = b;
            }
        }
        return bArr;
    }
}

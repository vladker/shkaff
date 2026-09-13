package org.apache.commons.codec.digest;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MurmurHash2 {
    private static final int M32 = 1540483477;
    private static final long M64 = -4132994306676758123L;
    private static final int R32 = 24;
    private static final int R64 = 47;

    private MurmurHash2() {
    }

    private static int getLittleEndianInt(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i5] & UnsignedBytes.MAX_VALUE) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i5) {
        return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
    }

    public static int hash32(byte[] bArr, int i5, int i6) {
        int i7 = i6 ^ i5;
        int i8 = i5 >> 2;
        for (int i9 = 0; i9 < i8; i9++) {
            int littleEndianInt = getLittleEndianInt(bArr, i9 << 2) * M32;
            i7 = (i7 * M32) ^ ((littleEndianInt ^ (littleEndianInt >>> 24)) * M32);
        }
        int i10 = i8 << 2;
        int i11 = i5 - i10;
        if (i11 == 1) {
            i7 = ((bArr[i10] & 255) ^ i7) * M32;
        } else {
            if (i11 != 2) {
                if (i11 == 3) {
                    i7 ^= (bArr[i10 + 2] & 255) << 16;
                }
            }
            i7 ^= (bArr[i10 + 1] & 255) << 8;
            i7 = ((bArr[i10] & 255) ^ i7) * M32;
        }
        int i12 = ((i7 >>> 13) ^ i7) * M32;
        return i12 ^ (i12 >>> 15);
    }

    public static long hash64(byte[] bArr, int i5, int i6) {
        long j6 = (((long) i6) & KeyboardMap.kValueMask) ^ (((long) i5) * M64);
        int i7 = i5 >> 3;
        for (int i8 = 0; i8 < i7; i8++) {
            long littleEndianLong = getLittleEndianLong(bArr, i8 << 3) * M64;
            j6 = (j6 ^ ((littleEndianLong ^ (littleEndianLong >>> 47)) * M64)) * M64;
        }
        int i9 = i7 << 3;
        switch (i5 - i9) {
            case 7:
                j6 ^= (((long) bArr[i9 + 6]) & 255) << 48;
            case 6:
                j6 ^= (((long) bArr[i9 + 5]) & 255) << 40;
            case 5:
                j6 ^= (((long) bArr[i9 + 4]) & 255) << 32;
            case 4:
                j6 ^= (((long) bArr[i9 + 3]) & 255) << 24;
            case 3:
                j6 ^= (((long) bArr[i9 + 2]) & 255) << 16;
            case 2:
                j6 ^= (((long) bArr[i9 + 1]) & 255) << 8;
            case 1:
                j6 = ((((long) bArr[i9]) & 255) ^ j6) * M64;
                break;
        }
        long j7 = ((j6 >>> 47) ^ j6) * M64;
        return j7 ^ (j7 >>> 47);
    }

    public static int hash32(byte[] bArr, int i5) {
        return hash32(bArr, i5, -1756908916);
    }

    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, bytesUtf8.length);
    }

    public static int hash32(String str, int i5, int i6) {
        return hash32(str.substring(i5, i6 + i5));
    }

    public static long hash64(byte[] bArr, int i5) {
        return hash64(bArr, i5, -512093083);
    }

    public static long hash64(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash64(bytesUtf8, bytesUtf8.length);
    }

    public static long hash64(String str, int i5, int i6) {
        return hash64(str.substring(i5, i6 + i5));
    }
}

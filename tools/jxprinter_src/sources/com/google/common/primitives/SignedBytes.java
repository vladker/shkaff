package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int iMin = Math.min(bArr.length, bArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int iCompare = SignedBytes.compare(bArr[i5], bArr2[i5]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long j6) {
        byte b = (byte) j6;
        Preconditions.checkArgument(((long) b) == j6, "Out of range: %s", j6);
        return b;
    }

    public static int compare(byte b, byte b6) {
        return b - b6;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i5 = 1; i5 < bArr.length; i5++) {
            sb.append(str);
            sb.append((int) bArr[i5]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i5 = 1; i5 < bArr.length; i5++) {
            byte b6 = bArr[i5];
            if (b6 > b) {
                b = b6;
            }
        }
        return b;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i5 = 1; i5 < bArr.length; i5++) {
            byte b6 = bArr[i5];
            if (b6 < b) {
                b = b6;
            }
        }
        return b;
    }

    public static byte saturatedCast(long j6) {
        if (j6 > 127) {
            return Ascii.DEL;
        }
        return j6 < -128 ? UnsignedBytes.MAX_POWER_OF_TWO : (byte) j6;
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i5, int i6) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i5, i6, bArr.length);
        Arrays.sort(bArr, i5, i6);
        Bytes.reverse(bArr, i5, i6);
    }
}

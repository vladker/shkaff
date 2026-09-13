package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    static final int DEFAULT_SIZE = 3;
    static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    static final int MAX_SIZE = 1073741823;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    static final byte UNSET = 0;

    private CompactHashing() {
    }

    public static Object createTable(int i5) {
        if (i5 < 2 || i5 > 1073741824 || Integer.highestOneBit(i5) != i5) {
            throw new IllegalArgumentException(com.google.android.gms.auth.api.accounttransfer.a.h(52, i5, "must be power of 2 between 2^1 and 2^30: "));
        }
        if (i5 <= 256) {
            return new byte[i5];
        }
        return i5 <= 65536 ? new short[i5] : new int[i5];
    }

    public static int getHashPrefix(int i5, int i6) {
        return i5 & (~i6);
    }

    public static int getNext(int i5, int i6) {
        return i5 & i6;
    }

    public static int maskCombine(int i5, int i6, int i7) {
        return (i5 & (~i7)) | (i6 & i7);
    }

    public static int newCapacity(int i5) {
        return (i5 + 1) * (i5 < 32 ? 4 : 2);
    }

    public static int remove(Object obj, Object obj2, int i5, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iSmearedHash = Hashing.smearedHash(obj);
        int i6 = iSmearedHash & i5;
        int iTableGet = tableGet(obj3, i6);
        if (iTableGet == 0) {
            return -1;
        }
        int hashPrefix = getHashPrefix(iSmearedHash, i5);
        int i7 = -1;
        while (true) {
            int i8 = iTableGet - 1;
            int i9 = iArr[i8];
            if (getHashPrefix(i9, i5) == hashPrefix && Objects.equal(obj, objArr[i8]) && (objArr2 == null || Objects.equal(obj2, objArr2[i8]))) {
                int next = getNext(i9, i5);
                if (i7 == -1) {
                    tableSet(obj3, i6, next);
                    return i8;
                }
                iArr[i7] = maskCombine(iArr[i7], next, i5);
                return i8;
            }
            int next2 = getNext(i9, i5);
            if (next2 == 0) {
                return -1;
            }
            i7 = i8;
            iTableGet = next2;
        }
    }

    public static void tableClear(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int tableGet(Object obj, int i5) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i5] & UnsignedBytes.MAX_VALUE;
        }
        return obj instanceof short[] ? ((short[]) obj)[i5] & 65535 : ((int[]) obj)[i5];
    }

    public static void tableSet(Object obj, int i5, int i6) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i5] = (byte) i6;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i5] = (short) i6;
        } else {
            ((int[]) obj)[i5] = i6;
        }
    }

    public static int tableSize(int i5) {
        return Math.max(4, Hashing.closedTableSize(i5 + 1, 1.0d));
    }
}

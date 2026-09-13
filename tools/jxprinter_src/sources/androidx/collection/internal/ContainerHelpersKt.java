package androidx.collection.internal;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(int[] array, int i5, int i6) {
        E.f(array, "array");
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = array[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else {
                if (i10 <= i6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static final boolean equal(Object obj, Object obj2) {
        return E.a(obj, obj2);
    }

    public static final int idealByteArraySize(int i5) {
        for (int i6 = 4; i6 < 32; i6++) {
            int i7 = (1 << i6) - 12;
            if (i5 <= i7) {
                return i7;
            }
        }
        return i5;
    }

    public static final int idealIntArraySize(int i5) {
        return idealByteArraySize(i5 * 4) / 4;
    }

    public static final int idealLongArraySize(int i5) {
        return idealByteArraySize(i5 * 8) / 8;
    }

    public static final int binarySearch(long[] array, int i5, long j6) {
        E.f(array, "array");
        int i6 = i5 - 1;
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) >>> 1;
            long j7 = array[i8];
            if (j7 < j6) {
                i7 = i8 + 1;
            } else {
                if (j7 <= j6) {
                    return i8;
                }
                i6 = i8 - 1;
            }
        }
        return ~i7;
    }
}

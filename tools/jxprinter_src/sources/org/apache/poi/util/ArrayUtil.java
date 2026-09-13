package org.apache.poi.util;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class ArrayUtil {
    private ArrayUtil() {
    }

    public static void arrayMoveWithin(Object[] objArr, int i5, int i6, int i7) {
        Object[] objArrCopyOfRange;
        if (i7 > 0 && i5 != i6) {
            if (i5 < 0 || i5 >= objArr.length) {
                throw new IllegalArgumentException("The moveFrom must be a valid array index");
            }
            if (i6 < 0 || i6 >= objArr.length) {
                throw new IllegalArgumentException("The moveTo must be a valid array index");
            }
            int i8 = i5 + i7;
            if (i8 > objArr.length) {
                throw new IllegalArgumentException("Asked to move more entries than the array has");
            }
            int i9 = i7 + i6;
            if (i9 > objArr.length) {
                throw new IllegalArgumentException("Asked to move to a position that doesn't have enough space");
            }
            Object[] objArrCopyOfRange2 = Arrays.copyOfRange(objArr, i5, i8);
            if (i5 > i6) {
                objArrCopyOfRange = Arrays.copyOfRange(objArr, i6, i5);
            } else {
                Object[] objArrCopyOfRange3 = Arrays.copyOfRange(objArr, i8, i9);
                i9 = i5;
                objArrCopyOfRange = objArrCopyOfRange3;
            }
            System.arraycopy(objArrCopyOfRange2, 0, objArr, i6, objArrCopyOfRange2.length);
            System.arraycopy(objArrCopyOfRange, 0, objArr, i9, objArrCopyOfRange.length);
        }
    }
}

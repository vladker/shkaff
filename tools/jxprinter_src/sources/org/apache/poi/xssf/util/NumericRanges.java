package org.apache.poi.xssf.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NumericRanges {
    public static final int NO_OVERLAPS = -1;
    public static final int OVERLAPS_1_MINOR = 0;
    public static final int OVERLAPS_1_WRAPS = 2;
    public static final int OVERLAPS_2_MINOR = 1;
    public static final int OVERLAPS_2_WRAPS = 3;

    public static long[] getOverlappingRange(long[] jArr, long[] jArr2) {
        int overlappingType = getOverlappingType(jArr, jArr2);
        if (overlappingType == 0) {
            return new long[]{jArr2[0], jArr[1]};
        }
        if (overlappingType == 1) {
            return new long[]{jArr[0], jArr2[1]};
        }
        if (overlappingType != 2) {
            return overlappingType != 3 ? new long[]{-1, -1} : jArr;
        }
        return jArr2;
    }

    public static int getOverlappingType(long[] jArr, long[] jArr2) {
        long j6 = jArr[0];
        long j7 = jArr[1];
        long j8 = jArr2[0];
        long j9 = jArr2[1];
        if (j6 >= j8) {
            if (j7 <= j9) {
                return 3;
            }
            return j6 <= j9 ? 1 : -1;
        }
        if (j7 >= j9) {
            return 2;
        }
        return j7 >= j8 ? 0 : -1;
    }
}

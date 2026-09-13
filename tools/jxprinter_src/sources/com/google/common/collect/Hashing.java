package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Hashing {

    /* JADX INFO: renamed from: C1, reason: collision with root package name */
    private static final long f3403C1 = -862048943;

    /* JADX INFO: renamed from: C2, reason: collision with root package name */
    private static final long f3404C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    public static int closedTableSize(int i5, double d) {
        int iMax = Math.max(i5, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i6 = iHighestOneBit << 1;
        if (i6 > 0) {
            return i6;
        }
        return 1073741824;
    }

    public static boolean needsResizing(int i5, int i6, double d) {
        return ((double) i5) > d * ((double) i6) && i6 < 1073741824;
    }

    public static int smear(int i5) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i5) * f3403C1), 15)) * f3404C2);
    }

    public static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}

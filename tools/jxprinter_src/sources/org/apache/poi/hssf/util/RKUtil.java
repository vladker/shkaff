package org.apache.poi.hssf.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RKUtil {
    private RKUtil() {
    }

    public static double decodeNumber(int i5) {
        long j6 = ((long) i5) >> 2;
        double dLongBitsToDouble = (i5 & 2) == 2 ? j6 : Double.longBitsToDouble(j6 << 34);
        return (i5 & 1) == 1 ? dLongBitsToDouble / 100.0d : dLongBitsToDouble;
    }
}

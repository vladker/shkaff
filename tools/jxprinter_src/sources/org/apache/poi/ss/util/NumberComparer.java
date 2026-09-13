package org.apache.poi.ss.util;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class NumberComparer {
    public static int compare(double d, double d6) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(d6);
        int biasedExponent = IEEEDouble.getBiasedExponent(jDoubleToLongBits);
        int biasedExponent2 = IEEEDouble.getBiasedExponent(jDoubleToLongBits2);
        if (biasedExponent == 2047) {
            throw new IllegalArgumentException("Special double values are not allowed: " + toHex(d));
        }
        if (biasedExponent2 == 2047) {
            throw new IllegalArgumentException("Special double values are not allowed: " + toHex(d));
        }
        boolean z6 = jDoubleToLongBits < 0;
        if (z6 != (jDoubleToLongBits2 < 0)) {
            return z6 ? -1 : 1;
        }
        int i5 = biasedExponent - biasedExponent2;
        int iAbs = Math.abs(i5);
        if (iAbs > 1) {
            return z6 ? -i5 : i5;
        }
        if (iAbs != 1 && jDoubleToLongBits == jDoubleToLongBits2) {
            return 0;
        }
        if (biasedExponent == 0) {
            return biasedExponent2 == 0 ? compareSubnormalNumbers(jDoubleToLongBits & IEEEDouble.FRAC_MASK, IEEEDouble.FRAC_MASK & jDoubleToLongBits2, z6) : -compareAcrossSubnormalThreshold(jDoubleToLongBits2, jDoubleToLongBits, z6);
        }
        if (biasedExponent2 == 0) {
            return compareAcrossSubnormalThreshold(jDoubleToLongBits, jDoubleToLongBits2, z6);
        }
        int iCompareNormalised = ExpandedDouble.fromRawBitsAndExponent(jDoubleToLongBits, biasedExponent - 1023).normaliseBaseTen().roundUnits().compareNormalised(ExpandedDouble.fromRawBitsAndExponent(jDoubleToLongBits2, biasedExponent2 - 1023).normaliseBaseTen().roundUnits());
        return z6 ? -iCompareNormalised : iCompareNormalised;
    }

    private static int compareAcrossSubnormalThreshold(long j6, long j7, boolean z6) {
        long j8 = j7 & IEEEDouble.FRAC_MASK;
        if (j8 == 0) {
            return z6 ? -1 : 1;
        }
        long j9 = j6 & IEEEDouble.FRAC_MASK;
        if (j9 > 7 || j8 < 4503599627370490L) {
            return z6 ? -1 : 1;
        }
        if (j9 == 7 && j8 == 4503599627370490L) {
            return 0;
        }
        return z6 ? 1 : -1;
    }

    private static int compareSubnormalNumbers(long j6, long j7, boolean z6) {
        return z6 ? Long.compare(j7, j6) : Long.compare(j6, j7);
    }

    private static String toHex(double d) {
        return "0x" + Long.toHexString(Double.doubleToLongBits(d)).toUpperCase(Locale.ROOT);
    }
}

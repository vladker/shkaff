package org.apache.poi.ss.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class IEEEDouble {
    public static final int BIASED_EXPONENT_SPECIAL_VALUE = 2047;
    public static final int EXPONENT_BIAS = 1023;
    private static final long EXPONENT_MASK = 9218868437227405312L;
    private static final int EXPONENT_SHIFT = 52;
    public static final long FRAC_ASSUMED_HIGH_BIT = 4503599627370496L;
    public static final long FRAC_MASK = 4503599627370495L;

    public static int getBiasedExponent(long j6) {
        return Math.toIntExact((j6 & EXPONENT_MASK) >> 52);
    }
}

package org.apache.poi.ss.util;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ExpandedDouble {
    private static final BigInteger BI_FRAC_MASK = BigInteger.valueOf(IEEEDouble.FRAC_MASK);
    private static final BigInteger BI_IMPLIED_FRAC_MSB = BigInteger.valueOf(IEEEDouble.FRAC_ASSUMED_HIGH_BIT);
    private final int _binaryExponent;
    private final BigInteger _significand;

    public ExpandedDouble(long j6) {
        int intExact = Math.toIntExact(j6 >> 52);
        if (intExact != 0) {
            this._significand = getFrac(j6);
            this._binaryExponent = (intExact & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) - 1023;
        } else {
            BigInteger bigIntegerAnd = BigInteger.valueOf(j6).and(BI_FRAC_MASK);
            int iBitLength = 64 - bigIntegerAnd.bitLength();
            this._significand = bigIntegerAnd.shiftLeft(iBitLength);
            this._binaryExponent = (-1023) - iBitLength;
        }
    }

    public static ExpandedDouble fromRawBitsAndExponent(long j6, int i5) {
        return new ExpandedDouble(getFrac(j6), i5);
    }

    private static BigInteger getFrac(long j6) {
        return BigInteger.valueOf(j6).and(BI_FRAC_MASK).or(BI_IMPLIED_FRAC_MSB).shiftLeft(11);
    }

    public int getBinaryExponent() {
        return this._binaryExponent;
    }

    public BigInteger getSignificand() {
        return this._significand;
    }

    public NormalisedDecimal normaliseBaseTen() {
        return NormalisedDecimal.create(this._significand, this._binaryExponent);
    }

    public ExpandedDouble(BigInteger bigInteger, int i5) {
        if (bigInteger.bitLength() == 64) {
            this._significand = bigInteger;
            this._binaryExponent = i5;
            return;
        }
        throw new IllegalArgumentException("bad bit length");
    }
}

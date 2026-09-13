package org.apache.poi.ss.util;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class MutableFPNumber {
    private static final int C_64 = 64;
    private static final int MIN_PRECISION = 72;
    private int _binaryExponent;
    private BigInteger _significand;
    private static final BigInteger BI_MIN_BASE = new BigInteger("0B5E620F47FFFE666", 16);
    private static final BigInteger BI_MAX_BASE = new BigInteger("0E35FA9319FFFE000", 16);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Rounder {
        private static final BigInteger[] HALF_BITS;

        static {
            BigInteger[] bigIntegerArr = new BigInteger[33];
            long j6 = 1;
            for (int i5 = 1; i5 < 33; i5++) {
                bigIntegerArr[i5] = BigInteger.valueOf(j6);
                j6 <<= 1;
            }
            HALF_BITS = bigIntegerArr;
        }

        private Rounder() {
        }

        public static BigInteger round(BigInteger bigInteger, int i5) {
            return i5 < 1 ? bigInteger : bigInteger.add(HALF_BITS[i5]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TenPower {
        private static final BigInteger FIVE = BigInteger.valueOf(5);
        private static final TenPower[] _cache = new TenPower[350];
        public final BigInteger _divisor;
        public final int _divisorShift;
        public final BigInteger _multiplicand;
        public final int _multiplierShift;

        private TenPower(int i5) {
            BigInteger bigIntegerPow = FIVE.pow(i5);
            int iBitLength = bigIntegerPow.bitLength();
            BigInteger bigIntegerDivide = BigInteger.ONE.shiftLeft(iBitLength + 80).divide(bigIntegerPow);
            int iBitLength2 = bigIntegerDivide.bitLength() - 80;
            this._divisor = bigIntegerDivide.shiftRight(iBitLength2);
            this._divisorShift = -((iBitLength - iBitLength2) + i5 + 80);
            int iBitLength3 = bigIntegerPow.bitLength() - 68;
            if (iBitLength3 > 0) {
                this._multiplierShift = i5 + iBitLength3;
                this._multiplicand = bigIntegerPow.shiftRight(iBitLength3);
            } else {
                this._multiplierShift = i5;
                this._multiplicand = bigIntegerPow;
            }
        }

        public static TenPower getInstance(int i5) {
            TenPower[] tenPowerArr = _cache;
            TenPower tenPower = tenPowerArr[i5];
            if (tenPower != null) {
                return tenPower;
            }
            TenPower tenPower2 = new TenPower(i5);
            tenPowerArr[i5] = tenPower2;
            return tenPower2;
        }
    }

    public MutableFPNumber(BigInteger bigInteger, int i5) {
        this._significand = bigInteger;
        this._binaryExponent = i5;
    }

    private void mulShift(BigInteger bigInteger, int i5) {
        BigInteger bigIntegerMultiply = this._significand.multiply(bigInteger);
        this._significand = bigIntegerMultiply;
        this._binaryExponent += i5;
        int iBitLength = (bigIntegerMultiply.bitLength() - 72) & (-32);
        if (iBitLength > 0) {
            this._significand = this._significand.shiftRight(iBitLength);
            this._binaryExponent += iBitLength;
        }
    }

    public MutableFPNumber copy() {
        return new MutableFPNumber(this._significand, this._binaryExponent);
    }

    public ExpandedDouble createExpandedDouble() {
        return new ExpandedDouble(this._significand, this._binaryExponent);
    }

    public NormalisedDecimal createNormalisedDecimal(int i5) {
        return new NormalisedDecimal(this._significand.shiftRight(63 - this._binaryExponent).longValue(), (this._significand.intValue() << (this._binaryExponent - 39)) & 16777088, i5);
    }

    public int get64BitNormalisedExponent() {
        return (this._significand.bitLength() + this._binaryExponent) - 64;
    }

    public boolean isAboveMinRep() {
        return this._significand.compareTo(BI_MIN_BASE.shiftLeft(this._significand.bitLength() + (-64))) > 0;
    }

    public boolean isBelowMaxRep() {
        return this._significand.compareTo(BI_MAX_BASE.shiftLeft(this._significand.bitLength() + (-64))) < 0;
    }

    public void multiplyByPowerOfTen(int i5) {
        TenPower tenPower = TenPower.getInstance(Math.abs(i5));
        if (i5 < 0) {
            mulShift(tenPower._divisor, tenPower._divisorShift);
        } else {
            mulShift(tenPower._multiplicand, tenPower._multiplierShift);
        }
    }

    public void normalise64bit() {
        int iBitLength = this._significand.bitLength();
        int i5 = iBitLength - 64;
        if (i5 == 0) {
            return;
        }
        if (i5 < 0) {
            throw new IllegalStateException("Not enough precision");
        }
        this._binaryExponent += i5;
        if (i5 > 32) {
            int i6 = (iBitLength - 65) & 16777184;
            this._significand = this._significand.shiftRight(i6);
            i5 -= i6;
            iBitLength -= i6;
        }
        if (i5 < 1) {
            throw new IllegalStateException();
        }
        BigInteger bigIntegerRound = Rounder.round(this._significand, i5);
        this._significand = bigIntegerRound;
        if (bigIntegerRound.bitLength() > iBitLength) {
            i5++;
            this._binaryExponent++;
        }
        this._significand = this._significand.shiftRight(i5);
    }
}

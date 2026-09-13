package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class NormalisedDecimal {
    private static final BigDecimal BD_2_POW_24 = new BigDecimal(BigInteger.ONE.shiftLeft(24));
    private static final int C_2_POW_19 = 524288;
    private static final int EXPONENT_OFFSET = 14;
    private static final int FRAC_HALF = 8388608;
    private static final int LOG_BASE_10_OF_2_TIMES_2_POW_20 = 315653;
    private static final long MAX_REP_WHOLE_PART = 1000000000000000L;
    private final int _fractionalPart;
    private final int _relativeDecimalExponent;
    private final long _wholePart;

    public NormalisedDecimal(long j6, int i5, int i6) {
        this._wholePart = j6;
        this._fractionalPart = i5;
        this._relativeDecimalExponent = i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0045  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    public static NormalisedDecimal create(BigInteger bigInteger, int i5) {
        int i6 = (i5 > 49 || i5 < 46) ? -((15728640 - (LOG_BASE_10_OF_2_TIMES_2_POW_20 * i5)) >> 20) : 0;
        MutableFPNumber mutableFPNumber = new MutableFPNumber(bigInteger, i5);
        if (i6 != 0) {
            mutableFPNumber.multiplyByPowerOfTen(-i6);
        }
        switch (mutableFPNumber.get64BitNormalisedExponent()) {
            case 44:
            case 45:
                mutableFPNumber.multiplyByPowerOfTen(1);
                i6--;
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i6);
            case 46:
                if (!mutableFPNumber.isAboveMinRep()) {
                    mutableFPNumber.multiplyByPowerOfTen(1);
                    i6--;
                }
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i6);
            case 47:
            case 48:
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i6);
            case 49:
                if (!mutableFPNumber.isBelowMaxRep()) {
                    mutableFPNumber.multiplyByPowerOfTen(-1);
                    i6++;
                }
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i6);
            case 50:
                mutableFPNumber.multiplyByPowerOfTen(-1);
                i6++;
                mutableFPNumber.normalise64bit();
                return mutableFPNumber.createNormalisedDecimal(i6);
            default:
                throw new IllegalStateException(AbstractC0157z.l(Consts.DOT, mutableFPNumber.get64BitNormalisedExponent(), new StringBuilder("Bad binary exp ")));
        }
    }

    private String getFractionalDigits() {
        return this._fractionalPart == 0 ? "0" : getFractionalPart().toString().substring(2);
    }

    public int compareNormalised(NormalisedDecimal normalisedDecimal) {
        int i5 = this._relativeDecimalExponent - normalisedDecimal._relativeDecimalExponent;
        if (i5 != 0) {
            return i5;
        }
        long j6 = this._wholePart;
        long j7 = normalisedDecimal._wholePart;
        if (j6 > j7) {
            return 1;
        }
        if (j6 < j7) {
            return -1;
        }
        return this._fractionalPart - normalisedDecimal._fractionalPart;
    }

    public BigInteger composeFrac() {
        return BigInteger.valueOf(this._wholePart).shiftLeft(24).or(BigInteger.valueOf(this._fractionalPart & 16777215));
    }

    public int getDecimalExponent() {
        return this._relativeDecimalExponent + 14;
    }

    public BigDecimal getFractionalPart() {
        return BigDecimal.valueOf(this._fractionalPart).divide(BD_2_POW_24);
    }

    public String getSignificantDecimalDigits() {
        return Long.toString(this._wholePart);
    }

    public String getSignificantDecimalDigitsLastDigitRounded() {
        long j6 = this._wholePart + 5;
        StringBuilder sb = new StringBuilder(24);
        sb.append(j6);
        sb.setCharAt(sb.length() - 1, '0');
        return sb.toString();
    }

    public ExpandedDouble normaliseBaseTwo() {
        MutableFPNumber mutableFPNumber = new MutableFPNumber(composeFrac(), 39);
        mutableFPNumber.multiplyByPowerOfTen(this._relativeDecimalExponent);
        mutableFPNumber.normalise64bit();
        return mutableFPNumber.createExpandedDouble();
    }

    public NormalisedDecimal roundUnits() {
        long j6 = this._wholePart;
        if (this._fractionalPart >= 8388608) {
            j6++;
        }
        int i5 = this._relativeDecimalExponent;
        return j6 < MAX_REP_WHOLE_PART ? new NormalisedDecimal(j6, 0, i5) : new NormalisedDecimal(j6 / 10, 0, i5 + 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(NormalisedDecimal.class, sb, " [");
        String strValueOf = String.valueOf(this._wholePart);
        sb.append(strValueOf.charAt(0));
        sb.append('.');
        sb.append(strValueOf.substring(1));
        sb.append(Chars.SPACE);
        sb.append(getFractionalDigits());
        sb.append('E');
        return AbstractC0157z.p(sb, getDecimalExponent(), ']');
    }
}

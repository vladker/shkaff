package org.apache.commons.math3.dfp;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DfpMath {
    private static final String POW_TRAP = "pow";

    private DfpMath() {
    }

    public static Dfp acos(Dfp dfp) {
        boolean zLessThan = dfp.lessThan(dfp.getZero());
        Dfp dfpCopysign = Dfp.copysign(dfp, dfp.getOne());
        Dfp dfpAtan = atan(dfpCopysign.getOne().subtract(dfpCopysign.multiply(dfpCopysign)).sqrt().divide(dfpCopysign));
        if (zLessThan) {
            dfpAtan = dfpCopysign.getField().getPi().subtract(dfpAtan);
        }
        return dfpCopysign.newInstance(dfpAtan);
    }

    public static Dfp asin(Dfp dfp) {
        return atan(dfp.divide(dfp.getOne().subtract(dfp.multiply(dfp)).sqrt()));
    }

    public static Dfp atan(Dfp dfp) {
        boolean z6;
        boolean z7;
        boolean z8;
        Dfp zero = dfp.getField().getZero();
        Dfp one = dfp.getField().getOne();
        Dfp[] sqr2Split = dfp.getField().getSqr2Split();
        Dfp[] piSplit = dfp.getField().getPiSplit();
        Dfp dfpAdd = sqr2Split[0].subtract(one).add(sqr2Split[1]);
        Dfp dfp2 = new Dfp(dfp);
        if (dfp2.lessThan(zero)) {
            dfp2 = dfp2.negate();
            z6 = true;
        } else {
            z6 = false;
        }
        if (dfp2.greaterThan(one)) {
            dfp2 = one.divide(dfp2);
            z7 = true;
        } else {
            z7 = false;
        }
        if (dfp2.greaterThan(dfpAdd)) {
            Dfp[] dfpArr = {sqr2Split[0].subtract(one), sqr2Split[1]};
            Dfp[] dfpArrSplit = split(dfp2);
            Dfp[] dfpArrSplitMult = splitMult(dfpArrSplit, dfpArr);
            dfpArrSplitMult[0] = dfpArrSplitMult[0].add(one);
            dfpArrSplit[0] = dfpArrSplit[0].subtract(dfpArr[0]);
            dfpArrSplit[1] = dfpArrSplit[1].subtract(dfpArr[1]);
            Dfp[] dfpArrSplitDiv = splitDiv(dfpArrSplit, dfpArrSplitMult);
            dfp2 = dfpArrSplitDiv[0].add(dfpArrSplitDiv[1]);
            z8 = true;
        } else {
            z8 = false;
        }
        Dfp dfpAtanInternal = atanInternal(dfp2);
        if (z8) {
            dfpAtanInternal = dfpAtanInternal.add(piSplit[0].divide(8)).add(piSplit[1].divide(8));
        }
        if (z7) {
            dfpAtanInternal = piSplit[0].divide(2).subtract(dfpAtanInternal).add(piSplit[1].divide(2));
        }
        if (z6) {
            dfpAtanInternal = dfpAtanInternal.negate();
        }
        return dfp.newInstance(dfpAtanInternal);
    }

    public static Dfp atanInternal(Dfp dfp) {
        Dfp dfp2 = new Dfp(dfp);
        Dfp dfp3 = new Dfp(dfp2);
        Dfp dfp4 = new Dfp(dfp2);
        for (int i5 = 3; i5 < 90; i5 += 2) {
            dfp3 = dfp3.multiply(dfp).multiply(dfp).negate();
            dfp2 = dfp2.add(dfp3.divide(i5));
            if (dfp2.equals(dfp4)) {
                return dfp2;
            }
            dfp4 = new Dfp(dfp2);
        }
        return dfp2;
    }

    public static Dfp cos(Dfp dfp) {
        boolean z6;
        Dfp dfpSinInternal;
        Dfp pi = dfp.getField().getPi();
        Dfp zero = dfp.getField().getZero();
        Dfp dfpRemainder2 = dfp.remainder(pi.multiply(2));
        if (dfpRemainder2.lessThan(zero)) {
            dfpRemainder2 = dfpRemainder2.negate();
        }
        if (dfpRemainder2.greaterThan(pi.divide(2))) {
            dfpRemainder2 = pi.subtract(dfpRemainder2);
            z6 = true;
        } else {
            z6 = false;
        }
        if (dfpRemainder2.lessThan(pi.divide(4))) {
            dfpSinInternal = cosInternal(new Dfp[]{dfpRemainder2, zero});
        } else {
            Dfp[] piSplit = dfp.getField().getPiSplit();
            dfpSinInternal = sinInternal(new Dfp[]{piSplit[0].divide(2).subtract(dfpRemainder2), piSplit[1].divide(2)});
        }
        if (z6) {
            dfpSinInternal = dfpSinInternal.negate();
        }
        return dfp.newInstance(dfpSinInternal);
    }

    public static Dfp cosInternal(Dfp[] dfpArr) {
        Dfp one = dfpArr[0].getOne();
        Dfp dfpAdd = dfpArr[0].add(dfpArr[1]);
        Dfp dfpMultiply = dfpAdd.multiply(dfpAdd);
        Dfp dfp = new Dfp(one);
        Dfp dfpAdd2 = one;
        Dfp dfpDivide = dfpAdd2;
        for (int i5 = 2; i5 < 90; i5 += 2) {
            one = one.multiply(dfpMultiply).negate();
            dfpDivide = dfpDivide.divide((i5 - 1) * i5);
            dfpAdd2 = dfpAdd2.add(one.multiply(dfpDivide));
            if (dfpAdd2.equals(dfp)) {
                return dfpAdd2;
            }
            dfp = new Dfp(dfpAdd2);
        }
        return dfpAdd2;
    }

    public static Dfp exp(Dfp dfp) {
        Dfp dfpRint = dfp.rint();
        Dfp dfpSubtract = dfp.subtract(dfpRint);
        int iIntValue = dfpRint.intValue();
        if (iIntValue > 2147483646) {
            return dfp.newInstance((byte) 1, (byte) 1);
        }
        return iIntValue < -2147483646 ? dfp.newInstance() : splitPow(dfp.getField().getESplit(), iIntValue).multiply(expInternal(dfpSubtract));
    }

    public static Dfp expInternal(Dfp dfp) {
        Dfp one = dfp.getOne();
        Dfp one2 = dfp.getOne();
        Dfp one3 = dfp.getOne();
        Dfp dfp2 = new Dfp(one);
        for (int i5 = 1; i5 < 90; i5++) {
            one2 = one2.multiply(dfp);
            one3 = one3.divide(i5);
            one = one.add(one2.multiply(one3));
            if (one.equals(dfp2)) {
                return one;
            }
            dfp2 = new Dfp(one);
        }
        return one;
    }

    public static Dfp log(Dfp dfp) {
        if (dfp.equals(dfp.getZero()) || dfp.lessThan(dfp.getZero()) || dfp.isNaN()) {
            dfp.getField().setIEEEFlagsBits(1);
            return dfp.dotrap(1, "ln", dfp, dfp.newInstance((byte) 1, (byte) 3));
        }
        if (dfp.classify() == 1) {
            return dfp;
        }
        Dfp dfp2 = new Dfp(dfp);
        int iLog10K = dfp2.log10K();
        Dfp dfpDivide = dfp2.divide(pow(dfp.newInstance(10000), iLog10K));
        int iIntValue = dfpDivide.floor().intValue();
        int i5 = 0;
        while (iIntValue > 2) {
            iIntValue >>= 1;
            i5++;
        }
        Dfp[] dfpArrSplit = split(dfpDivide);
        Dfp[] dfpArr = new Dfp[2];
        Dfp dfpPow = pow(dfp.getTwo(), i5);
        dfpArr[0] = dfpPow;
        dfpArrSplit[0] = dfpArrSplit[0].divide(dfpPow);
        dfpArrSplit[1] = dfpArrSplit[1].divide(dfpArr[0]);
        dfpArr[0] = dfp.newInstance("1.33333");
        while (dfpArrSplit[0].add(dfpArrSplit[1]).greaterThan(dfpArr[0])) {
            dfpArrSplit[0] = dfpArrSplit[0].divide(2);
            dfpArrSplit[1] = dfpArrSplit[1].divide(2);
            i5++;
        }
        Dfp[] dfpArrLogInternal = logInternal(dfpArrSplit);
        StringBuilder sb = new StringBuilder();
        int i6 = iLog10K * 4;
        sb.append(i5 + i6);
        dfpArrSplit[0] = dfp.newInstance(sb.toString());
        dfpArrSplit[1] = dfp.getZero();
        Dfp[] dfpArrSplitMult = splitMult(dfp.getField().getLn2Split(), dfpArrSplit);
        dfpArrLogInternal[0] = dfpArrLogInternal[0].add(dfpArrSplitMult[0]);
        dfpArrLogInternal[1] = dfpArrLogInternal[1].add(dfpArrSplitMult[1]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i6);
        dfpArrSplit[0] = dfp.newInstance(sb2.toString());
        dfpArrSplit[1] = dfp.getZero();
        Dfp[] dfpArrSplitMult2 = splitMult(dfp.getField().getLn5Split(), dfpArrSplit);
        dfpArrLogInternal[0] = dfpArrLogInternal[0].add(dfpArrSplitMult2[0]);
        Dfp dfpAdd = dfpArrLogInternal[1].add(dfpArrSplitMult2[1]);
        dfpArrLogInternal[1] = dfpAdd;
        return dfp.newInstance(dfpArrLogInternal[0].add(dfpAdd));
    }

    public static Dfp[] logInternal(Dfp[] dfpArr) {
        int i5 = 1;
        Dfp dfpAdd = dfpArr[0].divide(4).add(dfpArr[1].divide(4));
        Dfp dfpDivide = dfpAdd.add(dfpArr[0].newInstance("-0.25")).divide(dfpAdd.add(dfpArr[0].newInstance("0.25")));
        Dfp dfp = new Dfp(dfpDivide);
        Dfp dfp2 = new Dfp(dfpDivide);
        Dfp dfp3 = new Dfp(dfp);
        for (int i6 = 0; i6 < 10000; i6++) {
            dfp2 = dfp2.multiply(dfpDivide).multiply(dfpDivide);
            i5 += 2;
            dfp = dfp.add(dfp2.divide(i5));
            if (dfp.equals(dfp3)) {
                break;
            }
            dfp3 = new Dfp(dfp);
        }
        return split(dfp.multiply(dfpArr[0].getTwo()));
    }

    public static Dfp pow(Dfp dfp, int i5) {
        boolean z6;
        Dfp dfp2;
        Dfp one = dfp.getOne();
        if (i5 == 0) {
            return one;
        }
        if (i5 < 0) {
            i5 = -i5;
            z6 = true;
        } else {
            z6 = false;
        }
        do {
            Dfp dfp3 = new Dfp(dfp);
            int i6 = 1;
            while (true) {
                dfp2 = new Dfp(dfp3);
                dfp3 = dfp3.multiply(dfp3);
                int i7 = i6 * 2;
                if (i5 <= i7) {
                    break;
                }
                i6 = i7;
            }
            i5 -= i6;
            one = one.multiply(dfp2);
        } while (i5 >= 1);
        if (z6) {
            one = dfp.getOne().divide(one);
        }
        return dfp.newInstance(one);
    }

    public static Dfp sin(Dfp dfp) {
        boolean z6;
        Dfp dfpCosInternal;
        Dfp pi = dfp.getField().getPi();
        Dfp zero = dfp.getField().getZero();
        Dfp dfpRemainder2 = dfp.remainder(pi.multiply(2));
        if (dfpRemainder2.lessThan(zero)) {
            dfpRemainder2 = dfpRemainder2.negate();
            z6 = true;
        } else {
            z6 = false;
        }
        if (dfpRemainder2.greaterThan(pi.divide(2))) {
            dfpRemainder2 = pi.subtract(dfpRemainder2);
        }
        if (dfpRemainder2.lessThan(pi.divide(4))) {
            dfpCosInternal = sinInternal(split(dfpRemainder2));
        } else {
            Dfp[] piSplit = dfp.getField().getPiSplit();
            dfpCosInternal = cosInternal(new Dfp[]{piSplit[0].divide(2).subtract(dfpRemainder2), piSplit[1].divide(2)});
        }
        if (z6) {
            dfpCosInternal = dfpCosInternal.negate();
        }
        return dfp.newInstance(dfpCosInternal);
    }

    public static Dfp sinInternal(Dfp[] dfpArr) {
        Dfp dfpAdd = dfpArr[0].add(dfpArr[1]);
        Dfp dfpMultiply = dfpAdd.multiply(dfpAdd);
        Dfp one = dfpArr[0].getOne();
        Dfp dfp = new Dfp(dfpAdd);
        Dfp dfpAdd2 = dfpAdd;
        for (int i5 = 3; i5 < 90; i5 += 2) {
            dfpAdd = dfpAdd.multiply(dfpMultiply).negate();
            one = one.divide((i5 - 1) * i5);
            dfpAdd2 = dfpAdd2.add(dfpAdd.multiply(one));
            if (dfpAdd2.equals(dfp)) {
                return dfpAdd2;
            }
            dfp = new Dfp(dfpAdd2);
        }
        return dfpAdd2;
    }

    public static Dfp[] split(DfpField dfpField, String str) {
        int length = str.length();
        char[] cArr = new char[length];
        boolean z6 = true;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = 0;
                break;
            }
            char cCharAt = str.charAt(i5);
            cArr[i5] = cCharAt;
            if (cCharAt >= '1' && cCharAt <= '9') {
                z6 = false;
            }
            if (cCharAt == '.') {
                i6 += (400 - i6) % 4;
                z6 = false;
            }
            if (i6 == (dfpField.getRadixDigits() / 2) * 4) {
                break;
            }
            char c = cArr[i5];
            if (c >= '0' && c <= '9' && !z6) {
                i6++;
            }
            i5++;
        }
        Dfp dfpNewDfp = dfpField.newDfp(new String(cArr, 0, i5));
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt2 = str.charAt(i7);
            cArr[i7] = cCharAt2;
            if (cCharAt2 >= '0' && cCharAt2 <= '9' && i7 < i5) {
                cArr[i7] = '0';
            }
        }
        return new Dfp[]{dfpNewDfp, dfpField.newDfp(new String(cArr))};
    }

    public static Dfp[] splitDiv(Dfp[] dfpArr, Dfp[] dfpArr2) {
        Dfp dfpSubtract = dfpArr[1].multiply(dfpArr2[0]).subtract(dfpArr[0].multiply(dfpArr2[1]));
        Dfp[] dfpArr3 = {dfpArr[0].divide(dfpArr2[0]), dfpSubtract};
        Dfp dfp = dfpArr2[0];
        dfpArr3[1] = dfpSubtract.divide(dfp.multiply(dfp).add(dfpArr2[0].multiply(dfpArr2[1])));
        return dfpArr3;
    }

    public static Dfp[] splitMult(Dfp[] dfpArr, Dfp[] dfpArr2) {
        Dfp[] dfpArr3 = {dfpMultiply, dfpArr[0].getZero()};
        Dfp dfpMultiply = dfpArr[0].multiply(dfpArr2[0]);
        if (dfpMultiply.classify() != 1 && !dfpArr3[0].equals(dfpArr3[1])) {
            dfpArr3[1] = dfpArr[0].multiply(dfpArr2[1]).add(dfpArr[1].multiply(dfpArr2[0])).add(dfpArr[1].multiply(dfpArr2[1]));
        }
        return dfpArr3;
    }

    public static Dfp splitPow(Dfp[] dfpArr, int i5) {
        boolean z6;
        Dfp[] dfpArrSplitMult = new Dfp[2];
        Dfp zero = dfpArr[0].getZero();
        Dfp[] dfpArrSplitMult2 = {dfpArr[0].getOne(), zero};
        if (i5 == 0) {
            return dfpArrSplitMult2[0].add(zero);
        }
        if (i5 < 0) {
            i5 = -i5;
            z6 = true;
        } else {
            z6 = false;
        }
        do {
            dfpArrSplitMult[0] = new Dfp(dfpArr[0]);
            dfpArrSplitMult[1] = new Dfp(dfpArr[1]);
            int i6 = 1;
            while (true) {
                int i7 = i6 * 2;
                if (i7 > i5) {
                    break;
                }
                dfpArrSplitMult = splitMult(dfpArrSplitMult, dfpArrSplitMult);
                i6 = i7;
            }
            i5 -= i6;
            dfpArrSplitMult2 = splitMult(dfpArrSplitMult2, dfpArrSplitMult);
        } while (i5 >= 1);
        dfpArrSplitMult2[0] = dfpArrSplitMult2[0].add(dfpArrSplitMult2[1]);
        if (z6) {
            dfpArrSplitMult2[0] = dfpArr[0].getOne().divide(dfpArrSplitMult2[0]);
        }
        return dfpArrSplitMult2[0];
    }

    public static Dfp tan(Dfp dfp) {
        return sin(dfp).divide(cos(dfp));
    }

    public static Dfp pow(Dfp dfp, Dfp dfp2) {
        boolean z6;
        Dfp dfpExp;
        if (dfp.getField().getRadixDigits() != dfp2.getField().getRadixDigits()) {
            dfp.getField().setIEEEFlagsBits(1);
            Dfp dfpNewInstance = dfp.newInstance(dfp.getZero());
            dfpNewInstance.nans = (byte) 3;
            return dfp.dotrap(1, POW_TRAP, dfp, dfpNewInstance);
        }
        Dfp zero = dfp.getZero();
        Dfp one = dfp.getOne();
        Dfp two = dfp.getTwo();
        if (dfp2.equals(zero)) {
            return dfp.newInstance(one);
        }
        if (dfp2.equals(one)) {
            if (!dfp.isNaN()) {
                return dfp;
            }
            dfp.getField().setIEEEFlagsBits(1);
            return dfp.dotrap(1, POW_TRAP, dfp, dfp);
        }
        if (!dfp.isNaN() && !dfp2.isNaN()) {
            if (dfp.equals(zero)) {
                if (Dfp.copysign(one, dfp).greaterThan(zero)) {
                    if (dfp2.greaterThan(zero)) {
                        return dfp.newInstance(zero);
                    }
                    return dfp.newInstance(dfp.newInstance((byte) 1, (byte) 1));
                }
                if (dfp2.classify() == 0 && dfp2.rint().equals(dfp2) && !dfp2.remainder(two).equals(zero)) {
                    if (dfp2.greaterThan(zero)) {
                        return dfp.newInstance(zero.negate());
                    }
                    return dfp.newInstance(dfp.newInstance((byte) -1, (byte) 1));
                }
                if (dfp2.greaterThan(zero)) {
                    return dfp.newInstance(zero);
                }
                return dfp.newInstance(dfp.newInstance((byte) 1, (byte) 1));
            }
            if (dfp.lessThan(zero)) {
                dfp = dfp.negate();
                z6 = true;
            } else {
                z6 = false;
            }
            if (dfp.greaterThan(one) && dfp2.classify() == 1) {
                return dfp2.greaterThan(zero) ? dfp2 : dfp.newInstance(zero);
            }
            if (dfp.lessThan(one) && dfp2.classify() == 1) {
                if (dfp2.greaterThan(zero)) {
                    return dfp.newInstance(zero);
                }
                return dfp.newInstance(Dfp.copysign(dfp2, one));
            }
            if (dfp.equals(one) && dfp2.classify() == 1) {
                dfp.getField().setIEEEFlagsBits(1);
                return dfp.dotrap(1, POW_TRAP, dfp, dfp.newInstance((byte) 1, (byte) 3));
            }
            if (dfp.classify() == 1) {
                if (!z6) {
                    return dfp2.greaterThan(zero) ? dfp : dfp.newInstance(zero);
                }
                if (dfp2.classify() == 0 && dfp2.rint().equals(dfp2) && !dfp2.remainder(two).equals(zero)) {
                    if (dfp2.greaterThan(zero)) {
                        return dfp.newInstance(dfp.newInstance((byte) -1, (byte) 1));
                    }
                    return dfp.newInstance(zero.negate());
                }
                if (dfp2.greaterThan(zero)) {
                    return dfp.newInstance(dfp.newInstance((byte) 1, (byte) 1));
                }
                return dfp.newInstance(zero);
            }
            if (z6 && !dfp2.rint().equals(dfp2)) {
                dfp.getField().setIEEEFlagsBits(1);
                return dfp.dotrap(1, POW_TRAP, dfp, dfp.newInstance((byte) 1, (byte) 3));
            }
            if (dfp2.lessThan(dfp.newInstance(100000000)) && dfp2.greaterThan(dfp.newInstance(-100000000))) {
                Dfp dfpRint = dfp2.rint();
                int iIntValue = dfpRint.intValue();
                Dfp dfpSubtract = dfp2.subtract(dfpRint);
                if (dfpSubtract.unequal(zero)) {
                    Dfp dfpMultiply = dfpSubtract.multiply(log(dfp));
                    Dfp dfpRint2 = dfpMultiply.divide(dfp.getField().getLn2()).rint();
                    dfpExp = splitPow(split(dfp), iIntValue).multiply(pow(two, dfpRint2.intValue())).multiply(exp(dfpMultiply.subtract(dfpRint2.multiply(dfp.getField().getLn2()))));
                } else {
                    dfpExp = splitPow(split(dfp), iIntValue);
                }
            } else {
                dfpExp = exp(log(dfp).multiply(dfp2));
            }
            if (z6 && dfp2.rint().equals(dfp2) && !dfp2.remainder(two).equals(zero)) {
                dfpExp = dfpExp.negate();
            }
            return dfp.newInstance(dfpExp);
        }
        dfp.getField().setIEEEFlagsBits(1);
        return dfp.dotrap(1, POW_TRAP, dfp, dfp.newInstance((byte) 1, (byte) 3));
    }

    public static Dfp[] split(Dfp dfp) {
        Dfp dfpMultiply = dfp.multiply(dfp.power10K(dfp.getRadixDigits() / 2));
        Dfp dfpSubtract = dfp.add(dfpMultiply).subtract(dfpMultiply);
        return new Dfp[]{dfpSubtract, dfp.subtract(dfpSubtract)};
    }
}

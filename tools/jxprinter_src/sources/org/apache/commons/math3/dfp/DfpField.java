package org.apache.commons.math3.dfp;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DfpField implements Field<Dfp> {
    public static final int FLAG_DIV_ZERO = 2;
    public static final int FLAG_INEXACT = 16;
    public static final int FLAG_INVALID = 1;
    public static final int FLAG_OVERFLOW = 4;
    public static final int FLAG_UNDERFLOW = 8;
    private static String eString;
    private static String ln10String;
    private static String ln2String;
    private static String ln5String;
    private static String piString;
    private static String sqr2ReciprocalString;
    private static String sqr2String;
    private static String sqr3ReciprocalString;
    private static String sqr3String;
    private final Dfp e;
    private final Dfp[] eSplit;
    private int ieeeFlags;
    private final Dfp ln10;
    private final Dfp ln2;
    private final Dfp[] ln2Split;
    private final Dfp ln5;
    private final Dfp[] ln5Split;
    private final Dfp one;
    private final Dfp pi;
    private final Dfp[] piSplit;
    private RoundingMode rMode;
    private final int radixDigits;
    private final Dfp sqr2;
    private final Dfp sqr2Reciprocal;
    private final Dfp[] sqr2Split;
    private final Dfp sqr3;
    private final Dfp sqr3Reciprocal;
    private final Dfp two;
    private final Dfp zero;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum RoundingMode {
        ROUND_DOWN,
        ROUND_UP,
        ROUND_HALF_UP,
        ROUND_HALF_DOWN,
        ROUND_HALF_EVEN,
        ROUND_HALF_ODD,
        ROUND_CEIL,
        ROUND_FLOOR
    }

    public DfpField(int i5) {
        this(i5, true);
    }

    public static Dfp computeExp(Dfp dfp, Dfp dfp2) {
        Dfp dfp3 = new Dfp(dfp2);
        Dfp dfp4 = new Dfp(dfp2);
        Dfp dfp5 = new Dfp(dfp2);
        Dfp dfp6 = new Dfp(dfp2);
        Dfp dfp7 = new Dfp(dfp2);
        for (int i5 = 0; i5 < 10000; i5++) {
            dfp7 = dfp7.multiply(dfp);
            dfp3 = dfp3.add(dfp7.divide(dfp5));
            dfp6 = dfp6.add(dfp2);
            dfp5 = dfp5.multiply(dfp6);
            if (dfp3.equals(dfp4)) {
                return dfp3;
            }
            dfp4 = new Dfp(dfp3);
        }
        return dfp3;
    }

    public static Dfp computeLn(Dfp dfp, Dfp dfp2, Dfp dfp3) {
        Dfp dfpDivide = dfp.add(new Dfp(dfp.getField(), -1)).divide(dfp.add(dfp2));
        Dfp dfp4 = new Dfp(dfpDivide);
        Dfp dfp5 = new Dfp(dfpDivide);
        Dfp dfp6 = new Dfp(dfp4);
        int i5 = 1;
        for (int i6 = 0; i6 < 10000; i6++) {
            dfp5 = dfp5.multiply(dfpDivide).multiply(dfpDivide);
            i5 += 2;
            dfp4 = dfp4.add(dfp5.divide(i5));
            if (dfp4.equals(dfp6)) {
                break;
            }
            dfp6 = new Dfp(dfp4);
        }
        return dfp4.multiply(dfp3);
    }

    private static Dfp computePi(Dfp dfp, Dfp dfp2, Dfp dfp3) {
        Dfp dfpSqrt = dfp2.sqrt();
        Dfp dfpSubtract = dfpSqrt.subtract(dfp);
        Dfp dfpAdd = dfp2.add(dfp2);
        Dfp dfpMultiply = dfp2.multiply(dfp3.subtract(dfp2.multiply(dfpSqrt)));
        int i5 = 1;
        Dfp dfp4 = dfpSubtract;
        Dfp dfp5 = dfp2;
        while (i5 < 20) {
            Dfp dfpMultiply2 = dfp4.multiply(dfp4);
            Dfp dfpSqrt2 = dfp.subtract(dfpMultiply2.multiply(dfpMultiply2)).sqrt().sqrt();
            Dfp dfpDivide = dfp.subtract(dfpSqrt2).divide(dfp.add(dfpSqrt2));
            Dfp dfpMultiply3 = dfp5.multiply(dfpAdd);
            Dfp dfpAdd2 = dfp.add(dfpDivide);
            Dfp dfpMultiply4 = dfpAdd2.multiply(dfpAdd2);
            dfpMultiply = dfpMultiply.multiply(dfpMultiply4.multiply(dfpMultiply4)).subtract(dfpMultiply3.multiply(dfpDivide).multiply(dfp.add(dfpDivide).add(dfpDivide.multiply(dfpDivide))));
            if (dfpDivide.equals(dfp4)) {
                break;
            }
            i5++;
            dfp4 = dfpDivide;
            dfp5 = dfpMultiply3;
        }
        return dfp.divide(dfpMultiply);
    }

    private static void computeStringConstants(int i5) {
        String str = sqr2String;
        if (str == null || str.length() < i5 - 3) {
            DfpField dfpField = new DfpField(i5, false);
            Dfp dfp = new Dfp(dfpField, 1);
            Dfp dfp2 = new Dfp(dfpField, 2);
            Dfp dfp3 = new Dfp(dfpField, 3);
            Dfp dfpSqrt = dfp2.sqrt();
            sqr2String = dfpSqrt.toString();
            sqr2ReciprocalString = dfp.divide(dfpSqrt).toString();
            Dfp dfpSqrt2 = dfp3.sqrt();
            sqr3String = dfpSqrt2.toString();
            sqr3ReciprocalString = dfp.divide(dfpSqrt2).toString();
            piString = computePi(dfp, dfp2, dfp3).toString();
            eString = computeExp(dfp, dfp).toString();
            ln2String = computeLn(dfp2, dfp, dfp2).toString();
            ln5String = computeLn(new Dfp(dfpField, 5), dfp, dfp2).toString();
            ln10String = computeLn(new Dfp(dfpField, 10), dfp, dfp2).toString();
        }
    }

    private Dfp[] split(String str) {
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
            if (i6 == (this.radixDigits / 2) * 4) {
                break;
            }
            if (cCharAt >= '0' && cCharAt <= '9' && !z6) {
                i6++;
            }
            i5++;
        }
        Dfp dfp = new Dfp(this, new String(cArr, 0, i5));
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt2 = str.charAt(i7);
            cArr[i7] = cCharAt2;
            if (cCharAt2 >= '0' && cCharAt2 <= '9' && i7 < i5) {
                cArr[i7] = '0';
            }
        }
        return new Dfp[]{dfp, new Dfp(this, new String(cArr))};
    }

    public void clearIEEEFlags() {
        this.ieeeFlags = 0;
    }

    public Dfp getE() {
        return this.e;
    }

    public Dfp[] getESplit() {
        return (Dfp[]) this.eSplit.clone();
    }

    public int getIEEEFlags() {
        return this.ieeeFlags;
    }

    public Dfp getLn10() {
        return this.ln10;
    }

    public Dfp getLn2() {
        return this.ln2;
    }

    public Dfp[] getLn2Split() {
        return (Dfp[]) this.ln2Split.clone();
    }

    public Dfp getLn5() {
        return this.ln5;
    }

    public Dfp[] getLn5Split() {
        return (Dfp[]) this.ln5Split.clone();
    }

    public Dfp getPi() {
        return this.pi;
    }

    public Dfp[] getPiSplit() {
        return (Dfp[]) this.piSplit.clone();
    }

    public int getRadixDigits() {
        return this.radixDigits;
    }

    public RoundingMode getRoundingMode() {
        return this.rMode;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Dfp>> getRuntimeClass() {
        return Dfp.class;
    }

    public Dfp getSqr2() {
        return this.sqr2;
    }

    public Dfp getSqr2Reciprocal() {
        return this.sqr2Reciprocal;
    }

    public Dfp[] getSqr2Split() {
        return (Dfp[]) this.sqr2Split.clone();
    }

    public Dfp getSqr3() {
        return this.sqr3;
    }

    public Dfp getSqr3Reciprocal() {
        return this.sqr3Reciprocal;
    }

    public Dfp getTwo() {
        return this.two;
    }

    public Dfp newDfp() {
        return new Dfp(this);
    }

    public void setIEEEFlags(int i5) {
        this.ieeeFlags = i5 & 31;
    }

    public void setIEEEFlagsBits(int i5) {
        this.ieeeFlags = (i5 & 31) | this.ieeeFlags;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.rMode = roundingMode;
    }

    private DfpField(int i5, boolean z6) {
        this.radixDigits = i5 >= 13 ? (i5 + 3) / 4 : 4;
        this.rMode = RoundingMode.ROUND_HALF_EVEN;
        this.ieeeFlags = 0;
        this.zero = new Dfp(this, 0);
        this.one = new Dfp(this, 1);
        this.two = new Dfp(this, 2);
        if (!z6) {
            this.sqr2 = null;
            this.sqr2Split = null;
            this.sqr2Reciprocal = null;
            this.sqr3 = null;
            this.sqr3Reciprocal = null;
            this.pi = null;
            this.piSplit = null;
            this.e = null;
            this.eSplit = null;
            this.ln2 = null;
            this.ln2Split = null;
            this.ln5 = null;
            this.ln5Split = null;
            this.ln10 = null;
            return;
        }
        synchronized (DfpField.class) {
            computeStringConstants(i5 < 67 ? 200 : i5 * 3);
            this.sqr2 = new Dfp(this, sqr2String);
            this.sqr2Split = split(sqr2String);
            this.sqr2Reciprocal = new Dfp(this, sqr2ReciprocalString);
            this.sqr3 = new Dfp(this, sqr3String);
            this.sqr3Reciprocal = new Dfp(this, sqr3ReciprocalString);
            this.pi = new Dfp(this, piString);
            this.piSplit = split(piString);
            this.e = new Dfp(this, eString);
            this.eSplit = split(eString);
            this.ln2 = new Dfp(this, ln2String);
            this.ln2Split = split(ln2String);
            this.ln5 = new Dfp(this, ln5String);
            this.ln5Split = split(ln5String);
            this.ln10 = new Dfp(this, ln10String);
        }
    }

    @Override // org.apache.commons.math3.Field
    public Dfp getOne() {
        return this.one;
    }

    @Override // org.apache.commons.math3.Field
    public Dfp getZero() {
        return this.zero;
    }

    public Dfp newDfp(byte b) {
        return new Dfp(this, b);
    }

    public Dfp newDfp(int i5) {
        return new Dfp(this, i5);
    }

    public Dfp newDfp(long j6) {
        return new Dfp(this, j6);
    }

    public Dfp newDfp(double d) {
        return new Dfp(this, d);
    }

    public Dfp newDfp(Dfp dfp) {
        return new Dfp(dfp);
    }

    public Dfp newDfp(String str) {
        return new Dfp(this, str);
    }

    public Dfp newDfp(byte b, byte b6) {
        return new Dfp(this, b, b6);
    }
}

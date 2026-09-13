package org.apache.commons.math3.fraction;

import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Fraction extends Number implements FieldElement<Fraction>, Comparable<Fraction>, Serializable {
    private static final double DEFAULT_EPSILON = 1.0E-5d;
    private static final long serialVersionUID = 3698073679419233275L;
    private final int denominator;
    private final int numerator;
    public static final Fraction TWO = new Fraction(2, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction MINUS_ONE = new Fraction(-1, 1);

    public Fraction(double d) {
        this(d, 1.0E-5d, 100);
    }

    private Fraction addSub(Fraction fraction, boolean z6) {
        if (fraction == null) {
            throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
        }
        if (this.numerator == 0) {
            return z6 ? fraction : fraction.negate();
        }
        if (fraction.numerator == 0) {
            return this;
        }
        int iGcd = ArithmeticUtils.gcd(this.denominator, fraction.denominator);
        if (iGcd == 1) {
            int iMulAndCheck = ArithmeticUtils.mulAndCheck(this.numerator, fraction.denominator);
            int iMulAndCheck2 = ArithmeticUtils.mulAndCheck(fraction.numerator, this.denominator);
            return new Fraction(z6 ? ArithmeticUtils.addAndCheck(iMulAndCheck, iMulAndCheck2) : ArithmeticUtils.subAndCheck(iMulAndCheck, iMulAndCheck2), ArithmeticUtils.mulAndCheck(this.denominator, fraction.denominator));
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / iGcd));
        BigInteger bigIntegerMultiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / iGcd));
        BigInteger bigIntegerAdd = z6 ? bigIntegerMultiply.add(bigIntegerMultiply2) : bigIntegerMultiply.subtract(bigIntegerMultiply2);
        int iIntValue = bigIntegerAdd.mod(BigInteger.valueOf(iGcd)).intValue();
        int iGcd2 = iIntValue == 0 ? iGcd : ArithmeticUtils.gcd(iIntValue, iGcd);
        BigInteger bigIntegerDivide = bigIntegerAdd.divide(BigInteger.valueOf(iGcd2));
        if (bigIntegerDivide.bitLength() <= 31) {
            return new Fraction(bigIntegerDivide.intValue(), ArithmeticUtils.mulAndCheck(this.denominator / iGcd, fraction.denominator / iGcd2));
        }
        throw new MathArithmeticException(LocalizedFormats.NUMERATOR_OVERFLOW_AFTER_MULTIPLY, bigIntegerDivide);
    }

    public static Fraction getReducedFraction(int i5, int i6) {
        if (i6 == 0) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        if (i5 == 0) {
            return ZERO;
        }
        if (i6 == Integer.MIN_VALUE && (i5 & 1) == 0) {
            i5 /= 2;
            i6 /= 2;
        }
        if (i6 < 0) {
            if (i5 == Integer.MIN_VALUE || i6 == Integer.MIN_VALUE) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, Integer.valueOf(i5), Integer.valueOf(i6));
            }
            i5 = -i5;
            i6 = -i6;
        }
        int iGcd = ArithmeticUtils.gcd(i5, i6);
        return new Fraction(i5 / iGcd, i6 / iGcd);
    }

    public Fraction abs() {
        return this.numerator >= 0 ? this : negate();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Fraction) {
            Fraction fraction = (Fraction) obj;
            if (this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) doubleValue();
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int hashCode() {
        return ((this.numerator + 629) * 37) + this.denominator;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) doubleValue();
    }

    public double percentageValue() {
        return doubleValue() * 100.0d;
    }

    public String toString() {
        if (this.denominator == 1) {
            return Integer.toString(this.numerator);
        }
        if (this.numerator == 0) {
            return "0";
        }
        return this.numerator + " / " + this.denominator;
    }

    public Fraction(double d, double d6, int i5) {
        this(d, d6, Integer.MAX_VALUE, i5);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    @Override // java.lang.Comparable
    public int compareTo(Fraction fraction) {
        long j6 = ((long) this.numerator) * ((long) fraction.denominator);
        long j7 = ((long) this.denominator) * ((long) fraction.numerator);
        if (j6 < j7) {
            return -1;
        }
        return j6 > j7 ? 1 : 0;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction divide(Fraction fraction) {
        if (fraction == null) {
            throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
        }
        if (fraction.numerator != 0) {
            return multiply(fraction.reciprocal());
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_FRACTION_TO_DIVIDE_BY, Integer.valueOf(fraction.numerator), Integer.valueOf(fraction.denominator));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<Fraction> getField() {
        return FractionField.getInstance();
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction negate() {
        int i5 = this.numerator;
        if (i5 != Integer.MIN_VALUE) {
            return new Fraction(-i5, this.denominator);
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, Integer.valueOf(this.numerator), Integer.valueOf(this.denominator));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction reciprocal() {
        return new Fraction(this.denominator, this.numerator);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public Fraction(double d, int i5) {
        this(d, 0.0d, i5, 100);
    }

    public Fraction add(int i5) {
        int i6 = this.numerator;
        int i7 = this.denominator;
        return new Fraction((i5 * i7) + i6, i7);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction multiply(Fraction fraction) {
        if (fraction != null) {
            int i5 = this.numerator;
            if (i5 != 0 && fraction.numerator != 0) {
                int iGcd = ArithmeticUtils.gcd(i5, fraction.denominator);
                int iGcd2 = ArithmeticUtils.gcd(fraction.numerator, this.denominator);
                return getReducedFraction(ArithmeticUtils.mulAndCheck(this.numerator / iGcd, fraction.numerator / iGcd2), ArithmeticUtils.mulAndCheck(this.denominator / iGcd2, fraction.denominator / iGcd));
            }
            return ZERO;
        }
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public Fraction subtract(int i5) {
        int i6 = this.numerator;
        int i7 = this.denominator;
        return new Fraction(i6 - (i5 * i7), i7);
    }

    private Fraction(double d, double d6, int i5, int i6) {
        long j6;
        long j7;
        long jFloor = (long) FastMath.floor(d);
        long j8 = 2147483647L;
        if (FastMath.abs(jFloor) > 2147483647L) {
            throw new FractionConversionException(d, jFloor, 1L);
        }
        int i7 = 1;
        if (FastMath.abs(jFloor - d) < d6) {
            this.numerator = (int) jFloor;
            this.denominator = 1;
            return;
        }
        int i8 = 0;
        double d7 = d;
        long j9 = 1;
        long j10 = 0;
        long j11 = jFloor;
        boolean z6 = false;
        long j12 = 1;
        while (true) {
            i8 += i7;
            long j13 = j8;
            double d8 = 1.0d / (d7 - jFloor);
            long jFloor2 = (long) FastMath.floor(d8);
            long j14 = jFloor;
            j6 = (jFloor2 * j11) + j12;
            j7 = (jFloor2 * j9) + j10;
            if (FastMath.abs(j6) > j13 || FastMath.abs(j7) > j13) {
                long j15 = j11;
                if (d6 == 0.0d && FastMath.abs(j9) < i5) {
                    j11 = j15;
                    break;
                }
                throw new FractionConversionException(d, j6, j7);
            }
            long j16 = j11;
            double d9 = j6 / j7;
            if (i8 >= i6 || FastMath.abs(d9 - d) <= d6 || j7 >= i5) {
                j11 = j16;
                z6 = true;
            } else {
                j11 = j6;
                j10 = j9;
                d7 = d8;
                j12 = j16;
                j14 = jFloor2;
                j9 = j7;
            }
            if (z6) {
                break;
            }
            j8 = j13;
            jFloor = j14;
            i7 = 1;
        }
        long j17 = j9;
        if (i8 >= i6) {
            throw new FractionConversionException(d, i6);
        }
        if (j7 < i5) {
            this.numerator = (int) j6;
            this.denominator = (int) j7;
        } else {
            this.numerator = (int) j11;
            this.denominator = (int) j17;
        }
    }

    public Fraction divide(int i5) {
        return divide(new Fraction(i5));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Fraction multiply(int i5) {
        return multiply(new Fraction(i5));
    }

    public Fraction(int i5) {
        this(i5, 1);
    }

    public Fraction(int i5, int i6) {
        if (i6 != 0) {
            if (i6 < 0) {
                if (i5 == Integer.MIN_VALUE || i6 == Integer.MIN_VALUE) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, Integer.valueOf(i5), Integer.valueOf(i6));
                }
                i5 = -i5;
                i6 = -i6;
            }
            int iGcd = ArithmeticUtils.gcd(i5, i6);
            if (iGcd > 1) {
                i5 /= iGcd;
                i6 /= iGcd;
            }
            if (i6 < 0) {
                i5 = -i5;
                i6 = -i6;
            }
            this.numerator = i5;
            this.denominator = i6;
            return;
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, Integer.valueOf(i5), Integer.valueOf(i6));
    }
}

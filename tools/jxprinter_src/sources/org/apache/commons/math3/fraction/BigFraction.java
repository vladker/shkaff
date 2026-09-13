package org.apache.commons.math3.fraction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BigFraction extends Number implements FieldElement<BigFraction>, Comparable<BigFraction>, Serializable {
    private static final long serialVersionUID = -5630213147331578515L;
    private final BigInteger denominator;
    private final BigInteger numerator;
    public static final BigFraction TWO = new BigFraction(2);
    public static final BigFraction ONE = new BigFraction(1);
    public static final BigFraction ZERO = new BigFraction(0);
    public static final BigFraction MINUS_ONE = new BigFraction(-1);
    public static final BigFraction FOUR_FIFTHS = new BigFraction(4, 5);
    public static final BigFraction ONE_FIFTH = new BigFraction(1, 5);
    public static final BigFraction ONE_HALF = new BigFraction(1, 2);
    public static final BigFraction ONE_QUARTER = new BigFraction(1, 4);
    public static final BigFraction ONE_THIRD = new BigFraction(1, 3);
    public static final BigFraction THREE_FIFTHS = new BigFraction(3, 5);
    public static final BigFraction THREE_QUARTERS = new BigFraction(3, 4);
    public static final BigFraction TWO_FIFTHS = new BigFraction(2, 5);
    public static final BigFraction TWO_QUARTERS = new BigFraction(2, 4);
    public static final BigFraction TWO_THIRDS = new BigFraction(2, 3);
    private static final BigInteger ONE_HUNDRED = BigInteger.valueOf(100);

    public BigFraction(BigInteger bigInteger) {
        this(bigInteger, BigInteger.ONE);
    }

    public static BigFraction getReducedFraction(int i5, int i6) {
        return i5 == 0 ? ZERO : new BigFraction(i5, i6);
    }

    public BigFraction abs() {
        return this.numerator.signum() == 1 ? this : negate();
    }

    public BigDecimal bigDecimalValue() {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        double dDoubleValue = this.numerator.doubleValue() / this.denominator.doubleValue();
        if (!Double.isNaN(dDoubleValue)) {
            return dDoubleValue;
        }
        int iMax = FastMath.max(this.numerator.bitLength(), this.denominator.bitLength()) - FastMath.getExponent(Double.MAX_VALUE);
        return this.numerator.shiftRight(iMax).doubleValue() / this.denominator.shiftRight(iMax).doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BigFraction) {
            BigFraction bigFractionReduce = ((BigFraction) obj).reduce();
            BigFraction bigFractionReduce2 = reduce();
            if (bigFractionReduce2.numerator.equals(bigFractionReduce.numerator) && bigFractionReduce2.denominator.equals(bigFractionReduce.denominator)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        float fFloatValue = this.numerator.floatValue() / this.denominator.floatValue();
        if (!Double.isNaN(fFloatValue)) {
            return fFloatValue;
        }
        int iMax = FastMath.max(this.numerator.bitLength(), this.denominator.bitLength()) - FastMath.getExponent(Float.MAX_VALUE);
        return this.numerator.shiftRight(iMax).floatValue() / this.denominator.shiftRight(iMax).floatValue();
    }

    public BigInteger getDenominator() {
        return this.denominator;
    }

    public int getDenominatorAsInt() {
        return this.denominator.intValue();
    }

    public long getDenominatorAsLong() {
        return this.denominator.longValue();
    }

    public BigInteger getNumerator() {
        return this.numerator;
    }

    public int getNumeratorAsInt() {
        return this.numerator.intValue();
    }

    public long getNumeratorAsLong() {
        return this.numerator.longValue();
    }

    public int hashCode() {
        return this.denominator.hashCode() + ((this.numerator.hashCode() + 629) * 37);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator.divide(this.denominator).intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator.divide(this.denominator).longValue();
    }

    public double percentageValue() {
        return multiply(ONE_HUNDRED).doubleValue();
    }

    public BigFraction pow(int i5) {
        if (i5 == 0) {
            return ONE;
        }
        if (this.numerator.signum() == 0) {
            return this;
        }
        if (i5 >= 0) {
            return new BigFraction(this.numerator.pow(i5), this.denominator.pow(i5));
        }
        int i6 = -i5;
        return new BigFraction(this.denominator.pow(i6), this.numerator.pow(i6));
    }

    public BigFraction reduce() {
        BigInteger bigIntegerGcd = this.numerator.gcd(this.denominator);
        return BigInteger.ONE.compareTo(bigIntegerGcd) < 0 ? new BigFraction(this.numerator.divide(bigIntegerGcd), this.denominator.divide(bigIntegerGcd)) : this;
    }

    public String toString() {
        if (BigInteger.ONE.equals(this.denominator)) {
            return this.numerator.toString();
        }
        if (BigInteger.ZERO.equals(this.numerator)) {
            return "0";
        }
        return this.numerator + " / " + this.denominator;
    }

    public BigFraction(BigInteger bigInteger, BigInteger bigInteger2) {
        MathUtils.checkNotNull(bigInteger, LocalizedFormats.NUMERATOR, new Object[0]);
        MathUtils.checkNotNull(bigInteger2, LocalizedFormats.DENOMINATOR, new Object[0]);
        if (bigInteger2.signum() == 0) {
            throw new ZeroException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
        }
        if (bigInteger.signum() == 0) {
            this.numerator = BigInteger.ZERO;
            this.denominator = BigInteger.ONE;
            return;
        }
        BigInteger bigIntegerGcd = bigInteger.gcd(bigInteger2);
        if (BigInteger.ONE.compareTo(bigIntegerGcd) < 0) {
            bigInteger = bigInteger.divide(bigIntegerGcd);
            bigInteger2 = bigInteger2.divide(bigIntegerGcd);
        }
        if (bigInteger2.signum() == -1) {
            bigInteger = bigInteger.negate();
            bigInteger2 = bigInteger2.negate();
        }
        this.numerator = bigInteger;
        this.denominator = bigInteger2;
    }

    public BigFraction add(BigInteger bigInteger) {
        MathUtils.checkNotNull(bigInteger);
        if (this.numerator.signum() == 0) {
            return new BigFraction(bigInteger);
        }
        return bigInteger.signum() == 0 ? this : new BigFraction(this.numerator.add(this.denominator.multiply(bigInteger)), this.denominator);
    }

    public BigDecimal bigDecimalValue(int i5) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), i5);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigFraction bigFraction) {
        int iSignum = this.numerator.signum();
        int iSignum2 = bigFraction.numerator.signum();
        if (iSignum != iSignum2) {
            return iSignum > iSignum2 ? 1 : -1;
        }
        if (iSignum == 0) {
            return 0;
        }
        return this.numerator.multiply(bigFraction.denominator).compareTo(this.denominator.multiply(bigFraction.numerator));
    }

    public BigFraction divide(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
        }
        if (bigInteger.signum() != 0) {
            return this.numerator.signum() == 0 ? ZERO : new BigFraction(this.numerator, this.denominator.multiply(bigInteger));
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<BigFraction> getField() {
        return BigFractionField.getInstance();
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction negate() {
        return new BigFraction(this.numerator.negate(), this.denominator);
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction reciprocal() {
        return new BigFraction(this.denominator, this.numerator);
    }

    public BigFraction subtract(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new NullArgumentException();
        }
        if (bigInteger.signum() == 0) {
            return this;
        }
        return this.numerator.signum() == 0 ? new BigFraction(bigInteger.negate()) : new BigFraction(this.numerator.subtract(this.denominator.multiply(bigInteger)), this.denominator);
    }

    public BigDecimal bigDecimalValue(int i5, int i6) {
        return new BigDecimal(this.numerator).divide(new BigDecimal(this.denominator), i5, i6);
    }

    public BigFraction multiply(BigInteger bigInteger) {
        if (bigInteger != null) {
            if (this.numerator.signum() != 0 && bigInteger.signum() != 0) {
                return new BigFraction(bigInteger.multiply(this.numerator), this.denominator);
            }
            return ZERO;
        }
        throw new NullArgumentException();
    }

    public BigFraction pow(long j6) {
        if (j6 == 0) {
            return ONE;
        }
        if (this.numerator.signum() == 0) {
            return this;
        }
        if (j6 < 0) {
            long j7 = -j6;
            return new BigFraction(ArithmeticUtils.pow(this.denominator, j7), ArithmeticUtils.pow(this.numerator, j7));
        }
        return new BigFraction(ArithmeticUtils.pow(this.numerator, j6), ArithmeticUtils.pow(this.denominator, j6));
    }

    public BigFraction add(int i5) {
        return add(BigInteger.valueOf(i5));
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction multiply(int i5) {
        if (i5 != 0 && this.numerator.signum() != 0) {
            return multiply(BigInteger.valueOf(i5));
        }
        return ZERO;
    }

    public BigFraction subtract(int i5) {
        return subtract(BigInteger.valueOf(i5));
    }

    public BigFraction add(long j6) {
        return add(BigInteger.valueOf(j6));
    }

    public BigFraction divide(int i5) {
        return divide(BigInteger.valueOf(i5));
    }

    public BigFraction subtract(long j6) {
        return subtract(BigInteger.valueOf(j6));
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction add(BigFraction bigFraction) {
        BigInteger bigIntegerMultiply;
        BigInteger bigIntegerAdd;
        if (bigFraction != null) {
            if (bigFraction.numerator.signum() == 0) {
                return this;
            }
            if (this.numerator.signum() == 0) {
                return bigFraction;
            }
            if (this.denominator.equals(bigFraction.denominator)) {
                bigIntegerAdd = this.numerator.add(bigFraction.numerator);
                bigIntegerMultiply = this.denominator;
            } else {
                BigInteger bigIntegerAdd2 = this.numerator.multiply(bigFraction.denominator).add(bigFraction.numerator.multiply(this.denominator));
                bigIntegerMultiply = this.denominator.multiply(bigFraction.denominator);
                bigIntegerAdd = bigIntegerAdd2;
            }
            if (bigIntegerAdd.signum() == 0) {
                return ZERO;
            }
            return new BigFraction(bigIntegerAdd, bigIntegerMultiply);
        }
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public BigFraction divide(long j6) {
        return divide(BigInteger.valueOf(j6));
    }

    public BigFraction pow(BigInteger bigInteger) {
        if (bigInteger.signum() == 0) {
            return ONE;
        }
        if (this.numerator.signum() == 0) {
            return this;
        }
        if (bigInteger.signum() == -1) {
            BigInteger bigIntegerNegate = bigInteger.negate();
            return new BigFraction(ArithmeticUtils.pow(this.denominator, bigIntegerNegate), ArithmeticUtils.pow(this.numerator, bigIntegerNegate));
        }
        return new BigFraction(ArithmeticUtils.pow(this.numerator, bigInteger), ArithmeticUtils.pow(this.denominator, bigInteger));
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction subtract(BigFraction bigFraction) {
        BigInteger bigIntegerMultiply;
        BigInteger bigIntegerSubtract;
        if (bigFraction != null) {
            if (bigFraction.numerator.signum() == 0) {
                return this;
            }
            if (this.numerator.signum() == 0) {
                return bigFraction.negate();
            }
            if (this.denominator.equals(bigFraction.denominator)) {
                bigIntegerSubtract = this.numerator.subtract(bigFraction.numerator);
                bigIntegerMultiply = this.denominator;
            } else {
                BigInteger bigIntegerSubtract2 = this.numerator.multiply(bigFraction.denominator).subtract(bigFraction.numerator.multiply(this.denominator));
                bigIntegerMultiply = this.denominator.multiply(bigFraction.denominator);
                bigIntegerSubtract = bigIntegerSubtract2;
            }
            return new BigFraction(bigIntegerSubtract, bigIntegerMultiply);
        }
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction divide(BigFraction bigFraction) {
        if (bigFraction != null) {
            if (bigFraction.numerator.signum() != 0) {
                if (this.numerator.signum() == 0) {
                    return ZERO;
                }
                return multiply(bigFraction.reciprocal());
            }
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
        }
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public BigFraction multiply(long j6) {
        if (j6 != 0 && this.numerator.signum() != 0) {
            return multiply(BigInteger.valueOf(j6));
        }
        return ZERO;
    }

    @Override // org.apache.commons.math3.FieldElement
    public BigFraction multiply(BigFraction bigFraction) {
        if (bigFraction != null) {
            if (this.numerator.signum() != 0 && bigFraction.numerator.signum() != 0) {
                return new BigFraction(this.numerator.multiply(bigFraction.numerator), this.denominator.multiply(bigFraction.denominator));
            }
            return ZERO;
        }
        throw new NullArgumentException(LocalizedFormats.FRACTION, new Object[0]);
    }

    public double pow(double d) {
        return FastMath.pow(this.numerator.doubleValue(), d) / FastMath.pow(this.denominator.doubleValue(), d);
    }

    public BigFraction(double d) {
        if (!Double.isNaN(d)) {
            if (!Double.isInfinite(d)) {
                long jDoubleToLongBits = Double.doubleToLongBits(d);
                long j6 = Long.MIN_VALUE & jDoubleToLongBits;
                long j7 = 9218868437227405312L & jDoubleToLongBits;
                long j8 = jDoubleToLongBits & IEEEDouble.FRAC_MASK;
                j8 = j7 != 0 ? j8 | IEEEDouble.FRAC_ASSUMED_HIGH_BIT : j8;
                j8 = j6 != 0 ? -j8 : j8;
                int i5 = ((int) (j7 >> 52)) - 1075;
                while ((9007199254740990L & j8) != 0 && (1 & j8) == 0) {
                    j8 >>= 1;
                    i5++;
                }
                if (i5 < 0) {
                    this.numerator = BigInteger.valueOf(j8);
                    this.denominator = BigInteger.ZERO.flipBit(-i5);
                    return;
                } else {
                    this.numerator = BigInteger.valueOf(j8).multiply(BigInteger.ZERO.flipBit(i5));
                    this.denominator = BigInteger.ONE;
                    return;
                }
            }
            throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_VALUE_CONVERSION, new Object[0]);
        }
        throw new MathIllegalArgumentException(LocalizedFormats.NAN_VALUE_CONVERSION, new Object[0]);
    }

    public BigFraction(double d, double d6, int i5) {
        this(d, d6, Integer.MAX_VALUE, i5);
    }

    private BigFraction(double d, double d6, int i5, int i6) {
        long j6;
        long j7;
        long j8;
        long jFloor = (long) FastMath.floor(d);
        long j9 = 2147483647L;
        if (FastMath.abs(jFloor) > 2147483647L) {
            throw new FractionConversionException(d, jFloor, 1L);
        }
        if (FastMath.abs(jFloor - d) < d6) {
            this.numerator = BigInteger.valueOf(jFloor);
            this.denominator = BigInteger.ONE;
            return;
        }
        double d7 = d;
        long j10 = 1;
        long j11 = 0;
        int i7 = 0;
        boolean z6 = false;
        long j12 = 1;
        long j13 = jFloor;
        while (true) {
            i7++;
            long j14 = j9;
            double d8 = 1.0d / (d7 - jFloor);
            long jFloor2 = (long) FastMath.floor(d8);
            long j15 = jFloor;
            long j16 = (jFloor2 * j13) + j12;
            j6 = j13;
            j7 = (jFloor2 * j10) + j11;
            if (j16 > j14 || j7 > j14) {
                j8 = j16;
                if (d6 == 0.0d && FastMath.abs(j10) < i5) {
                    break;
                } else {
                    throw new FractionConversionException(d, j8, j7);
                }
            }
            j8 = j16;
            double d9 = j16 / j7;
            if (i7 >= i6 || FastMath.abs(d9 - d) <= d6 || j7 >= i5) {
                z6 = true;
                jFloor = j15;
            } else {
                j11 = j10;
                d7 = d8;
                jFloor = jFloor2;
                j12 = j6;
                j6 = j8;
                j10 = j7;
            }
            if (z6) {
                break;
            }
            j9 = j14;
            j13 = j6;
        }
        if (i7 >= i6) {
            throw new FractionConversionException(d, i6);
        }
        if (j7 < i5) {
            this.numerator = BigInteger.valueOf(j8);
            this.denominator = BigInteger.valueOf(j7);
        } else {
            this.numerator = BigInteger.valueOf(j6);
            this.denominator = BigInteger.valueOf(j10);
        }
    }

    public BigFraction(double d, int i5) {
        this(d, 0.0d, i5, 100);
    }

    public BigFraction(int i5) {
        this(BigInteger.valueOf(i5), BigInteger.ONE);
    }

    public BigFraction(int i5, int i6) {
        this(BigInteger.valueOf(i5), BigInteger.valueOf(i6));
    }

    public BigFraction(long j6) {
        this(BigInteger.valueOf(j6), BigInteger.ONE);
    }

    public BigFraction(long j6, long j7) {
        this(BigInteger.valueOf(j6), BigInteger.valueOf(j7));
    }
}

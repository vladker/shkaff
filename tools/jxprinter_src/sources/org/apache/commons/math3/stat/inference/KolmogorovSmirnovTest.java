package org.apache.commons.math3.stat.inference;

import androidx.collection.a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.commons.math3.distribution.EnumeratedRealDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.BigFractionField;
import org.apache.commons.math3.fraction.FractionConversionException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KolmogorovSmirnovTest {
    protected static final double KS_SUM_CAUCHY_CRITERION = 1.0E-20d;
    protected static final int LARGE_SAMPLE_PRODUCT = 10000;
    protected static final int MAXIMUM_PARTIAL_SUM_COUNT = 100000;

    @Deprecated
    protected static final int MONTE_CARLO_ITERATIONS = 1000000;
    protected static final double PG_SUM_RELATIVE_ERROR = 1.0E-10d;

    @Deprecated
    protected static final int SMALL_SAMPLE_PRODUCT = 200;
    private final RandomGenerator rng;

    public KolmogorovSmirnovTest() {
        this.rng = new Well19937c();
    }

    private static int c(int i5, int i6, int i7, int i8, long j6, boolean z6) {
        if (z6) {
            return FastMath.abs((((long) i5) * ((long) i8)) - (((long) i6) * ((long) i7))) <= j6 ? 1 : 0;
        }
        return FastMath.abs((((long) i5) * ((long) i8)) - (((long) i6) * ((long) i7))) < j6 ? 1 : 0;
    }

    private static long calculateIntegralD(double d, int i5, int i6, boolean z6) {
        double d6 = ((long) i5) * ((long) i6);
        long jCeil = (long) FastMath.ceil((d - 1.0E-12d) * d6);
        return (z6 && ((long) FastMath.floor((d + 1.0E-12d) * d6)) == jCeil) ? jCeil + 1 : jCeil;
    }

    private void checkArray(double[] dArr) {
        if (dArr == null) {
            throw new NullArgumentException(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        }
        if (dArr.length < 2) {
            throw new InsufficientDataException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(dArr.length), 2);
        }
    }

    private FieldMatrix<BigFraction> createExactH(double d, int i5) {
        BigFraction bigFraction;
        int i6;
        double d6 = ((double) i5) * d;
        int iCeil = (int) Math.ceil(d6);
        int i7 = iCeil * 2;
        int i8 = i7 - 1;
        double d7 = ((double) iCeil) - d6;
        if (d7 >= 1.0d) {
            throw new NumberIsTooLargeException(Double.valueOf(d7), Double.valueOf(1.0d), false);
        }
        try {
            try {
                bigFraction = new BigFraction(d7, KS_SUM_CAUCHY_CRITERION, 10000);
            } catch (FractionConversionException unused) {
                bigFraction = new BigFraction(d7, 1.0E-10d, 10000);
            }
        } catch (FractionConversionException unused2) {
            bigFraction = new BigFraction(d7, 1.0E-5d, 10000);
        }
        BigFraction[][] bigFractionArr = (BigFraction[][]) Array.newInstance((Class<?>) BigFraction.class, i8, i8);
        for (int i9 = 0; i9 < i8; i9++) {
            for (int i10 = 0; i10 < i8; i10++) {
                if ((i9 - i10) + 1 < 0) {
                    bigFractionArr[i9][i10] = BigFraction.ZERO;
                } else {
                    bigFractionArr[i9][i10] = BigFraction.ONE;
                }
            }
        }
        BigFraction[] bigFractionArr2 = new BigFraction[i8];
        bigFractionArr2[0] = bigFraction;
        for (int i11 = 1; i11 < i8; i11++) {
            bigFractionArr2[i11] = bigFraction.multiply(bigFractionArr2[i11 - 1]);
        }
        for (int i12 = 0; i12 < i8; i12++) {
            BigFraction[] bigFractionArr3 = bigFractionArr[i12];
            bigFractionArr3[0] = bigFractionArr3[0].subtract(bigFractionArr2[i12]);
            BigFraction[] bigFractionArr4 = bigFractionArr[i7 - 2];
            bigFractionArr4[i12] = bigFractionArr4[i12].subtract(bigFractionArr2[(i8 - i12) - 1]);
        }
        if (bigFraction.compareTo(BigFraction.ONE_HALF) == 1) {
            BigFraction[] bigFractionArr5 = bigFractionArr[i7 - 2];
            bigFractionArr5[0] = bigFractionArr5[0].add(bigFraction.multiply(2).subtract(1).pow(i8));
        }
        int i13 = 0;
        while (i13 < i8) {
            int i14 = 0;
            while (true) {
                i6 = i13 + 1;
                if (i14 < i6) {
                    int i15 = (i13 - i14) + 1;
                    if (i15 > 0) {
                        for (int i16 = 2; i16 <= i15; i16++) {
                            BigFraction[] bigFractionArr6 = bigFractionArr[i13];
                            bigFractionArr6[i14] = bigFractionArr6[i14].divide(i16);
                        }
                    }
                    i14++;
                }
            }
            i13 = i6;
        }
        return new Array2DRowFieldMatrix(BigFractionField.getInstance(), bigFractionArr);
    }

    private RealMatrix createRoundedH(double d, int i5) {
        int i6;
        double d6 = ((double) i5) * d;
        int iCeil = (int) Math.ceil(d6);
        int i7 = iCeil * 2;
        int i8 = i7 - 1;
        double d7 = ((double) iCeil) - d6;
        if (d7 >= 1.0d) {
            throw new NumberIsTooLargeException(Double.valueOf(d7), Double.valueOf(1.0d), false);
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i8, i8);
        for (int i9 = 0; i9 < i8; i9++) {
            for (int i10 = 0; i10 < i8; i10++) {
                if ((i9 - i10) + 1 < 0) {
                    dArr[i9][i10] = 0.0d;
                } else {
                    dArr[i9][i10] = 1.0d;
                }
            }
        }
        double[] dArr2 = new double[i8];
        dArr2[0] = d7;
        for (int i11 = 1; i11 < i8; i11++) {
            dArr2[i11] = dArr2[i11 - 1] * d7;
        }
        for (int i12 = 0; i12 < i8; i12++) {
            double[] dArr3 = dArr[i12];
            dArr3[0] = dArr3[0] - dArr2[i12];
            double[] dArr4 = dArr[i7 - 2];
            dArr4[i12] = dArr4[i12] - dArr2[(i8 - i12) - 1];
        }
        if (Double.compare(d7, 0.5d) > 0) {
            double[] dArr5 = dArr[i7 - 2];
            dArr5[0] = FastMath.pow((d7 * 2.0d) - 1.0d, i8) + dArr5[0];
        }
        int i13 = 0;
        while (i13 < i8) {
            int i14 = 0;
            while (true) {
                i6 = i13 + 1;
                if (i14 < i6) {
                    int i15 = (i13 - i14) + 1;
                    if (i15 > 0) {
                        for (int i16 = 2; i16 <= i15; i16++) {
                            double[] dArr6 = dArr[i13];
                            dArr6[i14] = dArr6[i14] / ((double) i16);
                        }
                    }
                    i14++;
                }
            }
            i13 = i6;
        }
        return MatrixUtils.createRealMatrix(dArr);
    }

    private double exactK(double d, int i5) {
        int iCeil = ((int) Math.ceil(((double) i5) * d)) - 1;
        BigFraction bigFractionDivide = (BigFraction) createExactH(d, i5).power(i5).getEntry(iCeil, iCeil);
        for (int i6 = 1; i6 <= i5; i6++) {
            bigFractionDivide = bigFractionDivide.multiply(i6).divide(i5);
        }
        return bigFractionDivide.bigDecimalValue(20, 4).doubleValue();
    }

    public static void fillBooleanArrayRandomlyWithFixedNumberTrueValues(boolean[] zArr, int i5, RandomGenerator randomGenerator) {
        Arrays.fill(zArr, true);
        while (i5 < zArr.length) {
            int i6 = i5 + 1;
            int iNextInt = randomGenerator.nextInt(i6);
            if (zArr[iNextInt]) {
                i5 = iNextInt;
            }
            zArr[i5] = false;
            i5 = i6;
        }
    }

    private static void fixTies(double[] dArr, double[] dArr2) {
        boolean zHasTies;
        double[] dArrUnique = MathArrays.unique(MathArrays.concatenate(dArr, dArr2));
        if (dArrUnique.length == dArr.length + dArr2.length) {
            return;
        }
        int i5 = 0;
        double d = dArrUnique[0];
        double d6 = 1.0d;
        int i6 = 1;
        while (i6 < dArrUnique.length) {
            double d7 = dArrUnique[i6];
            double d8 = d - d7;
            if (d8 < d6) {
                d6 = d8;
            }
            i6++;
            d = d7;
        }
        double d9 = d6 / 2.0d;
        UniformRealDistribution uniformRealDistribution = new UniformRealDistribution(new JDKRandomGenerator(100), -d9, d9);
        do {
            jitter(dArr, uniformRealDistribution);
            jitter(dArr2, uniformRealDistribution);
            zHasTies = hasTies(dArr, dArr2);
            i5++;
            if (!zHasTies) {
                break;
            }
        } while (i5 < 1000);
        if (zHasTies) {
            throw new MathInternalError();
        }
    }

    private static boolean hasTies(double[] dArr, double[] dArr2) {
        HashSet hashSet = new HashSet();
        for (double d : dArr) {
            if (!hashSet.add(Double.valueOf(d))) {
                return true;
            }
        }
        for (double d6 : dArr2) {
            if (!hashSet.add(Double.valueOf(d6))) {
                return true;
            }
        }
        return false;
    }

    private long integralKolmogorovSmirnovStatistic(double[] dArr, double[] dArr2) {
        checkArray(dArr);
        checkArray(dArr2);
        double[] dArrCopyOf = MathArrays.copyOf(dArr);
        double[] dArrCopyOf2 = MathArrays.copyOf(dArr2);
        Arrays.sort(dArrCopyOf);
        Arrays.sort(dArrCopyOf2);
        int length = dArrCopyOf.length;
        int length2 = dArrCopyOf2.length;
        int i5 = 0;
        long j6 = 0;
        int i6 = 0;
        long j7 = 0;
        do {
            double d = Double.compare(dArrCopyOf[i5], dArrCopyOf2[i6]) <= 0 ? dArrCopyOf[i5] : dArrCopyOf2[i6];
            while (i5 < length && Double.compare(dArrCopyOf[i5], d) == 0) {
                i5++;
                j7 += (long) length2;
            }
            while (i6 < length2 && Double.compare(dArrCopyOf2[i6], d) == 0) {
                i6++;
                j7 -= (long) length;
            }
            if (j7 > j6) {
                j6 = j7;
            } else {
                long j8 = -j7;
                if (j8 > j6) {
                    j6 = j8;
                }
            }
            if (i5 >= length) {
                break;
            }
        } while (i6 < length2);
        return j6;
    }

    private double integralMonteCarloP(long j6, int i5, int i6, int i7) {
        int iMax = FastMath.max(i5, i6);
        int iMin = FastMath.min(i5, i6);
        int i8 = iMax + iMin;
        boolean[] zArr = new boolean[i8];
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            fillBooleanArrayRandomlyWithFixedNumberTrueValues(zArr, iMax, this.rng);
            long j7 = 0;
            for (int i11 = 0; i11 < i8; i11++) {
                if (zArr[i11]) {
                    j7 += (long) iMin;
                    if (j7 >= j6) {
                        i9++;
                        break;
                    }
                } else {
                    j7 -= (long) iMax;
                    if (j7 <= (-j6)) {
                        i9++;
                        break;
                        break;
                    }
                }
            }
        }
        return ((double) i9) / ((double) i7);
    }

    private static void jitter(double[] dArr, RealDistribution realDistribution) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = realDistribution.sample() + dArr[i5];
        }
    }

    private static double n(int i5, int i6, int i7, int i8, long j6, boolean z6) {
        int i9 = i8;
        double[] dArr = new double[i9];
        int i10 = 0;
        while (i10 < i9) {
            int i11 = i10 + 1;
            dArr[i10] = c(0, i11, i7, i9, j6, z6);
            i9 = i8;
            i10 = i11;
        }
        double d = 0.0d;
        int i12 = 1;
        while (i12 <= i5) {
            int i13 = i12;
            double dC = c(i13, 0, i7, i8, j6, z6);
            for (int i14 = 1; i14 <= i6; i14++) {
                int i15 = i14 - 1;
                dC = (dC + dArr[i15]) * ((double) c(i13, i14, i7, i8, j6, z6));
                dArr[i15] = dC;
            }
            i12 = i13 + 1;
            d = dC;
        }
        return d;
    }

    private double roundedK(double d, int i5) {
        double d6 = i5;
        int iCeil = ((int) Math.ceil(d6 * d)) - 1;
        double entry = createRoundedH(d, i5).power(i5).getEntry(iCeil, iCeil);
        for (int i6 = 1; i6 <= i5; i6++) {
            entry *= ((double) i6) / d6;
        }
        return entry;
    }

    public double approximateP(double d, int i5, int i6) {
        double d6 = i6;
        double d7 = i5;
        return 1.0d - ksSum(FastMath.sqrt((d6 * d7) / (d6 + d7)) * d, KS_SUM_CAUCHY_CRITERION, 100000);
    }

    public double bootstrap(double[] dArr, double[] dArr2, int i5, boolean z6) {
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] dArr3 = new double[length + length2];
        System.arraycopy(dArr, 0, dArr3, 0, length);
        System.arraycopy(dArr2, 0, dArr3, length, length2);
        EnumeratedRealDistribution enumeratedRealDistribution = new EnumeratedRealDistribution(this.rng, dArr3);
        long jIntegralKolmogorovSmirnovStatistic = integralKolmogorovSmirnovStatistic(dArr, dArr2);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            long jIntegralKolmogorovSmirnovStatistic2 = integralKolmogorovSmirnovStatistic(enumeratedRealDistribution.sample(length), enumeratedRealDistribution.sample(length2));
            if (jIntegralKolmogorovSmirnovStatistic2 > jIntegralKolmogorovSmirnovStatistic) {
                i6++;
            } else if (jIntegralKolmogorovSmirnovStatistic2 == jIntegralKolmogorovSmirnovStatistic) {
                i7++;
            }
        }
        if (!z6) {
            i6 += i7;
        }
        return ((double) i6) / ((double) i5);
    }

    public double cdf(double d, int i5) {
        return cdf(d, i5, false);
    }

    public double cdfExact(double d, int i5) {
        return cdf(d, i5, true);
    }

    public double exactP(double d, int i5, int i6, boolean z6) {
        return 1.0d - (n(i6, i5, i6, i5, calculateIntegralD(d, i6, i5, z6), z6) / CombinatoricsUtils.binomialCoefficientDouble(i5 + i6, i6));
    }

    public double kolmogorovSmirnovStatistic(RealDistribution realDistribution, double[] dArr) {
        checkArray(dArr);
        int length = dArr.length;
        double d = length;
        double[] dArr2 = new double[length];
        System.arraycopy(dArr, 0, dArr2, 0, length);
        Arrays.sort(dArr2);
        double d6 = 0.0d;
        for (int i5 = 1; i5 <= length; i5++) {
            int i6 = i5 - 1;
            double dCumulativeProbability = realDistribution.cumulativeProbability(dArr2[i6]);
            double dMax = FastMath.max(dCumulativeProbability - (((double) i6) / d), (((double) i5) / d) - dCumulativeProbability);
            if (dMax > d6) {
                d6 = dMax;
            }
        }
        return d6;
    }

    public double kolmogorovSmirnovTest(RealDistribution realDistribution, double[] dArr, boolean z6) {
        return 1.0d - cdf(kolmogorovSmirnovStatistic(realDistribution, dArr), dArr.length, z6);
    }

    public double ksSum(double d, double d6, int i5) {
        if (d == 0.0d) {
            return 0.0d;
        }
        double d7 = (-2.0d) * d * d;
        double d8 = 0.5d;
        double dExp = 1.0d;
        long j6 = 1;
        int i6 = -1;
        while (dExp > d6 && j6 < i5) {
            double d9 = j6;
            dExp = FastMath.exp(d7 * d9 * d9);
            d8 += ((double) i6) * dExp;
            i6 *= -1;
            j6++;
        }
        if (j6 != i5) {
            return d8 * 2.0d;
        }
        throw new TooManyIterationsException(Integer.valueOf(i5));
    }

    public double monteCarloP(double d, int i5, int i6, boolean z6, int i7) {
        return integralMonteCarloP(calculateIntegralD(d, i5, i6, z6), i5, i6, i7);
    }

    public double pelzGood(double d, int i5) {
        Integer num;
        double d6;
        int i6;
        int i7;
        int i8 = 100000;
        Integer num2 = 100000;
        double d7 = i5;
        double dSqrt = FastMath.sqrt(d7);
        double d8 = d * dSqrt;
        double d9 = d * d * d7;
        double d10 = d9 * d9;
        double d11 = d10 * d9;
        double d12 = d10 * d10;
        double d13 = 9.869604401089358d / (8.0d * d9);
        double d14 = 0.0d;
        double d15 = 0.0d;
        int i9 = 1;
        while (true) {
            if (i9 >= i8) {
                num = num2;
                break;
            }
            num = num2;
            double d16 = (i9 * 2) - 1;
            double dExp = FastMath.exp((-d13) * d16 * d16);
            d15 += dExp;
            if (dExp <= d15 * 1.0E-10d) {
                i8 = 100000;
                break;
            }
            i9++;
            num2 = num;
            i8 = 100000;
        }
        if (i9 == i8) {
            throw new TooManyIterationsException(num);
        }
        double dSqrt2 = (FastMath.sqrt(6.283185307179586d) * d15) / d8;
        double d17 = 2.0d;
        double d18 = d9 * 2.0d;
        double d19 = 0.0d;
        int i10 = 0;
        while (true) {
            d6 = d17;
            if (i10 >= i8) {
                break;
            }
            double d20 = ((double) i10) + 0.5d;
            double d21 = d20 * d20;
            double dExp2 = FastMath.exp((d21 * (-9.869604401089358d)) / d18) * ((d21 * 9.869604401089358d) - d9);
            d19 += dExp2;
            if (FastMath.abs(dExp2) < FastMath.abs(d19) * 1.0E-10d) {
                i8 = 100000;
                break;
            }
            i10++;
            d17 = d6;
            i8 = 100000;
        }
        if (i10 == i8) {
            throw new TooManyIterationsException(num);
        }
        double dSqrt3 = FastMath.sqrt(1.5707963267948966d);
        double d22 = ((d19 * dSqrt3) / ((3.0d * d10) * dSqrt)) + dSqrt2;
        double d23 = d10 * d6;
        double d24 = 6.0d * d11;
        double d25 = d9 * 5.0d;
        double d26 = 0.0d;
        int i11 = 0;
        while (true) {
            if (i11 >= 100000) {
                i6 = 100000;
                break;
            }
            double d27 = d24;
            double d28 = ((double) i11) + 0.5d;
            double d29 = d28 * d28;
            double dExp3 = FastMath.exp((d29 * (-9.869604401089358d)) / d18) * (((1.0d - d18) * 97.40909103400243d * d29 * d29) + ((d23 - d25) * 9.869604401089358d * d29) + d27 + d23);
            d26 += dExp3;
            if (FastMath.abs(dExp3) < FastMath.abs(d26) * 1.0E-10d) {
                i6 = 100000;
                break;
            }
            i11++;
            d24 = d27;
        }
        if (i11 == i6) {
            throw new TooManyIterationsException(num);
        }
        double d30 = 0.0d;
        int i12 = 1;
        while (i12 < i6) {
            double d31 = i12 * i12;
            double dExp4 = FastMath.exp((d31 * (-9.869604401089358d)) / d18) * d31 * 9.869604401089358d;
            d30 += dExp4;
            if (FastMath.abs(dExp4) < FastMath.abs(d30) * 1.0E-10d) {
                i6 = 100000;
                break;
            }
            i12++;
            i6 = 100000;
        }
        if (i12 == i6) {
            throw new TooManyIterationsException(num);
        }
        double d32 = (((d26 / ((((36.0d * d9) * d9) * d9) * d8)) - (d30 / ((18.0d * d9) * d8))) * (dSqrt3 / d7)) + d22;
        double d33 = 0.0d;
        int i13 = 0;
        while (true) {
            i7 = 100000;
            if (i13 >= 100000) {
                break;
            }
            double d34 = ((double) i13) + 0.5d;
            double d35 = d34 * d34;
            double d36 = d35 * d35;
            double dExp5 = FastMath.exp((d35 * (-9.869604401089358d)) / d18) * ((((((135.0d * d10) - (96.0d * d11)) * (d35 * 9.869604401089358d)) + ((((212.0d * d10) + ((-60.0d) * d9)) * (d36 * 97.40909103400243d)) + ((5.0d - (d9 * 30.0d)) * ((d36 * d35) * 961.3891935753043d)))) - (30.0d * d11)) - (90.0d * d12));
            d33 += dExp5;
            if (FastMath.abs(dExp5) < FastMath.abs(d33) * 1.0E-10d) {
                i7 = 100000;
                break;
            }
            i13++;
        }
        if (i13 == i7) {
            throw new TooManyIterationsException(num);
        }
        int i14 = 1;
        while (i14 < i7) {
            double d37 = i14 * i14;
            double dExp6 = FastMath.exp((d37 * (-9.869604401089358d)) / d18) * a.C(d37, 29.608813203268074d, d9, d37 * d37 * (-97.40909103400243d));
            d14 += dExp6;
            if (FastMath.abs(dExp6) < FastMath.abs(d14) * 1.0E-10d) {
                i7 = 100000;
                break;
            }
            i14++;
            i7 = 100000;
        }
        if (i14 == i7) {
            throw new TooManyIterationsException(num);
        }
        return (((d14 / (d11 * 108.0d)) + (d33 / ((3240.0d * d11) * d10))) * (dSqrt3 / (dSqrt * d7))) + d32;
    }

    public double cdf(double d, int i5, boolean z6) {
        double d6 = i5;
        double d7 = 1.0d;
        double d8 = 1.0d / d6;
        double d9 = 0.5d * d8;
        if (d <= d9) {
            return 0.0d;
        }
        if (d9 < d && d <= d8) {
            double d10 = (d * 2.0d) - d8;
            for (int i6 = 1; i6 <= i5; i6++) {
                d7 *= ((double) i6) * d10;
            }
            return d7;
        }
        if (1.0d - d8 <= d && d < 1.0d) {
            return 1.0d - (Math.pow(1.0d - d, d6) * 2.0d);
        }
        if (1.0d <= d) {
            return 1.0d;
        }
        if (z6) {
            return exactK(d, i5);
        }
        return i5 <= 140 ? roundedK(d, i5) : pelzGood(d, i5);
    }

    public double kolmogorovSmirnovTest(double[] dArr, double[] dArr2, boolean z6) {
        double[] dArrCopyOf;
        double[] dArrCopyOf2;
        long length = ((long) dArr.length) * ((long) dArr2.length);
        if (length >= 10000 || !hasTies(dArr, dArr2)) {
            dArrCopyOf = dArr;
            dArrCopyOf2 = dArr2;
        } else {
            dArrCopyOf = MathArrays.copyOf(dArr);
            dArrCopyOf2 = MathArrays.copyOf(dArr2);
            fixTies(dArrCopyOf, dArrCopyOf2);
        }
        return length < 10000 ? exactP(kolmogorovSmirnovStatistic(dArrCopyOf, dArrCopyOf2), dArr.length, dArr2.length, z6) : approximateP(kolmogorovSmirnovStatistic(dArr, dArr2), dArr.length, dArr2.length);
    }

    @Deprecated
    public KolmogorovSmirnovTest(RandomGenerator randomGenerator) {
        this.rng = randomGenerator;
    }

    public double kolmogorovSmirnovStatistic(double[] dArr, double[] dArr2) {
        return integralKolmogorovSmirnovStatistic(dArr, dArr2) / (((long) dArr.length) * ((long) dArr2.length));
    }

    public double kolmogorovSmirnovTest(double[] dArr, double[] dArr2) {
        return kolmogorovSmirnovTest(dArr, dArr2, true);
    }

    public double kolmogorovSmirnovTest(RealDistribution realDistribution, double[] dArr) {
        return kolmogorovSmirnovTest(realDistribution, dArr, false);
    }

    public double bootstrap(double[] dArr, double[] dArr2, int i5) {
        return bootstrap(dArr, dArr2, i5, true);
    }

    public boolean kolmogorovSmirnovTest(RealDistribution realDistribution, double[] dArr, double d) {
        if (d <= 0.0d || d > 0.5d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, Double.valueOf(d), 0, Double.valueOf(0.5d));
        }
        return kolmogorovSmirnovTest(realDistribution, dArr) < d;
    }
}

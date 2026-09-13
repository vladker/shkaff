package org.apache.commons.math3.distribution;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.BigFractionField;
import org.apache.commons.math3.fraction.FractionConversionException;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KolmogorovSmirnovDistribution implements Serializable {
    private static final long serialVersionUID = -4670676796862967187L;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6763n;

    public KolmogorovSmirnovDistribution(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        this.f6763n = i5;
    }

    private FieldMatrix<BigFraction> createH(double d) {
        BigFraction bigFraction;
        int i5;
        int iCeil = (int) FastMath.ceil(((double) this.f6763n) * d);
        int i6 = iCeil * 2;
        int i7 = i6 - 1;
        double d6 = ((double) iCeil) - (((double) this.f6763n) * d);
        if (d6 >= 1.0d) {
            throw new NumberIsTooLargeException(Double.valueOf(d6), Double.valueOf(1.0d), false);
        }
        try {
            try {
                bigFraction = new BigFraction(d6, 1.0E-20d, 10000);
            } catch (FractionConversionException unused) {
                bigFraction = new BigFraction(d6, 1.0E-5d, 10000);
            }
        } catch (FractionConversionException unused2) {
            bigFraction = new BigFraction(d6, 1.0E-10d, 10000);
        }
        BigFraction[][] bigFractionArr = (BigFraction[][]) Array.newInstance((Class<?>) BigFraction.class, i7, i7);
        for (int i8 = 0; i8 < i7; i8++) {
            for (int i9 = 0; i9 < i7; i9++) {
                if ((i8 - i9) + 1 < 0) {
                    bigFractionArr[i8][i9] = BigFraction.ZERO;
                } else {
                    bigFractionArr[i8][i9] = BigFraction.ONE;
                }
            }
        }
        BigFraction[] bigFractionArr2 = new BigFraction[i7];
        bigFractionArr2[0] = bigFraction;
        for (int i10 = 1; i10 < i7; i10++) {
            bigFractionArr2[i10] = bigFraction.multiply(bigFractionArr2[i10 - 1]);
        }
        for (int i11 = 0; i11 < i7; i11++) {
            BigFraction[] bigFractionArr3 = bigFractionArr[i11];
            bigFractionArr3[0] = bigFractionArr3[0].subtract(bigFractionArr2[i11]);
            BigFraction[] bigFractionArr4 = bigFractionArr[i6 - 2];
            bigFractionArr4[i11] = bigFractionArr4[i11].subtract(bigFractionArr2[(i7 - i11) - 1]);
        }
        if (bigFraction.compareTo(BigFraction.ONE_HALF) == 1) {
            BigFraction[] bigFractionArr5 = bigFractionArr[i6 - 2];
            bigFractionArr5[0] = bigFractionArr5[0].add(bigFraction.multiply(2).subtract(1).pow(i7));
        }
        int i12 = 0;
        while (i12 < i7) {
            int i13 = 0;
            while (true) {
                i5 = i12 + 1;
                if (i13 < i5) {
                    int i14 = (i12 - i13) + 1;
                    if (i14 > 0) {
                        for (int i15 = 2; i15 <= i14; i15++) {
                            BigFraction[] bigFractionArr6 = bigFractionArr[i12];
                            bigFractionArr6[i13] = bigFractionArr6[i13].divide(i15);
                        }
                    }
                    i13++;
                }
            }
            i12 = i5;
        }
        return new Array2DRowFieldMatrix(BigFractionField.getInstance(), bigFractionArr);
    }

    private double exactK(double d) {
        int iCeil = (int) FastMath.ceil(((double) this.f6763n) * d);
        int i5 = iCeil - 1;
        BigFraction bigFractionDivide = (BigFraction) createH(d).power(this.f6763n).getEntry(i5, i5);
        for (int i6 = 1; i6 <= this.f6763n; i6++) {
            bigFractionDivide = bigFractionDivide.multiply(i6).divide(this.f6763n);
        }
        return bigFractionDivide.bigDecimalValue(20, 4).doubleValue();
    }

    private double roundedK(double d) {
        int iCeil = (int) FastMath.ceil(((double) this.f6763n) * d);
        FieldMatrix<BigFraction> fieldMatrixCreateH = createH(d);
        int rowDimension = fieldMatrixCreateH.getRowDimension();
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(rowDimension, rowDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                array2DRowRealMatrix.setEntry(i5, i6, ((BigFraction) fieldMatrixCreateH.getEntry(i5, i6)).doubleValue());
            }
        }
        int i7 = 1;
        int i8 = iCeil - 1;
        double entry = array2DRowRealMatrix.power(this.f6763n).getEntry(i8, i8);
        while (true) {
            int i9 = this.f6763n;
            if (i7 > i9) {
                return entry;
            }
            entry *= ((double) i7) / ((double) i9);
            i7++;
        }
    }

    public double cdf(double d) {
        return cdf(d, false);
    }

    public double cdfExact(double d) {
        return cdf(d, true);
    }

    public double cdf(double d, boolean z6) {
        int i5 = this.f6763n;
        double d6 = 1.0d;
        double d7 = 1.0d / ((double) i5);
        double d8 = 0.5d * d7;
        if (d <= d8) {
            return 0.0d;
        }
        if (d8 >= d || d > d7) {
            if (1.0d - d7 <= d && d < 1.0d) {
                return 1.0d - (FastMath.pow(1.0d - d, i5) * 2.0d);
            }
            if (1.0d <= d) {
                return 1.0d;
            }
            return z6 ? exactK(d) : roundedK(d);
        }
        double d9 = (d * 2.0d) - d7;
        for (int i6 = 1; i6 <= this.f6763n; i6++) {
            d6 *= ((double) i6) * d9;
        }
        return d6;
    }
}

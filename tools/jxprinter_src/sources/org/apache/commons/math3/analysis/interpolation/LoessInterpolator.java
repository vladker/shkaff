package org.apache.commons.math3.analysis.interpolation;

import com.google.android.gms.auth.api.accounttransfer.a;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LoessInterpolator implements UnivariateInterpolator, Serializable {
    public static final double DEFAULT_ACCURACY = 1.0E-12d;
    public static final double DEFAULT_BANDWIDTH = 0.3d;
    public static final int DEFAULT_ROBUSTNESS_ITERS = 2;
    private static final long serialVersionUID = 5204927143605193821L;
    private final double accuracy;
    private final double bandwidth;
    private final int robustnessIters;

    public LoessInterpolator() {
        this.bandwidth = 0.3d;
        this.robustnessIters = 2;
        this.accuracy = 1.0E-12d;
    }

    private static void checkAllFiniteReal(double[] dArr) {
        for (double d : dArr) {
            MathUtils.checkFinite(d);
        }
    }

    private static int nextNonzero(double[] dArr, int i5) {
        do {
            i5++;
            if (i5 >= dArr.length) {
                break;
            }
        } while (dArr[i5] == 0.0d);
        return i5;
    }

    private static double tricube(double d) {
        double dAbs = FastMath.abs(d);
        if (dAbs >= 1.0d) {
            return 0.0d;
        }
        double d6 = 1.0d - ((dAbs * dAbs) * dAbs);
        return d6 * d6 * d6;
    }

    private static void updateBandwidthInterval(double[] dArr, double[] dArr2, int i5, int[] iArr) {
        int i6 = iArr[0];
        int iNextNonzero = nextNonzero(dArr2, iArr[1]);
        if (iNextNonzero < dArr.length) {
            double d = dArr[iNextNonzero];
            double d6 = dArr[i5];
            if (d - d6 < d6 - dArr[i6]) {
                iArr[0] = nextNonzero(dArr2, iArr[0]);
                iArr[1] = iNextNonzero;
            }
        }
    }

    public final double[] smooth(double[] dArr, double[] dArr2, double[] dArr3) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException();
        }
        checkAllFiniteReal(dArr);
        checkAllFiniteReal(dArr2);
        checkAllFiniteReal(dArr3);
        MathArrays.checkOrder(dArr);
        int i5 = 0;
        char c = 1;
        if (length == 1) {
            return new double[]{dArr2[0]};
        }
        if (length == 2) {
            return new double[]{dArr2[0], dArr2[1]};
        }
        int i6 = (int) (this.bandwidth * ((double) length));
        if (i6 < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.BANDWIDTH, Integer.valueOf(i6), 2, true);
        }
        double[] dArr4 = new double[length];
        double[] dArr5 = new double[length];
        double[] dArr6 = new double[length];
        double[] dArr7 = new double[length];
        double d = 1.0d;
        Arrays.fill(dArr7, 1.0d);
        int i7 = 0;
        while (i7 <= this.robustnessIters) {
            int[] iArr = {i5, i6 - 1};
            double d6 = d;
            int i8 = i5;
            while (true) {
                double dA = 0.0d;
                if (i8 >= length) {
                    break;
                }
                double d7 = dArr[i8];
                if (i8 > 0) {
                    updateBandwidthInterval(dArr, dArr3, i8, iArr);
                }
                int i9 = iArr[i5];
                char c6 = c;
                int i10 = iArr[c6];
                double d8 = dArr[i8];
                double dAbs = FastMath.abs(d6 / (dArr[d8 - dArr[i9] > dArr[i10] - d8 ? i9 : i10] - d7));
                double d9 = 0.0d;
                double d10 = 0.0d;
                double d11 = 0.0d;
                double d12 = 0.0d;
                double d13 = 0.0d;
                while (i9 <= i10) {
                    double d14 = dArr[i9];
                    double d15 = dArr2[i9];
                    double dTricube = tricube((i9 < i8 ? d7 - d14 : d14 - d7) * dAbs) * dArr7[i9] * dArr3[i9];
                    double d16 = d14 * dTricube;
                    d10 += dTricube;
                    d9 += d16;
                    d13 = (d14 * d16) + d13;
                    d11 = (dTricube * d15) + d11;
                    d12 = (d15 * d16) + d12;
                    i9++;
                }
                double d17 = d9 / d10;
                double d18 = d11 / d10;
                double d19 = d12 / d10;
                double d20 = (d13 / d10) - (d17 * d17);
                if (FastMath.sqrt(FastMath.abs(d20)) >= this.accuracy) {
                    dA = a.a(d17, d18, d19, d20);
                }
                double d21 = (dA * d7) + (d18 - (d17 * dA));
                dArr4[i8] = d21;
                dArr5[i8] = FastMath.abs(dArr2[i8] - d21);
                i8++;
                c = c6;
                i5 = 0;
            }
            char c7 = c;
            if (i7 == this.robustnessIters) {
                break;
            }
            System.arraycopy(dArr5, 0, dArr6, 0, length);
            Arrays.sort(dArr6);
            double d22 = dArr6[length / 2];
            int i11 = i7;
            if (FastMath.abs(d22) < this.accuracy) {
                break;
            }
            for (int i12 = 0; i12 < length; i12++) {
                double d23 = dArr5[i12] / (6.0d * d22);
                if (d23 >= d6) {
                    dArr7[i12] = 0.0d;
                } else {
                    double d24 = d6 - (d23 * d23);
                    dArr7[i12] = d24 * d24;
                }
            }
            i7 = i11 + 1;
            d = d6;
            c = c7;
            i5 = 0;
        }
        return dArr4;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public final PolynomialSplineFunction interpolate(double[] dArr, double[] dArr2) {
        return new SplineInterpolator().interpolate(dArr, smooth(dArr, dArr2));
    }

    public LoessInterpolator(double d, int i5) {
        this(d, i5, 1.0E-12d);
    }

    public LoessInterpolator(double d, int i5, double d6) {
        if (d >= 0.0d && d <= 1.0d) {
            this.bandwidth = d;
            if (i5 >= 0) {
                this.robustnessIters = i5;
                this.accuracy = d6;
                return;
            }
            throw new NotPositiveException(LocalizedFormats.ROBUSTNESS_ITERATIONS, Integer.valueOf(i5));
        }
        throw new OutOfRangeException(LocalizedFormats.BANDWIDTH, Double.valueOf(d), 0, 1);
    }

    public final double[] smooth(double[] dArr, double[] dArr2) {
        if (dArr.length == dArr2.length) {
            double[] dArr3 = new double[dArr.length];
            Arrays.fill(dArr3, 1.0d);
            return smooth(dArr, dArr2, dArr3);
        }
        throw new DimensionMismatchException(dArr.length, dArr2.length);
    }
}

package org.apache.commons.math3.fitting.leastsquares;

import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LevenbergMarquardtOptimizer implements LeastSquaresOptimizer {
    private static final double TWO_EPS = Precision.EPSILON * 2.0d;
    private final double costRelativeTolerance;
    private final double initialStepBoundFactor;
    private final double orthoTolerance;
    private final double parRelativeTolerance;
    private final double qrRankingThreshold;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InternalData {
        private final double[] beta;
        private final double[] diagR;
        private final double[] jacNorm;
        private final int[] permutation;
        private final int rank;
        private final double[][] weightedJacobian;

        public InternalData(double[][] dArr, int[] iArr, int i5, double[] dArr2, double[] dArr3, double[] dArr4) {
            this.weightedJacobian = dArr;
            this.permutation = iArr;
            this.rank = i5;
            this.diagR = dArr2;
            this.jacNorm = dArr3;
            this.beta = dArr4;
        }
    }

    public LevenbergMarquardtOptimizer() {
        this(100.0d, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    private void determineLMDirection(double[] dArr, double[] dArr2, double[] dArr3, InternalData internalData, int i5, double[] dArr4, double[] dArr5) {
        double[][] dArr6;
        double d;
        double d6;
        int[] iArr = internalData.permutation;
        double[][] dArr7 = internalData.weightedJacobian;
        double[] dArr8 = internalData.diagR;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = iArr[i6];
            int i8 = i6 + 1;
            for (int i9 = i8; i9 < i5; i9++) {
                dArr7[i9][i7] = dArr7[i6][iArr[i9]];
            }
            dArr5[i6] = dArr8[i7];
            dArr4[i6] = dArr[i6];
            i6 = i8;
        }
        int i10 = 0;
        while (true) {
            double d7 = 0.0d;
            if (i10 >= i5) {
                break;
            }
            double d8 = dArr2[iArr[i10]];
            if (d8 != 0.0d) {
                Arrays.fill(dArr3, i10 + 1, dArr3.length, 0.0d);
            }
            dArr3[i10] = d8;
            int i11 = i10;
            double d9 = 0.0d;
            while (i11 < i5) {
                int i12 = iArr[i11];
                if (dArr3[i11] != d7) {
                    double d10 = dArr7[i11][i12];
                    if (FastMath.abs(d10) < FastMath.abs(dArr3[i11])) {
                        double d11 = d10 / dArr3[i11];
                        double dSqrt = 1.0d / FastMath.sqrt((d11 * d11) + 1.0d);
                        d6 = d11 * dSqrt;
                        d = dSqrt;
                    } else {
                        double d12 = dArr3[i11] / d10;
                        double dSqrt2 = 1.0d / FastMath.sqrt((d12 * d12) + 1.0d);
                        d = d12 * dSqrt2;
                        d6 = dSqrt2;
                    }
                    dArr7[i11][i12] = (dArr3[i11] * d) + (d10 * d6);
                    double d13 = dArr4[i11];
                    double d14 = (d * d9) + (d6 * d13);
                    dArr6 = dArr7;
                    double d15 = -d;
                    d9 = (d9 * d6) + (d13 * d15);
                    dArr4[i11] = d14;
                    for (int i13 = i11 + 1; i13 < i5; i13++) {
                        double[] dArr9 = dArr6[i13];
                        double d16 = dArr9[i12];
                        double d17 = dArr3[i13];
                        dArr3[i13] = (d17 * d6) + (d16 * d15);
                        dArr9[i12] = (d * d17) + (d6 * d16);
                    }
                } else {
                    dArr6 = dArr7;
                    d7 = d7;
                }
                i11++;
                iArr = iArr;
                dArr7 = dArr6;
                d7 = d7;
            }
            int[] iArr2 = iArr;
            double[][] dArr10 = dArr7;
            double[] dArr11 = dArr10[i10];
            int i14 = iArr2[i10];
            dArr3[i10] = dArr11[i14];
            dArr11[i14] = dArr5[i10];
            i10++;
            iArr = iArr2;
            dArr7 = dArr10;
        }
        double[][] dArr12 = dArr7;
        int[] iArr3 = iArr;
        int i15 = i5;
        for (int i16 = 0; i16 < i5; i16++) {
            if (dArr3[i16] == 0.0d && i15 == i5) {
                i15 = i16;
            }
            if (i15 < i5) {
                dArr4[i16] = 0.0d;
            }
        }
        if (i15 > 0) {
            for (int i17 = i15 - 1; i17 >= 0; i17--) {
                int i18 = iArr3[i17];
                double d18 = 0.0d;
                for (int i19 = i17 + 1; i19 < i15; i19++) {
                    d18 += dArr12[i19][i18] * dArr4[i19];
                }
                dArr4[i17] = (dArr4[i17] - d18) / dArr3[i17];
            }
        }
        for (int i20 = 0; i20 < dArr5.length; i20++) {
            dArr5[iArr3[i20]] = dArr4[i20];
        }
    }

    private double determineLMParameter(double[] dArr, double d, double[] dArr2, InternalData internalData, int i5, double[] dArr3, double[] dArr4, double[] dArr5, double[] dArr6, double d6) {
        double d7;
        double[][] dArr7 = internalData.weightedJacobian;
        int[] iArr = internalData.permutation;
        int i6 = internalData.rank;
        double[] dArr8 = internalData.diagR;
        int length = dArr7[0].length;
        for (int i7 = 0; i7 < i6; i7++) {
            dArr6[iArr[i7]] = dArr[i7];
        }
        for (int i8 = i6; i8 < length; i8++) {
            dArr6[iArr[i8]] = 0.0d;
        }
        for (int i9 = i6 - 1; i9 >= 0; i9--) {
            int i10 = iArr[i9];
            double d8 = dArr6[i10] / dArr8[i10];
            for (int i11 = 0; i11 < i9; i11++) {
                int i12 = iArr[i11];
                dArr6[i12] = dArr6[i12] - (dArr7[i11][i10] * d8);
            }
            dArr6[i10] = d8;
        }
        double d9 = 0.0d;
        for (int i13 = 0; i13 < i5; i13++) {
            int i14 = iArr[i13];
            double d10 = dArr2[i14] * dArr6[i14];
            dArr3[i14] = d10;
            d9 += d10 * d10;
        }
        double dSqrt = FastMath.sqrt(d9);
        double d11 = dSqrt - d;
        double d12 = d * 0.1d;
        if (d11 <= d12) {
            return 0.0d;
        }
        if (i6 == i5) {
            for (int i15 = 0; i15 < i5; i15++) {
                int i16 = iArr[i15];
                dArr3[i16] = (dArr2[i16] / dSqrt) * dArr3[i16];
            }
            double d13 = 0.0d;
            for (int i17 = 0; i17 < i5; i17++) {
                int i18 = iArr[i17];
                double d14 = 0.0d;
                for (int i19 = 0; i19 < i17; i19++) {
                    d14 = (dArr7[i19][i18] * dArr3[iArr[i19]]) + d14;
                }
                double d15 = (dArr3[i18] - d14) / dArr8[i18];
                dArr3[i18] = d15;
                d13 = (d15 * d15) + d13;
            }
            d7 = d11 / (d * d13);
        } else {
            d7 = 0.0d;
        }
        double d16 = 0.0d;
        for (int i20 = 0; i20 < i5; i20++) {
            int i21 = iArr[i20];
            double d17 = 0.0d;
            for (int i22 = 0; i22 <= i20; i22++) {
                d17 = (dArr7[i22][i21] * dArr[i22]) + d17;
            }
            double d18 = d17 / dArr2[i21];
            d16 = (d18 * d18) + d16;
        }
        double dSqrt2 = FastMath.sqrt(d16);
        double dMin = dSqrt2 / d;
        if (dMin == 0.0d) {
            dMin = Precision.SAFE_MIN / FastMath.min(d, 0.1d);
        }
        double d19 = dMin;
        double dMin2 = FastMath.min(d19, FastMath.max(d6, d7));
        if (dMin2 == 0.0d) {
            dMin2 = dSqrt2 / dSqrt;
        }
        double dMax = d7;
        double d20 = d19;
        int i23 = 10;
        while (true) {
            double d21 = d11;
            if (i23 < 0) {
                break;
            }
            if (dMin2 == 0.0d) {
                dMin2 = FastMath.max(Precision.SAFE_MIN, 0.001d * d20);
            }
            double dSqrt3 = FastMath.sqrt(dMin2);
            for (int i24 = 0; i24 < i5; i24++) {
                int i25 = iArr[i24];
                dArr3[i25] = dArr2[i25] * dSqrt3;
            }
            double[][] dArr9 = dArr7;
            int[] iArr2 = iArr;
            double dMin3 = d20;
            determineLMDirection(dArr, dArr3, dArr4, internalData, i5, dArr5, dArr6);
            double d22 = 0.0d;
            for (int i26 = 0; i26 < i5; i26++) {
                int i27 = iArr2[i26];
                double d23 = dArr2[i27] * dArr6[i27];
                dArr5[i27] = d23;
                d22 += d23 * d23;
            }
            double dSqrt4 = FastMath.sqrt(d22);
            d11 = dSqrt4 - d;
            if (FastMath.abs(d11) <= d12 || (dMax == 0.0d && d11 <= d21 && d21 < 0.0d)) {
                break;
            }
            for (int i28 = 0; i28 < i5; i28++) {
                int i29 = iArr2[i28];
                dArr3[i29] = (dArr5[i29] * dArr2[i29]) / dSqrt4;
            }
            int i30 = 0;
            while (i30 < i5) {
                int i31 = iArr2[i30];
                double d24 = dArr3[i31] / dArr4[i30];
                dArr3[i31] = d24;
                i30++;
                for (int i32 = i30; i32 < i5; i32++) {
                    int i33 = iArr2[i32];
                    dArr3[i33] = dArr3[i33] - (dArr9[i32][i31] * d24);
                }
            }
            double d25 = 0.0d;
            for (int i34 = 0; i34 < i5; i34++) {
                double d26 = dArr3[iArr2[i34]];
                d25 += d26 * d26;
            }
            double d27 = d11 / (d * d25);
            if (d11 > 0.0d) {
                dMax = FastMath.max(dMax, dMin2);
            } else if (d11 < 0.0d) {
                dMin3 = FastMath.min(dMin3, dMin2);
            }
            dMin2 = FastMath.max(dMax, dMin2 + d27);
            i23--;
            d20 = dMin3;
            dArr7 = dArr9;
            iArr = iArr2;
        }
        return dMin2;
    }

    private void qTy(double[] dArr, InternalData internalData) {
        double[][] dArr2 = internalData.weightedJacobian;
        int[] iArr = internalData.permutation;
        double[] dArr3 = internalData.beta;
        int length = dArr2.length;
        int length2 = dArr2[0].length;
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = iArr[i5];
            double d = 0.0d;
            for (int i7 = i5; i7 < length; i7++) {
                d += dArr2[i7][i6] * dArr[i7];
            }
            double d6 = d * dArr3[i6];
            for (int i8 = i5; i8 < length; i8++) {
                dArr[i8] = dArr[i8] - (dArr2[i8][i6] * d6);
            }
        }
    }

    private InternalData qrDecomposition(RealMatrix realMatrix, int i5) {
        double d;
        double[][] data = realMatrix.scalarMultiply(-1.0d).getData();
        int length = data.length;
        int i6 = 0;
        int length2 = data[0].length;
        int[] iArr = new int[length2];
        double[] dArr = new double[length2];
        double[] dArr2 = new double[length2];
        double[] dArr3 = new double[length2];
        int i7 = 0;
        while (true) {
            d = 0.0d;
            if (i7 >= length2) {
                break;
            }
            iArr[i7] = i7;
            for (double[] dArr4 : data) {
                double d6 = dArr4[i7];
                d += d6 * d6;
            }
            dArr2[i7] = FastMath.sqrt(d);
            i7++;
        }
        while (i6 < length2) {
            int i8 = -1;
            double d7 = Double.NEGATIVE_INFINITY;
            for (int i9 = i6; i9 < length2; i9++) {
                double d8 = d;
                for (int i10 = i6; i10 < length; i10++) {
                    double d9 = data[i10][iArr[i9]];
                    d8 = (d9 * d9) + d8;
                }
                if (Double.isInfinite(d8) || Double.isNaN(d8)) {
                    throw new ConvergenceException(LocalizedFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN, Integer.valueOf(length), Integer.valueOf(length2));
                }
                if (d8 > d7) {
                    i8 = i9;
                    d7 = d8;
                }
            }
            if (d7 <= this.qrRankingThreshold) {
                return new InternalData(data, iArr, i6, dArr, dArr2, dArr3);
            }
            int[] iArr2 = iArr;
            int i11 = i6;
            int i12 = length2;
            int i13 = iArr2[i8];
            iArr2[i8] = iArr2[i11];
            iArr2[i11] = i13;
            double d10 = data[i11][i13];
            double dSqrt = d10 > d ? -FastMath.sqrt(d7) : FastMath.sqrt(d7);
            double d11 = 1.0d / (d7 - (d10 * dSqrt));
            dArr3[i13] = d11;
            dArr[i13] = dSqrt;
            double[] dArr5 = data[i11];
            dArr5[i13] = dArr5[i13] - dSqrt;
            for (int i14 = (i12 - 1) - i11; i14 > 0; i14--) {
                double d12 = 0.0d;
                for (int i15 = i11; i15 < length; i15++) {
                    double[] dArr6 = data[i15];
                    d12 = (dArr6[i13] * dArr6[iArr2[i11 + i14]]) + d12;
                }
                double d13 = d12 * d11;
                for (int i16 = i11; i16 < length; i16++) {
                    double[] dArr7 = data[i16];
                    int i17 = iArr2[i11 + i14];
                    dArr7[i17] = dArr7[i17] - (dArr7[i13] * d13);
                }
            }
            length2 = i12;
            i6 = i11 + 1;
            iArr = iArr2;
            d = 0.0d;
        }
        return new InternalData(data, iArr, i5, dArr, dArr2, dArr3);
    }

    public double getCostRelativeTolerance() {
        return this.costRelativeTolerance;
    }

    public double getInitialStepBoundFactor() {
        return this.initialStepBoundFactor;
    }

    public double getOrthoTolerance() {
        return this.orthoTolerance;
    }

    public double getParameterRelativeTolerance() {
        return this.parRelativeTolerance;
    }

    public double getRankingThreshold() {
        return this.qrRankingThreshold;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer
    public LeastSquaresOptimizer.Optimum optimize(LeastSquaresProblem leastSquaresProblem) {
        double d;
        double d6;
        LeastSquaresProblem.Evaluation evaluation;
        ConvergenceChecker<LeastSquaresProblem.Evaluation> convergenceChecker;
        int observationSize = leastSquaresProblem.getObservationSize();
        int parameterSize = leastSquaresProblem.getParameterSize();
        Incrementor iterationCounter = leastSquaresProblem.getIterationCounter();
        Incrementor evaluationCounter = leastSquaresProblem.getEvaluationCounter();
        ConvergenceChecker<LeastSquaresProblem.Evaluation> convergenceChecker2 = leastSquaresProblem.getConvergenceChecker();
        int iMin = FastMath.min(observationSize, parameterSize);
        double[] dArr = new double[parameterSize];
        double[] dArr2 = new double[parameterSize];
        double[] dArr3 = new double[parameterSize];
        double[] dArr4 = new double[observationSize];
        ConvergenceChecker<LeastSquaresProblem.Evaluation> convergenceChecker3 = convergenceChecker2;
        double[] dArr5 = new double[observationSize];
        double[] dArr6 = new double[parameterSize];
        double[] dArr7 = new double[parameterSize];
        double[] dArr8 = new double[parameterSize];
        evaluationCounter.incrementCount();
        LeastSquaresProblem.Evaluation evaluationEvaluate = leastSquaresProblem.evaluate(leastSquaresProblem.getStart());
        double[] array = evaluationEvaluate.getResiduals().toArray();
        double cost = evaluationEvaluate.getCost();
        double[] array2 = evaluationEvaluate.getPoint().toArray();
        boolean z6 = true;
        double d7 = 0.0d;
        double dMin = 0.0d;
        double dSqrt = 0.0d;
        while (true) {
            iterationCounter.incrementCount();
            double[] dArr9 = dArr3;
            InternalData internalDataQrDecomposition = qrDecomposition(evaluationEvaluate.getJacobian(), iMin);
            double[][] dArr10 = internalDataQrDecomposition.weightedJacobian;
            int[] iArr = internalDataQrDecomposition.permutation;
            double[] dArr11 = internalDataQrDecomposition.diagR;
            double[] dArr12 = internalDataQrDecomposition.jacNorm;
            ConvergenceChecker<LeastSquaresProblem.Evaluation> convergenceChecker4 = convergenceChecker3;
            for (int i5 = 0; i5 < observationSize; i5++) {
                dArr5[i5] = array[i5];
            }
            qTy(dArr5, internalDataQrDecomposition);
            for (int i6 = 0; i6 < iMin; i6++) {
                int i7 = iArr[i6];
                dArr10[i6][i7] = dArr11[i7];
            }
            if (z6) {
                double d8 = 0.0d;
                for (int i8 = 0; i8 < parameterSize; i8++) {
                    double d9 = dArr12[i8];
                    if (d9 == 0.0d) {
                        d9 = 1.0d;
                    }
                    double d10 = array2[i8] * d9;
                    d8 = (d10 * d10) + d8;
                    dArr2[i8] = d9;
                }
                dSqrt = FastMath.sqrt(d8);
                dMin = dSqrt == 0.0d ? this.initialStepBoundFactor : this.initialStepBoundFactor * dSqrt;
            } else {
                dArr5 = dArr5;
                internalDataQrDecomposition = internalDataQrDecomposition;
            }
            double[] dArr13 = dArr5;
            if (cost != 0.0d) {
                double dMax = 0.0d;
                int i9 = 0;
                while (i9 < iMin) {
                    int i10 = iArr[i9];
                    double d11 = dArr12[i10];
                    if (d11 != 0.0d) {
                        double d12 = 0.0d;
                        for (int i11 = 0; i11 <= i9; i11++) {
                            d12 = (dArr10[i11][i10] * dArr13[i11]) + d12;
                        }
                        dMax = FastMath.max(dMax, FastMath.abs(d12) / (d11 * cost));
                    }
                    i9++;
                    dArr6 = dArr6;
                    dArr7 = dArr7;
                    dArr2 = dArr2;
                }
                d = dMax;
            } else {
                d = 0.0d;
            }
            double[] dArr14 = dArr2;
            double[] dArr15 = dArr6;
            double[] dArr16 = dArr7;
            if (d <= this.orthoTolerance) {
                return new OptimumImpl(evaluationEvaluate, evaluationCounter.getCount(), iterationCounter.getCount());
            }
            for (int i12 = 0; i12 < parameterSize; i12++) {
                dArr14[i12] = FastMath.max(dArr14[i12], dArr12[i12]);
            }
            LeastSquaresProblem.Evaluation evaluationEvaluate2 = evaluationEvaluate;
            double d13 = 0.0d;
            while (true) {
                dMin = dMin;
                if (d13 < 1.0E-4d) {
                    for (int i13 = 0; i13 < iMin; i13++) {
                        int i14 = iArr[i13];
                        dArr9[i14] = array2[i14];
                    }
                    double[] dArr17 = dArr15;
                    int i15 = observationSize;
                    double[] dArr18 = dArr14;
                    double[] dArr19 = array2;
                    double d14 = d7;
                    LeastSquaresProblem.Evaluation evaluation2 = evaluationEvaluate;
                    double dDetermineLMParameter = determineLMParameter(dArr13, dMin, dArr18, internalDataQrDecomposition, iMin, dArr17, dArr16, dArr8, dArr, d14);
                    double d15 = 0.0d;
                    int i16 = 0;
                    while (i16 < iMin) {
                        int i17 = iArr[i16];
                        double[] dArr20 = dArr18;
                        double d16 = -dArr[i17];
                        dArr[i17] = d16;
                        dArr19[i17] = dArr9[i17] + d16;
                        double d17 = dArr20[i17] * dArr[i17];
                        d15 = (d17 * d17) + d15;
                        i16++;
                        dArr18 = dArr20;
                    }
                    double[] dArr21 = dArr18;
                    double dSqrt2 = FastMath.sqrt(d15);
                    if (z6) {
                        dMin = FastMath.min(dMin, dSqrt2);
                    }
                    evaluationCounter.incrementCount();
                    evaluationEvaluate2 = leastSquaresProblem.evaluate(new ArrayRealVector(dArr19));
                    double[] array3 = evaluationEvaluate2.getResiduals().toArray();
                    double cost2 = evaluationEvaluate2.getCost();
                    double[] array4 = evaluationEvaluate2.getPoint().toArray();
                    double d18 = 0.1d;
                    double d19 = cost2 * 0.1d;
                    if (d19 < cost) {
                        double d20 = cost2 / cost;
                        d6 = 1.0d - (d20 * d20);
                    } else {
                        d6 = -1.0d;
                    }
                    for (int i18 = 0; i18 < iMin; i18++) {
                        int i19 = iArr[i18];
                        double d21 = dArr[i19];
                        dArr17[i18] = 0.0d;
                        for (int i20 = 0; i20 <= i18; i20++) {
                            dArr17[i20] = (dArr10[i20][i19] * d21) + dArr17[i20];
                        }
                    }
                    double d22 = 0.0d;
                    for (int i21 = 0; i21 < iMin; i21++) {
                        double d23 = dArr17[i21];
                        d22 = (d23 * d23) + d22;
                    }
                    double d24 = cost * cost;
                    double d25 = d22 / d24;
                    double d26 = ((dDetermineLMParameter * dSqrt2) * dSqrt2) / d24;
                    double d27 = (d26 * 2.0d) + d25;
                    double d28 = -(d25 + d26);
                    double d29 = d27 == 0.0d ? 0.0d : d6 / d27;
                    if (d29 <= 0.25d) {
                        double d30 = d6 < 0.0d ? (d28 * 0.5d) / ((0.5d * d6) + d28) : 0.5d;
                        if (d19 < cost && d30 >= 0.1d) {
                            d18 = d30;
                        }
                        dMin = FastMath.min(dMin, 10.0d * dSqrt2) * d18;
                        dDetermineLMParameter /= d18;
                    } else if (dDetermineLMParameter == 0.0d || d29 >= 0.75d) {
                        dDetermineLMParameter *= 0.5d;
                        dMin = dSqrt2 * 2.0d;
                    }
                    if (d29 >= 1.0E-4d) {
                        double d31 = 0.0d;
                        for (int i22 = 0; i22 < parameterSize; i22++) {
                            double d32 = dArr21[i22] * array4[i22];
                            d31 = (d32 * d32) + d31;
                        }
                        dSqrt = FastMath.sqrt(d31);
                        if (convergenceChecker4 != null) {
                            evaluation = evaluation2;
                            convergenceChecker = convergenceChecker4;
                            if (convergenceChecker.converged(iterationCounter.getCount(), evaluation, evaluationEvaluate2)) {
                                return new OptimumImpl(evaluationEvaluate2, evaluationCounter.getCount(), iterationCounter.getCount());
                            }
                        } else {
                            evaluation = evaluation2;
                            convergenceChecker = convergenceChecker4;
                        }
                        z6 = false;
                        cost = cost2;
                    } else {
                        dMin = dMin;
                        evaluation = evaluation2;
                        convergenceChecker = convergenceChecker4;
                        for (int i23 = 0; i23 < iMin; i23++) {
                            int i24 = iArr[i23];
                            array4[i24] = dArr9[i24];
                        }
                        evaluationEvaluate2 = evaluation;
                    }
                    double dAbs = FastMath.abs(d6);
                    LeastSquaresProblem.Evaluation evaluation3 = evaluation;
                    double d33 = this.costRelativeTolerance;
                    if ((dAbs <= d33 && d27 <= d33 && d29 <= 2.0d) || dMin <= this.parRelativeTolerance * dSqrt) {
                        return new OptimumImpl(evaluationEvaluate2, evaluationCounter.getCount(), iterationCounter.getCount());
                    }
                    double dAbs2 = FastMath.abs(d6);
                    double d34 = TWO_EPS;
                    if (dAbs2 <= d34 && d27 <= d34 && d29 <= 2.0d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, Double.valueOf(this.costRelativeTolerance));
                    }
                    if (dMin <= d34 * dSqrt) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, Double.valueOf(this.parRelativeTolerance));
                    }
                    if (d <= d34) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, Double.valueOf(this.orthoTolerance));
                    }
                    convergenceChecker4 = convergenceChecker;
                    dArr15 = dArr17;
                    dArr14 = dArr21;
                    evaluationEvaluate = evaluation3;
                    d13 = d29;
                    double d35 = dDetermineLMParameter;
                    array = array3;
                    array2 = array4;
                    observationSize = i15;
                    d7 = d35;
                }
            }
            evaluationEvaluate = evaluationEvaluate2;
            dMin = dMin;
            dArr6 = dArr15;
            dArr3 = dArr9;
            observationSize = observationSize;
            convergenceChecker3 = convergenceChecker4;
            dArr5 = dArr13;
            dArr7 = dArr16;
            dArr2 = dArr14;
        }
    }

    public LevenbergMarquardtOptimizer withCostRelativeTolerance(double d) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, d, this.parRelativeTolerance, this.orthoTolerance, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withInitialStepBoundFactor(double d) {
        return new LevenbergMarquardtOptimizer(d, this.costRelativeTolerance, this.parRelativeTolerance, this.orthoTolerance, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withOrthoTolerance(double d) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, this.costRelativeTolerance, this.parRelativeTolerance, d, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withParameterRelativeTolerance(double d) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, this.costRelativeTolerance, d, this.orthoTolerance, this.qrRankingThreshold);
    }

    public LevenbergMarquardtOptimizer withRankingThreshold(double d) {
        return new LevenbergMarquardtOptimizer(this.initialStepBoundFactor, this.costRelativeTolerance, this.parRelativeTolerance, this.orthoTolerance, d);
    }

    public LevenbergMarquardtOptimizer(double d, double d6, double d7, double d8, double d9) {
        this.initialStepBoundFactor = d;
        this.costRelativeTolerance = d6;
        this.parRelativeTolerance = d7;
        this.orthoTolerance = d8;
        this.qrRankingThreshold = d9;
    }
}

package org.apache.commons.math3.optimization.general;

import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private double[] beta;
    private final double costRelativeTolerance;
    private double[] diagR;
    private final double initialStepBoundFactor;
    private double[] jacNorm;
    private double[] lmDir;
    private double lmPar;
    private final double orthoTolerance;
    private final double parRelativeTolerance;
    private int[] permutation;
    private final double qrRankingThreshold;
    private int rank;
    private int solvedCols;
    private double[][] weightedJacobian;
    private double[] weightedResidual;

    public LevenbergMarquardtOptimizer() {
        this(100.0d, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    private void determineLMDirection(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4) {
        int i5;
        double d;
        double dSqrt;
        int i6 = 0;
        while (i6 < this.solvedCols) {
            int i7 = this.permutation[i6];
            int i8 = i6 + 1;
            for (int i9 = i8; i9 < this.solvedCols; i9++) {
                double[][] dArr5 = this.weightedJacobian;
                dArr5[i9][i7] = dArr5[i6][this.permutation[i9]];
            }
            this.lmDir[i6] = this.diagR[i7];
            dArr4[i6] = dArr[i6];
            i6 = i8;
        }
        int i10 = 0;
        while (true) {
            i5 = this.solvedCols;
            if (i10 >= i5) {
                break;
            }
            double d6 = dArr2[this.permutation[i10]];
            if (d6 != 0.0d) {
                Arrays.fill(dArr3, i10 + 1, dArr3.length, 0.0d);
            }
            dArr3[i10] = d6;
            int i11 = i10;
            double d7 = 0.0d;
            while (i11 < this.solvedCols) {
                int i12 = this.permutation[i11];
                if (dArr3[i11] != 0.0d) {
                    double d8 = this.weightedJacobian[i11][i12];
                    if (FastMath.abs(d8) < FastMath.abs(dArr3[i11])) {
                        double d9 = d8 / dArr3[i11];
                        dSqrt = 1.0d / FastMath.sqrt((d9 * d9) + 1.0d);
                        d = d9 * dSqrt;
                    } else {
                        double d10 = dArr3[i11] / d8;
                        double dSqrt2 = 1.0d / FastMath.sqrt((d10 * d10) + 1.0d);
                        double d11 = d10 * dSqrt2;
                        d = dSqrt2;
                        dSqrt = d11;
                    }
                    this.weightedJacobian[i11][i12] = (dArr3[i11] * dSqrt) + (d8 * d);
                    double d12 = dArr4[i11];
                    double d13 = (dSqrt * d7) + (d * d12);
                    double d14 = -dSqrt;
                    d7 = (d7 * d) + (d12 * d14);
                    dArr4[i11] = d13;
                    for (int i13 = i11 + 1; i13 < this.solvedCols; i13++) {
                        double[] dArr6 = this.weightedJacobian[i13];
                        double d15 = dArr6[i12];
                        double d16 = dArr3[i13];
                        dArr3[i13] = (d16 * d) + (d15 * d14);
                        dArr6[i12] = (dSqrt * d16) + (d * d15);
                    }
                }
                i11++;
                i10 = i10;
            }
            int i14 = i10;
            double[] dArr7 = this.weightedJacobian[i14];
            int i15 = this.permutation[i14];
            dArr3[i14] = dArr7[i15];
            dArr7[i15] = this.lmDir[i14];
            i10 = i14 + 1;
        }
        int i16 = 0;
        while (true) {
            int i17 = this.solvedCols;
            if (i16 >= i17) {
                break;
            }
            if (dArr3[i16] == 0.0d && i5 == i17) {
                i5 = i16;
            }
            if (i5 < i17) {
                dArr4[i16] = 0.0d;
            }
            i16++;
        }
        if (i5 > 0) {
            for (int i18 = i5 - 1; i18 >= 0; i18--) {
                int i19 = this.permutation[i18];
                double d17 = 0.0d;
                for (int i20 = i18 + 1; i20 < i5; i20++) {
                    d17 += this.weightedJacobian[i20][i19] * dArr4[i20];
                }
                dArr4[i18] = (dArr4[i18] - d17) / dArr3[i18];
            }
        }
        int i21 = 0;
        while (true) {
            double[] dArr8 = this.lmDir;
            if (i21 >= dArr8.length) {
                return;
            }
            dArr8[this.permutation[i21]] = dArr4[i21];
            i21++;
        }
    }

    private void determineLMParameter(double[] dArr, double d, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        int i5;
        double dMax;
        double d6;
        double d7;
        double[] dArr6 = dArr;
        int i6 = 0;
        int length = this.weightedJacobian[0].length;
        int i7 = 0;
        while (true) {
            i5 = this.rank;
            if (i7 >= i5) {
                break;
            }
            this.lmDir[this.permutation[i7]] = dArr6[i7];
            i7++;
        }
        while (i5 < length) {
            this.lmDir[this.permutation[i5]] = 0.0d;
            i5++;
        }
        int i8 = this.rank - 1;
        while (i8 >= 0) {
            int i9 = this.permutation[i8];
            double d8 = this.lmDir[i9] / this.diagR[i9];
            for (int i10 = i6; i10 < i8; i10++) {
                double[] dArr7 = this.lmDir;
                int i11 = this.permutation[i10];
                dArr7[i11] = dArr7[i11] - (this.weightedJacobian[i10][i9] * d8);
            }
            this.lmDir[i9] = d8;
            i8--;
            i6 = 0;
        }
        double d9 = 0.0d;
        for (int i12 = 0; i12 < this.solvedCols; i12++) {
            int i13 = this.permutation[i12];
            double d10 = dArr2[i13] * this.lmDir[i13];
            dArr3[i13] = d10;
            d9 += d10 * d10;
        }
        double dSqrt = FastMath.sqrt(d9);
        double d11 = dSqrt - d;
        double d12 = d * 0.1d;
        if (d11 <= d12) {
            this.lmPar = 0.0d;
            return;
        }
        if (this.rank == this.solvedCols) {
            for (int i14 = 0; i14 < this.solvedCols; i14++) {
                int i15 = this.permutation[i14];
                dArr3[i15] = (dArr2[i15] / dSqrt) * dArr3[i15];
            }
            double d13 = 0.0d;
            for (int i16 = 0; i16 < this.solvedCols; i16++) {
                int i17 = this.permutation[i16];
                int i18 = 0;
                double d14 = 0.0d;
                while (i18 < i16) {
                    int i19 = i17;
                    d14 = (this.weightedJacobian[i18][i19] * dArr3[this.permutation[i18]]) + d14;
                    i18++;
                    i17 = i19;
                }
                int i20 = i17;
                double d15 = (dArr3[i20] - d14) / this.diagR[i20];
                dArr3[i20] = d15;
                d13 += d15 * d15;
            }
            dMax = d11 / (d * d13);
        } else {
            dMax = 0.0d;
        }
        double d16 = d11;
        double d17 = 0.0d;
        for (int i21 = 0; i21 < this.solvedCols; i21++) {
            int i22 = this.permutation[i21];
            int i23 = 0;
            double d18 = 0.0d;
            while (i23 <= i21) {
                int i24 = i22;
                d18 = (this.weightedJacobian[i23][i24] * dArr6[i23]) + d18;
                i23++;
                i22 = i24;
            }
            double d19 = d18 / dArr2[i22];
            d17 = (d19 * d19) + d17;
        }
        double dSqrt2 = FastMath.sqrt(d17);
        double dMin = dSqrt2 / d;
        double d20 = 0.0d;
        if (dMin == 0.0d) {
            d6 = 2.2251E-308d;
            dMin = 2.2251E-308d / FastMath.min(d, 0.1d);
        } else {
            d6 = 2.2251E-308d;
        }
        double dMin2 = FastMath.min(dMin, FastMath.max(this.lmPar, dMax));
        this.lmPar = dMin2;
        if (dMin2 == 0.0d) {
            this.lmPar = dSqrt2 / dSqrt;
        }
        int i25 = 10;
        while (i25 >= 0) {
            if (this.lmPar == d20) {
                this.lmPar = FastMath.max(d6, 0.001d * dMin);
            }
            double dSqrt3 = FastMath.sqrt(this.lmPar);
            for (int i26 = 0; i26 < this.solvedCols; i26++) {
                int i27 = this.permutation[i26];
                dArr3[i27] = dArr2[i27] * dSqrt3;
            }
            determineLMDirection(dArr6, dArr3, dArr4, dArr5);
            double d21 = 0.0d;
            for (int i28 = 0; i28 < this.solvedCols; i28++) {
                int i29 = this.permutation[i28];
                double d22 = dArr2[i29] * this.lmDir[i29];
                dArr5[i29] = d22;
                d21 = (d22 * d22) + d21;
            }
            double dSqrt4 = FastMath.sqrt(d21);
            double d23 = dSqrt4 - d;
            if (FastMath.abs(d23) <= d12) {
                return;
            }
            if (dMax == 0.0d && d23 <= d16 && d16 < 0.0d) {
                return;
            }
            for (int i30 = 0; i30 < this.solvedCols; i30++) {
                int i31 = this.permutation[i30];
                dArr3[i31] = (dArr5[i31] * dArr2[i31]) / dSqrt4;
            }
            int i32 = 0;
            while (i32 < this.solvedCols) {
                int i33 = this.permutation[i32];
                double d24 = dArr3[i33] / dArr4[i32];
                dArr3[i33] = d24;
                int i34 = i32 + 1;
                while (i34 < this.solvedCols) {
                    int i35 = this.permutation[i34];
                    dArr3[i35] = dArr3[i35] - (this.weightedJacobian[i34][i33] * d24);
                    i34++;
                }
                i32 = i34;
            }
            double d25 = 0.0d;
            for (int i36 = 0; i36 < this.solvedCols; i36++) {
                double d26 = dArr3[this.permutation[i36]];
                d25 = (d26 * d26) + d25;
            }
            double d27 = d23 / (d * d25);
            d20 = 0.0d;
            if (d23 > 0.0d) {
                d7 = d27;
                dMax = FastMath.max(dMax, this.lmPar);
            } else {
                d7 = d27;
                if (d23 < 0.0d) {
                    dMin = FastMath.min(dMin, this.lmPar);
                }
            }
            this.lmPar = FastMath.max(dMax, this.lmPar + d7);
            d16 = d23;
            d6 = 2.2251E-308d;
            i25--;
            dArr6 = dArr;
        }
    }

    private void qTy(double[] dArr) {
        double[][] dArr2 = this.weightedJacobian;
        int length = dArr2.length;
        int length2 = dArr2[0].length;
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = this.permutation[i5];
            double d = 0.0d;
            for (int i7 = i5; i7 < length; i7++) {
                d += this.weightedJacobian[i7][i6] * dArr[i7];
            }
            double d6 = d * this.beta[i6];
            for (int i8 = i5; i8 < length; i8++) {
                dArr[i8] = dArr[i8] - (this.weightedJacobian[i8][i6] * d6);
            }
        }
    }

    private void qrDecomposition(RealMatrix realMatrix) {
        double d;
        double[][] data = realMatrix.scalarMultiply(-1.0d).getData();
        this.weightedJacobian = data;
        int length = data.length;
        int i5 = 0;
        int length2 = data[0].length;
        int i6 = 0;
        while (true) {
            d = 0.0d;
            if (i6 >= length2) {
                break;
            }
            this.permutation[i6] = i6;
            for (int i7 = 0; i7 < length; i7++) {
                double d6 = this.weightedJacobian[i7][i6];
                d += d6 * d6;
            }
            this.jacNorm[i6] = FastMath.sqrt(d);
            i6++;
        }
        while (i5 < length2) {
            int i8 = -1;
            double d7 = Double.NEGATIVE_INFINITY;
            for (int i9 = i5; i9 < length2; i9++) {
                double d8 = d;
                for (int i10 = i5; i10 < length; i10++) {
                    double d9 = this.weightedJacobian[i10][this.permutation[i9]];
                    d8 += d9 * d9;
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
                this.rank = i5;
                return;
            }
            int[] iArr = this.permutation;
            int i11 = iArr[i8];
            iArr[i8] = iArr[i5];
            iArr[i5] = i11;
            double d10 = this.weightedJacobian[i5][i11];
            double dSqrt = FastMath.sqrt(d7);
            if (d10 > d) {
                dSqrt = -dSqrt;
            }
            double d11 = 1.0d / (d7 - (d10 * dSqrt));
            this.beta[i11] = d11;
            this.diagR[i11] = dSqrt;
            double[] dArr = this.weightedJacobian[i5];
            dArr[i11] = dArr[i11] - dSqrt;
            int i12 = (length2 - 1) - i5;
            while (i12 > 0) {
                double d12 = d;
                for (int i13 = i5; i13 < length; i13++) {
                    double[] dArr2 = this.weightedJacobian[i13];
                    d12 += dArr2[i11] * dArr2[this.permutation[i5 + i12]];
                }
                double d13 = d12 * d11;
                for (int i14 = i5; i14 < length; i14++) {
                    double[] dArr3 = this.weightedJacobian[i14];
                    int i15 = this.permutation[i5 + i12];
                    dArr3[i15] = dArr3[i15] - (dArr3[i11] * d13);
                }
                i12--;
                d = 0.0d;
            }
            i5++;
            d = 0.0d;
        }
        this.rank = this.solvedCols;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:103:0x02bc A[LOOP:13: B:102:0x02ba->B:103:0x02bc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ee A[LOOP:14: B:112:0x02ea->B:114:0x02ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:128:0x033a  */
    /* JADX WARN: Code duplicated, block: B:137:0x035b  */
    /* JADX WARN: Code duplicated, block: B:139:0x035f A[LOOP:7: B:47:0x0175->B:139:0x035f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:150:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x0372 A[SYNTHETIC] */
    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    public PointVectorValuePair doOptimize() {
        double d;
        double d6;
        double dMin;
        PointVectorValuePair pointVectorValuePair;
        int i5;
        double[] dArr;
        double d7;
        double dAbs;
        PointVectorValuePair pointVectorValuePair2;
        double[] dArr2;
        double d8;
        double d9;
        int i6;
        int i7;
        int length = getTarget().length;
        double[] startPoint = getStartPoint();
        int length2 = startPoint.length;
        this.solvedCols = FastMath.min(length, length2);
        this.diagR = new double[length2];
        this.jacNorm = new double[length2];
        this.beta = new double[length2];
        this.permutation = new int[length2];
        this.lmDir = new double[length2];
        double[] dArr3 = new double[length2];
        double[] dArr4 = new double[length2];
        double[] dArr5 = new double[length];
        double[] dArr6 = new double[length];
        double[] dArr7 = new double[length];
        double[] dArr8 = new double[length2];
        double[] dArr9 = new double[length2];
        double[] dArr10 = new double[length2];
        RealMatrix weightSquareRoot = getWeightSquareRoot();
        double[] dArrComputeObjectiveValue = computeObjectiveValue(startPoint);
        double[] dArrComputeResiduals = computeResiduals(dArrComputeObjectiveValue);
        PointVectorValuePair pointVectorValuePair3 = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue);
        double dComputeCost = computeCost(dArrComputeResiduals);
        this.lmPar = 0.0d;
        ConvergenceChecker<PointVectorValuePair> convergenceChecker = getConvergenceChecker();
        double d10 = dComputeCost;
        double[] dArr11 = dArrComputeResiduals;
        PointVectorValuePair pointVectorValuePair4 = pointVectorValuePair3;
        double d11 = 0.0d;
        double dSqrt = 0.0d;
        int i8 = 0;
        boolean z6 = true;
        while (true) {
            int i9 = i8 + 1;
            double[] dArr12 = dArr6;
            qrDecomposition(computeWeightedJacobian(startPoint));
            this.weightedResidual = weightSquareRoot.operate(dArr11);
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10;
                dArr7[i11] = this.weightedResidual[i11];
                i10 = i11 + 1;
            }
            qTy(dArr7);
            double[] dArr13 = dArr7;
            for (int i12 = 0; i12 < this.solvedCols; i12++) {
                int i13 = this.permutation[i12];
                this.weightedJacobian[i12][i13] = this.diagR[i13];
            }
            if (z6) {
                double d12 = 0.0d;
                for (int i14 = 0; i14 < length2; i14++) {
                    double d13 = this.jacNorm[i14];
                    if (d13 == 0.0d) {
                        d13 = 1.0d;
                    }
                    double d14 = startPoint[i14] * d13;
                    d12 = (d14 * d14) + d12;
                    dArr3[i14] = d13;
                }
                dSqrt = FastMath.sqrt(d12);
                d11 = dSqrt == 0.0d ? this.initialStepBoundFactor : this.initialStepBoundFactor * dSqrt;
            }
            double d15 = d10;
            if (d15 != 0.0d) {
                double dMax = 0.0d;
                int i15 = 0;
                while (i15 < this.solvedCols) {
                    int i16 = this.permutation[i15];
                    double d16 = this.jacNorm[i16];
                    if (d16 != 0.0d) {
                        double d17 = 0.0d;
                        int i17 = 0;
                        while (i17 <= i15) {
                            d17 = (this.weightedJacobian[i17][i16] * dArr13[i17]) + d17;
                            i17++;
                            i15 = i15;
                        }
                        i7 = i15;
                        dMax = FastMath.max(dMax, FastMath.abs(d17) / (d16 * d15));
                    } else {
                        i7 = i15;
                    }
                    dArr10 = dArr10;
                    i15 = i7 + 1;
                }
                d = dMax;
            } else {
                d = 0.0d;
            }
            double[] dArr14 = dArr10;
            if (d <= this.orthoTolerance) {
                setCost(d15);
                this.point = pointVectorValuePair4.getPoint();
                return pointVectorValuePair4;
            }
            int i18 = 0;
            while (i18 < length2) {
                dArr3[i18] = FastMath.max(dArr3[i18], this.jacNorm[i18]);
                i18++;
                d15 = d15;
            }
            double d18 = d15;
            double[] dArr15 = dArr11;
            PointVectorValuePair pointVectorValuePair5 = pointVectorValuePair4;
            dArr6 = dArr12;
            double d19 = 0.0d;
            double[] dArr16 = dArrComputeObjectiveValue;
            while (d19 < 1.0E-4d) {
                for (int i19 = 0; i19 < this.solvedCols; i19++) {
                    int i20 = this.permutation[i19];
                    dArr4[i20] = startPoint[i20];
                }
                double[] dArr17 = this.weightedResidual;
                this.weightedResidual = dArr6;
                double[] dArr18 = dArr14;
                int i21 = length;
                double d20 = d11;
                determineLMParameter(dArr13, d20, dArr3, dArr8, dArr9, dArr18);
                double dMin2 = d20;
                double d21 = 0.0d;
                int i22 = 0;
                while (i22 < this.solvedCols) {
                    int i23 = this.permutation[i22];
                    double[] dArr19 = this.lmDir;
                    int i24 = i22;
                    double d22 = -dArr19[i23];
                    dArr19[i23] = d22;
                    startPoint[i23] = dArr4[i23] + d22;
                    double d23 = dArr3[i23] * dArr19[i23];
                    d21 = (d23 * d23) + d21;
                    i22 = i24 + 1;
                }
                double dSqrt2 = FastMath.sqrt(d21);
                if (z6) {
                    dMin2 = FastMath.min(dMin2, dSqrt2);
                }
                double[] dArrComputeObjectiveValue2 = computeObjectiveValue(startPoint);
                double[] dArrComputeResiduals2 = computeResiduals(dArrComputeObjectiveValue2);
                PointVectorValuePair pointVectorValuePair6 = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue2);
                double dComputeCost2 = computeCost(dArrComputeResiduals2);
                double d24 = 0.1d;
                double d25 = dComputeCost2 * 0.1d;
                if (d25 < d18) {
                    double d26 = dComputeCost2 / d18;
                    d6 = 1.0d - (d26 * d26);
                } else {
                    d6 = -1.0d;
                }
                int i25 = 0;
                while (i25 < this.solvedCols) {
                    int i26 = this.permutation[i25];
                    double d27 = this.lmDir[i26];
                    dArr8[i25] = 0;
                    int i27 = 0;
                    while (i27 <= i25) {
                        dArr8[i27] = (this.weightedJacobian[i27][i26] * d27) + dArr8[i27];
                        i27++;
                        i25 = i25;
                    }
                    i25++;
                }
                double d28 = 0.0d;
                for (int i28 = 0; i28 < this.solvedCols; i28++) {
                    double d29 = dArr8[i28];
                    d28 = (d29 * d29) + d28;
                }
                double d30 = d18 * d18;
                double d31 = d28 / d30;
                double[] dArr20 = dArr4;
                RealMatrix realMatrix = weightSquareRoot;
                double d32 = this.lmPar;
                double d33 = ((d32 * dSqrt2) * dSqrt2) / d30;
                double d34 = (d33 * 2.0d) + d31;
                double d35 = -(d31 + d33);
                double d36 = d34 == 0.0d ? 0.0d : d6 / d34;
                if (d36 <= 0.25d) {
                    double d37 = d6 < 0.0d ? (d35 * 0.5d) / ((0.5d * d6) + d35) : 0.5d;
                    if (d25 < d18 && d37 >= 0.1d) {
                        d24 = d37;
                    }
                    dMin = FastMath.min(dMin2, 10.0d * dSqrt2) * d24;
                    this.lmPar /= d24;
                } else {
                    if (d32 == 0.0d || d36 >= 0.75d) {
                        dMin = dSqrt2 * 2.0d;
                        this.lmPar = d32 * 0.5d;
                    } else {
                        d11 = dMin2;
                    }
                    if (d36 >= 1.0E-4d) {
                        d9 = 0.0d;
                        for (i6 = 0; i6 < length2; i6++) {
                            double d38 = dArr3[i6] * startPoint[i6];
                            d9 += d38 * d38;
                        }
                        dSqrt = FastMath.sqrt(d9);
                        pointVectorValuePair = pointVectorValuePair4;
                        if (convergenceChecker == null && convergenceChecker.converged(i9, pointVectorValuePair, pointVectorValuePair6)) {
                            setCost(dComputeCost2);
                            this.point = pointVectorValuePair6.getPoint();
                            return pointVectorValuePair6;
                        }
                        d7 = dComputeCost2;
                        dArr = dArr17;
                        z6 = false;
                        dArr16 = dArrComputeObjectiveValue2;
                    } else {
                        pointVectorValuePair = pointVectorValuePair4;
                        for (i5 = 0; i5 < this.solvedCols; i5++) {
                            int i29 = this.permutation[i5];
                            startPoint[i29] = dArr20[i29];
                        }
                        double[] dArr21 = this.weightedResidual;
                        this.weightedResidual = dArr17;
                        dArr = dArr21;
                        pointVectorValuePair6 = new PointVectorValuePair(startPoint, dArr16);
                        d7 = d18;
                    }
                    dAbs = FastMath.abs(d6);
                    pointVectorValuePair2 = pointVectorValuePair6;
                    dArr2 = dArr;
                    d8 = this.costRelativeTolerance;
                    if ((dAbs > d8 && d34 <= d8 && d36 <= 2.0d) || d11 <= this.parRelativeTolerance * dSqrt) {
                        setCost(d7);
                        this.point = pointVectorValuePair2.getPoint();
                        return pointVectorValuePair2;
                    }
                    if (FastMath.abs(d6) > 2.2204E-16d && d34 <= 2.2204E-16d && d36 <= 2.0d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, Double.valueOf(this.costRelativeTolerance));
                    }
                    if (d11 <= dSqrt * 2.2204E-16d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, Double.valueOf(this.parRelativeTolerance));
                    }
                    if (d <= 2.2204E-16d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, Double.valueOf(this.orthoTolerance));
                    }
                    pointVectorValuePair5 = pointVectorValuePair2;
                    pointVectorValuePair4 = pointVectorValuePair;
                    d18 = d7;
                    dArr4 = dArr20;
                    dArr6 = dArr2;
                    length = i21;
                    dArr14 = dArr18;
                    dArr15 = dArrComputeResiduals2;
                    d19 = d36;
                    weightSquareRoot = realMatrix;
                }
                d11 = dMin;
                if (d36 >= 1.0E-4d) {
                    d9 = 0.0d;
                    while (i6 < length2) {
                        double d39 = dArr3[i6] * startPoint[i6];
                        d9 += d39 * d39;
                    }
                    dSqrt = FastMath.sqrt(d9);
                    pointVectorValuePair = pointVectorValuePair4;
                    if (convergenceChecker == null) {
                    }
                    d7 = dComputeCost2;
                    dArr = dArr17;
                    z6 = false;
                    dArr16 = dArrComputeObjectiveValue2;
                } else {
                    pointVectorValuePair = pointVectorValuePair4;
                    while (i5 < this.solvedCols) {
                        int i210 = this.permutation[i5];
                        startPoint[i210] = dArr20[i210];
                    }
                    double[] dArr22 = this.weightedResidual;
                    this.weightedResidual = dArr17;
                    dArr = dArr22;
                    pointVectorValuePair6 = new PointVectorValuePair(startPoint, dArr16);
                    d7 = d18;
                }
                dAbs = FastMath.abs(d6);
                pointVectorValuePair2 = pointVectorValuePair6;
                dArr2 = dArr;
                d8 = this.costRelativeTolerance;
                if (dAbs > d8) {
                    if (FastMath.abs(d6) > 2.2204E-16d) {
                    }
                    if (d11 <= dSqrt * 2.2204E-16d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, Double.valueOf(this.parRelativeTolerance));
                    }
                    if (d <= 2.2204E-16d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, Double.valueOf(this.orthoTolerance));
                    }
                    pointVectorValuePair5 = pointVectorValuePair2;
                    pointVectorValuePair4 = pointVectorValuePair;
                    d18 = d7;
                    dArr4 = dArr20;
                    dArr6 = dArr2;
                    length = i21;
                    dArr14 = dArr18;
                    dArr15 = dArrComputeResiduals2;
                    d19 = d36;
                    weightSquareRoot = realMatrix;
                } else {
                    if (FastMath.abs(d6) > 2.2204E-16d) {
                    }
                    if (d11 <= dSqrt * 2.2204E-16d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, Double.valueOf(this.parRelativeTolerance));
                    }
                    if (d <= 2.2204E-16d) {
                        throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, Double.valueOf(this.orthoTolerance));
                    }
                    pointVectorValuePair5 = pointVectorValuePair2;
                    pointVectorValuePair4 = pointVectorValuePair;
                    d18 = d7;
                    dArr4 = dArr20;
                    dArr6 = dArr2;
                    length = i21;
                    dArr14 = dArr18;
                    dArr15 = dArrComputeResiduals2;
                    d19 = d36;
                    weightSquareRoot = realMatrix;
                }
                setCost(d7);
                this.point = pointVectorValuePair2.getPoint();
                return pointVectorValuePair2;
            }
            pointVectorValuePair4 = pointVectorValuePair5;
            dArr10 = dArr14;
            i8 = i9;
            dArrComputeObjectiveValue = dArr16;
            dArr7 = dArr13;
            dArr8 = dArr8;
            dArr9 = dArr9;
            dArr11 = dArr15;
            dArr3 = dArr3;
            d10 = d18;
        }
    }

    public LevenbergMarquardtOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        this(100.0d, convergenceChecker, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    public LevenbergMarquardtOptimizer(double d, ConvergenceChecker<PointVectorValuePair> convergenceChecker, double d6, double d7, double d8, double d9) {
        super(convergenceChecker);
        this.initialStepBoundFactor = d;
        this.costRelativeTolerance = d6;
        this.parRelativeTolerance = d7;
        this.orthoTolerance = d8;
        this.qrRankingThreshold = d9;
    }

    public LevenbergMarquardtOptimizer(double d, double d6, double d7) {
        this(100.0d, d, d6, d7, Precision.SAFE_MIN);
    }

    public LevenbergMarquardtOptimizer(double d, double d6, double d7, double d8, double d9) {
        super(null);
        this.initialStepBoundFactor = d;
        this.costRelativeTolerance = d6;
        this.parRelativeTolerance = d7;
        this.orthoTolerance = d8;
        this.qrRankingThreshold = d9;
    }
}

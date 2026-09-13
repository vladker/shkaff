package org.apache.commons.math3.optim.nonlinear.vector.jacobian;

import java.util.Arrays;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LevenbergMarquardtOptimizer extends AbstractLeastSquaresOptimizer {
    private static final double TWO_EPS = Precision.EPSILON * 2.0d;
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

    private void checkParameters() {
        if (getLowerBound() != null || getUpperBound() != null) {
            throw new MathUnsupportedOperationException(LocalizedFormats.CONSTRAINT, new Object[0]);
        }
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
            double d7 = this.lmDir[i9] / this.diagR[i9];
            for (int i10 = i6; i10 < i8; i10++) {
                double[] dArr7 = this.lmDir;
                int i11 = this.permutation[i10];
                dArr7[i11] = dArr7[i11] - (this.weightedJacobian[i10][i9] * d7);
            }
            this.lmDir[i9] = d7;
            i8--;
            i6 = 0;
        }
        double d8 = 0.0d;
        for (int i12 = 0; i12 < this.solvedCols; i12++) {
            int i13 = this.permutation[i12];
            double d9 = dArr2[i13] * this.lmDir[i13];
            dArr3[i13] = d9;
            d8 += d9 * d9;
        }
        double dSqrt = FastMath.sqrt(d8);
        double d10 = dSqrt - d;
        double d11 = d * 0.1d;
        if (d10 <= d11) {
            this.lmPar = 0.0d;
            return;
        }
        if (this.rank == this.solvedCols) {
            for (int i14 = 0; i14 < this.solvedCols; i14++) {
                int i15 = this.permutation[i14];
                dArr3[i15] = (dArr2[i15] / dSqrt) * dArr3[i15];
            }
            double d12 = 0.0d;
            for (int i16 = 0; i16 < this.solvedCols; i16++) {
                int i17 = this.permutation[i16];
                int i18 = 0;
                double d13 = 0.0d;
                while (i18 < i16) {
                    int i19 = i17;
                    d13 = (this.weightedJacobian[i18][i19] * dArr3[this.permutation[i18]]) + d13;
                    i18++;
                    i17 = i19;
                }
                int i20 = i17;
                double d14 = (dArr3[i20] - d13) / this.diagR[i20];
                dArr3[i20] = d14;
                d12 += d14 * d14;
            }
            dMax = d10 / (d * d12);
        } else {
            dMax = 0.0d;
        }
        double d15 = d10;
        double d16 = 0.0d;
        for (int i21 = 0; i21 < this.solvedCols; i21++) {
            int i22 = this.permutation[i21];
            int i23 = 0;
            double d17 = 0.0d;
            while (i23 <= i21) {
                int i24 = i22;
                d17 = (this.weightedJacobian[i23][i24] * dArr6[i23]) + d17;
                i23++;
                i22 = i24;
            }
            double d18 = d17 / dArr2[i22];
            d16 = (d18 * d18) + d16;
        }
        double dSqrt2 = FastMath.sqrt(d16);
        double dMin = dSqrt2 / d;
        double d19 = 0.0d;
        if (dMin == 0.0d) {
            dMin = Precision.SAFE_MIN / FastMath.min(d, 0.1d);
        }
        double dMin2 = FastMath.min(dMin, FastMath.max(this.lmPar, dMax));
        this.lmPar = dMin2;
        if (dMin2 == 0.0d) {
            this.lmPar = dSqrt2 / dSqrt;
        }
        int i25 = 10;
        while (i25 >= 0) {
            if (this.lmPar == d19) {
                this.lmPar = FastMath.max(Precision.SAFE_MIN, dMin * 0.001d);
            }
            double dSqrt3 = FastMath.sqrt(this.lmPar);
            for (int i26 = 0; i26 < this.solvedCols; i26++) {
                int i27 = this.permutation[i26];
                dArr3[i27] = dArr2[i27] * dSqrt3;
            }
            determineLMDirection(dArr6, dArr3, dArr4, dArr5);
            double d20 = 0.0d;
            for (int i28 = 0; i28 < this.solvedCols; i28++) {
                int i29 = this.permutation[i28];
                double d21 = dArr2[i29] * this.lmDir[i29];
                dArr5[i29] = d21;
                d20 = (d21 * d21) + d20;
            }
            double dSqrt4 = FastMath.sqrt(d20);
            double d22 = dSqrt4 - d;
            if (FastMath.abs(d22) <= d11) {
                return;
            }
            if (dMax == 0.0d && d22 <= d15 && d15 < 0.0d) {
                return;
            }
            for (int i30 = 0; i30 < this.solvedCols; i30++) {
                int i31 = this.permutation[i30];
                dArr3[i31] = (dArr5[i31] * dArr2[i31]) / dSqrt4;
            }
            int i32 = 0;
            while (i32 < this.solvedCols) {
                int i33 = this.permutation[i32];
                double d23 = dArr3[i33] / dArr4[i32];
                dArr3[i33] = d23;
                int i34 = i32 + 1;
                while (i34 < this.solvedCols) {
                    int i35 = this.permutation[i34];
                    dArr3[i35] = dArr3[i35] - (this.weightedJacobian[i34][i33] * d23);
                    i34++;
                }
                i32 = i34;
            }
            double d24 = 0.0d;
            for (int i36 = 0; i36 < this.solvedCols; i36++) {
                double d25 = dArr3[this.permutation[i36]];
                d24 = (d25 * d25) + d24;
            }
            double d26 = d22 / (d * d24);
            d19 = 0.0d;
            if (d22 > 0.0d) {
                d6 = d26;
                dMax = FastMath.max(dMax, this.lmPar);
            } else {
                d6 = d26;
                if (d22 < 0.0d) {
                    dMin = FastMath.min(dMin, this.lmPar);
                }
            }
            this.lmPar = FastMath.max(dMax, this.lmPar + d6);
            d15 = d22;
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

    public LevenbergMarquardtOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        this(100.0d, convergenceChecker, 1.0E-10d, 1.0E-10d, 1.0E-10d, Precision.SAFE_MIN);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointVectorValuePair doOptimize() {
        double d;
        double d6;
        checkParameters();
        int length = getTarget().length;
        double[] startPoint = getStartPoint();
        int length2 = startPoint.length;
        this.solvedCols = FastMath.min(length, length2);
        this.diagR = new double[length2];
        this.jacNorm = new double[length2];
        this.beta = new double[length2];
        this.permutation = new int[length2];
        this.lmDir = new double[length2];
        double[] dArr = new double[length2];
        double[] dArr2 = new double[length2];
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        double[] dArr5 = new double[length2];
        double[] dArr6 = new double[length2];
        double[] dArr7 = new double[length2];
        RealMatrix weightSquareRoot = getWeightSquareRoot();
        double[] dArrComputeObjectiveValue = computeObjectiveValue(startPoint);
        double[] dArrComputeResiduals = computeResiduals(dArrComputeObjectiveValue);
        PointVectorValuePair pointVectorValuePair = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue);
        double dComputeCost = computeCost(dArrComputeResiduals);
        this.lmPar = 0.0d;
        ConvergenceChecker<PointVectorValuePair> convergenceChecker = getConvergenceChecker();
        double d7 = 0.0d;
        double dSqrt = 0.0d;
        double[] dArr8 = new double[length];
        double[] dArr9 = dArrComputeObjectiveValue;
        double d8 = dComputeCost;
        PointVectorValuePair pointVectorValuePair2 = pointVectorValuePair;
        boolean z6 = true;
        double[] dArr10 = dArrComputeResiduals;
        while (true) {
            incrementIterationCount();
            double[] dArr11 = dArr;
            qrDecomposition(computeWeightedJacobian(startPoint));
            this.weightedResidual = weightSquareRoot.operate(dArr10);
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5;
                dArr4[i6] = this.weightedResidual[i6];
                i5 = i6 + 1;
            }
            qTy(dArr4);
            double[] dArr12 = dArr4;
            for (int i7 = 0; i7 < this.solvedCols; i7++) {
                int i8 = this.permutation[i7];
                this.weightedJacobian[i7][i8] = this.diagR[i8];
            }
            if (z6) {
                double d9 = 0.0d;
                for (int i9 = 0; i9 < length2; i9++) {
                    double d10 = this.jacNorm[i9];
                    if (d10 == 0.0d) {
                        d10 = 1.0d;
                    }
                    double d11 = startPoint[i9] * d10;
                    d9 = (d11 * d11) + d9;
                    dArr11[i9] = d10;
                }
                dSqrt = FastMath.sqrt(d9);
                d7 = dSqrt == 0.0d ? this.initialStepBoundFactor : this.initialStepBoundFactor * dSqrt;
            } else {
                dArr5 = dArr5;
            }
            double[] dArr13 = dArr5;
            double[] dArr14 = dArr6;
            if (d8 != 0.0d) {
                double dMax = 0.0d;
                int i10 = 0;
                while (i10 < this.solvedCols) {
                    int i11 = this.permutation[i10];
                    double d12 = this.jacNorm[i11];
                    if (d12 != 0.0d) {
                        double d13 = 0.0d;
                        int i12 = 0;
                        while (i12 <= i10) {
                            int i13 = i12;
                            d13 = (this.weightedJacobian[i13][i11] * dArr12[i13]) + d13;
                            i12 = i13 + 1;
                        }
                        dMax = FastMath.max(dMax, FastMath.abs(d13) / (d12 * d8));
                    }
                    i10++;
                    dArr7 = dArr7;
                    length = length;
                }
                d = dMax;
            } else {
                d = 0.0d;
            }
            double[] dArr15 = dArr7;
            int i14 = length;
            if (d <= this.orthoTolerance) {
                setCost(d8);
                return pointVectorValuePair2;
            }
            int i15 = 0;
            while (i15 < length2) {
                dArr11[i15] = FastMath.max(dArr11[i15], this.jacNorm[i15]);
                i15++;
                dArr15 = dArr15;
                d8 = d8;
            }
            double d14 = d8;
            double[] dArr16 = dArr15;
            PointVectorValuePair pointVectorValuePair3 = pointVectorValuePair2;
            double[] dArr17 = dArr8;
            double[] dArr18 = dArr9;
            double d15 = 0.0d;
            while (d15 < 1.0E-4d) {
                for (int i16 = 0; i16 < this.solvedCols; i16++) {
                    int i17 = this.permutation[i16];
                    dArr2[i17] = startPoint[i17];
                }
                double[] dArr19 = this.weightedResidual;
                this.weightedResidual = dArr17;
                double[] dArr20 = dArr16;
                double d16 = d7;
                double[] dArr21 = dArr14;
                determineLMParameter(dArr12, d16, dArr11, dArr13, dArr21, dArr20);
                double dMin = d16;
                double d17 = 0.0d;
                int i18 = 0;
                while (i18 < this.solvedCols) {
                    int i19 = this.permutation[i18];
                    double[] dArr22 = this.lmDir;
                    int i20 = i18;
                    double d18 = -dArr22[i19];
                    dArr22[i19] = d18;
                    startPoint[i19] = dArr2[i19] + d18;
                    double d19 = dArr11[i19] * dArr22[i19];
                    d17 = (d19 * d19) + d17;
                    i18 = i20 + 1;
                }
                double dSqrt2 = FastMath.sqrt(d17);
                if (z6) {
                    dMin = FastMath.min(dMin, dSqrt2);
                }
                double[] dArrComputeObjectiveValue2 = computeObjectiveValue(startPoint);
                double[] dArrComputeResiduals2 = computeResiduals(dArrComputeObjectiveValue2);
                PointVectorValuePair pointVectorValuePair4 = new PointVectorValuePair(startPoint, dArrComputeObjectiveValue2);
                dArr14 = dArr21;
                double dComputeCost2 = computeCost(dArrComputeResiduals2);
                double d20 = 0.1d;
                double d21 = dComputeCost2 * 0.1d;
                if (d21 < d14) {
                    double d22 = dComputeCost2 / d14;
                    d6 = 1.0d - (d22 * d22);
                } else {
                    d6 = -1.0d;
                }
                int i21 = 0;
                while (i21 < this.solvedCols) {
                    int i22 = this.permutation[i21];
                    double d23 = this.lmDir[i22];
                    dArr13[i21] = 0.0d;
                    int i23 = 0;
                    while (i23 <= i21) {
                        dArr13[i23] = (this.weightedJacobian[i23][i22] * d23) + dArr13[i23];
                        i23++;
                        i21 = i21;
                    }
                    i21++;
                }
                double d24 = 0.0d;
                for (int i24 = 0; i24 < this.solvedCols; i24++) {
                    double d25 = dArr13[i24];
                    d24 = (d25 * d25) + d24;
                }
                double d26 = d14 * d14;
                double d27 = d24 / d26;
                double[] dArr23 = dArr2;
                RealMatrix realMatrix = weightSquareRoot;
                double d28 = this.lmPar;
                double d29 = ((d28 * dSqrt2) * dSqrt2) / d26;
                double d30 = (d29 * 2.0d) + d27;
                double d31 = -(d27 + d29);
                double d32 = d30 == 0.0d ? 0.0d : d6 / d30;
                if (d32 <= 0.25d) {
                    double d33 = d6 < 0.0d ? (d31 * 0.5d) / ((0.5d * d6) + d31) : 0.5d;
                    if (d21 < d14 && d33 >= 0.1d) {
                        d20 = d33;
                    }
                    dMin = FastMath.min(dMin, 10.0d * dSqrt2) * d20;
                    this.lmPar /= d20;
                } else if (d28 == 0.0d || d32 >= 0.75d) {
                    dMin = dSqrt2 * 2.0d;
                    this.lmPar = d28 * 0.5d;
                }
                d7 = dMin;
                if (d32 >= 1.0E-4d) {
                    double d34 = 0.0d;
                    for (int i25 = 0; i25 < length2; i25++) {
                        double d35 = dArr11[i25] * startPoint[i25];
                        d34 += d35 * d35;
                    }
                    dSqrt = FastMath.sqrt(d34);
                    if (convergenceChecker != null && convergenceChecker.converged(getIterations(), pointVectorValuePair2, pointVectorValuePair4)) {
                        setCost(dComputeCost2);
                        return pointVectorValuePair4;
                    }
                    pointVectorValuePair3 = pointVectorValuePair4;
                    dArr17 = dArr19;
                    z6 = false;
                    dArr18 = dArrComputeObjectiveValue2;
                } else {
                    for (int i26 = 0; i26 < this.solvedCols; i26++) {
                        int i27 = this.permutation[i26];
                        startPoint[i27] = dArr23[i27];
                    }
                    double[] dArr24 = this.weightedResidual;
                    this.weightedResidual = dArr19;
                    dArr17 = dArr24;
                    pointVectorValuePair3 = new PointVectorValuePair(startPoint, dArr18);
                    dComputeCost2 = d14;
                }
                double dAbs = FastMath.abs(d6);
                double d36 = this.costRelativeTolerance;
                if ((dAbs <= d36 && d30 <= d36 && d32 <= 2.0d) || d7 <= this.parRelativeTolerance * dSqrt) {
                    setCost(dComputeCost2);
                    return pointVectorValuePair3;
                }
                double dAbs2 = FastMath.abs(d6);
                double d37 = TWO_EPS;
                if (dAbs2 <= d37 && d30 <= d37 && d32 <= 2.0d) {
                    throw new ConvergenceException(LocalizedFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE, Double.valueOf(this.costRelativeTolerance));
                }
                if (d7 <= d37 * dSqrt) {
                    throw new ConvergenceException(LocalizedFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE, Double.valueOf(this.parRelativeTolerance));
                }
                if (d <= d37) {
                    throw new ConvergenceException(LocalizedFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE, Double.valueOf(this.orthoTolerance));
                }
                d14 = dComputeCost2;
                dArr2 = dArr23;
                dArr10 = dArrComputeResiduals2;
                dArr16 = dArr20;
                d15 = d32;
                weightSquareRoot = realMatrix;
            }
            pointVectorValuePair2 = pointVectorValuePair3;
            dArr8 = dArr17;
            dArr9 = dArr18;
            dArr = dArr11;
            dArr4 = dArr12;
            dArr6 = dArr14;
            dArr5 = dArr13;
            length = i14;
            d8 = d14;
            dArr7 = dArr16;
        }
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

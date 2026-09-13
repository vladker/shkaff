package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CMAESOptimizer extends MultivariateOptimizer {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private RealMatrix f6869B;
    private RealMatrix BD;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private RealMatrix f6870C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private RealMatrix f6871D;
    private double cc;
    private double ccov1;
    private double ccov1Sep;
    private double ccovmu;
    private double ccovmuSep;
    private final int checkFeasableCount;
    private double chiN;
    private double cs;
    private double damps;
    private RealMatrix diagC;
    private RealMatrix diagD;
    private int diagonalOnly;
    private int dimension;
    private double[] fitnessHistory;
    private final boolean generateStatistics;
    private int historySize;
    private double[] inputSigma;
    private final boolean isActiveCMA;
    private boolean isMinimize;
    private int iterations;
    private int lambda;
    private double logMu2;
    private final int maxIterations;
    private int mu;
    private double mueff;
    private double normps;
    private RealMatrix pc;
    private RealMatrix ps;
    private final RandomGenerator random;
    private double sigma;
    private final List<RealMatrix> statisticsDHistory;
    private final List<Double> statisticsFitnessHistory;
    private final List<RealMatrix> statisticsMeanHistory;
    private final List<Double> statisticsSigmaHistory;
    private final double stopFitness;
    private double stopTolFun;
    private double stopTolHistFun;
    private double stopTolUpX;
    private double stopTolX;
    private RealMatrix weights;
    private RealMatrix xmean;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DoubleIndex implements Comparable<DoubleIndex> {
        private final int index;
        private final double value;

        public DoubleIndex(double d, int i5) {
            this.value = d;
            this.index = i5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoubleIndex) && Double.compare(this.value, ((DoubleIndex) obj).value) == 0;
        }

        public int hashCode() {
            long jDoubleToLongBits = Double.doubleToLongBits(this.value);
            return (int) (jDoubleToLongBits ^ ((jDoubleToLongBits >>> 32) ^ 1438542));
        }

        @Override // java.lang.Comparable
        public int compareTo(DoubleIndex doubleIndex) {
            return Double.compare(this.value, doubleIndex.value);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FitnessFunction {
        private final boolean isRepairMode = true;

        public FitnessFunction() {
        }

        private double penalty(double[] dArr, double[] dArr2) {
            double dAbs = 0.0d;
            for (int i5 = 0; i5 < dArr.length; i5++) {
                dAbs += FastMath.abs(dArr[i5] - dArr2[i5]);
            }
            return CMAESOptimizer.this.isMinimize ? dAbs : -dAbs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double[] repair(double[] dArr) {
            double[] lowerBound = CMAESOptimizer.this.getLowerBound();
            double[] upperBound = CMAESOptimizer.this.getUpperBound();
            double[] dArr2 = new double[dArr.length];
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double d = dArr[i5];
                double d6 = lowerBound[i5];
                if (d < d6) {
                    dArr2[i5] = d6;
                } else {
                    double d7 = upperBound[i5];
                    if (d > d7) {
                        dArr2[i5] = d7;
                    } else {
                        dArr2[i5] = d;
                    }
                }
            }
            return dArr2;
        }

        public boolean isFeasible(double[] dArr) {
            double[] lowerBound = CMAESOptimizer.this.getLowerBound();
            double[] upperBound = CMAESOptimizer.this.getUpperBound();
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double d = dArr[i5];
                if (d < lowerBound[i5] || d > upperBound[i5]) {
                    return false;
                }
            }
            return true;
        }

        public ValuePenaltyPair value(double[] dArr) {
            double dComputeObjectiveValue;
            double dPenalty;
            if (this.isRepairMode) {
                double[] dArrRepair = repair(dArr);
                dComputeObjectiveValue = CMAESOptimizer.this.computeObjectiveValue(dArrRepair);
                dPenalty = penalty(dArr, dArrRepair);
            } else {
                dComputeObjectiveValue = CMAESOptimizer.this.computeObjectiveValue(dArr);
                dPenalty = 0.0d;
            }
            if (!CMAESOptimizer.this.isMinimize) {
                dComputeObjectiveValue = -dComputeObjectiveValue;
            }
            if (!CMAESOptimizer.this.isMinimize) {
                dPenalty = -dPenalty;
            }
            return new ValuePenaltyPair(dComputeObjectiveValue, dPenalty);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PopulationSize implements OptimizationData {
        private final int lambda;

        public PopulationSize(int i5) {
            if (i5 <= 0) {
                throw new NotStrictlyPositiveException(Integer.valueOf(i5));
            }
            this.lambda = i5;
        }

        public int getPopulationSize() {
            return this.lambda;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Sigma implements OptimizationData {
        private final double[] sigma;

        public Sigma(double[] dArr) {
            for (int i5 = 0; i5 < dArr.length; i5++) {
                if (dArr[i5] < 0.0d) {
                    throw new NotPositiveException(Double.valueOf(dArr[i5]));
                }
            }
            this.sigma = (double[]) dArr.clone();
        }

        public double[] getSigma() {
            return (double[]) this.sigma.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ValuePenaltyPair {
        private double penalty;
        private double value;

        public ValuePenaltyPair(double d, double d6) {
            this.value = d;
            this.penalty = d6;
        }
    }

    public CMAESOptimizer(int i5, double d, boolean z6, int i6, int i7, RandomGenerator randomGenerator, boolean z7, ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
        this.isMinimize = true;
        this.statisticsSigmaHistory = new ArrayList();
        this.statisticsMeanHistory = new ArrayList();
        this.statisticsFitnessHistory = new ArrayList();
        this.statisticsDHistory = new ArrayList();
        this.maxIterations = i5;
        this.stopFitness = d;
        this.isActiveCMA = z6;
        this.diagonalOnly = i6;
        this.checkFeasableCount = i7;
        this.random = randomGenerator;
        this.generateStatistics = z7;
    }

    private void checkParameters() {
        double[] startPoint = getStartPoint();
        double[] lowerBound = getLowerBound();
        double[] upperBound = getUpperBound();
        double[] dArr = this.inputSigma;
        if (dArr != null) {
            if (dArr.length != startPoint.length) {
                throw new DimensionMismatchException(this.inputSigma.length, startPoint.length);
            }
            for (int i5 = 0; i5 < startPoint.length; i5++) {
                if (this.inputSigma[i5] > upperBound[i5] - lowerBound[i5]) {
                    throw new OutOfRangeException(Double.valueOf(this.inputSigma[i5]), 0, Double.valueOf(upperBound[i5] - lowerBound[i5]));
                }
            }
        }
    }

    private static void copyColumn(RealMatrix realMatrix, int i5, RealMatrix realMatrix2, int i6) {
        for (int i7 = 0; i7 < realMatrix.getRowDimension(); i7++) {
            realMatrix2.setEntry(i7, i6, realMatrix.getEntry(i7, i5));
        }
    }

    private static RealMatrix diag(RealMatrix realMatrix) {
        int columnDimension = realMatrix.getColumnDimension();
        Class cls = Double.TYPE;
        if (columnDimension == 1) {
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, realMatrix.getRowDimension(), realMatrix.getRowDimension());
            for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
                dArr[i5][i5] = realMatrix.getEntry(i5, 0);
            }
            return new Array2DRowRealMatrix(dArr, false);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, realMatrix.getRowDimension(), 1);
        for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
            dArr2[i6][0] = realMatrix.getEntry(i6, i6);
        }
        return new Array2DRowRealMatrix(dArr2, false);
    }

    private static RealMatrix divide(RealMatrix realMatrix, RealMatrix realMatrix2) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                dArr[i5][i6] = realMatrix.getEntry(i5, i6) / realMatrix2.getEntry(i5, i6);
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix eye(int i5, int i6) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 < i6) {
                dArr[i7][i7] = 1.0d;
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private void initializeCMA(double[] dArr) {
        if (this.lambda <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(this.lambda));
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, 1);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5][0] = this.inputSigma[i5];
        }
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(dArr2, false);
        this.sigma = max(array2DRowRealMatrix);
        this.stopTolUpX = max(array2DRowRealMatrix) * 1000.0d;
        this.stopTolX = max(array2DRowRealMatrix) * 1.0E-11d;
        this.stopTolFun = 1.0E-12d;
        this.stopTolHistFun = 1.0E-13d;
        int i6 = this.lambda / 2;
        this.mu = i6;
        this.logMu2 = FastMath.log(((double) i6) + 0.5d);
        this.weights = log(sequence(1.0d, this.mu, 1.0d)).scalarMultiply(-1.0d).scalarAdd(this.logMu2);
        double d = 0.0d;
        double d6 = 0.0d;
        for (int i7 = 0; i7 < this.mu; i7++) {
            double entry = this.weights.getEntry(i7, 0);
            d += entry;
            d6 += entry * entry;
        }
        this.weights = this.weights.scalarMultiply(1.0d / d);
        double d7 = (d * d) / d6;
        this.mueff = d7;
        int i8 = this.dimension;
        this.cc = ((d7 / ((double) i8)) + 4.0d) / (((d7 * 2.0d) / ((double) i8)) + ((double) (i8 + 4)));
        this.cs = (d7 + 2.0d) / ((((double) i8) + d7) + 3.0d);
        this.damps = (FastMath.max(0.3d, 1.0d - (((double) this.dimension) / (((double) this.maxIterations) + 1.0E-6d))) * ((FastMath.max(0.0d, FastMath.sqrt((d7 - 1.0d) / ((double) (i8 + 1))) - 1.0d) * 2.0d) + 1.0d)) + this.cs;
        int i9 = this.dimension;
        double d8 = this.mueff;
        double d9 = 2.0d / (((((double) i9) + 1.3d) * (((double) i9) + 1.3d)) + d8);
        this.ccov1 = d9;
        this.ccovmu = FastMath.min(1.0d - d9, (((1.0d / d8) + (d8 - 2.0d)) * 2.0d) / (((double) ((i9 + 2) * (i9 + 2))) + d8));
        this.ccov1Sep = FastMath.min(1.0d, ((((double) this.dimension) + 1.5d) * this.ccov1) / 3.0d);
        this.ccovmuSep = FastMath.min(1.0d - this.ccov1, ((((double) this.dimension) + 1.5d) * this.ccovmu) / 3.0d);
        double dSqrt = FastMath.sqrt(this.dimension);
        int i10 = this.dimension;
        this.chiN = ((1.0d / ((((double) i10) * 21.0d) * ((double) i10))) + (1.0d - (1.0d / (((double) i10) * 4.0d)))) * dSqrt;
        this.xmean = MatrixUtils.createColumnRealMatrix(dArr);
        RealMatrix realMatrixScalarMultiply = array2DRowRealMatrix.scalarMultiply(1.0d / this.sigma);
        this.diagD = realMatrixScalarMultiply;
        this.diagC = square(realMatrixScalarMultiply);
        this.pc = zeros(this.dimension, 1);
        RealMatrix realMatrixZeros = zeros(this.dimension, 1);
        this.ps = realMatrixZeros;
        this.normps = realMatrixZeros.getFrobeniusNorm();
        int i11 = this.dimension;
        this.f6869B = eye(i11, i11);
        this.f6871D = ones(this.dimension, 1);
        this.BD = times(this.f6869B, repmat(this.diagD.transpose(), this.dimension, 1));
        this.f6870C = this.f6869B.multiply(diag(square(this.f6871D)).multiply(this.f6869B.transpose()));
        int i12 = ((int) (((double) (this.dimension * 30)) / ((double) this.lambda))) + 10;
        this.historySize = i12;
        this.fitnessHistory = new double[i12];
        for (int i13 = 0; i13 < this.historySize; i13++) {
            this.fitnessHistory[i13] = Double.MAX_VALUE;
        }
    }

    private static int[] inverse(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[iArr[i5]] = i5;
        }
        return iArr2;
    }

    private static RealMatrix log(RealMatrix realMatrix) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                dArr[i5][i6] = FastMath.log(realMatrix.getEntry(i5, i6));
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static double max(RealMatrix realMatrix) {
        double d = -1.7976931348623157E308d;
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                double entry = realMatrix.getEntry(i5, i6);
                if (d < entry) {
                    d = entry;
                }
            }
        }
        return d;
    }

    private static double min(RealMatrix realMatrix) {
        double d = Double.MAX_VALUE;
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                double entry = realMatrix.getEntry(i5, i6);
                if (d > entry) {
                    d = entry;
                }
            }
        }
        return d;
    }

    private static RealMatrix ones(int i5, int i6) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        for (int i7 = 0; i7 < i5; i7++) {
            Arrays.fill(dArr[i7], 1.0d);
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static void push(double[] dArr, double d) {
        for (int length = dArr.length - 1; length > 0; length--) {
            dArr[length] = dArr[length - 1];
        }
        dArr[0] = d;
    }

    private double[] randn(int i5) {
        double[] dArr = new double[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6] = this.random.nextGaussian();
        }
        return dArr;
    }

    private RealMatrix randn1(int i5, int i6) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                dArr[i7][i8] = this.random.nextGaussian();
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix repmat(RealMatrix realMatrix, int i5, int i6) {
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        int i7 = i5 * rowDimension;
        int i8 = i6 * columnDimension;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i7, i8);
        for (int i9 = 0; i9 < i7; i9++) {
            for (int i10 = 0; i10 < i8; i10++) {
                dArr[i9][i10] = realMatrix.getEntry(i9 % rowDimension, i10 % columnDimension);
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static int[] reverse(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[i5] = iArr[(iArr.length - i5) - 1];
        }
        return iArr2;
    }

    private static RealMatrix selectColumns(RealMatrix realMatrix, int[] iArr) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), iArr.length);
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < iArr.length; i6++) {
                dArr[i5][i6] = realMatrix.getEntry(i5, iArr[i6]);
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix sequence(double d, double d6, double d7) {
        int i5 = (int) (((d6 - d) / d7) + 1.0d);
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, 1);
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6][0] = d;
            d += d7;
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private int[] sortedIndices(double[] dArr) {
        DoubleIndex[] doubleIndexArr = new DoubleIndex[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            doubleIndexArr[i5] = new DoubleIndex(dArr[i5], i5);
        }
        Arrays.sort(doubleIndexArr);
        int[] iArr = new int[dArr.length];
        for (int i6 = 0; i6 < dArr.length; i6++) {
            iArr[i6] = doubleIndexArr[i6].index;
        }
        return iArr;
    }

    private static RealMatrix sqrt(RealMatrix realMatrix) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                dArr[i5][i6] = FastMath.sqrt(realMatrix.getEntry(i5, i6));
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix square(RealMatrix realMatrix) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                double entry = realMatrix.getEntry(i5, i6);
                dArr[i5][i6] = entry * entry;
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix sumRows(RealMatrix realMatrix) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 1, realMatrix.getColumnDimension());
        for (int i5 = 0; i5 < realMatrix.getColumnDimension(); i5++) {
            double entry = 0.0d;
            for (int i6 = 0; i6 < realMatrix.getRowDimension(); i6++) {
                entry += realMatrix.getEntry(i6, i5);
            }
            dArr[0][i5] = entry;
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix times(RealMatrix realMatrix, RealMatrix realMatrix2) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        for (int i5 = 0; i5 < realMatrix.getRowDimension(); i5++) {
            for (int i6 = 0; i6 < realMatrix.getColumnDimension(); i6++) {
                dArr[i5][i6] = realMatrix2.getEntry(i5, i6) * realMatrix.getEntry(i5, i6);
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private static RealMatrix triu(RealMatrix realMatrix, int i5) {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        int i6 = 0;
        while (i6 < realMatrix.getRowDimension()) {
            for (int i7 = 0; i7 < realMatrix.getColumnDimension(); i7++) {
                dArr[i6][i7] = i6 <= i7 - i5 ? realMatrix.getEntry(i6, i7) : 0.0d;
            }
            i6++;
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    private void updateBD(double d) {
        double d6 = this.ccov1;
        double d7 = this.ccovmu;
        if (d6 + d7 + d <= 0.0d || (((((double) this.iterations) % 1.0d) / ((d6 + d7) + d)) / ((double) this.dimension)) / 10.0d >= 1.0d) {
            return;
        }
        RealMatrix realMatrixAdd = triu(this.f6870C, 0).add(triu(this.f6870C, 1).transpose());
        this.f6870C = realMatrixAdd;
        EigenDecomposition eigenDecomposition = new EigenDecomposition(realMatrixAdd);
        this.f6869B = eigenDecomposition.getV();
        RealMatrix d8 = eigenDecomposition.getD();
        this.f6871D = d8;
        RealMatrix realMatrixDiag = diag(d8);
        this.diagD = realMatrixDiag;
        if (min(realMatrixDiag) <= 0.0d) {
            for (int i5 = 0; i5 < this.dimension; i5++) {
                if (this.diagD.getEntry(i5, 0) < 0.0d) {
                    this.diagD.setEntry(i5, 0, 0.0d);
                }
            }
            double dMax = max(this.diagD) / 1.0E14d;
            RealMatrix realMatrix = this.f6870C;
            int i6 = this.dimension;
            this.f6870C = realMatrix.add(eye(i6, i6).scalarMultiply(dMax));
            this.diagD = this.diagD.add(ones(this.dimension, 1).scalarMultiply(dMax));
        }
        if (max(this.diagD) > min(this.diagD) * 1.0E14d) {
            double dMax2 = (max(this.diagD) / 1.0E14d) - min(this.diagD);
            RealMatrix realMatrix2 = this.f6870C;
            int i7 = this.dimension;
            this.f6870C = realMatrix2.add(eye(i7, i7).scalarMultiply(dMax2));
            this.diagD = this.diagD.add(ones(this.dimension, 1).scalarMultiply(dMax2));
        }
        this.diagC = diag(this.f6870C);
        RealMatrix realMatrixSqrt = sqrt(this.diagD);
        this.diagD = realMatrixSqrt;
        this.BD = times(this.f6869B, repmat(realMatrixSqrt.transpose(), this.dimension, 1));
    }

    private void updateCovariance(boolean z6, RealMatrix realMatrix, RealMatrix realMatrix2, int[] iArr, RealMatrix realMatrix3) {
        double d;
        double d6;
        if (this.ccov1 + this.ccovmu > 0.0d) {
            RealMatrix realMatrixScalarMultiply = realMatrix.subtract(repmat(realMatrix3, 1, this.mu)).scalarMultiply(1.0d / this.sigma);
            RealMatrix realMatrix4 = this.pc;
            RealMatrix realMatrixScalarMultiply2 = realMatrix4.multiply(realMatrix4.transpose()).scalarMultiply(this.ccov1);
            if (z6) {
                d6 = 0.0d;
            } else {
                double d7 = this.ccov1;
                double d8 = this.cc;
                d6 = (2.0d - d8) * d7 * d8;
            }
            double d9 = 1.0d - this.ccov1;
            double d10 = this.ccovmu;
            double d11 = (d9 - d10) + d6;
            if (this.isActiveCMA) {
                double dPow = (((1.0d - d10) * 0.25d) * this.mueff) / ((this.mueff * 2.0d) + FastMath.pow(this.dimension + 2, 1.5d));
                RealMatrix realMatrixSelectColumns = selectColumns(realMatrix2, MathArrays.copyOf(reverse(iArr), this.mu));
                RealMatrix realMatrixSqrt = sqrt(sumRows(square(realMatrixSelectColumns)));
                int[] iArrSortedIndices = sortedIndices(realMatrixSqrt.getRow(0));
                RealMatrix realMatrixSelectColumns2 = selectColumns(divide(selectColumns(realMatrixSqrt, reverse(iArrSortedIndices)), selectColumns(realMatrixSqrt, iArrSortedIndices)), inverse(iArrSortedIndices));
                double entry = 0.33999999999999997d / square(realMatrixSelectColumns2).multiply(this.weights).getEntry(0, 0);
                if (dPow <= entry) {
                    entry = dPow;
                }
                RealMatrix realMatrixMultiply = this.BD.multiply(times(realMatrixSelectColumns, repmat(realMatrixSelectColumns2, this.dimension, 1)));
                double d12 = 0.5d * entry;
                this.f6870C = this.f6870C.scalarMultiply(d11 + d12).add(realMatrixScalarMultiply2).add(realMatrixScalarMultiply.scalarMultiply(this.ccovmu + d12).multiply(times(repmat(this.weights, 1, this.dimension), realMatrixScalarMultiply.transpose()))).subtract(realMatrixMultiply.multiply(diag(this.weights)).multiply(realMatrixMultiply.transpose()).scalarMultiply(entry));
                d = entry;
            } else {
                this.f6870C = this.f6870C.scalarMultiply(d11).add(realMatrixScalarMultiply2).add(realMatrixScalarMultiply.scalarMultiply(this.ccovmu).multiply(times(repmat(this.weights, 1, this.dimension), realMatrixScalarMultiply.transpose())));
                d = 0.0d;
            }
        } else {
            d = 0.0d;
        }
        updateBD(d);
    }

    private void updateCovarianceDiagonalOnly(boolean z6, RealMatrix realMatrix) {
        double d;
        if (z6) {
            d = 0.0d;
        } else {
            double d6 = this.ccov1Sep;
            double d7 = this.cc;
            d = d6 * d7 * (2.0d - d7);
        }
        RealMatrix realMatrixAdd = this.diagC.scalarMultiply(((1.0d - this.ccov1Sep) - this.ccovmuSep) + d).add(square(this.pc).scalarMultiply(this.ccov1Sep)).add(times(this.diagC, square(realMatrix).multiply(this.weights)).scalarMultiply(this.ccovmuSep));
        this.diagC = realMatrixAdd;
        this.diagD = sqrt(realMatrixAdd);
        int i5 = this.diagonalOnly;
        if (i5 <= 1 || this.iterations <= i5) {
            return;
        }
        this.diagonalOnly = 0;
        int i6 = this.dimension;
        this.f6869B = eye(i6, i6);
        this.BD = diag(this.diagD);
        this.f6870C = diag(this.diagC);
    }

    private boolean updateEvolutionPaths(RealMatrix realMatrix, RealMatrix realMatrix2) {
        RealMatrix realMatrixScalarMultiply = this.ps.scalarMultiply(1.0d - this.cs);
        RealMatrix realMatrixMultiply = this.f6869B.multiply(realMatrix);
        double d = this.cs;
        RealMatrix realMatrixAdd = realMatrixScalarMultiply.add(realMatrixMultiply.scalarMultiply(FastMath.sqrt((2.0d - d) * d * this.mueff)));
        this.ps = realMatrixAdd;
        double frobeniusNorm = realMatrixAdd.getFrobeniusNorm();
        this.normps = frobeniusNorm;
        boolean z6 = (frobeniusNorm / FastMath.sqrt(1.0d - FastMath.pow(1.0d - this.cs, this.iterations * 2))) / this.chiN < (2.0d / (((double) this.dimension) + 1.0d)) + 1.4d;
        RealMatrix realMatrixScalarMultiply2 = this.pc.scalarMultiply(1.0d - this.cc);
        this.pc = realMatrixScalarMultiply2;
        if (z6) {
            RealMatrix realMatrixSubtract = this.xmean.subtract(realMatrix2);
            double d6 = this.cc;
            this.pc = realMatrixScalarMultiply2.add(realMatrixSubtract.scalarMultiply(FastMath.sqrt(((2.0d - d6) * d6) * this.mueff) / this.sigma));
        }
        return z6;
    }

    private double valueRange(ValuePenaltyPair[] valuePenaltyPairArr) {
        double d = Double.NEGATIVE_INFINITY;
        double d6 = Double.MAX_VALUE;
        for (ValuePenaltyPair valuePenaltyPair : valuePenaltyPairArr) {
            if (valuePenaltyPair.value > d) {
                d = valuePenaltyPair.value;
            }
            if (valuePenaltyPair.value < d6) {
                d6 = valuePenaltyPair.value;
            }
        }
        return d - d6;
    }

    private static RealMatrix zeros(int i5, int i6) {
        return new Array2DRowRealMatrix(i5, i6);
    }

    public List<RealMatrix> getStatisticsDHistory() {
        return this.statisticsDHistory;
    }

    public List<Double> getStatisticsFitnessHistory() {
        return this.statisticsFitnessHistory;
    }

    public List<RealMatrix> getStatisticsMeanHistory() {
        return this.statisticsMeanHistory;
    }

    public List<Double> getStatisticsSigmaHistory() {
        return this.statisticsSigmaHistory;
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public void parseOptimizationData(OptimizationData... optimizationDataArr) {
        super.parseOptimizationData(optimizationDataArr);
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof Sigma) {
                this.inputSigma = ((Sigma) optimizationData).getSigma();
            } else if (optimizationData instanceof PopulationSize) {
                this.lambda = ((PopulationSize) optimizationData).getPopulationSize();
            }
        }
        checkParameters();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0283  */
    /* JADX WARN: Code duplicated, block: B:105:0x029c  */
    /* JADX WARN: Code duplicated, block: B:106:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:109:0x02be  */
    /* JADX WARN: Code duplicated, block: B:114:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:123:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x01fb A[EDGE_INSN: B:137:0x01fb->B:70:0x01fb BREAK  A[LOOP:4: B:60:0x01c2->B:68:0x01ee], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ee A[LOOP:4: B:60:0x01c2->B:68:0x01ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0200  */
    /* JADX WARN: Code duplicated, block: B:76:0x020d A[LOOP:5: B:71:0x01fc->B:76:0x020d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x0263  */
    /* JADX WARN: Code duplicated, block: B:95:0x026e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0270  */
    /* JADX WARN: Code duplicated, block: B:99:0x0276  */
    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair doOptimize() {
        PointValuePair pointValuePair;
        double[] column;
        double[] column2;
        int i5;
        FitnessFunction fitnessFunction;
        double[] dArr;
        int i6;
        PointValuePair pointValuePair2;
        double d;
        double d6;
        double[] dArr2;
        int i7;
        RealMatrix realMatrixAdd;
        this.isMinimize = getGoalType().equals(GoalType.MINIMIZE);
        FitnessFunction fitnessFunction2 = new FitnessFunction();
        double[] startPoint = getStartPoint();
        this.dimension = startPoint.length;
        initializeCMA(startPoint);
        int i8 = 0;
        this.iterations = 0;
        ValuePenaltyPair valuePenaltyPairValue = fitnessFunction2.value(startPoint);
        double d7 = valuePenaltyPairValue.value + valuePenaltyPairValue.penalty;
        push(this.fitnessHistory, d7);
        PointValuePair pointValuePair3 = new PointValuePair(getStartPoint(), this.isMinimize ? d7 : -d7);
        boolean z6 = true;
        this.iterations = 1;
        double d8 = d7;
        PointValuePair pointValuePair4 = null;
        while (true) {
            pointValuePair = pointValuePair3;
            if (this.iterations > this.maxIterations) {
                break;
            }
            incrementIterationCount();
            RealMatrix realMatrixRandn1 = randn1(this.dimension, this.lambda);
            RealMatrix realMatrixZeros = zeros(this.dimension, this.lambda);
            int i9 = this.lambda;
            double[] dArr3 = new double[i9];
            ValuePenaltyPair[] valuePenaltyPairArr = new ValuePenaltyPair[i9];
            int i10 = i8;
            while (i10 < this.lambda) {
                int i11 = i8;
                boolean z7 = z6;
                RealMatrix realMatrix = null;
                while (true) {
                    if (i11 >= this.checkFeasableCount + 1) {
                        d8 = d8;
                        i7 = i8;
                        realMatrixAdd = realMatrix;
                        break;
                    }
                    realMatrixAdd = this.diagonalOnly <= 0 ? this.xmean.add(this.BD.multiply(realMatrixRandn1.getColumnMatrix(i10)).scalarMultiply(this.sigma)) : this.xmean.add(times(this.diagD, realMatrixRandn1.getColumnMatrix(i10)).scalarMultiply(this.sigma));
                    if (i11 >= this.checkFeasableCount || fitnessFunction2.isFeasible(realMatrixAdd.getColumn(0))) {
                        i7 = 0;
                        break;
                    }
                    realMatrixRandn1.setColumn(i10, randn(this.dimension));
                    i11++;
                    realMatrix = realMatrixAdd;
                    d8 = d8;
                    i8 = 0;
                }
                copyColumn(realMatrixAdd, i7, realMatrixZeros, i10);
                try {
                    valuePenaltyPairArr[i10] = fitnessFunction2.value(realMatrixZeros.getColumn(i10));
                    i10++;
                    z6 = z7;
                    d8 = d8;
                    i8 = 0;
                } catch (TooManyEvaluationsException unused) {
                }
            }
            boolean z8 = z6;
            double d9 = d8;
            double dValueRange = valueRange(valuePenaltyPairArr);
            for (int i12 = 0; i12 < i9; i12++) {
                dArr3[i12] = (valuePenaltyPairArr[i12].penalty * dValueRange) + valuePenaltyPairArr[i12].value;
            }
            int[] iArrSortedIndices = sortedIndices(dArr3);
            RealMatrix realMatrix2 = this.xmean;
            RealMatrix realMatrixSelectColumns = selectColumns(realMatrixZeros, MathArrays.copyOf(iArrSortedIndices, this.mu));
            this.xmean = realMatrixSelectColumns.multiply(this.weights);
            RealMatrix realMatrixSelectColumns2 = selectColumns(realMatrixRandn1, MathArrays.copyOf(iArrSortedIndices, this.mu));
            boolean zUpdateEvolutionPaths = updateEvolutionPaths(realMatrixSelectColumns2.multiply(this.weights), realMatrix2);
            if (this.diagonalOnly <= 0) {
                updateCovariance(zUpdateEvolutionPaths, realMatrixSelectColumns, realMatrixRandn1, iArrSortedIndices, realMatrix2);
            } else {
                updateCovarianceDiagonalOnly(zUpdateEvolutionPaths, realMatrixSelectColumns2);
            }
            this.sigma = FastMath.exp(FastMath.min(1.0d, (((this.normps / this.chiN) - 1.0d) * this.cs) / this.damps)) * this.sigma;
            double d10 = dArr3[iArrSortedIndices[0]];
            double d11 = dArr3[iArrSortedIndices[iArrSortedIndices.length - 1]];
            if (d9 > d10) {
                pointValuePair3 = new PointValuePair(fitnessFunction2.repair(realMatrixSelectColumns.getColumn(0)), this.isMinimize ? d10 : -d10);
                if (getConvergenceChecker() != null && getConvergenceChecker().converged(this.iterations, pointValuePair3, pointValuePair)) {
                    return pointValuePair3;
                }
                d9 = d10;
            } else {
                pointValuePair3 = pointValuePair;
                pointValuePair = pointValuePair4;
            }
            double d12 = this.stopFitness;
            if (d12 == 0.0d) {
                column = sqrt(this.diagC).getColumn(0);
                column2 = this.pc.getColumn(0);
                i5 = 0;
                while (true) {
                    if (i5 < this.dimension) {
                        fitnessFunction = fitnessFunction2;
                        dArr = dArr3;
                        break;
                    }
                    dArr2 = column2;
                    fitnessFunction = fitnessFunction2;
                    dArr = dArr3;
                    if (FastMath.max(FastMath.abs(dArr2[i5]), column[i5]) * this.sigma > this.stopTolX) {
                        break;
                    }
                    if (i5 >= this.dimension - 1) {
                        i5++;
                        column2 = dArr2;
                        dArr3 = dArr;
                        fitnessFunction2 = fitnessFunction;
                    }
                }
                for (i6 = 0; i6 < this.dimension; i6++) {
                    if (this.sigma * column[i6] > this.stopTolUpX) {
                    }
                }
                double dMin = min(this.fitnessHistory);
                double dMax = max(this.fitnessHistory);
                if (this.iterations > 2 || FastMath.max(dMax, d11) - FastMath.min(dMin, d10) >= this.stopTolFun) {
                    if ((this.iterations > this.fitnessHistory.length || dMax - dMin >= this.stopTolHistFun) && max(this.diagD) / min(this.diagD) <= 1.0E7d) {
                        if (getConvergenceChecker() != null) {
                            double[] column3 = realMatrixSelectColumns.getColumn(0);
                            if (this.isMinimize) {
                                d6 = d10;
                            } else {
                                d6 = -d10;
                            }
                            pointValuePair2 = new PointValuePair(column3, d6);
                            if (pointValuePair != null && getConvergenceChecker().converged(this.iterations, pointValuePair2, pointValuePair)) {
                            }
                        } else {
                            pointValuePair2 = pointValuePair;
                        }
                        if (d9 == dArr[iArrSortedIndices[(int) ((((double) this.lambda) / 4.0d) + 0.1d)]]) {
                            d = 0.2d;
                            this.sigma = FastMath.exp((this.cs / this.damps) + 0.2d) * this.sigma;
                        } else {
                            d = 0.2d;
                        }
                        if (this.iterations > 2 && FastMath.max(dMax, d10) - FastMath.min(dMin, d10) == 0) {
                            this.sigma = FastMath.exp((this.cs / this.damps) + d) * this.sigma;
                        }
                        push(this.fitnessHistory, d10);
                        if (this.generateStatistics) {
                            this.statisticsSigmaHistory.add(Double.valueOf(this.sigma));
                            this.statisticsFitnessHistory.add(Double.valueOf(d10));
                            this.statisticsMeanHistory.add(this.xmean.transpose());
                            this.statisticsDHistory.add(this.diagD.transpose().scalarMultiply(100000.0d));
                        }
                        this.iterations++;
                        pointValuePair4 = pointValuePair2;
                        z6 = z8;
                        d8 = d9;
                        fitnessFunction2 = fitnessFunction;
                        i8 = 0;
                    }
                }
            } else {
                if (!this.isMinimize) {
                    d12 = -d12;
                }
                if (d10 >= d12) {
                    column = sqrt(this.diagC).getColumn(0);
                    column2 = this.pc.getColumn(0);
                    i5 = 0;
                    while (true) {
                        if (i5 < this.dimension) {
                            fitnessFunction = fitnessFunction2;
                            dArr = dArr3;
                            break;
                        }
                        dArr2 = column2;
                        fitnessFunction = fitnessFunction2;
                        dArr = dArr3;
                        if (FastMath.max(FastMath.abs(dArr2[i5]), column[i5]) * this.sigma > this.stopTolX) {
                            break;
                            break;
                        }
                        if (i5 >= this.dimension - 1) {
                            i5++;
                            column2 = dArr2;
                            dArr3 = dArr;
                            fitnessFunction2 = fitnessFunction;
                        }
                    }
                    while (i6 < this.dimension) {
                        if (this.sigma * column[i6] > this.stopTolUpX) {
                        }
                    }
                    double dMin2 = min(this.fitnessHistory);
                    double dMax2 = max(this.fitnessHistory);
                    if (this.iterations > 2) {
                    }
                    if (this.iterations > this.fitnessHistory.length) {
                        if (getConvergenceChecker() != null) {
                            double[] column4 = realMatrixSelectColumns.getColumn(0);
                            if (this.isMinimize) {
                                d6 = d10;
                            } else {
                                d6 = -d10;
                            }
                            pointValuePair2 = new PointValuePair(column4, d6);
                            if (pointValuePair != null) {
                            }
                        } else {
                            pointValuePair2 = pointValuePair;
                        }
                        if (d9 == dArr[iArrSortedIndices[(int) ((((double) this.lambda) / 4.0d) + 0.1d)]]) {
                            d = 0.2d;
                            this.sigma = FastMath.exp((this.cs / this.damps) + 0.2d) * this.sigma;
                        } else {
                            d = 0.2d;
                        }
                        if (this.iterations > 2) {
                            this.sigma = FastMath.exp((this.cs / this.damps) + d) * this.sigma;
                        }
                        push(this.fitnessHistory, d10);
                        if (this.generateStatistics) {
                            this.statisticsSigmaHistory.add(Double.valueOf(this.sigma));
                            this.statisticsFitnessHistory.add(Double.valueOf(d10));
                            this.statisticsMeanHistory.add(this.xmean.transpose());
                            this.statisticsDHistory.add(this.diagD.transpose().scalarMultiply(100000.0d));
                        }
                        this.iterations++;
                        pointValuePair4 = pointValuePair2;
                        z6 = z8;
                        d8 = d9;
                        fitnessFunction2 = fitnessFunction;
                        i8 = 0;
                    } else {
                        if (getConvergenceChecker() != null) {
                            double[] column5 = realMatrixSelectColumns.getColumn(0);
                            if (this.isMinimize) {
                                d6 = d10;
                            } else {
                                d6 = -d10;
                            }
                            pointValuePair2 = new PointValuePair(column5, d6);
                            if (pointValuePair != null) {
                            }
                        } else {
                            pointValuePair2 = pointValuePair;
                        }
                        if (d9 == dArr[iArrSortedIndices[(int) ((((double) this.lambda) / 4.0d) + 0.1d)]]) {
                            d = 0.2d;
                            this.sigma = FastMath.exp((this.cs / this.damps) + 0.2d) * this.sigma;
                        } else {
                            d = 0.2d;
                        }
                        if (this.iterations > 2) {
                            this.sigma = FastMath.exp((this.cs / this.damps) + d) * this.sigma;
                        }
                        push(this.fitnessHistory, d10);
                        if (this.generateStatistics) {
                            this.statisticsSigmaHistory.add(Double.valueOf(this.sigma));
                            this.statisticsFitnessHistory.add(Double.valueOf(d10));
                            this.statisticsMeanHistory.add(this.xmean.transpose());
                            this.statisticsDHistory.add(this.diagD.transpose().scalarMultiply(100000.0d));
                        }
                        this.iterations++;
                        pointValuePair4 = pointValuePair2;
                        z6 = z8;
                        d8 = d9;
                        fitnessFunction2 = fitnessFunction;
                        i8 = 0;
                    }
                }
            }
            return pointValuePair3;
        }
        return pointValuePair;
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... optimizationDataArr) {
        return super.optimize(optimizationDataArr);
    }

    private static double max(double[] dArr) {
        double d = -1.7976931348623157E308d;
        for (double d6 : dArr) {
            if (d < d6) {
                d = d6;
            }
        }
        return d;
    }

    private static double min(double[] dArr) {
        double d = Double.MAX_VALUE;
        for (double d6 : dArr) {
            if (d > d6) {
                d = d6;
            }
        }
        return d;
    }
}

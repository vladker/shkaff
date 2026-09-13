package org.apache.commons.math3.optimization.direct;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleValueChecker;
import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class CMAESOptimizer extends BaseAbstractMultivariateSimpleBoundsOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    public static final int DEFAULT_CHECKFEASABLECOUNT = 0;
    public static final int DEFAULT_DIAGONALONLY = 0;
    public static final boolean DEFAULT_ISACTIVECMA = true;
    public static final int DEFAULT_MAXITERATIONS = 30000;
    public static final RandomGenerator DEFAULT_RANDOMGENERATOR = new MersenneTwister();
    public static final double DEFAULT_STOPFITNESS = 0.0d;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private RealMatrix f6872B;
    private RealMatrix BD;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private RealMatrix f6873C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private RealMatrix f6874D;
    private double cc;
    private double ccov1;
    private double ccov1Sep;
    private double ccovmu;
    private double ccovmuSep;
    private int checkFeasableCount;
    private double chiN;
    private double cs;
    private double damps;
    private RealMatrix diagC;
    private RealMatrix diagD;
    private int diagonalOnly;
    private int dimension;
    private double[] fitnessHistory;
    private boolean generateStatistics;
    private int historySize;
    private double[] inputSigma;
    private boolean isActiveCMA;
    private boolean isMinimize;
    private int iterations;
    private int lambda;
    private double logMu2;
    private int maxIterations;
    private int mu;
    private double mueff;
    private double normps;
    private RealMatrix pc;
    private RealMatrix ps;
    private RandomGenerator random;
    private double sigma;
    private List<RealMatrix> statisticsDHistory;
    private List<Double> statisticsFitnessHistory;
    private List<RealMatrix> statisticsMeanHistory;
    private List<Double> statisticsSigmaHistory;
    private double stopFitness;
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
        private double valueRange = 1.0d;
        private final boolean isRepairMode = true;

        public FitnessFunction() {
        }

        private double penalty(double[] dArr, double[] dArr2) {
            double dAbs = 0.0d;
            for (int i5 = 0; i5 < dArr.length; i5++) {
                dAbs += FastMath.abs(dArr[i5] - dArr2[i5]) * this.valueRange;
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

        public void setValueRange(double d) {
            this.valueRange = d;
        }

        public double value(double[] dArr) {
            double dComputeObjectiveValue;
            if (this.isRepairMode) {
                double[] dArrRepair = repair(dArr);
                dComputeObjectiveValue = CMAESOptimizer.this.computeObjectiveValue(dArrRepair) + penalty(dArr, dArrRepair);
            } else {
                dComputeObjectiveValue = CMAESOptimizer.this.computeObjectiveValue(dArr);
            }
            return CMAESOptimizer.this.isMinimize ? dComputeObjectiveValue : -dComputeObjectiveValue;
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

    @Deprecated
    public CMAESOptimizer() {
        this(0);
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
                double d = this.inputSigma[i5];
                if (d < 0.0d) {
                    throw new NotPositiveException(Double.valueOf(this.inputSigma[i5]));
                }
                if (d > upperBound[i5] - lowerBound[i5]) {
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
            this.lambda = ((int) (FastMath.log(this.dimension) * 3.0d)) + 4;
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, 1);
        int i5 = 0;
        while (true) {
            double d = 0.3d;
            if (i5 >= dArr.length) {
                break;
            }
            double[] dArr3 = dArr2[i5];
            double[] dArr4 = this.inputSigma;
            if (dArr4 != null) {
                d = dArr4[i5];
            }
            dArr3[0] = d;
            i5++;
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
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (int i7 = 0; i7 < this.mu; i7++) {
            double entry = this.weights.getEntry(i7, 0);
            d6 += entry;
            d7 = (entry * entry) + d7;
        }
        this.weights = this.weights.scalarMultiply(1.0d / d6);
        double d8 = (d6 * d6) / d7;
        this.mueff = d8;
        int i8 = this.dimension;
        this.cc = ((d8 / ((double) i8)) + 4.0d) / (((d8 * 2.0d) / ((double) i8)) + ((double) (i8 + 4)));
        this.cs = (d8 + 2.0d) / ((((double) i8) + d8) + 3.0d);
        this.damps = (FastMath.max(0.3d, 1.0d - (((double) this.dimension) / (((double) this.maxIterations) + 1.0E-6d))) * ((FastMath.max(0.0d, FastMath.sqrt((d8 - 1.0d) / ((double) (i8 + 1))) - 1.0d) * 2.0d) + 1.0d)) + this.cs;
        int i9 = this.dimension;
        double d9 = this.mueff;
        double d10 = 2.0d / (((((double) i9) + 1.3d) * (((double) i9) + 1.3d)) + d9);
        this.ccov1 = d10;
        this.ccovmu = FastMath.min(1.0d - d10, (((1.0d / d9) + (d9 - 2.0d)) * 2.0d) / (((double) ((i9 + 2) * (i9 + 2))) + d9));
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
        this.f6872B = eye(i11, i11);
        this.f6874D = ones(this.dimension, 1);
        this.BD = times(this.f6872B, repmat(this.diagD.transpose(), this.dimension, 1));
        this.f6873C = this.f6872B.multiply(diag(square(this.f6874D)).multiply(this.f6872B.transpose()));
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

    private void parseOptimizationData(OptimizationData... optimizationDataArr) {
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof Sigma) {
                this.inputSigma = ((Sigma) optimizationData).getSigma();
            } else if (optimizationData instanceof PopulationSize) {
                this.lambda = ((PopulationSize) optimizationData).getPopulationSize();
            }
        }
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
        RealMatrix realMatrixAdd = triu(this.f6873C, 0).add(triu(this.f6873C, 1).transpose());
        this.f6873C = realMatrixAdd;
        EigenDecomposition eigenDecomposition = new EigenDecomposition(realMatrixAdd);
        this.f6872B = eigenDecomposition.getV();
        RealMatrix d8 = eigenDecomposition.getD();
        this.f6874D = d8;
        RealMatrix realMatrixDiag = diag(d8);
        this.diagD = realMatrixDiag;
        if (min(realMatrixDiag) <= 0.0d) {
            for (int i5 = 0; i5 < this.dimension; i5++) {
                if (this.diagD.getEntry(i5, 0) < 0.0d) {
                    this.diagD.setEntry(i5, 0, 0.0d);
                }
            }
            double dMax = max(this.diagD) / 1.0E14d;
            RealMatrix realMatrix = this.f6873C;
            int i6 = this.dimension;
            this.f6873C = realMatrix.add(eye(i6, i6).scalarMultiply(dMax));
            this.diagD = this.diagD.add(ones(this.dimension, 1).scalarMultiply(dMax));
        }
        if (max(this.diagD) > min(this.diagD) * 1.0E14d) {
            double dMax2 = (max(this.diagD) / 1.0E14d) - min(this.diagD);
            RealMatrix realMatrix2 = this.f6873C;
            int i7 = this.dimension;
            this.f6873C = realMatrix2.add(eye(i7, i7).scalarMultiply(dMax2));
            this.diagD = this.diagD.add(ones(this.dimension, 1).scalarMultiply(dMax2));
        }
        this.diagC = diag(this.f6873C);
        RealMatrix realMatrixSqrt = sqrt(this.diagD);
        this.diagD = realMatrixSqrt;
        this.BD = times(this.f6872B, repmat(realMatrixSqrt.transpose(), this.dimension, 1));
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
                this.f6873C = this.f6873C.scalarMultiply(d11 + d12).add(realMatrixScalarMultiply2).add(realMatrixScalarMultiply.scalarMultiply(this.ccovmu + d12).multiply(times(repmat(this.weights, 1, this.dimension), realMatrixScalarMultiply.transpose()))).subtract(realMatrixMultiply.multiply(diag(this.weights)).multiply(realMatrixMultiply.transpose()).scalarMultiply(entry));
                d = entry;
            } else {
                this.f6873C = this.f6873C.scalarMultiply(d11).add(realMatrixScalarMultiply2).add(realMatrixScalarMultiply.scalarMultiply(this.ccovmu).multiply(times(repmat(this.weights, 1, this.dimension), realMatrixScalarMultiply.transpose())));
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
        this.f6872B = eye(i6, i6);
        this.BD = diag(this.diagD);
        this.f6873C = diag(this.diagC);
    }

    private boolean updateEvolutionPaths(RealMatrix realMatrix, RealMatrix realMatrix2) {
        RealMatrix realMatrixScalarMultiply = this.ps.scalarMultiply(1.0d - this.cs);
        RealMatrix realMatrixMultiply = this.f6872B.multiply(realMatrix);
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

    private static RealMatrix zeros(int i5, int i6) {
        return new Array2DRowRealMatrix(i5, i6);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    public PointValuePair doOptimize() {
        PointValuePair pointValuePair;
        PointValuePair pointValuePair2;
        int[] iArr;
        double[] dArr;
        double d;
        checkParameters();
        this.isMinimize = getGoalType().equals(GoalType.MINIMIZE);
        FitnessFunction fitnessFunction = new FitnessFunction();
        double[] startPoint = getStartPoint();
        this.dimension = startPoint.length;
        initializeCMA(startPoint);
        int i5 = 0;
        this.iterations = 0;
        double dValue = fitnessFunction.value(startPoint);
        push(this.fitnessHistory, dValue);
        PointValuePair pointValuePair3 = new PointValuePair(getStartPoint(), this.isMinimize ? dValue : -dValue);
        int i6 = 1;
        this.iterations = 1;
        double d6 = dValue;
        PointValuePair pointValuePair4 = pointValuePair3;
        PointValuePair pointValuePair5 = null;
        while (this.iterations <= this.maxIterations) {
            RealMatrix realMatrixRandn1 = randn1(this.dimension, this.lambda);
            RealMatrix realMatrixZeros = zeros(this.dimension, this.lambda);
            double[] dArr2 = new double[this.lambda];
            int i7 = i5;
            while (i7 < this.lambda) {
                int i8 = i5;
                RealMatrix realMatrixAdd = null;
                while (true) {
                    if (i8 >= this.checkFeasableCount + i6) {
                        i6 = i6;
                        d6 = d6;
                        break;
                    }
                    realMatrixAdd = this.diagonalOnly <= 0 ? this.xmean.add(this.BD.multiply(realMatrixRandn1.getColumnMatrix(i7)).scalarMultiply(this.sigma)) : this.xmean.add(times(this.diagD, realMatrixRandn1.getColumnMatrix(i7)).scalarMultiply(this.sigma));
                    if (i8 >= this.checkFeasableCount || fitnessFunction.isFeasible(realMatrixAdd.getColumn(i5))) {
                        break;
                    }
                    realMatrixRandn1.setColumn(i7, randn(this.dimension));
                    i8++;
                    i6 = i6;
                    d6 = d6;
                }
                copyColumn(realMatrixAdd, i5, realMatrixZeros, i7);
                try {
                    dArr2[i7] = fitnessFunction.value(realMatrixZeros.getColumn(i7));
                    i7++;
                    i6 = i6;
                    d6 = d6;
                } catch (TooManyEvaluationsException unused) {
                }
            }
            int i9 = i6;
            double d7 = d6;
            int[] iArrSortedIndices = sortedIndices(dArr2);
            RealMatrix realMatrix = this.xmean;
            RealMatrix realMatrixSelectColumns = selectColumns(realMatrixZeros, MathArrays.copyOf(iArrSortedIndices, this.mu));
            this.xmean = realMatrixSelectColumns.multiply(this.weights);
            RealMatrix realMatrixSelectColumns2 = selectColumns(realMatrixRandn1, MathArrays.copyOf(iArrSortedIndices, this.mu));
            boolean zUpdateEvolutionPaths = updateEvolutionPaths(realMatrixSelectColumns2.multiply(this.weights), realMatrix);
            if (this.diagonalOnly <= 0) {
                updateCovariance(zUpdateEvolutionPaths, realMatrixSelectColumns, realMatrixRandn1, iArrSortedIndices, realMatrix);
            } else {
                updateCovarianceDiagonalOnly(zUpdateEvolutionPaths, realMatrixSelectColumns2);
            }
            int i10 = i5;
            this.sigma = FastMath.exp(FastMath.min(1.0d, (((this.normps / this.chiN) - 1.0d) * this.cs) / this.damps)) * this.sigma;
            double d8 = dArr2[iArrSortedIndices[i10]];
            double d9 = dArr2[iArrSortedIndices[iArrSortedIndices.length - 1]];
            if (d7 > d8) {
                pointValuePair = new PointValuePair(fitnessFunction.repair(realMatrixSelectColumns.getColumn(i10)), this.isMinimize ? d8 : -d8);
                if (getConvergenceChecker() != null && getConvergenceChecker().converged(this.iterations, pointValuePair, pointValuePair4)) {
                    return pointValuePair;
                }
                d7 = d8;
            } else {
                dArr2 = dArr2;
                pointValuePair = pointValuePair4;
                pointValuePair4 = pointValuePair5;
            }
            double d10 = this.stopFitness;
            if (d10 != 0.0d) {
                if (!this.isMinimize) {
                    d10 = -d10;
                }
                if (d8 < d10) {
                    return pointValuePair;
                }
            }
            double[] column = sqrt(this.diagC).getColumn(0);
            double[] column2 = this.pc.getColumn(0);
            int i11 = 0;
            while (true) {
                pointValuePair2 = pointValuePair;
                if (i11 >= this.dimension) {
                    iArr = iArrSortedIndices;
                    dArr = column;
                    break;
                }
                iArr = iArrSortedIndices;
                dArr = column;
                if (FastMath.max(FastMath.abs(column2[i11]), dArr[i11]) * this.sigma > this.stopTolX) {
                    break;
                }
                if (i11 >= this.dimension - 1) {
                    return pointValuePair2;
                }
                i11++;
                pointValuePair = pointValuePair2;
                iArrSortedIndices = iArr;
                column = dArr;
            }
            for (int i12 = 0; i12 < this.dimension; i12++) {
                if (this.sigma * dArr[i12] > this.stopTolUpX) {
                    return pointValuePair2;
                }
            }
            double dMin = min(this.fitnessHistory);
            double dMax = max(this.fitnessHistory);
            if (this.iterations > 2 && FastMath.max(dMax, d9) - FastMath.min(dMin, d8) < this.stopTolFun) {
                return pointValuePair2;
            }
            if ((this.iterations > this.fitnessHistory.length && dMax - dMin < this.stopTolHistFun) || max(this.diagD) / min(this.diagD) > 1.0E7d) {
                return pointValuePair2;
            }
            if (getConvergenceChecker() != null) {
                pointValuePair5 = new PointValuePair(realMatrixSelectColumns.getColumn(0), this.isMinimize ? d8 : -d8);
                if (pointValuePair4 != null && getConvergenceChecker().converged(this.iterations, pointValuePair5, pointValuePair4)) {
                    return pointValuePair2;
                }
            } else {
                pointValuePair5 = pointValuePair4;
            }
            if (d7 == dArr2[iArr[(int) ((((double) this.lambda) / 4.0d) + 0.1d)]]) {
                d = 0.2d;
                this.sigma = FastMath.exp((this.cs / this.damps) + 0.2d) * this.sigma;
            } else {
                d = 0.2d;
            }
            if (this.iterations > 2 && FastMath.max(dMax, d8) - FastMath.min(dMin, d8) == 0.0d) {
                this.sigma = FastMath.exp((this.cs / this.damps) + d) * this.sigma;
            }
            push(this.fitnessHistory, d8);
            fitnessFunction.setValueRange(d9 - d8);
            if (this.generateStatistics) {
                this.statisticsSigmaHistory.add(Double.valueOf(this.sigma));
                this.statisticsFitnessHistory.add(Double.valueOf(d8));
                this.statisticsMeanHistory.add(this.xmean.transpose());
                this.statisticsDHistory.add(this.diagD.transpose().scalarMultiply(100000.0d));
            }
            this.iterations++;
            i6 = i9;
            d6 = d7;
            pointValuePair4 = pointValuePair2;
            i5 = 0;
        }
        return pointValuePair4;
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

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    public PointValuePair optimizeInternal(int i5, MultivariateFunction multivariateFunction, GoalType goalType, OptimizationData... optimizationDataArr) {
        parseOptimizationData(optimizationDataArr);
        return super.optimizeInternal(i5, multivariateFunction, goalType, optimizationDataArr);
    }

    @Deprecated
    public CMAESOptimizer(int i5) {
        this(i5, null, DEFAULT_MAXITERATIONS, 0.0d, true, 0, 0, DEFAULT_RANDOMGENERATOR, false, null);
    }

    @Deprecated
    public CMAESOptimizer(int i5, double[] dArr) {
        this(i5, dArr, DEFAULT_MAXITERATIONS, 0.0d, true, 0, 0, DEFAULT_RANDOMGENERATOR, false);
    }

    @Deprecated
    public CMAESOptimizer(int i5, double[] dArr, int i6, double d, boolean z6, int i7, int i8, RandomGenerator randomGenerator, boolean z7) {
        this(i5, dArr, i6, d, z6, i7, i8, randomGenerator, z7, new SimpleValueChecker());
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

    @Deprecated
    public CMAESOptimizer(int i5, double[] dArr, int i6, double d, boolean z6, int i7, int i8, RandomGenerator randomGenerator, boolean z7, ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
        this.diagonalOnly = 0;
        this.isMinimize = true;
        this.generateStatistics = false;
        this.statisticsSigmaHistory = new ArrayList();
        this.statisticsMeanHistory = new ArrayList();
        this.statisticsFitnessHistory = new ArrayList();
        this.statisticsDHistory = new ArrayList();
        this.lambda = i5;
        this.inputSigma = dArr == null ? null : (double[]) dArr.clone();
        this.maxIterations = i6;
        this.stopFitness = d;
        this.isActiveCMA = z6;
        this.diagonalOnly = i7;
        this.checkFeasableCount = i8;
        this.random = randomGenerator;
        this.generateStatistics = z7;
    }

    public CMAESOptimizer(int i5, double d, boolean z6, int i6, int i7, RandomGenerator randomGenerator, boolean z7, ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
        this.diagonalOnly = 0;
        this.isMinimize = true;
        this.generateStatistics = false;
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
}

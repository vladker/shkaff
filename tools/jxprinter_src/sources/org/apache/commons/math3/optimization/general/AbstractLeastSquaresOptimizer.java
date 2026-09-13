package org.apache.commons.math3.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class AbstractLeastSquaresOptimizer extends BaseAbstractMultivariateVectorOptimizer<DifferentiableMultivariateVectorFunction> implements DifferentiableMultivariateVectorOptimizer {

    @Deprecated
    private static final double DEFAULT_SINGULARITY_THRESHOLD = 1.0E-14d;

    @Deprecated
    protected int cols;

    @Deprecated
    protected double cost;
    private MultivariateDifferentiableVectorFunction jF;
    private int jacobianEvaluations;

    @Deprecated
    protected double[] objective;

    @Deprecated
    protected double[] point;

    @Deprecated
    protected int rows;
    private RealMatrix weightMatrixSqrt;

    @Deprecated
    protected double[][] weightedResidualJacobian;

    @Deprecated
    protected double[] weightedResiduals;

    @Deprecated
    public AbstractLeastSquaresOptimizer() {
    }

    private RealMatrix squareRoot(RealMatrix realMatrix) {
        if (!(realMatrix instanceof DiagonalMatrix)) {
            return new EigenDecomposition(realMatrix).getSquareRoot();
        }
        int rowDimension = realMatrix.getRowDimension();
        DiagonalMatrix diagonalMatrix = new DiagonalMatrix(rowDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            diagonalMatrix.setEntry(i5, i5, FastMath.sqrt(realMatrix.getEntry(i5, i5)));
        }
        return diagonalMatrix;
    }

    public double computeCost(double[] dArr) {
        ArrayRealVector arrayRealVector = new ArrayRealVector(dArr);
        return FastMath.sqrt(arrayRealVector.dotProduct(getWeight().operate(arrayRealVector)));
    }

    public double[][] computeCovariances(double[] dArr, double d) {
        RealMatrix realMatrixComputeWeightedJacobian = computeWeightedJacobian(dArr);
        return new QRDecomposition(realMatrixComputeWeightedJacobian.transpose().multiply(realMatrixComputeWeightedJacobian), d).getSolver().getInverse().getData();
    }

    public double[] computeResiduals(double[] dArr) {
        double[] target = getTarget();
        if (dArr.length != target.length) {
            throw new DimensionMismatchException(target.length, dArr.length);
        }
        double[] dArr2 = new double[target.length];
        for (int i5 = 0; i5 < target.length; i5++) {
            dArr2[i5] = target[i5] - dArr[i5];
        }
        return dArr2;
    }

    public double[] computeSigma(double[] dArr, double d) {
        int length = dArr.length;
        double[] dArr2 = new double[length];
        double[][] dArrComputeCovariances = computeCovariances(dArr, d);
        for (int i5 = 0; i5 < length; i5++) {
            dArr2[i5] = FastMath.sqrt(dArrComputeCovariances[i5][i5]);
        }
        return dArr2;
    }

    public RealMatrix computeWeightedJacobian(double[] dArr) {
        this.jacobianEvaluations++;
        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[dArr.length];
        int length = dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            derivativeStructureArr[i5] = new DerivativeStructure(length, 1, i5, dArr[i5]);
        }
        DerivativeStructure[] derivativeStructureArrValue = this.jF.value(derivativeStructureArr);
        int length2 = getTarget().length;
        if (derivativeStructureArrValue.length != length2) {
            throw new DimensionMismatchException(derivativeStructureArrValue.length, length2);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length);
        for (int i6 = 0; i6 < length2; i6++) {
            int[] iArr = new int[length];
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = 1;
                dArr2[i6][i7] = derivativeStructureArrValue[i6].getPartialDerivative(iArr);
                iArr[i7] = 0;
            }
        }
        return this.weightMatrixSqrt.multiply(MatrixUtils.createRealMatrix(dArr2));
    }

    public double getChiSquare() {
        double d = this.cost;
        return d * d;
    }

    @Deprecated
    public double[][] getCovariances() {
        return getCovariances(DEFAULT_SINGULARITY_THRESHOLD);
    }

    public int getJacobianEvaluations() {
        return this.jacobianEvaluations;
    }

    public double getRMS() {
        return FastMath.sqrt(getChiSquare() / ((double) this.rows));
    }

    public RealMatrix getWeightSquareRoot() {
        return this.weightMatrixSqrt.copy();
    }

    @Deprecated
    public double[] guessParametersErrors() {
        int i5 = this.rows;
        int i6 = this.cols;
        if (i5 <= i6) {
            throw new NumberIsTooSmallException(LocalizedFormats.NO_DEGREES_OF_FREEDOM, Integer.valueOf(this.rows), Integer.valueOf(this.cols), false);
        }
        double[] dArr = new double[i6];
        double dSqrt = FastMath.sqrt(getChiSquare() / ((double) (this.rows - this.cols)));
        double[][] dArrComputeCovariances = computeCovariances(this.point, DEFAULT_SINGULARITY_THRESHOLD);
        for (int i7 = 0; i7 < i6; i7++) {
            dArr[i7] = FastMath.sqrt(dArrComputeCovariances[i7][i7]) * dSqrt;
        }
        return dArr;
    }

    @Deprecated
    public PointVectorValuePair optimizeInternal(int i5, MultivariateDifferentiableVectorFunction multivariateDifferentiableVectorFunction, OptimizationData... optimizationDataArr) {
        return super.optimizeInternal(i5, FunctionUtils.toDifferentiableMultivariateVectorFunction(multivariateDifferentiableVectorFunction), optimizationDataArr);
    }

    public void setCost(double d) {
        this.cost = d;
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    public void setUp() {
        super.setUp();
        this.jacobianEvaluations = 0;
        this.weightMatrixSqrt = squareRoot(getWeight());
        this.jF = FunctionUtils.toMultivariateDifferentiableVectorFunction(getObjectiveFunction());
        this.point = getStartPoint();
        this.rows = getTarget().length;
        this.cols = this.point.length;
    }

    @Deprecated
    public void updateJacobian() {
        this.weightedResidualJacobian = computeWeightedJacobian(this.point).scalarMultiply(-1.0d).getData();
    }

    @Deprecated
    public void updateResidualsAndCost() {
        double[] dArrComputeObjectiveValue = computeObjectiveValue(this.point);
        this.objective = dArrComputeObjectiveValue;
        double[] dArrComputeResiduals = computeResiduals(dArrComputeObjectiveValue);
        this.cost = computeCost(dArrComputeResiduals);
        this.weightedResiduals = this.weightMatrixSqrt.operate(new ArrayRealVector(dArrComputeResiduals)).toArray();
    }

    public AbstractLeastSquaresOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        super(convergenceChecker);
    }

    @Deprecated
    public double[][] getCovariances(double d) {
        return computeCovariances(this.point, d);
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer, org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    @Deprecated
    public PointVectorValuePair optimize(int i5, DifferentiableMultivariateVectorFunction differentiableMultivariateVectorFunction, double[] dArr, double[] dArr2, double[] dArr3) {
        return optimizeInternal(i5, FunctionUtils.toMultivariateDifferentiableVectorFunction(differentiableMultivariateVectorFunction), new Target(dArr), new Weight(dArr2), new InitialGuess(dArr3));
    }

    @Deprecated
    public PointVectorValuePair optimize(int i5, MultivariateDifferentiableVectorFunction multivariateDifferentiableVectorFunction, double[] dArr, double[] dArr2, double[] dArr3) {
        return optimizeInternal(i5, multivariateDifferentiableVectorFunction, new Target(dArr), new Weight(dArr2), new InitialGuess(dArr3));
    }
}

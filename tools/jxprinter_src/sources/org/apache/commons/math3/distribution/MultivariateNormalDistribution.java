package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.NonPositiveDefiniteMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultivariateNormalDistribution extends AbstractMultivariateRealDistribution {
    private final RealMatrix covarianceMatrix;
    private final double covarianceMatrixDeterminant;
    private final RealMatrix covarianceMatrixInverse;
    private final double[] means;
    private final RealMatrix samplingMatrix;

    public MultivariateNormalDistribution(double[] dArr, double[][] dArr2) {
        this(new Well19937c(), dArr, dArr2);
    }

    private double getExponentTerm(double[] dArr) {
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr2[i5] = dArr[i5] - getMeans()[i5];
        }
        double[] dArrPreMultiply = this.covarianceMatrixInverse.preMultiply(dArr2);
        double d = 0.0d;
        for (int i6 = 0; i6 < dArrPreMultiply.length; i6++) {
            d += dArrPreMultiply[i6] * dArr2[i6];
        }
        return FastMath.exp(d * (-0.5d));
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double density(double[] dArr) {
        int dimension = getDimension();
        if (dArr.length != dimension) {
            throw new DimensionMismatchException(dArr.length, dimension);
        }
        return FastMath.pow(this.covarianceMatrixDeterminant, -0.5d) * FastMath.pow(6.283185307179586d, ((double) dimension) * (-0.5d)) * getExponentTerm(dArr);
    }

    public RealMatrix getCovariances() {
        return this.covarianceMatrix.copy();
    }

    public double[] getMeans() {
        return MathArrays.copyOf(this.means);
    }

    public double[] getStandardDeviations() {
        int dimension = getDimension();
        double[] dArr = new double[dimension];
        double[][] data = this.covarianceMatrix.getData();
        for (int i5 = 0; i5 < dimension; i5++) {
            dArr[i5] = FastMath.sqrt(data[i5][i5]);
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.distribution.AbstractMultivariateRealDistribution, org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double[] sample() {
        int dimension = getDimension();
        double[] dArr = new double[dimension];
        for (int i5 = 0; i5 < dimension; i5++) {
            dArr[i5] = this.random.nextGaussian();
        }
        double[] dArrOperate = this.samplingMatrix.operate(dArr);
        for (int i6 = 0; i6 < dimension; i6++) {
            dArrOperate[i6] = dArrOperate[i6] + this.means[i6];
        }
        return dArrOperate;
    }

    public MultivariateNormalDistribution(RandomGenerator randomGenerator, double[] dArr, double[][] dArr2) {
        super(randomGenerator, dArr.length);
        int length = dArr.length;
        if (dArr2.length != length) {
            throw new DimensionMismatchException(dArr2.length, length);
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (length != dArr2[i5].length) {
                throw new DimensionMismatchException(dArr2[i5].length, length);
            }
        }
        this.means = MathArrays.copyOf(dArr);
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(dArr2);
        this.covarianceMatrix = array2DRowRealMatrix;
        EigenDecomposition eigenDecomposition = new EigenDecomposition(array2DRowRealMatrix);
        this.covarianceMatrixInverse = eigenDecomposition.getSolver().getInverse();
        this.covarianceMatrixDeterminant = eigenDecomposition.getDeterminant();
        double[] realEigenvalues = eigenDecomposition.getRealEigenvalues();
        for (int i6 = 0; i6 < realEigenvalues.length; i6++) {
            if (realEigenvalues[i6] < 0.0d) {
                throw new NonPositiveDefiniteMatrixException(realEigenvalues[i6], i6, 0.0d);
            }
        }
        Array2DRowRealMatrix array2DRowRealMatrix2 = new Array2DRowRealMatrix(length, length);
        for (int i7 = 0; i7 < length; i7++) {
            array2DRowRealMatrix2.setColumn(i7, eigenDecomposition.getEigenvector(i7).toArray());
        }
        RealMatrix realMatrixTranspose = array2DRowRealMatrix2.transpose();
        for (int i8 = 0; i8 < length; i8++) {
            double dSqrt = FastMath.sqrt(realEigenvalues[i8]);
            for (int i9 = 0; i9 < length; i9++) {
                realMatrixTranspose.multiplyEntry(i8, i9, dSqrt);
            }
        }
        this.samplingMatrix = array2DRowRealMatrix2.multiply(realMatrixTranspose);
    }
}

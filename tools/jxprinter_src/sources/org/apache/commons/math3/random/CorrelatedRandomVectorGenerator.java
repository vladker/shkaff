package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RectangularCholeskyDecomposition;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;
    private final double[] mean;
    private final double[] normalized;
    private final RealMatrix root;

    public CorrelatedRandomVectorGenerator(double[] dArr, RealMatrix realMatrix, double d, NormalizedRandomGenerator normalizedRandomGenerator) {
        int rowDimension = realMatrix.getRowDimension();
        if (dArr.length != rowDimension) {
            throw new DimensionMismatchException(dArr.length, rowDimension);
        }
        this.mean = (double[]) dArr.clone();
        RectangularCholeskyDecomposition rectangularCholeskyDecomposition = new RectangularCholeskyDecomposition(realMatrix, d);
        this.root = rectangularCholeskyDecomposition.getRootMatrix();
        this.generator = normalizedRandomGenerator;
        this.normalized = new double[rectangularCholeskyDecomposition.getRank()];
    }

    public NormalizedRandomGenerator getGenerator() {
        return this.generator;
    }

    public int getRank() {
        return this.normalized.length;
    }

    public RealMatrix getRootMatrix() {
        return this.root;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        int i5 = 0;
        while (true) {
            double[] dArr = this.normalized;
            if (i5 >= dArr.length) {
                break;
            }
            dArr[i5] = this.generator.nextNormalizedDouble();
            i5++;
        }
        int length = this.mean.length;
        double[] dArr2 = new double[length];
        for (int i6 = 0; i6 < length; i6++) {
            dArr2[i6] = this.mean[i6];
            for (int i7 = 0; i7 < this.root.getColumnDimension(); i7++) {
                dArr2[i6] = (this.root.getEntry(i6, i7) * this.normalized[i7]) + dArr2[i6];
            }
        }
        return dArr2;
    }

    public CorrelatedRandomVectorGenerator(RealMatrix realMatrix, double d, NormalizedRandomGenerator normalizedRandomGenerator) {
        int rowDimension = realMatrix.getRowDimension();
        this.mean = new double[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            this.mean[i5] = 0.0d;
        }
        RectangularCholeskyDecomposition rectangularCholeskyDecomposition = new RectangularCholeskyDecomposition(realMatrix, d);
        this.root = rectangularCholeskyDecomposition.getRootMatrix();
        this.generator = normalizedRandomGenerator;
        this.normalized = new double[rectangularCholeskyDecomposition.getRank()];
    }
}

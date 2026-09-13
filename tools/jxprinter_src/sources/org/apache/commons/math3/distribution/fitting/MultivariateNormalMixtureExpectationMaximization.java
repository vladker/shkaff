package org.apache.commons.math3.distribution.fitting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.distribution.MixtureMultivariateNormalDistribution;
import org.apache.commons.math3.distribution.MultivariateNormalDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultivariateNormalMixtureExpectationMaximization {
    private static final int DEFAULT_MAX_ITERATIONS = 1000;
    private static final double DEFAULT_THRESHOLD = 1.0E-5d;
    private final double[][] data;
    private MixtureMultivariateNormalDistribution fittedModel;
    private double logLikelihood = 0.0d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataRow implements Comparable<DataRow> {
        private Double mean;
        private final double[] row;

        public DataRow(double[] dArr) {
            this.row = dArr;
            this.mean = Double.valueOf(0.0d);
            for (double d : dArr) {
                this.mean = Double.valueOf(this.mean.doubleValue() + d);
            }
            this.mean = Double.valueOf(this.mean.doubleValue() / ((double) dArr.length));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DataRow) {
                return MathArrays.equals(this.row, ((DataRow) obj).row);
            }
            return false;
        }

        public double[] getRow() {
            return this.row;
        }

        public int hashCode() {
            return Arrays.hashCode(this.row);
        }

        @Override // java.lang.Comparable
        public int compareTo(DataRow dataRow) {
            return this.mean.compareTo(dataRow.mean);
        }
    }

    public MultivariateNormalMixtureExpectationMaximization(double[][] dArr) {
        if (dArr.length < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(dArr.length));
        }
        this.data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, dArr[0].length);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double[] dArr2 = dArr[i5];
            if (dArr2.length != dArr[0].length) {
                throw new DimensionMismatchException(dArr[i5].length, dArr[0].length);
            }
            if (dArr2.length < 2) {
                throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, Integer.valueOf(dArr[i5].length), 2, true);
            }
            this.data[i5] = MathArrays.copyOf(dArr2, dArr2.length);
        }
    }

    public static MixtureMultivariateNormalDistribution estimate(double[][] dArr, int i5) {
        int i6 = 2;
        if (dArr.length < 2) {
            throw new NotStrictlyPositiveException(Integer.valueOf(dArr.length));
        }
        if (i5 < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
        }
        if (i5 > dArr.length) {
            throw new NumberIsTooLargeException(Integer.valueOf(i5), Integer.valueOf(dArr.length), true);
        }
        int length = dArr.length;
        int i7 = 0;
        int length2 = dArr[0].length;
        DataRow[] dataRowArr = new DataRow[length];
        for (int i8 = 0; i8 < length; i8++) {
            dataRowArr[i8] = new DataRow(dArr[i8]);
        }
        Arrays.sort(dataRowArr);
        double d = 1.0d;
        double d6 = 1.0d / ((double) i5);
        ArrayList arrayList = new ArrayList(i5);
        int i9 = 0;
        while (i9 < i5) {
            int i10 = (i9 * length) / i5;
            i9++;
            int i11 = (i9 * length) / i5;
            int i12 = i11 - i10;
            int i13 = i7;
            int[] iArr = new int[i6];
            iArr[1] = length2;
            iArr[i13] = i12;
            int i14 = i6;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr);
            double[] dArr3 = new double[length2];
            int i15 = i13;
            while (i10 < i11) {
                double d7 = d;
                for (int i16 = i13; i16 < length2; i16++) {
                    double d8 = dataRowArr[i10].getRow()[i16];
                    dArr3[i16] = dArr3[i16] + d8;
                    dArr2[i15][i16] = d8;
                }
                i10++;
                i15++;
                d = d7;
            }
            double d9 = d;
            MathArrays.scaleInPlace(d9 / ((double) i12), dArr3);
            arrayList.add(new Pair(Double.valueOf(d6), new MultivariateNormalDistribution(dArr3, new Covariance(dArr2).getCovarianceMatrix().getData())));
            i7 = i13;
            i6 = i14;
            d = d9;
        }
        return new MixtureMultivariateNormalDistribution(arrayList);
    }

    public void fit(MixtureMultivariateNormalDistribution mixtureMultivariateNormalDistribution, int i5, double d) {
        int i6 = i5;
        char c = 1;
        if (i6 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        if (d < Double.MIN_VALUE) {
            throw new NotStrictlyPositiveException(Double.valueOf(d));
        }
        double[][] dArr = this.data;
        int length = dArr.length;
        int i7 = 0;
        int length2 = dArr[0].length;
        int size = mixtureMultivariateNormalDistribution.getComponents().size();
        int length3 = mixtureMultivariateNormalDistribution.getComponents().get(0).getSecond().getMeans().length;
        if (length3 != length2) {
            throw new DimensionMismatchException(length3, length2);
        }
        this.logLikelihood = Double.NEGATIVE_INFINITY;
        this.fittedModel = new MixtureMultivariateNormalDistribution(mixtureMultivariateNormalDistribution.getComponents());
        int i8 = 0;
        double d6 = 0.0d;
        while (true) {
            int i9 = i8 + 1;
            if (i8 > i6 || FastMath.abs(d6 - this.logLikelihood) <= d) {
                break;
            }
            d6 = this.logLikelihood;
            List<Pair<Double, MultivariateNormalDistribution>> components = this.fittedModel.getComponents();
            double[] dArr2 = new double[size];
            MultivariateNormalDistribution[] multivariateNormalDistributionArr = new MultivariateNormalDistribution[size];
            for (int i10 = i7; i10 < size; i10++) {
                dArr2[i10] = components.get(i10).getFirst().doubleValue();
                multivariateNormalDistributionArr[i10] = components.get(i10).getSecond();
            }
            int[] iArr = new int[2];
            iArr[c] = size;
            iArr[i7] = length;
            char c6 = c;
            Class cls = Double.TYPE;
            double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, iArr);
            int i11 = i7;
            double[] dArr4 = new double[size];
            int[] iArr2 = new int[2];
            iArr2[c6] = length2;
            iArr2[i11] = size;
            double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
            double dLog = 0.0d;
            for (int i12 = i11; i12 < length; i12++) {
                double dDensity = this.fittedModel.density(this.data[i12]);
                dLog = FastMath.log(dDensity) + dLog;
                int i13 = i11;
                while (i13 < size) {
                    int i14 = i13;
                    double[] dArr6 = dArr4;
                    dArr3[i12][i14] = (multivariateNormalDistributionArr[i14].density(this.data[i12]) * dArr2[i13]) / dDensity;
                    dArr6[i14] = dArr6[i14] + dArr3[i12][i14];
                    for (int i15 = i11; i15 < length2; i15++) {
                        double[] dArr7 = dArr5[i14];
                        dArr7[i15] = (dArr3[i12][i14] * this.data[i12][i15]) + dArr7[i15];
                    }
                    i13 = i14 + 1;
                    dArr4 = dArr6;
                }
            }
            double[] dArr8 = dArr4;
            double d7 = length;
            this.logLikelihood = dLog / d7;
            double[] dArr9 = new double[size];
            int[] iArr3 = new int[2];
            iArr3[c6] = length2;
            iArr3[i11] = size;
            double[][] dArr10 = (double[][]) Array.newInstance((Class<?>) cls, iArr3);
            for (int i16 = i11; i16 < size; i16++) {
                dArr9[i16] = dArr8[i16] / d7;
                for (int i17 = i11; i17 < length2; i17++) {
                    dArr10[i16][i17] = dArr5[i16][i17] / dArr8[i16];
                }
            }
            RealMatrix[] realMatrixArr = new RealMatrix[size];
            for (int i18 = i11; i18 < size; i18++) {
                realMatrixArr[i18] = new Array2DRowRealMatrix(length2, length2);
            }
            int i19 = i11;
            while (i19 < length) {
                int i20 = i11;
                while (i20 < size) {
                    Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(MathArrays.ebeSubtract(this.data[i19], dArr10[i20]));
                    RealMatrix[] realMatrixArr2 = realMatrixArr;
                    realMatrixArr2[i20] = realMatrixArr2[i20].add(array2DRowRealMatrix.multiply(array2DRowRealMatrix.transpose()).scalarMultiply(dArr3[i19][i20]));
                    i20++;
                    realMatrixArr = realMatrixArr2;
                    length = length;
                    i19 = i19;
                }
                i19++;
            }
            int i21 = length;
            RealMatrix[] realMatrixArr3 = realMatrixArr;
            int[] iArr4 = new int[3];
            iArr4[2] = length2;
            iArr4[c6] = length2;
            iArr4[i11] = size;
            double[][][] dArr11 = (double[][][]) Array.newInstance((Class<?>) cls, iArr4);
            for (int i22 = i11; i22 < size; i22++) {
                RealMatrix realMatrixScalarMultiply = realMatrixArr3[i22].scalarMultiply(1.0d / dArr8[i22]);
                realMatrixArr3[i22] = realMatrixScalarMultiply;
                dArr11[i22] = realMatrixScalarMultiply.getData();
            }
            this.fittedModel = new MixtureMultivariateNormalDistribution(dArr9, dArr10, dArr11);
            i6 = i5;
            i8 = i9;
            c = c6;
            i7 = i11;
            length = i21;
        }
        if (FastMath.abs(d6 - this.logLikelihood) > d) {
            throw new ConvergenceException();
        }
    }

    public MixtureMultivariateNormalDistribution getFittedModel() {
        return new MixtureMultivariateNormalDistribution(this.fittedModel.getComponents());
    }

    public double getLogLikelihood() {
        return this.logLikelihood;
    }

    public void fit(MixtureMultivariateNormalDistribution mixtureMultivariateNormalDistribution) {
        fit(mixtureMultivariateNormalDistribution, 1000, 1.0E-5d);
    }
}

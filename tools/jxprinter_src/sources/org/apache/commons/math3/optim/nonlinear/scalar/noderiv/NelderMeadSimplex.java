package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import androidx.collection.a;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.PointValuePair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NelderMeadSimplex extends AbstractSimplex {
    private static final double DEFAULT_GAMMA = 0.5d;
    private static final double DEFAULT_KHI = 2.0d;
    private static final double DEFAULT_RHO = 1.0d;
    private static final double DEFAULT_SIGMA = 0.5d;
    private final double gamma;
    private final double khi;
    private final double rho;
    private final double sigma;

    public NelderMeadSimplex(int i5) {
        this(i5, 1.0d);
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.noderiv.AbstractSimplex
    public void iterate(MultivariateFunction multivariateFunction, Comparator<PointValuePair> comparator) {
        int dimension = getDimension();
        PointValuePair point = getPoint(0);
        PointValuePair point2 = getPoint(dimension - 1);
        PointValuePair point3 = getPoint(dimension);
        double[] pointRef = point3.getPointRef();
        double[] dArr = new double[dimension];
        for (int i5 = 0; i5 < dimension; i5++) {
            double[] pointRef2 = getPoint(i5).getPointRef();
            for (int i6 = 0; i6 < dimension; i6++) {
                dArr[i6] = dArr[i6] + pointRef2[i6];
            }
        }
        double d = 1.0d / ((double) dimension);
        for (int i7 = 0; i7 < dimension; i7++) {
            dArr[i7] = dArr[i7] * d;
        }
        double[] dArr2 = new double[dimension];
        for (int i8 = 0; i8 < dimension; i8++) {
            double d6 = dArr[i8];
            dArr2[i8] = a.a(d6, pointRef[i8], this.rho, d6);
        }
        PointValuePair pointValuePair = new PointValuePair(dArr2, multivariateFunction.value(dArr2), false);
        if (comparator.compare(point, pointValuePair) <= 0 && comparator.compare(pointValuePair, point2) < 0) {
            replaceWorstPoint(pointValuePair, comparator);
            return;
        }
        if (comparator.compare(pointValuePair, point) < 0) {
            double[] dArr3 = new double[dimension];
            for (int i9 = 0; i9 < dimension; i9++) {
                double d7 = dArr[i9];
                dArr3[i9] = a.a(dArr2[i9], d7, this.khi, d7);
            }
            PointValuePair pointValuePair2 = new PointValuePair(dArr3, multivariateFunction.value(dArr3), false);
            if (comparator.compare(pointValuePair2, pointValuePair) < 0) {
                replaceWorstPoint(pointValuePair2, comparator);
                return;
            } else {
                replaceWorstPoint(pointValuePair, comparator);
                return;
            }
        }
        if (comparator.compare(pointValuePair, point3) < 0) {
            double[] dArr4 = new double[dimension];
            for (int i10 = 0; i10 < dimension; i10++) {
                double d8 = dArr[i10];
                dArr4[i10] = a.a(dArr2[i10], d8, this.gamma, d8);
            }
            PointValuePair pointValuePair3 = new PointValuePair(dArr4, multivariateFunction.value(dArr4), false);
            if (comparator.compare(pointValuePair3, pointValuePair) <= 0) {
                replaceWorstPoint(pointValuePair3, comparator);
                return;
            }
        } else {
            double[] dArr5 = new double[dimension];
            for (int i11 = 0; i11 < dimension; i11++) {
                double d9 = dArr[i11];
                dArr5[i11] = d9 - ((d9 - pointRef[i11]) * this.gamma);
            }
            PointValuePair pointValuePair4 = new PointValuePair(dArr5, multivariateFunction.value(dArr5), false);
            if (comparator.compare(pointValuePair4, point3) < 0) {
                replaceWorstPoint(pointValuePair4, comparator);
                return;
            }
        }
        double[] pointRef3 = getPoint(0).getPointRef();
        for (int i12 = 1; i12 <= dimension; i12++) {
            double[] point4 = getPoint(i12).getPoint();
            for (int i13 = 0; i13 < dimension; i13++) {
                double d10 = pointRef3[i13];
                point4[i13] = a.a(point4[i13], d10, this.sigma, d10);
            }
            setPoint(i12, new PointValuePair(point4, Double.NaN, false));
        }
        evaluate(multivariateFunction, comparator);
    }

    public NelderMeadSimplex(int i5, double d) {
        this(i5, d, 1.0d, DEFAULT_KHI, 0.5d, 0.5d);
    }

    public NelderMeadSimplex(int i5, double d, double d6, double d7, double d8, double d9) {
        super(i5, d);
        this.rho = d6;
        this.khi = d7;
        this.gamma = d8;
        this.sigma = d9;
    }

    public NelderMeadSimplex(int i5, double d, double d6, double d7, double d8) {
        this(i5, 1.0d, d, d6, d7, d8);
    }

    public NelderMeadSimplex(double[] dArr) {
        this(dArr, 1.0d, DEFAULT_KHI, 0.5d, 0.5d);
    }

    public NelderMeadSimplex(double[] dArr, double d, double d6, double d7, double d8) {
        super(dArr);
        this.rho = d;
        this.khi = d6;
        this.gamma = d7;
        this.sigma = d8;
    }

    public NelderMeadSimplex(double[][] dArr) {
        this(dArr, 1.0d, DEFAULT_KHI, 0.5d, 0.5d);
    }

    public NelderMeadSimplex(double[][] dArr, double d, double d6, double d7, double d8) {
        super(dArr);
        this.rho = d;
        this.khi = d6;
        this.gamma = d7;
        this.sigma = d8;
    }
}

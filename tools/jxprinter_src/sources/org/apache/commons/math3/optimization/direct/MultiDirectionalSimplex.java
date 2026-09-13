package org.apache.commons.math3.optimization.direct;

import androidx.collection.a;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.PointValuePair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class MultiDirectionalSimplex extends AbstractSimplex {
    private static final double DEFAULT_GAMMA = 0.5d;
    private static final double DEFAULT_KHI = 2.0d;
    private final double gamma;
    private final double khi;

    public MultiDirectionalSimplex(int i5) {
        this(i5, 1.0d);
    }

    private PointValuePair evaluateNewSimplex(MultivariateFunction multivariateFunction, PointValuePair[] pointValuePairArr, double d, Comparator<PointValuePair> comparator) {
        double[] pointRef = pointValuePairArr[0].getPointRef();
        setPoint(0, pointValuePairArr[0]);
        int dimension = getDimension();
        for (int i5 = 1; i5 < getSize(); i5++) {
            double[] pointRef2 = pointValuePairArr[i5].getPointRef();
            double[] dArr = new double[dimension];
            for (int i6 = 0; i6 < dimension; i6++) {
                double d6 = pointRef[i6];
                dArr[i6] = a.a(d6, pointRef2[i6], d, d6);
            }
            setPoint(i5, new PointValuePair(dArr, Double.NaN, false));
        }
        evaluate(multivariateFunction, comparator);
        return getPoint(0);
    }

    @Override // org.apache.commons.math3.optimization.direct.AbstractSimplex
    public void iterate(MultivariateFunction multivariateFunction, Comparator<PointValuePair> comparator) {
        PointValuePair[] points = getPoints();
        PointValuePair pointValuePair = points[0];
        PointValuePair pointValuePairEvaluateNewSimplex = evaluateNewSimplex(multivariateFunction, points, 1.0d, comparator);
        if (comparator.compare(pointValuePairEvaluateNewSimplex, pointValuePair) >= 0) {
            evaluateNewSimplex(multivariateFunction, points, this.gamma, comparator);
            return;
        }
        PointValuePair[] points2 = getPoints();
        if (comparator.compare(pointValuePairEvaluateNewSimplex, evaluateNewSimplex(multivariateFunction, points, this.khi, comparator)) <= 0) {
            setPoints(points2);
        }
    }

    public MultiDirectionalSimplex(int i5, double d) {
        this(i5, d, DEFAULT_KHI, DEFAULT_GAMMA);
    }

    public MultiDirectionalSimplex(int i5, double d, double d6) {
        this(i5, 1.0d, d, d6);
    }

    public MultiDirectionalSimplex(int i5, double d, double d6, double d7) {
        super(i5, d);
        this.khi = d6;
        this.gamma = d7;
    }

    public MultiDirectionalSimplex(double[] dArr) {
        this(dArr, DEFAULT_KHI, DEFAULT_GAMMA);
    }

    public MultiDirectionalSimplex(double[] dArr, double d, double d6) {
        super(dArr);
        this.khi = d;
        this.gamma = d6;
    }

    public MultiDirectionalSimplex(double[][] dArr) {
        this(dArr, DEFAULT_KHI, DEFAULT_GAMMA);
    }

    public MultiDirectionalSimplex(double[][] dArr, double d, double d6) {
        super(dArr);
        this.khi = d;
        this.gamma = d6;
    }
}

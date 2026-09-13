package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GaussIntegrator {
    private final double[] points;
    private final double[] weights;

    public GaussIntegrator(double[] dArr, double[] dArr2) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        MathArrays.checkOrder(dArr, MathArrays.OrderDirection.INCREASING, true, true);
        this.points = (double[]) dArr.clone();
        this.weights = (double[]) dArr2.clone();
    }

    public int getNumberOfPoints() {
        return this.points.length;
    }

    public double getPoint(int i5) {
        return this.points[i5];
    }

    public double getWeight(int i5) {
        return this.weights[i5];
    }

    public double integrate(UnivariateFunction univariateFunction) {
        double d = 0.0d;
        int i5 = 0;
        double d6 = 0.0d;
        while (true) {
            double[] dArr = this.points;
            if (i5 >= dArr.length) {
                return d;
            }
            double dValue = (univariateFunction.value(dArr[i5]) * this.weights[i5]) - d6;
            double d7 = d + dValue;
            i5++;
            d6 = (d7 - d) - dValue;
            d = d7;
        }
    }

    public GaussIntegrator(Pair<double[], double[]> pair) {
        this(pair.getFirst(), pair.getSecond());
    }
}

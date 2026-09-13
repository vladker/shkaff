package org.apache.commons.math3.analysis.integration.gauss;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SymmetricGaussIntegrator extends GaussIntegrator {
    public SymmetricGaussIntegrator(double[] dArr, double[] dArr2) {
        super(dArr, dArr2);
    }

    @Override // org.apache.commons.math3.analysis.integration.gauss.GaussIntegrator
    public double integrate(UnivariateFunction univariateFunction) {
        int numberOfPoints = getNumberOfPoints();
        int i5 = 0;
        if (numberOfPoints == 1) {
            return univariateFunction.value(0.0d) * getWeight(0);
        }
        int i6 = numberOfPoints / 2;
        double d = 0.0d;
        double d6 = 0.0d;
        while (i5 < i6) {
            double point = getPoint(i5);
            double dValue = ((univariateFunction.value(-point) + univariateFunction.value(point)) * getWeight(i5)) - d;
            double d7 = d6 + dValue;
            double d8 = (d7 - d6) - dValue;
            i5++;
            d6 = d7;
            d = d8;
        }
        if (numberOfPoints % 2 == 0) {
            return d6;
        }
        return ((univariateFunction.value(0.0d) * getWeight(i6)) - d) + d6;
    }

    public SymmetricGaussIntegrator(Pair<double[], double[]> pair) {
        this(pair.getFirst(), pair.getSecond());
    }
}

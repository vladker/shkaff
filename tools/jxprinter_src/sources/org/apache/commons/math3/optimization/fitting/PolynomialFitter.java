package org.apache.commons.math3.optimization.fitting;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class PolynomialFitter extends CurveFitter<PolynomialFunction.Parametric> {

    @Deprecated
    private final int degree;

    @Deprecated
    public PolynomialFitter(int i5, DifferentiableMultivariateVectorOptimizer differentiableMultivariateVectorOptimizer) {
        super(differentiableMultivariateVectorOptimizer);
        this.degree = i5;
    }

    @Deprecated
    public double[] fit() {
        return fit(new PolynomialFunction.Parametric(), new double[this.degree + 1]);
    }

    public double[] fit(int i5, double[] dArr) {
        return fit(i5, new PolynomialFunction.Parametric(), dArr);
    }

    public PolynomialFitter(DifferentiableMultivariateVectorOptimizer differentiableMultivariateVectorOptimizer) {
        super(differentiableMultivariateVectorOptimizer);
        this.degree = -1;
    }

    public double[] fit(double[] dArr) {
        return fit(new PolynomialFunction.Parametric(), dArr);
    }
}

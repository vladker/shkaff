package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPolynomialSolver extends BaseAbstractUnivariateSolver<PolynomialFunction> implements PolynomialSolver {
    private PolynomialFunction polynomialFunction;

    public AbstractPolynomialSolver(double d) {
        super(d);
    }

    public double[] getCoefficients() {
        return this.polynomialFunction.getCoefficients();
    }

    public AbstractPolynomialSolver(double d, double d6) {
        super(d, d6);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public void setup(int i5, PolynomialFunction polynomialFunction, double d, double d6, double d7) {
        super.setup(i5, polynomialFunction, d, d6, d7);
        this.polynomialFunction = polynomialFunction;
    }

    public AbstractPolynomialSolver(double d, double d6, double d7) {
        super(d, d6, d7);
    }
}

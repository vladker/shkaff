package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractUnivariateSolver extends BaseAbstractUnivariateSolver<UnivariateFunction> implements UnivariateSolver {
    public AbstractUnivariateSolver(double d) {
        super(d);
    }

    public AbstractUnivariateSolver(double d, double d6) {
        super(d, d6);
    }

    public AbstractUnivariateSolver(double d, double d6, double d7) {
        super(d, d6, d7);
    }
}

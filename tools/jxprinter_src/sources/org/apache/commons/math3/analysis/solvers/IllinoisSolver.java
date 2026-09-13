package org.apache.commons.math3.analysis.solvers;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IllinoisSolver extends BaseSecantSolver {
    public IllinoisSolver() {
        super(1.0E-6d, BaseSecantSolver.Method.ILLINOIS);
    }

    public IllinoisSolver(double d) {
        super(d, BaseSecantSolver.Method.ILLINOIS);
    }

    public IllinoisSolver(double d, double d6) {
        super(d, d6, BaseSecantSolver.Method.ILLINOIS);
    }

    public IllinoisSolver(double d, double d6, double d7) {
        super(d, d6, d7, BaseSecantSolver.Method.PEGASUS);
    }
}

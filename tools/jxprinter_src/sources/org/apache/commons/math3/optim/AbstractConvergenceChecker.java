package org.apache.commons.math3.optim;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractConvergenceChecker<PAIR> implements ConvergenceChecker<PAIR> {
    private final double absoluteThreshold;
    private final double relativeThreshold;

    public AbstractConvergenceChecker(double d, double d6) {
        this.relativeThreshold = d;
        this.absoluteThreshold = d6;
    }

    @Override // org.apache.commons.math3.optim.ConvergenceChecker
    public abstract boolean converged(int i5, PAIR pair, PAIR pair2);

    public double getAbsoluteThreshold() {
        return this.absoluteThreshold;
    }

    public double getRelativeThreshold() {
        return this.relativeThreshold;
    }
}

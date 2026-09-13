package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EvaluationRmsChecker implements ConvergenceChecker<LeastSquaresProblem.Evaluation> {
    private final double absTol;
    private final double relTol;

    public EvaluationRmsChecker(double d) {
        this(d, d);
    }

    public EvaluationRmsChecker(double d, double d6) {
        this.relTol = d;
        this.absTol = d6;
    }

    @Override // org.apache.commons.math3.optim.ConvergenceChecker
    public boolean converged(int i5, LeastSquaresProblem.Evaluation evaluation, LeastSquaresProblem.Evaluation evaluation2) {
        double rms = evaluation.getRMS();
        double rms2 = evaluation2.getRMS();
        return Precision.equals(rms, rms2, this.absTol) || Precision.equalsWithRelativeTolerance(rms, rms2, this.relTol);
    }
}

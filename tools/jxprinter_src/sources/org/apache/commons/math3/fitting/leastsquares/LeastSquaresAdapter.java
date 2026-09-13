package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LeastSquaresAdapter implements LeastSquaresProblem {
    private final LeastSquaresProblem problem;

    public LeastSquaresAdapter(LeastSquaresProblem leastSquaresProblem) {
        this.problem = leastSquaresProblem;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
    public LeastSquaresProblem.Evaluation evaluate(RealVector realVector) {
        return this.problem.evaluate(realVector);
    }

    @Override // org.apache.commons.math3.optim.OptimizationProblem
    public ConvergenceChecker<LeastSquaresProblem.Evaluation> getConvergenceChecker() {
        return this.problem.getConvergenceChecker();
    }

    @Override // org.apache.commons.math3.optim.OptimizationProblem
    public Incrementor getEvaluationCounter() {
        return this.problem.getEvaluationCounter();
    }

    @Override // org.apache.commons.math3.optim.OptimizationProblem
    public Incrementor getIterationCounter() {
        return this.problem.getIterationCounter();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
    public int getObservationSize() {
        return this.problem.getObservationSize();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
    public int getParameterSize() {
        return this.problem.getParameterSize();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem
    public RealVector getStart() {
        return this.problem.getStart();
    }
}

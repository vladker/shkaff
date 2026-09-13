package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseOptimizer<PAIR> {
    private final ConvergenceChecker<PAIR> checker;
    protected final Incrementor evaluations;
    protected final Incrementor iterations;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MaxEvalCallback implements Incrementor.MaxCountExceededCallback {
        private MaxEvalCallback() {
        }

        @Override // org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback
        public void trigger(int i5) {
            throw new TooManyEvaluationsException(Integer.valueOf(i5));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MaxIterCallback implements Incrementor.MaxCountExceededCallback {
        private MaxIterCallback() {
        }

        @Override // org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback
        public void trigger(int i5) {
            throw new TooManyIterationsException(Integer.valueOf(i5));
        }
    }

    public BaseOptimizer(ConvergenceChecker<PAIR> convergenceChecker) {
        this(convergenceChecker, 0, Integer.MAX_VALUE);
    }

    public abstract PAIR doOptimize();

    public ConvergenceChecker<PAIR> getConvergenceChecker() {
        return this.checker;
    }

    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public int getIterations() {
        return this.iterations.getCount();
    }

    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public int getMaxIterations() {
        return this.iterations.getMaximalCount();
    }

    public void incrementEvaluationCount() {
        this.evaluations.incrementCount();
    }

    public void incrementIterationCount() {
        this.iterations.incrementCount();
    }

    public PAIR optimize(OptimizationData... optimizationDataArr) {
        parseOptimizationData(optimizationDataArr);
        this.evaluations.resetCount();
        this.iterations.resetCount();
        return doOptimize();
    }

    public void parseOptimizationData(OptimizationData... optimizationDataArr) {
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof MaxEval) {
                this.evaluations.setMaximalCount(((MaxEval) optimizationData).getMaxEval());
            } else if (optimizationData instanceof MaxIter) {
                this.iterations.setMaximalCount(((MaxIter) optimizationData).getMaxIter());
            }
        }
    }

    public BaseOptimizer(ConvergenceChecker<PAIR> convergenceChecker, int i5, int i6) {
        this.checker = convergenceChecker;
        this.evaluations = new Incrementor(i5, new MaxEvalCallback());
        this.iterations = new Incrementor(i6, new MaxIterCallback());
    }

    public PAIR optimize() {
        this.evaluations.resetCount();
        this.iterations.resetCount();
        return doOptimize();
    }
}

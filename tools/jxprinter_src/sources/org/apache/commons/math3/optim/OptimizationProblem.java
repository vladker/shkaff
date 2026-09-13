package org.apache.commons.math3.optim;

import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface OptimizationProblem<PAIR> {
    ConvergenceChecker<PAIR> getConvergenceChecker();

    Incrementor getEvaluationCounter();

    Incrementor getIterationCounter();
}

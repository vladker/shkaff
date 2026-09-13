package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.univariate.BracketFinder;
import org.apache.commons.math3.optim.univariate.BrentOptimizer;
import org.apache.commons.math3.optim.univariate.SearchInterval;
import org.apache.commons.math3.optim.univariate.SimpleUnivariateValueChecker;
import org.apache.commons.math3.optim.univariate.UnivariateObjectiveFunction;
import org.apache.commons.math3.optim.univariate.UnivariateOptimizer;
import org.apache.commons.math3.optim.univariate.UnivariatePointValuePair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LineSearch {
    private static final double ABS_TOL_UNUSED = Double.MIN_VALUE;
    private static final double REL_TOL_UNUSED = 1.0E-15d;
    private final BracketFinder bracket = new BracketFinder();
    private final double initialBracketingRange;
    private final UnivariateOptimizer lineOptimizer;
    private final MultivariateOptimizer mainOptimizer;

    public LineSearch(MultivariateOptimizer multivariateOptimizer, double d, double d6, double d7) {
        this.mainOptimizer = multivariateOptimizer;
        this.lineOptimizer = new BrentOptimizer(1.0E-15d, ABS_TOL_UNUSED, new SimpleUnivariateValueChecker(d, d6));
        this.initialBracketingRange = d7;
    }

    public UnivariatePointValuePair search(final double[] dArr, final double[] dArr2) {
        final int length = dArr.length;
        UnivariateFunction univariateFunction = new UnivariateFunction() { // from class: org.apache.commons.math3.optim.nonlinear.scalar.LineSearch.1
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                double[] dArr3 = new double[length];
                for (int i5 = 0; i5 < length; i5++) {
                    dArr3[i5] = (dArr2[i5] * d) + dArr[i5];
                }
                return LineSearch.this.mainOptimizer.computeObjectiveValue(dArr3);
            }
        };
        GoalType goalType = this.mainOptimizer.getGoalType();
        this.bracket.search(univariateFunction, goalType, 0.0d, this.initialBracketingRange);
        return this.lineOptimizer.optimize(new MaxEval(Integer.MAX_VALUE), new UnivariateObjectiveFunction(univariateFunction), goalType, new SearchInterval(this.bracket.getLo(), this.bracket.getHi(), this.bracket.getMid()));
    }
}

package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.BaseMultivariateOptimizer;
import org.apache.commons.math3.optimization.BaseMultivariateSimpleBoundsOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.optimization.SimpleBounds;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class BaseAbstractMultivariateSimpleBoundsOptimizer<FUNC extends MultivariateFunction> extends BaseAbstractMultivariateOptimizer<FUNC> implements BaseMultivariateOptimizer<FUNC>, BaseMultivariateSimpleBoundsOptimizer<FUNC> {
    @Deprecated
    public BaseAbstractMultivariateSimpleBoundsOptimizer() {
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer, org.apache.commons.math3.optimization.BaseMultivariateOptimizer
    public PointValuePair optimize(int i5, FUNC func, GoalType goalType, double[] dArr) {
        return super.optimizeInternal(i5, func, goalType, new InitialGuess(dArr));
    }

    public BaseAbstractMultivariateSimpleBoundsOptimizer(ConvergenceChecker<PointValuePair> convergenceChecker) {
        super(convergenceChecker);
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateSimpleBoundsOptimizer
    public PointValuePair optimize(int i5, FUNC func, GoalType goalType, double[] dArr, double[] dArr2, double[] dArr3) {
        return super.optimizeInternal(i5, func, goalType, new InitialGuess(dArr), new SimpleBounds(dArr2, dArr3));
    }
}

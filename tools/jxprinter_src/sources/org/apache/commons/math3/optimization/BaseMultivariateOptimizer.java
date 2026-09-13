package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface BaseMultivariateOptimizer<FUNC extends MultivariateFunction> extends BaseOptimizer<PointValuePair> {
    @Deprecated
    PointValuePair optimize(int i5, FUNC func, GoalType goalType, double[] dArr);
}

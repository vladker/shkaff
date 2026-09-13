package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.MultivariateFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface BaseMultivariateSimpleBoundsOptimizer<FUNC extends MultivariateFunction> extends BaseMultivariateOptimizer<FUNC> {
    PointValuePair optimize(int i5, FUNC func, GoalType goalType, double[] dArr, double[] dArr2, double[] dArr3);
}

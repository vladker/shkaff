package org.apache.commons.math3.optimization;

import org.apache.commons.math3.analysis.DifferentiableMultivariateFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class DifferentiableMultivariateMultiStartOptimizer extends BaseMultivariateMultiStartOptimizer<DifferentiableMultivariateFunction> implements DifferentiableMultivariateOptimizer {
    public DifferentiableMultivariateMultiStartOptimizer(DifferentiableMultivariateOptimizer differentiableMultivariateOptimizer, int i5, RandomVectorGenerator randomVectorGenerator) {
        super(differentiableMultivariateOptimizer, i5, randomVectorGenerator);
    }
}

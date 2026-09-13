package org.apache.commons.math3.optimization;

import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BaseMultivariateMultiStartOptimizer<FUNC extends MultivariateFunction> implements BaseMultivariateOptimizer<FUNC> {
    private RandomVectorGenerator generator;
    private int maxEvaluations;
    private PointValuePair[] optima;
    private final BaseMultivariateOptimizer<FUNC> optimizer;
    private int starts;
    private int totalEvaluations;

    public BaseMultivariateMultiStartOptimizer(BaseMultivariateOptimizer<FUNC> baseMultivariateOptimizer, int i5, RandomVectorGenerator randomVectorGenerator) {
        if (baseMultivariateOptimizer == null || randomVectorGenerator == null) {
            throw new NullArgumentException();
        }
        if (i5 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.optimizer = baseMultivariateOptimizer;
        this.starts = i5;
        this.generator = randomVectorGenerator;
    }

    private void sortPairs(final GoalType goalType) {
        Arrays.sort(this.optima, new Comparator<PointValuePair>() { // from class: org.apache.commons.math3.optimization.BaseMultivariateMultiStartOptimizer.1
            @Override // java.util.Comparator
            public int compare(PointValuePair pointValuePair, PointValuePair pointValuePair2) {
                if (pointValuePair == null) {
                    return pointValuePair2 == null ? 0 : 1;
                }
                if (pointValuePair2 == null) {
                    return -1;
                }
                double dDoubleValue = pointValuePair.getValue().doubleValue();
                double dDoubleValue2 = pointValuePair2.getValue().doubleValue();
                return goalType == GoalType.MINIMIZE ? Double.compare(dDoubleValue, dDoubleValue2) : Double.compare(dDoubleValue2, dDoubleValue);
            }
        });
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<PointValuePair> getConvergenceChecker() {
        return this.optimizer.getConvergenceChecker();
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public int getMaxEvaluations() {
        return this.maxEvaluations;
    }

    public PointValuePair[] getOptima() {
        PointValuePair[] pointValuePairArr = this.optima;
        if (pointValuePairArr != null) {
            return (PointValuePair[]) pointValuePairArr.clone();
        }
        throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateOptimizer
    public PointValuePair optimize(int i5, FUNC func, GoalType goalType, double[] dArr) {
        this.maxEvaluations = i5;
        this.optima = new PointValuePair[this.starts];
        this.totalEvaluations = 0;
        int i6 = 0;
        RuntimeException e = null;
        while (i6 < this.starts) {
            try {
                this.optima[i6] = this.optimizer.optimize(i5 - this.totalEvaluations, func, goalType, i6 == 0 ? dArr : this.generator.nextVector());
            } catch (RuntimeException e6) {
                e = e6;
                this.optima[i6] = null;
            }
            this.totalEvaluations = this.optimizer.getEvaluations() + this.totalEvaluations;
            i6++;
        }
        sortPairs(goalType);
        PointValuePair pointValuePair = this.optima[0];
        if (pointValuePair != null) {
            return pointValuePair;
        }
        throw e;
    }
}

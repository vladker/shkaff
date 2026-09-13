package org.apache.commons.math3.optim.univariate;

import androidx.collection.a;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiStartUnivariateOptimizer extends UnivariateOptimizer {
    private RandomGenerator generator;
    private int maxEvalIndex;
    private OptimizationData[] optimData;
    private UnivariatePointValuePair[] optima;
    private final UnivariateOptimizer optimizer;
    private int searchIntervalIndex;
    private int starts;
    private int totalEvaluations;

    public MultiStartUnivariateOptimizer(UnivariateOptimizer univariateOptimizer, int i5, RandomGenerator randomGenerator) {
        super(univariateOptimizer.getConvergenceChecker());
        this.maxEvalIndex = -1;
        this.searchIntervalIndex = -1;
        if (i5 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.optimizer = univariateOptimizer;
        this.starts = i5;
        this.generator = randomGenerator;
    }

    private void sortPairs(final GoalType goalType) {
        Arrays.sort(this.optima, new Comparator<UnivariatePointValuePair>() { // from class: org.apache.commons.math3.optim.univariate.MultiStartUnivariateOptimizer.1
            @Override // java.util.Comparator
            public int compare(UnivariatePointValuePair univariatePointValuePair, UnivariatePointValuePair univariatePointValuePair2) {
                if (univariatePointValuePair == null) {
                    return univariatePointValuePair2 == null ? 0 : 1;
                }
                if (univariatePointValuePair2 == null) {
                    return -1;
                }
                double value = univariatePointValuePair.getValue();
                double value2 = univariatePointValuePair2.getValue();
                return goalType == GoalType.MINIMIZE ? Double.compare(value, value2) : Double.compare(value2, value);
            }
        });
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public int getEvaluations() {
        return this.totalEvaluations;
    }

    public UnivariatePointValuePair[] getOptima() {
        UnivariatePointValuePair[] univariatePointValuePairArr = this.optima;
        if (univariatePointValuePairArr != null) {
            return (UnivariatePointValuePair[]) univariatePointValuePairArr.clone();
        }
        throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public UnivariatePointValuePair doOptimize() {
        double d;
        double d6;
        double dA;
        int i5 = 0;
        while (true) {
            OptimizationData[] optimizationDataArr = this.optimData;
            if (i5 >= optimizationDataArr.length) {
                break;
            }
            OptimizationData optimizationData = optimizationDataArr[i5];
            if (optimizationData instanceof MaxEval) {
                optimizationDataArr[i5] = null;
                this.maxEvalIndex = i5;
            } else if (optimizationData instanceof SearchInterval) {
                optimizationDataArr[i5] = null;
                this.searchIntervalIndex = i5;
            }
            i5++;
        }
        if (this.maxEvalIndex == -1) {
            throw new MathIllegalStateException();
        }
        if (this.searchIntervalIndex == -1) {
            throw new MathIllegalStateException();
        }
        this.optima = new UnivariatePointValuePair[this.starts];
        this.totalEvaluations = 0;
        int maxEvaluations = getMaxEvaluations();
        double min = getMin();
        double max = getMax();
        double startValue = getStartValue();
        int i6 = 0;
        RuntimeException e = null;
        while (i6 < this.starts) {
            try {
                this.optimData[this.maxEvalIndex] = new MaxEval(maxEvaluations - this.totalEvaluations);
                if (i6 == 0) {
                    d = min;
                    d6 = max;
                    dA = startValue;
                } else {
                    d = min;
                    d6 = max;
                    dA = a.a(d6, d, this.generator.nextDouble(), d);
                }
                try {
                    double d7 = d;
                    double d8 = d6;
                    d = d7;
                    d6 = d8;
                    this.optimData[this.searchIntervalIndex] = new SearchInterval(d7, d8, dA);
                    this.optima[i6] = this.optimizer.optimize(this.optimData);
                } catch (RuntimeException e6) {
                    e = e6;
                    this.optima[i6] = null;
                }
            } catch (RuntimeException e7) {
                e = e7;
                d = min;
                d6 = max;
            }
            this.totalEvaluations = this.optimizer.getEvaluations() + this.totalEvaluations;
            i6++;
            max = d6;
            min = d;
        }
        sortPairs(getGoalType());
        UnivariatePointValuePair univariatePointValuePair = this.optima[0];
        if (univariatePointValuePair != null) {
            return univariatePointValuePair;
        }
        throw e;
    }

    @Override // org.apache.commons.math3.optim.univariate.UnivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public UnivariatePointValuePair optimize(OptimizationData... optimizationDataArr) {
        this.optimData = optimizationDataArr;
        return super.optimize(optimizationDataArr);
    }
}

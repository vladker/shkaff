package org.apache.commons.math3.optimization.univariate;

import androidx.collection.a;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class UnivariateMultiStartOptimizer<FUNC extends UnivariateFunction> implements BaseUnivariateOptimizer<FUNC> {
    private RandomGenerator generator;
    private int maxEvaluations;
    private UnivariatePointValuePair[] optima;
    private final BaseUnivariateOptimizer<FUNC> optimizer;
    private int starts;
    private int totalEvaluations;

    public UnivariateMultiStartOptimizer(BaseUnivariateOptimizer<FUNC> baseUnivariateOptimizer, int i5, RandomGenerator randomGenerator) {
        if (baseUnivariateOptimizer == null || randomGenerator == null) {
            throw new NullArgumentException();
        }
        if (i5 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.optimizer = baseUnivariateOptimizer;
        this.starts = i5;
        this.generator = randomGenerator;
    }

    private void sortPairs(final GoalType goalType) {
        Arrays.sort(this.optima, new Comparator<UnivariatePointValuePair>() { // from class: org.apache.commons.math3.optimization.univariate.UnivariateMultiStartOptimizer.1
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

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<UnivariatePointValuePair> getConvergenceChecker() {
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

    public UnivariatePointValuePair[] getOptima() {
        UnivariatePointValuePair[] univariatePointValuePairArr = this.optima;
        if (univariatePointValuePairArr != null) {
            return (UnivariatePointValuePair[]) univariatePointValuePairArr.clone();
        }
        throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math3.optimization.univariate.BaseUnivariateOptimizer
    public UnivariatePointValuePair optimize(int i5, FUNC func, GoalType goalType, double d, double d6) {
        return optimize(i5, func, goalType, d, d6, a.a(d6, d, 0.5d, d));
    }

    @Override // org.apache.commons.math3.optimization.univariate.BaseUnivariateOptimizer
    public UnivariatePointValuePair optimize(int i5, FUNC func, GoalType goalType, double d, double d6, double d7) {
        this.optima = new UnivariatePointValuePair[this.starts];
        this.totalEvaluations = 0;
        int i6 = 0;
        RuntimeException e = null;
        while (i6 < this.starts) {
            try {
                this.optima[i6] = this.optimizer.optimize(i5 - this.totalEvaluations, func, goalType, d, d6, i6 == 0 ? d7 : a.a(d6, d, this.generator.nextDouble(), d));
            } catch (RuntimeException e6) {
                e = e6;
                this.optima[i6] = null;
            }
            this.totalEvaluations = this.optimizer.getEvaluations() + this.totalEvaluations;
            i6++;
        }
        sortPairs(goalType);
        UnivariatePointValuePair univariatePointValuePair = this.optima[0];
        if (univariatePointValuePair != null) {
            return univariatePointValuePair;
        }
        throw e;
    }
}

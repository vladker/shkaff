package org.apache.commons.math3.optimization;

import androidx.collection.a;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BaseMultivariateVectorMultiStartOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    private RandomVectorGenerator generator;
    private int maxEvaluations;
    private PointVectorValuePair[] optima;
    private final BaseMultivariateVectorOptimizer<FUNC> optimizer;
    private int starts;
    private int totalEvaluations;

    public BaseMultivariateVectorMultiStartOptimizer(BaseMultivariateVectorOptimizer<FUNC> baseMultivariateVectorOptimizer, int i5, RandomVectorGenerator randomVectorGenerator) {
        if (baseMultivariateVectorOptimizer == null || randomVectorGenerator == null) {
            throw new NullArgumentException();
        }
        if (i5 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.optimizer = baseMultivariateVectorOptimizer;
        this.starts = i5;
        this.generator = randomVectorGenerator;
    }

    private void sortPairs(final double[] dArr, final double[] dArr2) {
        Arrays.sort(this.optima, new Comparator<PointVectorValuePair>() { // from class: org.apache.commons.math3.optimization.BaseMultivariateVectorMultiStartOptimizer.1
            private double weightedResidual(PointVectorValuePair pointVectorValuePair) {
                double[] valueRef = pointVectorValuePair.getValueRef();
                double dC = 0.0d;
                for (int i5 = 0; i5 < valueRef.length; i5++) {
                    double d = valueRef[i5] - dArr[i5];
                    dC = a.C(dArr2[i5], d, d, dC);
                }
                return dC;
            }

            @Override // java.util.Comparator
            public int compare(PointVectorValuePair pointVectorValuePair, PointVectorValuePair pointVectorValuePair2) {
                if (pointVectorValuePair == null) {
                    return pointVectorValuePair2 == null ? 0 : 1;
                }
                if (pointVectorValuePair2 == null) {
                    return -1;
                }
                return Double.compare(weightedResidual(pointVectorValuePair), weightedResidual(pointVectorValuePair2));
            }
        });
    }

    @Override // org.apache.commons.math3.optimization.BaseOptimizer
    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
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

    public PointVectorValuePair[] getOptima() {
        PointVectorValuePair[] pointVectorValuePairArr = this.optima;
        if (pointVectorValuePairArr != null) {
            return (PointVectorValuePair[]) pointVectorValuePairArr.clone();
        }
        throw new MathIllegalStateException(LocalizedFormats.NO_OPTIMUM_COMPUTED_YET, new Object[0]);
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    public PointVectorValuePair optimize(int i5, FUNC func, double[] dArr, double[] dArr2, double[] dArr3) {
        this.maxEvaluations = i5;
        this.optima = new PointVectorValuePair[this.starts];
        this.totalEvaluations = 0;
        int i6 = 0;
        RuntimeException e = null;
        while (i6 < this.starts) {
            try {
                this.optima[i6] = this.optimizer.optimize(i5 - this.totalEvaluations, func, dArr, dArr2, i6 == 0 ? dArr3 : this.generator.nextVector());
            } catch (ConvergenceException unused) {
                this.optima[i6] = null;
            } catch (RuntimeException e6) {
                e = e6;
                this.optima[i6] = null;
            }
            this.totalEvaluations = this.optimizer.getEvaluations() + this.totalEvaluations;
            i6++;
        }
        sortPairs(dArr, dArr2);
        PointVectorValuePair pointVectorValuePair = this.optima[0];
        if (pointVectorValuePair != null) {
            return pointVectorValuePair;
        }
        throw e;
    }
}

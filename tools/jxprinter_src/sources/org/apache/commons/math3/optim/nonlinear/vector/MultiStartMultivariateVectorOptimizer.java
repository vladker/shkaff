package org.apache.commons.math3.optim.nonlinear.vector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.random.RandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class MultiStartMultivariateVectorOptimizer extends BaseMultiStartMultivariateOptimizer<PointVectorValuePair> {
    private final List<PointVectorValuePair> optima;
    private final MultivariateVectorOptimizer optimizer;

    public MultiStartMultivariateVectorOptimizer(MultivariateVectorOptimizer multivariateVectorOptimizer, int i5, RandomVectorGenerator randomVectorGenerator) {
        super(multivariateVectorOptimizer, i5, randomVectorGenerator);
        this.optima = new ArrayList();
        this.optimizer = multivariateVectorOptimizer;
    }

    private Comparator<PointVectorValuePair> getPairComparator() {
        return new Comparator<PointVectorValuePair>() { // from class: org.apache.commons.math3.optim.nonlinear.vector.MultiStartMultivariateVectorOptimizer.1
            private final RealVector target;
            private final RealMatrix weight;

            {
                this.target = new ArrayRealVector(MultiStartMultivariateVectorOptimizer.this.optimizer.getTarget(), false);
                this.weight = MultiStartMultivariateVectorOptimizer.this.optimizer.getWeight();
            }

            private double weightedResidual(PointVectorValuePair pointVectorValuePair) {
                RealVector realVectorSubtract = this.target.subtract(new ArrayRealVector(pointVectorValuePair.getValueRef(), false));
                return realVectorSubtract.dotProduct(this.weight.operate(realVectorSubtract));
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
        };
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    public void clear() {
        this.optima.clear();
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    public PointVectorValuePair[] getOptima() {
        Collections.sort(this.optima, getPairComparator());
        return (PointVectorValuePair[]) this.optima.toArray(new PointVectorValuePair[0]);
    }

    @Override // org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer
    public void store(PointVectorValuePair pointVectorValuePair) {
        this.optima.add(pointVectorValuePair);
    }
}

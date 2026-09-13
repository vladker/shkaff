package org.apache.commons.math3.distribution;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.MultivariateRealDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MixtureMultivariateRealDistribution<T extends MultivariateRealDistribution> extends AbstractMultivariateRealDistribution {
    private final List<T> distribution;
    private final double[] weight;

    public MixtureMultivariateRealDistribution(List<Pair<Double, T>> list) {
        this(new Well19937c(), list);
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double density(double[] dArr) {
        double dDensity = 0.0d;
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.weight;
            if (i5 >= dArr2.length) {
                return dDensity;
            }
            dDensity += this.distribution.get(i5).density(dArr) * dArr2[i5];
            i5++;
        }
    }

    public List<Pair<Double, T>> getComponents() {
        ArrayList arrayList = new ArrayList(this.weight.length);
        int i5 = 0;
        while (true) {
            double[] dArr = this.weight;
            if (i5 >= dArr.length) {
                return arrayList;
            }
            arrayList.add(new Pair(Double.valueOf(dArr[i5]), this.distribution.get(i5)));
            i5++;
        }
    }

    @Override // org.apache.commons.math3.distribution.AbstractMultivariateRealDistribution, org.apache.commons.math3.distribution.MultivariateRealDistribution
    public void reseedRandomGenerator(long j6) {
        super.reseedRandomGenerator(j6);
        int i5 = 0;
        while (i5 < this.distribution.size()) {
            T t6 = this.distribution.get(i5);
            i5++;
            t6.reseedRandomGenerator(((long) i5) + j6);
        }
    }

    @Override // org.apache.commons.math3.distribution.AbstractMultivariateRealDistribution, org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double[] sample() {
        double[] dArrSample;
        double dNextDouble = this.random.nextDouble();
        double d = 0.0d;
        int i5 = 0;
        while (true) {
            double[] dArr = this.weight;
            if (i5 >= dArr.length) {
                dArrSample = null;
                break;
            }
            d += dArr[i5];
            if (dNextDouble <= d) {
                dArrSample = this.distribution.get(i5).sample();
                break;
            }
            i5++;
        }
        return dArrSample == null ? this.distribution.get(this.weight.length - 1).sample() : dArrSample;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MixtureMultivariateRealDistribution(RandomGenerator randomGenerator, List<Pair<Double, T>> list) {
        super(randomGenerator, list.get(0).getSecond().getDimension());
        int size = list.size();
        int dimension = getDimension();
        double dDoubleValue = 0.0d;
        for (int i5 = 0; i5 < size; i5++) {
            Pair<Double, T> pair = list.get(i5);
            if (pair.getSecond().getDimension() != dimension) {
                throw new DimensionMismatchException(pair.getSecond().getDimension(), dimension);
            }
            if (pair.getFirst().doubleValue() < 0.0d) {
                throw new NotPositiveException(pair.getFirst());
            }
            dDoubleValue += pair.getFirst().doubleValue();
        }
        if (Double.isInfinite(dDoubleValue)) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
        }
        this.distribution = new ArrayList();
        this.weight = new double[size];
        for (int i6 = 0; i6 < size; i6++) {
            Pair<Double, T> pair2 = list.get(i6);
            this.weight[i6] = pair2.getFirst().doubleValue() / dDoubleValue;
            this.distribution.add(pair2.getSecond());
        }
    }
}

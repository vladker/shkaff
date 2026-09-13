package org.apache.commons.math3.distribution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EnumeratedIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20130308;
    protected final EnumeratedDistribution<Integer> innerDistribution;

    public EnumeratedIntegerDistribution(int[] iArr, double[] dArr) {
        this(new Well19937c(), iArr, dArr);
    }

    private static List<Pair<Integer, Double>> createDistribution(int[] iArr, double[] dArr) {
        if (iArr.length != dArr.length) {
            throw new DimensionMismatchException(dArr.length, iArr.length);
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            arrayList.add(new Pair(Integer.valueOf(iArr[i5]), Double.valueOf(dArr[i5])));
        }
        return arrayList;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5) {
        double dDoubleValue = 0.0d;
        for (Pair<Integer, Double> pair : this.innerDistribution.getPmf()) {
            if (pair.getKey().intValue() <= i5) {
                dDoubleValue = pair.getValue().doubleValue() + dDoubleValue;
            }
        }
        return dDoubleValue;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        double dDoubleValue = 0.0d;
        for (Pair<Integer, Double> pair : this.innerDistribution.getPmf()) {
            dDoubleValue += pair.getValue().doubleValue() * ((double) pair.getKey().intValue());
        }
        return dDoubleValue;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double dDoubleValue = 0.0d;
        double dDoubleValue2 = 0.0d;
        for (Pair<Integer, Double> pair : this.innerDistribution.getPmf()) {
            dDoubleValue2 += pair.getValue().doubleValue() * ((double) pair.getKey().intValue());
            dDoubleValue += pair.getValue().doubleValue() * ((double) pair.getKey().intValue()) * ((double) pair.getKey().intValue());
        }
        return dDoubleValue - (dDoubleValue2 * dDoubleValue2);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        int iIntValue = Integer.MAX_VALUE;
        for (Pair<Integer, Double> pair : this.innerDistribution.getPmf()) {
            if (pair.getKey().intValue() < iIntValue && pair.getValue().doubleValue() > 0.0d) {
                iIntValue = pair.getKey().intValue();
            }
        }
        return iIntValue;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        int iIntValue = Integer.MIN_VALUE;
        for (Pair<Integer, Double> pair : this.innerDistribution.getPmf()) {
            if (pair.getKey().intValue() > iIntValue && pair.getValue().doubleValue() > 0.0d) {
                iIntValue = pair.getKey().intValue();
            }
        }
        return iIntValue;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int i5) {
        return this.innerDistribution.probability(Integer.valueOf(i5));
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution, org.apache.commons.math3.distribution.IntegerDistribution
    public int sample() {
        return this.innerDistribution.sample().intValue();
    }

    public EnumeratedIntegerDistribution(RandomGenerator randomGenerator, int[] iArr, double[] dArr) {
        super(randomGenerator);
        this.innerDistribution = new EnumeratedDistribution<>(randomGenerator, createDistribution(iArr, dArr));
    }

    public EnumeratedIntegerDistribution(RandomGenerator randomGenerator, int[] iArr) {
        super(randomGenerator);
        HashMap map = new HashMap();
        int i5 = 0;
        for (int i6 : iArr) {
            Integer num = (Integer) map.get(Integer.valueOf(i6));
            if (num == null) {
                num = 0;
            }
            map.put(Integer.valueOf(i6), Integer.valueOf(num.intValue() + 1));
        }
        int size = map.size();
        double length = iArr.length;
        int[] iArr2 = new int[size];
        double[] dArr = new double[size];
        for (Map.Entry entry : map.entrySet()) {
            iArr2[i5] = ((Integer) entry.getKey()).intValue();
            dArr[i5] = ((double) ((Integer) entry.getValue()).intValue()) / length;
            i5++;
        }
        this.innerDistribution = new EnumeratedDistribution<>(randomGenerator, createDistribution(iArr2, dArr));
    }

    public EnumeratedIntegerDistribution(int[] iArr) {
        this(new Well19937c(), iArr);
    }
}

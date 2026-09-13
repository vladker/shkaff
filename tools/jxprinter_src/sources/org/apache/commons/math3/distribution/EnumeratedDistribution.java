package org.apache.commons.math3.distribution;

import A3.AbstractC0157z;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EnumeratedDistribution<T> implements Serializable {
    private static final long serialVersionUID = 20123308;
    private final double[] cumulativeProbabilities;
    private final double[] probabilities;
    protected final RandomGenerator random;
    private final List<T> singletons;

    public EnumeratedDistribution(List<Pair<T, Double>> list) {
        this(new Well19937c(), list);
    }

    public List<Pair<T, Double>> getPmf() {
        ArrayList arrayList = new ArrayList(this.probabilities.length);
        for (int i5 = 0; i5 < this.probabilities.length; i5++) {
            arrayList.add(new Pair(this.singletons.get(i5), Double.valueOf(this.probabilities[i5])));
        }
        return arrayList;
    }

    public double probability(T t6) {
        double d = 0.0d;
        for (int i5 = 0; i5 < this.probabilities.length; i5++) {
            if ((t6 == null && this.singletons.get(i5) == null) || (t6 != null && t6.equals(this.singletons.get(i5)))) {
                d += this.probabilities[i5];
            }
        }
        return d;
    }

    public void reseedRandomGenerator(long j6) {
        this.random.setSeed(j6);
    }

    public T sample() {
        double dNextDouble = this.random.nextDouble();
        int iBinarySearch = Arrays.binarySearch(this.cumulativeProbabilities, dNextDouble);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        return (iBinarySearch < 0 || iBinarySearch >= this.probabilities.length || dNextDouble >= this.cumulativeProbabilities[iBinarySearch]) ? (T) AbstractC0157z.f(1, this.singletons) : this.singletons.get(iBinarySearch);
    }

    public EnumeratedDistribution(RandomGenerator randomGenerator, List<Pair<T, Double>> list) {
        this.random = randomGenerator;
        this.singletons = new ArrayList(list.size());
        double[] dArr = new double[list.size()];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            double d = 0.0d;
            if (i6 < list.size()) {
                Pair<T, Double> pair = list.get(i6);
                this.singletons.add(pair.getKey());
                Double value = pair.getValue();
                double dDoubleValue = value.doubleValue();
                if (dDoubleValue < 0.0d) {
                    throw new NotPositiveException(pair.getValue());
                }
                if (Double.isInfinite(dDoubleValue)) {
                    throw new NotFiniteNumberException(value, new Object[0]);
                }
                if (Double.isNaN(dDoubleValue)) {
                    throw new NotANumberException();
                }
                dArr[i6] = dDoubleValue;
                i6++;
            } else {
                double[] dArrNormalizeArray = MathArrays.normalizeArray(dArr, 1.0d);
                this.probabilities = dArrNormalizeArray;
                this.cumulativeProbabilities = new double[dArrNormalizeArray.length];
                while (true) {
                    double[] dArr2 = this.probabilities;
                    if (i5 >= dArr2.length) {
                        return;
                    }
                    d += dArr2[i5];
                    this.cumulativeProbabilities[i5] = d;
                    i5++;
                }
            }
        }
    }

    public Object[] sample(int i5) {
        if (i5 > 0) {
            Object[] objArr = new Object[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                objArr[i6] = sample();
            }
            return objArr;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i5));
    }

    public T[] sample(int i5, T[] tArr) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        if (tArr != null) {
            if (tArr.length < i5) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i5));
            }
            for (int i6 = 0; i6 < i5; i6++) {
                tArr[i6] = sample();
            }
            return tArr;
        }
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }
}

package org.apache.commons.math3.analysis.integration.gauss;

import java.lang.Number;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseRuleFactory<T extends Number> {
    private final Map<Integer, Pair<T[], T[]>> pointsAndWeights = new TreeMap();
    private final Map<Integer, Pair<double[], double[]>> pointsAndWeightsDouble = new TreeMap();

    private static <T extends Number> Pair<double[], double[]> convertToDouble(Pair<T[], T[]> pair) {
        T[] first = pair.getFirst();
        T[] second = pair.getSecond();
        int length = first.length;
        double[] dArr = new double[length];
        double[] dArr2 = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = first[i5].doubleValue();
            dArr2[i5] = second[i5].doubleValue();
        }
        return new Pair<>(dArr, dArr2);
    }

    public void addRule(Pair<T[], T[]> pair) {
        if (pair.getFirst().length != pair.getSecond().length) {
            throw new DimensionMismatchException(pair.getFirst().length, pair.getSecond().length);
        }
        this.pointsAndWeights.put(Integer.valueOf(pair.getFirst().length), pair);
    }

    public abstract Pair<T[], T[]> computeRule(int i5);

    public Pair<double[], double[]> getRule(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(i5));
        }
        Pair<double[], double[]> pairConvertToDouble = this.pointsAndWeightsDouble.get(Integer.valueOf(i5));
        if (pairConvertToDouble == null) {
            pairConvertToDouble = convertToDouble(getRuleInternal(i5));
            this.pointsAndWeightsDouble.put(Integer.valueOf(i5), pairConvertToDouble);
        }
        return new Pair<>(pairConvertToDouble.getFirst().clone(), pairConvertToDouble.getSecond().clone());
    }

    public synchronized Pair<T[], T[]> getRuleInternal(int i5) {
        Pair<T[], T[]> pair = this.pointsAndWeights.get(Integer.valueOf(i5));
        if (pair != null) {
            return pair;
        }
        addRule(computeRule(i5));
        return getRuleInternal(i5);
    }
}

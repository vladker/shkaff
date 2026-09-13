package org.apache.commons.math3.util;

import java.io.Serializable;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RandomPivotingStrategy implements PivotingStrategyInterface, Serializable {
    private static final long serialVersionUID = 20140713;
    private final RandomGenerator random;

    public RandomPivotingStrategy(RandomGenerator randomGenerator) {
        this.random = randomGenerator;
    }

    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    public int pivotIndex(double[] dArr, int i5, int i6) {
        int i7 = i6 - i5;
        MathArrays.verifyValues(dArr, i5, i7);
        return this.random.nextInt(i7 - 1) + i5;
    }
}

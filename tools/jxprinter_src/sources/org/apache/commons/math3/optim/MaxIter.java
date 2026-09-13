package org.apache.commons.math3.optim;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxIter implements OptimizationData {
    private final int maxIter;

    public MaxIter(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.maxIter = i5;
    }

    public static MaxIter unlimited() {
        return new MaxIter(Integer.MAX_VALUE);
    }

    public int getMaxIter() {
        return this.maxIter;
    }
}

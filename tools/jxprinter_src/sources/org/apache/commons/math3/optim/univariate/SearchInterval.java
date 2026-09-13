package org.apache.commons.math3.optim.univariate;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SearchInterval implements OptimizationData {
    private final double lower;
    private final double start;
    private final double upper;

    public SearchInterval(double d, double d6, double d7) {
        if (d >= d6) {
            throw new NumberIsTooLargeException(Double.valueOf(d), Double.valueOf(d6), false);
        }
        if (d7 < d || d7 > d6) {
            throw new OutOfRangeException(Double.valueOf(d7), Double.valueOf(d), Double.valueOf(d6));
        }
        this.lower = d;
        this.upper = d6;
        this.start = d7;
    }

    public double getMax() {
        return this.upper;
    }

    public double getMin() {
        return this.lower;
    }

    public double getStartValue() {
        return this.start;
    }

    public SearchInterval(double d, double d6) {
        this(d, d6, (d + d6) * 0.5d);
    }
}

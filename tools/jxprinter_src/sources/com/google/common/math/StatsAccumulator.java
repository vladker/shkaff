package com.google.common.math;

import androidx.collection.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class StatsAccumulator {
    private long count = 0;
    private double mean = 0.0d;
    private double sumOfSquaresOfDeltas = 0.0d;
    private double min = Double.NaN;
    private double max = Double.NaN;

    public static double calculateNewMeanNonFinite(double d, double d6) {
        if (Doubles.isFinite(d)) {
            return d6;
        }
        if (Doubles.isFinite(d6) || d == d6) {
            return d;
        }
        return Double.NaN;
    }

    private void merge(long j6, double d, double d6, double d7, double d8) {
        long j7 = this.count;
        if (j7 == 0) {
            this.count = j6;
            this.mean = d;
            this.sumOfSquaresOfDeltas = d6;
            this.min = d7;
            this.max = d8;
            return;
        }
        this.count = j7 + j6;
        if (Doubles.isFinite(this.mean) && Doubles.isFinite(d)) {
            double d9 = this.mean;
            double d10 = d - d9;
            double d11 = j6;
            double d12 = ((d10 * d11) / this.count) + d9;
            this.mean = d12;
            this.sumOfSquaresOfDeltas = ((d - d12) * d10 * d11) + d6 + this.sumOfSquaresOfDeltas;
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d7);
        this.max = Math.max(this.max, d8);
    }

    public void add(double d) {
        double d6;
        long j6 = this.count;
        if (j6 == 0) {
            this.count = 1L;
            this.mean = d;
            this.min = d;
            this.max = d;
            if (Doubles.isFinite(d)) {
                return;
            }
            this.sumOfSquaresOfDeltas = Double.NaN;
            return;
        }
        this.count = j6 + 1;
        if (Doubles.isFinite(d) && Doubles.isFinite(this.mean)) {
            double d7 = this.mean;
            double d8 = d - d7;
            double d9 = (d8 / this.count) + d7;
            this.mean = d9;
            d6 = d;
            this.sumOfSquaresOfDeltas = a.a(d, d9, d8, this.sumOfSquaresOfDeltas);
        } else {
            d6 = d;
            this.mean = calculateNewMeanNonFinite(this.mean, d6);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d6);
        this.max = Math.max(this.max, d6);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public long count() {
        return this.count;
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double d : dArr) {
            add(d);
        }
    }

    public void addAll(int... iArr) {
        for (int i5 : iArr) {
            add(i5);
        }
    }

    public void addAll(long... jArr) {
        for (long j6 : jArr) {
            add(j6);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        merge(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() == 0) {
            return;
        }
        merge(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.sumOfSquaresOfDeltas(), statsAccumulator.min(), statsAccumulator.max());
    }
}

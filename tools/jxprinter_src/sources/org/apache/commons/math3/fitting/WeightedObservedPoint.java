package org.apache.commons.math3.fitting;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WeightedObservedPoint implements Serializable {
    private static final long serialVersionUID = 5306874947404636157L;
    private final double weight;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double f6771x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double f6772y;

    public WeightedObservedPoint(double d, double d6, double d7) {
        this.weight = d;
        this.f6771x = d6;
        this.f6772y = d7;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getX() {
        return this.f6771x;
    }

    public double getY() {
        return this.f6772y;
    }
}

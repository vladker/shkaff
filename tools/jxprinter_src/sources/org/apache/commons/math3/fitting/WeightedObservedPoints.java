package org.apache.commons.math3.fitting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WeightedObservedPoints implements Serializable {
    private static final long serialVersionUID = 20130813;
    private final List<WeightedObservedPoint> observations = new ArrayList();

    public void add(double d, double d6) {
        add(1.0d, d, d6);
    }

    public void clear() {
        this.observations.clear();
    }

    public List<WeightedObservedPoint> toList() {
        return new ArrayList(this.observations);
    }

    public void add(double d, double d6, double d7) {
        this.observations.add(new WeightedObservedPoint(d, d6, d7));
    }

    public void add(WeightedObservedPoint weightedObservedPoint) {
        this.observations.add(weightedObservedPoint);
    }
}

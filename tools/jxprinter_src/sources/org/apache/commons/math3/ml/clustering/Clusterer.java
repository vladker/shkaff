package org.apache.commons.math3.ml.clustering;

import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Clusterer<T extends Clusterable> {
    private DistanceMeasure measure;

    public Clusterer(DistanceMeasure distanceMeasure) {
        this.measure = distanceMeasure;
    }

    public abstract List<? extends Cluster<T>> cluster(Collection<T> collection);

    public double distance(Clusterable clusterable, Clusterable clusterable2) {
        return this.measure.compute(clusterable.getPoint(), clusterable2.getPoint());
    }

    public DistanceMeasure getDistanceMeasure() {
        return this.measure;
    }
}

package org.apache.commons.math3.stat.clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.clustering.Clusterable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Cluster<T extends Clusterable<T>> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;
    private final T center;
    private final List<T> points = new ArrayList();

    public Cluster(T t6) {
        this.center = t6;
    }

    public void addPoint(T t6) {
        this.points.add(t6);
    }

    public T getCenter() {
        return this.center;
    }

    public List<T> getPoints() {
        return this.points;
    }
}

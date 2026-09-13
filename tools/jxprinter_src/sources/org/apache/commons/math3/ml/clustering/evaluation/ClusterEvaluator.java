package org.apache.commons.math3.ml.clustering.evaluation;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ClusterEvaluator<T extends Clusterable> {
    private final DistanceMeasure measure;

    public ClusterEvaluator() {
        this(new EuclideanDistance());
    }

    public Clusterable centroidOf(Cluster<T> cluster) {
        List<T> points = cluster.getPoints();
        if (points.isEmpty()) {
            return null;
        }
        if (cluster instanceof CentroidCluster) {
            return ((CentroidCluster) cluster).getCenter();
        }
        int length = points.get(0).getPoint().length;
        double[] dArr = new double[length];
        Iterator<T> it = points.iterator();
        while (it.hasNext()) {
            double[] point = it.next().getPoint();
            for (int i5 = 0; i5 < length; i5++) {
                dArr[i5] = dArr[i5] + point[i5];
            }
        }
        for (int i6 = 0; i6 < length; i6++) {
            dArr[i6] = dArr[i6] / ((double) points.size());
        }
        return new DoublePoint(dArr);
    }

    public double distance(Clusterable clusterable, Clusterable clusterable2) {
        return this.measure.compute(clusterable.getPoint(), clusterable2.getPoint());
    }

    public boolean isBetterScore(double d, double d6) {
        return d < d6;
    }

    public abstract double score(List<? extends Cluster<T>> list);

    public ClusterEvaluator(DistanceMeasure distanceMeasure) {
        this.measure = distanceMeasure;
    }
}

package org.apache.commons.math3.ml.clustering.evaluation;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SumOfClusterVariances<T extends Clusterable> extends ClusterEvaluator<T> {
    public SumOfClusterVariances(DistanceMeasure distanceMeasure) {
        super(distanceMeasure);
    }

    @Override // org.apache.commons.math3.ml.clustering.evaluation.ClusterEvaluator
    public double score(List<? extends Cluster<T>> list) {
        double result = 0.0d;
        for (Cluster<T> cluster : list) {
            if (!cluster.getPoints().isEmpty()) {
                Clusterable clusterableCentroidOf = centroidOf(cluster);
                Variance variance = new Variance();
                Iterator<T> it = cluster.getPoints().iterator();
                while (it.hasNext()) {
                    variance.increment(distance(it.next(), clusterableCentroidOf));
                }
                result = variance.getResult() + result;
            }
        }
        return result;
    }
}

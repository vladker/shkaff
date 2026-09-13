package org.apache.commons.math3.ml.clustering;

import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.evaluation.ClusterEvaluator;
import org.apache.commons.math3.ml.clustering.evaluation.SumOfClusterVariances;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiKMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    private final KMeansPlusPlusClusterer<T> clusterer;
    private final ClusterEvaluator<T> evaluator;
    private final int numTrials;

    public MultiKMeansPlusPlusClusterer(KMeansPlusPlusClusterer<T> kMeansPlusPlusClusterer, int i5) {
        this(kMeansPlusPlusClusterer, i5, new SumOfClusterVariances(kMeansPlusPlusClusterer.getDistanceMeasure()));
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<CentroidCluster<T>> cluster(Collection<T> collection) {
        List<CentroidCluster<T>> list = null;
        double d = Double.POSITIVE_INFINITY;
        for (int i5 = 0; i5 < this.numTrials; i5++) {
            List<CentroidCluster<T>> listCluster = this.clusterer.cluster(collection);
            double dScore = this.evaluator.score(listCluster);
            if (this.evaluator.isBetterScore(dScore, d)) {
                list = listCluster;
                d = dScore;
            }
        }
        return list;
    }

    public ClusterEvaluator<T> getClusterEvaluator() {
        return this.evaluator;
    }

    public KMeansPlusPlusClusterer<T> getClusterer() {
        return this.clusterer;
    }

    public int getNumTrials() {
        return this.numTrials;
    }

    public MultiKMeansPlusPlusClusterer(KMeansPlusPlusClusterer<T> kMeansPlusPlusClusterer, int i5, ClusterEvaluator<T> clusterEvaluator) {
        super(kMeansPlusPlusClusterer.getDistanceMeasure());
        this.clusterer = kMeansPlusPlusClusterer;
        this.numTrials = i5;
        this.evaluator = clusterEvaluator;
    }
}

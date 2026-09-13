package org.apache.commons.math3.ml.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DBSCANClusterer<T extends Clusterable> extends Clusterer<T> {
    private final double eps;
    private final int minPts;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PointStatus {
        NOISE,
        PART_OF_CLUSTER
    }

    public DBSCANClusterer(double d, int i5) {
        this(d, i5, new EuclideanDistance());
    }

    private Cluster<T> expandCluster(Cluster<T> cluster, T t6, List<T> list, Collection<T> collection, Map<Clusterable, PointStatus> map) {
        cluster.addPoint(t6);
        map.put(t6, PointStatus.PART_OF_CLUSTER);
        List<T> arrayList = new ArrayList<>(list);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            T t7 = arrayList.get(i5);
            PointStatus pointStatus = map.get(t7);
            if (pointStatus == null) {
                List<T> neighbors = getNeighbors(t7, collection);
                if (neighbors.size() >= this.minPts) {
                    arrayList = merge(arrayList, neighbors);
                }
            }
            PointStatus pointStatus2 = PointStatus.PART_OF_CLUSTER;
            if (pointStatus != pointStatus2) {
                map.put(t7, pointStatus2);
                cluster.addPoint(t7);
            }
        }
        return cluster;
    }

    private List<T> getNeighbors(T t6, Collection<T> collection) {
        ArrayList arrayList = new ArrayList();
        for (T t7 : collection) {
            if (t6 != t7 && distance(t7, t6) <= this.eps) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    private List<T> merge(List<T> list, List<T> list2) {
        HashSet hashSet = new HashSet(list);
        for (T t6 : list2) {
            if (!hashSet.contains(t6)) {
                list.add(t6);
            }
        }
        return list;
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<Cluster<T>> cluster(Collection<T> collection) {
        Collection<T> collection2;
        MathUtils.checkNotNull(collection);
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (T t6 : collection) {
            if (map.get(t6) == null) {
                List<T> neighbors = getNeighbors(t6, collection);
                if (neighbors.size() >= this.minPts) {
                    collection2 = collection;
                    arrayList.add(expandCluster(new Cluster<>(), t6, neighbors, collection2, map));
                } else {
                    collection2 = collection;
                    map.put(t6, PointStatus.NOISE);
                }
                collection = collection2;
            }
        }
        return arrayList;
    }

    public double getEps() {
        return this.eps;
    }

    public int getMinPts() {
        return this.minPts;
    }

    public DBSCANClusterer(double d, int i5, DistanceMeasure distanceMeasure) {
        super(distanceMeasure);
        if (d < 0.0d) {
            throw new NotPositiveException(Double.valueOf(d));
        }
        if (i5 < 0) {
            throw new NotPositiveException(Integer.valueOf(i5));
        }
        this.eps = d;
        this.minPts = i5;
    }
}

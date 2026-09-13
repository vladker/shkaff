package org.apache.commons.math3.stat.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.clustering.Clusterable;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class KMeansPlusPlusClusterer<T extends Clusterable<T>> {
    private final EmptyClusterStrategy emptyStrategy;
    private final Random random;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.clustering.KMeansPlusPlusClusterer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy;

        static {
            int[] iArr = new int[EmptyClusterStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy = iArr;
            try {
                iArr[EmptyClusterStrategy.LARGEST_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.LARGEST_POINTS_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.FARTHEST_POINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum EmptyClusterStrategy {
        LARGEST_VARIANCE,
        LARGEST_POINTS_NUMBER,
        FARTHEST_POINT,
        ERROR
    }

    public KMeansPlusPlusClusterer(Random random) {
        this(random, EmptyClusterStrategy.LARGEST_VARIANCE);
    }

    private static <T extends Clusterable<T>> int assignPointsToClusters(List<Cluster<T>> list, Collection<T> collection, int[] iArr) {
        int i5 = 0;
        int i6 = 0;
        for (T t6 : collection) {
            int nearestCluster = getNearestCluster(list, t6);
            if (nearestCluster != iArr[i6]) {
                i5++;
            }
            list.get(nearestCluster).addPoint(t6);
            iArr[i6] = nearestCluster;
            i6++;
        }
        return i5;
    }

    private static <T extends Clusterable<T>> List<Cluster<T>> chooseInitialCenters(Collection<T> collection, int i5, Random random) {
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(collection));
        int size = listUnmodifiableList.size();
        boolean[] zArr = new boolean[size];
        ArrayList arrayList = new ArrayList();
        int iNextInt = random.nextInt(size);
        Clusterable clusterable = (Clusterable) listUnmodifiableList.get(iNextInt);
        arrayList.add(new Cluster(clusterable));
        zArr[iNextInt] = true;
        double[] dArr = new double[size];
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 != iNextInt) {
                double dDistanceFrom = clusterable.distanceFrom(listUnmodifiableList.get(i6));
                dArr[i6] = dDistanceFrom * dDistanceFrom;
            }
        }
        while (arrayList.size() < i5) {
            double d = 0.0d;
            double d6 = 0.0d;
            for (int i7 = 0; i7 < size; i7++) {
                if (!zArr[i7]) {
                    d6 += dArr[i7];
                }
            }
            double dNextDouble = random.nextDouble() * d6;
            int i8 = 0;
            while (true) {
                if (i8 >= size) {
                    i8 = -1;
                    break;
                }
                if (!zArr[i8]) {
                    d += dArr[i8];
                    if (d >= dNextDouble) {
                        break;
                    }
                }
                i8++;
            }
            if (i8 == -1) {
                for (int i9 = size - 1; i9 >= 0; i9--) {
                    if (!zArr[i9]) {
                        i8 = i9;
                        break;
                    }
                }
            }
            if (i8 < 0) {
                break;
            }
            Clusterable clusterable2 = (Clusterable) listUnmodifiableList.get(i8);
            arrayList.add(new Cluster(clusterable2));
            zArr[i8] = true;
            if (arrayList.size() < i5) {
                for (int i10 = 0; i10 < size; i10++) {
                    if (!zArr[i10]) {
                        double dDistanceFrom2 = clusterable2.distanceFrom(listUnmodifiableList.get(i10));
                        double d7 = dDistanceFrom2 * dDistanceFrom2;
                        if (d7 < dArr[i10]) {
                            dArr[i10] = d7;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private T getFarthestPoint(Collection<Cluster<T>> collection) {
        Iterator<Cluster<T>> it = collection.iterator();
        double d = Double.NEGATIVE_INFINITY;
        Cluster<T> cluster = null;
        int i5 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Cluster<T> next = it.next();
            Clusterable center = next.getCenter();
            List<T> points = next.getPoints();
            for (int i6 = 0; i6 < points.size(); i6++) {
                double dDistanceFrom = points.get(i6).distanceFrom(center);
                if (dDistanceFrom > d) {
                    cluster = next;
                    i5 = i6;
                    d = dDistanceFrom;
                }
            }
        }
        if (cluster != null) {
            return cluster.getPoints().remove(i5);
        }
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    }

    private static <T extends Clusterable<T>> int getNearestCluster(Collection<Cluster<T>> collection, T t6) {
        Iterator<Cluster<T>> it = collection.iterator();
        double d = Double.MAX_VALUE;
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            double dDistanceFrom = t6.distanceFrom(it.next().getCenter());
            if (dDistanceFrom < d) {
                i5 = i6;
                d = dDistanceFrom;
            }
            i6++;
        }
        return i5;
    }

    private T getPointFromLargestNumberCluster(Collection<Cluster<T>> collection) {
        Cluster<T> cluster = null;
        int i5 = 0;
        for (Cluster<T> cluster2 : collection) {
            int size = cluster2.getPoints().size();
            if (size > i5) {
                cluster = cluster2;
                i5 = size;
            }
        }
        if (cluster == null) {
            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        List<T> points = cluster.getPoints();
        return points.remove(this.random.nextInt(points.size()));
    }

    private T getPointFromLargestVarianceCluster(Collection<Cluster<T>> collection) {
        double d = Double.NEGATIVE_INFINITY;
        Cluster<T> cluster = null;
        for (Cluster<T> cluster2 : collection) {
            if (!cluster2.getPoints().isEmpty()) {
                Clusterable center = cluster2.getCenter();
                Variance variance = new Variance();
                Iterator<T> it = cluster2.getPoints().iterator();
                while (it.hasNext()) {
                    variance.increment(it.next().distanceFrom(center));
                }
                double result = variance.getResult();
                if (result > d) {
                    cluster = cluster2;
                    d = result;
                }
            }
        }
        if (cluster == null) {
            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        List<T> points = cluster.getPoints();
        return points.remove(this.random.nextInt(points.size()));
    }

    public List<Cluster<T>> cluster(Collection<T> collection, int i5, int i6, int i7) {
        List<Cluster<T>> list;
        double d;
        List<Cluster<T>> list2 = null;
        double d6 = Double.POSITIVE_INFINITY;
        for (int i8 = 0; i8 < i6; i8++) {
            List<Cluster<T>> listCluster = cluster(collection, i5, i7);
            double result = 0.0d;
            for (Cluster<T> cluster : listCluster) {
                if (cluster.getPoints().isEmpty()) {
                    list = list2;
                    d = d6;
                } else {
                    Clusterable center = cluster.getCenter();
                    Variance variance = new Variance();
                    Iterator<T> it = cluster.getPoints().iterator();
                    while (it.hasNext()) {
                        variance.increment(it.next().distanceFrom(center));
                        list2 = list2;
                        d6 = d6;
                    }
                    list = list2;
                    d = d6;
                    result = variance.getResult() + result;
                }
                list2 = list;
                d6 = d;
            }
            List<Cluster<T>> list3 = list2;
            double d7 = d6;
            if (result <= d7) {
                list2 = listCluster;
                d6 = result;
            } else {
                list2 = list3;
                d6 = d7;
            }
        }
        return list2;
    }

    public KMeansPlusPlusClusterer(Random random, EmptyClusterStrategy emptyClusterStrategy) {
        this.random = random;
        this.emptyStrategy = emptyClusterStrategy;
    }

    public List<Cluster<T>> cluster(Collection<T> collection, int i5, int i6) {
        boolean z6;
        Clusterable pointFromLargestVarianceCluster;
        MathUtils.checkNotNull(collection);
        if (collection.size() >= i5) {
            List<Cluster<T>> listChooseInitialCenters = chooseInitialCenters(collection, i5, this.random);
            int[] iArr = new int[collection.size()];
            assignPointsToClusters(listChooseInitialCenters, collection, iArr);
            if (i6 < 0) {
                i6 = Integer.MAX_VALUE;
            }
            int i7 = 0;
            while (i7 < i6) {
                ArrayList arrayList = new ArrayList();
                boolean z7 = false;
                for (Cluster<T> cluster : listChooseInitialCenters) {
                    if (cluster.getPoints().isEmpty()) {
                        int i8 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[this.emptyStrategy.ordinal()];
                        z6 = true;
                        if (i8 == 1) {
                            pointFromLargestVarianceCluster = getPointFromLargestVarianceCluster(listChooseInitialCenters);
                        } else if (i8 == 2) {
                            pointFromLargestVarianceCluster = getPointFromLargestNumberCluster(listChooseInitialCenters);
                        } else if (i8 == 3) {
                            pointFromLargestVarianceCluster = getFarthestPoint(listChooseInitialCenters);
                        } else {
                            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                        }
                    } else {
                        Clusterable clusterable = (Clusterable) cluster.getCenter().centroidOf(cluster.getPoints());
                        z6 = z7;
                        pointFromLargestVarianceCluster = clusterable;
                    }
                    arrayList.add(new Cluster(pointFromLargestVarianceCluster));
                    z7 = z6;
                }
                if (assignPointsToClusters(arrayList, collection, iArr) == 0 && !z7) {
                    return arrayList;
                }
                i7++;
                listChooseInitialCenters = arrayList;
            }
            return listChooseInitialCenters;
        }
        throw new NumberIsTooSmallException(Integer.valueOf(collection.size()), Integer.valueOf(i5), false);
    }
}

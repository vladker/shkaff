package org.apache.commons.math3.ml.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    private final EmptyClusterStrategy emptyStrategy;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f6822k;
    private final int maxIterations;
    private final RandomGenerator random;

    /* JADX INFO: renamed from: org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy;

        static {
            int[] iArr = new int[EmptyClusterStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy = iArr;
            try {
                iArr[EmptyClusterStrategy.LARGEST_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.LARGEST_POINTS_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[EmptyClusterStrategy.FARTHEST_POINT.ordinal()] = 3;
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

    public KMeansPlusPlusClusterer(int i5) {
        this(i5, -1);
    }

    private int assignPointsToClusters(List<CentroidCluster<T>> list, Collection<T> collection, int[] iArr) {
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

    private Clusterable centroidOf(Collection<T> collection, int i5) {
        int i6;
        double[] dArr = new double[i5];
        Iterator<T> it = collection.iterator();
        while (true) {
            i6 = 0;
            if (!it.hasNext()) {
                break;
            }
            double[] point = it.next().getPoint();
            while (i6 < i5) {
                dArr[i6] = dArr[i6] + point[i6];
                i6++;
            }
        }
        while (i6 < i5) {
            dArr[i6] = dArr[i6] / ((double) collection.size());
            i6++;
        }
        return new DoublePoint(dArr);
    }

    private List<CentroidCluster<T>> chooseInitialCenters(Collection<T> collection) {
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(collection));
        int size = listUnmodifiableList.size();
        boolean[] zArr = new boolean[size];
        ArrayList arrayList = new ArrayList();
        int iNextInt = this.random.nextInt(size);
        Clusterable clusterable = (Clusterable) listUnmodifiableList.get(iNextInt);
        arrayList.add(new CentroidCluster(clusterable));
        zArr[iNextInt] = true;
        double[] dArr = new double[size];
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 != iNextInt) {
                double dDistance = distance(clusterable, (Clusterable) listUnmodifiableList.get(i5));
                dArr[i5] = dDistance * dDistance;
            }
        }
        while (arrayList.size() < this.f6822k) {
            double d = 0.0d;
            double d6 = 0.0d;
            for (int i6 = 0; i6 < size; i6++) {
                if (!zArr[i6]) {
                    d6 += dArr[i6];
                }
            }
            double dNextDouble = this.random.nextDouble() * d6;
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    i7 = -1;
                    break;
                }
                if (!zArr[i7]) {
                    d += dArr[i7];
                    if (d >= dNextDouble) {
                        break;
                    }
                }
                i7++;
            }
            if (i7 == -1) {
                for (int i8 = size - 1; i8 >= 0; i8--) {
                    if (!zArr[i8]) {
                        i7 = i8;
                        break;
                    }
                }
            }
            if (i7 < 0) {
                break;
            }
            Clusterable clusterable2 = (Clusterable) listUnmodifiableList.get(i7);
            arrayList.add(new CentroidCluster(clusterable2));
            zArr[i7] = true;
            if (arrayList.size() < this.f6822k) {
                for (int i9 = 0; i9 < size; i9++) {
                    if (!zArr[i9]) {
                        double dDistance2 = distance(clusterable2, (Clusterable) listUnmodifiableList.get(i9));
                        double d7 = dDistance2 * dDistance2;
                        if (d7 < dArr[i9]) {
                            dArr[i9] = d7;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private T getFarthestPoint(Collection<CentroidCluster<T>> collection) {
        Iterator<CentroidCluster<T>> it = collection.iterator();
        double d = Double.NEGATIVE_INFINITY;
        CentroidCluster<T> centroidCluster = null;
        int i5 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CentroidCluster<T> next = it.next();
            Clusterable center = next.getCenter();
            List<T> points = next.getPoints();
            for (int i6 = 0; i6 < points.size(); i6++) {
                double dDistance = distance(points.get(i6), center);
                if (dDistance > d) {
                    centroidCluster = next;
                    i5 = i6;
                    d = dDistance;
                }
            }
        }
        if (centroidCluster != null) {
            return centroidCluster.getPoints().remove(i5);
        }
        throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
    }

    private int getNearestCluster(Collection<CentroidCluster<T>> collection, T t6) {
        Iterator<CentroidCluster<T>> it = collection.iterator();
        double d = Double.MAX_VALUE;
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            double dDistance = distance(t6, it.next().getCenter());
            if (dDistance < d) {
                i5 = i6;
                d = dDistance;
            }
            i6++;
        }
        return i5;
    }

    private T getPointFromLargestNumberCluster(Collection<? extends Cluster<T>> collection) {
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

    private T getPointFromLargestVarianceCluster(Collection<CentroidCluster<T>> collection) {
        double d = Double.NEGATIVE_INFINITY;
        CentroidCluster<T> centroidCluster = null;
        for (CentroidCluster<T> centroidCluster2 : collection) {
            if (!centroidCluster2.getPoints().isEmpty()) {
                Clusterable center = centroidCluster2.getCenter();
                Variance variance = new Variance();
                Iterator<T> it = centroidCluster2.getPoints().iterator();
                while (it.hasNext()) {
                    variance.increment(distance(it.next(), center));
                }
                double result = variance.getResult();
                if (result > d) {
                    centroidCluster = centroidCluster2;
                    d = result;
                }
            }
        }
        if (centroidCluster == null) {
            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        List<T> points = centroidCluster.getPoints();
        return points.remove(this.random.nextInt(points.size()));
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<CentroidCluster<T>> cluster(Collection<T> collection) {
        boolean z6;
        Clusterable pointFromLargestVarianceCluster;
        MathUtils.checkNotNull(collection);
        if (collection.size() < this.f6822k) {
            throw new NumberIsTooSmallException(Integer.valueOf(collection.size()), Integer.valueOf(this.f6822k), false);
        }
        List<CentroidCluster<T>> listChooseInitialCenters = chooseInitialCenters(collection);
        int[] iArr = new int[collection.size()];
        assignPointsToClusters(listChooseInitialCenters, collection, iArr);
        int i5 = this.maxIterations;
        if (i5 < 0) {
            i5 = Integer.MAX_VALUE;
        }
        int i6 = 0;
        while (i6 < i5) {
            ArrayList arrayList = new ArrayList();
            boolean z7 = false;
            for (CentroidCluster<T> centroidCluster : listChooseInitialCenters) {
                if (centroidCluster.getPoints().isEmpty()) {
                    int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$clustering$KMeansPlusPlusClusterer$EmptyClusterStrategy[this.emptyStrategy.ordinal()];
                    z6 = true;
                    if (i7 == 1) {
                        pointFromLargestVarianceCluster = getPointFromLargestVarianceCluster(listChooseInitialCenters);
                    } else if (i7 == 2) {
                        pointFromLargestVarianceCluster = getPointFromLargestNumberCluster(listChooseInitialCenters);
                    } else {
                        if (i7 != 3) {
                            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
                        }
                        pointFromLargestVarianceCluster = getFarthestPoint(listChooseInitialCenters);
                    }
                } else {
                    Clusterable clusterableCentroidOf = centroidOf(centroidCluster.getPoints(), centroidCluster.getCenter().getPoint().length);
                    z6 = z7;
                    pointFromLargestVarianceCluster = clusterableCentroidOf;
                }
                arrayList.add(new CentroidCluster(pointFromLargestVarianceCluster));
                z7 = z6;
            }
            if (assignPointsToClusters(arrayList, collection, iArr) == 0 && !z7) {
                return arrayList;
            }
            i6++;
            listChooseInitialCenters = arrayList;
        }
        return listChooseInitialCenters;
    }

    public EmptyClusterStrategy getEmptyClusterStrategy() {
        return this.emptyStrategy;
    }

    public int getK() {
        return this.f6822k;
    }

    public int getMaxIterations() {
        return this.maxIterations;
    }

    public RandomGenerator getRandomGenerator() {
        return this.random;
    }

    public KMeansPlusPlusClusterer(int i5, int i6) {
        this(i5, i6, new EuclideanDistance());
    }

    public KMeansPlusPlusClusterer(int i5, int i6, DistanceMeasure distanceMeasure) {
        this(i5, i6, distanceMeasure, new JDKRandomGenerator());
    }

    public KMeansPlusPlusClusterer(int i5, int i6, DistanceMeasure distanceMeasure, RandomGenerator randomGenerator) {
        this(i5, i6, distanceMeasure, randomGenerator, EmptyClusterStrategy.LARGEST_VARIANCE);
    }

    public KMeansPlusPlusClusterer(int i5, int i6, DistanceMeasure distanceMeasure, RandomGenerator randomGenerator, EmptyClusterStrategy emptyClusterStrategy) {
        super(distanceMeasure);
        this.f6822k = i5;
        this.maxIterations = i6;
        this.random = randomGenerator;
        this.emptyStrategy = emptyClusterStrategy;
    }
}

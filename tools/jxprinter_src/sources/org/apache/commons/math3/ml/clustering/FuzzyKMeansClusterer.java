package org.apache.commons.math3.ml.clustering;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FuzzyKMeansClusterer<T extends Clusterable> extends Clusterer<T> {
    private static final double DEFAULT_EPSILON = 0.001d;
    private List<CentroidCluster<T>> clusters;
    private final double epsilon;
    private final double fuzziness;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f6821k;
    private final int maxIterations;
    private double[][] membershipMatrix;
    private List<T> points;
    private final RandomGenerator random;

    public FuzzyKMeansClusterer(int i5, double d) {
        this(i5, d, -1, new EuclideanDistance());
    }

    private double calculateMaxMembershipChange(double[][] dArr) {
        double dMax = 0.0d;
        for (int i5 = 0; i5 < this.points.size(); i5++) {
            for (int i6 = 0; i6 < this.clusters.size(); i6++) {
                dMax = FastMath.max(FastMath.abs(this.membershipMatrix[i5][i6] - dArr[i5][i6]), dMax);
            }
        }
        return dMax;
    }

    private void initializeMembershipMatrix() {
        for (int i5 = 0; i5 < this.points.size(); i5++) {
            for (int i6 = 0; i6 < this.f6821k; i6++) {
                this.membershipMatrix[i5][i6] = this.random.nextDouble();
            }
            double[][] dArr = this.membershipMatrix;
            dArr[i5] = MathArrays.normalizeArray(dArr[i5], 1.0d);
        }
    }

    private void saveMembershipMatrix(double[][] dArr) {
        for (int i5 = 0; i5 < this.points.size(); i5++) {
            System.arraycopy(this.membershipMatrix[i5], 0, dArr[i5], 0, this.clusters.size());
        }
    }

    private void updateClusterCenters() {
        ArrayList arrayList = new ArrayList(this.f6821k);
        Iterator<CentroidCluster<T>> it = this.clusters.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            int length = it.next().getCenter().getPoint().length;
            double[] dArr = new double[length];
            double d = 0.0d;
            int i6 = 0;
            for (T t6 : this.points) {
                int i7 = i5;
                double dPow = FastMath.pow(this.membershipMatrix[i6][i5], this.fuzziness);
                double[] point = t6.getPoint();
                for (int i8 = 0; i8 < length; i8++) {
                    dArr[i8] = (point[i8] * dPow) + dArr[i8];
                }
                d += dPow;
                i6++;
                i5 = i7;
            }
            MathArrays.scaleInPlace(1.0d / d, dArr);
            arrayList.add(new CentroidCluster(new DoublePoint(dArr)));
            i5++;
        }
        this.clusters.clear();
        this.clusters = arrayList;
    }

    private void updateMembershipMatrix() {
        double d;
        double dPow;
        for (int i5 = 0; i5 < this.points.size(); i5++) {
            T t6 = this.points.get(i5);
            double d6 = Double.MIN_VALUE;
            int i6 = -1;
            for (int i7 = 0; i7 < this.clusters.size(); i7++) {
                double dAbs = FastMath.abs(distance(t6, this.clusters.get(i7).getCenter()));
                double d7 = 0.0d;
                if (dAbs != 0.0d) {
                    Iterator<CentroidCluster<T>> it = this.clusters.iterator();
                    dPow = 0.0d;
                    while (it.hasNext()) {
                        double dAbs2 = FastMath.abs(distance(t6, it.next().getCenter()));
                        if (dAbs2 == d7) {
                            dPow = Double.POSITIVE_INFINITY;
                            break;
                        } else {
                            dPow = FastMath.pow(dAbs / dAbs2, 2.0d / (this.fuzziness - 1.0d)) + dPow;
                            d7 = d7;
                        }
                    }
                    d = Double.POSITIVE_INFINITY;
                } else {
                    d7 = 0.0d;
                    d = Double.POSITIVE_INFINITY;
                    dPow = 0.0d;
                }
                double d8 = dPow == d7 ? 1.0d : dPow == d ? d7 : 1.0d / dPow;
                this.membershipMatrix[i5][i7] = d8;
                if (d8 > d6) {
                    i6 = i7;
                    d6 = d8;
                }
            }
            this.clusters.get(i6).addPoint(t6);
        }
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterer
    public List<CentroidCluster<T>> cluster(Collection<T> collection) {
        MathUtils.checkNotNull(collection);
        int size = collection.size();
        int i5 = 0;
        if (size < this.f6821k) {
            throw new NumberIsTooSmallException(Integer.valueOf(size), Integer.valueOf(this.f6821k), false);
        }
        this.points = Collections.unmodifiableList(new ArrayList(collection));
        this.clusters = new ArrayList();
        int[] iArr = {size, this.f6821k};
        Class cls = Double.TYPE;
        this.membershipMatrix = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, size, this.f6821k);
        if (size == 0) {
            return this.clusters;
        }
        initializeMembershipMatrix();
        int length = this.points.get(0).getPoint().length;
        for (int i6 = 0; i6 < this.f6821k; i6++) {
            this.clusters.add(new CentroidCluster<>(new DoublePoint(new double[length])));
        }
        int i7 = this.maxIterations;
        if (i7 < 0) {
            i7 = Integer.MAX_VALUE;
        }
        do {
            saveMembershipMatrix(dArr);
            updateClusterCenters();
            updateMembershipMatrix();
            if (calculateMaxMembershipChange(dArr) <= this.epsilon) {
                break;
            }
            i5++;
        } while (i5 < i7);
        return this.clusters;
    }

    public List<CentroidCluster<T>> getClusters() {
        return this.clusters;
    }

    public List<T> getDataPoints() {
        return this.points;
    }

    public double getEpsilon() {
        return this.epsilon;
    }

    public double getFuzziness() {
        return this.fuzziness;
    }

    public int getK() {
        return this.f6821k;
    }

    public int getMaxIterations() {
        return this.maxIterations;
    }

    public RealMatrix getMembershipMatrix() {
        double[][] dArr = this.membershipMatrix;
        if (dArr != null) {
            return MatrixUtils.createRealMatrix(dArr);
        }
        throw new MathIllegalStateException();
    }

    public double getObjectiveFunctionValue() {
        List<T> list = this.points;
        if (list == null || this.clusters == null) {
            throw new MathIllegalStateException();
        }
        double dPow = 0.0d;
        int i5 = 0;
        for (T t6 : list) {
            Iterator<CentroidCluster<T>> it = this.clusters.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                double dDistance = distance(t6, it.next().getCenter());
                dPow += FastMath.pow(this.membershipMatrix[i5][i6], this.fuzziness) * dDistance * dDistance;
                i6++;
            }
            i5++;
        }
        return dPow;
    }

    public RandomGenerator getRandomGenerator() {
        return this.random;
    }

    public FuzzyKMeansClusterer(int i5, double d, int i6, DistanceMeasure distanceMeasure) {
        this(i5, d, i6, distanceMeasure, 0.001d, new JDKRandomGenerator());
    }

    public FuzzyKMeansClusterer(int i5, double d, int i6, DistanceMeasure distanceMeasure, double d6, RandomGenerator randomGenerator) {
        super(distanceMeasure);
        if (d > 1.0d) {
            this.f6821k = i5;
            this.fuzziness = d;
            this.maxIterations = i6;
            this.epsilon = d6;
            this.random = randomGenerator;
            this.membershipMatrix = null;
            this.points = null;
            this.clusters = null;
            return;
        }
        throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(1.0d), false);
    }
}

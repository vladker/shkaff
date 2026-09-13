package org.apache.commons.math3.stat.clustering;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class EuclideanDoublePoint implements Clusterable<EuclideanDoublePoint>, Serializable {
    private static final long serialVersionUID = 8026472786091227632L;
    private final double[] point;

    public EuclideanDoublePoint(double[] dArr) {
        this.point = dArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EuclideanDoublePoint) {
            return Arrays.equals(this.point, ((EuclideanDoublePoint) obj).point);
        }
        return false;
    }

    public double[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public EuclideanDoublePoint centroidOf(Collection<EuclideanDoublePoint> collection) {
        int i5;
        int length = getPoint().length;
        double[] dArr = new double[length];
        Iterator<EuclideanDoublePoint> it = collection.iterator();
        while (true) {
            i5 = 0;
            if (!it.hasNext()) {
                break;
            }
            EuclideanDoublePoint next = it.next();
            while (i5 < length) {
                dArr[i5] = dArr[i5] + next.getPoint()[i5];
                i5++;
            }
        }
        while (i5 < length) {
            dArr[i5] = dArr[i5] / ((double) collection.size());
            i5++;
        }
        return new EuclideanDoublePoint(dArr);
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public double distanceFrom(EuclideanDoublePoint euclideanDoublePoint) {
        return MathArrays.distance(this.point, euclideanDoublePoint.getPoint());
    }
}

package org.apache.commons.math3.stat.clustering;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class EuclideanIntegerPoint implements Clusterable<EuclideanIntegerPoint>, Serializable {
    private static final long serialVersionUID = 3946024775784901369L;
    private final int[] point;

    public EuclideanIntegerPoint(int[] iArr) {
        this.point = iArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EuclideanIntegerPoint) {
            return Arrays.equals(this.point, ((EuclideanIntegerPoint) obj).point);
        }
        return false;
    }

    public int[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public EuclideanIntegerPoint centroidOf(Collection<EuclideanIntegerPoint> collection) {
        int i5;
        int length = getPoint().length;
        int[] iArr = new int[length];
        Iterator<EuclideanIntegerPoint> it = collection.iterator();
        while (true) {
            i5 = 0;
            if (!it.hasNext()) {
                break;
            }
            EuclideanIntegerPoint next = it.next();
            while (i5 < length) {
                iArr[i5] = iArr[i5] + next.getPoint()[i5];
                i5++;
            }
        }
        while (i5 < length) {
            iArr[i5] = iArr[i5] / collection.size();
            i5++;
        }
        return new EuclideanIntegerPoint(iArr);
    }

    @Override // org.apache.commons.math3.stat.clustering.Clusterable
    public double distanceFrom(EuclideanIntegerPoint euclideanIntegerPoint) {
        return MathArrays.distance(this.point, euclideanIntegerPoint.getPoint());
    }
}

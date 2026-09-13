package org.apache.commons.math3.ml.clustering;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DoublePoint implements Clusterable, Serializable {
    private static final long serialVersionUID = 3946024775784901369L;
    private final double[] point;

    public DoublePoint(double[] dArr) {
        this.point = dArr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DoublePoint) {
            return Arrays.equals(this.point, ((DoublePoint) obj).point);
        }
        return false;
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterable
    public double[] getPoint() {
        return this.point;
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }

    public DoublePoint(int[] iArr) {
        this.point = new double[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.point[i5] = iArr[i5];
        }
    }
}

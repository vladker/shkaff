package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class VectorialMean implements Serializable {
    private static final long serialVersionUID = 8223009086481006892L;
    private final Mean[] means;

    public VectorialMean(int i5) {
        this.means = new Mean[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            this.means[i6] = new Mean();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VectorialMean) && Arrays.equals(this.means, ((VectorialMean) obj).means);
    }

    public long getN() {
        Mean[] meanArr = this.means;
        if (meanArr.length == 0) {
            return 0L;
        }
        return meanArr[0].getN();
    }

    public double[] getResult() {
        int length = this.means.length;
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = this.means[i5].getResult();
        }
        return dArr;
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.means);
    }

    public void increment(double[] dArr) {
        if (dArr.length != this.means.length) {
            throw new DimensionMismatchException(dArr.length, this.means.length);
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            this.means[i5].increment(dArr[i5]);
        }
    }
}

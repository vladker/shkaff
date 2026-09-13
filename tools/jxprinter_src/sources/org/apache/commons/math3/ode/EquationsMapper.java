package org.apache.commons.math3.ode;

import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EquationsMapper implements Serializable {
    private static final long serialVersionUID = 20110925;
    private final int dimension;
    private final int firstIndex;

    public EquationsMapper(int i5, int i6) {
        this.firstIndex = i5;
        this.dimension = i6;
    }

    public void extractEquationData(double[] dArr, double[] dArr2) {
        int length = dArr2.length;
        int i5 = this.dimension;
        if (length != i5) {
            throw new DimensionMismatchException(dArr2.length, this.dimension);
        }
        System.arraycopy(dArr, this.firstIndex, dArr2, 0, i5);
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public void insertEquationData(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        int i5 = this.dimension;
        if (length != i5) {
            throw new DimensionMismatchException(dArr.length, this.dimension);
        }
        System.arraycopy(dArr, 0, dArr2, this.firstIndex, i5);
    }
}

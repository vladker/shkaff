package org.apache.commons.math3.linear;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RealLinearOperator {
    public abstract int getColumnDimension();

    public abstract int getRowDimension();

    public boolean isTransposable() {
        return false;
    }

    public abstract RealVector operate(RealVector realVector);

    public RealVector operateTranspose(RealVector realVector) {
        throw new UnsupportedOperationException();
    }
}

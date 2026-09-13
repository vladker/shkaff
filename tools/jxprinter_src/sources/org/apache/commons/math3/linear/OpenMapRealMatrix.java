package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OpenMapRealMatrix extends AbstractRealMatrix implements SparseRealMatrix, Serializable {
    private static final long serialVersionUID = -5962461716457143437L;
    private final int columns;
    private final OpenIntToDoubleHashMap entries;
    private final int rows;

    public OpenMapRealMatrix(int i5, int i6) {
        super(i5, i6);
        long j6 = ((long) i5) * ((long) i6);
        if (j6 >= 2147483647L) {
            throw new NumberIsTooLargeException(Long.valueOf(j6), Integer.MAX_VALUE, false);
        }
        this.rows = i5;
        this.columns = i6;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
    }

    private int computeKey(int i5, int i6) {
        return (i5 * this.columns) + i6;
    }

    public OpenMapRealMatrix add(OpenMapRealMatrix openMapRealMatrix) {
        MatrixUtils.checkAdditionCompatible(this, openMapRealMatrix);
        OpenMapRealMatrix openMapRealMatrix2 = new OpenMapRealMatrix(this);
        OpenIntToDoubleHashMap.Iterator it = openMapRealMatrix.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key() / this.columns;
            int iKey2 = it.key() - (this.columns * iKey);
            openMapRealMatrix2.setEntry(iKey, iKey2, it.value() + getEntry(iKey, iKey2));
        }
        return openMapRealMatrix2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int i5, int i6, double d) {
        MatrixUtils.checkRowIndex(this, i5);
        MatrixUtils.checkColumnIndex(this, i6);
        int iComputeKey = computeKey(i5, i6);
        double d6 = this.entries.get(iComputeKey) + d;
        if (d6 == 0.0d) {
            this.entries.remove(iComputeKey);
        } else {
            this.entries.put(iComputeKey, d6);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i5, int i6) {
        MatrixUtils.checkRowIndex(this, i5);
        MatrixUtils.checkColumnIndex(this, i6);
        return this.entries.get(computeKey(i5, i6));
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix realMatrix) {
        try {
            return multiply((OpenMapRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
            int columnDimension = realMatrix.getColumnDimension();
            BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, columnDimension);
            OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
            while (it.hasNext()) {
                it.advance();
                double dValue = it.value();
                int iKey = it.key();
                int i5 = this.columns;
                int i6 = iKey / i5;
                int i7 = iKey % i5;
                for (int i8 = 0; i8 < columnDimension; i8++) {
                    blockRealMatrix.addToEntry(i6, i8, realMatrix.getEntry(i7, i8) * dValue);
                }
            }
            return blockRealMatrix;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int i5, int i6, double d) {
        MatrixUtils.checkRowIndex(this, i5);
        MatrixUtils.checkColumnIndex(this, i6);
        int iComputeKey = computeKey(i5, i6);
        double d6 = this.entries.get(iComputeKey) * d;
        if (d6 == 0.0d) {
            this.entries.remove(iComputeKey);
        } else {
            this.entries.put(iComputeKey, d6);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i5, int i6, double d) {
        MatrixUtils.checkRowIndex(this, i5);
        MatrixUtils.checkColumnIndex(this, i6);
        if (d == 0.0d) {
            this.entries.remove(computeKey(i5, i6));
        } else {
            this.entries.put(computeKey(i5, i6), d);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public OpenMapRealMatrix copy() {
        return new OpenMapRealMatrix(this);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public OpenMapRealMatrix createMatrix(int i5, int i6) {
        return new OpenMapRealMatrix(i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public OpenMapRealMatrix subtract(RealMatrix realMatrix) {
        try {
            return subtract((OpenMapRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            return (OpenMapRealMatrix) super.subtract(realMatrix);
        }
    }

    public OpenMapRealMatrix subtract(OpenMapRealMatrix openMapRealMatrix) {
        MatrixUtils.checkAdditionCompatible(this, openMapRealMatrix);
        OpenMapRealMatrix openMapRealMatrix2 = new OpenMapRealMatrix(this);
        OpenIntToDoubleHashMap.Iterator it = openMapRealMatrix.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key() / this.columns;
            int iKey2 = it.key() - (this.columns * iKey);
            openMapRealMatrix2.setEntry(iKey, iKey2, getEntry(iKey, iKey2) - it.value());
        }
        return openMapRealMatrix2;
    }

    public OpenMapRealMatrix(OpenMapRealMatrix openMapRealMatrix) {
        this.rows = openMapRealMatrix.rows;
        this.columns = openMapRealMatrix.columns;
        this.entries = new OpenIntToDoubleHashMap(openMapRealMatrix.entries);
    }

    public OpenMapRealMatrix multiply(OpenMapRealMatrix openMapRealMatrix) {
        MatrixUtils.checkMultiplicationCompatible(this, openMapRealMatrix);
        int columnDimension = openMapRealMatrix.getColumnDimension();
        OpenMapRealMatrix openMapRealMatrix2 = new OpenMapRealMatrix(this.rows, columnDimension);
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            double dValue = it.value();
            int iKey = it.key();
            int i5 = this.columns;
            int i6 = iKey / i5;
            int i7 = iKey % i5;
            for (int i8 = 0; i8 < columnDimension; i8++) {
                int iComputeKey = openMapRealMatrix.computeKey(i7, i8);
                if (openMapRealMatrix.entries.containsKey(iComputeKey)) {
                    int iComputeKey2 = openMapRealMatrix2.computeKey(i6, i8);
                    double d = (openMapRealMatrix.entries.get(iComputeKey) * dValue) + openMapRealMatrix2.entries.get(iComputeKey2);
                    if (d == 0.0d) {
                        openMapRealMatrix2.entries.remove(iComputeKey2);
                    } else {
                        openMapRealMatrix2.entries.put(iComputeKey2, d);
                    }
                }
            }
        }
        return openMapRealMatrix2;
    }
}

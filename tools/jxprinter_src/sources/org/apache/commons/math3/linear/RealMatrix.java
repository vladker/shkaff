package org.apache.commons.math3.linear;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RealMatrix extends AnyMatrix {
    RealMatrix add(RealMatrix realMatrix);

    void addToEntry(int i5, int i6, double d);

    RealMatrix copy();

    void copySubMatrix(int i5, int i6, int i7, int i8, double[][] dArr);

    void copySubMatrix(int[] iArr, int[] iArr2, double[][] dArr);

    RealMatrix createMatrix(int i5, int i6);

    double[] getColumn(int i5);

    RealMatrix getColumnMatrix(int i5);

    RealVector getColumnVector(int i5);

    double[][] getData();

    double getEntry(int i5, int i6);

    double getFrobeniusNorm();

    double getNorm();

    double[] getRow(int i5);

    RealMatrix getRowMatrix(int i5);

    RealVector getRowVector(int i5);

    RealMatrix getSubMatrix(int i5, int i6, int i7, int i8);

    RealMatrix getSubMatrix(int[] iArr, int[] iArr2);

    double getTrace();

    RealMatrix multiply(RealMatrix realMatrix);

    void multiplyEntry(int i5, int i6, double d);

    RealVector operate(RealVector realVector);

    double[] operate(double[] dArr);

    RealMatrix power(int i5);

    RealMatrix preMultiply(RealMatrix realMatrix);

    RealVector preMultiply(RealVector realVector);

    double[] preMultiply(double[] dArr);

    RealMatrix scalarAdd(double d);

    RealMatrix scalarMultiply(double d);

    void setColumn(int i5, double[] dArr);

    void setColumnMatrix(int i5, RealMatrix realMatrix);

    void setColumnVector(int i5, RealVector realVector);

    void setEntry(int i5, int i6, double d);

    void setRow(int i5, double[] dArr);

    void setRowMatrix(int i5, RealMatrix realMatrix);

    void setRowVector(int i5, RealVector realVector);

    void setSubMatrix(double[][] dArr, int i5, int i6);

    RealMatrix subtract(RealMatrix realMatrix);

    RealMatrix transpose();

    double walkInColumnOrder(RealMatrixChangingVisitor realMatrixChangingVisitor);

    double walkInColumnOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8);

    double walkInColumnOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor);

    double walkInColumnOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8);

    double walkInOptimizedOrder(RealMatrixChangingVisitor realMatrixChangingVisitor);

    double walkInOptimizedOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8);

    double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor);

    double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8);

    double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor);

    double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8);

    double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor);

    double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8);
}

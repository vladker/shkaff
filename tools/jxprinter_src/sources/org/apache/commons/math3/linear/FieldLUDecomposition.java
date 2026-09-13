package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldLUDecomposition<T extends FieldElement<T>> {
    private FieldMatrix<T> cachedL;
    private FieldMatrix<T> cachedP;
    private FieldMatrix<T> cachedU;
    private boolean even;
    private final Field<T> field;
    private T[][] lu;
    private int[] pivot;
    private boolean singular;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver<T extends FieldElement<T>> implements FieldDecompositionSolver<T> {
        private final Field<T> field;
        private final T[][] lu;
        private final int[] pivot;
        private final boolean singular;

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public FieldMatrix<T> getInverse() {
            int length = this.pivot.length;
            T one = this.field.getOne();
            Array2DRowFieldMatrix array2DRowFieldMatrix = new Array2DRowFieldMatrix(this.field, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                array2DRowFieldMatrix.setEntry(i5, i5, one);
            }
            return solve(array2DRowFieldMatrix);
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public boolean isNonSingular() {
            return !this.singular;
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public FieldVector<T> solve(FieldVector<T> fieldVector) {
            try {
                return solve((ArrayFieldVector) fieldVector);
            } catch (ClassCastException unused) {
                int length = this.pivot.length;
                if (fieldVector.getDimension() != length) {
                    throw new DimensionMismatchException(fieldVector.getDimension(), length);
                }
                if (this.singular) {
                    throw new SingularMatrixException();
                }
                FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, length);
                for (int i5 = 0; i5 < length; i5++) {
                    fieldElementArr[i5] = fieldVector.getEntry(this.pivot[i5]);
                }
                int i6 = 0;
                while (i6 < length) {
                    FieldElement fieldElement = fieldElementArr[i6];
                    int i7 = i6 + 1;
                    for (int i8 = i7; i8 < length; i8++) {
                        fieldElementArr[i8] = (FieldElement) fieldElementArr[i8].subtract(fieldElement.multiply(this.lu[i8][i6]));
                    }
                    i6 = i7;
                }
                for (int i9 = length - 1; i9 >= 0; i9--) {
                    FieldElement fieldElement2 = (FieldElement) fieldElementArr[i9].divide(this.lu[i9][i9]);
                    fieldElementArr[i9] = fieldElement2;
                    for (int i10 = 0; i10 < i9; i10++) {
                        fieldElementArr[i10] = (FieldElement) fieldElementArr[i10].subtract(fieldElement2.multiply(this.lu[i10][i9]));
                    }
                }
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
        }

        private Solver(Field<T> field, T[][] tArr, int[] iArr, boolean z6) {
            this.field = field;
            this.lu = tArr;
            this.pivot = iArr;
            this.singular = z6;
        }

        public ArrayFieldVector<T> solve(ArrayFieldVector<T> arrayFieldVector) {
            int length = this.pivot.length;
            int dimension = arrayFieldVector.getDimension();
            if (dimension == length) {
                if (!this.singular) {
                    FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, length);
                    for (int i5 = 0; i5 < length; i5++) {
                        fieldElementArr[i5] = arrayFieldVector.getEntry(this.pivot[i5]);
                    }
                    int i6 = 0;
                    while (i6 < length) {
                        FieldElement fieldElement = fieldElementArr[i6];
                        int i7 = i6 + 1;
                        for (int i8 = i7; i8 < length; i8++) {
                            fieldElementArr[i8] = (FieldElement) fieldElementArr[i8].subtract(fieldElement.multiply(this.lu[i8][i6]));
                        }
                        i6 = i7;
                    }
                    for (int i9 = length - 1; i9 >= 0; i9--) {
                        FieldElement fieldElement2 = (FieldElement) fieldElementArr[i9].divide(this.lu[i9][i9]);
                        fieldElementArr[i9] = fieldElement2;
                        for (int i10 = 0; i10 < i9; i10++) {
                            fieldElementArr[i10] = (FieldElement) fieldElementArr[i10].subtract(fieldElement2.multiply(this.lu[i10][i9]));
                        }
                    }
                    return new ArrayFieldVector<>(fieldElementArr, false);
                }
                throw new SingularMatrixException();
            }
            throw new DimensionMismatchException(dimension, length);
        }

        @Override // org.apache.commons.math3.linear.FieldDecompositionSolver
        public FieldMatrix<T> solve(FieldMatrix<T> fieldMatrix) {
            int length = this.pivot.length;
            if (fieldMatrix.getRowDimension() == length) {
                if (!this.singular) {
                    int columnDimension = fieldMatrix.getColumnDimension();
                    FieldElement[][] fieldElementArr = (FieldElement[][]) MathArrays.buildArray(this.field, length, columnDimension);
                    for (int i5 = 0; i5 < length; i5++) {
                        FieldElement[] fieldElementArr2 = fieldElementArr[i5];
                        int i6 = this.pivot[i5];
                        for (int i7 = 0; i7 < columnDimension; i7++) {
                            fieldElementArr2[i7] = fieldMatrix.getEntry(i6, i7);
                        }
                    }
                    int i8 = 0;
                    while (i8 < length) {
                        FieldElement[] fieldElementArr3 = fieldElementArr[i8];
                        int i9 = i8 + 1;
                        for (int i10 = i9; i10 < length; i10++) {
                            FieldElement[] fieldElementArr4 = fieldElementArr[i10];
                            T t6 = this.lu[i10][i8];
                            for (int i11 = 0; i11 < columnDimension; i11++) {
                                fieldElementArr4[i11] = (FieldElement) fieldElementArr4[i11].subtract(fieldElementArr3[i11].multiply(t6));
                            }
                        }
                        i8 = i9;
                    }
                    for (int i12 = length - 1; i12 >= 0; i12--) {
                        FieldElement[] fieldElementArr5 = fieldElementArr[i12];
                        T t7 = this.lu[i12][i12];
                        for (int i13 = 0; i13 < columnDimension; i13++) {
                            fieldElementArr5[i13] = (FieldElement) fieldElementArr5[i13].divide(t7);
                        }
                        for (int i14 = 0; i14 < i12; i14++) {
                            FieldElement[] fieldElementArr6 = fieldElementArr[i14];
                            T t8 = this.lu[i14][i12];
                            for (int i15 = 0; i15 < columnDimension; i15++) {
                                fieldElementArr6[i15] = (FieldElement) fieldElementArr6[i15].subtract(fieldElementArr5[i15].multiply(t8));
                            }
                        }
                    }
                    return new Array2DRowFieldMatrix((Field) this.field, fieldElementArr, false);
                }
                throw new SingularMatrixException();
            }
            throw new DimensionMismatchException(fieldMatrix.getRowDimension(), length);
        }
    }

    public FieldLUDecomposition(FieldMatrix<T> fieldMatrix) {
        if (!fieldMatrix.isSquare()) {
            throw new NonSquareMatrixException(fieldMatrix.getRowDimension(), fieldMatrix.getColumnDimension());
        }
        int columnDimension = fieldMatrix.getColumnDimension();
        this.field = fieldMatrix.getField();
        this.lu = (T[][]) fieldMatrix.getData();
        this.pivot = new int[columnDimension];
        this.cachedL = null;
        this.cachedU = null;
        this.cachedP = null;
        for (int i5 = 0; i5 < columnDimension; i5++) {
            this.pivot[i5] = i5;
        }
        this.even = true;
        this.singular = false;
        int i6 = 0;
        while (i6 < columnDimension) {
            this.field.getZero();
            for (int i7 = 0; i7 < i6; i7++) {
                FieldElement[] fieldElementArr = this.lu[i7];
                FieldElement fieldElement = fieldElementArr[i6];
                for (int i8 = 0; i8 < i7; i8++) {
                    fieldElement = (FieldElement) fieldElement.subtract(fieldElementArr[i8].multiply(this.lu[i8][i6]));
                }
                fieldElementArr[i6] = fieldElement;
            }
            int i9 = i6;
            int i10 = i9;
            while (i9 < columnDimension) {
                FieldElement[] fieldElementArr2 = this.lu[i9];
                FieldElement fieldElement2 = fieldElementArr2[i6];
                for (int i11 = 0; i11 < i6; i11++) {
                    fieldElement2 = (FieldElement) fieldElement2.subtract(fieldElementArr2[i11].multiply(this.lu[i11][i6]));
                }
                fieldElementArr2[i6] = fieldElement2;
                if (this.lu[i10][i6].equals(this.field.getZero())) {
                    i10++;
                }
                i9++;
            }
            if (i10 >= columnDimension) {
                this.singular = true;
                return;
            }
            if (i10 != i6) {
                this.field.getZero();
                for (int i12 = 0; i12 < columnDimension; i12++) {
                    T[][] tArr = this.lu;
                    T[] tArr2 = tArr[i10];
                    T t6 = tArr2[i12];
                    tArr2[i12] = tArr[i6][i12];
                    tArr[i6][i12] = t6;
                }
                int[] iArr = this.pivot;
                int i13 = iArr[i10];
                iArr[i10] = iArr[i6];
                iArr[i6] = i13;
                this.even = !this.even;
            }
            T t7 = this.lu[i6][i6];
            int i14 = i6 + 1;
            for (int i15 = i14; i15 < columnDimension; i15++) {
                FieldElement[] fieldElementArr3 = this.lu[i15];
                fieldElementArr3[i6] = (FieldElement) fieldElementArr3[i6].divide(t7);
            }
            i6 = i14;
        }
    }

    public T getDeterminant() {
        if (this.singular) {
            return this.field.getZero();
        }
        int length = this.pivot.length;
        T t6 = (T) (this.even ? this.field.getOne() : this.field.getZero().subtract(this.field.getOne()));
        for (int i5 = 0; i5 < length; i5++) {
            t6 = (T) t6.multiply(this.lu[i5][i5]);
        }
        return t6;
    }

    public FieldMatrix<T> getL() {
        if (this.cachedL == null && !this.singular) {
            int length = this.pivot.length;
            this.cachedL = new Array2DRowFieldMatrix(this.field, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                T[] tArr = this.lu[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    this.cachedL.setEntry(i5, i6, tArr[i6]);
                }
                this.cachedL.setEntry(i5, i5, this.field.getOne());
            }
        }
        return this.cachedL;
    }

    public FieldMatrix<T> getP() {
        if (this.cachedP == null && !this.singular) {
            int length = this.pivot.length;
            this.cachedP = new Array2DRowFieldMatrix(this.field, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                this.cachedP.setEntry(i5, this.pivot[i5], this.field.getOne());
            }
        }
        return this.cachedP;
    }

    public int[] getPivot() {
        return (int[]) this.pivot.clone();
    }

    public FieldDecompositionSolver<T> getSolver() {
        return new Solver(this.field, this.lu, this.pivot, this.singular);
    }

    public FieldMatrix<T> getU() {
        if (this.cachedU == null && !this.singular) {
            int length = this.pivot.length;
            this.cachedU = new Array2DRowFieldMatrix(this.field, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                T[] tArr = this.lu[i5];
                for (int i6 = i5; i6 < length; i6++) {
                    this.cachedU.setEntry(i5, i6, tArr[i6]);
                }
            }
        }
        return this.cachedU;
    }
}

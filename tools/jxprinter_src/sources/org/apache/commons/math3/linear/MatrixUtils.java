package org.apache.commons.math3.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MatrixUtils {
    public static final RealMatrixFormat DEFAULT_FORMAT = RealMatrixFormat.getInstance();
    public static final RealMatrixFormat OCTAVE_FORMAT = new RealMatrixFormat("[", "]", "", "", VectorFormat.DEFAULT_SEPARATOR, ", ");

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BigFractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<BigFraction> {
        private double[][] data;

        public BigFractionMatrixConverter() {
            super(BigFraction.ZERO);
        }

        public Array2DRowRealMatrix getConvertedMatrix() {
            return new Array2DRowRealMatrix(this.data, false);
        }

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
            this.data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        }

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void visit(int i5, int i6, BigFraction bigFraction) {
            this.data[i5][i6] = bigFraction.doubleValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FractionMatrixConverter extends DefaultFieldMatrixPreservingVisitor<Fraction> {
        private double[][] data;

        public FractionMatrixConverter() {
            super(Fraction.ZERO);
        }

        public Array2DRowRealMatrix getConvertedMatrix() {
            return new Array2DRowRealMatrix(this.data, false);
        }

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
            this.data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
        }

        @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
        public void visit(int i5, int i6, Fraction fraction) {
            this.data[i5][i6] = fraction.doubleValue();
        }
    }

    private MatrixUtils() {
    }

    public static Array2DRowRealMatrix bigFractionMatrixToRealMatrix(FieldMatrix<BigFraction> fieldMatrix) {
        BigFractionMatrixConverter bigFractionMatrixConverter = new BigFractionMatrixConverter();
        fieldMatrix.walkInOptimizedOrder(bigFractionMatrixConverter);
        return bigFractionMatrixConverter.getConvertedMatrix();
    }

    public static RealMatrix blockInverse(RealMatrix realMatrix, int i5) {
        int rowDimension = realMatrix.getRowDimension();
        if (realMatrix.getColumnDimension() != rowDimension) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int i6 = i5 + 1;
        RealMatrix subMatrix = realMatrix.getSubMatrix(0, i5, 0, i5);
        int i7 = rowDimension - 1;
        RealMatrix subMatrix2 = realMatrix.getSubMatrix(0, i5, i6, i7);
        RealMatrix subMatrix3 = realMatrix.getSubMatrix(i6, i7, 0, i5);
        RealMatrix subMatrix4 = realMatrix.getSubMatrix(i6, i7, i6, i7);
        DecompositionSolver solver = new SingularValueDecomposition(subMatrix).getSolver();
        if (!solver.isNonSingular()) {
            throw new SingularMatrixException();
        }
        RealMatrix inverse = solver.getInverse();
        DecompositionSolver solver2 = new SingularValueDecomposition(subMatrix4).getSolver();
        if (!solver2.isNonSingular()) {
            throw new SingularMatrixException();
        }
        RealMatrix inverse2 = solver2.getInverse();
        DecompositionSolver solver3 = new SingularValueDecomposition(subMatrix.subtract(subMatrix2.multiply(inverse2).multiply(subMatrix3))).getSolver();
        if (!solver3.isNonSingular()) {
            throw new SingularMatrixException();
        }
        RealMatrix inverse3 = solver3.getInverse();
        DecompositionSolver solver4 = new SingularValueDecomposition(subMatrix4.subtract(subMatrix3.multiply(inverse).multiply(subMatrix2))).getSolver();
        if (!solver4.isNonSingular()) {
            throw new SingularMatrixException();
        }
        RealMatrix inverse4 = solver4.getInverse();
        RealMatrix realMatrixScalarMultiply = inverse.multiply(subMatrix2).multiply(inverse4).scalarMultiply(-1.0d);
        RealMatrix realMatrixScalarMultiply2 = inverse2.multiply(subMatrix3).multiply(inverse3).scalarMultiply(-1.0d);
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(rowDimension, rowDimension);
        array2DRowRealMatrix.setSubMatrix(inverse3.getData(), 0, 0);
        array2DRowRealMatrix.setSubMatrix(realMatrixScalarMultiply.getData(), 0, i6);
        array2DRowRealMatrix.setSubMatrix(realMatrixScalarMultiply2.getData(), i6, 0);
        array2DRowRealMatrix.setSubMatrix(inverse4.getData(), i6, i6);
        return array2DRowRealMatrix;
    }

    public static void checkAdditionCompatible(AnyMatrix anyMatrix, AnyMatrix anyMatrix2) {
        if (anyMatrix.getRowDimension() != anyMatrix2.getRowDimension() || anyMatrix.getColumnDimension() != anyMatrix2.getColumnDimension()) {
            throw new MatrixDimensionMismatchException(anyMatrix.getRowDimension(), anyMatrix.getColumnDimension(), anyMatrix2.getRowDimension(), anyMatrix2.getColumnDimension());
        }
    }

    public static void checkColumnIndex(AnyMatrix anyMatrix, int i5) {
        if (i5 < 0 || i5 >= anyMatrix.getColumnDimension()) {
            throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(i5), 0, Integer.valueOf(anyMatrix.getColumnDimension() - 1));
        }
    }

    public static void checkMatrixIndex(AnyMatrix anyMatrix, int i5, int i6) {
        checkRowIndex(anyMatrix, i5);
        checkColumnIndex(anyMatrix, i6);
    }

    public static void checkMultiplicationCompatible(AnyMatrix anyMatrix, AnyMatrix anyMatrix2) {
        if (anyMatrix.getColumnDimension() != anyMatrix2.getRowDimension()) {
            throw new DimensionMismatchException(anyMatrix.getColumnDimension(), anyMatrix2.getRowDimension());
        }
    }

    public static void checkRowIndex(AnyMatrix anyMatrix, int i5) {
        if (i5 < 0 || i5 >= anyMatrix.getRowDimension()) {
            throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(i5), 0, Integer.valueOf(anyMatrix.getRowDimension() - 1));
        }
    }

    public static void checkSubMatrixIndex(AnyMatrix anyMatrix, int i5, int i6, int i7, int i8) {
        checkRowIndex(anyMatrix, i5);
        checkRowIndex(anyMatrix, i6);
        if (i6 < i5) {
            throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(i6), Integer.valueOf(i5), false);
        }
        checkColumnIndex(anyMatrix, i7);
        checkColumnIndex(anyMatrix, i8);
        if (i8 < i7) {
            throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(i8), Integer.valueOf(i7), false);
        }
    }

    public static void checkSubtractionCompatible(AnyMatrix anyMatrix, AnyMatrix anyMatrix2) {
        if (anyMatrix.getRowDimension() != anyMatrix2.getRowDimension() || anyMatrix.getColumnDimension() != anyMatrix2.getColumnDimension()) {
            throw new MatrixDimensionMismatchException(anyMatrix.getRowDimension(), anyMatrix.getColumnDimension(), anyMatrix2.getRowDimension(), anyMatrix2.getColumnDimension());
        }
    }

    public static void checkSymmetric(RealMatrix realMatrix, double d) {
        isSymmetricInternal(realMatrix, d, true);
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createColumnFieldMatrix(T[] tArr) {
        if (tArr == null) {
            throw new NullArgumentException();
        }
        int length = tArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        FieldMatrix<T> fieldMatrixCreateFieldMatrix = createFieldMatrix(tArr[0].getField(), length, 1);
        for (int i5 = 0; i5 < length; i5++) {
            fieldMatrixCreateFieldMatrix.setEntry(i5, 0, tArr[i5]);
        }
        return fieldMatrixCreateFieldMatrix;
    }

    public static RealMatrix createColumnRealMatrix(double[] dArr) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        int length = dArr.length;
        RealMatrix realMatrixCreateRealMatrix = createRealMatrix(length, 1);
        for (int i5 = 0; i5 < length; i5++) {
            realMatrixCreateRealMatrix.setEntry(i5, 0, dArr[i5]);
        }
        return realMatrixCreateRealMatrix;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldDiagonalMatrix(T[] tArr) {
        FieldMatrix<T> fieldMatrixCreateFieldMatrix = createFieldMatrix(tArr[0].getField(), tArr.length, tArr.length);
        for (int i5 = 0; i5 < tArr.length; i5++) {
            fieldMatrixCreateFieldMatrix.setEntry(i5, i5, tArr[i5]);
        }
        return fieldMatrixCreateFieldMatrix;
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldIdentityMatrix(Field<T> field, int i5) {
        T zero = field.getZero();
        T one = field.getOne();
        FieldElement[][] fieldElementArr = (FieldElement[][]) MathArrays.buildArray(field, i5, i5);
        for (int i6 = 0; i6 < i5; i6++) {
            FieldElement[] fieldElementArr2 = fieldElementArr[i6];
            Arrays.fill(fieldElementArr2, zero);
            fieldElementArr2[i6] = one;
        }
        return new Array2DRowFieldMatrix((Field) field, fieldElementArr, false);
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(Field<T> field, int i5, int i6) {
        return i5 * i6 <= 4096 ? new Array2DRowFieldMatrix(field, i5, i6) : new BlockFieldMatrix(field, i5, i6);
    }

    public static <T extends FieldElement<T>> FieldVector<T> createFieldVector(T[] tArr) {
        if (tArr == null) {
            throw new NullArgumentException();
        }
        if (tArr.length != 0) {
            return new ArrayFieldVector(tArr[0].getField(), (FieldElement[]) tArr, true);
        }
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public static RealMatrix createRealDiagonalMatrix(double[] dArr) {
        RealMatrix realMatrixCreateRealMatrix = createRealMatrix(dArr.length, dArr.length);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            realMatrixCreateRealMatrix.setEntry(i5, i5, dArr[i5]);
        }
        return realMatrixCreateRealMatrix;
    }

    public static RealMatrix createRealIdentityMatrix(int i5) {
        RealMatrix realMatrixCreateRealMatrix = createRealMatrix(i5, i5);
        for (int i6 = 0; i6 < i5; i6++) {
            realMatrixCreateRealMatrix.setEntry(i6, i6, 1.0d);
        }
        return realMatrixCreateRealMatrix;
    }

    public static RealMatrix createRealMatrix(int i5, int i6) {
        return i5 * i6 <= 4096 ? new Array2DRowRealMatrix(i5, i6) : new BlockRealMatrix(i5, i6);
    }

    public static RealVector createRealVector(double[] dArr) {
        if (dArr != null) {
            return new ArrayRealVector(dArr, true);
        }
        throw new NullArgumentException();
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createRowFieldMatrix(T[] tArr) {
        if (tArr == null) {
            throw new NullArgumentException();
        }
        int length = tArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        FieldMatrix<T> fieldMatrixCreateFieldMatrix = createFieldMatrix(tArr[0].getField(), 1, length);
        for (int i5 = 0; i5 < length; i5++) {
            fieldMatrixCreateFieldMatrix.setEntry(0, i5, tArr[i5]);
        }
        return fieldMatrixCreateFieldMatrix;
    }

    public static RealMatrix createRowRealMatrix(double[] dArr) {
        if (dArr == null) {
            throw new NullArgumentException();
        }
        int length = dArr.length;
        RealMatrix realMatrixCreateRealMatrix = createRealMatrix(1, length);
        for (int i5 = 0; i5 < length; i5++) {
            realMatrixCreateRealMatrix.setEntry(0, i5, dArr[i5]);
        }
        return realMatrixCreateRealMatrix;
    }

    public static void deserializeRealMatrix(Object obj, String str, ObjectInputStream objectInputStream) throws IOException {
        try {
            int i5 = objectInputStream.readInt();
            int i6 = objectInputStream.readInt();
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
            for (int i7 = 0; i7 < i5; i7++) {
                double[] dArr2 = dArr[i7];
                for (int i8 = 0; i8 < i6; i8++) {
                    dArr2[i8] = objectInputStream.readDouble();
                }
            }
            Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(dArr, false);
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, array2DRowRealMatrix);
        } catch (IllegalAccessException e) {
            IOException iOException = new IOException();
            iOException.initCause(e);
            throw iOException;
        } catch (NoSuchFieldException e6) {
            IOException iOException2 = new IOException();
            iOException2.initCause(e6);
            throw iOException2;
        }
    }

    public static void deserializeRealVector(Object obj, String str, ObjectInputStream objectInputStream) throws IOException {
        try {
            int i5 = objectInputStream.readInt();
            double[] dArr = new double[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                dArr[i6] = objectInputStream.readDouble();
            }
            ArrayRealVector arrayRealVector = new ArrayRealVector(dArr, false);
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, arrayRealVector);
        } catch (IllegalAccessException e) {
            IOException iOException = new IOException();
            iOException.initCause(e);
            throw iOException;
        } catch (NoSuchFieldException e6) {
            IOException iOException2 = new IOException();
            iOException2.initCause(e6);
            throw iOException2;
        }
    }

    public static Array2DRowRealMatrix fractionMatrixToRealMatrix(FieldMatrix<Fraction> fieldMatrix) {
        FractionMatrixConverter fractionMatrixConverter = new FractionMatrixConverter();
        fieldMatrix.walkInOptimizedOrder(fractionMatrixConverter);
        return fractionMatrixConverter.getConvertedMatrix();
    }

    public static RealMatrix inverse(RealMatrix realMatrix) {
        return inverse(realMatrix, 0.0d);
    }

    public static boolean isSymmetric(RealMatrix realMatrix, double d) {
        return isSymmetricInternal(realMatrix, d, false);
    }

    private static boolean isSymmetricInternal(RealMatrix realMatrix, double d, boolean z6) {
        int rowDimension = realMatrix.getRowDimension();
        if (rowDimension != realMatrix.getColumnDimension()) {
            if (z6) {
                throw new NonSquareMatrixException(rowDimension, realMatrix.getColumnDimension());
            }
            return false;
        }
        int i5 = 0;
        while (i5 < rowDimension) {
            int i6 = i5 + 1;
            for (int i7 = i6; i7 < rowDimension; i7++) {
                double entry = realMatrix.getEntry(i5, i7);
                double entry2 = realMatrix.getEntry(i7, i5);
                if (FastMath.abs(entry - entry2) > FastMath.max(FastMath.abs(entry), FastMath.abs(entry2)) * d) {
                    if (z6) {
                        throw new NonSymmetricMatrixException(i5, i7, d);
                    }
                    return false;
                }
            }
            i5 = i6;
        }
        return true;
    }

    public static void serializeRealMatrix(RealMatrix realMatrix, ObjectOutputStream objectOutputStream) throws IOException {
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        objectOutputStream.writeInt(rowDimension);
        objectOutputStream.writeInt(columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                objectOutputStream.writeDouble(realMatrix.getEntry(i5, i6));
            }
        }
    }

    public static void serializeRealVector(RealVector realVector, ObjectOutputStream objectOutputStream) throws IOException {
        int dimension = realVector.getDimension();
        objectOutputStream.writeInt(dimension);
        for (int i5 = 0; i5 < dimension; i5++) {
            objectOutputStream.writeDouble(realVector.getEntry(i5));
        }
    }

    public static void solveLowerTriangularSystem(RealMatrix realMatrix, RealVector realVector) {
        if (realMatrix == null || realVector == null || realMatrix.getRowDimension() != realVector.getDimension()) {
            throw new DimensionMismatchException(realMatrix == null ? 0 : realMatrix.getRowDimension(), realVector != null ? realVector.getDimension() : 0);
        }
        if (realMatrix.getColumnDimension() != realMatrix.getRowDimension()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        int i5 = 0;
        while (i5 < rowDimension) {
            double entry = realMatrix.getEntry(i5, i5);
            if (FastMath.abs(entry) < Precision.SAFE_MIN) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
            }
            double entry2 = realVector.getEntry(i5) / entry;
            realVector.setEntry(i5, entry2);
            int i6 = i5 + 1;
            for (int i7 = i6; i7 < rowDimension; i7++) {
                realVector.setEntry(i7, realVector.getEntry(i7) - (realMatrix.getEntry(i7, i5) * entry2));
            }
            i5 = i6;
        }
    }

    public static void solveUpperTriangularSystem(RealMatrix realMatrix, RealVector realVector) {
        if (realMatrix == null || realVector == null || realMatrix.getRowDimension() != realVector.getDimension()) {
            throw new DimensionMismatchException(realMatrix == null ? 0 : realMatrix.getRowDimension(), realVector != null ? realVector.getDimension() : 0);
        }
        if (realMatrix.getColumnDimension() != realMatrix.getRowDimension()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        while (true) {
            rowDimension--;
            if (rowDimension <= -1) {
                return;
            }
            double entry = realMatrix.getEntry(rowDimension, rowDimension);
            if (FastMath.abs(entry) < Precision.SAFE_MIN) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
            }
            double entry2 = realVector.getEntry(rowDimension) / entry;
            realVector.setEntry(rowDimension, entry2);
            for (int i5 = rowDimension - 1; i5 > -1; i5--) {
                realVector.setEntry(i5, realVector.getEntry(i5) - (realMatrix.getEntry(i5, rowDimension) * entry2));
            }
        }
    }

    public static <T extends FieldElement<T>> FieldMatrix<T> createFieldMatrix(T[][] tArr) {
        T[] tArr2;
        if (tArr == null || (tArr2 = tArr[0]) == null) {
            throw new NullArgumentException();
        }
        return tArr.length * tArr2.length <= 4096 ? new Array2DRowFieldMatrix(tArr) : new BlockFieldMatrix(tArr);
    }

    public static RealMatrix createRealMatrix(double[][] dArr) {
        double[] dArr2;
        if (dArr == null || (dArr2 = dArr[0]) == null) {
            throw new NullArgumentException();
        }
        return dArr.length * dArr2.length <= 4096 ? new Array2DRowRealMatrix(dArr) : new BlockRealMatrix(dArr);
    }

    public static RealMatrix inverse(RealMatrix realMatrix, double d) {
        MathUtils.checkNotNull(realMatrix);
        if (realMatrix.isSquare()) {
            return realMatrix instanceof DiagonalMatrix ? ((DiagonalMatrix) realMatrix).inverse(d) : new QRDecomposition(realMatrix, d).getSolver().getInverse();
        }
        throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
    }

    public static void checkSubMatrixIndex(AnyMatrix anyMatrix, int[] iArr, int[] iArr2) {
        if (iArr == null) {
            throw new NullArgumentException();
        }
        if (iArr2 != null) {
            if (iArr.length != 0) {
                if (iArr2.length != 0) {
                    for (int i5 : iArr) {
                        checkRowIndex(anyMatrix, i5);
                    }
                    for (int i6 : iArr2) {
                        checkColumnIndex(anyMatrix, i6);
                    }
                    return;
                }
                throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY);
            }
            throw new NoDataException(LocalizedFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY);
        }
        throw new NullArgumentException();
    }
}

package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BlockFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    public static final int BLOCK_SIZE = 36;
    private static final long serialVersionUID = -4602336630143123183L;
    private final int blockColumns;
    private final int blockRows;
    private final T[][] blocks;
    private final int columns;
    private final int rows;

    public BlockFieldMatrix(Field<T> field, int i5, int i6) {
        super(field, i5, i6);
        this.rows = i5;
        this.columns = i6;
        this.blockRows = (i5 + 35) / 36;
        this.blockColumns = (i6 + 35) / 36;
        this.blocks = (T[][]) createBlocksLayout(field, i5, i6);
    }

    private int blockHeight(int i5) {
        if (i5 == this.blockRows - 1) {
            return this.rows - (i5 * 36);
        }
        return 36;
    }

    private int blockWidth(int i5) {
        if (i5 == this.blockColumns - 1) {
            return this.columns - (i5 * 36);
        }
        return 36;
    }

    private void copyBlockPart(T[] tArr, int i5, int i6, int i7, int i8, int i9, T[] tArr2, int i10, int i11, int i12) {
        int i13 = i9 - i8;
        int i14 = (i6 * i5) + i8;
        int i15 = (i11 * i10) + i12;
        while (i6 < i7) {
            System.arraycopy(tArr, i14, tArr2, i15, i13);
            i14 += i5;
            i15 += i10;
            i6++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FieldElement<T>> T[][] createBlocksLayout(Field<T> field, int i5, int i6) {
        int i7 = (i5 + 35) / 36;
        int i8 = (i6 + 35) / 36;
        T[][] tArr = (T[][]) ((FieldElement[][]) MathArrays.buildArray(field, i7 * i8, -1));
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = i10 * 36;
            int iMin = FastMath.min(i11 + 36, i5) - i11;
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = i12 * 36;
                tArr[i9] = (FieldElement[]) MathArrays.buildArray(field, (FastMath.min(i13 + 36, i6) - i13) * iMin);
                i9++;
            }
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FieldElement<T>> T[][] toBlocksLayout(T[][] tArr) {
        int length = tArr.length;
        int i5 = 0;
        int length2 = tArr[0].length;
        int i6 = (length + 35) / 36;
        int i7 = (length2 + 35) / 36;
        for (T[] tArr2 : tArr) {
            int length3 = tArr2.length;
            if (length3 != length2) {
                throw new DimensionMismatchException(length2, length3);
            }
        }
        Field fieldExtractField = AbstractFieldMatrix.extractField(tArr);
        T[][] tArr3 = (T[][]) ((FieldElement[][]) MathArrays.buildArray(fieldExtractField, i6 * i7, -1));
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = i8 * 36;
            int iMin = FastMath.min(i10 + 36, length);
            int i11 = iMin - i10;
            int i12 = i5;
            while (i12 < i7) {
                int i13 = i12 * 36;
                int iMin2 = FastMath.min(i13 + 36, length2) - i13;
                FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(fieldExtractField, i11 * iMin2);
                tArr3[i9] = fieldElementArr;
                int i14 = length;
                int i15 = i10;
                int i16 = 0;
                while (i15 < iMin) {
                    int i17 = i15;
                    System.arraycopy(tArr[i17], i13, fieldElementArr, i16, iMin2);
                    i16 += iMin2;
                    i15 = i17 + 1;
                }
                i9++;
                i12++;
                length = i14;
            }
            i8++;
            i5 = 0;
        }
        return tArr3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> fieldMatrix) {
        try {
            return add((BlockFieldMatrix) fieldMatrix);
        } catch (ClassCastException unused) {
            checkAdditionCompatible(fieldMatrix);
            BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), this.rows, this.columns);
            int i5 = 0;
            for (int i6 = 0; i6 < blockFieldMatrix.blockRows; i6++) {
                for (int i7 = 0; i7 < blockFieldMatrix.blockColumns; i7++) {
                    FieldElement[] fieldElementArr = ((T[][]) blockFieldMatrix.blocks)[i5];
                    T[] tArr = this.blocks[i5];
                    int i8 = i6 * 36;
                    int iMin = FastMath.min(i8 + 36, this.rows);
                    int i9 = i7 * 36;
                    int iMin2 = FastMath.min(i9 + 36, this.columns);
                    int i10 = 0;
                    while (i8 < iMin) {
                        for (int i11 = i9; i11 < iMin2; i11++) {
                            fieldElementArr[i10] = (FieldElement) tArr[i10].add(fieldMatrix.getEntry(i8, i11));
                            i10++;
                        }
                        i8++;
                    }
                    i5++;
                }
            }
            return blockFieldMatrix;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void addToEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        int i7 = i5 / 36;
        int i8 = i6 / 36;
        int iBlockWidth = (i6 - (i8 * 36)) + ((i5 - (i7 * 36)) * blockWidth(i8));
        FieldElement[] fieldElementArr = this.blocks[(i7 * this.blockColumns) + i8];
        fieldElementArr[iBlockWidth] = (FieldElement) fieldElementArr[iBlockWidth].add(t6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int i5 = 0;
        while (true) {
            T[][] tArr = this.blocks;
            if (i5 >= tArr.length) {
                return blockFieldMatrix;
            }
            T[] tArr2 = tArr[i5];
            System.arraycopy(tArr2, 0, blockFieldMatrix.blocks[i5], 0, tArr2.length);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int i5, int i6) {
        return new BlockFieldMatrix(getField(), i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] getColumn(int i5) {
        checkColumnIndex(i5);
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), this.rows));
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int iBlockWidth = blockWidth(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockRows; i9++) {
            int iBlockHeight = blockHeight(i9);
            T[] tArr2 = this.blocks[(this.blockColumns * i9) + i6];
            int i10 = 0;
            while (i10 < iBlockHeight) {
                tArr[i8] = tArr2[(i10 * iBlockWidth) + i7];
                i10++;
                i8++;
            }
        }
        return tArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getColumnMatrix(int i5) {
        checkColumnIndex(i5);
        BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), this.rows, 1);
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int iBlockWidth = blockWidth(i6);
        T[] tArr = blockFieldMatrix.blocks[0];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.blockRows; i10++) {
            int iBlockHeight = blockHeight(i10);
            T[] tArr2 = this.blocks[(this.blockColumns * i10) + i6];
            int i11 = 0;
            while (i11 < iBlockHeight) {
                if (i8 >= tArr.length) {
                    i9++;
                    tArr = blockFieldMatrix.blocks[i9];
                    i8 = 0;
                }
                tArr[i8] = tArr2[(i11 * iBlockWidth) + i7];
                i11++;
                i8++;
            }
        }
        return blockFieldMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getColumnVector(int i5) {
        checkColumnIndex(i5);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(getField(), this.rows);
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int iBlockWidth = blockWidth(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockRows; i9++) {
            int iBlockHeight = blockHeight(i9);
            T[] tArr = this.blocks[(this.blockColumns * i9) + i6];
            int i10 = 0;
            while (i10 < iBlockHeight) {
                fieldElementArr[i8] = tArr[(i10 * iBlockWidth) + i7];
                i10++;
                i8++;
            }
        }
        return new ArrayFieldVector((Field) getField(), fieldElementArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[][] getData() {
        T[][] tArr = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), getRowDimension(), getColumnDimension()));
        int i5 = this.columns - ((this.blockColumns - 1) * 36);
        for (int i6 = 0; i6 < this.blockRows; i6++) {
            int i7 = i6 * 36;
            int iMin = FastMath.min(i7 + 36, this.rows);
            int i8 = 0;
            int i9 = 0;
            while (i7 < iMin) {
                T[] tArr2 = tArr[i7];
                int i10 = this.blockColumns * i6;
                int i11 = 0;
                int i12 = 0;
                while (i11 < this.blockColumns - 1) {
                    System.arraycopy(this.blocks[i10], i8, tArr2, i12, 36);
                    i12 += 36;
                    i11++;
                    i10++;
                }
                System.arraycopy(this.blocks[i10], i9, tArr2, i12, i5);
                i8 += 36;
                i9 += i5;
                i7++;
            }
        }
        return tArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int i5, int i6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        int i7 = i5 / 36;
        int i8 = i6 / 36;
        return this.blocks[(i7 * this.blockColumns) + i8][(i6 - (i8 * 36)) + ((i5 - (i7 * 36)) * blockWidth(i8))];
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] getRow(int i5) {
        checkRowIndex(i5);
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), this.columns));
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockColumns; i9++) {
            int iBlockWidth = blockWidth(i9);
            System.arraycopy(this.blocks[(this.blockColumns * i6) + i9], i7 * iBlockWidth, tArr, i8, iBlockWidth);
            i8 += iBlockWidth;
        }
        return tArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getRowMatrix(int i5) {
        checkRowIndex(i5);
        BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), 1, this.columns);
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        T[] tArr = blockFieldMatrix.blocks[0];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.blockColumns; i10++) {
            int iBlockWidth = blockWidth(i10);
            T[] tArr2 = this.blocks[(this.blockColumns * i6) + i10];
            int length = tArr.length - i8;
            if (iBlockWidth > length) {
                int i11 = i7 * iBlockWidth;
                System.arraycopy(tArr2, i11, tArr, i8, length);
                i9++;
                tArr = blockFieldMatrix.blocks[i9];
                int i12 = iBlockWidth - length;
                System.arraycopy(tArr2, i11, tArr, 0, i12);
                i8 = i12;
            } else {
                System.arraycopy(tArr2, i7 * iBlockWidth, tArr, i8, iBlockWidth);
                i8 += iBlockWidth;
            }
        }
        return blockFieldMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getRowVector(int i5) {
        checkRowIndex(i5);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(getField(), this.columns);
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockColumns; i9++) {
            int iBlockWidth = blockWidth(i9);
            System.arraycopy(this.blocks[(this.blockColumns * i6) + i9], i7 * iBlockWidth, fieldElementArr, i8, iBlockWidth);
            i8 += iBlockWidth;
        }
        return new ArrayFieldVector((Field) getField(), fieldElementArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        BlockFieldMatrix<T> blockFieldMatrix = this;
        checkSubMatrixIndex(i5, i6, i7, i8);
        BlockFieldMatrix blockFieldMatrix2 = new BlockFieldMatrix(blockFieldMatrix.getField(), (i6 - i5) + 1, (i8 - i7) + 1);
        int i12 = i5 % 36;
        int i13 = i7 / 36;
        int i14 = i7 % 36;
        int i15 = i5 / 36;
        int i16 = 0;
        while (i16 < blockFieldMatrix2.blockRows) {
            int iBlockHeight = blockFieldMatrix2.blockHeight(i16);
            int i17 = i13;
            int i18 = 0;
            while (i18 < blockFieldMatrix2.blockColumns) {
                int iBlockWidth = blockFieldMatrix2.blockWidth(i18);
                T[] tArr = blockFieldMatrix2.blocks[(blockFieldMatrix2.blockColumns * i16) + i18];
                int i19 = (blockFieldMatrix.blockColumns * i15) + i17;
                int i20 = i17;
                int iBlockWidth2 = blockFieldMatrix.blockWidth(i20);
                int i21 = iBlockHeight + i12;
                int i22 = i21 - 36;
                int i23 = iBlockWidth + i14;
                int i24 = i23 - 36;
                if (i22 <= 0) {
                    i9 = i18;
                    i10 = i20;
                    int i25 = i12;
                    if (i24 > 0) {
                        int iBlockWidth3 = blockFieldMatrix.blockWidth(i10 + 1);
                        i12 = i25;
                        blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19], iBlockWidth2, i12, i21, i14, 36, tArr, iBlockWidth, 0, 0);
                        i11 = i14;
                        blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19 + 1], iBlockWidth3, i12, i21, 0, i24, tArr, iBlockWidth, 0, iBlockWidth - i24);
                        i14 = i11;
                    } else {
                        i12 = i25;
                        blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19], iBlockWidth2, i12, i21, i14, i23, tArr, iBlockWidth, 0, 0);
                    }
                } else if (i24 > 0) {
                    int iBlockWidth4 = blockFieldMatrix.blockWidth(i20 + 1);
                    i9 = i18;
                    i10 = i20;
                    blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19], iBlockWidth2, i12, 36, i14, 36, tArr, iBlockWidth, 0, 0);
                    i11 = i14;
                    int i26 = iBlockWidth - i24;
                    blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19 + 1], iBlockWidth4, i12, 36, 0, i24, tArr, iBlockWidth, 0, i26);
                    int i27 = iBlockHeight - i22;
                    blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19 + blockFieldMatrix.blockColumns], iBlockWidth2, 0, i22, i11, 36, tArr, iBlockWidth, i27, 0);
                    blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19 + blockFieldMatrix.blockColumns + 1], iBlockWidth4, 0, i22, 0, i24, tArr, iBlockWidth, i27, i26);
                    i12 = i12;
                    i14 = i11;
                } else {
                    i9 = i18;
                    i10 = i20;
                    blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19], iBlockWidth2, i12, 36, i14, i23, tArr, iBlockWidth, 0, 0);
                    blockFieldMatrix.copyBlockPart(blockFieldMatrix.blocks[i19 + blockFieldMatrix.blockColumns], iBlockWidth2, 0, i22, i14, i23, tArr, iBlockWidth, iBlockHeight - i22, 0);
                    i12 = i12;
                }
                i17 = i10 + 1;
                i18 = i9 + 1;
                blockFieldMatrix = this;
            }
            i15++;
            i16++;
            blockFieldMatrix = this;
        }
        return blockFieldMatrix2;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> fieldMatrix) {
        BlockFieldMatrix<T> blockFieldMatrix = this;
        try {
            return blockFieldMatrix.multiply((BlockFieldMatrix) fieldMatrix);
        } catch (ClassCastException unused) {
            checkMultiplicationCompatible(fieldMatrix);
            BlockFieldMatrix blockFieldMatrix2 = new BlockFieldMatrix(blockFieldMatrix.getField(), blockFieldMatrix.rows, fieldMatrix.getColumnDimension());
            T zero = blockFieldMatrix.getField().getZero();
            int i5 = 0;
            int i6 = 0;
            while (i5 < blockFieldMatrix2.blockRows) {
                int i7 = i5 * 36;
                int iMin = FastMath.min(i7 + 36, blockFieldMatrix.rows);
                int i8 = 0;
                while (i8 < blockFieldMatrix2.blockColumns) {
                    int i9 = i8 * 36;
                    int iMin2 = FastMath.min(i9 + 36, fieldMatrix.getColumnDimension());
                    FieldElement[] fieldElementArr = blockFieldMatrix2.blocks[i6];
                    int i10 = 0;
                    while (i10 < blockFieldMatrix.blockColumns) {
                        int iBlockWidth = blockFieldMatrix.blockWidth(i10);
                        T[] tArr = blockFieldMatrix.blocks[(blockFieldMatrix.blockColumns * i5) + i10];
                        int i11 = i10 * 36;
                        int i12 = i7;
                        int i13 = 0;
                        while (i12 < iMin) {
                            int i14 = (i12 - i7) * iBlockWidth;
                            int i15 = i12;
                            int i16 = i14 + iBlockWidth;
                            BlockFieldMatrix blockFieldMatrix3 = blockFieldMatrix2;
                            int i17 = i9;
                            while (i17 < iMin2) {
                                T t6 = zero;
                                T[] tArr2 = tArr;
                                int i18 = i5;
                                int i19 = i11;
                                FieldElement fieldElement = t6;
                                int i20 = i14;
                                while (i20 < i16) {
                                    fieldElement = (FieldElement) fieldElement.add(tArr2[i20].multiply(fieldMatrix.getEntry(i19, i17)));
                                    i19++;
                                    i20++;
                                    i16 = i16;
                                }
                                fieldElementArr[i13] = (FieldElement) fieldElementArr[i13].add(fieldElement);
                                i13++;
                                i17++;
                                zero = t6;
                                tArr = tArr2;
                                i5 = i18;
                                i16 = i16;
                            }
                            i12 = i15 + 1;
                            blockFieldMatrix2 = blockFieldMatrix3;
                        }
                        i10++;
                        blockFieldMatrix = this;
                    }
                    i6++;
                    i8++;
                    blockFieldMatrix = this;
                }
                i5++;
                blockFieldMatrix = this;
            }
            return blockFieldMatrix2;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void multiplyEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        int i7 = i5 / 36;
        int i8 = i6 / 36;
        int iBlockWidth = (i6 - (i8 * 36)) + ((i5 - (i7 * 36)) * blockWidth(i8));
        FieldElement[] fieldElementArr = this.blocks[(i7 * this.blockColumns) + i8];
        fieldElementArr[iBlockWidth] = (FieldElement) fieldElementArr[iBlockWidth].multiply(t6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] operate(T[] tArr) {
        if (tArr.length != this.columns) {
            throw new DimensionMismatchException(tArr.length, this.columns);
        }
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(getField(), this.rows);
        T zero = getField().getZero();
        for (int i5 = 0; i5 < this.blockRows; i5++) {
            int i6 = i5 * 36;
            int iMin = FastMath.min(i6 + 36, this.rows);
            int i7 = 0;
            while (true) {
                int i8 = this.blockColumns;
                if (i7 < i8) {
                    T[] tArr2 = this.blocks[(i8 * i5) + i7];
                    int i9 = i7 * 36;
                    int iMin2 = FastMath.min(i9 + 36, this.columns);
                    int i10 = i6;
                    int i11 = 0;
                    while (i10 < iMin) {
                        FieldElement fieldElement = zero;
                        int i12 = i9;
                        while (i12 < iMin2 - 3) {
                            fieldElement = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) fieldElement.add(tArr2[i11].multiply(tArr[i12]))).add(tArr2[i11 + 1].multiply(tArr[i12 + 1]))).add(tArr2[i11 + 2].multiply(tArr[i12 + 2]))).add(tArr2[i11 + 3].multiply(tArr[i12 + 3]));
                            i11 += 4;
                            i12 += 4;
                            fieldElementArr = fieldElementArr;
                        }
                        FieldElement[] fieldElementArr2 = fieldElementArr;
                        while (i12 < iMin2) {
                            fieldElement = (FieldElement) fieldElement.add(tArr2[i11].multiply(tArr[i12]));
                            i12++;
                            i11++;
                        }
                        fieldElementArr2[i10] = (FieldElement) fieldElementArr2[i10].add(fieldElement);
                        i10++;
                        fieldElementArr = fieldElementArr2;
                    }
                    i7++;
                }
            }
        }
        return (T[]) fieldElementArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] preMultiply(T[] tArr) {
        int i5;
        if (tArr.length != this.rows) {
            throw new DimensionMismatchException(tArr.length, this.rows);
        }
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(getField(), this.columns);
        T zero = getField().getZero();
        int i6 = 0;
        while (i6 < this.blockColumns) {
            int iBlockWidth = blockWidth(i6);
            int i7 = iBlockWidth + iBlockWidth;
            int i8 = i7 + iBlockWidth;
            int i9 = i8 + iBlockWidth;
            int i10 = i6 * 36;
            int iMin = FastMath.min(i10 + 36, this.columns);
            for (int i11 = 0; i11 < this.blockRows; i11++) {
                T[] tArr2 = this.blocks[(this.blockColumns * i11) + i6];
                int i12 = i11 * 36;
                int iMin2 = FastMath.min(i12 + 36, this.rows);
                int i13 = i10;
                while (i13 < iMin) {
                    int i14 = i13 - i10;
                    FieldElement[] fieldElementArr2 = fieldElementArr;
                    T t6 = zero;
                    int i15 = i12;
                    while (true) {
                        i5 = i6;
                        if (i15 >= iMin2 - 3) {
                            break;
                        }
                        int i16 = i15;
                        zero = (T) ((FieldElement) ((FieldElement) ((FieldElement) zero.add(tArr2[i14].multiply(tArr[i16]))).add(tArr2[i14 + iBlockWidth].multiply(tArr[i16 + 1]))).add(tArr2[i14 + i7].multiply(tArr[i16 + 2]))).add(tArr2[i14 + i8].multiply(tArr[i16 + 3]));
                        i14 += i9;
                        i15 = i16 + 4;
                        i6 = i5;
                    }
                    while (i15 < iMin2) {
                        zero = (T) zero.add(tArr2[i14].multiply(tArr[i15]));
                        i14 += iBlockWidth;
                        i15++;
                    }
                    fieldElementArr2[i13] = (FieldElement) fieldElementArr2[i13].add(zero);
                    i13++;
                    fieldElementArr = fieldElementArr2;
                    zero = t6;
                    i6 = i5;
                }
            }
            i6++;
        }
        return (T[]) fieldElementArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarAdd(T t6) {
        BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int i5 = 0;
        while (true) {
            FieldElement[][] fieldElementArr = (T[][]) blockFieldMatrix.blocks;
            if (i5 >= fieldElementArr.length) {
                return blockFieldMatrix;
            }
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            T[] tArr = this.blocks[i5];
            for (int i6 = 0; i6 < fieldElementArr2.length; i6++) {
                fieldElementArr2[i6] = (FieldElement) tArr[i6].add(t6);
            }
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarMultiply(T t6) {
        BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), this.rows, this.columns);
        int i5 = 0;
        while (true) {
            FieldElement[][] fieldElementArr = (T[][]) blockFieldMatrix.blocks;
            if (i5 >= fieldElementArr.length) {
                return blockFieldMatrix;
            }
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            T[] tArr = this.blocks[i5];
            for (int i6 = 0; i6 < fieldElementArr2.length; i6++) {
                fieldElementArr2[i6] = (FieldElement) tArr[i6].multiply(t6);
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setColumn(int i5, T[] tArr) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        if (tArr.length != rowDimension) {
            throw new MatrixDimensionMismatchException(tArr.length, 1, rowDimension, 1);
        }
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int iBlockWidth = blockWidth(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockRows; i9++) {
            int iBlockHeight = blockHeight(i9);
            T[] tArr2 = this.blocks[(this.blockColumns * i9) + i6];
            int i10 = 0;
            while (i10 < iBlockHeight) {
                tArr2[(i10 * iBlockWidth) + i7] = tArr[i8];
                i10++;
                i8++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setColumnMatrix(int i5, FieldMatrix<T> fieldMatrix) {
        try {
            setColumnMatrix(i5, (BlockFieldMatrix) fieldMatrix);
        } catch (ClassCastException unused) {
            super.setColumnMatrix(i5, fieldMatrix);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setColumnVector(int i5, FieldVector<T> fieldVector) {
        try {
            setColumn(i5, ((ArrayFieldVector) fieldVector).getDataRef());
        } catch (ClassCastException unused) {
            super.setColumnVector(i5, fieldVector);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        int i7 = i5 / 36;
        int i8 = i6 / 36;
        this.blocks[(i7 * this.blockColumns) + i8][(i6 - (i8 * 36)) + ((i5 - (i7 * 36)) * blockWidth(i8))] = t6;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setRow(int i5, T[] tArr) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        if (tArr.length != columnDimension) {
            throw new MatrixDimensionMismatchException(1, tArr.length, 1, columnDimension);
        }
        int i6 = i5 / 36;
        int i7 = i5 - (i6 * 36);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockColumns; i9++) {
            int iBlockWidth = blockWidth(i9);
            System.arraycopy(tArr, i8, this.blocks[(this.blockColumns * i6) + i9], i7 * iBlockWidth, iBlockWidth);
            i8 += iBlockWidth;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setRowMatrix(int i5, FieldMatrix<T> fieldMatrix) {
        try {
            setRowMatrix(i5, (BlockFieldMatrix) fieldMatrix);
        } catch (ClassCastException unused) {
            super.setRowMatrix(i5, fieldMatrix);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setRowVector(int i5, FieldVector<T> fieldVector) {
        try {
            setRow(i5, ((ArrayFieldVector) fieldVector).getDataRef());
        } catch (ClassCastException unused) {
            super.setRowVector(i5, fieldVector);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setSubMatrix(T[][] tArr, int i5, int i6) {
        BlockFieldMatrix<T> blockFieldMatrix = this;
        int i7 = i5;
        int i8 = i6;
        MathUtils.checkNotNull(tArr);
        int length = tArr[0].length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        int length2 = tArr.length + i7;
        int i9 = i8 + length;
        blockFieldMatrix.checkSubMatrixIndex(i7, length2 - 1, i8, i9 - 1);
        for (T[] tArr2 : tArr) {
            if (tArr2.length != length) {
                throw new DimensionMismatchException(length, tArr2.length);
            }
        }
        int i10 = i7 / 36;
        int i11 = (length2 + 35) / 36;
        int i12 = i8 / 36;
        int i13 = (i9 + 35) / 36;
        while (i10 < i11) {
            int iBlockHeight = blockFieldMatrix.blockHeight(i10);
            int i14 = i10 * 36;
            int iMax = FastMath.max(i7, i14);
            int iMin = FastMath.min(length2, iBlockHeight + i14);
            int i15 = i12;
            while (i15 < i13) {
                int iBlockWidth = blockFieldMatrix.blockWidth(i15);
                int i16 = i15 * 36;
                int iMax2 = FastMath.max(i8, i16);
                int iMin2 = FastMath.min(i9, i16 + iBlockWidth) - iMax2;
                T[] tArr3 = blockFieldMatrix.blocks[(blockFieldMatrix.blockColumns * i10) + i15];
                int i17 = iMax;
                while (i17 < iMin) {
                    int i18 = i17;
                    System.arraycopy(tArr[i17 - i5], iMax2 - i6, tArr3, (iMax2 - i16) + ((i18 - i14) * iBlockWidth), iMin2);
                    i17 = i18 + 1;
                    i10 = i10;
                }
                i15++;
                blockFieldMatrix = this;
                i8 = i6;
            }
            i10++;
            blockFieldMatrix = this;
            i7 = i5;
            i8 = i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> fieldMatrix) {
        try {
            return subtract((BlockFieldMatrix) fieldMatrix);
        } catch (ClassCastException unused) {
            checkSubtractionCompatible(fieldMatrix);
            BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), this.rows, this.columns);
            int i5 = 0;
            for (int i6 = 0; i6 < blockFieldMatrix.blockRows; i6++) {
                for (int i7 = 0; i7 < blockFieldMatrix.blockColumns; i7++) {
                    FieldElement[] fieldElementArr = ((T[][]) blockFieldMatrix.blocks)[i5];
                    T[] tArr = this.blocks[i5];
                    int i8 = i6 * 36;
                    int iMin = FastMath.min(i8 + 36, this.rows);
                    int i9 = i7 * 36;
                    int iMin2 = FastMath.min(i9 + 36, this.columns);
                    int i10 = 0;
                    while (i8 < iMin) {
                        for (int i11 = i9; i11 < iMin2; i11++) {
                            fieldElementArr[i10] = (FieldElement) tArr[i10].subtract(fieldMatrix.getEntry(i8, i11));
                            i10++;
                        }
                        i8++;
                    }
                    i5++;
                }
            }
            return blockFieldMatrix;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> transpose() {
        int rowDimension = getRowDimension();
        BlockFieldMatrix blockFieldMatrix = new BlockFieldMatrix(getField(), getColumnDimension(), rowDimension);
        int i5 = 0;
        for (int i6 = 0; i6 < this.blockColumns; i6++) {
            for (int i7 = 0; i7 < this.blockRows; i7++) {
                T[] tArr = blockFieldMatrix.blocks[i5];
                T[] tArr2 = this.blocks[(this.blockColumns * i7) + i6];
                int i8 = i6 * 36;
                int iMin = FastMath.min(i8 + 36, this.columns);
                int i9 = i7 * 36;
                int iMin2 = FastMath.min(i9 + 36, this.rows);
                int i10 = 0;
                for (int i11 = i8; i11 < iMin; i11++) {
                    int i12 = iMin - i8;
                    int i13 = i11 - i8;
                    for (int i14 = i9; i14 < iMin2; i14++) {
                        tArr[i10] = tArr2[i13];
                        i10++;
                        i13 += i12;
                    }
                }
                i5++;
            }
        }
        return blockFieldMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        fieldMatrixChangingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        int i7 = 0;
        for (int i8 = 0; i8 < this.blockRows; i8++) {
            int i9 = i8 * 36;
            int iMin = FastMath.min(i9 + 36, this.rows);
            for (int i10 = 0; i10 < this.blockColumns; i10++) {
                int i11 = i10 * 36;
                int iMin2 = FastMath.min(i11 + 36, this.columns);
                Object[] objArr = this.blocks[i7];
                int i12 = 0;
                for (int i13 = i9; i13 < iMin; i13++) {
                    for (int i14 = i11; i14 < iMin2; i14++) {
                        objArr[i12] = fieldMatrixChangingVisitor.visit(i13, i14, objArr[i12]);
                        i12++;
                    }
                }
                i7++;
            }
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        fieldMatrixChangingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        for (int i7 = 0; i7 < this.blockRows; i7++) {
            int i8 = i7 * 36;
            int iMin = FastMath.min(i8 + 36, this.rows);
            for (int i9 = i8; i9 < iMin; i9++) {
                for (int i10 = 0; i10 < this.blockColumns; i10++) {
                    int iBlockWidth = blockWidth(i10);
                    int i11 = i10 * 36;
                    int iMin2 = FastMath.min(i11 + 36, this.columns);
                    Object[] objArr = this.blocks[(this.blockColumns * i7) + i10];
                    int i12 = (i9 - i8) * iBlockWidth;
                    while (i11 < iMin2) {
                        objArr[i12] = fieldMatrixChangingVisitor.visit(i9, i11, objArr[i12]);
                        i12++;
                        i11++;
                    }
                }
            }
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    public void setColumnMatrix(int i5, BlockFieldMatrix<T> blockFieldMatrix) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        if (blockFieldMatrix.getRowDimension() == rowDimension && blockFieldMatrix.getColumnDimension() == 1) {
            int i6 = i5 / 36;
            int i7 = i5 - (i6 * 36);
            int iBlockWidth = blockWidth(i6);
            T[] tArr = blockFieldMatrix.blocks[0];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < this.blockRows; i10++) {
                int iBlockHeight = blockHeight(i10);
                T[] tArr2 = this.blocks[(this.blockColumns * i10) + i6];
                int i11 = 0;
                while (i11 < iBlockHeight) {
                    if (i8 >= tArr.length) {
                        i9++;
                        tArr = blockFieldMatrix.blocks[i9];
                        i8 = 0;
                    }
                    tArr2[(i11 * iBlockWidth) + i7] = tArr[i8];
                    i11++;
                    i8++;
                }
            }
            return;
        }
        throw new MatrixDimensionMismatchException(blockFieldMatrix.getRowDimension(), blockFieldMatrix.getColumnDimension(), rowDimension, 1);
    }

    public void setRowMatrix(int i5, BlockFieldMatrix<T> blockFieldMatrix) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        if (blockFieldMatrix.getRowDimension() == 1 && blockFieldMatrix.getColumnDimension() == columnDimension) {
            int i6 = i5 / 36;
            int i7 = i5 - (i6 * 36);
            T[] tArr = blockFieldMatrix.blocks[0];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < this.blockColumns; i10++) {
                int iBlockWidth = blockWidth(i10);
                T[] tArr2 = this.blocks[(this.blockColumns * i6) + i10];
                int length = tArr.length - i8;
                if (iBlockWidth > length) {
                    int i11 = i7 * iBlockWidth;
                    System.arraycopy(tArr, i8, tArr2, i11, length);
                    i9++;
                    tArr = blockFieldMatrix.blocks[i9];
                    int i12 = iBlockWidth - length;
                    System.arraycopy(tArr, 0, tArr2, i11, i12);
                    i8 = i12;
                } else {
                    System.arraycopy(tArr, i8, tArr2, i7 * iBlockWidth, iBlockWidth);
                    i8 += iBlockWidth;
                }
            }
            return;
        }
        throw new MatrixDimensionMismatchException(blockFieldMatrix.getRowDimension(), blockFieldMatrix.getColumnDimension(), 1, columnDimension);
    }

    public BlockFieldMatrix(T[][] tArr) {
        this(tArr.length, tArr[0].length, toBlocksLayout(tArr), false);
    }

    public BlockFieldMatrix(int i5, int i6, T[][] tArr, boolean z6) {
        super(AbstractFieldMatrix.extractField(tArr), i5, i6);
        this.rows = i5;
        this.columns = i6;
        int i7 = (i5 + 35) / 36;
        this.blockRows = i7;
        int i8 = (i6 + 35) / 36;
        this.blockColumns = i8;
        if (z6) {
            this.blocks = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), i7 * i8, -1));
        } else {
            this.blocks = tArr;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.blockRows; i10++) {
            int iBlockHeight = blockHeight(i10);
            int i11 = 0;
            while (i11 < this.blockColumns) {
                if (tArr[i9].length != blockWidth(i11) * iBlockHeight) {
                    throw new DimensionMismatchException(tArr[i9].length, iBlockHeight * blockWidth(i11));
                }
                if (z6) {
                    ((T[][]) this.blocks)[i9] = (FieldElement[]) tArr[i9].clone();
                }
                i11++;
                i9++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        fieldMatrixPreservingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        int i7 = 0;
        for (int i8 = 0; i8 < this.blockRows; i8++) {
            int i9 = i8 * 36;
            int iMin = FastMath.min(i9 + 36, this.rows);
            for (int i10 = 0; i10 < this.blockColumns; i10++) {
                int i11 = i10 * 36;
                int iMin2 = FastMath.min(i11 + 36, this.columns);
                T[] tArr = this.blocks[i7];
                int i12 = 0;
                for (int i13 = i9; i13 < iMin; i13++) {
                    for (int i14 = i11; i14 < iMin2; i14++) {
                        fieldMatrixPreservingVisitor.visit(i13, i14, tArr[i12]);
                        i12++;
                    }
                }
                i7++;
            }
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        fieldMatrixPreservingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        for (int i7 = 0; i7 < this.blockRows; i7++) {
            int i8 = i7 * 36;
            int iMin = FastMath.min(i8 + 36, this.rows);
            for (int i9 = i8; i9 < iMin; i9++) {
                for (int i10 = 0; i10 < this.blockColumns; i10++) {
                    int iBlockWidth = blockWidth(i10);
                    int i11 = i10 * 36;
                    int iMin2 = FastMath.min(i11 + 36, this.columns);
                    T[] tArr = this.blocks[(this.blockColumns * i7) + i10];
                    int i12 = (i9 - i8) * iBlockWidth;
                    while (i11 < iMin2) {
                        fieldMatrixPreservingVisitor.visit(i9, i11, tArr[i12]);
                        i12++;
                        i11++;
                    }
                }
            }
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockFieldMatrix<T> add(BlockFieldMatrix<T> blockFieldMatrix) {
        checkAdditionCompatible(blockFieldMatrix);
        BlockFieldMatrix<T> blockFieldMatrix2 = new BlockFieldMatrix<>(getField(), this.rows, this.columns);
        int i5 = 0;
        while (true) {
            FieldElement[][] fieldElementArr = (T[][]) blockFieldMatrix2.blocks;
            if (i5 >= fieldElementArr.length) {
                return blockFieldMatrix2;
            }
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            T[] tArr = this.blocks[i5];
            T[] tArr2 = blockFieldMatrix.blocks[i5];
            for (int i6 = 0; i6 < fieldElementArr2.length; i6++) {
                fieldElementArr2[i6] = (FieldElement) tArr[i6].add(tArr2[i6]);
            }
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockFieldMatrix<T> subtract(BlockFieldMatrix<T> blockFieldMatrix) {
        checkSubtractionCompatible(blockFieldMatrix);
        BlockFieldMatrix<T> blockFieldMatrix2 = new BlockFieldMatrix<>(getField(), this.rows, this.columns);
        int i5 = 0;
        while (true) {
            FieldElement[][] fieldElementArr = (T[][]) blockFieldMatrix2.blocks;
            if (i5 >= fieldElementArr.length) {
                return blockFieldMatrix2;
            }
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            T[] tArr = this.blocks[i5];
            T[] tArr2 = blockFieldMatrix.blocks[i5];
            for (int i6 = 0; i6 < fieldElementArr2.length; i6++) {
                fieldElementArr2[i6] = (FieldElement) tArr[i6].subtract(tArr2[i6]);
            }
            i5++;
        }
    }

    public BlockFieldMatrix<T> multiply(BlockFieldMatrix<T> blockFieldMatrix) {
        T t6;
        BlockFieldMatrix<T> blockFieldMatrix2 = this;
        BlockFieldMatrix<T> blockFieldMatrix3 = blockFieldMatrix;
        checkMultiplicationCompatible(blockFieldMatrix);
        BlockFieldMatrix<T> blockFieldMatrix4 = new BlockFieldMatrix<>(blockFieldMatrix2.getField(), blockFieldMatrix2.rows, blockFieldMatrix3.columns);
        T zero = blockFieldMatrix2.getField().getZero();
        int i5 = 0;
        int i6 = 0;
        while (i5 < blockFieldMatrix4.blockRows) {
            int i7 = i5 * 36;
            int iMin = FastMath.min(i7 + 36, blockFieldMatrix2.rows);
            int i8 = 0;
            while (i8 < blockFieldMatrix4.blockColumns) {
                int iBlockWidth = blockFieldMatrix4.blockWidth(i8);
                int i9 = iBlockWidth + iBlockWidth;
                int i10 = i9 + iBlockWidth;
                int i11 = i10 + iBlockWidth;
                FieldElement[] fieldElementArr = blockFieldMatrix4.blocks[i6];
                int i12 = 0;
                while (i12 < blockFieldMatrix2.blockColumns) {
                    int iBlockWidth2 = blockFieldMatrix2.blockWidth(i12);
                    BlockFieldMatrix<T> blockFieldMatrix5 = blockFieldMatrix4;
                    T[] tArr = blockFieldMatrix2.blocks[(blockFieldMatrix2.blockColumns * i5) + i12];
                    T[] tArr2 = blockFieldMatrix3.blocks[(blockFieldMatrix3.blockColumns * i12) + i8];
                    int i13 = i7;
                    int i14 = 0;
                    while (i13 < iMin) {
                        int i15 = (i13 - i7) * iBlockWidth2;
                        int i16 = i13;
                        int i17 = i15 + iBlockWidth2;
                        int i18 = 0;
                        while (i18 < iBlockWidth) {
                            int i19 = i18;
                            int i20 = i19;
                            T[] tArr3 = tArr;
                            FieldElement fieldElement = zero;
                            int i21 = i15;
                            while (true) {
                                t6 = zero;
                                if (i21 >= i17 - 3) {
                                    break;
                                }
                                int i22 = i21;
                                fieldElement = (FieldElement) ((FieldElement) ((FieldElement) ((FieldElement) fieldElement.add(tArr3[i21].multiply(tArr2[i20]))).add(tArr3[i22 + 1].multiply(tArr2[i20 + iBlockWidth]))).add(tArr3[i22 + 2].multiply(tArr2[i20 + i9]))).add(tArr3[i22 + 3].multiply(tArr2[i20 + i10]));
                                i21 = i22 + 4;
                                i20 += i11;
                                zero = t6;
                            }
                            while (i21 < i17) {
                                fieldElement = (FieldElement) fieldElement.add(tArr3[i21].multiply(tArr2[i20]));
                                i20 += iBlockWidth;
                                i21++;
                                i17 = i17;
                            }
                            fieldElementArr[i14] = (FieldElement) fieldElementArr[i14].add(fieldElement);
                            i14++;
                            i18 = i19 + 1;
                            tArr = tArr3;
                            zero = t6;
                            i17 = i17;
                        }
                        i13 = i16 + 1;
                    }
                    i12++;
                    blockFieldMatrix2 = this;
                    blockFieldMatrix3 = blockFieldMatrix;
                    blockFieldMatrix4 = blockFieldMatrix5;
                }
                i6++;
                i8++;
                blockFieldMatrix2 = this;
                blockFieldMatrix3 = blockFieldMatrix;
            }
            i5++;
            blockFieldMatrix2 = this;
            blockFieldMatrix3 = blockFieldMatrix;
        }
        return blockFieldMatrix4;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        BlockFieldMatrix<T> blockFieldMatrix = this;
        blockFieldMatrix.checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixChangingVisitor.start(blockFieldMatrix.rows, blockFieldMatrix.columns, i5, i6, i7, i8);
        int i9 = i5 / 36;
        while (i9 < (i6 / 36) + 1) {
            int i10 = i9 * 36;
            int iMax = FastMath.max(i5, i10);
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 36, i6 + 1);
            int i12 = i7 / 36;
            while (i12 < (i8 / 36) + 1) {
                int iBlockWidth = blockFieldMatrix.blockWidth(i12);
                int i13 = i12 * 36;
                int iMax2 = FastMath.max(i7, i13);
                int i14 = i12 + 1;
                int iMin2 = FastMath.min(i14 * 36, i8 + 1);
                Object[] objArr = blockFieldMatrix.blocks[(blockFieldMatrix.blockColumns * i9) + i12];
                int i15 = iMax;
                while (i15 < iMin) {
                    int i16 = (((i15 - i10) * iBlockWidth) + iMax2) - i13;
                    int i17 = iMax2;
                    while (i17 < iMin2) {
                        objArr[i16] = fieldMatrixChangingVisitor.visit(i15, i17, objArr[i16]);
                        i16++;
                        i17++;
                        i9 = i9;
                        i10 = i10;
                    }
                    i15++;
                    i10 = i10;
                }
                blockFieldMatrix = this;
                i12 = i14;
                i10 = i10;
            }
            blockFieldMatrix = this;
            i9 = i11;
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixChangingVisitor.start(this.rows, this.columns, i5, i6, i7, i8);
        int i9 = i5 / 36;
        while (i9 < (i6 / 36) + 1) {
            int i10 = i9 * 36;
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 36, i6 + 1);
            for (int iMax = FastMath.max(i5, i10); iMax < iMin; iMax++) {
                int i12 = i7 / 36;
                while (i12 < (i8 / 36) + 1) {
                    int iBlockWidth = blockWidth(i12);
                    int i13 = i12 * 36;
                    int iMax2 = FastMath.max(i7, i13);
                    int i14 = i12 + 1;
                    int iMin2 = FastMath.min(i14 * 36, i8 + 1);
                    Object[] objArr = this.blocks[(this.blockColumns * i9) + i12];
                    int i15 = (((iMax - i10) * iBlockWidth) + iMax2) - i13;
                    while (iMax2 < iMin2) {
                        objArr[i15] = fieldMatrixChangingVisitor.visit(iMax, iMax2, objArr[i15]);
                        i15++;
                        iMax2++;
                    }
                    i12 = i14;
                }
            }
            i9 = i11;
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        BlockFieldMatrix<T> blockFieldMatrix = this;
        blockFieldMatrix.checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixPreservingVisitor.start(blockFieldMatrix.rows, blockFieldMatrix.columns, i5, i6, i7, i8);
        int i9 = i5 / 36;
        while (i9 < (i6 / 36) + 1) {
            int i10 = i9 * 36;
            int iMax = FastMath.max(i5, i10);
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 36, i6 + 1);
            int i12 = i7 / 36;
            while (i12 < (i8 / 36) + 1) {
                int iBlockWidth = blockFieldMatrix.blockWidth(i12);
                int i13 = i12 * 36;
                int iMax2 = FastMath.max(i7, i13);
                int i14 = i12 + 1;
                int iMin2 = FastMath.min(i14 * 36, i8 + 1);
                T[] tArr = blockFieldMatrix.blocks[(blockFieldMatrix.blockColumns * i9) + i12];
                int i15 = iMax;
                while (i15 < iMin) {
                    int i16 = (((i15 - i10) * iBlockWidth) + iMax2) - i13;
                    int i17 = iMax2;
                    while (i17 < iMin2) {
                        fieldMatrixPreservingVisitor.visit(i15, i17, tArr[i16]);
                        i16++;
                        i17++;
                        i9 = i9;
                        i10 = i10;
                    }
                    i15++;
                    i10 = i10;
                }
                blockFieldMatrix = this;
                i12 = i14;
                i10 = i10;
            }
            blockFieldMatrix = this;
            i9 = i11;
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixPreservingVisitor.start(this.rows, this.columns, i5, i6, i7, i8);
        int i9 = i5 / 36;
        while (i9 < (i6 / 36) + 1) {
            int i10 = i9 * 36;
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 36, i6 + 1);
            for (int iMax = FastMath.max(i5, i10); iMax < iMin; iMax++) {
                int i12 = i7 / 36;
                while (i12 < (i8 / 36) + 1) {
                    int iBlockWidth = blockWidth(i12);
                    int i13 = i12 * 36;
                    int iMax2 = FastMath.max(i7, i13);
                    int i14 = i12 + 1;
                    int iMin2 = FastMath.min(i14 * 36, i8 + 1);
                    T[] tArr = this.blocks[(this.blockColumns * i9) + i12];
                    int i15 = (((iMax - i10) * iBlockWidth) + iMax2) - i13;
                    while (iMax2 < iMin2) {
                        fieldMatrixPreservingVisitor.visit(iMax, iMax2, tArr[i15]);
                        i15++;
                        iMax2++;
                    }
                    i12 = i14;
                }
            }
            i9 = i11;
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }
}

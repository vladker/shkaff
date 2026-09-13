package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class SSCellRange<K extends Cell> implements CellRange<K> {
    private final int _firstColumn;
    private final int _firstRow;
    private final K[] _flattenedArray;
    private final int _height;
    private final int _width;

    private SSCellRange(int i5, int i6, int i7, int i8, K[] kArr) {
        this._firstRow = i5;
        this._firstColumn = i6;
        this._height = i7;
        this._width = i8;
        this._flattenedArray = (K[]) ((Cell[]) kArr.clone());
    }

    public static <B extends Cell> SSCellRange<B> create(int i5, int i6, int i7, int i8, List<B> list, Class<B> cls) {
        int size = list.size();
        if (i7 * i8 != size) {
            throw new IllegalArgumentException("Array size mismatch.");
        }
        Cell[] cellArr = (Cell[]) Array.newInstance((Class<?>) cls, size);
        list.toArray(cellArr);
        return new SSCellRange<>(i5, i6, i7, i8, cellArr);
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public K getCell(int i5, int i6) {
        int i7;
        if (i5 < 0 || i5 >= this._height) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified row ", " is outside the allowable range (0..");
            sbT.append(this._height - 1);
            sbT.append(").");
            throw new ArrayIndexOutOfBoundsException(sbT.toString());
        }
        if (i6 >= 0 && i6 < (i7 = this._width)) {
            return this._flattenedArray[(i7 * i5) + i6];
        }
        StringBuilder sbT2 = AbstractC0157z.t(i6, "Specified colummn ", " is outside the allowable range (0..");
        sbT2.append(this._width - 1);
        sbT2.append(").");
        throw new ArrayIndexOutOfBoundsException(sbT2.toString());
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public K[][] getCells() {
        Class<?> cls = this._flattenedArray.getClass();
        K[][] kArr = (K[][]) ((Cell[][]) Array.newInstance(cls, this._height));
        Class<?> componentType = cls.getComponentType();
        for (int i5 = this._height - 1; i5 >= 0; i5--) {
            Cell[] cellArr = (Cell[]) Array.newInstance(componentType, this._width);
            int i6 = this._width;
            System.arraycopy(this._flattenedArray, i6 * i5, cellArr, 0, i6);
        }
        return kArr;
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public K[] getFlattenedCells() {
        return (K[]) ((Cell[]) this._flattenedArray.clone());
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public int getHeight() {
        return this._height;
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public String getReferenceText() {
        int i5 = this._firstRow;
        int i6 = (this._height + i5) - 1;
        int i7 = this._firstColumn;
        return new CellRangeAddress(i5, i6, i7, (this._width + i7) - 1).formatAsString();
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public K getTopLeftCell() {
        return this._flattenedArray[0];
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public int getWidth() {
        return this._width;
    }

    @Override // org.apache.poi.ss.usermodel.CellRange, java.lang.Iterable
    public Iterator<K> iterator() {
        return Stream.of((Object[]) this._flattenedArray).iterator();
    }

    @Override // org.apache.poi.ss.usermodel.CellRange
    public int size() {
        return this._height * this._width;
    }

    @Override // java.lang.Iterable
    public Spliterator<K> spliterator() {
        return Stream.of((Object[]) this._flattenedArray).spliterator();
    }
}

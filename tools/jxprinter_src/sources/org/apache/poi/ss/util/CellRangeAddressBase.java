package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CellRangeAddressBase implements Iterable<CellAddress>, Duplicatable, GenericRecord {
    private int _firstCol;
    private int _firstRow;
    private int _lastCol;
    private int _lastRow;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum CellPosition {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        INSIDE
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RowMajorCellAddressIterator implements Iterator<CellAddress> {
        private int c;
        private final int firstCol;
        private final int firstRow;
        private final int lastCol;
        private final int lastRow;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f7237r;

        public RowMajorCellAddressIterator(CellRangeAddressBase cellRangeAddressBase) {
            int firstRow = cellRangeAddressBase.getFirstRow();
            this.firstRow = firstRow;
            this.f7237r = firstRow;
            int firstColumn = cellRangeAddressBase.getFirstColumn();
            this.firstCol = firstColumn;
            this.c = firstColumn;
            int lastRow = cellRangeAddressBase.getLastRow();
            this.lastRow = lastRow;
            int lastColumn = cellRangeAddressBase.getLastColumn();
            this.lastCol = lastColumn;
            if (firstRow < 0) {
                throw new IllegalStateException("First row cannot be negative.");
            }
            if (firstColumn < 0) {
                throw new IllegalStateException("First column cannot be negative.");
            }
            if (firstRow > lastRow) {
                throw new IllegalStateException("First row cannot be greater than last row.");
            }
            if (firstColumn > lastColumn) {
                throw new IllegalStateException("First column cannot be greater than last column.");
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7237r <= this.lastRow && this.c <= this.lastCol;
        }

        @Override // java.util.Iterator
        public CellAddress next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            CellAddress cellAddress = new CellAddress(this.f7237r, this.c);
            int i5 = this.c;
            if (i5 < this.lastCol) {
                this.c = i5 + 1;
                return cellAddress;
            }
            this.c = this.firstCol;
            this.f7237r++;
            return cellAddress;
        }
    }

    public CellRangeAddressBase(int i5, int i6, int i7, int i8) {
        this._firstRow = i5;
        this._lastRow = i6;
        this._firstCol = i7;
        this._lastCol = i8;
    }

    private static void validateColumn(int i5, SpreadsheetVersion spreadsheetVersion) {
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        if (i5 > lastColumnIndex) {
            throw new IllegalArgumentException(AbstractC0157z.k(lastColumnIndex, "Maximum column number is "));
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Minimum column number is 0");
        }
    }

    private static void validateRow(int i5, SpreadsheetVersion spreadsheetVersion) {
        int lastRowIndex = spreadsheetVersion.getLastRowIndex();
        if (i5 > lastRowIndex) {
            throw new IllegalArgumentException(AbstractC0157z.k(lastRowIndex, "Maximum row number is "));
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Minumum row number is 0");
        }
    }

    public boolean containsColumn(int i5) {
        return this._firstCol <= i5 && i5 <= this._lastCol;
    }

    public boolean containsRow(int i5) {
        return this._firstRow <= i5 && i5 <= this._lastRow;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CellRangeAddressBase) {
            CellRangeAddressBase cellRangeAddressBase = (CellRangeAddressBase) obj;
            if (getMinRow() == cellRangeAddressBase.getMinRow() && getMaxRow() == cellRangeAddressBase.getMaxRow() && getMinColumn() == cellRangeAddressBase.getMinColumn() && getMaxColumn() == cellRangeAddressBase.getMaxColumn()) {
                return true;
            }
        }
        return false;
    }

    public final int getFirstColumn() {
        return this._firstCol;
    }

    public final int getFirstRow() {
        return this._firstRow;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.util.a
            public final /* synthetic */ CellRangeAddressBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int firstRow;
                switch (i5) {
                    case 0:
                        firstRow = this.b.getFirstRow();
                        break;
                    case 1:
                        firstRow = this.b.getFirstColumn();
                        break;
                    case 2:
                        firstRow = this.b.getLastRow();
                        break;
                    default:
                        firstRow = this.b.getLastColumn();
                        break;
                }
                return Integer.valueOf(firstRow);
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.util.a
            public final /* synthetic */ CellRangeAddressBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int firstRow;
                switch (i6) {
                    case 0:
                        firstRow = this.b.getFirstRow();
                        break;
                    case 1:
                        firstRow = this.b.getFirstColumn();
                        break;
                    case 2:
                        firstRow = this.b.getLastRow();
                        break;
                    default:
                        firstRow = this.b.getLastColumn();
                        break;
                }
                return Integer.valueOf(firstRow);
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.util.a
            public final /* synthetic */ CellRangeAddressBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int firstRow;
                switch (i7) {
                    case 0:
                        firstRow = this.b.getFirstRow();
                        break;
                    case 1:
                        firstRow = this.b.getFirstColumn();
                        break;
                    case 2:
                        firstRow = this.b.getLastRow();
                        break;
                    default:
                        firstRow = this.b.getLastColumn();
                        break;
                }
                return Integer.valueOf(firstRow);
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("firstRow", supplier, "firstCol", supplier2, "lastRow", supplier3, "lastCol", new Supplier(this) { // from class: org.apache.poi.ss.util.a
            public final /* synthetic */ CellRangeAddressBase b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                int firstRow;
                switch (i8) {
                    case 0:
                        firstRow = this.b.getFirstRow();
                        break;
                    case 1:
                        firstRow = this.b.getFirstColumn();
                        break;
                    case 2:
                        firstRow = this.b.getLastRow();
                        break;
                    default:
                        firstRow = this.b.getLastColumn();
                        break;
                }
                return Integer.valueOf(firstRow);
            }
        });
    }

    public final int getLastColumn() {
        return this._lastCol;
    }

    public final int getLastRow() {
        return this._lastRow;
    }

    public int getMaxColumn() {
        return Math.max(this._firstCol, this._lastCol);
    }

    public int getMaxRow() {
        return Math.max(this._firstRow, this._lastRow);
    }

    public int getMinColumn() {
        return Math.min(this._firstCol, this._lastCol);
    }

    public int getMinRow() {
        return Math.min(this._firstRow, this._lastRow);
    }

    public int getNumberOfCells() {
        return ((this._lastCol - this._firstCol) + 1) * ((this._lastRow - this._firstRow) + 1);
    }

    public Set<CellPosition> getPosition(int i5, int i6) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(CellPosition.class);
        if (i5 > getFirstRow() && i5 < getLastRow() && i6 > getFirstColumn() && i6 < getLastColumn()) {
            enumSetNoneOf.add(CellPosition.INSIDE);
            return enumSetNoneOf;
        }
        if (i5 == getFirstRow()) {
            enumSetNoneOf.add(CellPosition.TOP);
        }
        if (i5 == getLastRow()) {
            enumSetNoneOf.add(CellPosition.BOTTOM);
        }
        if (i6 == getFirstColumn()) {
            enumSetNoneOf.add(CellPosition.LEFT);
        }
        if (i6 == getLastColumn()) {
            enumSetNoneOf.add(CellPosition.RIGHT);
        }
        return enumSetNoneOf;
    }

    public int hashCode() {
        return getMinColumn() + (getMaxColumn() << 8) + (getMinRow() << 16) + (getMaxRow() << 24);
    }

    public boolean intersects(CellRangeAddressBase cellRangeAddressBase) {
        return this._firstRow <= cellRangeAddressBase._lastRow && this._firstCol <= cellRangeAddressBase._lastCol && cellRangeAddressBase._firstRow <= this._lastRow && cellRangeAddressBase._firstCol <= this._lastCol;
    }

    public final boolean isFullColumnRange() {
        if (this._firstRow == 0 && this._lastRow == SpreadsheetVersion.EXCEL97.getLastRowIndex()) {
            return true;
        }
        return this._firstRow == -1 && this._lastRow == -1;
    }

    public final boolean isFullRowRange() {
        if (this._firstCol == 0 && this._lastCol == SpreadsheetVersion.EXCEL97.getLastColumnIndex()) {
            return true;
        }
        return this._firstCol == -1 && this._lastCol == -1;
    }

    public boolean isInRange(int i5, int i6) {
        return this._firstRow <= i5 && i5 <= this._lastRow && this._firstCol <= i6 && i6 <= this._lastCol;
    }

    @Override // java.lang.Iterable
    public Iterator<CellAddress> iterator() {
        return new RowMajorCellAddressIterator(this);
    }

    public final void setFirstColumn(int i5) {
        this._firstCol = i5;
    }

    public final void setFirstRow(int i5) {
        this._firstRow = i5;
    }

    public final void setLastColumn(int i5) {
        this._lastCol = i5;
    }

    public final void setLastRow(int i5) {
        this._lastRow = i5;
    }

    @Override // java.lang.Iterable
    public Spliterator<CellAddress> spliterator() {
        return Spliterators.spliterator(iterator(), getNumberOfCells(), 0);
    }

    public final String toString() {
        return getClass().getName() + " [" + new CellAddress(this._firstRow, this._firstCol).formatAsString() + ParameterizedMessage.ERROR_MSG_SEPARATOR + new CellAddress(this._lastRow, this._lastCol).formatAsString() + "]";
    }

    public void validate(SpreadsheetVersion spreadsheetVersion) {
        validateRow(this._firstRow, spreadsheetVersion);
        validateRow(this._lastRow, spreadsheetVersion);
        validateColumn(this._firstCol, spreadsheetVersion);
        validateColumn(this._lastCol, spreadsheetVersion);
    }

    public boolean isInRange(CellReference cellReference) {
        return isInRange(cellReference.getRow(), cellReference.getCol());
    }

    public boolean isInRange(CellAddress cellAddress) {
        return isInRange(cellAddress.getRow(), cellAddress.getColumn());
    }

    public boolean isInRange(Cell cell) {
        return isInRange(cell.getRowIndex(), cell.getColumnIndex());
    }
}

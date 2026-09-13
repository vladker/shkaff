package org.apache.poi.ss.util;

import java.util.Locale;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellAddress implements Comparable<CellAddress> {

    /* JADX INFO: renamed from: A1, reason: collision with root package name */
    public static final CellAddress f7236A1 = new CellAddress(0, 0);
    private final int _col;
    private final int _row;

    public CellAddress(int i5, int i6) {
        this._row = i5;
        this._col = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CellAddress)) {
            return false;
        }
        CellAddress cellAddress = (CellAddress) obj;
        return this._row == cellAddress._row && this._col == cellAddress._col;
    }

    public String formatAsR1C1String() {
        return new CellReference(this._row, this._col).formatAsR1C1String();
    }

    public String formatAsString() {
        return CellReference.convertNumToColString(this._col) + (this._row + 1);
    }

    public int getColumn() {
        return this._col;
    }

    public int getRow() {
        return this._row;
    }

    public int hashCode() {
        return (this._row + this._col) << 16;
    }

    public String toString() {
        return formatAsString();
    }

    @Override // java.lang.Comparable
    public int compareTo(CellAddress cellAddress) {
        int i5 = this._row - cellAddress._row;
        return i5 != 0 ? i5 : this._col - cellAddress._col;
    }

    public CellAddress(String str) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length && !Character.isDigit(str.charAt(i5))) {
            i5++;
        }
        String upperCase = str.substring(0, i5).toUpperCase(Locale.ROOT);
        this._row = Integer.parseInt(str.substring(i5)) - 1;
        this._col = CellReference.convertColStringToIndex(upperCase);
    }

    public CellAddress(CellReference cellReference) {
        this(cellReference.getRow(), cellReference.getCol());
    }

    public CellAddress(CellAddress cellAddress) {
        this(cellAddress.getRow(), cellAddress.getColumn());
    }

    public CellAddress(Cell cell) {
        this(cell.getRowIndex(), cell.getColumnIndex());
    }
}

package org.apache.poi.xssf.streaming;

import A3.AbstractC0157z;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SXSSFRow implements Row, Comparable<SXSSFRow> {
    private static final Boolean UNDEFINED = null;
    private Boolean _collapsed;
    private Boolean _hidden;
    private int _outlineLevel;
    private int _rowNum;
    private final SXSSFSheet _sheet;
    private boolean _zHeight;
    private final SortedMap<Integer, SXSSFCell> _cells = new TreeMap();
    private short _style = -1;
    private short _height = -1;

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SXSSFRow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy;

        static {
            int[] iArr = new int[Row.MissingCellPolicy.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy = iArr;
            try {
                iArr[Row.MissingCellPolicy.RETURN_NULL_AND_BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.RETURN_BLANK_AS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.CREATE_NULL_AS_BLANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class CellIterator implements Iterator<Cell> {
        final int maxColumn;
        int pos;

        public CellIterator() {
            this.maxColumn = SXSSFRow.this.getLastCellNum();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < this.maxColumn;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Cell next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            SortedMap sortedMap = SXSSFRow.this._cells;
            int i5 = this.pos;
            this.pos = i5 + 1;
            return (Cell) sortedMap.get(Integer.valueOf(i5));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FilledCellIterator implements Iterator<Cell> {
        private final Iterator<SXSSFCell> iter;

        public FilledCellIterator() {
            this.iter = SXSSFRow.this._cells.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Cell next() {
            return this.iter.next();
        }
    }

    public SXSSFRow(SXSSFSheet sXSSFSheet) {
        Boolean bool = UNDEFINED;
        this._hidden = bool;
        this._collapsed = bool;
        this._sheet = sXSSFSheet;
    }

    private static void checkBounds(int i5) {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        if (i5 < 0 || i5 > lastColumnIndex) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Invalid column index (", ").  Allowable column range for ");
            sbT.append(spreadsheetVersion.name());
            sbT.append(" is (0..");
            sbT.append(lastColumnIndex);
            sbT.append(") or ('A'..'");
            sbT.append(spreadsheetVersion.getLastColumnName());
            sbT.append("')");
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    public Iterator<Cell> allCellsIterator() {
        return new CellIterator();
    }

    public Spliterator<Cell> allCellsSpliterator() {
        return Spliterators.spliterator(allCellsIterator(), getLastCellNum(), 0);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return new FilledCellIterator();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SXSSFRow)) {
            return false;
        }
        SXSSFRow sXSSFRow = (SXSSFRow) obj;
        return getRowNum() == sXSSFRow.getRowNum() && getSheet() == sXSSFRow.getSheet();
    }

    public int getCellIndex(SXSSFCell sXSSFCell) {
        for (Map.Entry<Integer, SXSSFCell> entry : this._cells.entrySet()) {
            if (entry.getValue() == sXSSFCell) {
                return entry.getKey().intValue();
            }
        }
        return -1;
    }

    public Boolean getCollapsed() {
        return this._collapsed;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        try {
            return this._cells.firstKey().shortValue();
        } catch (NoSuchElementException unused) {
            return (short) -1;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        short s6 = this._height;
        return (short) (s6 == -1 ? getSheet().getDefaultRowHeightInPoints() * 20.0f : s6);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        short s6 = this._height;
        return (float) (s6 == -1 ? getSheet().getDefaultRowHeightInPoints() : ((double) s6) / 20.0d);
    }

    public Boolean getHidden() {
        return this._hidden;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this._cells.isEmpty()) {
            return (short) -1;
        }
        return (short) (this._cells.lastKey().intValue() + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this._outlineLevel;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this._rowNum;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public CellStyle getRowStyle() {
        if (isFormatted()) {
            return getSheet().getWorkbook().getCellStyleAt(this._style);
        }
        return null;
    }

    @Internal
    public int getRowStyleIndex() {
        return this._style;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this._zHeight;
    }

    public boolean hasCustomHeight() {
        return this._height != -1;
    }

    public int hashCode() {
        return this._cells.hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this._style > -1;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        this._cells.remove(Integer.valueOf(getCellIndex((SXSSFCell) cell)));
    }

    public void setCollapsed(Boolean bool) {
        this._collapsed = bool;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s6) {
        this._height = s6;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f6) {
        if (f6 == -1.0f) {
            this._height = (short) -1;
        } else {
            this._height = (short) (f6 * 20.0f);
        }
    }

    public void setHidden(Boolean bool) {
        this._hidden = bool;
    }

    public void setOutlineLevel(int i5) {
        this._outlineLevel = i5;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i5) {
        this._rowNum = i5;
        this._sheet.changeRowNum(this, i5);
    }

    public void setRowNumWithoutUpdatingSheet(int i5) {
        this._rowNum = i5;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            this._style = (short) -1;
        } else {
            this._style = cellStyle.getIndex();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z6) {
        this._zHeight = z6;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    @NotImplemented
    public void shiftCellsLeft(int i5, int i6, int i7) {
        throw new NotImplementedException("shiftCellsLeft");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    @NotImplemented
    public void shiftCellsRight(int i5, int i6, int i7) {
        throw new NotImplementedException("shiftCellsRight");
    }

    @Override // org.apache.poi.ss.usermodel.Row, java.lang.Iterable
    public Spliterator<Cell> spliterator() {
        return this._cells.values().spliterator();
    }

    @Override // java.lang.Comparable
    public int compareTo(SXSSFRow sXSSFRow) {
        if (getSheet() == sXSSFRow.getSheet()) {
            return Integer.compare(getRowNum(), sXSSFRow.getRowNum());
        }
        throw new IllegalArgumentException("The compared rows must belong to the same sheet");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell createCell(int i5) {
        return createCell(i5, CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell getCell(int i5) {
        return getCell(i5, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell createCell(int i5, CellType cellType) {
        checkBounds(i5);
        SXSSFCell sXSSFCell = new SXSSFCell(this, cellType);
        this._cells.put(Integer.valueOf(i5), sXSSFCell);
        this._sheet.trackNewCell(sXSSFCell);
        return sXSSFCell;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell getCell(int i5, Row.MissingCellPolicy missingCellPolicy) {
        checkBounds(i5);
        SXSSFCell sXSSFCell = this._cells.get(Integer.valueOf(i5));
        int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[missingCellPolicy.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return sXSSFCell == null ? createCell(i5, CellType.BLANK) : sXSSFCell;
                }
                throw new IllegalArgumentException("Illegal policy " + missingCellPolicy);
            }
            if (sXSSFCell != null && sXSSFCell.getCellType() == CellType.BLANK) {
                return null;
            }
        }
        return sXSSFCell;
    }
}

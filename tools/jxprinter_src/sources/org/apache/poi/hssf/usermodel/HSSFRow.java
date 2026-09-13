package org.apache.poi.hssf.usermodel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.usermodel.helpers.HSSFRowShifter;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyContext;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.helpers.RowShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.Configurator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFRow implements Row, Comparable<HSSFRow> {
    public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFRow.ColInitialCapacity", 5);
    private final HSSFWorkbook book;
    private HSSFCell[] cells;
    private final RowRecord row;
    private int rowNum;
    private final HSSFSheet sheet;

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFRow$1, reason: invalid class name */
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
        int thisId = -1;
        int nextId = -1;

        public CellIterator() {
            findNext();
        }

        private void findNext() {
            int i5 = this.nextId;
            do {
                i5++;
                if (i5 >= HSSFRow.this.cells.length) {
                    break;
                }
            } while (HSSFRow.this.cells[i5] == null);
            this.nextId = i5;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextId < HSSFRow.this.cells.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.thisId == -1) {
                throw new IllegalStateException("remove() called before next()");
            }
            HSSFRow.this.cells[this.thisId] = null;
        }

        @Override // java.util.Iterator
        public Cell next() {
            if (!hasNext()) {
                throw new NoSuchElementException("At last element");
            }
            HSSFCell[] hSSFCellArr = HSSFRow.this.cells;
            int i5 = this.nextId;
            HSSFCell hSSFCell = hSSFCellArr[i5];
            this.thisId = i5;
            findNext();
            return hSSFCell;
        }
    }

    public HSSFRow(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, int i5) {
        this(hSSFWorkbook, hSSFSheet, new RowRecord(i5));
    }

    private void addCell(HSSFCell hSSFCell) {
        int columnIndex = hSSFCell.getColumnIndex();
        HSSFCell[] hSSFCellArr = this.cells;
        if (columnIndex >= hSSFCellArr.length) {
            int iC = androidx.collection.a.c(hSSFCellArr.length, 3, 2, 1);
            if (iC < columnIndex + 1) {
                iC = INITIAL_CAPACITY + columnIndex;
            }
            HSSFCell[] hSSFCellArr2 = new HSSFCell[iC];
            this.cells = hSSFCellArr2;
            System.arraycopy(hSSFCellArr, 0, hSSFCellArr2, 0, hSSFCellArr.length);
        }
        this.cells[columnIndex] = hSSFCell;
        if (this.row.isEmpty() || columnIndex < this.row.getFirstCol()) {
            this.row.setFirstCol((short) columnIndex);
        }
        if (this.row.isEmpty() || columnIndex >= this.row.getLastCol()) {
            this.row.setLastCol((short) (columnIndex + 1));
        }
    }

    private int calculateNewFirstCell(int i5) {
        int i6 = i5 + 1;
        HSSFCell hSSFCellRetrieveCell = retrieveCell(i6);
        while (hSSFCellRetrieveCell == null) {
            if (i6 <= this.cells.length) {
                return 0;
            }
            i6++;
            hSSFCellRetrieveCell = retrieveCell(i6);
        }
        return i6;
    }

    private int calculateNewLastCellPlusOne(int i5) {
        int i6 = i5 - 1;
        HSSFCell hSSFCellRetrieveCell = retrieveCell(i6);
        while (hSSFCellRetrieveCell == null) {
            if (i6 < 0) {
                return 0;
            }
            i6--;
            hSSFCellRetrieveCell = retrieveCell(i6);
        }
        return i6 + 1;
    }

    private void extend(int i5) {
        HSSFCell[] hSSFCellArr = (HSSFCell[]) this.cells.clone();
        HSSFCell[] hSSFCellArr2 = new HSSFCell[i5];
        this.cells = hSSFCellArr2;
        System.arraycopy(hSSFCellArr, 0, hSSFCellArr2, 0, hSSFCellArr.length);
    }

    private HSSFCell retrieveCell(int i5) {
        if (i5 < 0) {
            return null;
        }
        HSSFCell[] hSSFCellArr = this.cells;
        if (i5 >= hSSFCellArr.length) {
            return null;
        }
        return hSSFCellArr[i5];
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return new CellIterator();
    }

    public void copyRowFrom(Row row, CellCopyPolicy cellCopyPolicy) {
        copyRowFrom(row, cellCopyPolicy, null);
    }

    public HSSFCell createCellFromRecord(CellValueRecordInterface cellValueRecordInterface) {
        HSSFCell hSSFCell = new HSSFCell(this.book, this.sheet, cellValueRecordInterface);
        addCell(hSSFCell);
        short column = cellValueRecordInterface.getColumn();
        if (this.row.isEmpty()) {
            this.row.setFirstCol(column);
            this.row.setLastCol(column + 1);
            return hSSFCell;
        }
        if (column < this.row.getFirstCol()) {
            this.row.setFirstCol(column);
            return hSSFCell;
        }
        if (column > this.row.getLastCol()) {
            this.row.setLastCol(column + 1);
        }
        return hSSFCell;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HSSFRow)) {
            return false;
        }
        HSSFRow hSSFRow = (HSSFRow) obj;
        return getRowNum() == hSSFRow.getRowNum() && getSheet() == hSSFRow.getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        if (this.row.isEmpty()) {
            return (short) -1;
        }
        return (short) this.row.getFirstCol();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        short height = this.row.getHeight();
        return (Short.MIN_VALUE & height) != 0 ? this.sheet.getSheet().getDefaultRowHeight() : (short) (height & Font.COLOR_NORMAL);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        return getHeight() / 20.0f;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this.row.isEmpty()) {
            return (short) -1;
        }
        return (short) this.row.getLastCol();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this.row.getOutlineLevel();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        int i5 = 0;
        for (HSSFCell hSSFCell : this.cells) {
            if (hSSFCell != null) {
                i5++;
            }
        }
        return i5;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this.rowNum;
    }

    public RowRecord getRowRecord() {
        return this.row;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this.row.getZeroHeight();
    }

    public int hashCode() {
        return this.row.hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this.row.getFormatted();
    }

    public void moveCell(HSSFCell hSSFCell, short s6) {
        HSSFCell[] hSSFCellArr = this.cells;
        if (hSSFCellArr.length > s6 && hSSFCellArr[s6] != null) {
            throw new IllegalArgumentException(androidx.collection.a.i(s6, "Asked to move cell to column ", " but there's already a cell there"));
        }
        if (!hSSFCellArr[hSSFCell.getColumnIndex()].equals(hSSFCell)) {
            throw new IllegalArgumentException("Asked to move a cell, but it didn't belong to our row");
        }
        removeCell(hSSFCell, false);
        hSSFCell.updateCellNum(s6);
        addCell(hSSFCell);
    }

    public void removeAllCells() {
        for (HSSFCell hSSFCell : this.cells) {
            if (hSSFCell != null) {
                removeCell(hSSFCell, true);
            }
        }
        this.cells = new HSSFCell[INITIAL_CAPACITY];
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("cell must not be null");
        }
        removeCell((HSSFCell) cell, true);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s6) {
        if (s6 == -1) {
            this.row.setHeight((short) -32513);
            this.row.setBadFontHeight(false);
        } else {
            this.row.setBadFontHeight(true);
            this.row.setHeight(s6);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f6) {
        if (f6 == -1.0f) {
            this.row.setHeight((short) -32513);
            this.row.setBadFontHeight(false);
        } else {
            this.row.setBadFontHeight(true);
            this.row.setHeight((short) (f6 * 20.0f));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i5) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i5 < 0 || i5 > lastRowIndex) {
            throw new IllegalArgumentException(androidx.collection.a.m("Invalid row number (", i5, lastRowIndex, ") outside allowable range (0..", ")"));
        }
        this.rowNum = i5;
        RowRecord rowRecord = this.row;
        if (rowRecord != null) {
            rowRecord.setRowNumber(i5);
        }
    }

    public void setRowStyle(HSSFCellStyle hSSFCellStyle) {
        this.row.setFormatted(true);
        this.row.setXFIndex(hSSFCellStyle.getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z6) {
        this.row.setZeroHeight(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void shiftCellsLeft(int i5, int i6, int i7) {
        RowShifter.validateShiftLeftParameters(i5, i6, i7);
        while (i5 <= i6) {
            HSSFCell cell = getCell(i5);
            if (cell != null) {
                int i8 = i5 - i7;
                this.cells[i8] = null;
                moveCell(cell, (short) i8);
            } else {
                this.cells[i5 - i7] = null;
            }
            i5++;
        }
        int i9 = i6 - i7;
        while (true) {
            i9++;
            if (i9 > i6) {
                return;
            } else {
                this.cells[i9] = null;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void shiftCellsRight(int i5, int i6, int i7) {
        RowShifter.validateShiftParameters(i5, i6, i7);
        int i8 = i6 + i7 + 1;
        if (i8 > this.cells.length) {
            extend(i8);
        }
        while (i6 >= i5) {
            HSSFCell cell = getCell(i6);
            int i9 = i6 + i7;
            this.cells[i9] = null;
            if (cell != null) {
                moveCell(cell, (short) i9);
            }
            i6--;
        }
        for (int i10 = i5; i10 <= (i5 + i7) - 1; i10++) {
            this.cells[i10] = null;
        }
    }

    public HSSFRow(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet, RowRecord rowRecord) {
        int i5;
        this.book = hSSFWorkbook;
        this.sheet = hSSFSheet;
        this.row = rowRecord;
        setRowNum(rowRecord.getRowNumber());
        if (rowRecord.getLastCol() >= 0 && (i5 = INITIAL_CAPACITY) >= 0) {
            this.cells = new HSSFCell[rowRecord.getLastCol() + i5];
            rowRecord.setEmpty();
        } else {
            throw new IllegalArgumentException("Had invalid column counts: " + rowRecord.getLastCol() + " and " + INITIAL_CAPACITY);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(HSSFRow hSSFRow) {
        if (getSheet() == hSSFRow.getSheet()) {
            return Integer.compare(getRowNum(), hSSFRow.getRowNum());
        }
        throw new IllegalArgumentException("The compared rows must belong to the same sheet");
    }

    public void copyRowFrom(Row row, CellCopyPolicy cellCopyPolicy, CellCopyContext cellCopyContext) {
        if (row == null) {
            Iterator<Cell> it = iterator();
            while (it.hasNext()) {
                CellUtil.copyCell(null, it.next(), cellCopyPolicy, cellCopyContext);
            }
            if (cellCopyPolicy.isCopyMergedRegions()) {
                int rowNum = getRowNum();
                HashSet hashSet = new HashSet();
                int i5 = 0;
                for (CellRangeAddress cellRangeAddress : getSheet().getMergedRegions()) {
                    if (rowNum == cellRangeAddress.getFirstRow() && rowNum == cellRangeAddress.getLastRow()) {
                        hashSet.add(Integer.valueOf(i5));
                    }
                    i5++;
                }
                getSheet().removeMergedRegions(hashSet);
            }
            if (cellCopyPolicy.isCopyRowHeight()) {
                setHeight((short) -1);
                return;
            }
            return;
        }
        for (Cell cell : row) {
            CellUtil.copyCell(cell, createCell(cell.getColumnIndex()), cellCopyPolicy, cellCopyContext);
        }
        int sheetIndex = this.sheet.getWorkbook().getSheetIndex(this.sheet);
        String sheetName = this.sheet.getWorkbook().getSheetName(sheetIndex);
        int rowNum2 = row.getRowNum();
        int rowNum3 = getRowNum();
        new HSSFRowShifter(this.sheet).updateRowFormulas(this, FormulaShifter.createForRowCopy(sheetIndex, sheetName, rowNum2, rowNum2, rowNum3 - rowNum2, SpreadsheetVersion.EXCEL2007));
        if (cellCopyPolicy.isCopyMergedRegions()) {
            for (CellRangeAddress cellRangeAddress2 : row.getSheet().getMergedRegions()) {
                if (rowNum2 == cellRangeAddress2.getFirstRow() && rowNum2 == cellRangeAddress2.getLastRow()) {
                    CellRangeAddress cellRangeAddressCopy = cellRangeAddress2.copy();
                    cellRangeAddressCopy.setFirstRow(rowNum3);
                    cellRangeAddressCopy.setLastRow(rowNum3);
                    getSheet().addMergedRegion(cellRangeAddressCopy);
                }
            }
        }
        if (cellCopyPolicy.isCopyRowHeight()) {
            setHeight(row.getHeight());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCellStyle getRowStyle() {
        if (!isFormatted()) {
            return null;
        }
        short xFIndex = this.row.getXFIndex();
        return new HSSFCellStyle(xFIndex, this.book.getWorkbook().getExFormatAt(xFIndex), this.book);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFSheet getSheet() {
        return this.sheet;
    }

    private void removeCell(HSSFCell hSSFCell, boolean z6) {
        int columnIndex = hSSFCell.getColumnIndex();
        if (columnIndex >= 0) {
            HSSFCell[] hSSFCellArr = this.cells;
            if (columnIndex < hSSFCellArr.length && hSSFCell == hSSFCellArr[columnIndex]) {
                if (hSSFCell.isPartOfArrayFormulaGroup()) {
                    hSSFCell.tryToDeleteArrayFormula(null);
                }
                this.cells[columnIndex] = null;
                if (z6) {
                    this.sheet.getSheet().removeValueRecord(getRowNum(), hSSFCell.getCellValueRecord());
                }
                if (hSSFCell.getColumnIndex() + 1 == this.row.getLastCol()) {
                    RowRecord rowRecord = this.row;
                    rowRecord.setLastCol(calculateNewLastCellPlusOne(rowRecord.getLastCol()));
                }
                if (hSSFCell.getColumnIndex() == this.row.getFirstCol()) {
                    RowRecord rowRecord2 = this.row;
                    rowRecord2.setFirstCol(calculateNewFirstCell(rowRecord2.getFirstCol()));
                    return;
                }
                return;
            }
            throw new RuntimeException("Specified cell is not from this row");
        }
        throw new RuntimeException("Negative cell indexes not allowed");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell createCell(int i5) {
        return createCell(i5, CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell getCell(int i5) {
        return getCell(i5, this.book.getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        setRowStyle((HSSFCellStyle) cellStyle);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell createCell(int i5, CellType cellType) {
        short s6 = (short) i5;
        if (i5 > 32767) {
            s6 = (short) (65535 - i5);
        }
        HSSFCell hSSFCell = new HSSFCell(this.book, this.sheet, getRowNum(), s6, cellType);
        addCell(hSSFCell);
        this.sheet.getSheet().addValueRecord(getRowNum(), hSSFCell.getCellValueRecord());
        return hSSFCell;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell getCell(int i5, Row.MissingCellPolicy missingCellPolicy) {
        HSSFCell hSSFCellRetrieveCell = retrieveCell(i5);
        int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[missingCellPolicy.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    return hSSFCellRetrieveCell == null ? createCell(i5, CellType.BLANK) : hSSFCellRetrieveCell;
                }
                throw new IllegalArgumentException("Illegal policy " + missingCellPolicy);
            }
            if (hSSFCellRetrieveCell != null && hSSFCellRetrieveCell.getCellType() == CellType.BLANK) {
                return null;
            }
        }
        return hSSFCellRetrieveCell;
    }
}

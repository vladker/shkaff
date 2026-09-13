package org.apache.poi.xssf.usermodel;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyContext;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.helpers.RowShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFRow implements Row, Comparable<XSSFRow> {
    private final TreeMap<Integer, XSSFCell> _cells = new TreeMap<>();
    private final CTRow _row;
    private final XSSFSheet _sheet;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFRow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;
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
            int[] iArr2 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr2;
            try {
                iArr2[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public XSSFRow(CTRow cTRow, XSSFSheet xSSFSheet) {
        this._row = cTRow;
        this._sheet = xSSFSheet;
        for (CTCell cTCell : cTRow.getCArray()) {
            XSSFCell xSSFCell = new XSSFCell(this, cTCell);
            this._cells.put(Integer.valueOf(xSSFCell.getColumnIndex()), xSSFCell);
            xSSFSheet.onReadCell(xSSFCell);
        }
        if (cTRow.isSetR()) {
            return;
        }
        int lastRowNum = xSSFSheet.getLastRowNum() + 2;
        if (lastRowNum == 2 && xSSFSheet.getPhysicalNumberOfRows() == 0) {
            lastRowNum = 1;
        }
        cTRow.setR(lastRowNum);
    }

    private void fixupCTCells(CTCell[] cTCellArr) {
        CTCell[] cTCellArr2 = new CTCell[cTCellArr.length];
        IdentityHashMap identityHashMap = new IdentityHashMap(this._cells.size());
        int i5 = 0;
        int i6 = 0;
        for (CTCell cTCell : cTCellArr) {
            cTCellArr2[i6] = (CTCell) cTCell.copy();
            identityHashMap.put(cTCell, Integer.valueOf(i6));
            i6++;
        }
        for (XSSFCell xSSFCell : this._cells.values()) {
            Integer num = (Integer) identityHashMap.get(xSSFCell.getCTCell());
            Objects.requireNonNull(num, "Should find CTCell in _row");
            if (num.intValue() != i5) {
                this._row.setCArray(i5, cTCellArr2[num.intValue()]);
                xSSFCell.setCTCell(this._row.getCArray(i5));
            }
            i5++;
        }
        while (cTCellArr.length > this._cells.size()) {
            this._row.removeC(this._cells.size());
        }
    }

    private static void setDefaultValue(XSSFCell xSSFCell, CellType cellType) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            xSSFCell.setCellValue(0.0d);
            return;
        }
        if (i5 == 2) {
            xSSFCell.setCellValue("");
            return;
        }
        if (i5 == 3) {
            xSSFCell.setCellValue(false);
        } else if (i5 == 4) {
            xSSFCell.setCellErrorValue(FormulaError._NO_ERROR);
        } else {
            throw new AssertionError("Unknown cell-type specified: " + cellType);
        }
    }

    private void shiftCell(int i5, int i6) {
        int i7 = i6 + i5;
        if (i7 < 0) {
            throw new IllegalStateException("Column index less than zero : " + Integer.valueOf(i7));
        }
        XSSFCell cell = getCell(i5);
        if (cell != null) {
            cell.setCellNum(i7);
            this._cells.put(Integer.valueOf(i7), cell);
            return;
        }
        this._cells.remove(Integer.valueOf(i7));
        XSSFCell cell2 = getCell(i7);
        if (cell2 != null) {
            cell2.getCTCell().set(CTCell.Factory.newInstance());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return this._cells.values().iterator();
    }

    public void copyRowFrom(Row row, CellCopyPolicy cellCopyPolicy) {
        copyRowFrom(row, cellCopyPolicy, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFRow)) {
            return false;
        }
        XSSFRow xSSFRow = (XSSFRow) obj;
        return getRowNum() == xSSFRow.getRowNum() && getSheet() == xSSFRow.getSheet();
    }

    @Internal
    public CTRow getCTRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        return (short) (this._cells.isEmpty() ? -1 : this._cells.firstKey().intValue());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getHeight() {
        return (short) (getHeightInPoints() * 20.0f);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public float getHeightInPoints() {
        return this._row.isSetHt() ? (float) this._row.getHt() : this._sheet.getDefaultRowHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        return (short) (this._cells.isEmpty() ? -1 : this._cells.lastKey().intValue() + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getOutlineLevel() {
        return this._row.getOutlineLevel();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return Math.toIntExact(this._row.getR() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean getZeroHeight() {
        return this._row.getHidden();
    }

    public int hashCode() {
        return this._row.hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public boolean isFormatted() {
        return this._row.isSetS();
    }

    public void onDocumentWrite() {
        CTCell[] cArray = this._row.getCArray();
        if (cArray.length == this._cells.size()) {
            Iterator<XSSFCell> it = this._cells.values().iterator();
            for (CTCell cTCell : cArray) {
                XSSFCell next = it.next();
                next.applyDefaultCellStyleIfNecessary();
                if (cTCell == next.getCTCell()) {
                }
            }
            return;
        }
        fixupCTCells(cArray);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void removeCell(Cell cell) {
        if (cell.getRow() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this row");
        }
        if (!this._cells.containsValue(cell)) {
            throw new IllegalArgumentException("the row does not contain this cell");
        }
        XSSFCell xSSFCell = (XSSFCell) cell;
        if (xSSFCell.isPartOfArrayFormulaGroup()) {
            xSSFCell.setCellFormula(null);
        }
        if (cell.getCellType() == CellType.FORMULA) {
            this._sheet.getWorkbook().onDeleteFormula(xSSFCell);
        }
        XSSFCell xSSFCellRemove = this._cells.remove(Integer.valueOf(cell.getColumnIndex()));
        int i5 = 0;
        for (CTCell cTCell : this._row.getCArray()) {
            if (cTCell == xSSFCellRemove.getCTCell()) {
                this._row.removeC(i5);
            }
            i5++;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeight(short s6) {
        if (s6 != -1) {
            this._row.setHt(((double) s6) / 20.0d);
            this._row.setCustomHeight(true);
            return;
        }
        if (this._row.isSetHt()) {
            this._row.unsetHt();
        }
        if (this._row.isSetCustomHeight()) {
            this._row.unsetCustomHeight();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setHeightInPoints(float f6) {
        setHeight((short) (f6 != -1.0f ? 20.0f * f6 : -1.0f));
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowNum(int i5) {
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (i5 < 0 || i5 > lastRowIndex) {
            throw new IllegalArgumentException(androidx.collection.a.m("Invalid row number (", i5, lastRowIndex, ") outside allowable range (0..", ")"));
        }
        this._row.setR(((long) i5) + 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setRowStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            if (this._row.isSetS()) {
                this._row.unsetS();
                this._row.unsetCustomFormat();
                return;
            }
            return;
        }
        StylesTable stylesSource = getSheet().getWorkbook().getStylesSource();
        XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
        xSSFCellStyle.verifyBelongsToStylesSource(stylesSource);
        this._row.setS(stylesSource.putStyle(xSSFCellStyle));
        this._row.setCustomFormat(true);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void setZeroHeight(boolean z6) {
        this._row.setHidden(z6);
    }

    public void shift(int i5) {
        int rowNum = getRowNum();
        int i6 = i5 + rowNum;
        String str = "Row[rownum=" + rowNum + "] contains cell(s) included in a multi-cell array formula. You cannot change part of an array.";
        setRowNum(i6);
        Iterator<Cell> it = iterator();
        while (it.hasNext()) {
            ((XSSFCell) it.next()).updateCellReferencesForShifting(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void shiftCellsLeft(int i5, int i6, int i7) {
        RowShifter.validateShiftLeftParameters(i5, i6, i7);
        while (i5 <= i6) {
            shiftCell(i5, -i7);
            i5++;
        }
        int i8 = i6 - i7;
        while (true) {
            i8++;
            if (i8 > i6) {
                return;
            }
            this._cells.remove(Integer.valueOf(i8));
            XSSFCell cell = getCell(i8);
            if (cell != null) {
                cell.getCTCell().set(CTCell.Factory.newInstance());
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public void shiftCellsRight(int i5, int i6, int i7) {
        RowShifter.validateShiftParameters(i5, i6, i7);
        while (i6 >= i5) {
            shiftCell(i6, i7);
            i6--;
        }
        for (int i8 = i5; i8 <= (i5 + i7) - 1; i8++) {
            this._cells.remove(Integer.valueOf(i8));
            XSSFCell cell = getCell(i8);
            if (cell != null) {
                cell.getCTCell().set(CTCell.Factory.newInstance());
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row, java.lang.Iterable
    public Spliterator<Cell> spliterator() {
        return this._cells.values().spliterator();
    }

    public String toString() {
        return this._row.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(XSSFRow xSSFRow) {
        if (getSheet() == xSSFRow.getSheet()) {
            return Integer.compare(getRowNum(), xSSFRow.getRowNum());
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
        int sheetIndex = this._sheet.getWorkbook().getSheetIndex(this._sheet);
        String sheetName = this._sheet.getWorkbook().getSheetName(sheetIndex);
        int rowNum2 = row.getRowNum();
        int rowNum3 = getRowNum();
        new XSSFRowShifter(this._sheet).updateRowFormulas(this, FormulaShifter.createForRowCopy(sheetIndex, sheetName, rowNum2, rowNum2, rowNum3 - rowNum2, SpreadsheetVersion.EXCEL2007));
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
    public XSSFCellStyle getRowStyle() {
        if (!isFormatted()) {
            return null;
        }
        StylesTable stylesSource = getSheet().getWorkbook().getStylesSource();
        if (stylesSource.getNumCellStyles() > 0) {
            return stylesSource.getStyleAt(Math.toIntExact(this._row.getS()));
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i5) {
        return createCell(i5, CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int i5) {
        return getCell(i5, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell createCell(int i5, CellType cellType) {
        CTCell cTCellAddNewC;
        Integer numValueOf = Integer.valueOf(i5);
        XSSFCell xSSFCell = this._cells.get(numValueOf);
        if (xSSFCell != null) {
            cTCellAddNewC = xSSFCell.getCTCell();
            cTCellAddNewC.set(CTCell.Factory.newInstance());
        } else {
            cTCellAddNewC = this._row.addNewC();
        }
        XSSFCell xSSFCell2 = new XSSFCell(this, cTCellAddNewC);
        try {
            xSSFCell2.setCellNum(i5);
            if (cellType != CellType.BLANK && cellType != CellType.FORMULA) {
                setDefaultValue(xSSFCell2, cellType);
            }
            this._cells.put(numValueOf, xSSFCell2);
            return xSSFCell2;
        } catch (IllegalArgumentException e) {
            this._row.removeC(this._row.getCList().size() - 1);
            throw e;
        }
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int i5, Row.MissingCellPolicy missingCellPolicy) {
        if (i5 >= 0) {
            XSSFCell xSSFCell = this._cells.get(Integer.valueOf(i5));
            int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[missingCellPolicy.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3) {
                        return xSSFCell == null ? createCell(i5, CellType.BLANK) : xSSFCell;
                    }
                    throw new IllegalArgumentException("Illegal policy " + missingCellPolicy);
                }
                if (xSSFCell != null && xSSFCell.getCellType() == CellType.BLANK) {
                    return null;
                }
            }
            return xSSFCell;
        }
        throw new IllegalArgumentException("Cell index must be >= 0");
    }
}

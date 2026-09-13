package org.apache.poi.ss.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RangeCopier {
    private Sheet destSheet;
    private FormulaShifter horizontalFormulaShifter;
    private Sheet sourceSheet;
    private FormulaShifter verticalFormulaShifter;

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.RangeCopier$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public RangeCopier(Sheet sheet, Sheet sheet2) {
        this.sourceSheet = sheet;
        this.destSheet = sheet2;
    }

    public static void cloneCellContent(Cell cell, Cell cell2, Map<Integer, CellStyle> map) {
        if (map != null) {
            if (cell.getSheet().getWorkbook() == cell2.getSheet().getWorkbook()) {
                cell2.setCellStyle(cell.getCellStyle());
            } else {
                int iHashCode = cell.getCellStyle().hashCode();
                CellStyle cellStyleCreateCellStyle = map.get(Integer.valueOf(iHashCode));
                if (cellStyleCreateCellStyle == null) {
                    cellStyleCreateCellStyle = cell2.getSheet().getWorkbook().createCellStyle();
                    cellStyleCreateCellStyle.cloneStyleFrom(cell.getCellStyle());
                    map.put(Integer.valueOf(iHashCode), cellStyleCreateCellStyle);
                }
                cell2.setCellStyle(cellStyleCreateCellStyle);
            }
        }
        switch (AnonymousClass2.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cell.getCellType().ordinal()]) {
            case 1:
                cell2.setCellValue(cell.getStringCellValue());
                break;
            case 2:
                cell2.setCellValue(cell.getNumericCellValue());
                break;
            case 3:
                cell2.setBlank();
                break;
            case 4:
                cell2.setCellValue(cell.getBooleanCellValue());
                break;
            case 5:
                cell2.setCellErrorValue(cell.getErrorCellValue());
                break;
            case 6:
                cell2.setCellFormula(cell.getCellFormula());
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyRange$0(CellRangeAddress cellRangeAddress) {
        this.destSheet.addMergedRegion(cellRangeAddress);
    }

    public abstract void adjustCellReferencesInsideFormula(Cell cell, Sheet sheet, int i5, int i6);

    public boolean adjustInBothDirections(Ptg[] ptgArr, int i5, int i6, int i7) {
        boolean zAdjustFormula = i7 != 0 ? this.verticalFormulaShifter.adjustFormula(ptgArr, i5) : true;
        if (i6 != 0) {
            return zAdjustFormula && this.horizontalFormulaShifter.adjustFormula(ptgArr, i5);
        }
        return zAdjustFormula;
    }

    public void copyRange(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        copyRange(cellRangeAddress, cellRangeAddress2, false, false);
    }

    public void copyRange(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2, boolean z6, boolean z7) {
        Sheet sheetCloneSheet = this.sourceSheet.getWorkbook().cloneSheet(this.sourceSheet.getWorkbook().getSheetIndex(this.sourceSheet));
        HashMap<Integer, CellStyle> map = z6 ? new HashMap<Integer, CellStyle>() { // from class: org.apache.poi.ss.usermodel.RangeCopier.1
        } : null;
        int lastColumn = cellRangeAddress.getLastColumn() - cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow();
        int firstRow = cellRangeAddress2.getFirstRow();
        do {
            int firstColumn = cellRangeAddress2.getFirstColumn();
            int iMin = Math.min(lastRow, cellRangeAddress2.getLastRow() - firstRow);
            int firstRow2 = cellRangeAddress.getFirstRow() + iMin;
            int i5 = firstColumn;
            do {
                int iMin2 = Math.min(lastColumn, cellRangeAddress2.getLastColumn() - i5);
                CellRangeAddress cellRangeAddress3 = new CellRangeAddress(cellRangeAddress.getFirstRow(), firstRow2, cellRangeAddress.getFirstColumn(), cellRangeAddress.getFirstColumn() + iMin2);
                copyRange(cellRangeAddress3, i5 - cellRangeAddress3.getFirstColumn(), firstRow - cellRangeAddress3.getFirstRow(), sheetCloneSheet, map);
                i5 += iMin2 + 1;
            } while (i5 <= cellRangeAddress2.getLastColumn());
            firstRow += iMin + 1;
        } while (firstRow <= cellRangeAddress2.getLastRow());
        if (z7) {
            this.sourceSheet.getMergedRegions().forEach(new b(this, 0));
        }
        this.sourceSheet.getWorkbook().removeSheetAt(this.sourceSheet.getWorkbook().getSheetIndex(sheetCloneSheet));
    }

    public RangeCopier(Sheet sheet) {
        this(sheet, sheet);
    }

    private void copyRange(CellRangeAddress cellRangeAddress, int i5, int i6, Sheet sheet, Map<Integer, CellStyle> map) {
        if (i5 != 0) {
            this.horizontalFormulaShifter = FormulaShifter.createForColumnCopy(this.sourceSheet.getWorkbook().getSheetIndex(this.sourceSheet), this.sourceSheet.getSheetName(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), i5, this.sourceSheet.getWorkbook().getSpreadsheetVersion());
        }
        if (i6 != 0) {
            this.verticalFormulaShifter = FormulaShifter.createForRowCopy(this.sourceSheet.getWorkbook().getSheetIndex(this.sourceSheet), this.sourceSheet.getSheetName(), cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), i6, this.sourceSheet.getWorkbook().getSpreadsheetVersion());
        }
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            Row row = sheet.getRow(firstRow);
            if (row != null) {
                for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                    Cell cell = row.getCell(firstColumn);
                    if (cell != null) {
                        int i7 = firstRow + i6;
                        Row row2 = this.destSheet.getRow(i7);
                        if (row2 == null) {
                            row2 = this.destSheet.createRow(i7);
                        }
                        int i8 = firstColumn + i5;
                        Cell cell2 = row2.getCell(i8);
                        if (cell2 == null) {
                            cell2 = row2.createCell(i8);
                        }
                        cloneCellContent(cell, cell2, map);
                        if (cell2.getCellType() == CellType.FORMULA) {
                            adjustCellReferencesInsideFormula(cell2, this.destSheet, i5, i6);
                        }
                    }
                }
            }
        }
    }
}

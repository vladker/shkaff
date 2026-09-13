package org.apache.poi.ss.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SheetBuilder {
    private final Object[][] cells;
    private String sheetName;
    private boolean shouldCreateEmptyCells;
    private final Workbook workbook;

    public SheetBuilder(Workbook workbook, Object[][] objArr) {
        this.workbook = workbook;
        this.cells = (Object[][]) objArr.clone();
    }

    private String getFormula(Object obj) {
        return ((String) obj).substring(1);
    }

    private boolean isFormulaDefinition(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() >= 2 && str.charAt(0) == '=') {
                return true;
            }
        }
        return false;
    }

    private void setCellValue(Cell cell, Object obj) {
        if (obj == null || cell == null) {
            return;
        }
        if (obj instanceof Number) {
            cell.setCellValue(((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Date) {
            cell.setCellValue((Date) obj);
            return;
        }
        if (obj instanceof Calendar) {
            cell.setCellValue((Calendar) obj);
        } else if (isFormulaDefinition(obj)) {
            cell.setCellFormula(getFormula(obj));
        } else {
            cell.setCellValue(obj.toString());
        }
    }

    public Sheet build() {
        String str = this.sheetName;
        Sheet sheetCreateSheet = str == null ? this.workbook.createSheet() : this.workbook.createSheet(str);
        int i5 = 0;
        while (true) {
            Object[][] objArr = this.cells;
            if (i5 >= objArr.length) {
                return sheetCreateSheet;
            }
            Object[] objArr2 = objArr[i5];
            Row rowCreateRow = sheetCreateSheet.createRow(i5);
            for (int i6 = 0; i6 < objArr2.length; i6++) {
                Object obj = objArr2[i6];
                if (obj != null || this.shouldCreateEmptyCells) {
                    setCellValue(rowCreateRow.createCell(i6), obj);
                }
            }
            i5++;
        }
    }

    public boolean getCreateEmptyCells() {
        return this.shouldCreateEmptyCells;
    }

    public SheetBuilder setCreateEmptyCells(boolean z6) {
        this.shouldCreateEmptyCells = z6;
        return this;
    }

    public SheetBuilder setSheetName(String str) {
        this.sheetName = str;
        return this;
    }
}

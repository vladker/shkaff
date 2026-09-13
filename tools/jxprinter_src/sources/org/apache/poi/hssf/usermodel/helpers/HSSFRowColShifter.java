package org.apache.poi.hssf.usermodel.helpers;

import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
final class HSSFRowColShifter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) HSSFRowColShifter.class);

    private HSSFRowColShifter() {
    }

    public static String shiftFormula(Row row, String str, FormulaShifter formulaShifter) {
        Sheet sheet = row.getSheet();
        Workbook workbook = sheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(sheet);
        int rowNum = row.getRowNum();
        HSSFEvaluationWorkbook hSSFEvaluationWorkbookCreate = HSSFEvaluationWorkbook.create((HSSFWorkbook) workbook);
        try {
            Ptg[] ptgArr = FormulaParser.parse(str, hSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, rowNum);
            return formulaShifter.adjustFormula(ptgArr, sheetIndex) ? FormulaRenderer.toFormulaString(hSSFEvaluationWorkbookCreate, ptgArr) : str;
        } catch (FormulaParseException e) {
            LOG.atWarn().withThrowable(e).log("Error shifting formula on row {}", Unbox.box(row.getRowNum()));
            return str;
        }
    }

    public static void updateFormulas(Sheet sheet, FormulaShifter formulaShifter) {
        updateSheetFormulas(sheet, formulaShifter);
        for (Sheet sheet2 : sheet.getWorkbook()) {
            if (sheet != sheet2) {
                updateSheetFormulas(sheet2, formulaShifter);
            }
        }
    }

    public static void updateRowFormulas(HSSFRow hSSFRow, FormulaShifter formulaShifter) {
        hSSFRow.getSheet();
        Iterator<Cell> it = hSSFRow.iterator();
        while (it.hasNext()) {
            HSSFCell hSSFCell = (HSSFCell) it.next();
            String cellFormula = hSSFCell.getCellFormula();
            if (cellFormula.length() > 0) {
                hSSFCell.setCellFormula(shiftFormula(hSSFRow, cellFormula, formulaShifter));
            }
        }
    }

    public static void updateSheetFormulas(Sheet sheet, FormulaShifter formulaShifter) {
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            updateRowFormulas((HSSFRow) it.next(), formulaShifter);
        }
    }
}

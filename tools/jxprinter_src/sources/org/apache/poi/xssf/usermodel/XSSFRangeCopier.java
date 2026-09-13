package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RangeCopier;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFRangeCopier extends RangeCopier {
    public XSSFRangeCopier(Sheet sheet, Sheet sheet2) {
        super(sheet, sheet2);
    }

    @Override // org.apache.poi.ss.usermodel.RangeCopier
    public void adjustCellReferencesInsideFormula(Cell cell, Sheet sheet, int i5, int i6) {
        XSSFWorkbook xSSFWorkbook = (XSSFWorkbook) sheet.getWorkbook();
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create(xSSFWorkbook);
        Ptg[] ptgArr = FormulaParser.parse(cell.getCellFormula(), xSSFEvaluationWorkbookCreate, FormulaType.CELL, 0);
        if (adjustInBothDirections(ptgArr, xSSFWorkbook.getSheetIndex(sheet), i5, i6)) {
            cell.setCellFormula(FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
        }
    }

    public XSSFRangeCopier(Sheet sheet) {
        super(sheet);
    }
}

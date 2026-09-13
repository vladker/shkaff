package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RangeCopier;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFRangeCopier extends RangeCopier {
    public HSSFRangeCopier(Sheet sheet, Sheet sheet2) {
        super(sheet, sheet2);
    }

    @Override // org.apache.poi.ss.usermodel.RangeCopier
    public void adjustCellReferencesInsideFormula(Cell cell, Sheet sheet, int i5, int i6) {
        FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate) ((HSSFCell) cell).getCellValueRecord();
        int sheetIndex = sheet.getWorkbook().getSheetIndex(sheet);
        Ptg[] formulaTokens = formulaRecordAggregate.getFormulaTokens();
        if (adjustInBothDirections(formulaTokens, sheetIndex, i5, i6)) {
            formulaRecordAggregate.setParsedExpression(formulaTokens);
        }
    }

    public HSSFRangeCopier(Sheet sheet) {
        super(sheet);
    }
}

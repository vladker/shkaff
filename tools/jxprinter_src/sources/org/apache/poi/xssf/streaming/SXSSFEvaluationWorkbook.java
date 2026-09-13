package org.apache.poi.xssf.streaming;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.BaseXSSFEvaluationWorkbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class SXSSFEvaluationWorkbook extends BaseXSSFEvaluationWorkbook {
    private final SXSSFWorkbook _sxssfBook;

    private SXSSFEvaluationWorkbook(SXSSFWorkbook sXSSFWorkbook) {
        super(sXSSFWorkbook.getXSSFWorkbook());
        this._sxssfBook = sXSSFWorkbook;
    }

    public static SXSSFEvaluationWorkbook create(SXSSFWorkbook sXSSFWorkbook) {
        if (sXSSFWorkbook == null) {
            return null;
        }
        return new SXSSFEvaluationWorkbook(sXSSFWorkbook);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell evaluationCell) {
        SXSSFCell sXSSFCell = ((SXSSFEvaluationCell) evaluationCell).getSXSSFCell();
        return FormulaParser.parse(sXSSFCell.getCellFormula(), this, FormulaType.CELL, this._sxssfBook.getSheetIndex(sXSSFCell.getSheet()));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int i5) {
        return new SXSSFEvaluationSheet(this._sxssfBook.getSheetAt(i5));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet evaluationSheet) {
        return this._sxssfBook.getSheetIndex(((SXSSFEvaluationSheet) evaluationSheet).getSXSSFSheet());
    }
}

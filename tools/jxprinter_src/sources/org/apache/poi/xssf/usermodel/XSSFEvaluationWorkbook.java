package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class XSSFEvaluationWorkbook extends BaseXSSFEvaluationWorkbook {
    private final Map<XSSFSheet, XSSFEvaluationSheet> _sheetCache;

    private XSSFEvaluationWorkbook(XSSFWorkbook xSSFWorkbook) {
        super(xSSFWorkbook);
        this._sheetCache = new HashMap();
    }

    public static XSSFEvaluationWorkbook create(XSSFWorkbook xSSFWorkbook) {
        if (xSSFWorkbook == null) {
            return null;
        }
        return new XSSFEvaluationWorkbook(xSSFWorkbook);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XSSFEvaluationSheet lambda$getSheet$0(XSSFSheet xSSFSheet, XSSFSheet xSSFSheet2) {
        return new XSSFEvaluationSheet(xSSFSheet);
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFEvaluationWorkbook, org.apache.poi.ss.formula.EvaluationWorkbook
    public void clearAllCachedResultValues() {
        super.clearAllCachedResultValues();
        this._sheetCache.clear();
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell evaluationCell) {
        XSSFCell xSSFCell = ((XSSFEvaluationCell) evaluationCell).getXSSFCell();
        return FormulaParser.parse(xSSFCell.getCellFormula(this), this, FormulaType.CELL, this._uBook.getSheetIndex(xSSFCell.getSheet()), xSSFCell.getRowIndex());
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int i5) {
        if (i5 < 0 || i5 >= this._uBook.getNumberOfSheets()) {
            this._uBook.getSheetAt(i5);
        }
        XSSFSheet sheetAt = this._uBook.getSheetAt(i5);
        return this._sheetCache.computeIfAbsent(sheetAt, new com.google.android.material.color.utilities.a(sheetAt, 7));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet evaluationSheet) {
        return this._uBook.getSheetIndex(((XSSFEvaluationSheet) evaluationSheet).getXSSFSheet());
    }
}

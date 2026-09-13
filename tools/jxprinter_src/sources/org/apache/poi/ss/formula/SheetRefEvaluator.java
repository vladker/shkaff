package org.apache.poi.ss.formula;

import com.alibaba.android.arouter.utils.Consts;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class SheetRefEvaluator {
    private final WorkbookEvaluator _bookEvaluator;
    private EvaluationSheet _sheet;
    private final int _sheetIndex;
    private final EvaluationTracker _tracker;

    public SheetRefEvaluator(WorkbookEvaluator workbookEvaluator, EvaluationTracker evaluationTracker, int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Invalid sheetIndex: ", Consts.DOT));
        }
        this._bookEvaluator = workbookEvaluator;
        this._tracker = evaluationTracker;
        this._sheetIndex = i5;
    }

    private EvaluationSheet getSheet() {
        if (this._sheet == null) {
            this._sheet = this._bookEvaluator.getSheet(this._sheetIndex);
        }
        return this._sheet;
    }

    public ValueEval getEvalForCell(int i5, int i6) {
        return this._bookEvaluator.evaluateReference(getSheet(), this._sheetIndex, i5, i6, this._tracker);
    }

    public int getLastRowNum() {
        return getSheet().getLastRowNum();
    }

    public int getMaxRowNum() {
        return this._bookEvaluator.getWorkbook().getSpreadsheetVersion().getLastRowIndex();
    }

    public String getSheetName() {
        return this._bookEvaluator.getSheetName(this._sheetIndex);
    }

    public boolean isRowHidden(int i5) {
        return getSheet().isRowHidden(i5);
    }

    public boolean isSubTotal(int i5, int i6) {
        EvaluationCell cell = getSheet().getCell(i5, i6);
        if (cell != null && cell.getCellType() == CellType.FORMULA) {
            for (Ptg ptg : this._bookEvaluator.getWorkbook().getFormulaTokens(cell)) {
                if ((ptg instanceof FuncVarPtg) && "SUBTOTAL".equals(((FuncVarPtg) ptg).getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}

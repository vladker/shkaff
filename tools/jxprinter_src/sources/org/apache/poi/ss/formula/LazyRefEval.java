package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.RefEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyRefEval extends RefEvalBase {
    private final SheetRangeEvaluator _evaluator;

    public LazyRefEval(int i5, int i6, SheetRangeEvaluator sheetRangeEvaluator) {
        super(sheetRangeEvaluator, i5, i6);
        this._evaluator = sheetRangeEvaluator;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public ValueEval getInnerValueEval(int i5) {
        return this._evaluator.getEvalForCell(i5, getRow(), getColumn());
    }

    public boolean isRowHidden() {
        SheetRangeEvaluator sheetRangeEvaluator = this._evaluator;
        return sheetRangeEvaluator.getSheetEvaluator(sheetRangeEvaluator.getFirstSheetIndex()).isRowHidden(getRow());
    }

    public boolean isSubTotal() {
        return this._evaluator.getSheetEvaluator(getFirstSheetIndex()).isSubTotal(getRow(), getColumn());
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public AreaEval offset(int i5, int i6, int i7, int i8) {
        return new LazyAreaEval(new AreaI.OffsetArea(getRow(), getColumn(), i5, i6, i7, i8), this._evaluator);
    }

    public String toString() {
        CellReference cellReference = new CellReference(getRow(), getColumn());
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(LazyRefEval.class, sb, "[");
        sb.append(this._evaluator.getSheetNameRange());
        sb.append('!');
        sb.append(cellReference.formatAsString());
        sb.append("]");
        return sb.toString();
    }
}

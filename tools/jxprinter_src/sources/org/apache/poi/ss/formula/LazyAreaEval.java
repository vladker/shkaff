package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class LazyAreaEval extends AreaEvalBase {
    private final SheetRangeEvaluator _evaluator;

    public LazyAreaEval(AreaI areaI, SheetRangeEvaluator sheetRangeEvaluator) {
        super(areaI, sheetRangeEvaluator);
        this._evaluator = sheetRangeEvaluator;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.eval.AreaEval
    public ValueEval getRelativeValue(int i5, int i6) {
        return getRelativeValue(getFirstSheetIndex(), i5, i6);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.TwoDEval
    public boolean isRowHidden(int i5) {
        SheetRangeEvaluator sheetRangeEvaluator = this._evaluator;
        return sheetRangeEvaluator.getSheetEvaluator(sheetRangeEvaluator.getFirstSheetIndex()).isRowHidden(getFirstRow() + i5);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.TwoDEval
    public boolean isSubTotal(int i5, int i6) {
        SheetRangeEvaluator sheetRangeEvaluator = this._evaluator;
        return sheetRangeEvaluator.getSheetEvaluator(sheetRangeEvaluator.getFirstSheetIndex()).isSubTotal(getFirstRow() + i5, getFirstColumn() + i6);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public AreaEval offset(int i5, int i6, int i7, int i8) {
        return new LazyAreaEval(new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), i5, i6, i7, i8), this._evaluator);
    }

    public String toString() {
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn());
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn());
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(LazyAreaEval.class, sb, "[");
        sb.append(this._evaluator.getSheetNameRange());
        sb.append('!');
        sb.append(cellReference.formatAsString());
        sb.append(NameUtil.COLON);
        sb.append(cellReference2.formatAsString());
        sb.append("]");
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getColumn(int i5) {
        if (i5 < getWidth()) {
            int firstColumn = getFirstColumn() + i5;
            return new LazyAreaEval(getFirstRow(), firstColumn, getLastRow(), firstColumn, this._evaluator);
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Invalid columnIndex ", ".  Allowable range is (0..");
        sbT.append(getWidth());
        sbT.append(").");
        throw new IllegalArgumentException(sbT.toString());
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase
    public ValueEval getRelativeValue(int i5, int i6, int i7) {
        return this._evaluator.getEvalForCell(i5, getFirstRow() + i6, getFirstColumn() + i7);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getRow(int i5) {
        if (i5 < getHeight()) {
            int firstRow = getFirstRow() + i5;
            return new LazyAreaEval(firstRow, getFirstColumn(), firstRow, getLastColumn(), this._evaluator);
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Invalid rowIndex ", ".  Allowable range is (0..");
        sbT.append(getHeight());
        sbT.append(").");
        throw new IllegalArgumentException(sbT.toString());
    }

    public LazyAreaEval(int i5, int i6, int i7, int i8, SheetRangeEvaluator sheetRangeEvaluator) {
        super(sheetRangeEvaluator, i5, i6, sheetRangeEvaluator.adjustRowNumber(i7), i8);
        this._evaluator = sheetRangeEvaluator;
    }
}

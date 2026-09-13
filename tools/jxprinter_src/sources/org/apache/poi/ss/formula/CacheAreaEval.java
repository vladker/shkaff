package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CacheAreaEval extends AreaEvalBase {
    private final ValueEval[] _values;

    public CacheAreaEval(AreaI areaI, ValueEval[] valueEvalArr) {
        super(areaI);
        this._values = valueEvalArr;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public TwoDEval getColumn(int i5) {
        if (i5 >= getWidth()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Invalid columnIndex ", ".  Allowable range is (0..");
            sbT.append(getWidth());
            sbT.append(").");
            throw new IllegalArgumentException(sbT.toString());
        }
        int firstColumn = getFirstColumn() + i5;
        int height = getHeight();
        ValueEval[] valueEvalArr = new ValueEval[height];
        for (int i6 = 0; i6 < height; i6++) {
            valueEvalArr[i6] = getRelativeValue(i6, i5);
        }
        return new CacheAreaEval(getFirstRow(), firstColumn, getLastRow(), firstColumn, valueEvalArr);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.eval.AreaEval
    public ValueEval getRelativeValue(int i5, int i6) {
        return getRelativeValue(-1, i5, i6);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public TwoDEval getRow(int i5) {
        if (i5 >= getHeight()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Invalid rowIndex ", ".  Allowable range is (0..");
            sbT.append(getHeight());
            sbT.append(").");
            throw new IllegalArgumentException(sbT.toString());
        }
        int firstRow = getFirstRow() + i5;
        int width = getWidth();
        ValueEval[] valueEvalArr = new ValueEval[width];
        for (int i6 = 0; i6 < width; i6++) {
            valueEvalArr[i6] = getRelativeValue(i5, i6);
        }
        return new CacheAreaEval(firstRow, getFirstColumn(), firstRow, getLastColumn(), valueEvalArr);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public AreaEval offset(int i5, int i6, int i7, int i8) {
        int i9;
        AreaI.OffsetArea offsetArea = new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), i5, i6, i7, i8);
        int lastRow = (offsetArea.getLastRow() - offsetArea.getFirstRow()) + 1;
        int lastColumn = (offsetArea.getLastColumn() - offsetArea.getFirstColumn()) + 1;
        ValueEval[] valueEvalArr = new ValueEval[lastRow * lastColumn];
        int firstRow = offsetArea.getFirstRow() - getFirstRow();
        int firstColumn = offsetArea.getFirstColumn() - getFirstColumn();
        for (int i10 = 0; i10 < lastRow; i10++) {
            for (int i11 = 0; i11 < lastColumn; i11++) {
                int i12 = firstRow + i10;
                valueEvalArr[(i10 * lastColumn) + i11] = (i12 > getLastRow() || (i9 = firstColumn + i11) > getLastColumn()) ? BlankEval.instance : this._values[(getWidth() * i12) + i9];
            }
        }
        return new CacheAreaEval(offsetArea, valueEvalArr);
    }

    public String toString() {
        return CacheAreaEval.class.getName() + "[" + new CellReference(getFirstRow(), getFirstColumn()).formatAsString() + NameUtil.COLON + new CellReference(getLastRow(), getLastColumn()).formatAsString() + "]";
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase
    public ValueEval getRelativeValue(int i5, int i6, int i7) {
        return this._values[(getWidth() * i6) + i7];
    }

    public CacheAreaEval(int i5, int i6, int i7, int i8, ValueEval[] valueEvalArr) {
        super(i5, i6, i7, i8);
        this._values = valueEvalArr;
    }
}

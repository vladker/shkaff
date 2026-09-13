package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class SheetRangeEvaluator implements SheetRange {
    private final int _firstSheetIndex;
    private final int _lastSheetIndex;
    private final SheetRefEvaluator[] _sheetEvaluators;

    public SheetRangeEvaluator(int i5, int i6, SheetRefEvaluator[] sheetRefEvaluatorArr) {
        if (i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Invalid firstSheetIndex: ", Consts.DOT));
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(androidx.collection.a.m("Invalid lastSheetIndex: ", i6, i5, " for firstSheetIndex: ", Consts.DOT));
        }
        this._firstSheetIndex = i5;
        this._lastSheetIndex = i6;
        this._sheetEvaluators = (SheetRefEvaluator[]) sheetRefEvaluatorArr.clone();
    }

    public int adjustRowNumber(int i5) {
        int iMax = 0;
        boolean z6 = false;
        for (int i6 = this._firstSheetIndex; i6 <= this._lastSheetIndex; i6++) {
            if (i5 >= this._sheetEvaluators[i6 - this._firstSheetIndex].getMaxRowNum()) {
                z6 = true;
            }
        }
        if (!z6) {
            return i5;
        }
        for (int i7 = this._firstSheetIndex; i7 <= this._lastSheetIndex; i7++) {
            iMax = Math.max(iMax, this._sheetEvaluators[i7 - this._firstSheetIndex].getLastRowNum());
        }
        return Math.min(i5, iMax);
    }

    public ValueEval getEvalForCell(int i5, int i6, int i7) {
        return getSheetEvaluator(i5).getEvalForCell(i6, i7);
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheetIndex;
    }

    public SheetRefEvaluator getSheetEvaluator(int i5) {
        int i6 = this._firstSheetIndex;
        if (i5 >= i6 && i5 <= this._lastSheetIndex) {
            return this._sheetEvaluators[i5 - i6];
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Invalid SheetIndex: ", " - Outside range ");
        sbT.append(this._firstSheetIndex);
        sbT.append(" : ");
        sbT.append(this._lastSheetIndex);
        throw new IllegalArgumentException(sbT.toString());
    }

    public String getSheetName(int i5) {
        return getSheetEvaluator(i5).getSheetName();
    }

    public String getSheetNameRange() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSheetName(this._firstSheetIndex));
        if (this._firstSheetIndex != this._lastSheetIndex) {
            sb.append(NameUtil.COLON);
            sb.append(getSheetName(this._lastSheetIndex));
        }
        return sb.toString();
    }

    public SheetRangeEvaluator(int i5, SheetRefEvaluator sheetRefEvaluator) {
        this(i5, i5, new SheetRefEvaluator[]{sheetRefEvaluator});
    }
}

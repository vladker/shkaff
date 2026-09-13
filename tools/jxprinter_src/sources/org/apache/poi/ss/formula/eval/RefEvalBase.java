package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RefEvalBase implements RefEval {
    private final int _columnIndex;
    private final int _firstSheetIndex;
    private final int _lastSheetIndex;
    private final int _rowIndex;

    public RefEvalBase(SheetRange sheetRange, int i5, int i6) {
        if (sheetRange == null) {
            throw new IllegalArgumentException("sheetRange must not be null");
        }
        this._firstSheetIndex = sheetRange.getFirstSheetIndex();
        this._lastSheetIndex = sheetRange.getLastSheetIndex();
        this._rowIndex = i5;
        this._columnIndex = i6;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public final int getColumn() {
        return this._columnIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval, org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval, org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public int getNumberOfSheets() {
        return (this._lastSheetIndex - this._firstSheetIndex) + 1;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public final int getRow() {
        return this._rowIndex;
    }

    public RefEvalBase(int i5, int i6, int i7, int i8) {
        this._firstSheetIndex = i5;
        this._lastSheetIndex = i6;
        this._rowIndex = i7;
        this._columnIndex = i8;
    }

    public RefEvalBase(int i5, int i6, int i7) {
        this(i5, i5, i6, i7);
    }
}

package org.apache.poi.ss.formula.eval;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.SheetRange;
import org.apache.poi.ss.formula.ptg.AreaI;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AreaEvalBase implements AreaEval {
    private final int _firstColumn;
    private final int _firstRow;
    private final int _firstSheet;
    private final int _lastColumn;
    private final int _lastRow;
    private final int _lastSheet;
    private final int _nColumns;
    private final int _nRows;

    public AreaEvalBase(SheetRange sheetRange, int i5, int i6, int i7, int i8) {
        this._firstColumn = i6;
        this._firstRow = i5;
        this._lastColumn = i8;
        this._lastRow = i7;
        this._nColumns = (i8 - i6) + 1;
        this._nRows = (i7 - i5) + 1;
        if (sheetRange != null) {
            this._firstSheet = sheetRange.getFirstSheetIndex();
            this._lastSheet = sheetRange.getLastSheetIndex();
        } else {
            this._firstSheet = -1;
            this._lastSheet = -1;
        }
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final boolean contains(int i5, int i6) {
        return this._firstRow <= i5 && this._lastRow >= i5 && this._firstColumn <= i6 && this._lastColumn >= i6;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final boolean containsColumn(int i5) {
        return this._firstColumn <= i5 && this._lastColumn >= i5;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final boolean containsRow(int i5) {
        return this._firstRow <= i5 && this._lastRow >= i5;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final ValueEval getAbsoluteValue(int i5, int i6) {
        int i7 = i5 - this._firstRow;
        int i8 = i6 - this._firstColumn;
        if (i7 < 0 || i7 >= this._nRows) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified row index (", ") is outside the allowed range (");
            sbT.append(this._firstRow);
            sbT.append("..");
            throw new IllegalArgumentException(AbstractC0157z.l(")", this._lastRow, sbT));
        }
        if (i8 >= 0 && i8 < this._nColumns) {
            return getRelativeValue(i7, i8);
        }
        StringBuilder sbT2 = AbstractC0157z.t(i6, "Specified column index (", ") is outside the allowed range (");
        sbT2.append(this._firstColumn);
        sbT2.append("..");
        sbT2.append(i6);
        sbT2.append(")");
        throw new IllegalArgumentException(sbT2.toString());
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getFirstColumn() {
        return this._firstColumn;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getFirstRow() {
        return this._firstRow;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheet;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval, org.apache.poi.ss.formula.TwoDEval
    public int getHeight() {
        return (this._lastRow - this._firstRow) + 1;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getLastColumn() {
        return this._lastColumn;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getLastRow() {
        return this._lastRow;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheet;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public abstract ValueEval getRelativeValue(int i5, int i6);

    public abstract ValueEval getRelativeValue(int i5, int i6, int i7);

    @Override // org.apache.poi.ss.formula.TwoDEval
    public final ValueEval getValue(int i5, int i6) {
        return getRelativeValue(i5, i6);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval, org.apache.poi.ss.formula.TwoDEval
    public int getWidth() {
        return (this._lastColumn - this._firstColumn) + 1;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public final boolean isColumn() {
        return this._firstColumn == this._lastColumn;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public final boolean isRow() {
        return this._firstRow == this._lastRow;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public boolean isRowHidden(int i5) {
        return false;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public boolean isSubTotal(int i5, int i6) {
        return false;
    }

    @Override // org.apache.poi.ss.formula.ThreeDEval
    public final ValueEval getValue(int i5, int i6, int i7) {
        return getRelativeValue(i5, i6, i7);
    }

    public AreaEvalBase(int i5, int i6, int i7, int i8) {
        this(null, i5, i6, i7, i8);
    }

    public AreaEvalBase(AreaI areaI) {
        this(areaI, null);
    }

    public AreaEvalBase(AreaI areaI, SheetRange sheetRange) {
        this(sheetRange, areaI.getFirstRow(), areaI.getFirstColumn(), areaI.getLastRow(), areaI.getLastColumn());
    }
}

package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.Area2DPtgBase;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.Deleted3DPxg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FormulaShifter {
    private final int _amountToMove;
    private final int _dstSheetIndex;
    private final int _externSheetIndex;
    private final int _firstMovedIndex;
    private final int _lastMovedIndex;
    private final ShiftMode _mode;
    private final String _sheetName;
    private final int _srcSheetIndex;
    private final SpreadsheetVersion _version;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.FormulaShifter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode;

        static {
            int[] iArr = new int[ShiftMode.values().length];
            $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode = iArr;
            try {
                iArr[ShiftMode.RowMove.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[ShiftMode.RowCopy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[ShiftMode.ColumnMove.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[ShiftMode.ColumnCopy.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[ShiftMode.SheetMove.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum ShiftMode {
        RowMove,
        RowCopy,
        ColumnMove,
        ColumnCopy,
        SheetMove
    }

    private FormulaShifter(int i5, String str, int i6, int i7, int i8, ShiftMode shiftMode, SpreadsheetVersion spreadsheetVersion) {
        if (i6 > i7) {
            throw new IllegalArgumentException("firstMovedIndex, lastMovedIndex out of order");
        }
        this._externSheetIndex = i5;
        this._sheetName = str;
        this._firstMovedIndex = i6;
        this._lastMovedIndex = i7;
        this._amountToMove = i8;
        this._mode = shiftMode;
        this._version = spreadsheetVersion;
        this._dstSheetIndex = -1;
        this._srcSheetIndex = -1;
    }

    private Ptg adjustPtg(Ptg ptg, int i5) {
        int i6 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[this._mode.ordinal()];
        if (i6 == 1) {
            return adjustPtgDueToRowMove(ptg, i5);
        }
        if (i6 == 2) {
            return adjustPtgDueToRowCopy(ptg);
        }
        if (i6 == 3) {
            return adjustPtgDueToColumnMove(ptg, i5);
        }
        if (i6 == 4) {
            return adjustPtgDueToColumnCopy(ptg);
        }
        if (i6 == 5) {
            return adjustPtgDueToSheetMove(ptg);
        }
        throw new IllegalStateException("Unsupported shift mode: " + this._mode);
    }

    private Ptg adjustPtgDueToColumnCopy(Ptg ptg) {
        return adjustPtgDueToCopy(ptg, false);
    }

    private Ptg adjustPtgDueToColumnMove(Ptg ptg, int i5) {
        return adjustPtgDueToMove(ptg, i5, false);
    }

    private Ptg adjustPtgDueToCopy(Ptg ptg, boolean z6) {
        if (ptg instanceof RefPtg) {
            RefPtg refPtg = (RefPtg) ptg;
            return z6 ? rowCopyRefPtg(refPtg) : columnCopyRefPtg(refPtg);
        }
        if (ptg instanceof Ref3DPtg) {
            Ref3DPtg ref3DPtg = (Ref3DPtg) ptg;
            return z6 ? rowCopyRefPtg(ref3DPtg) : columnCopyRefPtg(ref3DPtg);
        }
        if (ptg instanceof Ref3DPxg) {
            Ref3DPxg ref3DPxg = (Ref3DPxg) ptg;
            return z6 ? rowCopyRefPtg(ref3DPxg) : columnCopyRefPtg(ref3DPxg);
        }
        if (ptg instanceof Area2DPtgBase) {
            Area2DPtgBase area2DPtgBase = (Area2DPtgBase) ptg;
            return z6 ? rowCopyAreaPtg(area2DPtgBase) : columnCopyAreaPtg(area2DPtgBase);
        }
        if (ptg instanceof Area3DPtg) {
            Area3DPtg area3DPtg = (Area3DPtg) ptg;
            return z6 ? rowCopyAreaPtg(area3DPtg) : columnCopyAreaPtg(area3DPtg);
        }
        if (!(ptg instanceof Area3DPxg)) {
            return null;
        }
        Area3DPxg area3DPxg = (Area3DPxg) ptg;
        return z6 ? rowCopyAreaPtg(area3DPxg) : columnCopyAreaPtg(area3DPxg);
    }

    private Ptg adjustPtgDueToMove(Ptg ptg, int i5, boolean z6) {
        if (ptg instanceof RefPtg) {
            if (i5 != this._externSheetIndex) {
                return null;
            }
            RefPtgBase refPtgBase = (RefPtg) ptg;
            return z6 ? rowMoveRefPtg(refPtgBase) : columnMoveRefPtg(refPtgBase);
        }
        if (ptg instanceof Ref3DPtg) {
            Ref3DPtg ref3DPtg = (Ref3DPtg) ptg;
            if (this._externSheetIndex != ref3DPtg.getExternSheetIndex()) {
                return null;
            }
            return z6 ? rowMoveRefPtg(ref3DPtg) : columnMoveRefPtg(ref3DPtg);
        }
        if (ptg instanceof Ref3DPxg) {
            Ref3DPxg ref3DPxg = (Ref3DPxg) ptg;
            if (ref3DPxg.getExternalWorkbookNumber() > 0 || !this._sheetName.equalsIgnoreCase(ref3DPxg.getSheetName())) {
                return null;
            }
            return z6 ? rowMoveRefPtg(ref3DPxg) : columnMoveRefPtg(ref3DPxg);
        }
        if (ptg instanceof Area2DPtgBase) {
            if (i5 != this._externSheetIndex) {
                return ptg;
            }
            AreaPtgBase areaPtgBase = (Area2DPtgBase) ptg;
            return z6 ? rowMoveAreaPtg(areaPtgBase) : columnMoveAreaPtg(areaPtgBase);
        }
        if (ptg instanceof Area3DPtg) {
            Area3DPtg area3DPtg = (Area3DPtg) ptg;
            if (this._externSheetIndex != area3DPtg.getExternSheetIndex()) {
                return null;
            }
            return z6 ? rowMoveAreaPtg(area3DPtg) : columnMoveAreaPtg(area3DPtg);
        }
        if (ptg instanceof Area3DPxg) {
            Area3DPxg area3DPxg = (Area3DPxg) ptg;
            if (area3DPxg.getExternalWorkbookNumber() <= 0 && this._sheetName.equalsIgnoreCase(area3DPxg.getSheetName())) {
                return z6 ? rowMoveAreaPtg(area3DPxg) : columnMoveAreaPtg(area3DPxg);
            }
        }
        return null;
    }

    private Ptg adjustPtgDueToRowCopy(Ptg ptg) {
        return adjustPtgDueToCopy(ptg, true);
    }

    private Ptg adjustPtgDueToRowMove(Ptg ptg, int i5) {
        return adjustPtgDueToMove(ptg, i5, true);
    }

    private Ptg adjustPtgDueToSheetMove(Ptg ptg) {
        Ref3DPtg ref3DPtg;
        int externSheetIndex;
        int i5;
        if (!(ptg instanceof Ref3DPtg) || ((externSheetIndex = (ref3DPtg = (Ref3DPtg) ptg).getExternSheetIndex()) < (i5 = this._srcSheetIndex) && externSheetIndex < this._dstSheetIndex)) {
            return null;
        }
        if (externSheetIndex > i5 && externSheetIndex > this._dstSheetIndex) {
            return null;
        }
        if (externSheetIndex == i5) {
            ref3DPtg.setExternSheetIndex(this._dstSheetIndex);
            return ref3DPtg;
        }
        int i6 = this._dstSheetIndex;
        if (i6 < i5) {
            ref3DPtg.setExternSheetIndex(externSheetIndex + 1);
            return ref3DPtg;
        }
        if (i6 > i5) {
            ref3DPtg.setExternSheetIndex(externSheetIndex - 1);
            return ref3DPtg;
        }
        return null;
    }

    private Ptg columnCopyAreaPtg(AreaPtgBase areaPtgBase) {
        boolean z6;
        int firstColumn = areaPtgBase.getFirstColumn();
        int lastColumn = areaPtgBase.getLastColumn();
        boolean z7 = true;
        if (areaPtgBase.isFirstColRelative()) {
            int i5 = firstColumn + this._amountToMove;
            if (i5 < 0 || this._version.getLastColumnIndex() < i5) {
                return createDeletedRef(areaPtgBase);
            }
            areaPtgBase.setFirstColumn(i5);
            z6 = true;
        } else {
            z6 = false;
        }
        if (areaPtgBase.isLastColRelative()) {
            int i6 = lastColumn + this._amountToMove;
            if (i6 < 0 || this._version.getLastColumnIndex() < i6) {
                return createDeletedRef(areaPtgBase);
            }
            areaPtgBase.setLastColumn(i6);
        } else {
            z7 = z6;
        }
        if (z7) {
            areaPtgBase.sortTopLeftToBottomRight();
        }
        if (z7) {
            return areaPtgBase;
        }
        return null;
    }

    private Ptg columnCopyRefPtg(RefPtgBase refPtgBase) {
        int column = refPtgBase.getColumn();
        if (!refPtgBase.isColRelative()) {
            return null;
        }
        int i5 = this._firstMovedIndex + this._amountToMove;
        if (i5 < 0 || this._version.getLastColumnIndex() < i5) {
            return createDeletedRef(refPtgBase);
        }
        int i6 = column + this._amountToMove;
        if (i6 < 0 || this._version.getLastColumnIndex() < i6) {
            return createDeletedRef(refPtgBase);
        }
        refPtgBase.setColumn(i6);
        return refPtgBase;
    }

    private Ptg columnMoveAreaPtg(AreaPtgBase areaPtgBase) {
        int firstColumn = areaPtgBase.getFirstColumn();
        int lastColumn = areaPtgBase.getLastColumn();
        int i5 = this._firstMovedIndex;
        if (i5 <= firstColumn && lastColumn <= this._lastMovedIndex) {
            areaPtgBase.setFirstColumn(firstColumn + this._amountToMove);
            areaPtgBase.setLastColumn(lastColumn + this._amountToMove);
            return areaPtgBase;
        }
        int i6 = this._amountToMove;
        int i7 = i5 + i6;
        int i8 = this._lastMovedIndex;
        int i9 = i8 + i6;
        if (firstColumn < i5 && i8 < lastColumn) {
            if (i7 < firstColumn && firstColumn <= i9) {
                areaPtgBase.setFirstColumn(i9 + 1);
                return areaPtgBase;
            }
            if (i7 > lastColumn || lastColumn >= i9) {
                return null;
            }
            areaPtgBase.setLastColumn(i7 - 1);
            return areaPtgBase;
        }
        if (i5 <= firstColumn && firstColumn <= i8) {
            if (i6 < 0) {
                areaPtgBase.setFirstColumn(firstColumn + i6);
                return areaPtgBase;
            }
            if (i7 > lastColumn) {
                return null;
            }
            int i10 = firstColumn + i6;
            if (i9 < lastColumn) {
                areaPtgBase.setFirstColumn(i10);
                return areaPtgBase;
            }
            int i11 = i8 + 1;
            if (i7 > i11) {
                i10 = i11;
            }
            areaPtgBase.setFirstColumn(i10);
            areaPtgBase.setLastColumn(Math.max(lastColumn, i9));
            return areaPtgBase;
        }
        if (i5 <= lastColumn && lastColumn <= i8) {
            if (i6 > 0) {
                areaPtgBase.setLastColumn(lastColumn + i6);
                return areaPtgBase;
            }
            if (i9 < firstColumn) {
                return null;
            }
            int i12 = lastColumn + i6;
            if (i7 > firstColumn) {
                areaPtgBase.setLastColumn(i12);
                return areaPtgBase;
            }
            int i13 = i5 - 1;
            if (i9 < i13) {
                i12 = i13;
            }
            areaPtgBase.setFirstColumn(Math.min(firstColumn, i7));
            areaPtgBase.setLastColumn(i12);
            return areaPtgBase;
        }
        if (i9 < firstColumn || lastColumn < i7) {
            return null;
        }
        if (i7 <= firstColumn && lastColumn <= i9) {
            return createDeletedRef(areaPtgBase);
        }
        if (firstColumn <= i7 && i9 <= lastColumn) {
            return null;
        }
        if (i7 < firstColumn && firstColumn <= i9) {
            areaPtgBase.setFirstColumn(i9 + 1);
            return areaPtgBase;
        }
        if (i7 <= lastColumn && lastColumn < i9) {
            areaPtgBase.setLastColumn(i7 - 1);
            return areaPtgBase;
        }
        StringBuilder sb = new StringBuilder("Situation not covered: (");
        sb.append(this._firstMovedIndex);
        sb.append(", ");
        sb.append(this._lastMovedIndex);
        sb.append(", ");
        androidx.exifinterface.media.a.y(sb, this._amountToMove, ", ", firstColumn, ", ");
        throw new IllegalStateException(AbstractC0157z.l(")", lastColumn, sb));
    }

    private Ptg columnMoveRefPtg(RefPtgBase refPtgBase) {
        int column = refPtgBase.getColumn();
        int i5 = this._firstMovedIndex;
        if (i5 <= column && column <= this._lastMovedIndex) {
            refPtgBase.setColumn(column + this._amountToMove);
            return refPtgBase;
        }
        int i6 = this._amountToMove;
        int i7 = i5 + i6;
        int i8 = this._lastMovedIndex + i6;
        if (i8 < column || column < i7) {
            return null;
        }
        if (i7 <= column && column <= i8) {
            return createDeletedRef(refPtgBase);
        }
        StringBuilder sb = new StringBuilder("Situation not covered: (");
        sb.append(this._firstMovedIndex);
        sb.append(", ");
        sb.append(this._lastMovedIndex);
        sb.append(", ");
        androidx.exifinterface.media.a.y(sb, this._amountToMove, ", ", column, ", ");
        throw new IllegalStateException(AbstractC0157z.l(")", column, sb));
    }

    private static Ptg createDeletedRef(Ptg ptg) {
        if (ptg instanceof RefPtg) {
            return new RefErrorPtg();
        }
        if (ptg instanceof Ref3DPtg) {
            return new DeletedRef3DPtg(((Ref3DPtg) ptg).getExternSheetIndex());
        }
        if (ptg instanceof AreaPtg) {
            return new AreaErrPtg();
        }
        if (ptg instanceof Area3DPtg) {
            return new DeletedArea3DPtg(((Area3DPtg) ptg).getExternSheetIndex());
        }
        if (ptg instanceof Ref3DPxg) {
            Ref3DPxg ref3DPxg = (Ref3DPxg) ptg;
            return new Deleted3DPxg(ref3DPxg.getExternalWorkbookNumber(), ref3DPxg.getSheetName());
        }
        if (ptg instanceof Area3DPxg) {
            Area3DPxg area3DPxg = (Area3DPxg) ptg;
            return new Deleted3DPxg(area3DPxg.getExternalWorkbookNumber(), area3DPxg.getSheetName());
        }
        throw new IllegalArgumentException("Unexpected ref ptg class (" + ptg.getClass().getName() + ")");
    }

    public static FormulaShifter createForColumnCopy(int i5, String str, int i6, int i7, int i8, SpreadsheetVersion spreadsheetVersion) {
        return new FormulaShifter(i5, str, i6, i7, i8, ShiftMode.ColumnCopy, spreadsheetVersion);
    }

    public static FormulaShifter createForColumnShift(int i5, String str, int i6, int i7, int i8, SpreadsheetVersion spreadsheetVersion) {
        return new FormulaShifter(i5, str, i6, i7, i8, ShiftMode.ColumnMove, spreadsheetVersion);
    }

    public static FormulaShifter createForRowCopy(int i5, String str, int i6, int i7, int i8, SpreadsheetVersion spreadsheetVersion) {
        return new FormulaShifter(i5, str, i6, i7, i8, ShiftMode.RowCopy, spreadsheetVersion);
    }

    public static FormulaShifter createForRowShift(int i5, String str, int i6, int i7, int i8, SpreadsheetVersion spreadsheetVersion) {
        return new FormulaShifter(i5, str, i6, i7, i8, ShiftMode.RowMove, spreadsheetVersion);
    }

    public static FormulaShifter createForSheetShift(int i5, int i6) {
        return new FormulaShifter(i5, i6);
    }

    private Ptg rowCopyAreaPtg(AreaPtgBase areaPtgBase) {
        boolean z6;
        int firstRow = areaPtgBase.getFirstRow();
        int lastRow = areaPtgBase.getLastRow();
        boolean z7 = true;
        if (areaPtgBase.isFirstRowRelative()) {
            int i5 = firstRow + this._amountToMove;
            if (i5 < 0 || this._version.getLastRowIndex() < i5) {
                return createDeletedRef(areaPtgBase);
            }
            areaPtgBase.setFirstRow(i5);
            z6 = true;
        } else {
            z6 = false;
        }
        if (areaPtgBase.isLastRowRelative()) {
            int i6 = lastRow + this._amountToMove;
            if (i6 < 0 || this._version.getLastRowIndex() < i6) {
                return createDeletedRef(areaPtgBase);
            }
            areaPtgBase.setLastRow(i6);
        } else {
            z7 = z6;
        }
        if (z7) {
            areaPtgBase.sortTopLeftToBottomRight();
        }
        if (z7) {
            return areaPtgBase;
        }
        return null;
    }

    private Ptg rowCopyRefPtg(RefPtgBase refPtgBase) {
        int row = refPtgBase.getRow();
        if (!refPtgBase.isRowRelative()) {
            return null;
        }
        int i5 = this._firstMovedIndex + this._amountToMove;
        if (i5 < 0 || this._version.getLastRowIndex() < i5) {
            return createDeletedRef(refPtgBase);
        }
        int i6 = row + this._amountToMove;
        if (i6 < 0 || this._version.getLastRowIndex() < i6) {
            return createDeletedRef(refPtgBase);
        }
        refPtgBase.setRow(i6);
        return refPtgBase;
    }

    private Ptg rowMoveAreaPtg(AreaPtgBase areaPtgBase) {
        int firstRow = areaPtgBase.getFirstRow();
        int lastRow = areaPtgBase.getLastRow();
        int i5 = this._firstMovedIndex;
        if (i5 <= firstRow && lastRow <= this._lastMovedIndex) {
            areaPtgBase.setFirstRow(firstRow + this._amountToMove);
            areaPtgBase.setLastRow(lastRow + this._amountToMove);
            return areaPtgBase;
        }
        int i6 = this._amountToMove;
        int i7 = i5 + i6;
        int i8 = this._lastMovedIndex;
        int i9 = i8 + i6;
        if (firstRow < i5 && i8 < lastRow) {
            if (i7 < firstRow && firstRow <= i9) {
                areaPtgBase.setFirstRow(i9 + 1);
                return areaPtgBase;
            }
            if (i7 > lastRow || lastRow >= i9) {
                return null;
            }
            areaPtgBase.setLastRow(i7 - 1);
            return areaPtgBase;
        }
        if (i5 <= firstRow && firstRow <= i8) {
            if (i6 < 0) {
                areaPtgBase.setFirstRow(firstRow + i6);
                return areaPtgBase;
            }
            if (i7 > lastRow) {
                return null;
            }
            int i10 = firstRow + i6;
            if (i9 < lastRow) {
                areaPtgBase.setFirstRow(i10);
                return areaPtgBase;
            }
            int i11 = i8 + 1;
            if (i7 > i11) {
                i10 = i11;
            }
            areaPtgBase.setFirstRow(i10);
            areaPtgBase.setLastRow(Math.max(lastRow, i9));
            return areaPtgBase;
        }
        if (i5 <= lastRow && lastRow <= i8) {
            if (i6 > 0) {
                areaPtgBase.setLastRow(lastRow + i6);
                return areaPtgBase;
            }
            if (i9 < firstRow) {
                return null;
            }
            int i12 = lastRow + i6;
            if (i7 > firstRow) {
                areaPtgBase.setLastRow(i12);
                return areaPtgBase;
            }
            int i13 = i5 - 1;
            if (i9 < i13) {
                i12 = i13;
            }
            areaPtgBase.setFirstRow(Math.min(firstRow, i7));
            areaPtgBase.setLastRow(i12);
            return areaPtgBase;
        }
        if (i9 < firstRow || lastRow < i7) {
            return null;
        }
        if (i7 <= firstRow && lastRow <= i9) {
            return createDeletedRef(areaPtgBase);
        }
        if (firstRow <= i7 && i9 <= lastRow) {
            return null;
        }
        if (i7 < firstRow && firstRow <= i9) {
            areaPtgBase.setFirstRow(i9 + 1);
            return areaPtgBase;
        }
        if (i7 <= lastRow && lastRow < i9) {
            areaPtgBase.setLastRow(i7 - 1);
            return areaPtgBase;
        }
        StringBuilder sb = new StringBuilder("Situation not covered: (");
        sb.append(this._firstMovedIndex);
        sb.append(", ");
        sb.append(this._lastMovedIndex);
        sb.append(", ");
        androidx.exifinterface.media.a.y(sb, this._amountToMove, ", ", firstRow, ", ");
        throw new IllegalStateException(AbstractC0157z.l(")", lastRow, sb));
    }

    private Ptg rowMoveRefPtg(RefPtgBase refPtgBase) {
        int row = refPtgBase.getRow();
        int i5 = this._firstMovedIndex;
        if (i5 <= row && row <= this._lastMovedIndex) {
            refPtgBase.setRow(row + this._amountToMove);
            return refPtgBase;
        }
        int i6 = this._amountToMove;
        int i7 = i5 + i6;
        int i8 = this._lastMovedIndex + i6;
        if (i8 < row || row < i7) {
            return null;
        }
        if (i7 <= row && row <= i8) {
            return createDeletedRef(refPtgBase);
        }
        StringBuilder sb = new StringBuilder("Situation not covered: (");
        sb.append(this._firstMovedIndex);
        sb.append(", ");
        sb.append(this._lastMovedIndex);
        sb.append(", ");
        androidx.exifinterface.media.a.y(sb, this._amountToMove, ", ", row, ", ");
        throw new IllegalStateException(AbstractC0157z.l(")", row, sb));
    }

    public boolean adjustFormula(Ptg[] ptgArr, int i5) {
        boolean z6 = false;
        for (int i6 = 0; i6 < ptgArr.length; i6++) {
            Ptg ptgAdjustPtg = adjustPtg(ptgArr[i6], i5);
            if (ptgAdjustPtg != null) {
                ptgArr[i6] = ptgAdjustPtg;
                z6 = true;
            }
        }
        return z6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(FormulaShifter.class, sb, " [");
        sb.append(this._firstMovedIndex);
        sb.append(this._lastMovedIndex);
        return AbstractC0157z.l("]", this._amountToMove, sb);
    }

    private FormulaShifter(int i5, int i6) {
        this._amountToMove = -1;
        this._lastMovedIndex = -1;
        this._firstMovedIndex = -1;
        this._externSheetIndex = -1;
        this._sheetName = null;
        this._version = null;
        this._srcSheetIndex = i5;
        this._dstSheetIndex = i6;
        this._mode = ShiftMode.SheetMove;
    }
}

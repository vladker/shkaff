package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SharedFormula {
    private final int _columnWrappingMask;
    private final int _rowWrappingMask;

    public SharedFormula(SpreadsheetVersion spreadsheetVersion) {
        this._columnWrappingMask = spreadsheetVersion.getLastColumnIndex();
        this._rowWrappingMask = spreadsheetVersion.getLastRowIndex();
    }

    private int fixupRelativeColumn(int i5, int i6, boolean z6) {
        if (!z6) {
            return i6;
        }
        return this._columnWrappingMask & (i6 + i5);
    }

    private int fixupRelativeRow(int i5, int i6, boolean z6) {
        if (!z6) {
            return i6;
        }
        return this._rowWrappingMask & (i6 + i5);
    }

    public Ptg[] convertSharedFormulas(Ptg[] ptgArr, int i5, int i6) {
        Ptg areaPtg;
        Ptg[] ptgArr2 = new Ptg[ptgArr.length];
        for (int i7 = 0; i7 < ptgArr.length; i7++) {
            Ptg ptgCopy = ptgArr[i7];
            byte ptgClass = !ptgCopy.isBaseToken() ? ptgCopy.getPtgClass() : (byte) -1;
            if (ptgCopy instanceof RefPtgBase) {
                RefPtgBase refPtgBase = (RefPtgBase) ptgCopy;
                areaPtg = new RefPtg(fixupRelativeRow(i5, refPtgBase.getRow(), refPtgBase.isRowRelative()), fixupRelativeColumn(i6, refPtgBase.getColumn(), refPtgBase.isColRelative()), refPtgBase.isRowRelative(), refPtgBase.isColRelative());
                areaPtg.setClass(ptgClass);
            } else {
                if (ptgCopy instanceof AreaPtgBase) {
                    AreaPtgBase areaPtgBase = (AreaPtgBase) ptgCopy;
                    areaPtg = new AreaPtg(fixupRelativeRow(i5, areaPtgBase.getFirstRow(), areaPtgBase.isFirstRowRelative()), fixupRelativeRow(i5, areaPtgBase.getLastRow(), areaPtgBase.isLastRowRelative()), fixupRelativeColumn(i6, areaPtgBase.getFirstColumn(), areaPtgBase.isFirstColRelative()), fixupRelativeColumn(i6, areaPtgBase.getLastColumn(), areaPtgBase.isLastColRelative()), areaPtgBase.isFirstRowRelative(), areaPtgBase.isLastRowRelative(), areaPtgBase.isFirstColRelative(), areaPtgBase.isLastColRelative());
                    areaPtg.setClass(ptgClass);
                } else if (ptgCopy instanceof OperandPtg) {
                    ptgCopy = ((OperandPtg) ptgCopy).copy();
                }
                ptgArr2[i7] = ptgCopy;
            }
            ptgCopy = areaPtg;
            ptgArr2[i7] = ptgCopy;
        }
        return ptgArr2;
    }
}

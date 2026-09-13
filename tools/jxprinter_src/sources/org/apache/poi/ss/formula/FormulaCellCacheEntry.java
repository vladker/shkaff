package org.apache.poi.ss.formula;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class FormulaCellCacheEntry extends CellCacheEntry {
    private CellCacheEntry[] _sensitiveInputCells;
    private FormulaUsedBlankCellSet _usedBlankCellGroup;

    private void changeConsumingCells(CellCacheEntry[] cellCacheEntryArr) {
        Set set;
        CellCacheEntry[] cellCacheEntryArr2 = this._sensitiveInputCells;
        int length = cellCacheEntryArr.length;
        for (CellCacheEntry cellCacheEntry : cellCacheEntryArr) {
            cellCacheEntry.addConsumingCell(this);
        }
        if (cellCacheEntryArr2 != null && cellCacheEntryArr2.length >= 1) {
            if (length < 1) {
                set = Collections.EMPTY_SET;
            } else {
                HashSet hashSet = new HashSet((length * 3) / 2);
                hashSet.addAll(Arrays.asList(cellCacheEntryArr).subList(0, length));
                set = hashSet;
            }
            for (CellCacheEntry cellCacheEntry2 : cellCacheEntryArr2) {
                if (!set.contains(cellCacheEntry2)) {
                    cellCacheEntry2.clearConsumingCell(this);
                }
            }
        }
    }

    public void clearFormulaEntry() {
        CellCacheEntry[] cellCacheEntryArr = this._sensitiveInputCells;
        if (cellCacheEntryArr != null) {
            for (int length = cellCacheEntryArr.length - 1; length >= 0; length--) {
                cellCacheEntryArr[length].clearConsumingCell(this);
            }
        }
        this._sensitiveInputCells = null;
        clearValue();
    }

    public boolean isInputSensitive() {
        CellCacheEntry[] cellCacheEntryArr = this._sensitiveInputCells;
        if (cellCacheEntryArr != null && cellCacheEntryArr.length > 0) {
            return true;
        }
        FormulaUsedBlankCellSet formulaUsedBlankCellSet = this._usedBlankCellGroup;
        return (formulaUsedBlankCellSet == null || formulaUsedBlankCellSet.isEmpty()) ? false : true;
    }

    public void notifyUpdatedBlankCell(FormulaUsedBlankCellSet.BookSheetKey bookSheetKey, int i5, int i6, IEvaluationListener iEvaluationListener) {
        FormulaUsedBlankCellSet formulaUsedBlankCellSet = this._usedBlankCellGroup;
        if (formulaUsedBlankCellSet == null || !formulaUsedBlankCellSet.containsCell(bookSheetKey, i5, i6)) {
            return;
        }
        clearFormulaEntry();
        recurseClearCachedFormulaResults(iEvaluationListener);
    }

    public void setSensitiveInputCells(CellCacheEntry[] cellCacheEntryArr) {
        if (cellCacheEntryArr == null) {
            this._sensitiveInputCells = null;
            changeConsumingCells(CellCacheEntry.EMPTY_ARRAY);
        } else {
            CellCacheEntry[] cellCacheEntryArr2 = (CellCacheEntry[]) cellCacheEntryArr.clone();
            this._sensitiveInputCells = cellCacheEntryArr2;
            changeConsumingCells(cellCacheEntryArr2);
        }
    }

    public void updateFormulaResult(ValueEval valueEval, CellCacheEntry[] cellCacheEntryArr, FormulaUsedBlankCellSet formulaUsedBlankCellSet) {
        updateValue(valueEval);
        setSensitiveInputCells(cellCacheEntryArr);
        this._usedBlankCellGroup = formulaUsedBlankCellSet;
    }
}

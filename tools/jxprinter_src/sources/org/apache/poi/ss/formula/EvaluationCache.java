package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class EvaluationCache {
    final IEvaluationListener _evaluationListener;
    private final PlainCellCache _plainCellCache = new PlainCellCache();
    private final FormulaCellCache _formulaCellCache = new FormulaCellCache();

    public EvaluationCache(IEvaluationListener iEvaluationListener) {
        this._evaluationListener = iEvaluationListener;
    }

    private boolean areValuesEqual(ValueEval valueEval, ValueEval valueEval2) {
        Class<?> cls;
        if (valueEval == null || (cls = valueEval.getClass()) != valueEval2.getClass()) {
            return false;
        }
        if (valueEval == BlankEval.instance) {
            return valueEval2 == valueEval;
        }
        if (cls == NumberEval.class) {
            return ((NumberEval) valueEval).getNumberValue() == ((NumberEval) valueEval2).getNumberValue();
        }
        if (cls == StringEval.class) {
            return ((StringEval) valueEval).getStringValue().equals(((StringEval) valueEval2).getStringValue());
        }
        if (cls == BoolEval.class) {
            return ((BoolEval) valueEval).getBooleanValue() == ((BoolEval) valueEval2).getBooleanValue();
        }
        if (cls == ErrorEval.class) {
            return ((ErrorEval) valueEval).getErrorCode() == ((ErrorEval) valueEval2).getErrorCode();
        }
        throw new IllegalStateException("Unexpected value class (" + cls.getName() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAnyBlankReferencingFormulas$0(FormulaUsedBlankCellSet.BookSheetKey bookSheetKey, int i5, int i6, FormulaCellCacheEntry formulaCellCacheEntry) {
        formulaCellCacheEntry.notifyUpdatedBlankCell(bookSheetKey, i5, i6, this._evaluationListener);
    }

    private void updateAnyBlankReferencingFormulas(int i5, int i6, final int i7, final int i8) {
        final FormulaUsedBlankCellSet.BookSheetKey bookSheetKey = new FormulaUsedBlankCellSet.BookSheetKey(i5, i6);
        this._formulaCellCache.applyOperation(new FormulaCellCache.IEntryOperation() { // from class: org.apache.poi.ss.formula.a
            @Override // org.apache.poi.ss.formula.FormulaCellCache.IEntryOperation
            public final void processEntry(FormulaCellCacheEntry formulaCellCacheEntry) {
                this.f7196a.lambda$updateAnyBlankReferencingFormulas$0(bookSheetKey, i7, i8, formulaCellCacheEntry);
            }
        });
    }

    public void clear() {
        IEvaluationListener iEvaluationListener = this._evaluationListener;
        if (iEvaluationListener != null) {
            iEvaluationListener.onClearWholeCache();
        }
        this._plainCellCache.clear();
        this._formulaCellCache.clear();
    }

    public FormulaCellCacheEntry getOrCreateFormulaCellEntry(EvaluationCell evaluationCell) {
        FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.get(evaluationCell);
        if (formulaCellCacheEntry != null) {
            return formulaCellCacheEntry;
        }
        FormulaCellCacheEntry formulaCellCacheEntry2 = new FormulaCellCacheEntry();
        this._formulaCellCache.put(evaluationCell, formulaCellCacheEntry2);
        return formulaCellCacheEntry2;
    }

    public PlainValueCellCacheEntry getPlainValueEntry(int i5, int i6, int i7, int i8, ValueEval valueEval) {
        PlainCellCache.Loc loc = new PlainCellCache.Loc(i5, i6, i7, i8);
        PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
        if (plainValueCellCacheEntry == null) {
            PlainValueCellCacheEntry plainValueCellCacheEntry2 = new PlainValueCellCacheEntry(valueEval);
            this._plainCellCache.put(loc, plainValueCellCacheEntry2);
            IEvaluationListener iEvaluationListener = this._evaluationListener;
            if (iEvaluationListener != null) {
                iEvaluationListener.onReadPlainValue(i6, i7, i8, plainValueCellCacheEntry2);
            }
            return plainValueCellCacheEntry2;
        }
        if (!areValuesEqual(plainValueCellCacheEntry.getValue(), valueEval)) {
            throw new IllegalStateException("value changed");
        }
        IEvaluationListener iEvaluationListener2 = this._evaluationListener;
        if (iEvaluationListener2 != null) {
            iEvaluationListener2.onCacheHit(i6, i7, i8, valueEval);
        }
        return plainValueCellCacheEntry;
    }

    public void notifyDeleteCell(int i5, int i6, EvaluationCell evaluationCell) {
        if (evaluationCell.getCellType() == CellType.FORMULA) {
            FormulaCellCacheEntry formulaCellCacheEntryRemove = this._formulaCellCache.remove(evaluationCell);
            if (formulaCellCacheEntryRemove == null) {
                return;
            }
            formulaCellCacheEntryRemove.setSensitiveInputCells(null);
            formulaCellCacheEntryRemove.recurseClearCachedFormulaResults(this._evaluationListener);
            return;
        }
        PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(new PlainCellCache.Loc(i5, i6, evaluationCell.getRowIndex(), evaluationCell.getColumnIndex()));
        if (plainValueCellCacheEntry == null) {
            return;
        }
        plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
    }

    public void notifyUpdateCell(int i5, int i6, EvaluationCell evaluationCell) {
        EvaluationCell evaluationCell2;
        FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.get(evaluationCell);
        int rowIndex = evaluationCell.getRowIndex();
        int columnIndex = evaluationCell.getColumnIndex();
        PlainCellCache.Loc loc = new PlainCellCache.Loc(i5, i6, rowIndex, columnIndex);
        PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
        if (evaluationCell.getCellType() == CellType.FORMULA) {
            if (formulaCellCacheEntry == null) {
                FormulaCellCacheEntry formulaCellCacheEntry2 = new FormulaCellCacheEntry();
                if (plainValueCellCacheEntry == null) {
                    IEvaluationListener iEvaluationListener = this._evaluationListener;
                    evaluationCell2 = evaluationCell;
                    if (iEvaluationListener != null) {
                        iEvaluationListener.onChangeFromBlankValue(i6, rowIndex, columnIndex, evaluationCell2, formulaCellCacheEntry2);
                    }
                    updateAnyBlankReferencingFormulas(i5, i6, rowIndex, columnIndex);
                } else {
                    evaluationCell2 = evaluationCell;
                }
                this._formulaCellCache.put(evaluationCell2, formulaCellCacheEntry2);
            } else {
                formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
                formulaCellCacheEntry.clearFormulaEntry();
            }
            if (plainValueCellCacheEntry == null) {
                return;
            }
            plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
            this._plainCellCache.remove(loc);
            return;
        }
        ValueEval valueFromNonFormulaCell = WorkbookEvaluator.getValueFromNonFormulaCell(evaluationCell);
        if (plainValueCellCacheEntry != null) {
            if (plainValueCellCacheEntry.updateValue(valueFromNonFormulaCell)) {
                plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
            }
            if (valueFromNonFormulaCell == BlankEval.instance) {
                this._plainCellCache.remove(loc);
            }
        } else if (valueFromNonFormulaCell != BlankEval.instance) {
            PlainValueCellCacheEntry plainValueCellCacheEntry2 = new PlainValueCellCacheEntry(valueFromNonFormulaCell);
            if (formulaCellCacheEntry == null) {
                IEvaluationListener iEvaluationListener2 = this._evaluationListener;
                if (iEvaluationListener2 != null) {
                    iEvaluationListener2.onChangeFromBlankValue(i6, rowIndex, columnIndex, evaluationCell, plainValueCellCacheEntry2);
                }
                updateAnyBlankReferencingFormulas(i5, i6, rowIndex, columnIndex);
            }
            this._plainCellCache.put(loc, plainValueCellCacheEntry2);
        }
        if (formulaCellCacheEntry == null) {
            return;
        }
        this._formulaCellCache.remove(evaluationCell);
        formulaCellCacheEntry.setSensitiveInputCells(null);
        formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
    }
}

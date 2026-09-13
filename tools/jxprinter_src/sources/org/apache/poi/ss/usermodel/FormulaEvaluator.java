package org.apache.poi.ss.usermodel;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FormulaEvaluator {
    void clearAllCachedResultValues();

    CellValue evaluate(Cell cell);

    void evaluateAll();

    CellType evaluateFormulaCell(Cell cell);

    Cell evaluateInCell(Cell cell);

    void notifyDeleteCell(Cell cell);

    void notifySetFormula(Cell cell);

    void notifyUpdateCell(Cell cell);

    void setDebugEvaluationOutputForNextEval(boolean z6);

    void setIgnoreMissingWorkbooks(boolean z6);

    void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map);
}

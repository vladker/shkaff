package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Single implements FreeRefFunction {
    public static final FreeRefFunction instance = new Single();

    private Single() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        int columnIndex = operationEvaluationContext.getColumnIndex();
        int rowIndex = operationEvaluationContext.getRowIndex();
        ValueEval absoluteValue = null;
        for (ValueEval valueEval : valueEvalArr) {
            if (valueEval instanceof AreaEvalBase) {
                AreaEvalBase areaEvalBase = (AreaEvalBase) valueEval;
                if (areaEvalBase.contains(rowIndex, columnIndex)) {
                    if (absoluteValue != null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    absoluteValue = areaEvalBase.getAbsoluteValue(rowIndex, columnIndex);
                } else if (areaEvalBase.containsRow(rowIndex)) {
                    if (absoluteValue != null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    absoluteValue = areaEvalBase.getAbsoluteValue(rowIndex, areaEvalBase.getFirstColumn());
                } else if (!areaEvalBase.containsColumn(columnIndex)) {
                    continue;
                } else {
                    if (absoluteValue != null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    absoluteValue = areaEvalBase.getAbsoluteValue(areaEvalBase.getFirstRow(), columnIndex);
                }
            }
        }
        return absoluteValue != null ? absoluteValue : ErrorEval.VALUE_INVALID;
    }
}

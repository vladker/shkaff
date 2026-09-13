package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RangeEval extends Fixed2ArgFunction {
    public static final Function instance = new RangeEval();

    private RangeEval() {
    }

    private static AreaEval evaluateRef(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new IllegalArgumentException("Unexpected ref arg class (" + valueEval.getClass().getName() + ")");
    }

    private static AreaEval resolveRange(AreaEval areaEval, AreaEval areaEval2) {
        int firstRow = areaEval.getFirstRow();
        int firstColumn = areaEval.getFirstColumn();
        return areaEval.offset(Math.min(firstRow, areaEval2.getFirstRow()) - firstRow, Math.max(areaEval.getLastRow(), areaEval2.getLastRow()) - firstRow, Math.min(firstColumn, areaEval2.getFirstColumn()) - firstColumn, Math.max(areaEval.getLastColumn(), areaEval2.getLastColumn()) - firstColumn);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return resolveRange(evaluateRef(valueEval), evaluateRef(valueEval2));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

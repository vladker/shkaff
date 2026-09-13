package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IntersectionEval extends Fixed2ArgFunction {
    public static final Function instance = new IntersectionEval();

    private IntersectionEval() {
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
        int firstColumn;
        int lastRow;
        int firstRow;
        int lastRow2;
        int firstRow2 = areaEval.getFirstRow();
        int firstColumn2 = areaEval.getFirstColumn();
        int lastColumn = areaEval2.getLastColumn();
        if (firstColumn2 <= lastColumn && (firstColumn = areaEval2.getFirstColumn()) <= areaEval.getLastColumn() && firstRow2 <= (lastRow = areaEval2.getLastRow()) && (firstRow = areaEval2.getFirstRow()) <= (lastRow2 = areaEval.getLastRow())) {
            return areaEval.offset(Math.max(firstRow2, firstRow) - firstRow2, Math.min(lastRow2, lastRow) - firstRow2, Math.max(firstColumn2, firstColumn) - firstColumn2, Math.min(areaEval.getLastColumn(), lastColumn) - firstColumn2);
        }
        return null;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            AreaEval areaEvalResolveRange = resolveRange(evaluateRef(valueEval), evaluateRef(valueEval2));
            return areaEvalResolveRange == null ? ErrorEval.NULL_INTERSECTION : areaEvalResolveRange;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

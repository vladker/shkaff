package org.apache.poi.ss.formula.atp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class TextJoinFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new TextJoinFunction(ArgumentsEvaluator.instance);
    private ArgumentsEvaluator evaluator;

    private TextJoinFunction(ArgumentsEvaluator argumentsEvaluator) {
        this.evaluator = argumentsEvaluator;
    }

    private List<ValueEval> getValues(ValueEval valueEval, int i5, int i6, boolean z6) {
        if (!(valueEval instanceof AreaEval)) {
            return Collections.singletonList(OperandResolver.getSingleValue(valueEval, i5, i6));
        }
        AreaEval areaEval = (AreaEval) valueEval;
        ArrayList arrayList = new ArrayList();
        for (int lastRow = z6 ? areaEval.getLastRow() : areaEval.getFirstRow(); lastRow <= areaEval.getLastRow(); lastRow++) {
            for (int firstColumn = areaEval.getFirstColumn(); firstColumn <= areaEval.getLastColumn(); firstColumn++) {
                arrayList.add(OperandResolver.getSingleValue(areaEval.getAbsoluteValue(lastRow, firstColumn), lastRow, firstColumn));
            }
        }
        return arrayList;
    }

    private String laxValueToString(ValueEval valueEval) {
        return valueEval instanceof MissingArgEval ? "" : OperandResolver.coerceValueToString(valueEval);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 3 || valueEvalArr.length > 254) {
            return ErrorEval.VALUE_INVALID;
        }
        int rowIndex = operationEvaluationContext.getRowIndex();
        int columnIndex = operationEvaluationContext.getColumnIndex();
        try {
            List<ValueEval> values = getValues(valueEvalArr[0], rowIndex, columnIndex, true);
            boolean zBooleanValue = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEvalArr[1], rowIndex, columnIndex), false).booleanValue();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 2; i5 < valueEvalArr.length; i5++) {
                Iterator<ValueEval> it = getValues(valueEvalArr[i5], rowIndex, columnIndex, false).iterator();
                while (it.hasNext()) {
                    String strCoerceValueToString = OperandResolver.coerceValueToString(it.next());
                    if (!zBooleanValue || (strCoerceValueToString != null && strCoerceValueToString.length() > 0)) {
                        arrayList.add(strCoerceValueToString);
                    }
                }
            }
            if (values.isEmpty()) {
                return new StringEval(String.join("", arrayList));
            }
            if (values.size() == 1) {
                return new StringEval(String.join(laxValueToString(values.get(0)), arrayList));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<ValueEval> it2 = values.iterator();
            while (it2.hasNext()) {
                arrayList2.add(laxValueToString(it2.next()));
            }
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                if (i6 > 0) {
                    sb.append((String) arrayList2.get((i6 - 1) % arrayList2.size()));
                }
                sb.append((String) arrayList.get(i6));
            }
            return new StringEval(sb.toString());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

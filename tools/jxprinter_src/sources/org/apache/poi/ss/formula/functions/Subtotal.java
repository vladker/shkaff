package org.apache.poi.ss.formula.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.poi.ss.formula.LazyRefEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Subtotal implements Function {
    private static Function findFunction(int i5) throws EvaluationException {
        switch (i5) {
            case 1:
                return AggregateFunction.subtotalInstance(AggregateFunction.AVERAGE, true);
            case 2:
                return Count.subtotalInstance(true);
            case 3:
                return Counta.subtotalInstance(true);
            case 4:
                return AggregateFunction.subtotalInstance(AggregateFunction.MAX, true);
            case 5:
                return AggregateFunction.subtotalInstance(AggregateFunction.MIN, true);
            case 6:
                return AggregateFunction.subtotalInstance(AggregateFunction.PRODUCT, true);
            case 7:
                return AggregateFunction.subtotalInstance(AggregateFunction.STDEV, true);
            case 8:
                return AggregateFunction.subtotalInstance(AggregateFunction.STDEVP, true);
            case 9:
                return AggregateFunction.subtotalInstance(AggregateFunction.SUM, true);
            case 10:
                return AggregateFunction.subtotalInstance(AggregateFunction.VAR, true);
            case 11:
                return AggregateFunction.subtotalInstance(AggregateFunction.VARP, true);
            default:
                switch (i5) {
                    case 101:
                        return AggregateFunction.subtotalInstance(AggregateFunction.AVERAGE, false);
                    case 102:
                        return Count.subtotalInstance(false);
                    case 103:
                        return Counta.subtotalInstance(false);
                    case 104:
                        return AggregateFunction.subtotalInstance(AggregateFunction.MAX, false);
                    case 105:
                        return AggregateFunction.subtotalInstance(AggregateFunction.MIN, false);
                    case 106:
                        return AggregateFunction.subtotalInstance(AggregateFunction.PRODUCT, false);
                    case 107:
                        return AggregateFunction.subtotalInstance(AggregateFunction.STDEV, false);
                    case 108:
                        return AggregateFunction.subtotalInstance(AggregateFunction.STDEVP, false);
                    case 109:
                        return AggregateFunction.subtotalInstance(AggregateFunction.SUM, false);
                    case 110:
                        return AggregateFunction.subtotalInstance(AggregateFunction.VAR, false);
                    case 111:
                        return AggregateFunction.subtotalInstance(AggregateFunction.VARP, false);
                    default:
                        throw EvaluationException.invalidValue();
                }
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length - 1 < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[0], i5, i6));
            Function functionFindFunction = findFunction(iCoerceValueToInt);
            ArrayList arrayList = new ArrayList(Arrays.asList(valueEvalArr).subList(1, valueEvalArr.length));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ValueEval valueEval = (ValueEval) it.next();
                if (valueEval instanceof LazyRefEval) {
                    LazyRefEval lazyRefEval = (LazyRefEval) valueEval;
                    if (lazyRefEval.isSubTotal()) {
                        it.remove();
                    }
                    if (iCoerceValueToInt > 100 && lazyRefEval.isRowHidden()) {
                        it.remove();
                    }
                }
            }
            return functionFindFunction.evaluate((ValueEval[]) arrayList.toArray(new ValueEval[0]), i5, i6);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

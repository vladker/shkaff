package org.apache.poi.ss.formula.functions;

import java.util.List;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Forecast extends Fixed3ArgFunction implements FreeRefFunction {
    public static final Forecast instance = new Forecast();

    private Forecast() {
    }

    private static Double evaluateValue(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            Double dEvaluateValue = evaluateValue(valueEval, i5, i6);
            if (dEvaluateValue != null && !dEvaluateValue.isNaN() && !dEvaluateValue.isInfinite()) {
                List<DoubleList> numberArrays = ArrayFunctionUtils.getNumberArrays(valueEval2, valueEval3);
                double[] array = numberArrays.get(0).toArray();
                double[] array2 = numberArrays.get(1).toArray();
                double dAverage = MathX.average(array);
                double dAverage2 = MathX.average(array2);
                int length = array.length;
                double dA = 0.0d;
                double dPow = 0.0d;
                for (int i7 = 0; i7 < length; i7++) {
                    double d = array2[i7] - dAverage2;
                    dA = androidx.collection.a.a(array[i7], dAverage, d, dA);
                    dPow += Math.pow(d, 2.0d);
                }
                if (dPow == 0.0d) {
                    return ErrorEval.DIV_ZERO;
                }
                double d6 = dA / dPow;
                return new NumberEval((d6 * dEvaluateValue.doubleValue()) + (dAverage - (dAverage2 * d6)));
            }
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        } catch (Exception unused) {
            return ErrorEval.NA;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 3) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
    }
}

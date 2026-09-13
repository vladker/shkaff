package org.apache.poi.ss.formula.functions;

import java.math.BigInteger;
import java.util.HashMap;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FactDouble extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new FactDouble();
    static HashMap<Integer, BigInteger> cache = new HashMap<>();

    public static BigInteger factorial(int i5) {
        if (i5 == 0 || i5 < 0) {
            return BigInteger.ONE;
        }
        if (cache.containsKey(Integer.valueOf(i5))) {
            return cache.get(Integer.valueOf(i5));
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(i5).multiply(factorial(i5 - 2));
        cache.put(Integer.valueOf(i5), bigIntegerMultiply);
        return bigIntegerMultiply;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(valueEval);
            return iCoerceValueToInt < 0 ? ErrorEval.NUM_ERROR : new NumberEval(factorial(iCoerceValueToInt).longValue());
        } catch (EvaluationException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return lambda$evaluateArray$0(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}

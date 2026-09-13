package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class UserDefinedFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new UserDefinedFunction();

    private UserDefinedFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        ValueEval valueEvalEvaluateArrayFunction;
        int length = valueEvalArr.length;
        if (length < 1) {
            throw new RuntimeException("function name argument missing");
        }
        ValueEval valueEval = valueEvalArr[0];
        if (!(valueEval instanceof FunctionNameEval)) {
            throw new RuntimeException("First argument should be a NameEval, but got (" + valueEval.getClass().getName() + ")");
        }
        String functionName = ((FunctionNameEval) valueEval).getFunctionName();
        FreeRefFunction freeRefFunctionFindUserDefinedFunction = operationEvaluationContext.findUserDefinedFunction(functionName);
        if (freeRefFunctionFindUserDefinedFunction == null) {
            throw new NotImplementedFunctionException(functionName);
        }
        int i5 = length - 1;
        ValueEval[] valueEvalArr2 = new ValueEval[i5];
        System.arraycopy(valueEvalArr, 1, valueEvalArr2, 0, i5);
        return (!(freeRefFunctionFindUserDefinedFunction instanceof ArrayFunction) || (valueEvalEvaluateArrayFunction = OperationEvaluatorFactory.evaluateArrayFunction((ArrayFunction) freeRefFunctionFindUserDefinedFunction, valueEvalArr2, operationEvaluationContext)) == null) ? freeRefFunctionFindUserDefinedFunction.evaluate(valueEvalArr2, operationEvaluationContext) : valueEvalEvaluateArrayFunction;
    }
}

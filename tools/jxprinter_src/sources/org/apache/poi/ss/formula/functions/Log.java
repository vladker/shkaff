package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Log {
    private static final double LOG_10_TO_BASE_e = Math.log(10.0d);
    private static final double TEN = 10.0d;

    public static ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        double dLog;
        if (valueEvalArr.length != 1 && valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEvalArr[0], i5, i6);
            if (valueEvalArr.length == 1) {
                dLog = Math.log(dSingleOperandEvaluate) / LOG_10_TO_BASE_e;
            } else {
                double dSingleOperandEvaluate2 = NumericFunction.singleOperandEvaluate(valueEvalArr[1], i5, i6);
                double dLog2 = Math.log(dSingleOperandEvaluate);
                if (Double.compare(dSingleOperandEvaluate2, 2.718281828459045d) != 0) {
                    dLog2 /= Math.log(dSingleOperandEvaluate2);
                }
                dLog = dLog2;
            }
            NumericFunction.checkValue(dLog);
            return new NumberEval(dLog);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

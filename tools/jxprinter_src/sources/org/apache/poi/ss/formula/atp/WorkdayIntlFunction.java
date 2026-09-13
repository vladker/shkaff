package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class WorkdayIntlFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new WorkdayIntlFunction(ArgumentsEvaluator.instance);
    private ArgumentsEvaluator evaluator;

    private WorkdayIntlFunction(ArgumentsEvaluator argumentsEvaluator) {
        this.evaluator = argumentsEvaluator;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 2 || valueEvalArr.length > 4) {
            return ErrorEval.VALUE_INVALID;
        }
        int rowIndex = operationEvaluationContext.getRowIndex();
        int columnIndex = operationEvaluationContext.getColumnIndex();
        try {
            double dEvaluateDateArg = this.evaluator.evaluateDateArg(valueEvalArr[0], rowIndex, columnIndex);
            int iEvaluateNumberArg = 1;
            int iFloor = (int) Math.floor(this.evaluator.evaluateNumberArg(valueEvalArr[1], rowIndex, columnIndex));
            if (valueEvalArr.length >= 3) {
                ValueEval valueEval = valueEvalArr[2];
                iEvaluateNumberArg = valueEval != BlankEval.instance ? (int) this.evaluator.evaluateNumberArg(valueEval, rowIndex, columnIndex) : 1;
                if (!WorkdayCalculator.instance.getValidWeekendTypes().contains(Integer.valueOf(iEvaluateNumberArg))) {
                    return ErrorEval.NUM_ERROR;
                }
            }
            return new NumberEval(DateUtil.getExcelDate(WorkdayCalculator.instance.calculateWorkdays(dEvaluateDateArg, iFloor, iEvaluateNumberArg, this.evaluator.evaluateDatesArg(valueEvalArr.length >= 4 ? valueEvalArr[3] : null, rowIndex, columnIndex))));
        } catch (EvaluationException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }
}

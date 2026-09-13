package org.apache.poi.ss.formula.functions;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.DateParser;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Days implements FreeRefFunction {
    public static final Days instance = new Days();

    private Days() {
    }

    public static LocalDate getDate(ValueEval valueEval, int i5, int i6) {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
        try {
            return getDate(NumericFunction.singleOperandEvaluate(singleValue, i5, i6));
        } catch (Exception unused) {
            return DateParser.parseLocalDate(OperandResolver.coerceValueToString(singleValue));
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return valueEvalArr.length != 2 ? ErrorEval.VALUE_INVALID : evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
    }

    private ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return new NumberEval(evaluate(getDate(valueEval, i5, i6), getDate(valueEval2, i5, i6)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static LocalDate getDate(double d) {
        return DateUtil.getJavaDate(d, false).toInstant().atZone(LocaleUtil.getUserTimeZone().toZoneId()).toLocalDate();
    }

    private static double evaluate(LocalDate localDate, LocalDate localDate2) {
        return ChronoUnit.DAYS.between(localDate2, localDate);
    }
}

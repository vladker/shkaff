package org.apache.poi.ss.formula.functions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WeekNum extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new WeekNum();
    private static final NumberEval DEFAULT_RETURN_TYPE = new NumberEval(1.0d);
    private static final HashSet<Integer> VALID_RETURN_TYPES = new HashSet<>(Arrays.asList(1, 2, 11, 12, 13, 14, 15, 16, 17, 21));
    private WeekFields SUNDAY_START = WeekFields.of(DayOfWeek.SUNDAY, 1);
    private WeekFields MONDAY_START = WeekFields.of(DayOfWeek.MONDAY, 1);
    private WeekFields TUESDAY_START = WeekFields.of(DayOfWeek.TUESDAY, 1);
    private WeekFields WEDNESDAY_START = WeekFields.of(DayOfWeek.WEDNESDAY, 1);
    private WeekFields THURSDAY_START = WeekFields.of(DayOfWeek.THURSDAY, 1);
    private WeekFields FRIDAY_START = WeekFields.of(DayOfWeek.FRIDAY, 1);
    private WeekFields SATURDAY_START = WeekFields.of(DayOfWeek.SATURDAY, 1);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            try {
                LocalDate localDate = DateUtil.getJavaDate(NumericFunction.singleOperandEvaluate(valueEval, i5, i6), false).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                try {
                    ValueEval singleValue = OperandResolver.getSingleValue(valueEval2, i5, i6);
                    int numberValue = singleValue instanceof MissingArgEval ? (int) DEFAULT_RETURN_TYPE.getNumberValue() : OperandResolver.coerceValueToInt(singleValue);
                    return !VALID_RETURN_TYPES.contains(Integer.valueOf(numberValue)) ? ErrorEval.NUM_ERROR : new NumberEval(getWeekNo(localDate, numberValue));
                } catch (EvaluationException unused) {
                    return ErrorEval.NUM_ERROR;
                }
            } catch (Exception unused2) {
                return ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException unused3) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    public int getWeekNo(LocalDate localDate, int i5) {
        if (i5 == 1 || i5 == 17) {
            return localDate.get(this.SUNDAY_START.weekOfYear());
        }
        if (i5 == 2 || i5 == 11) {
            return localDate.get(this.MONDAY_START.weekOfYear());
        }
        if (i5 == 12) {
            return localDate.get(this.TUESDAY_START.weekOfYear());
        }
        if (i5 == 13) {
            return localDate.get(this.WEDNESDAY_START.weekOfYear());
        }
        if (i5 == 14) {
            return localDate.get(this.THURSDAY_START.weekOfYear());
        }
        if (i5 == 15) {
            return localDate.get(this.FRIDAY_START.weekOfYear());
        }
        return i5 == 16 ? localDate.get(this.SATURDAY_START.weekOfYear()) : localDate.get(WeekFields.ISO.weekOfYear());
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 1) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], DEFAULT_RETURN_TYPE);
        }
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}

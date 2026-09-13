package org.apache.poi.ss.formula.functions;

import java.time.LocalDate;
import java.util.Calendar;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Days360 extends Var2or3ArgFunction {
    private static Calendar getDate(double d) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(DateUtil.getJavaDate(d, false));
        return localeCalendar;
    }

    private static int[] getEndingDate(Calendar calendar, int[] iArr, boolean z6) {
        int i5 = 1;
        int i6 = calendar.get(1);
        int i7 = calendar.get(2);
        int iMin = Math.min(30, calendar.get(5));
        if (z6 || calendar.get(5) != 31) {
            i5 = iMin;
        } else if (iArr[2] < 30) {
            calendar.set(5, 1);
            calendar.add(2, 1);
            i6 = calendar.get(1);
            i7 = calendar.get(2);
        } else {
            i5 = 30;
        }
        return new int[]{i6, i7, i5};
    }

    private static int[] getStartingDate(Calendar calendar, boolean z6) {
        return new int[]{calendar.get(1), calendar.get(2), (z6 || !isLastDayOfMonth(calendar)) ? Math.min(30, calendar.get(5)) : 30};
    }

    private static boolean isLastDayOfMonth(Calendar calendar) {
        return calendar.get(5) == calendar.getActualMaximum(5);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return new NumberEval(evaluate(DateUtil.getExcelDate(Days.getDate(valueEval, i5, i6)), DateUtil.getExcelDate(Days.getDate(valueEval2, i5, i6)), false));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            LocalDate date = Days.getDate(valueEval, i5, i6);
            LocalDate date2 = Days.getDate(valueEval2, i5, i6);
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval3, i5, i6);
            boolean z6 = false;
            Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(singleValue, false);
            double excelDate = DateUtil.getExcelDate(date);
            double excelDate2 = DateUtil.getExcelDate(date2);
            if (boolCoerceValueToBoolean != null && boolCoerceValueToBoolean.booleanValue()) {
                z6 = true;
            }
            return new NumberEval(evaluate(excelDate, excelDate2, z6));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double evaluate(double d, double d6, boolean z6) {
        Calendar date = getDate(d);
        Calendar date2 = getDate(d6);
        int[] startingDate = getStartingDate(date, z6);
        int[] endingDate = getEndingDate(date2, startingDate, z6);
        return (((((double) endingDate[1]) * 30.0d) + (((double) endingDate[0]) * 360.0d)) + ((double) endingDate[2])) - (((((double) startingDate[1]) * 30.0d) + (((double) startingDate[0]) * 360.0d)) + ((double) startingDate[2]));
    }
}

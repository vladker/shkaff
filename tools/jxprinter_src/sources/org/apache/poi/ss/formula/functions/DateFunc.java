package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DateFunc extends Fixed3ArgFunction {
    public static final Function instance = new DateFunc();

    private DateFunc() {
    }

    private static int getYear(double d) {
        int i5 = (int) d;
        if (i5 < 0) {
            return -1;
        }
        return i5 < 1900 ? i5 + Videoio.CAP_FFMPEG : i5;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            double dEvaluate = evaluate(getYear(NumericFunction.singleOperandEvaluate(valueEval, i5, i6)), (int) (NumericFunction.singleOperandEvaluate(valueEval2, i5, i6) - 1.0d), (int) NumericFunction.singleOperandEvaluate(valueEval3, i5, i6));
            NumericFunction.checkValue(dEvaluate);
            return new NumberEval(dEvaluate);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double evaluate(int i5, int i6, int i7) throws EvaluationException {
        if (i5 < 0) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        while (i6 < 0) {
            i5--;
            i6 += 12;
        }
        if (i5 == 1900 && i6 == 1 && i7 == 29) {
            return 60.0d;
        }
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar(i5, i6, (i5 != 1900 || ((i6 != 0 || i7 < 60) && (i6 != 1 || i7 < 30))) ? i7 : i7 - 1);
        if (i7 < 0 && localeCalendar.get(1) == 1900 && i6 > 1 && localeCalendar.get(2) < 2) {
            localeCalendar.add(5, 1);
        }
        return DateUtil.getExcelDate(localeCalendar.getTime(), false);
    }
}

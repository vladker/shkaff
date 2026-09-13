package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CalendarFieldFunction extends Fixed1ArgFunction {
    private final int _dateFieldId;
    public static final Function YEAR = new CalendarFieldFunction(1);
    public static final Function MONTH = new CalendarFieldFunction(2);
    public static final Function DAY = new CalendarFieldFunction(5);
    public static final Function HOUR = new CalendarFieldFunction(11);
    public static final Function MINUTE = new CalendarFieldFunction(12);
    public static final Function SECOND = new CalendarFieldFunction(13);

    private CalendarFieldFunction(int i5) {
        this._dateFieldId = i5;
    }

    private int getCalField(double d) {
        if (((int) d) == 0) {
            int i5 = this._dateFieldId;
            if (i5 == 1) {
                return Videoio.CAP_FFMPEG;
            }
            if (i5 == 2) {
                return 1;
            }
            if (i5 == 5) {
                return 0;
            }
        }
        int i6 = DateUtil.getJavaCalendarUTC(d + 5.78125E-6d, false).get(this._dateFieldId);
        return this._dateFieldId == 2 ? i6 + 1 : i6;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public final ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
            return dCoerceValueToDouble < 0.0d ? ErrorEval.NUM_ERROR : new NumberEval(getCalField(dCoerceValueToDouble));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

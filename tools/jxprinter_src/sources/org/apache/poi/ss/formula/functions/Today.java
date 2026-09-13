package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Today {
    public static ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length != 0) {
            return ErrorEval.VALUE_INVALID;
        }
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.clear(10);
        localeCalendar.set(11, 0);
        localeCalendar.clear(12);
        localeCalendar.clear(13);
        localeCalendar.clear(14);
        return new NumberEval(DateUtil.getExcelDate(localeCalendar.getTime()));
    }
}

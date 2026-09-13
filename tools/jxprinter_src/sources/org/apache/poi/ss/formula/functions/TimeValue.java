package org.apache.poi.ss.formula.functions;

import java.time.DateTimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.DateParser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TimeValue extends Fixed1ArgFunction {
    private static final Logger LOG = LogManager.getLogger((Class<?>) TimeValue.class);

    private NumberEval parseTimeFromDateTime(String str) {
        return new NumberEval(DateUtil.parseDateTime(str).doubleValue() - DateUtil.getExcelDate(DateParser.parseLocalDate(str)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        try {
            String strCoerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i5, i6));
            if (strCoerceValueToString == null || strCoerceValueToString.isEmpty()) {
                return BlankEval.instance;
            }
            try {
                try {
                    return parseTimeFromDateTime(strCoerceValueToString);
                } catch (Exception unused) {
                    return parseTimeFromDateTime("1/01/2000 ".concat(strCoerceValueToString));
                }
            } catch (Exception unused2) {
                DateParser.parseLocalDate(strCoerceValueToString);
                return new NumberEval(0.0d);
            }
        } catch (DateTimeException e) {
            LOG.atInfo().log("Failed to parse date/time", e);
            return ErrorEval.VALUE_INVALID;
        } catch (EvaluationException e6) {
            return e6.getErrorEval();
        }
    }
}

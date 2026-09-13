package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeFunc extends Fixed3ArgFunction {
    private static final int HOURS_PER_DAY = 24;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;

    private static int evalArg(ValueEval valueEval, int i5, int i6) {
        if (valueEval == MissingArgEval.instance) {
            return 0;
        }
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i5, i6));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return new NumberEval(evaluate(evalArg(valueEval, i5, i6), evalArg(valueEval2, i5, i6), evalArg(valueEval3, i5, i6)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double evaluate(int i5, int i6, int i7) throws EvaluationException {
        if (i5 > 32767 || i6 > 32767 || i7 > 32767) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        int i8 = (i6 * 60) + (i5 * SECONDS_PER_HOUR) + i7;
        if (i8 >= 0) {
            return ((double) (i8 % 86400)) / 86400.0d;
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}

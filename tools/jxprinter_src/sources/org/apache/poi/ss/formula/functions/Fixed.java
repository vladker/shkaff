package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Fixed implements Function1Arg, Function2Arg, Function3Arg {
    private ValueEval fixed(ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, int i5, int i6) {
        try {
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6)));
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i5, i6));
            Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEval3, i5, i6), false);
            BigDecimal scale = bigDecimalValueOf.setScale(iCoerceValueToInt, RoundingMode.HALF_UP);
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            decimalFormat.setGroupingUsed(boolCoerceValueToBoolean == null || !boolCoerceValueToBoolean.booleanValue());
            decimalFormat.setMinimumFractionDigits(Math.max(iCoerceValueToInt, 0));
            decimalFormat.setMaximumFractionDigits(Math.max(iCoerceValueToInt, 0));
            return new StringEval(decimalFormat.format(scale.doubleValue()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        return fixed(valueEval, valueEval2, valueEval3, i5, i6);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        return fixed(valueEval, valueEval2, BoolEval.FALSE, i5, i6);
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    /* JADX INFO: renamed from: evaluate */
    public ValueEval lambda$evaluateArray$0(int i5, int i6, ValueEval valueEval) {
        return fixed(valueEval, new NumberEval(2.0d), BoolEval.FALSE, i5, i6);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        int length = valueEvalArr.length;
        if (length == 1) {
            return fixed(valueEvalArr[0], new NumberEval(2.0d), BoolEval.FALSE, i5, i6);
        }
        if (length == 2) {
            return fixed(valueEvalArr[0], valueEvalArr[1], BoolEval.FALSE, i5, i6);
        }
        if (length != 3) {
            return ErrorEval.VALUE_INVALID;
        }
        return fixed(valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], i5, i6);
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Rate implements Function {
    private static final Logger LOG = LogManager.getLogger((Class<?>) Rate.class);

    private static double _g_div_gp(double d, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d + 1.0d;
        double dPow = Math.pow(d11, d6);
        double dPow2 = Math.pow(d11, d6 - 1.0d);
        double d12 = (dPow * d8) + d9;
        double d13 = (dPow - 1.0d) * d7;
        double d14 = (d * d10) + 1.0d;
        double d15 = d13 * d14;
        return ((d15 / d) + d12) / (((d6 * dPow2) * d8) - (d15 / (((d13 * d10) / d) + (((((d6 * d7) * dPow2) * d14) / d) + Math.pow(d, 2.0d)))));
    }

    public static double calculateRate(double d, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d10;
        int i5 = 0;
        boolean z6 = false;
        while (i5 < 100.0d && !z6) {
            double d_g_div_gp = d11 - _g_div_gp(d11, d, d6, d7, d8, d9);
            z6 = Math.abs(d_g_div_gp - d11) < 1.0E-8d;
            i5++;
            d11 = d_g_div_gp;
        }
        if (z6) {
            return d11;
        }
        return Double.NaN;
    }

    public static void checkValue(double d) throws EvaluationException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 3) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dCalculateRate = calculateRate(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i5, i6)), OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], i5, i6)), OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[2], i5, i6)), valueEvalArr.length >= 4 ? OperandResolver.coerceValueToDouble(valueEvalArr.length >= 4 ? OperandResolver.getSingleValue(valueEvalArr[3], i5, i6) : null) : 0.0d, valueEvalArr.length >= 5 ? OperandResolver.coerceValueToDouble(valueEvalArr.length >= 5 ? OperandResolver.getSingleValue(valueEvalArr[4], i5, i6) : null) : 0.0d, valueEvalArr.length >= 6 ? OperandResolver.coerceValueToDouble(valueEvalArr.length >= 6 ? OperandResolver.getSingleValue(valueEvalArr[5], i5, i6) : null) : 0.1d);
            checkValue(dCalculateRate);
            return new NumberEval(dCalculateRate);
        } catch (EvaluationException e) {
            LOG.atError().withThrowable(e).log("Can't evaluate rate function");
            return e.getErrorEval();
        }
    }
}

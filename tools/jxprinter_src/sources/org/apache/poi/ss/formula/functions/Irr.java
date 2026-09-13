package org.apache.poi.ss.formula.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Irr implements Function {
    private static final double ABSOLUTE_ACCURACY = 1.0E-7d;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) Irr.class);
    private static final int MAX_ITERATION_COUNT = 1000;

    public static double irr(double[] dArr) {
        return irr(dArr, 0.1d);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length == 0 || valueEvalArr.length > 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dIrr = irr(AggregateFunction.ValueCollector.collectValues(valueEvalArr[0]), valueEvalArr.length == 2 ? NumericFunction.singleOperandEvaluate(valueEvalArr[1], i5, i6) : 0.1d);
            NumericFunction.checkValue(dIrr);
            return new NumberEval(dIrr);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public static double irr(double[] dArr, double d) {
        char c = 0;
        double d6 = d;
        int i5 = 0;
        while (true) {
            double d7 = Double.NaN;
            if (i5 >= 1000) {
                LOGGER.atWarn().log("Returning NaN because IRR has reached max number of iterations allowed: {}", (Object) 1000);
                return Double.NaN;
            }
            double d8 = 1.0d + d6;
            if (d8 == 0.0d) {
                LOGGER.atWarn().log("Returning NaN because IRR has found an denominator of 0");
                return Double.NaN;
            }
            double d9 = dArr[c];
            int i6 = 1;
            double d10 = d8;
            double d11 = 0.0d;
            while (i6 < dArr.length) {
                double d12 = dArr[i6];
                d9 = (d12 / d10) + d9;
                d10 *= d8;
                d11 -= (((double) i6) * d12) / d10;
                i6++;
                d7 = d7;
            }
            double d13 = d7;
            if (d11 == 0.0d) {
                LOGGER.atWarn().log("Returning NaN because IRR has found an fDerivative of 0");
                return d13;
            }
            double d14 = d6 - (d9 / d11);
            if (Math.abs(d14 - d6) <= ABSOLUTE_ACCURACY) {
                return d14;
            }
            i5++;
            d6 = d14;
            c = 0;
        }
    }
}

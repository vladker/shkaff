package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class NumericFunction implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long PARITY_MASK = -2;
    private static final double TEN = 10.0d;
    private static final double ZERO = 0.0d;
    private static final double LOG_10_TO_BASE_e = Math.log(10.0d);
    public static final Function ABS = oneDouble(new g(5));
    public static final Function ACOS = oneDouble(new g(7));
    public static final Function ACOSH = oneDouble(new g(18));
    public static final Function ASIN = oneDouble(new g(24));
    public static final Function ASINH = oneDouble(new g(25));
    public static final Function ATAN = oneDouble(new g(26));
    public static final Function ATANH = oneDouble(new g(27));
    public static final Function COS = oneDouble(new g(28));
    public static final Function COSH = oneDouble(new g(29));
    public static final Function DEGREES = oneDouble(new h(0));
    public static final Function DOLLAR = new a(3);
    public static final Function EXP = oneDouble(new g(21));
    public static final Function FACT = oneDouble(new h(1));
    public static final Function INT = oneDouble(new h(2));
    public static final Function LN = oneDouble(new h(3));
    public static final Function LOG10 = oneDouble(new h(4));
    public static final Function RADIANS = oneDouble(new h(5));
    public static final Function SIGN = oneDouble(new h(6));
    public static final Function SIN = oneDouble(new h(7));
    public static final Function SINH = oneDouble(new g(6));
    public static final Function SQRT = oneDouble(new g(8));
    public static final Function TAN = oneDouble(new g(9));
    public static final Function TANH = oneDouble(new g(10));
    public static final Function ATAN2 = twoDouble(new g(11));
    public static final Function CEILING = twoDouble(new g(12));
    public static final Function COMBIN = twoDouble(new g(13));
    public static final Function FLOOR = twoDouble(new g(14));
    public static final Function MOD = twoDouble(new g(15));
    public static final Function POWER = twoDouble(new g(16));
    public static final Function ROUND = twoDouble(new g(17));
    public static final Function ROUNDDOWN = twoDouble(new g(19));
    public static final Function ROUNDUP = twoDouble(new g(20));
    public static final Function TRUNC = new a(4);
    public static final Function LOG = new a(5);
    static final NumberEval PI_EVAL = new NumberEval(3.141592653589793d);
    public static final Function PI = new a(6);
    public static final Function RAND = new a(7);
    public static final Function POISSON = new a(8);
    public static final Function ODD = oneDouble(new g(22));
    public static final Function EVEN = oneDouble(new g(23));

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OneDoubleIf {
        double apply(double d);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TwoDoubleIf {
        Object apply(double d, double d6);
    }

    public static void checkValue(double d) throws EvaluationException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluateDollar(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length != 1 && valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dSingleOperandEvaluate = singleOperandEvaluate(valueEvalArr[0], i5, i6);
            int iSingleOperandEvaluate = (int) (valueEvalArr.length == 1 ? 2.0d : singleOperandEvaluate(valueEvalArr[1], i5, i6));
            if (iSingleOperandEvaluate > 127) {
                return ErrorEval.VALUE_INVALID;
            }
            if (iSingleOperandEvaluate < 0) {
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(Math.pow(10.0d, -iSingleOperandEvaluate));
                dSingleOperandEvaluate = BigDecimal.valueOf(dSingleOperandEvaluate).divide(bigDecimalValueOf, MathContext.DECIMAL128).toBigInteger().multiply(bigDecimalValueOf.toBigInteger()).doubleValue();
            }
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(LocaleUtil.getUserLocale());
            int iMax = Math.max(iSingleOperandEvaluate, 0);
            if (LocaleUtil.getUserLocale().getCountry().equalsIgnoreCase("US")) {
                decimalFormat.setNegativePrefix("(" + decimalFormat.getDecimalFormatSymbols().getCurrencySymbol());
                decimalFormat.setNegativeSuffix(")");
            }
            decimalFormat.setMinimumFractionDigits(iMax);
            decimalFormat.setMaximumFractionDigits(iMax);
            return new StringEval(decimalFormat.format(dSingleOperandEvaluate).replace(" ", " "));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double evaluateEven(double d) {
        if (d == 0.0d) {
            return 0.0d;
        }
        double dAbs = Math.abs(d);
        long j6 = ((long) dAbs) & (-2);
        double dSign = MathX.sign(d);
        if (Double.compare(j6, dAbs) != 0) {
            j6 += 2;
        }
        return dSign * j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double evaluateOdd(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        double dAbs = Math.abs(d) + 1.0d;
        long j6 = ((long) dAbs) & (-2);
        return ((double) MathX.sign(d)) * (Double.compare((double) j6, dAbs) == 0 ? j6 - 1 : j6 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluatePI(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 0 ? ErrorEval.VALUE_INVALID : PI_EVAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluateRand(ValueEval[] valueEvalArr, int i5, int i6) {
        return valueEvalArr.length != 0 ? ErrorEval.VALUE_INVALID : new NumberEval(Math.random());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ValueEval evaluateTrunc(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length != 1 && valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dRoundDown = MathX.roundDown(singleOperandEvaluate(valueEvalArr[0], i5, i6), valueEvalArr.length == 1 ? 0.0d : singleOperandEvaluate(valueEvalArr[1], i5, i6));
            checkValue(dRoundDown);
            return new NumberEval(dRoundDown);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ValueEval lambda$oneDouble$7(OneDoubleIf oneDoubleIf, ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double dApply = oneDoubleIf.apply(singleOperandEvaluate(valueEvalArr[0], i5, i6));
            if (!Double.isNaN(dApply) && !Double.isInfinite(dApply)) {
                return new NumberEval(dApply);
            }
            return ErrorEval.NUM_ERROR;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$static$0(double d) {
        return Math.pow(2.718281828459045d, d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$static$1(double d) {
        return Math.round(d - 0.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$static$2(double d) {
        return Math.log(d) / LOG_10_TO_BASE_e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$3(double d, double d6) {
        return (d == 0.0d && d6 == 0.0d) ? ErrorEval.DIV_ZERO : Double.valueOf(Math.atan2(d6, d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$4(double d, double d6) {
        return (d > 2.147483647E9d || d6 > 2.147483647E9d) ? ErrorEval.NUM_ERROR : Double.valueOf(MathX.nChooseK((int) d, (int) d6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$5(double d, double d6) {
        if (d6 == 0.0d) {
            return d == 0.0d ? Double.valueOf(0.0d) : ErrorEval.DIV_ZERO;
        }
        return Double.valueOf(MathX.floor(d, d6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$6(double d, double d6) {
        return d6 == 0.0d ? ErrorEval.DIV_ZERO : Double.valueOf(MathX.mod(d, d6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ValueEval lambda$twoDouble$8(TwoDoubleIf twoDoubleIf, ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            Object objApply = twoDoubleIf.apply(singleOperandEvaluate(valueEvalArr[0], i5, i6), singleOperandEvaluate(valueEvalArr[1], i5, i6));
            if (objApply instanceof ErrorEval) {
                return (ErrorEval) objApply;
            }
            double dDoubleValue = ((Double) objApply).doubleValue();
            if (!Double.isNaN(dDoubleValue) && !Double.isInfinite(dDoubleValue)) {
                return new NumberEval(dDoubleValue);
            }
            return ErrorEval.NUM_ERROR;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static Function oneDouble(OneDoubleIf oneDoubleIf) {
        return new i(oneDoubleIf, 0);
    }

    public static double singleOperandEvaluate(ValueEval valueEval, int i5, int i6) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("arg must not be null");
        }
        double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i5, i6));
        checkValue(dCoerceValueToDouble);
        return dCoerceValueToDouble;
    }

    private static Function twoDouble(TwoDoubleIf twoDoubleIf) {
        return new i(twoDoubleIf, 1);
    }

    public abstract double eval(ValueEval[] valueEvalArr, int i5, int i6);

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        try {
            double dEval = eval(valueEvalArr, i5, i6);
            checkValue(dEval);
            return new NumberEval(dEval);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AggregateFunction extends MultiOperandNumericFunction {
    public static final Function AVEDEV = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.2
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            return StatsLib.avedev(dArr);
        }
    };
    public static final Function AVERAGE = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.3
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return MathX.average(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function AVERAGEA = new AggregateFunctionA() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.4
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return MathX.average(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function DEVSQ = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.5
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            return StatsLib.devsq(dArr);
        }
    };
    public static final Function LARGE = new LargeSmall(true);
    public static final Function MAX = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.6
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            if (dArr.length > 0) {
                return MathX.max(dArr);
            }
            return 0.0d;
        }
    };
    public static final Function MEDIAN = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.7
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            return StatsLib.median(dArr);
        }
    };
    public static final Function MIN = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.8
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            if (dArr.length > 0) {
                return MathX.min(dArr);
            }
            return 0.0d;
        }
    };
    public static final Function PERCENTILE = new Percentile();
    public static final Function PRODUCT = new Product();
    public static final Function SMALL = new LargeSmall(false);
    public static final Function STDEV = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.9
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.stdev(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function STDEVP = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.10
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.stdevp(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function STDEVA = new AggregateFunctionA() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.11
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.stdev(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function STDEVPA = new AggregateFunctionA() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.12
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.stdevp(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function SUM = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.13
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            return MathX.sum(dArr);
        }
    };
    public static final Function SUMSQ = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.14
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            return MathX.sumsq(dArr);
        }
    };
    public static final Function VAR = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.15
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.var(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function VARP = new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.16
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.varp(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function VARA = new AggregateFunctionA() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.17
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.var(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function VARPA = new AggregateFunctionA() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.18
        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            if (dArr.length >= 1) {
                return StatsLib.varp(dArr);
            }
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
    };
    public static final Function GEOMEAN = new Geomean();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class AggregateFunctionA extends AggregateFunction {
        public AggregateFunctionA() {
            super(true);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public boolean treatStringsAsZero() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Geomean extends AggregateFunction {
        public Geomean() {
            setMissingArgPolicy(MultiOperandNumericFunction.Policy.COERCE);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) throws EvaluationException {
            for (double d : dArr) {
                if (d <= 0.0d) {
                    throw new EvaluationException(ErrorEval.NUM_ERROR);
                }
            }
            return new GeometricMean().evaluate(dArr, 0, dArr.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LargeSmall extends Fixed2ArgFunction {
        private final boolean _isLarge;

        public LargeSmall(boolean z6) {
            this._isLarge = z6;
        }

        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            try {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval2, i5, i6));
                if (dCoerceValueToDouble < 1.0d) {
                    return ErrorEval.NUM_ERROR;
                }
                int iCeil = (int) Math.ceil(dCoerceValueToDouble);
                try {
                    double[] dArrCollectValues = ValueCollector.collectValues(valueEval);
                    if (iCeil > dArrCollectValues.length) {
                        return ErrorEval.NUM_ERROR;
                    }
                    double dKthLargest = this._isLarge ? StatsLib.kthLargest(dArrCollectValues, iCeil) : StatsLib.kthSmallest(dArrCollectValues, iCeil);
                    NumericFunction.checkValue(dKthLargest);
                    return new NumberEval(dKthLargest);
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Percentile extends Fixed2ArgFunction {
        @Override // org.apache.poi.ss.formula.functions.Function2Arg
        public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
            double dA;
            try {
                double dCoerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval2, i5, i6));
                if (dCoerceValueToDouble < 0.0d || dCoerceValueToDouble > 1.0d) {
                    return ErrorEval.NUM_ERROR;
                }
                try {
                    double[] dArrCollectValues = ValueCollector.collectValues(valueEval);
                    int length = dArrCollectValues.length;
                    if (length != 0 && length <= 8191) {
                        double d = (((double) (length - 1)) * dCoerceValueToDouble) + 1.0d;
                        if (d == 1.0d) {
                            dA = StatsLib.kthSmallest(dArrCollectValues, 1);
                        } else if (Double.compare(d, length) == 0) {
                            dA = StatsLib.kthLargest(dArrCollectValues, 1);
                        } else {
                            int i7 = (int) d;
                            dA = androidx.collection.a.a(StatsLib.kthSmallest(dArrCollectValues, i7 + 1), StatsLib.kthSmallest(dArrCollectValues, i7), d - ((double) i7), StatsLib.kthSmallest(dArrCollectValues, i7));
                        }
                        NumericFunction.checkValue(dA);
                        return new NumberEval(dA);
                    }
                    return ErrorEval.NUM_ERROR;
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Product extends AggregateFunction {
        public Product() {
            setMissingArgPolicy(MultiOperandNumericFunction.Policy.SKIP);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            return MathX.product(dArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ValueCollector extends MultiOperandNumericFunction {
        private static final ValueCollector instance = new ValueCollector();

        public ValueCollector() {
            super(false, false);
        }

        public static double[] collectValues(ValueEval... valueEvalArr) {
            return instance.getNumberArray(valueEvalArr);
        }

        @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
        public double evaluate(double[] dArr) {
            throw new IllegalStateException("should not be called");
        }
    }

    public AggregateFunction() {
        this(false);
    }

    public static Function subtotalInstance(Function function, final boolean z6) {
        return new AggregateFunction() { // from class: org.apache.poi.ss.formula.functions.AggregateFunction.1
            @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
            public double evaluate(double[] dArr) {
                return AggregateFunction.this.evaluate(dArr);
            }

            @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
            public boolean isHiddenRowCounted() {
                return z6;
            }

            @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction
            public boolean isSubtotalCounted() {
                return false;
            }
        };
    }

    public AggregateFunction(boolean z6) {
        super(z6, false);
    }
}

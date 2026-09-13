package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Match extends Var2or3ArgFunction {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SingleValueVector implements LookupUtils.ValueVector {
        private final ValueEval _value;

        public SingleValueVector(ValueEval valueEval) {
            this._value = valueEval;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i5) {
            if (i5 == 0) {
                return this._value;
            }
            throw new RuntimeException(androidx.collection.a.i(i5, "Invalid index (", ") only zero is allowed"));
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public int getSize() {
            return 1;
        }
    }

    private static LookupUtils.LookupValueComparer createLookupComparer(ValueEval valueEval, boolean z6) {
        return LookupUtils.createLookupComparer(valueEval, z6, true);
    }

    private static ValueEval eval(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, double d) {
        try {
            return new NumberEval(((double) findIndexOfValue(OperandResolver.getSingleValue(valueEval, i5, i6), evaluateLookupRange(valueEval2), d == 0.0d, d > 0.0d)) + 1.0d);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static LookupUtils.ValueVector evaluateLookupRange(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            return refEval.getNumberOfSheets() == 1 ? new SingleValueVector(refEval.getInnerValueEval(refEval.getFirstSheetIndex())) : LookupUtils.createVector(refEval);
        }
        if (valueEval instanceof TwoDEval) {
            LookupUtils.ValueVector valueVectorCreateVector = LookupUtils.createVector((TwoDEval) valueEval);
            if (valueVectorCreateVector != null) {
                return valueVectorCreateVector;
            }
            throw new EvaluationException(ErrorEval.NA);
        }
        if (valueEval instanceof NumericValueEval) {
            throw new EvaluationException(ErrorEval.NA);
        }
        if (valueEval instanceof StringEval) {
            if (OperandResolver.parseDouble(((StringEval) valueEval).getStringValue()) == null) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            throw new EvaluationException(ErrorEval.NA);
        }
        throw new RuntimeException("Unexpected eval type (" + valueEval + ")");
    }

    private static double evaluateMatchTypeArg(ValueEval valueEval, int i5, int i6) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
        if (singleValue instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) singleValue);
        }
        if (singleValue instanceof NumericValueEval) {
            return ((NumericValueEval) singleValue).getNumberValue();
        }
        if (singleValue instanceof StringEval) {
            Double d = OperandResolver.parseDouble(((StringEval) singleValue).getStringValue());
            if (d != null) {
                return d.doubleValue();
            }
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        if ((singleValue instanceof MissingArgEval) || (singleValue instanceof BlankEval)) {
            return 1.0d;
        }
        throw new RuntimeException("Unexpected match_type type (" + singleValue.getClass().getName() + ")");
    }

    private static int findIndexOfValue(ValueEval valueEval, LookupUtils.ValueVector valueVector, boolean z6, boolean z7) throws EvaluationException {
        LookupUtils.LookupValueComparer lookupValueComparerCreateLookupComparer = createLookupComparer(valueEval, z6);
        int size = valueVector.getSize();
        int i5 = 0;
        if (z6) {
            while (i5 < size) {
                if (lookupValueComparerCreateLookupComparer.compareTo(valueVector.getItem(i5)).isEqual()) {
                    return i5;
                }
                i5++;
            }
            throw new EvaluationException(ErrorEval.NA);
        }
        if (z7) {
            for (int i6 = size - 1; i6 >= 0; i6--) {
                LookupUtils.CompareResult compareResultCompareTo = lookupValueComparerCreateLookupComparer.compareTo(valueVector.getItem(i6));
                if (!compareResultCompareTo.isTypeMismatch() && !compareResultCompareTo.isLessThan()) {
                    return i6;
                }
            }
            throw new EvaluationException(ErrorEval.NA);
        }
        while (i5 < size) {
            LookupUtils.CompareResult compareResultCompareTo2 = lookupValueComparerCreateLookupComparer.compareTo(valueVector.getItem(i5));
            if (compareResultCompareTo2.isEqual()) {
                return i5;
            }
            if (compareResultCompareTo2.isGreaterThan()) {
                if (i5 >= 1) {
                    return i5 - 1;
                }
                throw new EvaluationException(ErrorEval.NA);
            }
            i5++;
        }
        return size - 1;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        return eval(i5, i6, valueEval, valueEval2, 1.0d);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return eval(i5, i6, valueEval, valueEval2, evaluateMatchTypeArg(valueEval3, i5, i6));
        } catch (EvaluationException unused) {
            return ErrorEval.REF_INVALID;
        }
    }
}

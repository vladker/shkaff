package org.apache.poi.ss.formula.functions;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LinearRegressionFunction extends Fixed2ArgFunction {
    private final FUNCTION function;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval twoDEval) {
            super(twoDEval.getHeight() * twoDEval.getWidth());
            this._ae = twoDEval;
            this._width = twoDEval.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        public ValueEval getItemInternal(int i5) {
            int i6 = this._width;
            return this._ae.getValue(i5 / i6, i5 % i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum FUNCTION {
        INTERCEPT,
        SLOPE
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class RefValueArray extends ValueArray {
        private final RefEval _ref;
        private final int _width;

        public RefValueArray(RefEval refEval) {
            super(refEval.getNumberOfSheets());
            this._ref = refEval;
            this._width = refEval.getNumberOfSheets();
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        public ValueEval getItemInternal(int i5) {
            return this._ref.getInnerValueEval(this._ref.getFirstSheetIndex() + (i5 % this._width));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SingleCellValueArray extends ValueArray {
        private final ValueEval _value;

        public SingleCellValueArray(ValueEval valueEval) {
            super(1);
            this._value = valueEval;
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        public ValueEval getItemInternal(int i5) {
            return this._value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class ValueArray implements LookupUtils.ValueVector {
        private final int _size;

        public ValueArray(int i5) {
            this._size = i5;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i5) {
            if (i5 >= 0 && i5 <= this._size) {
                return getItemInternal(i5);
            }
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified index ", " is outside range (0..");
            sbT.append(this._size - 1);
            sbT.append(")");
            throw new IllegalArgumentException(sbT.toString());
        }

        public abstract ValueEval getItemInternal(int i5);

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public final int getSize() {
            return this._size;
        }
    }

    public LinearRegressionFunction(FUNCTION function) {
        this.function = function;
    }

    private static LookupUtils.ValueVector createValueVector(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval instanceof TwoDEval) {
            return new AreaValueArray((TwoDEval) valueEval);
        }
        return valueEval instanceof RefEval ? new RefValueArray((RefEval) valueEval) : new SingleCellValueArray(valueEval);
    }

    private double evaluateInternal(LookupUtils.ValueVector valueVector, LookupUtils.ValueVector valueVector2, int i5) throws EvaluationException {
        ErrorEval errorEval = null;
        boolean z6 = false;
        double numberValue = 0.0d;
        double numberValue2 = 0.0d;
        for (int i6 = 0; i6 < i5; i6++) {
            ValueEval item = valueVector.getItem(i6);
            ValueEval item2 = valueVector2.getItem(i6);
            if (item instanceof ErrorEval) {
                throw new EvaluationException((ErrorEval) item);
            }
            if ((item2 instanceof ErrorEval) && errorEval == null) {
                errorEval = (ErrorEval) item2;
            } else if ((item instanceof NumberEval) && (item2 instanceof NumberEval)) {
                numberValue += ((NumberEval) item).getNumberValue();
                numberValue2 += ((NumberEval) item2).getNumberValue();
                z6 = true;
            }
        }
        if (errorEval != null) {
            throw new EvaluationException(errorEval);
        }
        if (!z6) {
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
        double d = i5;
        double d6 = numberValue / d;
        double d7 = numberValue2 / d;
        double numberValue3 = 0.0d;
        double numberValue4 = 0.0d;
        for (int i7 = 0; i7 < i5; i7++) {
            ValueEval item3 = valueVector.getItem(i7);
            ValueEval item4 = valueVector2.getItem(i7);
            if ((item3 instanceof NumberEval) && (item4 instanceof NumberEval)) {
                NumberEval numberEval = (NumberEval) item3;
                numberValue3 = ((numberEval.getNumberValue() - d6) * (numberEval.getNumberValue() - d6)) + numberValue3;
                numberValue4 = ((((NumberEval) item4).getNumberValue() - d7) * (numberEval.getNumberValue() - d6)) + numberValue4;
            }
        }
        if (numberValue3 == 0.0d) {
            throw new EvaluationException(ErrorEval.DIV_ZERO);
        }
        double d8 = numberValue4 / numberValue3;
        return this.function == FUNCTION.INTERCEPT ? d7 - (d6 * d8) : d8;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            LookupUtils.ValueVector valueVectorCreateValueVector = createValueVector(valueEval);
            LookupUtils.ValueVector valueVectorCreateValueVector2 = createValueVector(valueEval2);
            int size = valueVectorCreateValueVector2.getSize();
            if (size != 0 && valueVectorCreateValueVector.getSize() == size) {
                double dEvaluateInternal = evaluateInternal(valueVectorCreateValueVector2, valueVectorCreateValueVector, size);
                return (Double.isNaN(dEvaluateInternal) || Double.isInfinite(dEvaluateInternal)) ? ErrorEval.NUM_ERROR : new NumberEval(dEvaluateInternal);
            }
            return ErrorEval.NA;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

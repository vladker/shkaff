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
public abstract class XYNumericFunction extends Fixed2ArgFunction {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Accumulator {
        double accumulate(double d, double d6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval twoDEval) {
            super(twoDEval.getHeight() * twoDEval.getWidth());
            this._ae = twoDEval;
            this._width = twoDEval.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
        public ValueEval getItemInternal(int i5) {
            int i6 = this._width;
            return this._ae.getValue(i5 / i6, i5 % i6);
        }
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

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
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

        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.ValueArray
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
        Accumulator accumulatorCreateAccumulator = createAccumulator();
        ErrorEval errorEval = null;
        double dAccumulate = 0.0d;
        boolean z6 = false;
        ErrorEval errorEval2 = null;
        for (int i6 = 0; i6 < i5; i6++) {
            ValueEval item = valueVector.getItem(i6);
            ValueEval item2 = valueVector2.getItem(i6);
            if ((item instanceof ErrorEval) && errorEval == null) {
                errorEval = (ErrorEval) item;
            } else if ((item2 instanceof ErrorEval) && errorEval2 == null) {
                errorEval2 = (ErrorEval) item2;
            } else if ((item instanceof NumberEval) && (item2 instanceof NumberEval)) {
                z6 = true;
                dAccumulate = accumulatorCreateAccumulator.accumulate(((NumberEval) item).getNumberValue(), ((NumberEval) item2).getNumberValue()) + dAccumulate;
            }
        }
        if (errorEval != null) {
            throw new EvaluationException(errorEval);
        }
        if (errorEval2 != null) {
            throw new EvaluationException(errorEval2);
        }
        if (z6) {
            return dAccumulate;
        }
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    }

    public abstract Accumulator createAccumulator();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            LookupUtils.ValueVector valueVectorCreateValueVector = createValueVector(valueEval);
            LookupUtils.ValueVector valueVectorCreateValueVector2 = createValueVector(valueEval2);
            int size = valueVectorCreateValueVector.getSize();
            if (size != 0 && valueVectorCreateValueVector2.getSize() == size) {
                double dEvaluateInternal = evaluateInternal(valueVectorCreateValueVector, valueVectorCreateValueVector2, size);
                return (Double.isNaN(dEvaluateInternal) || Double.isInfinite(dEvaluateInternal)) ? ErrorEval.NUM_ERROR : new NumberEval(dEvaluateInternal);
            }
            return ErrorEval.NA;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

package org.apache.poi.ss.formula.functions;

import A3.AbstractC0157z;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Offset implements Function {
    private static final int LAST_VALID_COLUMN_INDEX = 255;
    private static final int LAST_VALID_ROW_INDEX = 65535;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LinearOffsetRange {
        private final int _length;
        private final int _offset;

        public LinearOffsetRange(int i5, int i6) {
            if (i6 == 0) {
                throw new RuntimeException("length may not be zero");
            }
            this._offset = i5;
            this._length = i6;
        }

        public short getFirstIndex() {
            return (short) this._offset;
        }

        public short getLastIndex() {
            return (short) ((this._offset + this._length) - 1);
        }

        public boolean isOutOfBounds(int i5, int i6) {
            return this._offset < i5 || getLastIndex() > i6;
        }

        public LinearOffsetRange normaliseAndTranslate(int i5) {
            int i6 = this._length;
            if (i6 > 0) {
                return i5 == 0 ? this : new LinearOffsetRange(i5 + this._offset, i6);
            }
            return new LinearOffsetRange(i5 + this._offset + i6 + 1, -i6);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            androidx.collection.a.w(LinearOffsetRange.class, sb, " [");
            sb.append(this._offset);
            sb.append("...");
            return AbstractC0157z.l("]", getLastIndex(), sb);
        }
    }

    private static AreaEval createOffset(BaseRef baseRef, LinearOffsetRange linearOffsetRange, LinearOffsetRange linearOffsetRange2) throws EvaluationException {
        LinearOffsetRange linearOffsetRangeNormaliseAndTranslate = linearOffsetRange.normaliseAndTranslate(baseRef.getFirstRowIndex());
        LinearOffsetRange linearOffsetRangeNormaliseAndTranslate2 = linearOffsetRange2.normaliseAndTranslate(baseRef.getFirstColumnIndex());
        if (linearOffsetRangeNormaliseAndTranslate.isOutOfBounds(0, 65535)) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        if (linearOffsetRangeNormaliseAndTranslate2.isOutOfBounds(0, 255)) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        return baseRef.offset(linearOffsetRange.getFirstIndex(), linearOffsetRange.getLastIndex(), linearOffsetRange2.getFirstIndex(), linearOffsetRange2.getLastIndex());
    }

    private static BaseRef evaluateBaseRef(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            return new BaseRef((RefEval) valueEval);
        }
        if (valueEval instanceof AreaEval) {
            return new BaseRef((AreaEval) valueEval);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    public static int evaluateIntArg(ValueEval valueEval, int i5, int i6) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i5, i6));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004b A[Catch: EvaluationException -> 0x0042, TryCatch #0 {EvaluationException -> 0x0042, blocks: (B:8:0x000a, B:12:0x001c, B:16:0x0028, B:31:0x0054, B:33:0x0063, B:20:0x0037, B:22:0x003d, B:25:0x0044, B:27:0x004b, B:15:0x0024, B:11:0x0018), top: B:39:0x000a }] */
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        ValueEval valueEval;
        if (valueEvalArr.length < 1 || valueEvalArr.length > 5) {
            return ErrorEval.VALUE_INVALID;
        }
        int iEvaluateIntArg = 0;
        try {
            BaseRef baseRefEvaluateBaseRef = evaluateBaseRef(valueEvalArr[0]);
            ValueEval valueEval2 = valueEvalArr[1];
            int iEvaluateIntArg2 = valueEval2 instanceof MissingArgEval ? 0 : evaluateIntArg(valueEval2, i5, i6);
            ValueEval valueEval3 = valueEvalArr[2];
            if (!(valueEval3 instanceof MissingArgEval)) {
                iEvaluateIntArg = evaluateIntArg(valueEval3, i5, i6);
            }
            int height = baseRefEvaluateBaseRef.getHeight();
            int width = baseRefEvaluateBaseRef.getWidth();
            int length = valueEvalArr.length;
            if (length == 4) {
                valueEval = valueEvalArr[3];
                if (!(valueEval instanceof MissingArgEval)) {
                    height = evaluateIntArg(valueEval, i5, i6);
                }
            } else if (length == 5) {
                ValueEval valueEval4 = valueEvalArr[4];
                if (!(valueEval4 instanceof MissingArgEval)) {
                    width = evaluateIntArg(valueEval4, i5, i6);
                }
                valueEval = valueEvalArr[3];
                if (!(valueEval instanceof MissingArgEval)) {
                    height = evaluateIntArg(valueEval, i5, i6);
                }
            }
            if (height != 0 && width != 0) {
                return createOffset(baseRefEvaluateBaseRef, new LinearOffsetRange(iEvaluateIntArg2, height), new LinearOffsetRange(iEvaluateIntArg, width));
            }
            return ErrorEval.REF_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BaseRef {
        private final AreaEval _areaEval;
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _height;
        private final RefEval _refEval;
        private final int _width;

        public BaseRef(RefEval refEval) {
            this._refEval = refEval;
            this._areaEval = null;
            this._firstRowIndex = refEval.getRow();
            this._firstColumnIndex = refEval.getColumn();
            this._height = 1;
            this._width = 1;
        }

        public int getFirstColumnIndex() {
            return this._firstColumnIndex;
        }

        public int getFirstRowIndex() {
            return this._firstRowIndex;
        }

        public int getHeight() {
            return this._height;
        }

        public int getWidth() {
            return this._width;
        }

        public AreaEval offset(int i5, int i6, int i7, int i8) {
            RefEval refEval = this._refEval;
            return refEval == null ? this._areaEval.offset(i5, i6, i7, i8) : refEval.offset(i5, i6, i7, i8);
        }

        public BaseRef(AreaEval areaEval) {
            this._refEval = null;
            this._areaEval = areaEval;
            this._firstRowIndex = areaEval.getFirstRow();
            this._firstColumnIndex = areaEval.getFirstColumn();
            this._height = (areaEval.getLastRow() - areaEval.getFirstRow()) + 1;
            this._width = (areaEval.getLastColumn() - areaEval.getFirstColumn()) + 1;
        }
    }
}

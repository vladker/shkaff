package org.apache.poi.ss.formula.functions;

import java.util.function.BiFunction;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ArrayFunction {
    static ValueEval _evaluateOneArrayArg(ValueEval valueEval, int i5, int i6, java.util.function.Function<ValueEval, ValueEval> function) {
        int i7;
        int height;
        int row;
        int column;
        ValueEval errorEval;
        if (valueEval instanceof AreaEval) {
            AreaEval areaEval = (AreaEval) valueEval;
            int width = areaEval.getWidth();
            height = areaEval.getHeight();
            column = areaEval.getFirstColumn();
            row = areaEval.getFirstRow();
            i7 = width;
        } else if (valueEval instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval;
            column = refEval.getColumn();
            row = refEval.getRow();
            i7 = 1;
            height = 1;
        } else {
            i7 = 1;
            height = 1;
            row = 0;
            column = 0;
        }
        int iMax = Math.max(i7, 1);
        int iMax2 = Math.max(height, 1);
        int i8 = iMax2 * iMax;
        ValueEval[] valueEvalArr = new ValueEval[i8];
        int i9 = 0;
        int i10 = 0;
        while (i10 < iMax2) {
            int i11 = i9;
            int i12 = 0;
            while (i12 < iMax) {
                try {
                    errorEval = OperandResolver.getSingleValue(valueEval, row + i10, column + i12);
                } catch (FormulaParseException unused) {
                    errorEval = ErrorEval.NAME_INVALID;
                } catch (RuntimeException e) {
                    if (!e.getMessage().startsWith("Don't know how to evaluate name")) {
                        throw e;
                    }
                    errorEval = ErrorEval.NAME_INVALID;
                } catch (EvaluationException e6) {
                    errorEval = e6.getErrorEval();
                }
                valueEvalArr[i11] = function.apply(errorEval);
                i12++;
                i11++;
            }
            i10++;
            i9 = i11;
        }
        return i8 == 1 ? valueEvalArr[0] : new CacheAreaEval(i5, i6, (i5 + iMax2) - 1, (i6 + iMax) - 1, valueEvalArr);
    }

    static ValueEval _evaluateTwoArrayArgs(ValueEval valueEval, ValueEval valueEval2, int i5, int i6, BiFunction<ValueEval, ValueEval, ValueEval> biFunction) {
        int i7;
        int row;
        int height;
        int column;
        int row2;
        int width;
        int height2;
        int column2;
        ValueEval errorEval;
        ValueEval errorEval2;
        ValueEval valueEval3 = valueEval;
        if (valueEval3 instanceof AreaEval) {
            AreaEval areaEval = (AreaEval) valueEval3;
            int width2 = areaEval.getWidth();
            height = areaEval.getHeight();
            column = areaEval.getFirstColumn();
            row = areaEval.getFirstRow();
            i7 = width2;
        } else if (valueEval3 instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval3;
            column = refEval.getColumn();
            row = refEval.getRow();
            i7 = 1;
            height = 1;
        } else {
            i7 = 1;
            row = 0;
            height = 1;
            column = 0;
        }
        if (valueEval2 instanceof AreaEval) {
            AreaEval areaEval2 = (AreaEval) valueEval2;
            width = areaEval2.getWidth();
            height2 = areaEval2.getHeight();
            column2 = areaEval2.getFirstColumn();
            row2 = areaEval2.getFirstRow();
        } else if (valueEval2 instanceof RefEval) {
            RefEval refEval2 = (RefEval) valueEval2;
            column2 = refEval2.getColumn();
            row2 = refEval2.getRow();
            width = 1;
            height2 = 1;
        } else {
            row2 = 0;
            width = 1;
            height2 = 1;
            column2 = 0;
        }
        int iMax = Math.max(i7, width);
        int iMax2 = Math.max(height, height2);
        int i8 = iMax2 * iMax;
        ValueEval[] valueEvalArr = new ValueEval[i8];
        int i9 = 0;
        int i10 = 0;
        while (i10 < iMax2) {
            int i11 = i9;
            int i12 = 0;
            while (i12 < iMax) {
                try {
                    errorEval = OperandResolver.getSingleValue(valueEval3, row + i10, column + i12);
                } catch (FormulaParseException unused) {
                    errorEval = ErrorEval.NAME_INVALID;
                } catch (RuntimeException e) {
                    if (!e.getMessage().startsWith("Don't know how to evaluate name")) {
                        throw e;
                    }
                    errorEval = ErrorEval.NAME_INVALID;
                } catch (EvaluationException e6) {
                    errorEval = e6.getErrorEval();
                }
                ValueEval valueEval4 = errorEval;
                try {
                    errorEval2 = OperandResolver.getSingleValue(valueEval2, row2 + i10, column2 + i12);
                } catch (FormulaParseException unused2) {
                    errorEval2 = ErrorEval.NAME_INVALID;
                } catch (RuntimeException e7) {
                    if (!e7.getMessage().startsWith("Don't know how to evaluate name")) {
                        throw e7;
                    }
                    errorEval2 = ErrorEval.NAME_INVALID;
                } catch (EvaluationException e8) {
                    errorEval2 = e8.getErrorEval();
                }
                if (valueEval4 instanceof ErrorEval) {
                    valueEvalArr[i11] = valueEval4;
                    i11++;
                } else if (errorEval2 instanceof ErrorEval) {
                    valueEvalArr[i11] = errorEval2;
                    i11++;
                } else {
                    valueEvalArr[i11] = biFunction.apply(valueEval4, errorEval2);
                    i11++;
                }
                i12++;
                valueEval3 = valueEval;
            }
            i10++;
            valueEval3 = valueEval;
            i9 = i11;
        }
        return i8 == 1 ? valueEvalArr[0] : new CacheAreaEval(i5, i6, (i5 + iMax2) - 1, (i6 + iMax) - 1, valueEvalArr);
    }

    ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6);

    default ValueEval evaluateOneArrayArg(ValueEval valueEval, int i5, int i6, java.util.function.Function<ValueEval, ValueEval> function) {
        return _evaluateOneArrayArg(valueEval, i5, i6, function);
    }

    default ValueEval evaluateTwoArrayArgs(ValueEval valueEval, ValueEval valueEval2, int i5, int i6, BiFunction<ValueEval, ValueEval, ValueEval> biFunction) {
        return _evaluateTwoArrayArgs(valueEval, valueEval2, i5, i6, biFunction);
    }
}

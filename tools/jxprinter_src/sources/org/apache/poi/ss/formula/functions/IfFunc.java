package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IfFunc extends Var2or3ArgFunction implements ArrayFunction {
    public static boolean evaluateFirstArg(ValueEval valueEval, int i5, int i6) {
        Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEval, i5, i6), false);
        if (boolCoerceValueToBoolean == null) {
            return false;
        }
        return boolCoerceValueToBoolean.booleanValue();
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            if (evaluateFirstArg(valueEval, i5, i6)) {
                return valueEval2 == MissingArgEval.instance ? BlankEval.instance : valueEval2;
            }
            return BoolEval.FALSE;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 2 || valueEvalArr.length > 3) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluateArrayArgs(valueEvalArr[0], valueEvalArr[1], valueEvalArr.length == 2 ? BoolEval.FALSE : valueEvalArr[2], i5, i6);
    }

    public ValueEval evaluateArrayArgs(ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, int i5, int i6) {
        int i7;
        int row;
        int height;
        int column;
        int row2;
        int width;
        int height2;
        int column2;
        int row3;
        int column3;
        ValueEval errorEval;
        ValueEval errorEval2;
        ValueEval errorEval3;
        int i8;
        ValueEval valueEval4 = valueEval;
        if (valueEval4 instanceof AreaEval) {
            AreaEval areaEval = (AreaEval) valueEval4;
            int width2 = areaEval.getWidth();
            height = areaEval.getHeight();
            column = areaEval.getFirstColumn();
            row = areaEval.getFirstRow();
            i7 = width2;
        } else if (valueEval4 instanceof RefEval) {
            RefEval refEval = (RefEval) valueEval4;
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
        if (valueEval3 instanceof AreaEval) {
            AreaEval areaEval3 = (AreaEval) valueEval3;
            column3 = areaEval3.getFirstColumn();
            row3 = areaEval3.getFirstRow();
        } else if (valueEval3 instanceof RefEval) {
            RefEval refEval3 = (RefEval) valueEval3;
            column3 = refEval3.getColumn();
            row3 = refEval3.getRow();
        } else {
            row3 = 0;
            column3 = 0;
        }
        int iMax = Math.max(i7, width);
        int iMax2 = Math.max(height, height2);
        int i9 = iMax2 * iMax;
        ValueEval[] valueEvalArr = new ValueEval[i9];
        int i10 = 0;
        int i11 = 0;
        while (i11 < iMax2) {
            int i12 = i10;
            int i13 = 0;
            while (i13 < iMax) {
                int i14 = i11;
                try {
                    errorEval = OperandResolver.getSingleValue(valueEval4, row + i11, column + i13);
                } catch (FormulaParseException unused) {
                    errorEval = ErrorEval.NAME_INVALID;
                } catch (EvaluationException e) {
                    errorEval = e.getErrorEval();
                }
                ValueEval valueEval5 = errorEval;
                try {
                    errorEval2 = OperandResolver.getSingleValue(valueEval2, row2 + i14, column2 + i13);
                } catch (FormulaParseException unused2) {
                    errorEval2 = ErrorEval.NAME_INVALID;
                } catch (EvaluationException e6) {
                    errorEval2 = e6.getErrorEval();
                }
                ValueEval valueEval6 = errorEval2;
                try {
                    errorEval3 = OperandResolver.getSingleValue(valueEval3, row3 + i14, column3 + i13);
                } catch (FormulaParseException unused3) {
                    errorEval3 = ErrorEval.NAME_INVALID;
                } catch (EvaluationException e7) {
                    errorEval3 = e7.getErrorEval();
                }
                if (valueEval5 instanceof ErrorEval) {
                    valueEvalArr[i12] = valueEval5;
                    i12++;
                } else {
                    try {
                        Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(valueEval5, false);
                        i8 = i12 + 1;
                        if (boolCoerceValueToBoolean != null) {
                            try {
                                if (boolCoerceValueToBoolean.booleanValue()) {
                                    errorEval3 = valueEval6;
                                }
                            } catch (EvaluationException e8) {
                                e = e8;
                                i12 = i8;
                                i8 = i12 + 1;
                                valueEvalArr[i12] = e.getErrorEval();
                            }
                        }
                        valueEvalArr[i12] = errorEval3;
                    } catch (EvaluationException e9) {
                        e = e9;
                    }
                    i12 = i8;
                }
                i13++;
                valueEval4 = valueEval;
                i11 = i14;
            }
            i11++;
            valueEval4 = valueEval;
            i10 = i12;
        }
        return i9 == 1 ? valueEvalArr[0] : new CacheAreaEval(i5, i6, (i5 + iMax2) - 1, (i6 + iMax) - 1, valueEvalArr);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            if (evaluateFirstArg(valueEval, i5, i6)) {
                return valueEval2 == MissingArgEval.instance ? BlankEval.instance : valueEval2;
            }
            return valueEval3 == MissingArgEval.instance ? BlankEval.instance : valueEval3;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Index implements Function2Arg, Function3Arg, Function4Arg, ArrayMode {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static TwoDEval convertFirstArg(ValueEval valueEval) {
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        if (valueEval instanceof TwoDEval) {
            return (TwoDEval) valueEval;
        }
        throw new RuntimeException("Incomplete code - cannot handle first arg of type (" + valueEval.getClass().getName() + ")");
    }

    private static ValueEval getValueFromArea(TwoDEval twoDEval, int i5, int i6) throws EvaluationException {
        TwoDEval row;
        if (i5 == 0) {
            row = twoDEval;
        } else {
            if (i5 > twoDEval.getHeight()) {
                throw new EvaluationException(ErrorEval.REF_INVALID);
            }
            row = twoDEval.getRow(i5 - 1);
        }
        if (i6 == 0) {
            return row;
        }
        if (i6 <= twoDEval.getWidth()) {
            return row.getColumn(i6 - 1);
        }
        throw new EvaluationException(ErrorEval.REF_INVALID);
    }

    private static int resolveIndexArg(ValueEval valueEval, int i5, int i6) throws EvaluationException {
        ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
        if (singleValue == MissingArgEval.instance || singleValue == BlankEval.instance) {
            return 0;
        }
        int iCoerceValueToInt = OperandResolver.coerceValueToInt(singleValue);
        if (iCoerceValueToInt >= 0) {
            return iCoerceValueToInt;
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        TwoDEval twoDEvalConvertFirstArg = convertFirstArg(valueEval);
        try {
            int iResolveIndexArg = resolveIndexArg(valueEval2, i5, i6);
            int i7 = 0;
            if (!twoDEvalConvertFirstArg.isColumn()) {
                if (!twoDEvalConvertFirstArg.isRow()) {
                    return ErrorEval.REF_INVALID;
                }
                i7 = iResolveIndexArg;
                iResolveIndexArg = 0;
            }
            return getValueFromArea(twoDEvalConvertFirstArg, iResolveIndexArg, i7);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return getValueFromArea(convertFirstArg(valueEval), resolveIndexArg(valueEval2, i5, i6), resolveIndexArg(valueEval3, i5, i6));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        throw new RuntimeException("Incomplete code - don't know how to support the 'area_num' parameter yet)");
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        int length = valueEvalArr.length;
        if (length == 2) {
            return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1]);
        }
        if (length == 3) {
            return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        if (length != 4) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEvalArr[3]);
    }
}

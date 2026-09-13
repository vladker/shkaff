package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Address implements Function {
    public static final int REF_ABSOLUTE = 1;
    public static final int REF_RELATIVE = 4;
    public static final int REF_ROW_ABSOLUTE_COLUMN_RELATIVE = 2;
    public static final int REF_ROW_RELATIVE_RELATIVE_ABSOLUTE = 3;

    /* JADX WARN: Code duplicated, block: B:36:0x006a A[Catch: EvaluationException -> 0x0029, TryCatch #0 {EvaluationException -> 0x0029, blocks: (B:8:0x000b, B:10:0x001d, B:12:0x0023, B:28:0x0047, B:30:0x004b, B:33:0x0056, B:34:0x005a, B:36:0x006a, B:37:0x0072, B:23:0x0038, B:24:0x003f), top: B:43:0x000b }] */
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        boolean z6;
        String strCoerceValueToString;
        StringBuilder sb;
        ValueEval singleValue;
        ValueEval valueEval;
        if (valueEvalArr.length < 2 || valueEvalArr.length > 5) {
            return ErrorEval.VALUE_INVALID;
        }
        boolean z7 = false;
        try {
            int iSingleOperandEvaluate = (int) NumericFunction.singleOperandEvaluate(valueEvalArr[0], i5, i6);
            int iSingleOperandEvaluate2 = (int) NumericFunction.singleOperandEvaluate(valueEvalArr[1], i5, i6);
            int iSingleOperandEvaluate3 = (valueEvalArr.length <= 2 || (valueEval = valueEvalArr[2]) == MissingArgEval.instance) ? 1 : (int) NumericFunction.singleOperandEvaluate(valueEval, i5, i6);
            if (iSingleOperandEvaluate3 != 1) {
                if (iSingleOperandEvaluate3 == 2) {
                    z6 = false;
                    z7 = true;
                } else if (iSingleOperandEvaluate3 == 3) {
                    z6 = true;
                } else if (iSingleOperandEvaluate3 != 4) {
                    throw new EvaluationException(ErrorEval.VALUE_INVALID);
                }
                strCoerceValueToString = null;
                if (valueEvalArr.length == 5 && (singleValue = OperandResolver.getSingleValue(valueEvalArr[4], i5, i6)) != MissingArgEval.instance) {
                    strCoerceValueToString = OperandResolver.coerceValueToString(singleValue);
                }
                CellReference cellReference = new CellReference(iSingleOperandEvaluate - 1, iSingleOperandEvaluate2 - 1, z7, z6);
                sb = new StringBuilder(32);
                if (strCoerceValueToString != null) {
                    SheetNameFormatter.appendFormat(sb, strCoerceValueToString);
                    sb.append('!');
                }
                sb.append(cellReference.formatAsString());
                return new StringEval(sb.toString());
            }
            z7 = true;
            z6 = z7;
            strCoerceValueToString = null;
            if (valueEvalArr.length == 5) {
                strCoerceValueToString = OperandResolver.coerceValueToString(singleValue);
            }
            CellReference cellReference2 = new CellReference(iSingleOperandEvaluate - 1, iSingleOperandEvaluate2 - 1, z7, z6);
            sb = new StringBuilder(32);
            if (strCoerceValueToString != null) {
                SheetNameFormatter.appendFormat(sb, strCoerceValueToString);
                sb.append('!');
            }
            sb.append(cellReference2.formatAsString());
            return new StringEval(sb.toString());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

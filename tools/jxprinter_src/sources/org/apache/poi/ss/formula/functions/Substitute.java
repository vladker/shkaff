package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Substitute extends Var3or4ArgFunction {
    private static String replaceAllOccurrences(String str, String str2, String str3) {
        if (str2.length() < 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                return androidx.exifinterface.media.a.j(str, length, sb);
            }
            sb.append((CharSequence) str, length, iIndexOf);
            sb.append(str3);
            length = str2.length() + iIndexOf;
        }
    }

    private static String replaceOneOccurrence(String str, String str2, String str3, int i5) {
        if (str2.length() < 1) {
            return str;
        }
        int length = 0;
        int i6 = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                return str;
            }
            i6++;
            if (i6 == i5) {
                return str.substring(0, iIndexOf) + str3 + str.substring(str2.length() + iIndexOf);
            }
            length = iIndexOf + str2.length();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            return new StringEval(replaceAllOccurrences(TextFunction.evaluateStringArg(valueEval, i5, i6), TextFunction.evaluateStringArg(valueEval2, i5, i6), TextFunction.evaluateStringArg(valueEval3, i5, i6)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4) {
        try {
            String strEvaluateStringArg = TextFunction.evaluateStringArg(valueEval, i5, i6);
            String strEvaluateStringArg2 = TextFunction.evaluateStringArg(valueEval2, i5, i6);
            String strEvaluateStringArg3 = TextFunction.evaluateStringArg(valueEval3, i5, i6);
            int iEvaluateIntArg = TextFunction.evaluateIntArg(valueEval4, i5, i6);
            if (iEvaluateIntArg < 1) {
                return ErrorEval.VALUE_INVALID;
            }
            return new StringEval(replaceOneOccurrence(strEvaluateStringArg, strEvaluateStringArg2, strEvaluateStringArg3, iEvaluateIntArg));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}

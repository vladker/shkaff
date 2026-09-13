package org.apache.poi.ss.formula.eval;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ErrorEval implements ValueEval {
    private final FormulaError _error;
    private static final Map<FormulaError, ErrorEval> evals = new HashMap();
    public static final ErrorEval NULL_INTERSECTION = new ErrorEval(FormulaError.NULL);
    public static final ErrorEval DIV_ZERO = new ErrorEval(FormulaError.DIV0);
    public static final ErrorEval VALUE_INVALID = new ErrorEval(FormulaError.VALUE);
    public static final ErrorEval REF_INVALID = new ErrorEval(FormulaError.REF);
    public static final ErrorEval NAME_INVALID = new ErrorEval(FormulaError.NAME);
    public static final ErrorEval NUM_ERROR = new ErrorEval(FormulaError.NUM);
    public static final ErrorEval NA = new ErrorEval(FormulaError.NA);
    public static final ErrorEval FUNCTION_NOT_IMPLEMENTED = new ErrorEval(FormulaError.FUNCTION_NOT_IMPLEMENTED);
    public static final ErrorEval CIRCULAR_REF_ERROR = new ErrorEval(FormulaError.CIRCULAR_REF);

    private ErrorEval(FormulaError formulaError) {
        this._error = formulaError;
        evals.put(formulaError, this);
    }

    public static String getText(int i5) {
        return FormulaError.isValidCode(i5) ? FormulaError.forInt(i5).getString() : androidx.collection.a.i(i5, "~non~std~err(", ")~");
    }

    public static ErrorEval valueOf(int i5) {
        ErrorEval errorEval = evals.get(FormulaError.forInt(i5));
        if (errorEval != null) {
            return errorEval;
        }
        throw new RuntimeException(AbstractC0157z.k(i5, "Unhandled error type for code "));
    }

    public int getErrorCode() {
        return this._error.getLongCode();
    }

    public String getErrorString() {
        return this._error.getString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(ErrorEval.class, sb, " [");
        sb.append(this._error.getString());
        sb.append("]");
        return sb.toString();
    }
}

package org.apache.poi.ss.formula.eval;

import java.time.DateTimeException;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class OperandResolver {
    private static final String Digits = "(\\p{Digit}+)";
    private static final String Exp = "[eE][+-]?(\\p{Digit}+)";
    private static final String fpRegex = "[\\x00-\\x20]*[+-]?(((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.(\\p{Digit}+)([eE][+-]?(\\p{Digit}+))?))[\\x00-\\x20]*";
    private static final Pattern fpPattern = Pattern.compile(fpRegex);

    private OperandResolver() {
    }

    public static ValueEval chooseSingleElementFromArea(AreaEval areaEval, int i5, int i6) throws EvaluationException {
        ValueEval valueEvalChooseSingleElementFromAreaInternal = chooseSingleElementFromAreaInternal(areaEval, i5, i6);
        if (valueEvalChooseSingleElementFromAreaInternal instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEvalChooseSingleElementFromAreaInternal);
        }
        return valueEvalChooseSingleElementFromAreaInternal;
    }

    private static ValueEval chooseSingleElementFromAreaInternal(AreaEval areaEval, int i5, int i6) throws EvaluationException {
        if (areaEval.isColumn()) {
            if (areaEval.isRow()) {
                return areaEval.getRelativeValue(0, 0);
            }
            if (areaEval.containsRow(i5)) {
                return areaEval.getAbsoluteValue(i5, areaEval.getFirstColumn());
            }
            throw EvaluationException.invalidValue();
        }
        if (areaEval.isRow()) {
            if (areaEval.containsColumn(i6)) {
                return areaEval.getAbsoluteValue(areaEval.getFirstRow(), i6);
            }
            throw EvaluationException.invalidValue();
        }
        if (areaEval.containsRow(i5) && areaEval.containsColumn(i6)) {
            return areaEval.getAbsoluteValue(i5, i6);
        }
        throw EvaluationException.invalidValue();
    }

    private static ValueEval chooseSingleElementFromRef(RefEval refEval) {
        return refEval.getInnerValueEval(refEval.getFirstSheetIndex());
    }

    public static Boolean coerceValueToBoolean(ValueEval valueEval, boolean z6) {
        if (valueEval == null || valueEval == BlankEval.instance) {
            return null;
        }
        if (valueEval instanceof BoolEval) {
            return Boolean.valueOf(((BoolEval) valueEval).getBooleanValue());
        }
        if (valueEval instanceof StringEval) {
            if (z6) {
                return null;
            }
            String stringValue = ((StringEval) valueEval).getStringValue();
            if (stringValue.equalsIgnoreCase("true")) {
                return Boolean.TRUE;
            }
            if (stringValue.equalsIgnoreCase("false")) {
                return Boolean.FALSE;
            }
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        if (valueEval instanceof NumericValueEval) {
            double numberValue = ((NumericValueEval) valueEval).getNumberValue();
            if (Double.isNaN(numberValue)) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return Boolean.valueOf(numberValue != 0.0d);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new RuntimeException("Unexpected eval (" + valueEval.getClass().getName() + ")");
    }

    public static double coerceValueToDouble(ValueEval valueEval) {
        if (valueEval == BlankEval.instance) {
            return 0.0d;
        }
        if (valueEval instanceof NumericValueEval) {
            return ((NumericValueEval) valueEval).getNumberValue();
        }
        if (!(valueEval instanceof StringEval)) {
            throw new RuntimeException("Unexpected arg eval type (" + valueEval.getClass().getName() + ")");
        }
        String stringValue = ((StringEval) valueEval).getStringValue();
        Double dateTime = parseDouble(stringValue);
        if (dateTime == null) {
            dateTime = parseDateTime(stringValue);
        }
        if (dateTime != null) {
            return dateTime.doubleValue();
        }
        throw EvaluationException.invalidValue();
    }

    public static int coerceValueToInt(ValueEval valueEval) {
        if (valueEval == BlankEval.instance) {
            return 0;
        }
        return (int) Math.floor(coerceValueToDouble(valueEval));
    }

    public static String coerceValueToString(ValueEval valueEval) {
        if (valueEval instanceof StringValueEval) {
            return ((StringValueEval) valueEval).getStringValue();
        }
        if (valueEval == BlankEval.instance) {
            return "";
        }
        throw new IllegalArgumentException("Unexpected eval class (" + valueEval.getClass().getName() + ")");
    }

    public static ValueEval getElementFromArray(AreaEval areaEval, EvaluationCell evaluationCell) {
        CellRangeAddress arrayFormulaRange = evaluationCell.getArrayFormulaRange();
        int rowIndex = evaluationCell.getRowIndex() - arrayFormulaRange.getFirstRow();
        int columnIndex = evaluationCell.getColumnIndex() - arrayFormulaRange.getFirstColumn();
        if (areaEval.isColumn()) {
            if (areaEval.isRow()) {
                return areaEval.getRelativeValue(0, 0);
            }
            if (rowIndex < areaEval.getHeight()) {
                return areaEval.getRelativeValue(rowIndex, 0);
            }
        } else {
            if (!areaEval.isRow() && rowIndex < areaEval.getHeight() && columnIndex < areaEval.getWidth()) {
                return areaEval.getRelativeValue(rowIndex, columnIndex);
            }
            if (areaEval.isRow() && columnIndex < areaEval.getWidth()) {
                return areaEval.getRelativeValue(0, columnIndex);
            }
        }
        return ErrorEval.NA;
    }

    public static ValueEval getSingleValue(ValueEval valueEval, int i5, int i6) {
        if (valueEval instanceof RefEval) {
            valueEval = chooseSingleElementFromRef((RefEval) valueEval);
        } else if (valueEval instanceof AreaEval) {
            valueEval = chooseSingleElementFromArea((AreaEval) valueEval, i5, i6);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        return valueEval;
    }

    public static Double parseDateTime(String str) {
        try {
            return DateUtil.parseDateTime(str);
        } catch (DateTimeException unused) {
            return null;
        }
    }

    public static Double parseDouble(String str) {
        if (fpPattern.matcher(str).matches()) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}

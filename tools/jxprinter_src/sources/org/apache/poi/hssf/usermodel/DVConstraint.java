package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.DVRecord;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DVConstraint implements DataValidationConstraint {
    private String[] _explicitListValues;
    private String _formula1;
    private String _formula2;
    private int _operator;
    private final int _validationType;
    private Double _value1;
    private Double _value2;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FormulaPair {
        private final Ptg[] _formula1;
        private final Ptg[] _formula2;

        public FormulaPair(Ptg[] ptgArr, Ptg[] ptgArr2) {
            this._formula1 = ptgArr == null ? null : (Ptg[]) ptgArr.clone();
            this._formula2 = ptgArr2 != null ? (Ptg[]) ptgArr2.clone() : null;
        }

        public Ptg[] getFormula1() {
            return this._formula1;
        }

        public Ptg[] getFormula2() {
            return this._formula2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FormulaValuePair {
        private String _formula;
        private String _value;

        private FormulaValuePair() {
        }

        public String formula() {
            return this._formula;
        }

        public String string() {
            String str = this._formula;
            if (str != null) {
                return str;
            }
            String str2 = this._value;
            if (str2 != null) {
                return str2;
            }
            return null;
        }

        public Double value() {
            String str = this._value;
            if (str == null) {
                return null;
            }
            return Double.valueOf(str);
        }
    }

    private DVConstraint(int i5, int i6, String str, String str2, Double d, Double d6, String[] strArr) {
        this._validationType = i5;
        this._operator = i6;
        this._formula1 = str;
        this._formula2 = str2;
        this._value1 = d;
        this._value2 = d6;
        this._explicitListValues = strArr == null ? null : (String[]) strArr.clone();
    }

    private static Double convertDate(String str, SimpleDateFormat simpleDateFormat) {
        Date yYYYMMDDDate;
        if (str == null) {
            return null;
        }
        if (simpleDateFormat == null) {
            yYYYMMDDDate = DateUtil.parseYYYYMMDDDate(str);
        } else {
            try {
                yYYYMMDDDate = simpleDateFormat.parse(str);
            } catch (ParseException e) {
                throw new RuntimeException("Failed to parse date '" + str + "' using specified format '" + simpleDateFormat + "'", e);
            }
        }
        return Double.valueOf(DateUtil.getExcelDate(yYYYMMDDDate));
    }

    private static Ptg[] convertDoubleFormula(String str, Double d, HSSFSheet hSSFSheet) {
        if (str == null) {
            return d == null ? Ptg.EMPTY_PTG_ARRAY : new Ptg[]{new NumberPtg(d.doubleValue())};
        }
        if (d != null) {
            throw new IllegalStateException("Both formula and value cannot be present");
        }
        HSSFWorkbook workbook = hSSFSheet.getWorkbook();
        return HSSFFormulaParser.parse(str, workbook, FormulaType.CELL, workbook.getSheetIndex(hSSFSheet));
    }

    private static Double convertNumber(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            throw new RuntimeException(AbstractC0157z.o("The supplied text '", str, "' could not be parsed as a number"));
        }
    }

    private static Double convertTime(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(DateUtil.convertTime(str));
    }

    public static DVConstraint createCustomFormulaConstraint(String str) {
        if (str != null) {
            return new DVConstraint(7, 0, str, null, null, null, null);
        }
        throw new IllegalArgumentException("formula must be supplied");
    }

    public static DVConstraint createDVConstraint(DVRecord dVRecord, FormulaRenderingWorkbook formulaRenderingWorkbook) {
        switch (dVRecord.getDataType()) {
            case 0:
                return new DVConstraint(0, dVRecord.getConditionOperator(), null, null, null, null, null);
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                FormulaValuePair formulaString = toFormulaString(dVRecord.getFormula1(), formulaRenderingWorkbook);
                FormulaValuePair formulaString2 = toFormulaString(dVRecord.getFormula2(), formulaRenderingWorkbook);
                return new DVConstraint(dVRecord.getDataType(), dVRecord.getConditionOperator(), formulaString.formula(), formulaString2.formula(), formulaString.value(), formulaString2.value(), null);
            case 3:
                if (!dVRecord.getListExplicitFormula()) {
                    return createFormulaListConstraint(toFormulaString(dVRecord.getFormula1(), formulaRenderingWorkbook).string());
                }
                String strString = toFormulaString(dVRecord.getFormula1(), formulaRenderingWorkbook).string();
                if (strString.startsWith("\"")) {
                    strString = strString.substring(1);
                }
                if (strString.endsWith("\"")) {
                    strString = androidx.collection.a.g(1, 0, strString);
                }
                return createExplicitListConstraint(strString.split(Pattern.quote(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR)));
            case 7:
                return createCustomFormulaConstraint(toFormulaString(dVRecord.getFormula1(), formulaRenderingWorkbook).string());
            default:
                throw new UnsupportedOperationException("validationType=" + dVRecord.getDataType());
        }
    }

    public static DVConstraint createDateConstraint(int i5, String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat;
        if (str == null) {
            throw new IllegalArgumentException("expr1 must be supplied");
        }
        DataValidationConstraint.OperatorType.validateSecondArg(i5, str2);
        if (str3 != null) {
            simpleDateFormat = new SimpleDateFormat(str3, LocaleUtil.getUserLocale());
            simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
        } else {
            simpleDateFormat = null;
        }
        String formulaFromTextExpression = getFormulaFromTextExpression(str);
        Double dConvertDate = formulaFromTextExpression == null ? convertDate(str, simpleDateFormat) : null;
        String formulaFromTextExpression2 = getFormulaFromTextExpression(str2);
        return new DVConstraint(4, i5, formulaFromTextExpression, formulaFromTextExpression2, dConvertDate, formulaFromTextExpression2 == null ? convertDate(str2, simpleDateFormat) : null, null);
    }

    public static DVConstraint createExplicitListConstraint(String[] strArr) {
        return new DVConstraint(null, strArr);
    }

    public static DVConstraint createFormulaListConstraint(String str) {
        return new DVConstraint(str, null);
    }

    private Ptg[] createListFormula(HSSFSheet hSSFSheet) {
        String[] strArr = this._explicitListValues;
        if (strArr == null) {
            HSSFWorkbook workbook = hSSFSheet.getWorkbook();
            return HSSFFormulaParser.parse(this._formula1, workbook, FormulaType.DATAVALIDATION_LIST, workbook.getSheetIndex(hSSFSheet));
        }
        StringBuilder sb = new StringBuilder(strArr.length * 16);
        for (int i5 = 0; i5 < this._explicitListValues.length; i5++) {
            if (i5 > 0) {
                sb.append((char) 0);
            }
            sb.append(this._explicitListValues[i5]);
        }
        return new Ptg[]{new StringPtg(sb.toString())};
    }

    public static DVConstraint createNumericConstraint(int i5, int i6, String str, String str2) {
        if (i5 != 0) {
            if (i5 != 1 && i5 != 2 && i5 != 6) {
                throw new IllegalArgumentException(androidx.collection.a.i(i5, "Validation Type (", ") not supported with this method"));
            }
            if (str == null) {
                throw new IllegalArgumentException("expr1 must be supplied");
            }
            DataValidationConstraint.OperatorType.validateSecondArg(i6, str2);
        } else if (str != null || str2 != null) {
            throw new IllegalArgumentException("expr1 and expr2 must be null for validation type 'any'");
        }
        String formulaFromTextExpression = getFormulaFromTextExpression(str);
        Double dConvertNumber = formulaFromTextExpression == null ? convertNumber(str) : null;
        String formulaFromTextExpression2 = getFormulaFromTextExpression(str2);
        return new DVConstraint(i5, i6, formulaFromTextExpression, formulaFromTextExpression2, dConvertNumber, formulaFromTextExpression2 == null ? convertNumber(str2) : null, null);
    }

    public static DVConstraint createTimeConstraint(int i5, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("expr1 must be supplied");
        }
        DataValidationConstraint.OperatorType.validateSecondArg(i5, str);
        String formulaFromTextExpression = getFormulaFromTextExpression(str);
        Double dConvertTime = formulaFromTextExpression == null ? convertTime(str) : null;
        String formulaFromTextExpression2 = getFormulaFromTextExpression(str2);
        return new DVConstraint(5, i5, formulaFromTextExpression, formulaFromTextExpression2, dConvertTime, formulaFromTextExpression2 == null ? convertTime(str2) : null, null);
    }

    private static String getFormulaFromTextExpression(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("Empty string is not a valid formula/value expression");
        }
        if (str.charAt(0) == '=') {
            return str.substring(1);
        }
        return null;
    }

    private static FormulaValuePair toFormulaString(Ptg[] ptgArr, FormulaRenderingWorkbook formulaRenderingWorkbook) {
        FormulaValuePair formulaValuePair = new FormulaValuePair();
        if (ptgArr != null && ptgArr.length > 0) {
            String formulaString = FormulaRenderer.toFormulaString(formulaRenderingWorkbook, ptgArr);
            if (ptgArr.length == 1 && ptgArr[0].getClass() == NumberPtg.class) {
                formulaValuePair._value = formulaString;
                return formulaValuePair;
            }
            formulaValuePair._formula = formulaString;
        }
        return formulaValuePair;
    }

    public FormulaPair createFormulas(HSSFSheet hSSFSheet) {
        Ptg[] ptgArrConvertDoubleFormula;
        Ptg[] ptgArrCreateListFormula;
        if (isListValidationType()) {
            ptgArrCreateListFormula = createListFormula(hSSFSheet);
            ptgArrConvertDoubleFormula = Ptg.EMPTY_PTG_ARRAY;
        } else {
            Ptg[] ptgArrConvertDoubleFormula2 = convertDoubleFormula(this._formula1, this._value1, hSSFSheet);
            ptgArrConvertDoubleFormula = convertDoubleFormula(this._formula2, this._value2, hSSFSheet);
            ptgArrCreateListFormula = ptgArrConvertDoubleFormula2;
        }
        return new FormulaPair(ptgArrCreateListFormula, ptgArrConvertDoubleFormula);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public String[] getExplicitListValues() {
        return this._explicitListValues;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public String getFormula1() {
        return this._formula1;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public String getFormula2() {
        return this._formula2;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public int getOperator() {
        return this._operator;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public int getValidationType() {
        return this._validationType;
    }

    public Double getValue1() {
        return this._value1;
    }

    public Double getValue2() {
        return this._value2;
    }

    public boolean isExplicitList() {
        return this._validationType == 3 && this._explicitListValues != null;
    }

    public boolean isListValidationType() {
        return this._validationType == 3;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setExplicitListValues(String[] strArr) {
        if (this._validationType != 3) {
            throw new RuntimeException("Cannot setExplicitListValues on non-list constraint");
        }
        this._formula1 = null;
        this._explicitListValues = strArr;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setFormula1(String str) {
        this._value1 = null;
        this._explicitListValues = null;
        this._formula1 = str;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setFormula2(String str) {
        this._value2 = null;
        this._formula2 = str;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setOperator(int i5) {
        this._operator = i5;
    }

    public void setValue1(double d) {
        this._formula1 = null;
        this._value1 = Double.valueOf(d);
    }

    public void setValue2(double d) {
        this._formula2 = null;
        this._value2 = Double.valueOf(d);
    }

    private DVConstraint(String str, String[] strArr) {
        this(3, 0, str, null, null, null, strArr);
    }
}

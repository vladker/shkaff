package org.apache.poi.xssf.usermodel;

import java.util.Arrays;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.util.StringUtil;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFDataValidationConstraint implements DataValidationConstraint {
    private static final String LIST_SEPARATOR = ",";
    private static final Pattern LIST_SPLIT_REGEX = Pattern.compile("\\s*,\\s*");
    private static final int MAX_EXPLICIT_LIST_LENGTH = 257;
    private static final String QUOTE = "\"";
    private String[] explicitListOfValues;
    private String formula1;
    private String formula2;
    private int operator;
    private final int validationType;

    public XSSFDataValidationConstraint(String[] strArr) {
        this.operator = -1;
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("List validation with explicit values must specify at least one value");
        }
        this.validationType = 3;
        setExplicitListValues(strArr);
        validate();
    }

    public static boolean isFormulaEmpty(String str) {
        return StringUtil.isBlank(str);
    }

    private static boolean isQuoted(String str) {
        return str.startsWith(QUOTE) && str.endsWith(QUOTE);
    }

    public static String removeLeadingEquals(String str) {
        return (!isFormulaEmpty(str) && str.charAt(0) == '=') ? str.substring(1) : str;
    }

    private static String unquote(String str) {
        return isQuoted(str) ? androidx.collection.a.g(1, 1, str) : str;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public String[] getExplicitListValues() {
        return this.explicitListOfValues;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public String getFormula1() {
        return this.formula1;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public String getFormula2() {
        return this.formula2;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public int getOperator() {
        return this.operator;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public int getValidationType() {
        return this.validationType;
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        STDataValidationType.Enum r6 = XSSFDataValidation.validationTypeMappings.get(Integer.valueOf(this.validationType));
        STDataValidationOperator.Enum r7 = XSSFDataValidation.operatorTypeMappings.get(Integer.valueOf(this.operator));
        sb.append(r6);
        sb.append(Chars.SPACE);
        int i5 = this.validationType;
        if (i5 != 0) {
            if (i5 != 3 && i5 != 7) {
                sb.append(LIST_SEPARATOR);
                sb.append(r7);
                sb.append(", ");
            }
            if (this.validationType != 3 || this.explicitListOfValues == null) {
                sb.append("");
                sb.append(this.formula1);
                sb.append(" ");
            } else {
                sb.append("");
                sb.append(Arrays.asList(this.explicitListOfValues));
                sb.append(" ");
            }
            if (this.formula2 != null) {
                sb.append("");
                sb.append(this.formula2);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setExplicitListValues(String[] strArr) {
        this.explicitListOfValues = strArr;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(QUOTE);
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(LIST_SEPARATOR);
            }
            sb.append(str);
        }
        sb.append(QUOTE);
        setFormula1(sb.toString());
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setFormula1(String str) {
        this.formula1 = removeLeadingEquals(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setFormula2(String str) {
        this.formula2 = removeLeadingEquals(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationConstraint
    public void setOperator(int i5) {
        this.operator = i5;
    }

    public void validate() {
        int i5 = this.validationType;
        if (i5 == 0) {
            return;
        }
        if (i5 == 3) {
            if (isFormulaEmpty(this.formula1)) {
                throw new IllegalArgumentException("A valid formula or a list of values must be specified for list validation.");
            }
            if (this.formula1.length() > 257) {
                throw new IllegalArgumentException("A valid formula or a list of values must be less than or equal to 255 characters (including separators).");
            }
            return;
        }
        if (isFormulaEmpty(this.formula1)) {
            throw new IllegalArgumentException("Formula is not specified. Formula is required for all validation types except explicit list validation.");
        }
        if (this.validationType != 7) {
            int i6 = this.operator;
            if (i6 == -1) {
                throw new IllegalArgumentException("This validation type requires an operator to be specified.");
            }
            if ((i6 == 0 || i6 == 1) && isFormulaEmpty(this.formula2)) {
                throw new IllegalArgumentException("Between and not between comparisons require two formulae to be specified.");
            }
        }
    }

    public XSSFDataValidationConstraint(int i5, String str) {
        this.operator = -1;
        setFormula1(str);
        this.validationType = i5;
        validate();
    }

    public XSSFDataValidationConstraint(int i5, int i6, String str) {
        this.operator = -1;
        setFormula1(str);
        this.validationType = i5;
        this.operator = i6;
        validate();
    }

    public XSSFDataValidationConstraint(int i5, int i6, String str, String str2) {
        String str3;
        this.operator = -1;
        setFormula1(str);
        setFormula2(str2);
        this.validationType = i5;
        this.operator = i6;
        validate();
        if (3 == i5 && (str3 = this.formula1) != null && isQuoted(str3)) {
            this.explicitListOfValues = LIST_SPLIT_REGEX.split(unquote(this.formula1));
        }
    }
}

package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFDataValidation implements DataValidation {
    private static final int MAX_TEXT_LENGTH = 255;
    static Map<Integer, STDataValidationErrorStyle.Enum> errorStyleMappings;
    static Map<STDataValidationErrorStyle.Enum, Integer> reverseErrorStyleMappings;
    private CTDataValidation ctDataValidation;
    private CellRangeAddressList regions;
    private XSSFDataValidationConstraint validationConstraint;
    static Map<Integer, STDataValidationOperator.Enum> operatorTypeMappings = new HashMap();
    static Map<STDataValidationOperator.Enum, Integer> operatorTypeReverseMappings = new HashMap();
    static Map<Integer, STDataValidationType.Enum> validationTypeMappings = new HashMap();
    static Map<STDataValidationType.Enum, Integer> validationTypeReverseMappings = new HashMap();

    static {
        HashMap map = new HashMap();
        errorStyleMappings = map;
        map.put(2, STDataValidationErrorStyle.INFORMATION);
        errorStyleMappings.put(0, STDataValidationErrorStyle.STOP);
        errorStyleMappings.put(1, STDataValidationErrorStyle.WARNING);
        reverseErrorStyleMappings = MapUtils.invertMap(errorStyleMappings);
        operatorTypeMappings.put(0, STDataValidationOperator.BETWEEN);
        operatorTypeMappings.put(1, STDataValidationOperator.NOT_BETWEEN);
        operatorTypeMappings.put(2, STDataValidationOperator.EQUAL);
        operatorTypeMappings.put(3, STDataValidationOperator.NOT_EQUAL);
        operatorTypeMappings.put(4, STDataValidationOperator.GREATER_THAN);
        operatorTypeMappings.put(6, STDataValidationOperator.GREATER_THAN_OR_EQUAL);
        operatorTypeMappings.put(5, STDataValidationOperator.LESS_THAN);
        operatorTypeMappings.put(7, STDataValidationOperator.LESS_THAN_OR_EQUAL);
        for (Map.Entry<Integer, STDataValidationOperator.Enum> entry : operatorTypeMappings.entrySet()) {
            operatorTypeReverseMappings.put(entry.getValue(), entry.getKey());
        }
        validationTypeMappings.put(7, STDataValidationType.CUSTOM);
        validationTypeMappings.put(4, STDataValidationType.DATE);
        validationTypeMappings.put(2, STDataValidationType.DECIMAL);
        validationTypeMappings.put(3, STDataValidationType.LIST);
        validationTypeMappings.put(0, STDataValidationType.NONE);
        validationTypeMappings.put(6, STDataValidationType.TEXT_LENGTH);
        validationTypeMappings.put(5, STDataValidationType.TIME);
        validationTypeMappings.put(1, STDataValidationType.WHOLE);
        for (Map.Entry<Integer, STDataValidationType.Enum> entry2 : validationTypeMappings.entrySet()) {
            validationTypeReverseMappings.put(entry2.getValue(), entry2.getKey());
        }
    }

    public XSSFDataValidation(CellRangeAddressList cellRangeAddressList, CTDataValidation cTDataValidation) {
        this(getConstraint(cTDataValidation), cellRangeAddressList, cTDataValidation);
    }

    private String encodeUtf(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            char c = charArray[i5];
            if (c < ' ') {
                sb.append("_x");
                sb.append(c < 16 ? "000" : TarConstants.VERSION_POSIX);
                sb.append(Integer.toHexString(c));
                sb.append("_");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static XSSFDataValidationConstraint getConstraint(CTDataValidation cTDataValidation) {
        String formula1 = cTDataValidation.getFormula1();
        String formula2 = cTDataValidation.getFormula2();
        STDataValidationOperator.Enum operator = cTDataValidation.getOperator();
        return new XSSFDataValidationConstraint(validationTypeReverseMappings.get(cTDataValidation.getType()).intValue(), operatorTypeReverseMappings.get(operator).intValue(), formula1, formula2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void createErrorBox(String str, String str2) {
        if (str != null && str.length() > 255) {
            throw new IllegalStateException("Error-title cannot be longer than 32 characters, but had: ".concat(str));
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Error-text cannot be longer than 255 characters, but had: ".concat(str2));
        }
        this.ctDataValidation.setErrorTitle(encodeUtf(str));
        this.ctDataValidation.setError(encodeUtf(str2));
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void createPromptBox(String str, String str2) {
        if (str != null && str.length() > 255) {
            throw new IllegalStateException("Error-title cannot be longer than 32 characters, but had: ".concat(str));
        }
        if (str2 != null && str2.length() > 255) {
            throw new IllegalStateException("Error-text cannot be longer than 255 characters, but had: ".concat(str2));
        }
        this.ctDataValidation.setPromptTitle(encodeUtf(str));
        this.ctDataValidation.setPrompt(encodeUtf(str2));
    }

    public CTDataValidation getCtDataValidation() {
        return this.ctDataValidation;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getEmptyCellAllowed() {
        return this.ctDataValidation.getAllowBlank();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getErrorBoxText() {
        return this.ctDataValidation.getError();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getErrorBoxTitle() {
        return this.ctDataValidation.getErrorTitle();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public int getErrorStyle() {
        return reverseErrorStyleMappings.get(this.ctDataValidation.getErrorStyle()).intValue();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getPromptBoxText() {
        return this.ctDataValidation.getPrompt();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public String getPromptBoxTitle() {
        return this.ctDataValidation.getPromptTitle();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public CellRangeAddressList getRegions() {
        return this.regions;
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getShowErrorBox() {
        return this.ctDataValidation.getShowErrorMessage();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getShowPromptBox() {
        return this.ctDataValidation.getShowInputMessage();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public boolean getSuppressDropDownArrow() {
        return !this.ctDataValidation.getShowDropDown();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public DataValidationConstraint getValidationConstraint() {
        return this.validationConstraint;
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        for (CellRangeAddress cellRangeAddress : this.regions.getCellRangeAddresses()) {
            sb.append(cellRangeAddress.formatAsString());
        }
        sb.append(" => ");
        sb.append(this.validationConstraint.prettyPrint());
        return sb.toString();
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setEmptyCellAllowed(boolean z6) {
        this.ctDataValidation.setAllowBlank(z6);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setErrorStyle(int i5) {
        this.ctDataValidation.setErrorStyle(errorStyleMappings.get(Integer.valueOf(i5)));
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setShowErrorBox(boolean z6) {
        this.ctDataValidation.setShowErrorMessage(z6);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setShowPromptBox(boolean z6) {
        this.ctDataValidation.setShowInputMessage(z6);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidation
    public void setSuppressDropDownArrow(boolean z6) {
        if (this.validationConstraint.getValidationType() == 3) {
            this.ctDataValidation.setShowDropDown(!z6);
        }
    }

    public XSSFDataValidation(XSSFDataValidationConstraint xSSFDataValidationConstraint, CellRangeAddressList cellRangeAddressList, CTDataValidation cTDataValidation) {
        this.validationConstraint = xSSFDataValidationConstraint;
        this.ctDataValidation = cTDataValidation;
        this.regions = cellRangeAddressList;
    }
}

package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFName implements Name {
    public static final String BUILTIN_CONSOLIDATE_AREA = "_xlnm.Consolidate_Area";
    public static final String BUILTIN_CRITERIA = "_xlnm.Criteria:";
    public static final String BUILTIN_DATABASE = "_xlnm.Database";
    public static final String BUILTIN_EXTRACT = "_xlnm.Extract:";
    public static final String BUILTIN_FILTER_DB = "_xlnm._FilterDatabase";
    public static final String BUILTIN_PRINT_AREA = "_xlnm.Print_Area";
    public static final String BUILTIN_PRINT_TITLE = "_xlnm.Print_Titles";
    public static final String BUILTIN_SHEET_TITLE = "_xlnm.Sheet_Title";
    private final CTDefinedName _ctName;
    private final XSSFWorkbook _workbook;

    public XSSFName(CTDefinedName cTDefinedName, XSSFWorkbook xSSFWorkbook) {
        this._workbook = xSSFWorkbook;
        this._ctName = cTDefinedName;
    }

    private static void validateName(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': cannot exceed 255 characters in length"));
        }
        if (str.equalsIgnoreCase("R") || str.equalsIgnoreCase("C")) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': cannot be special shorthand R or C"));
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLetter(cCharAt) && "_\\".indexOf(cCharAt) == -1) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': first character must be underscore or a letter"));
        }
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && "_.\\".indexOf(c) == -1) {
                throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': name must be letter, digit, period, or underscore"));
            }
        }
        if (str.matches("[A-Za-z]+\\d+")) {
            try {
                if (CellReference.cellReferenceIsWithinRange(str.replaceAll("\\d", ""), str.replaceAll("[A-Za-z]", ""), SpreadsheetVersion.EXCEL2007)) {
                    throw new IllegalArgumentException("Invalid name: '" + str + "': cannot be $A$1-style cell reference");
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (str.matches("[Rr]\\d+[Cc]\\d+")) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': cannot be R1C1-style cell reference"));
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof XSSFName) {
            return this._ctName.toString().equals(((XSSFName) obj).getCTName().toString());
        }
        return false;
    }

    public CTDefinedName getCTName() {
        return this._ctName;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getComment() {
        return this._ctName.getComment();
    }

    public boolean getFunction() {
        return this._ctName.getFunction();
    }

    public int getFunctionGroupId() {
        return (int) this._ctName.getFunctionGroupId();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getNameName() {
        return this._ctName.getName();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getRefersToFormula() {
        String stringValue = this._ctName.getStringValue();
        if (stringValue == null || stringValue.length() < 1) {
            return null;
        }
        return stringValue;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public int getSheetIndex() {
        if (this._ctName.isSetLocalSheetId()) {
            return (int) this._ctName.getLocalSheetId();
        }
        return -1;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getSheetName() {
        if (!this._ctName.isSetLocalSheetId()) {
            return new AreaReference(getRefersToFormula(), SpreadsheetVersion.EXCEL2007).getFirstCell().getSheetName();
        }
        return this._workbook.getSheetName((int) this._ctName.getLocalSheetId());
    }

    public int hashCode() {
        return this._ctName.toString().hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isDeleted() {
        String refersToFormula = getRefersToFormula();
        if (refersToFormula == null) {
            return false;
        }
        return Ptg.doesFormulaReferToDeletedCell(FormulaParser.parse(refersToFormula, XSSFEvaluationWorkbook.create(this._workbook), FormulaType.NAMEDRANGE, getSheetIndex(), -1));
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isFunctionName() {
        return getFunction();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isHidden() {
        return this._ctName.getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setComment(String str) {
        this._ctName.setComment(str);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setFunction(boolean z6) {
        this._ctName.setFunction(z6);
    }

    public void setFunctionGroupId(int i5) {
        this._ctName.setFunctionGroupId(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setNameName(String str) {
        validateName(str);
        String nameName = getNameName();
        int sheetIndex = getSheetIndex();
        for (XSSFName xSSFName : this._workbook.getNames(str)) {
            if (xSSFName.getSheetIndex() == sheetIndex && xSSFName != this) {
                throw new IllegalArgumentException(androidx.exifinterface.media.a.r(new StringBuilder("The "), sheetIndex == -1 ? "workbook" : "sheet", " already contains this name: ", str));
            }
        }
        this._ctName.setName(str);
        this._workbook.updateName(this, nameName);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setRefersToFormula(String str) {
        FormulaParser.parse(str, XSSFEvaluationWorkbook.create(this._workbook), FormulaType.NAMEDRANGE, getSheetIndex(), -1);
        this._ctName.setStringValue(str);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setSheetIndex(int i5) {
        int numberOfSheets = this._workbook.getNumberOfSheets() - 1;
        if (i5 < -1 || i5 > numberOfSheets) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Sheet index (", ") is out of range");
            sbT.append(numberOfSheets == -1 ? "" : androidx.collection.a.i(numberOfSheets, " (0..", ")"));
            throw new IllegalArgumentException(sbT.toString());
        }
        if (i5 != -1) {
            this._ctName.setLocalSheetId(i5);
        } else if (this._ctName.isSetLocalSheetId()) {
            this._ctName.unsetLocalSheetId();
        }
    }
}

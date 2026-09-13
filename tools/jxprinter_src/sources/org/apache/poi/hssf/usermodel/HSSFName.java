package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFName implements Name {
    private final HSSFWorkbook _book;
    private final NameCommentRecord _commentRec;
    private final NameRecord _definedNameRec;

    public HSSFName(HSSFWorkbook hSSFWorkbook, NameRecord nameRecord) {
        this(hSSFWorkbook, nameRecord, null);
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
        if (str.matches("[A-Za-z]+\\d+") && CellReference.cellReferenceIsWithinRange(str.replaceAll("\\d", ""), str.replaceAll("[A-Za-z]", ""), SpreadsheetVersion.EXCEL97)) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': cannot be $A$1-style cell reference"));
        }
        if (str.matches("[Rr]\\d+[Cc]\\d+")) {
            throw new IllegalArgumentException(AbstractC0157z.o("Invalid name: '", str, "': cannot be R1C1-style cell reference"));
        }
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getComment() {
        NameCommentRecord nameCommentRecord = this._commentRec;
        return (nameCommentRecord == null || nameCommentRecord.getCommentText() == null || this._commentRec.getCommentText().length() <= 0) ? this._definedNameRec.getDescriptionText() : this._commentRec.getCommentText();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getNameName() {
        return this._definedNameRec.getNameText();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getRefersToFormula() {
        if (this._definedNameRec.isFunctionName()) {
            throw new IllegalStateException("Only applicable to named ranges");
        }
        Ptg[] nameDefinition = this._definedNameRec.getNameDefinition();
        if (nameDefinition.length < 1) {
            return null;
        }
        return HSSFFormulaParser.toFormulaString(this._book, nameDefinition);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public int getSheetIndex() {
        return this._definedNameRec.getSheetNumber() - 1;
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public String getSheetName() {
        return this._book.getWorkbook().findSheetFirstNameFromExternSheet(this._definedNameRec.getExternSheetNumber());
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isDeleted() {
        return Ptg.doesFormulaReferToDeletedCell(this._definedNameRec.getNameDefinition());
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isFunctionName() {
        return this._definedNameRec.isFunctionName();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public boolean isHidden() {
        return this._definedNameRec.isHiddenName();
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setComment(String str) {
        this._definedNameRec.setDescriptionText(str);
        NameCommentRecord nameCommentRecord = this._commentRec;
        if (nameCommentRecord != null) {
            nameCommentRecord.setCommentText(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setFunction(boolean z6) {
        this._definedNameRec.setFunction(z6);
    }

    public void setNameDefinition(Ptg[] ptgArr) {
        this._definedNameRec.setNameDefinition(ptgArr);
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setNameName(String str) {
        validateName(str);
        InternalWorkbook workbook = this._book.getWorkbook();
        this._definedNameRec.setNameText(str);
        int sheetNumber = this._definedNameRec.getSheetNumber();
        for (int numNames = workbook.getNumNames() - 1; numNames >= 0; numNames--) {
            NameRecord nameRecord = workbook.getNameRecord(numNames);
            if (nameRecord != this._definedNameRec && nameRecord.getNameText().equalsIgnoreCase(str) && sheetNumber == nameRecord.getSheetNumber()) {
                String strR = androidx.exifinterface.media.a.r(new StringBuilder("The "), sheetNumber == 0 ? "workbook" : "sheet", " already contains this name: ", str);
                this._definedNameRec.setNameText(str + "(2)");
                throw new IllegalArgumentException(strR);
            }
        }
        NameCommentRecord nameCommentRecord = this._commentRec;
        if (nameCommentRecord != null) {
            nameCommentRecord.setNameText(str);
            this._book.getWorkbook().updateNameCommentRecordCache(this._commentRec);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setRefersToFormula(String str) {
        this._definedNameRec.setNameDefinition(HSSFFormulaParser.parse(str, this._book, FormulaType.NAMEDRANGE, getSheetIndex()));
    }

    @Override // org.apache.poi.ss.usermodel.Name
    public void setSheetIndex(int i5) {
        int numberOfSheets = this._book.getNumberOfSheets() - 1;
        if (i5 >= -1 && i5 <= numberOfSheets) {
            this._definedNameRec.setSheetNumber(i5 + 1);
        } else {
            StringBuilder sbT = AbstractC0157z.t(i5, "Sheet index (", ") is out of range");
            sbT.append(numberOfSheets == -1 ? "" : androidx.collection.a.i(numberOfSheets, " (0..", ")"));
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(HSSFName.class, sb, " [");
        sb.append(this._definedNameRec.getNameText());
        sb.append("]");
        return sb.toString();
    }

    public HSSFName(HSSFWorkbook hSSFWorkbook, NameRecord nameRecord, NameCommentRecord nameCommentRecord) {
        this._book = hSSFWorkbook;
        this._definedNameRec = nameRecord;
        this._commentRec = nameCommentRecord;
    }
}

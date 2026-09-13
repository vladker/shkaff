package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFCell extends CellBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FALSE = "FALSE";
    private static final String FALSE_AS_STRING = "0";
    private static final String TRUE = "TRUE";
    private static final String TRUE_AS_STRING = "1";
    private CTCell _cell;
    private int _cellNum;
    private final XSSFRow _row;
    private final SharedStringsTable _sharedStringSource;
    private final StylesTable _stylesSource;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFCell$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BLANK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public XSSFCell(XSSFRow xSSFRow, CTCell cTCell) {
        this._cell = cTCell;
        this._row = xSSFRow;
        String r6 = cTCell.getR();
        if (r6 != null) {
            this._cellNum = new CellReference(r6).getCol();
        } else {
            short lastCellNum = xSSFRow.getLastCellNum();
            if (lastCellNum != -1) {
                this._cellNum = xSSFRow.getCell(lastCellNum - 1, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getColumnIndex() + 1;
            }
        }
        this._sharedStringSource = xSSFRow.getSheet().getWorkbook().getSharedStringSource();
        this._stylesSource = xSSFRow.getSheet().getWorkbook().getStylesSource();
    }

    private static void checkBounds(int i5) {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL2007;
        int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
        if (i5 < 0 || i5 > lastColumnIndex) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Invalid column index (", ").  Allowable column range for ");
            sbT.append(spreadsheetVersion.name());
            sbT.append(" is (0..");
            sbT.append(lastColumnIndex);
            sbT.append(") or ('A'..'");
            sbT.append(spreadsheetVersion.getLastColumnName());
            sbT.append("')");
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    private boolean convertCellValueToBoolean() {
        CellType cellType = getCellType();
        if (cellType == CellType.FORMULA) {
            cellType = getBaseCellType(false);
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                return TRUE_AS_STRING.equals(this._cell.getV());
            }
            if (i5 == 4) {
                return Double.parseDouble(this._cell.getV()) != 0.0d;
            }
            if (i5 == 5) {
                return Boolean.parseBoolean(this._sharedStringSource.getItemAt(Integer.parseInt(this._cell.getV())).getString());
            }
            if (i5 != 6) {
                throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
            }
        }
        return false;
    }

    private String convertCellValueToString() {
        CellType cellType = getCellType();
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType;
        switch (iArr[cellType.ordinal()]) {
            case 1:
                return "";
            case 2:
                return TRUE_AS_STRING.equals(this._cell.getV()) ? TRUE : FALSE;
            case 3:
                CellType baseCellType = getBaseCellType(false);
                String v6 = this._cell.getV();
                int i5 = iArr[baseCellType.ordinal()];
                if (i5 == 2) {
                    if (TRUE_AS_STRING.equals(v6)) {
                        return TRUE;
                    }
                    if (FALSE_AS_STRING.equals(v6)) {
                        return FALSE;
                    }
                    throw new IllegalStateException(AbstractC0157z.o("Unexpected boolean cached formula value '", v6, "'."));
                }
                if (i5 == 4 || i5 == 5 || i5 == 6) {
                    return v6;
                }
                throw new IllegalStateException("Unexpected formula result type (" + baseCellType + ")");
            case 4:
            case 6:
                return this._cell.getV();
            case 5:
                try {
                    return this._sharedStringSource.getItemAt(Integer.parseInt(this._cell.getV())).getString();
                } catch (Throwable unused) {
                    return "";
                }
            default:
                throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
        }
    }

    private String convertSharedFormula(int i5, BaseXSSFEvaluationWorkbook baseXSSFEvaluationWorkbook) {
        XSSFSheet sheet = getSheet();
        CTCellFormula sharedFormula = sheet.getSharedFormula(i5);
        if (sharedFormula == null) {
            throw new IllegalStateException(androidx.collection.a.i(i5, "Master cell of a shared formula with sid=", " was not found"));
        }
        String stringValue = sharedFormula.getStringValue();
        CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(sharedFormula.getRef());
        return FormulaRenderer.toFormulaString(baseXSSFEvaluationWorkbook, new SharedFormula(SpreadsheetVersion.EXCEL2007).convertSharedFormulas(FormulaParser.parse(stringValue, baseXSSFEvaluationWorkbook, FormulaType.CELL, sheet.getWorkbook().getSheetIndex(sheet), getRowIndex()), getRowIndex() - cellRangeAddressValueOf.getFirstRow(), getColumnIndex() - cellRangeAddressValueOf.getFirstColumn()));
    }

    private CellType getBaseCellType(boolean z6) {
        switch (this._cell.getT().intValue()) {
            case 1:
                return CellType.BOOLEAN;
            case 2:
                return (this._cell.isSetV() || !z6) ? CellType.NUMERIC : CellType.BLANK;
            case 3:
                return CellType.ERROR;
            case 4:
            case 5:
            case 6:
                return CellType.STRING;
            default:
                throw new IllegalStateException("Illegal cell type: " + this._cell.getT());
        }
    }

    private XSSFCellStyle getDefaultCellStyleFromColumn() {
        XSSFSheet sheet = getSheet();
        if (sheet != null) {
            return (XSSFCellStyle) sheet.getColumnStyle(getColumnIndex());
        }
        return null;
    }

    private XSSFCellStyle getExplicitCellStyle() {
        if (this._stylesSource.getNumCellStyles() <= 0 || !this._cell.isSetS()) {
            return null;
        }
        return this._stylesSource.getStyleAt(Math.toIntExact(this._cell.getS()));
    }

    private boolean isFormulaCell() {
        return (this._cell.isSetF() && this._cell.getF().getT() != STCellFormulaType.DATA_TABLE) || getSheet().isCellInArrayFormulaContext(this);
    }

    private void setBlankPrivate() {
        CTCell cTCellNewInstance = CTCell.Factory.newInstance();
        cTCellNewInstance.setR(this._cell.getR());
        if (this._cell.isSetS()) {
            cTCellNewInstance.setS(this._cell.getS());
        }
        this._cell.set(cTCellNewInstance);
    }

    private void setFormula(String str, FormulaType formulaType) {
        XSSFWorkbook workbook = this._row.getSheet().getWorkbook();
        if (formulaType == FormulaType.ARRAY && str == null) {
            removeFormulaImpl();
            return;
        }
        if (workbook.getCellFormulaValidation()) {
            XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create(workbook);
            Ptg[] ptgArr = FormulaParser.parse(str, xSSFEvaluationWorkbookCreate, formulaType, workbook.getSheetIndex(getSheet()), getRowIndex());
            int length = ptgArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    str = FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr);
                    break;
                } else if (ptgArr[i5] instanceof ErrPtg) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        if (!this._cell.isSetF()) {
            CTCellFormula cTCellFormulaNewInstance = CTCellFormula.Factory.newInstance();
            cTCellFormulaNewInstance.setStringValue(str);
            this._cell.setF(cTCellFormulaNewInstance);
        } else {
            CTCellFormula f6 = this._cell.getF();
            f6.setStringValue(str);
            if (f6.getT() == STCellFormulaType.SHARED) {
                getRow().getSheet().onReadCell(this);
            }
        }
    }

    private static RuntimeException typeMismatch(CellType cellType, CellType cellType2, boolean z6) {
        StringBuilder sb = new StringBuilder("Cannot get a ");
        sb.append(cellType);
        sb.append(" value from a ");
        sb.append(cellType2);
        sb.append(" ");
        return new IllegalStateException(AbstractC0157z.s(sb, z6 ? "formula " : "", "cell"));
    }

    public void applyDefaultCellStyleIfNecessary() {
        XSSFCellStyle defaultCellStyleFromColumn;
        if (getExplicitCellStyle() != null || getSheet() == null || (defaultCellStyleFromColumn = getDefaultCellStyleFromColumn()) == null) {
            return;
        }
        setCellStyle(defaultCellStyleFromColumn);
    }

    public void copyCellFrom(Cell cell, CellCopyPolicy cellCopyPolicy) {
        CellUtil.copyCell(cell, this, cellCopyPolicy, null);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellRangeAddress getArrayFormulaRange() {
        XSSFCell firstCellInArrayFormula = getSheet().getFirstCellInArrayFormula(this);
        if (firstCellInArrayFormula != null) {
            return CellRangeAddress.valueOf(firstCellInArrayFormula._cell.getF().getRef());
        }
        throw new IllegalStateException("Cell " + new CellReference(this).formatAsString() + " is not part of an array formula.");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        CellType cellType = getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return this._cell.isSetV() && TRUE_AS_STRING.equals(this._cell.getV());
                }
                throw typeMismatch(CellType.BOOLEAN, cellType, false);
            }
            if (this._cell.isSetV() && TRUE_AS_STRING.equals(this._cell.getV())) {
                return true;
            }
        }
        return false;
    }

    @Internal
    public CTCell getCTCell() {
        return this._cell;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultType() {
        if (isFormulaCell()) {
            return getBaseCellType(false);
        }
        throw new IllegalStateException("Only formula cells have cached results");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        return getCellFormula(null);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellType() {
        return isFormulaCell() ? CellType.FORMULA : getBaseCellType(true);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._cellNum;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellType() == CellType.BLANK) {
            return null;
        }
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    public String getErrorCellString() {
        CellType baseCellType = getBaseCellType(true);
        CellType cellType = CellType.ERROR;
        if (baseCellType == cellType) {
            return this._cell.getV();
        }
        throw typeMismatch(cellType, baseCellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        String errorCellString = getErrorCellString();
        if (errorCellString == null) {
            return (byte) 0;
        }
        try {
            return FormulaError.forString(errorCellString).getCode();
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Unexpected error code", e);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public LocalDateTime getLocalDateTimeCellValue() {
        if (getCellType() == CellType.BLANK) {
            return null;
        }
        return DateUtil.getLocalDateTime(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public double getNumericCellValue() {
        CellType cachedFormulaResultType = isFormulaCell() ? getCachedFormulaResultType() : getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cachedFormulaResultType.ordinal()];
        if (i5 == 1) {
            return 0.0d;
        }
        if (i5 == 3) {
            throw new AssertionError();
        }
        if (i5 != 4) {
            throw typeMismatch(CellType.NUMERIC, cachedFormulaResultType, false);
        }
        if (!this._cell.isSetV()) {
            return 0.0d;
        }
        String v6 = this._cell.getV();
        if (v6.isEmpty()) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(v6);
        } catch (NumberFormatException unused) {
            throw typeMismatch(CellType.NUMERIC, CellType.STRING, false);
        }
    }

    public String getRawValue() {
        return this._cell.getV();
    }

    public String getReference() {
        String r6 = this._cell.getR();
        return r6 == null ? getAddress().formatAsString() : r6;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    public SharedStringsTable getSharedStringSource() {
        return this._sharedStringSource;
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        return getRichStringCellValue().getString();
    }

    public StylesTable getStylesSource() {
        return this._stylesSource;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean isPartOfArrayFormulaGroup() {
        return getSheet().isCellInArrayFormulaContext(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        if (getCellComment() != null) {
            CellAddress cellAddress = new CellAddress(getReference());
            XSSFSheet sheet = getSheet();
            sheet.getCommentsTable(false).removeComment(cellAddress);
            sheet.getVMLDrawing(false).removeCommentShape(getRowIndex(), getColumnIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void removeFormulaImpl() {
        this._row.getSheet().getWorkbook().onDeleteFormula(this);
        if (this._cell.isSetF()) {
            this._row.getSheet().onDeleteFormula(this, null);
            this._cell.unsetF();
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        getSheet().removeHyperlink(this._row.getRowNum(), this._cellNum);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        getSheet().setActiveCell(getAddress());
    }

    @Internal
    public void setCTCell(CTCell cTCell) {
        this._cell = cTCell;
    }

    public void setCellArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        setFormula(str, FormulaType.ARRAY);
        CTCellFormula f6 = this._cell.getF();
        f6.setT(STCellFormulaType.ARRAY);
        f6.setRef(cellRangeAddress.formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        if (comment == null) {
            removeCellComment();
        } else {
            comment.setAddress(getRowIndex(), getColumnIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        setCellErrorValue(FormulaError.forInt(b));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellFormulaImpl(String str) {
        setFormula(str, FormulaType.CELL);
    }

    public void setCellNum(int i5) {
        checkBounds(i5);
        this._cellNum = i5;
        this._cell.setR(new CellReference(getRowIndex(), getColumnIndex()).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        if (cellStyle == null) {
            if (this._cell.isSetS()) {
                this._cell.unsetS();
            }
        } else {
            XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
            xSSFCellStyle.verifyBelongsToStylesSource(this._stylesSource);
            this._cell.setS(this._stylesSource.putStyle(xSSFCellStyle));
        }
    }

    public void setCellType(CellType cellType, BaseXSSFEvaluationWorkbook baseXSSFEvaluationWorkbook) {
        CellType cellType2 = getCellType();
        CellType cellType3 = CellType.FORMULA;
        if (cellType2 == cellType3 && cellType != cellType3) {
            if (this._cell.isSetF()) {
                this._row.getSheet().onDeleteFormula(this, baseXSSFEvaluationWorkbook);
            }
            getSheet().getWorkbook().onDeleteFormula(this);
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        String str = FALSE_AS_STRING;
        switch (i5) {
            case 1:
                setBlankPrivate();
                break;
            case 2:
                if (convertCellValueToBoolean()) {
                    str = TRUE_AS_STRING;
                }
                this._cell.setT(STCellType.f7728B);
                this._cell.setV(str);
                break;
            case 3:
                if (!this._cell.isSetF()) {
                    CTCellFormula cTCellFormulaNewInstance = CTCellFormula.Factory.newInstance();
                    cTCellFormulaNewInstance.setStringValue(FALSE_AS_STRING);
                    this._cell.setF(cTCellFormulaNewInstance);
                    if (this._cell.isSetT()) {
                        this._cell.unsetT();
                    }
                }
                break;
            case 4:
                this._cell.setT(STCellType.f7730N);
                break;
            case 5:
                if (cellType2 != CellType.STRING) {
                    XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(convertCellValueToString());
                    xSSFRichTextString.setStylesTableReference(this._stylesSource);
                    this._cell.setV(Integer.toString(this._sharedStringSource.addSharedStringItem(xSSFRichTextString)));
                }
                this._cell.setT(STCellType.f7731S);
                break;
            case 6:
                this._cell.setT(STCellType.f7729E);
                break;
            default:
                throw new IllegalArgumentException("Illegal cell type: " + cellType);
        }
        if (cellType == cellType3 || !this._cell.isSetF()) {
            return;
        }
        this._cell.unsetF();
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellTypeImpl(CellType cellType) {
        setCellType(cellType, null);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z6) {
        this._cell.setT(STCellType.f7728B);
        this._cell.setV(z6 ? TRUE_AS_STRING : FALSE_AS_STRING);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(double d) {
        this._cell.setT(STCellType.f7730N);
        this._cell.setV(String.valueOf(d));
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        XSSFHyperlink xSSFHyperlink = hyperlink instanceof XSSFHyperlink ? (XSSFHyperlink) hyperlink : new XSSFHyperlink(hyperlink);
        xSSFHyperlink.setCellReference(new CellReference(this._row.getRowNum(), this._cellNum).formatAsString());
        getSheet().addHyperlink(xSSFHyperlink);
    }

    public String toString() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()]) {
            case 1:
                return "";
            case 2:
                return getBooleanCellValue() ? TRUE : FALSE;
            case 3:
                return getCellFormula();
            case 4:
                if (!DateUtil.isCellDateFormatted(this)) {
                    return Double.toString(getNumericCellValue());
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
                return simpleDateFormat.format(getDateCellValue());
            case 5:
                return getRichStringCellValue().toString();
            case 6:
                return ErrorEval.getText(getErrorCellValue());
            default:
                return "Unknown Cell Type: " + getCellType();
        }
    }

    public void updateCellReferencesForShifting(String str) {
        if (isPartOfArrayFormulaGroup()) {
            tryToDeleteArrayFormula(str);
        }
        CalculationChain calculationChain = getSheet().getWorkbook().getCalculationChain();
        int intExact = Math.toIntExact(getSheet().sheet.getSheetId());
        if (calculationChain != null) {
            calculationChain.removeItem(intExact, getReference());
        }
        getCTCell().setR(new CellReference(getRowIndex(), getColumnIndex()).formatAsString());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFComment getCellComment() {
        return getSheet().getCellComment(new CellAddress(this));
    }

    public String getCellFormula(BaseXSSFEvaluationWorkbook baseXSSFEvaluationWorkbook) {
        CellType cellType = getCellType();
        CellType cellType2 = CellType.FORMULA;
        if (cellType != cellType2) {
            throw typeMismatch(cellType2, cellType, false);
        }
        CTCellFormula f6 = this._cell.getF();
        if (isPartOfArrayFormulaGroup() && (f6 == null || f6.getStringValue().isEmpty())) {
            return getSheet().getFirstCellInArrayFormula(this).getCellFormula(baseXSSFEvaluationWorkbook);
        }
        if (f6 == null) {
            return null;
        }
        if (f6.getT() != STCellFormulaType.SHARED) {
            return f6.getStringValue();
        }
        int intExact = Math.toIntExact(f6.getSi());
        if (baseXSSFEvaluationWorkbook == null) {
            baseXSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create(getSheet().getWorkbook());
        }
        return convertSharedFormula(intExact, baseXSSFEvaluationWorkbook);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFCellStyle getCellStyle() {
        XSSFCellStyle explicitCellStyle = getExplicitCellStyle();
        return explicitCellStyle == null ? getDefaultCellStyleFromColumn() : explicitCellStyle;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFHyperlink getHyperlink() {
        return getSheet().getHyperlink(this._row.getRowNum(), this._cellNum);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRichTextString getRichStringCellValue() {
        XSSFRichTextString xSSFRichTextString;
        CellType cellType = getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            xSSFRichTextString = new XSSFRichTextString("");
        } else if (i5 == 3) {
            CellType baseCellType = getBaseCellType(false);
            CellType cellType2 = CellType.STRING;
            if (baseCellType != cellType2) {
                throw typeMismatch(cellType2, baseCellType, true);
            }
            xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : "");
        } else {
            if (i5 != 5) {
                throw typeMismatch(CellType.STRING, cellType, false);
            }
            STCellType.Enum t6 = this._cell.getT();
            if (t6 == STCellType.INLINE_STR) {
                if (this._cell.isSetIs()) {
                    xSSFRichTextString = new XSSFRichTextString(this._cell.getIs());
                } else {
                    xSSFRichTextString = this._cell.isSetV() ? new XSSFRichTextString(this._cell.getV()) : new XSSFRichTextString("");
                }
            } else if (t6 == STCellType.STR) {
                xSSFRichTextString = new XSSFRichTextString(this._cell.isSetV() ? this._cell.getV() : "");
            } else if (this._cell.isSetV()) {
                try {
                    xSSFRichTextString = (XSSFRichTextString) this._sharedStringSource.getItemAt(Integer.parseInt(this._cell.getV()));
                } catch (Throwable unused) {
                    xSSFRichTextString = new XSSFRichTextString("");
                }
            } else {
                xSSFRichTextString = new XSSFRichTextString("");
            }
        }
        xSSFRichTextString.setStylesTableReference(this._stylesSource);
        return xSSFRichTextString;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFRow getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public XSSFSheet getSheet() {
        return getRow().getSheet();
    }

    public void setCellErrorValue(FormulaError formulaError) {
        this._cell.setT(STCellType.f7729E);
        this._cell.setV(formulaError.getString());
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(String str) {
        setCellValueImpl(new XSSFRichTextString(str));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(RichTextString richTextString) {
        if (getCellType() == CellType.FORMULA) {
            this._cell.setV(richTextString.getString());
            this._cell.setT(STCellType.STR);
            return;
        }
        if (this._cell.getT() == STCellType.INLINE_STR) {
            this._cell.setV(richTextString.getString());
            return;
        }
        if (richTextString instanceof XSSFRichTextString) {
            this._cell.setT(STCellType.f7731S);
            XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
            xSSFRichTextString.setStylesTableReference(this._stylesSource);
            this._cell.setV(Integer.toString(this._sharedStringSource.addSharedStringItem(xSSFRichTextString)));
            return;
        }
        this._cell.setT(STCellType.f7731S);
        XSSFRichTextString xSSFRichTextString2 = new XSSFRichTextString(richTextString.getString());
        xSSFRichTextString2.setStylesTableReference(this._stylesSource);
        this._cell.setV(Integer.toString(this._sharedStringSource.addSharedStringItem(xSSFRichTextString2)));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(Date date) {
        setCellValue(DateUtil.getExcelDate(date, getSheet().getWorkbook().isDate1904()));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(LocalDateTime localDateTime) {
        setCellValue(DateUtil.getExcelDate(localDateTime, getSheet().getWorkbook().isDate1904()));
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(Calendar calendar) {
        setCellValue(DateUtil.getExcelDate(calendar, getSheet().getWorkbook().isDate1904()));
    }
}

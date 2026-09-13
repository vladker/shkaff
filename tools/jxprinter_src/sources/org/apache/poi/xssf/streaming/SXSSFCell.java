package org.apache.poi.xssf.streaming;

import A3.AbstractC0157z;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SXSSFCell extends CellBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Property _firstProperty;
    private final SXSSFRow _row;
    private CellStyle _style;
    private Value _value = new BlankValue();

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SXSSFCell$1, reason: invalid class name */
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
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BlankValue implements Value {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.BLANK;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BooleanFormulaValue extends FormulaValue {
        boolean _preEvaluatedValue;

        public BooleanFormulaValue(String str, boolean z6) {
            super(str);
            this._preEvaluatedValue = z6;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        public CellType getFormulaType() {
            return CellType.BOOLEAN;
        }

        public boolean getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        public void setPreEvaluatedValue(boolean z6) {
            this._preEvaluatedValue = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CommentProperty extends Property {
        public CommentProperty(Object obj) {
            super(obj);
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Property
        public int getType() {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ErrorFormulaValue extends FormulaValue {
        byte _preEvaluatedValue;

        public ErrorFormulaValue(String str, byte b) {
            super(str);
            this._preEvaluatedValue = b;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        public CellType getFormulaType() {
            return CellType.ERROR;
        }

        public byte getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        public void setPreEvaluatedValue(byte b) {
            this._preEvaluatedValue = b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class FormulaValue implements Value {
        String _value;

        public FormulaValue(String str) {
            this._value = str;
        }

        public abstract CellType getFormulaType();

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.FORMULA;
        }

        public String getValue() {
            return this._value;
        }

        public void setValue(String str) {
            this._value = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class HyperlinkProperty extends Property {
        public HyperlinkProperty(Object obj) {
            super(obj);
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Property
        public int getType() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NumericFormulaValue extends FormulaValue {
        double _preEvaluatedValue;

        public NumericFormulaValue(String str, double d) {
            super(str);
            this._preEvaluatedValue = d;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        public CellType getFormulaType() {
            return CellType.NUMERIC;
        }

        public double getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        public void setPreEvaluatedValue(double d) {
            this._preEvaluatedValue = d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PlainStringValue extends StringValue {
        String _value;

        public String getValue() {
            return this._value;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        public boolean isRichText() {
            return false;
        }

        public void setValue(String str) {
            this._value = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Property {
        static final int COMMENT = 1;
        static final int HYPERLINK = 2;
        Property _next;
        Object _value;

        public Property(Object obj) {
            this._value = obj;
        }

        public abstract int getType();

        public Object getValue() {
            return this._value;
        }

        public void setValue(Object obj) {
            this._value = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RichTextStringFormulaValue extends FormulaValue {
        RichTextString _preEvaluatedValue;

        public RichTextStringFormulaValue(String str, RichTextString richTextString) {
            super(str);
            this._preEvaluatedValue = richTextString;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        public CellType getFormulaType() {
            return CellType.STRING;
        }

        public RichTextString getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        public void setPreEvaluatedValue(RichTextString richTextString) {
            this._preEvaluatedValue = richTextString;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RichTextValue extends StringValue {
        RichTextString _value;

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue, org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.STRING;
        }

        public RichTextString getValue() {
            return this._value;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.StringValue
        public boolean isRichText() {
            return true;
        }

        public void setValue(RichTextString richTextString) {
            this._value = richTextString;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StringFormulaValue extends FormulaValue {
        String _preEvaluatedValue;

        public StringFormulaValue(String str, String str2) {
            super(str);
            this._preEvaluatedValue = str2;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.FormulaValue
        public CellType getFormulaType() {
            return CellType.STRING;
        }

        public String getPreEvaluatedValue() {
            return this._preEvaluatedValue;
        }

        public void setPreEvaluatedValue(String str) {
            this._preEvaluatedValue = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class StringValue implements Value {
        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.STRING;
        }

        public abstract boolean isRichText();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Value {
        CellType getType();
    }

    public SXSSFCell(SXSSFRow sXSSFRow, CellType cellType) {
        this._row = sXSSFRow;
        setType(cellType);
    }

    private boolean convertCellValueToBoolean() {
        CellType cellType = getCellType();
        if (cellType == CellType.FORMULA) {
            cellType = getCachedFormulaResultType();
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return Boolean.parseBoolean(getStringCellValue());
                }
                if (i5 == 4) {
                    return getBooleanCellValue();
                }
                if (i5 != 5) {
                    throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
                }
            } else if (getNumericCellValue() != 0.0d) {
                return true;
            }
        }
        return false;
    }

    private String convertCellValueToString() {
        return convertCellValueToString(getCellType());
    }

    private CellStyle getDefaultCellStyleFromColumn() {
        SXSSFSheet sheet = getSheet();
        if (sheet != null) {
            return sheet.getColumnStyle(getColumnIndex());
        }
        return null;
    }

    private boolean isFormulaCell() {
        return this._value instanceof FormulaValue;
    }

    private static IllegalStateException typeMismatch(CellType cellType, CellType cellType2, boolean z6) {
        StringBuilder sb = new StringBuilder("Cannot get a ");
        sb.append(cellType);
        sb.append(" value from a ");
        sb.append(cellType2);
        sb.append(" ");
        return new IllegalStateException(AbstractC0157z.s(sb, z6 ? "formula " : "", "cell"));
    }

    public void ensurePlainStringType() {
        if (this._value.getType() != CellType.STRING || ((StringValue) this._value).isRichText()) {
            this._value = new PlainStringValue();
        }
    }

    public void ensureRichTextStringType() {
        if (this._value.getType() == CellType.FORMULA) {
            this._value = new RichTextStringFormulaValue(((FormulaValue) this._value).getValue(), new XSSFRichTextString(""));
        } else {
            if (this._value.getType() == CellType.STRING && ((StringValue) this._value).isRichText()) {
                return;
            }
            this._value = new RichTextValue();
        }
    }

    public void ensureType(CellType cellType) {
        if (this._value.getType() != cellType) {
            setType(cellType);
        }
    }

    public void ensureTypeOrFormulaType(CellType cellType) {
        if (this._value.getType() == cellType) {
            CellType cellType2 = CellType.STRING;
            if (cellType == cellType2 && ((StringValue) this._value).isRichText()) {
                setType(cellType2);
                return;
            }
            return;
        }
        if (this._value.getType() != CellType.FORMULA) {
            setType(cellType);
            return;
        }
        if (((FormulaValue) this._value).getFormulaType() == cellType) {
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 2) {
            this._value = new NumericFormulaValue(getCellFormula(), 0.0d);
            return;
        }
        if (i5 == 3) {
            this._value = new StringFormulaValue(getCellFormula(), "");
        } else if (i5 == 4) {
            this._value = new BooleanFormulaValue(getCellFormula(), false);
        } else {
            if (i5 != 5) {
                throw new AssertionError();
            }
            this._value = new ErrorFormulaValue(getCellFormula(), FormulaError._NO_ERROR.getCode());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @NotImplemented
    public CellRangeAddress getArrayFormulaRange() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public boolean getBooleanCellValue() {
        CellType cellType = getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            return false;
        }
        if (i5 == 4) {
            return ((BooleanValue) this._value).getValue();
        }
        if (i5 != 6) {
            throw typeMismatch(CellType.BOOLEAN, cellType, false);
        }
        CellType formulaType = ((FormulaValue) this._value).getFormulaType();
        CellType cellType2 = CellType.BOOLEAN;
        if (formulaType == cellType2) {
            return ((BooleanFormulaValue) this._value).getPreEvaluatedValue();
        }
        throw typeMismatch(cellType2, CellType.FORMULA, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCachedFormulaResultType() {
        if (isFormulaCell()) {
            return ((FormulaValue) this._value).getFormulaType();
        }
        throw new IllegalStateException("Only formula cells have cached results");
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Comment getCellComment() {
        return (Comment) getPropertyValue(1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getCellFormula() {
        CellType type = this._value.getType();
        CellType cellType = CellType.FORMULA;
        if (type == cellType) {
            return ((FormulaValue) this._value).getValue();
        }
        throw typeMismatch(cellType, this._value.getType(), false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellStyle getCellStyle() {
        CellStyle cellStyle = this._style;
        if (cellStyle != null) {
            return cellStyle;
        }
        CellStyle defaultCellStyleFromColumn = getDefaultCellStyleFromColumn();
        return defaultCellStyleFromColumn == null ? getSheet().getWorkbook().getCellStyleAt(0) : defaultCellStyleFromColumn;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellType getCellType() {
        return isFormulaCell() ? CellType.FORMULA : this._value.getType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getColumnIndex() {
        return this._row.getCellIndex(this);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Date getDateCellValue() {
        if (getCellType() == CellType.BLANK) {
            return null;
        }
        return DateUtil.getJavaDate(getNumericCellValue(), getSheet().getWorkbook().isDate1904());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public byte getErrorCellValue() {
        CellType cellType = getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            return (byte) 0;
        }
        if (i5 == 5) {
            return ((ErrorValue) this._value).getValue();
        }
        if (i5 != 6) {
            throw typeMismatch(CellType.ERROR, cellType, false);
        }
        CellType formulaType = ((FormulaValue) this._value).getFormulaType();
        CellType cellType2 = CellType.ERROR;
        if (formulaType == cellType2) {
            return ((ErrorFormulaValue) this._value).getPreEvaluatedValue();
        }
        throw typeMismatch(cellType2, CellType.FORMULA, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Hyperlink getHyperlink() {
        return (Hyperlink) getPropertyValue(2);
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
        CellType cellType = getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            return 0.0d;
        }
        if (i5 == 2) {
            return ((NumericValue) this._value).getValue();
        }
        if (i5 != 6) {
            throw typeMismatch(CellType.NUMERIC, cellType, false);
        }
        CellType formulaType = ((FormulaValue) this._value).getFormulaType();
        CellType cellType2 = CellType.NUMERIC;
        if (formulaType == cellType2) {
            return ((NumericFormulaValue) this._value).getPreEvaluatedValue();
        }
        throw typeMismatch(cellType2, CellType.FORMULA, false);
    }

    public Object getPropertyValue(int i5) {
        return getPropertyValue(i5, null);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public RichTextString getRichStringCellValue() {
        CellType cellType = getCellType();
        CellType cellType2 = getCellType();
        CellType cellType3 = CellType.STRING;
        if (cellType2 == cellType3) {
            return ((StringValue) this._value).isRichText() ? ((RichTextValue) this._value).getValue() : new XSSFRichTextString(getStringCellValue());
        }
        throw typeMismatch(cellType3, cellType, false);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public Row getRow() {
        return this._row;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public int getRowIndex() {
        return this._row.getRowNum();
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public String getStringCellValue() {
        CellType cellType = getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            return "";
        }
        if (i5 == 3) {
            return ((StringValue) this._value).isRichText() ? ((RichTextValue) this._value).getValue().getString() : ((PlainStringValue) this._value).getValue();
        }
        if (i5 != 6) {
            throw typeMismatch(CellType.STRING, cellType, false);
        }
        CellType formulaType = ((FormulaValue) this._value).getFormulaType();
        CellType cellType2 = CellType.STRING;
        if (formulaType != cellType2) {
            throw typeMismatch(cellType2, CellType.FORMULA, false);
        }
        Value value = this._value;
        return value instanceof RichTextStringFormulaValue ? ((RichTextStringFormulaValue) value).getPreEvaluatedValue().getString() : ((StringFormulaValue) value).getPreEvaluatedValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    @NotImplemented
    public boolean isPartOfArrayFormulaGroup() {
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeCellComment() {
        removeProperty(1);
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void removeFormulaImpl() {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCachedFormulaResultType().ordinal()];
        if (i5 == 2) {
            double preEvaluatedValue = ((NumericFormulaValue) this._value).getPreEvaluatedValue();
            NumericValue numericValue = new NumericValue();
            this._value = numericValue;
            numericValue.setValue(preEvaluatedValue);
            return;
        }
        if (i5 == 3) {
            String preEvaluatedValue2 = ((StringFormulaValue) this._value).getPreEvaluatedValue();
            PlainStringValue plainStringValue = new PlainStringValue();
            this._value = plainStringValue;
            plainStringValue.setValue(preEvaluatedValue2);
            return;
        }
        if (i5 == 4) {
            boolean preEvaluatedValue3 = ((BooleanFormulaValue) this._value).getPreEvaluatedValue();
            BooleanValue booleanValue = new BooleanValue();
            this._value = booleanValue;
            booleanValue.setValue(preEvaluatedValue3);
            return;
        }
        if (i5 != 5) {
            throw new AssertionError();
        }
        byte preEvaluatedValue4 = ((ErrorFormulaValue) this._value).getPreEvaluatedValue();
        ErrorValue errorValue = new ErrorValue();
        this._value = errorValue;
        errorValue.setValue(preEvaluatedValue4);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void removeHyperlink() {
        removeProperty(2);
        getSheet()._sh.removeHyperlink(getRowIndex(), getColumnIndex());
    }

    public void removeProperty(int i5) {
        Property property = this._firstProperty;
        Property property2 = null;
        while (property != null && property.getType() != i5) {
            property2 = property;
            property = property._next;
        }
        if (property != null) {
            if (property2 != null) {
                property2._next = property._next;
            } else {
                this._firstProperty = property._next;
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setAsActiveCell() {
        getSheet().setActiveCell(getAddress());
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellComment(Comment comment) {
        setProperty(1, comment);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellErrorValue(byte b) {
        if (this._value.getType() == CellType.FORMULA) {
            this._value = new ErrorFormulaValue(getCellFormula(), b);
        } else {
            this._value = new ErrorValue(b);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellFormulaImpl(String str) {
        if (getCellType() == CellType.FORMULA) {
            ((FormulaValue) this._value).setValue(str);
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()];
        if (i5 == 1 || i5 == 2) {
            this._value = new NumericFormulaValue(str, getNumericCellValue());
            return;
        }
        if (i5 == 3) {
            Value value = this._value;
            if (value instanceof PlainStringValue) {
                this._value = new StringFormulaValue(str, getStringCellValue());
                return;
            } else {
                this._value = new RichTextStringFormulaValue(str, ((RichTextValue) value).getValue());
                return;
            }
        }
        if (i5 == 4) {
            this._value = new BooleanFormulaValue(str, getBooleanCellValue());
        } else if (i5 == 5) {
            this._value = new ErrorFormulaValue(str, getErrorCellValue());
        } else {
            throw new IllegalStateException("Cannot set a formula for a cell of type " + getCellType());
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellStyle(CellStyle cellStyle) {
        this._style = cellStyle;
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellTypeImpl(CellType cellType) {
        ensureType(cellType);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(boolean z6) {
        ensureTypeOrFormulaType(CellType.BOOLEAN);
        if (this._value.getType() == CellType.FORMULA) {
            ((BooleanFormulaValue) this._value).setPreEvaluatedValue(z6);
        } else {
            ((BooleanValue) this._value).setValue(z6);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(double d) {
        ensureTypeOrFormulaType(CellType.NUMERIC);
        if (this._value.getType() == CellType.FORMULA) {
            ((NumericFormulaValue) this._value).setPreEvaluatedValue(d);
        } else {
            ((NumericValue) this._value).setValue(d);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setHyperlink(Hyperlink hyperlink) {
        if (hyperlink == null) {
            removeHyperlink();
            return;
        }
        setProperty(2, hyperlink);
        XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) hyperlink;
        xSSFHyperlink.setCellReference(new CellReference(getRowIndex(), getColumnIndex()));
        getSheet()._sh.addHyperlink(xSSFHyperlink);
    }

    public void setProperty(int i5, Object obj) {
        Property commentProperty;
        Property property = this._firstProperty;
        Property property2 = null;
        while (property != null && property.getType() != i5) {
            property2 = property;
            property = property._next;
        }
        if (property != null) {
            property.setValue(obj);
            return;
        }
        if (i5 == 1) {
            commentProperty = new CommentProperty(obj);
        } else {
            if (i5 != 2) {
                throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid type: "));
            }
            commentProperty = new HyperlinkProperty(obj);
        }
        if (property2 != null) {
            property2._next = commentProperty;
        } else {
            this._firstProperty = commentProperty;
        }
    }

    public void setType(CellType cellType) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()]) {
            case 1:
                this._value = new BlankValue();
                return;
            case 2:
                this._value = new NumericValue();
                return;
            case 3:
                PlainStringValue plainStringValue = new PlainStringValue();
                if (this._value != null) {
                    plainStringValue.setValue(convertCellValueToString());
                }
                this._value = plainStringValue;
                return;
            case 4:
                BooleanValue booleanValue = new BooleanValue();
                if (this._value != null) {
                    booleanValue.setValue(convertCellValueToBoolean());
                }
                this._value = booleanValue;
                return;
            case 5:
                this._value = new ErrorValue();
                return;
            case 6:
                if (getCellType() == CellType.BLANK) {
                    this._value = new NumericFormulaValue("", 0.0d);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("Illegal type " + cellType);
        }
    }

    public String toString() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[getCellType().ordinal()]) {
            case 1:
                return "";
            case 2:
                if (DateUtil.isCellDateFormatted(this)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", LocaleUtil.getUserLocale());
                    simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
                    return simpleDateFormat.format(getDateCellValue());
                }
                return getNumericCellValue() + "";
            case 3:
                return getRichStringCellValue().toString();
            case 4:
                return getBooleanCellValue() ? "TRUE" : "FALSE";
            case 5:
                return ErrorEval.getText(getErrorCellValue());
            case 6:
                return getCellFormula();
            default:
                return "Unknown Cell Type: " + getCellType();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BooleanValue implements Value {
        boolean _value;

        public BooleanValue() {
            this._value = false;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.BOOLEAN;
        }

        public boolean getValue() {
            return this._value;
        }

        public void setValue(boolean z6) {
            this._value = z6;
        }

        public BooleanValue(boolean z6) {
            this._value = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ErrorValue implements Value {
        byte _value;

        public ErrorValue() {
            this._value = FormulaError._NO_ERROR.getCode();
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.ERROR;
        }

        public byte getValue() {
            return this._value;
        }

        public void setValue(byte b) {
            this._value = b;
        }

        public ErrorValue(byte b) {
            this._value = b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NumericValue implements Value {
        double _value;

        public NumericValue() {
            this._value = 0.0d;
        }

        @Override // org.apache.poi.xssf.streaming.SXSSFCell.Value
        public CellType getType() {
            return CellType.NUMERIC;
        }

        public double getValue() {
            return this._value;
        }

        public void setValue(double d) {
            this._value = d;
        }

        public NumericValue(double d) {
            this._value = d;
        }
    }

    public Object getPropertyValue(int i5, String str) {
        Property property = this._firstProperty;
        while (property != null && property.getType() != i5) {
            property = property._next;
        }
        return property == null ? str : property.getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public SXSSFSheet getSheet() {
        return this._row.getSheet();
    }

    private String convertCellValueToString(CellType cellType) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()]) {
            case 1:
                return "";
            case 2:
                return Double.toString(getNumericCellValue());
            case 3:
                return getStringCellValue();
            case 4:
                return getBooleanCellValue() ? "TRUE" : "FALSE";
            case 5:
                return FormulaError.forInt(getErrorCellValue()).getString();
            case 6:
                Value value = this._value;
                if (value != null) {
                    FormulaValue formulaValue = (FormulaValue) value;
                    if (formulaValue.getFormulaType() != CellType.FORMULA) {
                        return convertCellValueToString(formulaValue.getFormulaType());
                    }
                }
                return "";
            default:
                throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
        }
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

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(RichTextString richTextString) {
        ensureRichTextStringType();
        Value value = this._value;
        if (value instanceof RichTextStringFormulaValue) {
            ((RichTextStringFormulaValue) value).setPreEvaluatedValue(richTextString);
        } else {
            ((RichTextValue) value).setValue(richTextString);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellBase
    public void setCellValueImpl(String str) {
        ensureTypeOrFormulaType(CellType.STRING);
        if (this._value.getType() == CellType.FORMULA) {
            ((StringFormulaValue) this._value).setPreEvaluatedValue(str);
        } else {
            ((PlainStringValue) this._value).setValue(str);
        }
    }
}

package org.apache.poi.hssf.usermodel;

import java.util.List;
import java.util.Objects;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFCellStyle implements CellStyle, Duplicatable {
    private final ExtendedFormatRecord _format;
    private final short _index;
    private final InternalWorkbook _workbook;
    private static final ThreadLocal<Short> lastDateFormat = ThreadLocal.withInitial(new androidx.emoji2.text.flatbuffer.a(22));
    private static final ThreadLocal<List<FormatRecord>> lastFormats = new ThreadLocal<>();
    private static final ThreadLocal<String> getDataFormatStringCache = new ThreadLocal<>();

    public HSSFCellStyle(short s6, ExtendedFormatRecord extendedFormatRecord, HSSFWorkbook hSSFWorkbook) {
        this(s6, extendedFormatRecord, hSSFWorkbook.getWorkbook());
    }

    private void checkDefaultBackgroundFills() {
        short index = HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex();
        if (this._format.getFillForeground() == index) {
            int i5 = index + 1;
            if (this._format.getFillBackground() != i5) {
                setFillBackgroundColor((short) i5);
                return;
            }
            return;
        }
        if (this._format.getFillBackground() != index + 1 || this._format.getFillForeground() == index) {
            return;
        }
        setFillBackgroundColor(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Short lambda$static$0() {
        return Short.MIN_VALUE;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void cloneStyleFrom(CellStyle cellStyle) {
        if (!(cellStyle instanceof HSSFCellStyle)) {
            throw new IllegalArgumentException("Can only clone from one HSSFCellStyle to another, not between HSSFCellStyle and XSSFCellStyle");
        }
        cloneStyleFrom((HSSFCellStyle) cellStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HSSFCellStyle)) {
            return false;
        }
        HSSFCellStyle hSSFCellStyle = (HSSFCellStyle) obj;
        ExtendedFormatRecord extendedFormatRecord = this._format;
        if (extendedFormatRecord == null) {
            if (hSSFCellStyle._format != null) {
                return false;
            }
        } else if (!extendedFormatRecord.equals(hSSFCellStyle._format)) {
            return false;
        }
        return this._index == hSSFCellStyle._index;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HorizontalAlignment getAlignment() {
        return HorizontalAlignment.forInt(this._format.getAlignment());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderBottom() {
        return BorderStyle.valueOf(this._format.getBorderBottom());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderLeft() {
        return BorderStyle.valueOf(this._format.getBorderLeft());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderRight() {
        return BorderStyle.valueOf(this._format.getBorderRight());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderTop() {
        return BorderStyle.valueOf(this._format.getBorderTop());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBottomBorderColor() {
        return this._format.getBottomBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getDataFormat() {
        return this._format.getFormatIndex();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public String getDataFormatString() {
        ThreadLocal<String> threadLocal = getDataFormatStringCache;
        if (threadLocal.get() != null && lastDateFormat.get().shortValue() == getDataFormat() && this._workbook.getFormats().equals(lastFormats.get())) {
            return threadLocal.get();
        }
        lastFormats.set(this._workbook.getFormats());
        lastDateFormat.set(Short.valueOf(getDataFormat()));
        threadLocal.set(getDataFormatString(this._workbook));
        return threadLocal.get();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillBackgroundColor() {
        short index = HSSFColor.HSSFColorPredefined.AUTOMATIC.getIndex();
        short fillBackground = this._format.getFillBackground();
        return fillBackground == index + 1 ? index : fillBackground;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillForegroundColor() {
        return this._format.getFillForeground();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public FillPatternType getFillPattern() {
        return FillPatternType.forInt(this._format.getAdtlFillPattern());
    }

    public HSSFFont getFont(Workbook workbook) {
        return ((HSSFWorkbook) workbook).getFontAt(getFontIndex());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public int getFontIndex() {
        return this._format.getFontIndex();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Removal(version = "6.0.0")
    @Deprecated
    public int getFontIndexAsInt() {
        return this._format.getFontIndex();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getHidden() {
        return this._format.isHidden();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndention() {
        return this._format.getIndent();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndex() {
        return this._index;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getLeftBorderColor() {
        return this._format.getLeftBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getLocked() {
        return this._format.isLocked();
    }

    public HSSFCellStyle getParentStyle() {
        short parentIndex = this._format.getParentIndex();
        if (parentIndex == 0 || parentIndex == 4095) {
            return null;
        }
        return new HSSFCellStyle(parentIndex, this._workbook.getExFormatAt(parentIndex), this._workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getQuotePrefixed() {
        return this._format.get123Prefix();
    }

    public short getReadingOrder() {
        return this._format.getReadingOrder();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRightBorderColor() {
        return this._format.getRightBorderPaletteIdx();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRotation() {
        short rotation = this._format.getRotation();
        return (rotation != 255 && rotation > 90) ? (short) (90 - rotation) : rotation;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getShrinkToFit() {
        return this._format.getShrinkToFit();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getTopBorderColor() {
        return this._format.getTopBorderPaletteIdx();
    }

    public String getUserStyleName() {
        StyleRecord styleRecord = this._workbook.getStyleRecord(this._index);
        if (styleRecord == null || styleRecord.isBuiltin()) {
            return null;
        }
        return styleRecord.getName();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public VerticalAlignment getVerticalAlignment() {
        return VerticalAlignment.forInt(this._format.getVerticalAlignment());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getWrapText() {
        return this._format.getWrapText();
    }

    public int hashCode() {
        return Objects.hash(this._format, Short.valueOf(this._index));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setAlignment(HorizontalAlignment horizontalAlignment) {
        this._format.setIndentNotParentAlignment(true);
        this._format.setAlignment(horizontalAlignment.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderBottom(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderBottom(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderLeft(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderLeft(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderRight(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderRight(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderTop(BorderStyle borderStyle) {
        this._format.setIndentNotParentBorder(true);
        this._format.setBorderTop(borderStyle.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBottomBorderColor(short s6) {
        this._format.setBottomBorderPaletteIdx(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setDataFormat(short s6) {
        this._format.setFormatIndex(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillBackgroundColor(short s6) {
        this._format.setFillBackground(s6);
        checkDefaultBackgroundFills();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillForegroundColor(short s6) {
        this._format.setFillForeground(s6);
        checkDefaultBackgroundFills();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillPattern(FillPatternType fillPatternType) {
        this._format.setAdtlFillPattern(fillPatternType.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFont(Font font) {
        setFont((HSSFFont) font);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setHidden(boolean z6) {
        this._format.setIndentNotParentCellOptions(true);
        this._format.setHidden(z6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setIndention(short s6) {
        this._format.setIndent(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLeftBorderColor(short s6) {
        this._format.setLeftBorderPaletteIdx(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLocked(boolean z6) {
        this._format.setIndentNotParentCellOptions(true);
        this._format.setLocked(z6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setQuotePrefixed(boolean z6) {
        this._format.set123Prefix(z6);
    }

    public void setReadingOrder(short s6) {
        this._format.setReadingOrder(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRightBorderColor(short s6) {
        this._format.setRightBorderPaletteIdx(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRotation(short s6) {
        if (s6 != 255) {
            if (s6 < 0 && s6 >= -90) {
                s6 = (short) (90 - s6);
            } else if ((s6 <= 90 || s6 > 180) && (s6 < -90 || s6 > 90)) {
                throw new IllegalArgumentException("The rotation must be between -90 and 90 degrees, or 0xff");
            }
        }
        this._format.setRotation(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setShrinkToFit(boolean z6) {
        this._format.setShrinkToFit(z6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setTopBorderColor(short s6) {
        this._format.setTopBorderPaletteIdx(s6);
    }

    public void setUserStyleName(String str) {
        StyleRecord styleRecord = this._workbook.getStyleRecord(this._index);
        if (styleRecord == null) {
            styleRecord = this._workbook.createStyleRecord(this._index);
        }
        if (styleRecord.isBuiltin() && this._index <= 20) {
            throw new IllegalArgumentException("Unable to set user specified style names for built in styles!");
        }
        styleRecord.setName(str);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        this._format.setVerticalAlignment(verticalAlignment.getCode());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setWrapText(boolean z6) {
        this._format.setIndentNotParentAlignment(true);
        this._format.setWrapText(z6);
    }

    public void verifyBelongsToWorkbook(HSSFWorkbook hSSFWorkbook) {
        if (hSSFWorkbook.getWorkbook() != this._workbook) {
            throw new IllegalArgumentException("This Style does not belong to the supplied Workbook. Are you trying to assign a style from one workbook to the cell of a differnt workbook?");
        }
    }

    public HSSFCellStyle(short s6, ExtendedFormatRecord extendedFormatRecord, InternalWorkbook internalWorkbook) {
        this._workbook = internalWorkbook;
        this._index = s6;
        this._format = extendedFormatRecord;
    }

    @Override // org.apache.poi.common.Duplicatable
    public HSSFCellStyle copy() {
        return new HSSFCellStyle(this);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HSSFColor getFillBackgroundColorColor() {
        return new HSSFPalette(this._workbook.getCustomPalette()).getColor(getFillBackgroundColor());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HSSFColor getFillForegroundColorColor() {
        return new HSSFPalette(this._workbook.getCustomPalette()).getColor(getFillForegroundColor());
    }

    public void setFont(HSSFFont hSSFFont) {
        this._format.setIndentNotParentFont(true);
        this._format.setFontIndex((short) hSSFFont.getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillBackgroundColor(Color color) {
        if (!(color instanceof HSSFColor)) {
            if (color != null) {
                throw new IllegalArgumentException("HSSFCellStyle only accepts HSSFColor instances");
            }
        } else {
            short index2 = ((HSSFColor) color).getIndex2();
            if (index2 != -1) {
                setFillBackgroundColor(index2);
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillForegroundColor(Color color) {
        if (!(color instanceof HSSFColor)) {
            if (color != null) {
                throw new IllegalArgumentException("HSSFCellStyle only accepts HSSFColor instances");
            }
        } else {
            short index2 = ((HSSFColor) color).getIndex2();
            if (index2 != -1) {
                setFillForegroundColor(index2);
            }
        }
    }

    public void cloneStyleFrom(HSSFCellStyle hSSFCellStyle) {
        this._format.cloneStyleFrom(hSSFCellStyle._format);
        if (this._workbook != hSSFCellStyle._workbook) {
            lastDateFormat.set(Short.MIN_VALUE);
            lastFormats.remove();
            getDataFormatStringCache.remove();
            setDataFormat((short) this._workbook.createFormat(hSSFCellStyle.getDataFormatString()));
            FontRecord fontRecordCreateNewFont = this._workbook.createNewFont();
            fontRecordCreateNewFont.cloneStyleFrom(hSSFCellStyle._workbook.getFontRecordAt(hSSFCellStyle.getFontIndex()));
            setFont(new HSSFFont((short) this._workbook.getFontIndex(fontRecordCreateNewFont), fontRecordCreateNewFont));
        }
    }

    public HSSFCellStyle(HSSFCellStyle hSSFCellStyle) {
        this._workbook = hSSFCellStyle._workbook;
        this._index = hSSFCellStyle._index;
        this._format = hSSFCellStyle._format;
    }

    public String getDataFormatString(Workbook workbook) {
        return getDataFormat() == -1 ? "General" : new HSSFDataFormat(((HSSFWorkbook) workbook).getWorkbook()).getFormat(getDataFormat());
    }

    public String getDataFormatString(InternalWorkbook internalWorkbook) {
        return new HSSFDataFormat(internalWorkbook).getFormat(getDataFormat());
    }
}

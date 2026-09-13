package org.apache.poi.xssf.usermodel;

import org.apache.poi.common.Duplicatable;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.ReadingOrder;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellAlignment;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFCellStyle implements CellStyle, Duplicatable {
    private XSSFCellAlignment _cellAlignment;
    private final CTXf _cellStyleXf;
    private CTXf _cellXf;
    private int _cellXfId;
    private XSSFFont _font;
    private final StylesTable _stylesSource;
    private ThemesTable _theme;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFCellStyle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide;

        static {
            int[] iArr = new int[XSSFCellBorder.BorderSide.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide = iArr;
            try {
                iArr[XSSFCellBorder.BorderSide.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[XSSFCellBorder.BorderSide.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[XSSFCellBorder.BorderSide.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[XSSFCellBorder.BorderSide.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public XSSFCellStyle(int i5, int i6, StylesTable stylesTable, ThemesTable themesTable) {
        this._cellXfId = i5;
        this._stylesSource = stylesTable;
        this._cellXf = stylesTable.getCellXfAt(i5);
        this._cellStyleXf = i6 == -1 ? null : stylesTable.getCellStyleXfAt(i6);
        this._theme = themesTable;
    }

    private void addBorder(CTBorder cTBorder) {
        StylesTable stylesTable = this._stylesSource;
        this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    private void addFill(CTFill cTFill) {
        StylesTable stylesTable = this._stylesSource;
        this._cellXf.setFillId(stylesTable.putFill(new XSSFCellFill(cTFill, stylesTable.getIndexedColors())));
        this._cellXf.setApplyFill(true);
    }

    private CTBorder getCTBorder() {
        if (!this._cellXf.getApplyBorder()) {
            return CTBorder.Factory.newInstance();
        }
        return (CTBorder) this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getCTBorder().copy();
    }

    private CTCellAlignment getCTCellAlignment() {
        if (this._cellXf.getAlignment() == null) {
            this._cellXf.setAlignment(CTCellAlignment.Factory.newInstance());
        }
        return this._cellXf.getAlignment();
    }

    private CTFill getCTFill() {
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return CTFill.Factory.newInstance();
        }
        return (CTFill) this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getCTFill().copy();
    }

    private int getFontId() {
        return (int) (this._cellXf.isSetFontId() ? this._cellXf.getFontId() : this._cellStyleXf.getFontId());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void cloneStyleFrom(CellStyle cellStyle) {
        if (!(cellStyle instanceof XSSFCellStyle)) {
            throw new IllegalArgumentException("Can only clone from one XSSFCellStyle to another, not between HSSFCellStyle and XSSFCellStyle");
        }
        XSSFCellStyle xSSFCellStyle = (XSSFCellStyle) cellStyle;
        if (xSSFCellStyle._stylesSource == this._stylesSource) {
            this._cellXf.set(xSSFCellStyle.getCoreXf());
            this._cellStyleXf.set(xSSFCellStyle.getStyleXf());
        } else {
            try {
                if (this._cellXf.isSetAlignment()) {
                    this._cellXf.unsetAlignment();
                }
                if (this._cellXf.isSetExtLst()) {
                    this._cellXf.unsetExtLst();
                }
                DocumentFactory<CTXf> documentFactory = CTXf.Factory;
                String string = xSSFCellStyle.getCoreXf().toString();
                XmlOptions xmlOptions = POIXMLTypeLoader.DEFAULT_XML_OPTIONS;
                this._cellXf = documentFactory.parse(string, xmlOptions);
                addFill(CTFill.Factory.parse(xSSFCellStyle.getCTFill().toString(), xmlOptions));
                addBorder(CTBorder.Factory.parse(xSSFCellStyle.getCTBorder().toString(), xmlOptions));
                this._stylesSource.replaceCellXfAt(this._cellXfId, this._cellXf);
                setDataFormat(new XSSFDataFormat(this._stylesSource).getFormat(xSSFCellStyle.getDataFormatString()));
                try {
                    XSSFFont xSSFFont = new XSSFFont(CTFont.Factory.parse(xSSFCellStyle.getFont().getCTFont().toString(), xmlOptions));
                    xSSFFont.registerTo(this._stylesSource);
                    setFont(xSSFFont);
                } catch (XmlException e) {
                    throw new POIXMLException(e);
                }
            } catch (XmlException e6) {
                throw new POIXMLException(e6);
            }
        }
        this._font = null;
        this._cellAlignment = null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof XSSFCellStyle) {
            return this._cellXf.toString().equals(((XSSFCellStyle) obj).getCoreXf().toString());
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public HorizontalAlignment getAlignment() {
        if (!this._cellXf.getApplyAlignment()) {
            return HorizontalAlignment.GENERAL;
        }
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return (alignment == null || !alignment.isSetHorizontal()) ? HorizontalAlignment.GENERAL : HorizontalAlignment.forInt(alignment.getHorizontal().intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderBottom() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetBottom() ? cTBorder.getBottom().getStyle() : null;
        return style == null ? BorderStyle.NONE : BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    public XSSFColor getBorderColor(XSSFCellBorder.BorderSide borderSide) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[borderSide.ordinal()];
        if (i5 == 1) {
            return getBottomBorderXSSFColor();
        }
        if (i5 == 2) {
            return getRightBorderXSSFColor();
        }
        if (i5 == 3) {
            return getTopBorderXSSFColor();
        }
        if (i5 == 4) {
            return getLeftBorderXSSFColor();
        }
        throw new IllegalArgumentException("Unknown border: " + borderSide);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderLeft() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetLeft() ? cTBorder.getLeft().getStyle() : null;
        return style == null ? BorderStyle.NONE : BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderRight() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetRight() ? cTBorder.getRight().getStyle() : null;
        return style == null ? BorderStyle.NONE : BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public BorderStyle getBorderTop() {
        if (!this._cellXf.getApplyBorder()) {
            return BorderStyle.NONE;
        }
        CTBorder cTBorder = this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getCTBorder();
        STBorderStyle.Enum style = cTBorder.isSetTop() ? cTBorder.getTop().getStyle() : null;
        return style == null ? BorderStyle.NONE : BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getBottomBorderColor() {
        XSSFColor bottomBorderXSSFColor = getBottomBorderXSSFColor();
        return bottomBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : bottomBorderXSSFColor.getIndexed();
    }

    public XSSFColor getBottomBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getBorderColor(XSSFCellBorder.BorderSide.BOTTOM);
    }

    public XSSFCellAlignment getCellAlignment() {
        if (this._cellAlignment == null) {
            this._cellAlignment = new XSSFCellAlignment(getCTCellAlignment());
        }
        return this._cellAlignment;
    }

    @Internal
    public CTXf getCoreXf() {
        return this._cellXf;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getDataFormat() {
        return (short) this._cellXf.getNumFmtId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public String getDataFormatString() {
        return new XSSFDataFormat(this._stylesSource).getFormat(getDataFormat());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillBackgroundColor() {
        XSSFColor fillBackgroundXSSFColor = getFillBackgroundXSSFColor();
        return fillBackgroundXSSFColor == null ? IndexedColors.AUTOMATIC.getIndex() : fillBackgroundXSSFColor.getIndexed();
    }

    public XSSFColor getFillBackgroundXSSFColor() {
        ThemesTable themesTable;
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return null;
        }
        XSSFColor fillBackgroundColor = this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getFillBackgroundColor();
        if (fillBackgroundColor != null && (themesTable = this._theme) != null) {
            themesTable.inheritFromThemeAsRequired(fillBackgroundColor);
        }
        return fillBackgroundColor;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getFillForegroundColor() {
        XSSFColor fillForegroundXSSFColor = getFillForegroundXSSFColor();
        return fillForegroundXSSFColor == null ? IndexedColors.AUTOMATIC.getIndex() : fillForegroundXSSFColor.getIndexed();
    }

    public XSSFColor getFillForegroundXSSFColor() {
        ThemesTable themesTable;
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return null;
        }
        XSSFColor fillForegroundColor = this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getFillForegroundColor();
        if (fillForegroundColor != null && (themesTable = this._theme) != null) {
            themesTable.inheritFromThemeAsRequired(fillForegroundColor);
        }
        return fillForegroundColor;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public FillPatternType getFillPattern() {
        if (this._cellXf.isSetApplyFill() && !this._cellXf.getApplyFill()) {
            return FillPatternType.NO_FILL;
        }
        STPatternType.Enum patternType = this._stylesSource.getFillAt((int) this._cellXf.getFillId()).getPatternType();
        return patternType == null ? FillPatternType.NO_FILL : FillPatternType.forInt(patternType.intValue() - 1);
    }

    public XSSFFont getFont() {
        if (this._font == null) {
            this._font = this._stylesSource.getFontAt(getFontId());
        }
        return this._font;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public int getFontIndex() {
        return getFontId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    @Removal(version = "6.0.0")
    @Deprecated
    public int getFontIndexAsInt() {
        return getFontId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getHidden() {
        return this._cellXf.isSetProtection() && this._cellXf.getProtection().isSetHidden() && this._cellXf.getProtection().getHidden();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndention() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return (short) (alignment == null ? 0L : alignment.getIndent());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndex() {
        return (short) this._cellXfId;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getLeftBorderColor() {
        XSSFColor leftBorderXSSFColor = getLeftBorderXSSFColor();
        return leftBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : leftBorderXSSFColor.getIndexed();
    }

    public XSSFColor getLeftBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getBorderColor(XSSFCellBorder.BorderSide.LEFT);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getLocked() {
        return (this._cellXf.isSetProtection() && this._cellXf.getProtection().isSetLocked() && !this._cellXf.getProtection().getLocked()) ? false : true;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getQuotePrefixed() {
        return this._cellXf.getQuotePrefix();
    }

    public ReadingOrder getReadingOrder() {
        return getCellAlignment().getReadingOrder();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRightBorderColor() {
        XSSFColor rightBorderXSSFColor = getRightBorderXSSFColor();
        return rightBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : rightBorderXSSFColor.getIndexed();
    }

    public XSSFColor getRightBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getBorderColor(XSSFCellBorder.BorderSide.RIGHT);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRotation() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        if (alignment == null || alignment.getTextRotation() == null) {
            return (short) 0;
        }
        return alignment.getTextRotation().shortValue();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getShrinkToFit() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return alignment != null && alignment.getShrinkToFit();
    }

    @Internal
    public CTXf getStyleXf() {
        return this._cellStyleXf;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getTopBorderColor() {
        XSSFColor topBorderXSSFColor = getTopBorderXSSFColor();
        return topBorderXSSFColor == null ? IndexedColors.BLACK.getIndex() : topBorderXSSFColor.getIndexed();
    }

    public XSSFColor getTopBorderXSSFColor() {
        if (!this._cellXf.getApplyBorder()) {
            return null;
        }
        return this._stylesSource.getBorderAt(Math.toIntExact(this._cellXf.getBorderId())).getBorderColor(XSSFCellBorder.BorderSide.TOP);
    }

    public int getUIndex() {
        return this._cellXfId;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public VerticalAlignment getVerticalAlignment() {
        if (!this._cellXf.getApplyAlignment()) {
            return VerticalAlignment.BOTTOM;
        }
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return (alignment == null || !alignment.isSetVertical()) ? VerticalAlignment.BOTTOM : VerticalAlignment.forInt(alignment.getVertical().intValue() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public boolean getWrapText() {
        CTCellAlignment alignment = this._cellXf.getAlignment();
        return alignment != null && alignment.getWrapText();
    }

    public int hashCode() {
        return this._cellXf.toString().hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setAlignment(HorizontalAlignment horizontalAlignment) {
        this._cellXf.setApplyAlignment(true);
        getCellAlignment().setHorizontal(horizontalAlignment);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderBottom(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr bottom = cTBorder.isSetBottom() ? cTBorder.getBottom() : cTBorder.addNewBottom();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetBottom();
        } else {
            bottom.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        StylesTable stylesTable = this._stylesSource;
        this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    public void setBorderColor(XSSFCellBorder.BorderSide borderSide, XSSFColor xSSFColor) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[borderSide.ordinal()];
        if (i5 == 1) {
            setBottomBorderColor(xSSFColor);
            return;
        }
        if (i5 == 2) {
            setRightBorderColor(xSSFColor);
        } else if (i5 == 3) {
            setTopBorderColor(xSSFColor);
        } else {
            if (i5 != 4) {
                return;
            }
            setLeftBorderColor(xSSFColor);
        }
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderLeft(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr left = cTBorder.isSetLeft() ? cTBorder.getLeft() : cTBorder.addNewLeft();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetLeft();
        } else {
            left.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        StylesTable stylesTable = this._stylesSource;
        this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderRight(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr right = cTBorder.isSetRight() ? cTBorder.getRight() : cTBorder.addNewRight();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetRight();
        } else {
            right.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        StylesTable stylesTable = this._stylesSource;
        this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBorderTop(BorderStyle borderStyle) {
        CTBorder cTBorder = getCTBorder();
        CTBorderPr top = cTBorder.isSetTop() ? cTBorder.getTop() : cTBorder.addNewTop();
        if (borderStyle == BorderStyle.NONE) {
            cTBorder.unsetTop();
        } else {
            top.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
        StylesTable stylesTable = this._stylesSource;
        this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
        this._cellXf.setApplyBorder(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setBottomBorderColor(short s6) {
        XSSFColor xSSFColorFrom = XSSFColor.from(CTColor.Factory.newInstance(), this._stylesSource.getIndexedColors());
        xSSFColorFrom.setIndexed(s6);
        setBottomBorderColor(xSSFColorFrom);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setDataFormat(short s6) {
        setDataFormat(s6 & 65535);
    }

    public void setFillBackgroundColor(XSSFColor xSSFColor) {
        CTFill cTFill = getCTFill();
        CTPatternFill patternFill = cTFill.getPatternFill();
        if (xSSFColor != null) {
            if (patternFill == null) {
                patternFill = cTFill.addNewPatternFill();
            }
            patternFill.setBgColor(xSSFColor.getCTColor());
        } else if (patternFill != null && patternFill.isSetBgColor()) {
            patternFill.unsetBgColor();
        }
        addFill(cTFill);
    }

    public void setFillForegroundColor(XSSFColor xSSFColor) {
        CTFill cTFill = getCTFill();
        CTPatternFill patternFill = cTFill.getPatternFill();
        if (xSSFColor != null) {
            if (patternFill == null) {
                patternFill = cTFill.addNewPatternFill();
            }
            patternFill.setFgColor(xSSFColor.getCTColor());
        } else if (patternFill != null && patternFill.isSetFgColor()) {
            patternFill.unsetFgColor();
        }
        addFill(cTFill);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillPattern(FillPatternType fillPatternType) {
        CTFill cTFill = getCTFill();
        CTPatternFill patternFill = cTFill.isSetPatternFill() ? cTFill.getPatternFill() : cTFill.addNewPatternFill();
        if (fillPatternType == FillPatternType.NO_FILL && patternFill.isSetPatternType()) {
            patternFill.unsetPatternType();
        } else {
            patternFill.setPatternType(STPatternType.Enum.forInt(fillPatternType.getCode() + 1));
        }
        addFill(cTFill);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFont(Font font) {
        if (font == null) {
            this._cellXf.setApplyFont(false);
            return;
        }
        this._cellXf.setFontId(font.getIndex());
        this._cellXf.setApplyFont(true);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setHidden(boolean z6) {
        if (!this._cellXf.isSetProtection()) {
            this._cellXf.addNewProtection();
        }
        this._cellXf.getProtection().setHidden(z6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setIndention(short s6) {
        getCellAlignment().setIndent(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLeftBorderColor(short s6) {
        XSSFColor xSSFColorFrom = XSSFColor.from(CTColor.Factory.newInstance(), this._stylesSource.getIndexedColors());
        xSSFColorFrom.setIndexed(s6);
        setLeftBorderColor(xSSFColorFrom);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setLocked(boolean z6) {
        if (!this._cellXf.isSetProtection()) {
            this._cellXf.addNewProtection();
        }
        this._cellXf.getProtection().setLocked(z6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setQuotePrefixed(boolean z6) {
        this._cellXf.setQuotePrefix(z6);
    }

    public void setReadingOrder(ReadingOrder readingOrder) {
        getCellAlignment().setReadingOrder(readingOrder);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRightBorderColor(short s6) {
        XSSFColor xSSFColorFrom = XSSFColor.from(CTColor.Factory.newInstance(), this._stylesSource.getIndexedColors());
        xSSFColorFrom.setIndexed(s6);
        setRightBorderColor(xSSFColorFrom);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setRotation(short s6) {
        getCellAlignment().setTextRotation(s6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setShrinkToFit(boolean z6) {
        getCellAlignment().setShrinkToFit(z6);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setTopBorderColor(short s6) {
        XSSFColor xSSFColorFrom = XSSFColor.from(CTColor.Factory.newInstance(), this._stylesSource.getIndexedColors());
        xSSFColorFrom.setIndexed(s6);
        setTopBorderColor(xSSFColorFrom);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        this._cellXf.setApplyAlignment(true);
        getCellAlignment().setVertical(verticalAlignment);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setWrapText(boolean z6) {
        getCellAlignment().setWrapText(z6);
    }

    public void verifyBelongsToStylesSource(StylesTable stylesTable) {
        if (this._stylesSource != stylesTable) {
            throw new IllegalArgumentException("This Style does not belong to the supplied Workbook Styles Source. Are you trying to assign a style from one workbook to the cell of a different workbook?");
        }
    }

    @Override // org.apache.poi.common.Duplicatable
    public XSSFCellStyle copy() {
        return new XSSFCellStyle(this._stylesSource.putCellXf((CTXf) this._cellXf.copy()) - 1, this._stylesSource._getStyleXfsSize() - 1, this._stylesSource, this._theme);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public XSSFColor getFillBackgroundColorColor() {
        return getFillBackgroundXSSFColor();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public XSSFColor getFillForegroundColorColor() {
        return getFillForegroundXSSFColor();
    }

    public void setDataFormat(int i5) {
        this._cellXf.setApplyNumberFormat(true);
        this._cellXf.setNumFmtId(i5);
    }

    public void setBottomBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetBottom()) {
            CTBorderPr bottom = cTBorder.isSetBottom() ? cTBorder.getBottom() : cTBorder.addNewBottom();
            if (xSSFColor != null) {
                bottom.setColor(xSSFColor.getCTColor());
            } else {
                bottom.unsetColor();
            }
            StylesTable stylesTable = this._stylesSource;
            this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    public void setLeftBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetLeft()) {
            CTBorderPr left = cTBorder.isSetLeft() ? cTBorder.getLeft() : cTBorder.addNewLeft();
            if (xSSFColor != null) {
                left.setColor(xSSFColor.getCTColor());
            } else {
                left.unsetColor();
            }
            StylesTable stylesTable = this._stylesSource;
            this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    public void setRightBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetRight()) {
            CTBorderPr right = cTBorder.isSetRight() ? cTBorder.getRight() : cTBorder.addNewRight();
            if (xSSFColor != null) {
                right.setColor(xSSFColor.getCTColor());
            } else {
                right.unsetColor();
            }
            StylesTable stylesTable = this._stylesSource;
            this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    public void setTopBorderColor(XSSFColor xSSFColor) {
        CTBorder cTBorder = getCTBorder();
        if (xSSFColor != null || cTBorder.isSetTop()) {
            CTBorderPr top = cTBorder.isSetTop() ? cTBorder.getTop() : cTBorder.addNewTop();
            if (xSSFColor != null) {
                top.setColor(xSSFColor.getCTColor());
            } else {
                top.unsetColor();
            }
            StylesTable stylesTable = this._stylesSource;
            this._cellXf.setBorderId(stylesTable.putBorder(new XSSFCellBorder(cTBorder, this._theme, stylesTable.getIndexedColors())));
            this._cellXf.setApplyBorder(true);
        }
    }

    public XSSFCellStyle(StylesTable stylesTable) {
        this._stylesSource = stylesTable;
        this._cellXf = CTXf.Factory.newInstance();
        this._cellStyleXf = null;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillBackgroundColor(Color color) {
        if (color != null && !(color instanceof XSSFColor)) {
            throw new IllegalArgumentException("XSSFCellStyle only accepts XSSFColor instances");
        }
        setFillBackgroundColor((XSSFColor) color);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillForegroundColor(Color color) {
        if (color != null && !(color instanceof XSSFColor)) {
            throw new IllegalArgumentException("XSSFCellStyle only accepts XSSFColor instances");
        }
        setFillForegroundColor((XSSFColor) color);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillBackgroundColor(short s6) {
        XSSFColor xSSFColorFrom = XSSFColor.from(CTColor.Factory.newInstance(), this._stylesSource.getIndexedColors());
        xSSFColorFrom.setIndexed(s6);
        setFillBackgroundColor(xSSFColorFrom);
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public void setFillForegroundColor(short s6) {
        XSSFColor xSSFColorFrom = XSSFColor.from(CTColor.Factory.newInstance(), this._stylesSource.getIndexedColors());
        xSSFColorFrom.setIndexed(s6);
        setFillForegroundColor(xSSFColorFrom);
    }
}

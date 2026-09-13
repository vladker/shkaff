package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.util.Objects;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STVerticalAlignRun;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontFamily;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFFont implements Font {
    public static final short DEFAULT_FONT_COLOR = IndexedColors.BLACK.getIndex();
    public static final String DEFAULT_FONT_NAME = "Calibri";
    public static final short DEFAULT_FONT_SIZE = 11;
    private final CTFont _ctFont;
    private int _index;
    private IndexedColorMap _indexedColorMap;
    private ThemesTable _themes;

    @Internal
    public XSSFFont(CTFont cTFont) {
        this._ctFont = cTFont;
        this._index = 0;
    }

    private double getFontHeightRaw() {
        CTFontSize szArray = this._ctFont.sizeOfSzArray() == 0 ? null : this._ctFont.getSzArray(0);
        if (szArray != null) {
            return szArray.getVal();
        }
        return 11.0d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFFont)) {
            return false;
        }
        XSSFFont xSSFFont = (XSSFFont) obj;
        return Boolean.valueOf(getItalic()).equals(Boolean.valueOf(xSSFFont.getItalic())) && Boolean.valueOf(getBold()).equals(Boolean.valueOf(xSSFFont.getBold())) && Boolean.valueOf(getStrikeout()).equals(Boolean.valueOf(xSSFFont.getStrikeout())) && Integer.valueOf(getCharSet()).equals(Integer.valueOf(xSSFFont.getCharSet())) && Short.valueOf(getColor()).equals(Short.valueOf(xSSFFont.getColor())) && Integer.valueOf(getFamily()).equals(Integer.valueOf(xSSFFont.getFamily())) && Short.valueOf(getFontHeight()).equals(Short.valueOf(xSSFFont.getFontHeight())) && Objects.equals(getFontName(), xSSFFont.getFontName()) && Objects.equals(getScheme(), xSSFFont.getScheme()) && Short.valueOf(getThemeColor()).equals(Short.valueOf(xSSFFont.getThemeColor())) && Short.valueOf(getTypeOffset()).equals(Short.valueOf(xSSFFont.getTypeOffset())) && Byte.valueOf(getUnderline()).equals(Byte.valueOf(xSSFFont.getUnderline())) && Objects.equals(getXSSFColor(), xSSFFont.getXSSFColor());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getBold() {
        CTBooleanProperty bArray = this._ctFont.sizeOfBArray() == 0 ? null : this._ctFont.getBArray(0);
        return bArray != null && bArray.getVal();
    }

    @Internal
    public CTFont getCTFont() {
        return this._ctFont;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public int getCharSet() {
        CTIntProperty charsetArray = this._ctFont.sizeOfCharsetArray() == 0 ? null : this._ctFont.getCharsetArray(0);
        return (charsetArray == null ? FontCharset.ANSI : FontCharset.valueOf(charsetArray.getVal())).getNativeId();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getColor() {
        CTColor colorArray = this._ctFont.sizeOfColorArray() == 0 ? null : this._ctFont.getColorArray(0);
        if (colorArray == null) {
            return IndexedColors.BLACK.getIndex();
        }
        long indexed = colorArray.getIndexed();
        if (indexed == DEFAULT_FONT_COLOR) {
            return IndexedColors.BLACK.getIndex();
        }
        IndexedColors indexedColors = IndexedColors.RED;
        return indexed == ((long) indexedColors.getIndex()) ? indexedColors.getIndex() : (short) indexed;
    }

    public int getFamily() {
        CTFontFamily familyArray = this._ctFont.sizeOfFamilyArray() == 0 ? null : this._ctFont.getFamilyArray(0);
        return (familyArray == null ? FontFamily.NOT_APPLICABLE : FontFamily.valueOf(familyArray.getVal())).getValue();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeight() {
        return (short) (getFontHeightRaw() * 20.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeightInPoints() {
        return (short) getFontHeightRaw();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public String getFontName() {
        CTFontName nameArray = this._ctFont.sizeOfNameArray() == 0 ? null : this._ctFont.getNameArray(0);
        return nameArray == null ? DEFAULT_FONT_NAME : nameArray.getVal();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public int getIndex() {
        return this._index;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    @Removal(version = "6.0.0")
    @Deprecated
    public int getIndexAsInt() {
        return this._index;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getItalic() {
        CTBooleanProperty iArray = this._ctFont.sizeOfIArray() == 0 ? null : this._ctFont.getIArray(0);
        return iArray != null && iArray.getVal();
    }

    public FontScheme getScheme() {
        CTFontScheme schemeArray = this._ctFont.sizeOfSchemeArray() == 0 ? null : this._ctFont.getSchemeArray(0);
        return schemeArray == null ? FontScheme.NONE : FontScheme.valueOf(schemeArray.getVal().intValue());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getStrikeout() {
        CTBooleanProperty strikeArray = this._ctFont.sizeOfStrikeArray() == 0 ? null : this._ctFont.getStrikeArray(0);
        return strikeArray != null && strikeArray.getVal();
    }

    public short getThemeColor() {
        CTColor colorArray = this._ctFont.sizeOfColorArray() == 0 ? null : this._ctFont.getColorArray(0);
        return (short) (colorArray == null ? 0L : colorArray.getTheme());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getTypeOffset() {
        int iIntValue;
        CTVerticalAlignFontProperty vertAlignArray = this._ctFont.sizeOfVertAlignArray() == 0 ? null : this._ctFont.getVertAlignArray(0);
        if (vertAlignArray == null || (iIntValue = vertAlignArray.getVal().intValue()) == 1) {
            return (short) 0;
        }
        if (iIntValue == 2) {
            return (short) 1;
        }
        if (iIntValue == 3) {
            return (short) 2;
        }
        throw new POIXMLException(AbstractC0157z.k(iIntValue, "Wrong offset value "));
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public byte getUnderline() {
        CTUnderlineProperty uArray = this._ctFont.sizeOfUArray() == 0 ? null : this._ctFont.getUArray(0);
        if (uArray != null) {
            return FontUnderline.valueOf(uArray.getVal().intValue()).getByteValue();
        }
        return (byte) 0;
    }

    public XSSFColor getXSSFColor() {
        CTColor colorArray = this._ctFont.sizeOfColorArray() == 0 ? null : this._ctFont.getColorArray(0);
        if (colorArray == null) {
            return null;
        }
        XSSFColor xSSFColorFrom = XSSFColor.from(colorArray, this._indexedColorMap);
        ThemesTable themesTable = this._themes;
        if (themesTable != null) {
            themesTable.inheritFromThemeAsRequired(xSSFColorFrom);
        }
        return xSSFColorFrom;
    }

    public int hashCode() {
        return this._ctFont.toString().hashCode();
    }

    public long registerTo(StylesTable stylesTable) {
        return registerTo(stylesTable, true);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setBold(boolean z6) {
        if (z6) {
            (this._ctFont.sizeOfBArray() == 0 ? this._ctFont.addNewB() : this._ctFont.getBArray(0)).setVal(true);
        } else {
            this._ctFont.setBArray(null);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(byte b) {
        setCharSet(b & UnsignedBytes.MAX_VALUE);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setColor(short s6) {
        CTColor cTColorAddNewColor = this._ctFont.sizeOfColorArray() == 0 ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0);
        if (s6 == 10) {
            cTColorAddNewColor.setIndexed(IndexedColors.RED.getIndex());
        } else if (s6 != Short.MAX_VALUE) {
            cTColorAddNewColor.setIndexed(s6);
        } else {
            cTColorAddNewColor.setIndexed(DEFAULT_FONT_COLOR);
        }
    }

    public void setFamily(int i5) {
        (this._ctFont.sizeOfFamilyArray() == 0 ? this._ctFont.addNewFamily() : this._ctFont.getFamilyArray(0)).setVal(i5);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeight(short s6) {
        setFontHeight(((double) s6) / 20.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeightInPoints(short s6) {
        setFontHeight(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontName(String str) {
        CTFontName cTFontNameAddNewName = this._ctFont.sizeOfNameArray() == 0 ? this._ctFont.addNewName() : this._ctFont.getNameArray(0);
        if (str == null) {
            str = DEFAULT_FONT_NAME;
        }
        cTFontNameAddNewName.setVal(str);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setItalic(boolean z6) {
        if (z6) {
            (this._ctFont.sizeOfIArray() == 0 ? this._ctFont.addNewI() : this._ctFont.getIArray(0)).setVal(true);
        } else {
            this._ctFont.setIArray(null);
        }
    }

    public void setScheme(FontScheme fontScheme) {
        (this._ctFont.sizeOfSchemeArray() == 0 ? this._ctFont.addNewScheme() : this._ctFont.getSchemeArray(0)).setVal(STFontScheme.Enum.forInt(fontScheme.getValue()));
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setStrikeout(boolean z6) {
        if (z6) {
            (this._ctFont.sizeOfStrikeArray() == 0 ? this._ctFont.addNewStrike() : this._ctFont.getStrikeArray(0)).setVal(true);
        } else {
            this._ctFont.setStrikeArray(null);
        }
    }

    public void setThemeColor(short s6) {
        (this._ctFont.sizeOfColorArray() == 0 ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0)).setTheme(s6);
    }

    public void setThemesTable(ThemesTable themesTable) {
        this._themes = themesTable;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setTypeOffset(short s6) {
        if (s6 == 0) {
            this._ctFont.setVertAlignArray(null);
            return;
        }
        CTVerticalAlignFontProperty cTVerticalAlignFontPropertyAddNewVertAlign = this._ctFont.sizeOfVertAlignArray() == 0 ? this._ctFont.addNewVertAlign() : this._ctFont.getVertAlignArray(0);
        if (s6 == 1) {
            cTVerticalAlignFontPropertyAddNewVertAlign.setVal(STVerticalAlignRun.SUPERSCRIPT);
        } else {
            if (s6 != 2) {
                throw new IllegalStateException(AbstractC0157z.k(s6, "Invalid type offset: "));
            }
            cTVerticalAlignFontPropertyAddNewVertAlign.setVal(STVerticalAlignRun.SUBSCRIPT);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setUnderline(byte b) {
        setUnderline(FontUnderline.valueOf(b));
    }

    public String toString() {
        return this._ctFont.toString();
    }

    public long registerTo(StylesTable stylesTable, boolean z6) {
        this._themes = stylesTable.getTheme();
        int iPutFont = stylesTable.putFont(this, z6);
        this._index = iPutFont;
        return iPutFont;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(int i5) {
        FontCharset fontCharsetValueOf = FontCharset.valueOf(i5);
        if (fontCharsetValueOf == null) {
            throw new POIXMLException("Attention: an attempt to set a type of unknown charset and charset");
        }
        setCharSet(fontCharsetValueOf);
    }

    public void setFontHeight(double d) {
        (this._ctFont.sizeOfSzArray() == 0 ? this._ctFont.addNewSz() : this._ctFont.getSzArray(0)).setVal(d);
    }

    public void setUnderline(FontUnderline fontUnderline) {
        if (fontUnderline != FontUnderline.NONE || this._ctFont.sizeOfUArray() <= 0) {
            (this._ctFont.sizeOfUArray() == 0 ? this._ctFont.addNewU() : this._ctFont.getUArray(0)).setVal(STUnderlineValues.Enum.forInt(fontUnderline.getValue()));
        } else {
            this._ctFont.setUArray(null);
        }
    }

    public void setFamily(FontFamily fontFamily) {
        setFamily(fontFamily.getValue());
    }

    @Internal
    public XSSFFont(CTFont cTFont, int i5, IndexedColorMap indexedColorMap) {
        this._ctFont = cTFont;
        this._index = (short) i5;
        this._indexedColorMap = indexedColorMap;
    }

    @Removal(version = "6.0.0")
    @Deprecated
    public void setCharSet(org.apache.poi.ss.usermodel.FontCharset fontCharset) {
        CTIntProperty charsetArray;
        if (this._ctFont.sizeOfCharsetArray() == 0) {
            charsetArray = this._ctFont.addNewCharset();
        } else {
            charsetArray = this._ctFont.getCharsetArray(0);
        }
        charsetArray.setVal(fontCharset.getValue());
    }

    public void setColor(XSSFColor xSSFColor) {
        if (xSSFColor == null) {
            this._ctFont.setColorArray(null);
            return;
        }
        CTColor cTColorAddNewColor = this._ctFont.sizeOfColorArray() == 0 ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0);
        if (cTColorAddNewColor.isSetIndexed()) {
            cTColorAddNewColor.unsetIndexed();
        }
        cTColorAddNewColor.setRgb(xSSFColor.getRGB());
    }

    public XSSFFont() {
        this._ctFont = CTFont.Factory.newInstance();
        setFontName(DEFAULT_FONT_NAME);
        setFontHeight(11.0d);
    }

    public void setCharSet(FontCharset fontCharset) {
        CTIntProperty charsetArray;
        if (this._ctFont.sizeOfCharsetArray() == 0) {
            charsetArray = this._ctFont.addNewCharset();
        } else {
            charsetArray = this._ctFont.getCharsetArray(0);
        }
        charsetArray.setVal(fontCharset.getNativeId());
    }
}

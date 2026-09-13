package org.apache.poi.hssf.usermodel;

import androidx.core.view.InputDeviceCompat;
import java.util.Objects;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFFont implements Font {
    static final short BOLDWEIGHT_BOLD = 700;
    static final short BOLDWEIGHT_NORMAL = 400;
    public static final String FONT_ARIAL = "Arial";
    private final FontRecord font;
    private final int index;

    public HSSFFont(int i5, FontRecord fontRecord) {
        this.font = fontRecord;
        this.index = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof HSSFFont)) {
            HSSFFont hSSFFont = (HSSFFont) obj;
            FontRecord fontRecord = this.font;
            if (fontRecord == null) {
                if (hSSFFont.font != null) {
                    return false;
                }
            } else if (!fontRecord.equals(hSSFFont.font)) {
                return false;
            }
            if (this.index == hSSFFont.index) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getBold() {
        return this.font.getBoldWeight() == 700;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public int getCharSet() {
        byte charset = this.font.getCharset();
        return charset >= 0 ? charset : charset + 256;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getColor() {
        return this.font.getColorPaletteIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeight() {
        return this.font.getFontHeight();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeightInPoints() {
        return (short) (this.font.getFontHeight() / 20);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public String getFontName() {
        return this.font.getFontName();
    }

    public HSSFColor getHSSFColor(HSSFWorkbook hSSFWorkbook) {
        return hSSFWorkbook.getCustomPalette().getColor(getColor());
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public int getIndex() {
        return this.index;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    @Removal(version = "6.0.0")
    @Deprecated
    public int getIndexAsInt() {
        return this.index;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getItalic() {
        return this.font.isItalic();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getStrikeout() {
        return this.font.isStruckout();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getTypeOffset() {
        return this.font.getSuperSubScript();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public byte getUnderline() {
        return this.font.getUnderline();
    }

    public int hashCode() {
        return Objects.hash(this.font, Integer.valueOf(this.index));
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setBold(boolean z6) {
        if (z6) {
            this.font.setBoldWeight(BOLDWEIGHT_BOLD);
        } else {
            this.font.setBoldWeight(BOLDWEIGHT_NORMAL);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(int i5) {
        byte b = (byte) i5;
        if (i5 > 127) {
            b = (byte) (i5 + InputDeviceCompat.SOURCE_ANY);
        }
        setCharSet(b);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setColor(short s6) {
        this.font.setColorPaletteIndex(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeight(short s6) {
        this.font.setFontHeight(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontHeightInPoints(short s6) {
        this.font.setFontHeight((short) (s6 * 20));
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setFontName(String str) {
        this.font.setFontName(str);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setItalic(boolean z6) {
        this.font.setItalic(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setStrikeout(boolean z6) {
        this.font.setStrikeout(z6);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setTypeOffset(short s6) {
        this.font.setSuperSubScript(s6);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setUnderline(byte b) {
        this.font.setUnderline(b);
    }

    public String toString() {
        return "org.apache.poi.hssf.usermodel.HSSFFont{" + this.font + VectorFormat.DEFAULT_SUFFIX;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public void setCharSet(byte b) {
        this.font.setCharset(b);
    }
}

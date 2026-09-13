package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FontFormatting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFFontFormatting implements FontFormatting {
    private final org.apache.poi.hssf.record.cf.FontFormatting fontFormatting;
    private final HSSFWorkbook workbook;

    public HSSFFontFormatting(CFRuleBase cFRuleBase, HSSFWorkbook hSSFWorkbook) {
        this.fontFormatting = cFRuleBase.getFontFormatting();
        this.workbook = hSSFWorkbook;
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public short getEscapementType() {
        return this.fontFormatting.getEscapementType();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public short getFontColorIndex() {
        return this.fontFormatting.getFontColorIndex();
    }

    public org.apache.poi.hssf.record.cf.FontFormatting getFontFormattingBlock() {
        return this.fontFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public int getFontHeight() {
        return this.fontFormatting.getFontHeight();
    }

    public short getFontWeight() {
        return this.fontFormatting.getFontWeight();
    }

    public byte[] getRawRecord() {
        return this.fontFormatting.getRawRecord();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public short getUnderlineType() {
        return this.fontFormatting.getUnderlineType();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public boolean isBold() {
        return this.fontFormatting.isFontWeightModified() && this.fontFormatting.isBold();
    }

    public boolean isEscapementTypeModified() {
        return this.fontFormatting.isEscapementTypeModified();
    }

    public boolean isFontCancellationModified() {
        return this.fontFormatting.isFontCancellationModified();
    }

    public boolean isFontOutlineModified() {
        return this.fontFormatting.isFontOutlineModified();
    }

    public boolean isFontShadowModified() {
        return this.fontFormatting.isFontShadowModified();
    }

    public boolean isFontStyleModified() {
        return this.fontFormatting.isFontStyleModified();
    }

    public boolean isFontWeightModified() {
        return this.fontFormatting.isFontWeightModified();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public boolean isItalic() {
        return this.fontFormatting.isFontStyleModified() && this.fontFormatting.isItalic();
    }

    public boolean isOutlineOn() {
        return this.fontFormatting.isFontOutlineModified() && this.fontFormatting.isOutlineOn();
    }

    public boolean isShadowOn() {
        return this.fontFormatting.isFontOutlineModified() && this.fontFormatting.isShadowOn();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public boolean isStruckout() {
        return this.fontFormatting.isFontCancellationModified() && this.fontFormatting.isStruckout();
    }

    public boolean isUnderlineTypeModified() {
        return this.fontFormatting.isUnderlineTypeModified();
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void resetFontStyle() {
        setFontStyle(false, false);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setEscapementType(short s6) {
        if (s6 == 0) {
            this.fontFormatting.setEscapementType(s6);
            this.fontFormatting.setEscapementTypeModified(false);
        } else if (s6 == 1 || s6 == 2) {
            this.fontFormatting.setEscapementType(s6);
            this.fontFormatting.setEscapementTypeModified(true);
        }
    }

    public void setEscapementTypeModified(boolean z6) {
        this.fontFormatting.setEscapementTypeModified(z6);
    }

    public void setFontCancellationModified(boolean z6) {
        this.fontFormatting.setFontCancellationModified(z6);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            this.fontFormatting.setFontColorIndex((short) 0);
        } else {
            this.fontFormatting.setFontColorIndex(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontColorIndex(short s6) {
        this.fontFormatting.setFontColorIndex(s6);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontHeight(int i5) {
        this.fontFormatting.setFontHeight(i5);
    }

    public void setFontOutlineModified(boolean z6) {
        this.fontFormatting.setFontOutlineModified(z6);
    }

    public void setFontShadowModified(boolean z6) {
        this.fontFormatting.setFontShadowModified(z6);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setFontStyle(boolean z6, boolean z7) {
        boolean z8 = z6 || z7;
        this.fontFormatting.setItalic(z6);
        this.fontFormatting.setBold(z7);
        this.fontFormatting.setFontStyleModified(z8);
        this.fontFormatting.setFontWieghtModified(z8);
    }

    public void setFontStyleModified(boolean z6) {
        this.fontFormatting.setFontStyleModified(z6);
    }

    public void setOutline(boolean z6) {
        this.fontFormatting.setOutline(z6);
        this.fontFormatting.setFontOutlineModified(z6);
    }

    public void setShadow(boolean z6) {
        this.fontFormatting.setShadow(z6);
        this.fontFormatting.setFontShadowModified(z6);
    }

    public void setStrikeout(boolean z6) {
        this.fontFormatting.setStrikeout(z6);
        this.fontFormatting.setFontCancellationModified(z6);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public void setUnderlineType(short s6) {
        if (s6 == 0) {
            this.fontFormatting.setUnderlineType(s6);
            setUnderlineTypeModified(false);
        } else if (s6 == 1 || s6 == 2 || s6 == 33 || s6 == 34) {
            this.fontFormatting.setUnderlineType(s6);
            setUnderlineTypeModified(true);
        }
    }

    public void setUnderlineTypeModified(boolean z6) {
        this.fontFormatting.setUnderlineTypeModified(z6);
    }

    @Override // org.apache.poi.ss.usermodel.FontFormatting
    public HSSFColor getFontColor() {
        return this.workbook.getCustomPalette().getColor(getFontColorIndex());
    }
}

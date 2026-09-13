package org.apache.poi.xssf.usermodel;

import java.util.Arrays;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFColor extends ExtendedColor {
    private final CTColor ctColor;
    private final IndexedColorMap indexedColorMap;

    private XSSFColor(CTColor cTColor, IndexedColorMap indexedColorMap) {
        this.ctColor = cTColor;
        this.indexedColorMap = indexedColorMap;
    }

    public static XSSFColor from(CTColor cTColor, IndexedColorMap indexedColorMap) {
        if (cTColor == null) {
            return null;
        }
        return new XSSFColor(cTColor, indexedColorMap);
    }

    private boolean sameARGB(XSSFColor xSSFColor) {
        if (isRGB() == xSSFColor.isRGB()) {
            return !isRGB() || Arrays.equals(getARGB(), xSSFColor.getARGB());
        }
        return false;
    }

    private boolean sameAuto(XSSFColor xSSFColor) {
        return isAuto() == xSSFColor.isAuto();
    }

    private boolean sameIndexed(XSSFColor xSSFColor) {
        if (isIndexed() == xSSFColor.isIndexed()) {
            return !isIndexed() || getIndexed() == xSSFColor.getIndexed();
        }
        return false;
    }

    private boolean sameTheme(XSSFColor xSSFColor) {
        if (isThemed() == xSSFColor.isThemed()) {
            return !isThemed() || getTheme() == xSSFColor.getTheme();
        }
        return false;
    }

    private boolean sameTint(XSSFColor xSSFColor) {
        if (hasTint() == xSSFColor.hasTint()) {
            return !hasTint() || getTint() == xSSFColor.getTint();
        }
        return false;
    }

    public static XSSFColor toXSSFColor(Color color) {
        if (color == null || (color instanceof XSSFColor)) {
            return (XSSFColor) color;
        }
        throw new IllegalArgumentException("Only XSSFColor objects are supported, but had " + color.getClass());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFColor)) {
            return false;
        }
        XSSFColor xSSFColor = (XSSFColor) obj;
        return sameARGB(xSSFColor) && sameTheme(xSSFColor) && sameIndexed(xSSFColor) && sameTint(xSSFColor) && sameAuto(xSSFColor);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getARGB() {
        byte[] rGBOrARGB = getRGBOrARGB();
        if (rGBOrARGB == null) {
            return null;
        }
        if (rGBOrARGB.length != 3) {
            return rGBOrARGB;
        }
        byte[] bArr = new byte[4];
        bArr[0] = -1;
        System.arraycopy(rGBOrARGB, 0, bArr, 1, 3);
        return bArr;
    }

    @Internal
    public CTColor getCTColor() {
        return this.ctColor;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public short getIndex() {
        return (short) this.ctColor.getIndexed();
    }

    public short getIndexed() {
        return getIndex();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getIndexedRGB() {
        if (!isIndexed()) {
            return null;
        }
        IndexedColorMap indexedColorMap = this.indexedColorMap;
        return indexedColorMap != null ? indexedColorMap.getRGB(getIndex()) : DefaultIndexedColorMap.getDefaultRGB(getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getRGB() {
        byte[] rGBOrARGB = getRGBOrARGB();
        if (rGBOrARGB == null) {
            return null;
        }
        return rGBOrARGB.length == 4 ? Arrays.copyOfRange(rGBOrARGB, 1, 4) : rGBOrARGB;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getStoredRBG() {
        return this.ctColor.getRgb();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public int getTheme() {
        return (int) this.ctColor.getTheme();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public double getTint() {
        return this.ctColor.getTint();
    }

    public boolean hasAlpha() {
        return this.ctColor.isSetRgb() && this.ctColor.getRgb().length == 4;
    }

    public boolean hasTint() {
        return this.ctColor.isSetTint() && this.ctColor.getTint() != 0.0d;
    }

    public int hashCode() {
        return this.ctColor.toString().hashCode();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isAuto() {
        return this.ctColor.getAuto();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isIndexed() {
        return this.ctColor.isSetIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isRGB() {
        return this.ctColor.isSetRgb();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isThemed() {
        return this.ctColor.isSetTheme();
    }

    public void setAuto(boolean z6) {
        this.ctColor.setAuto(z6);
    }

    public void setIndexed(int i5) {
        this.ctColor.setIndexed(i5);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public void setRGB(byte[] bArr) {
        this.ctColor.setRgb(bArr);
    }

    public void setTheme(int i5) {
        this.ctColor.setTheme(i5);
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public void setTint(double d) {
        this.ctColor.setTint(d);
    }

    public static XSSFColor from(CTColor cTColor) {
        if (cTColor == null) {
            return null;
        }
        return new XSSFColor(cTColor, (IndexedColorMap) null);
    }

    public XSSFColor() {
        this(CTColor.Factory.newInstance(), (IndexedColorMap) null);
    }

    public XSSFColor(IndexedColorMap indexedColorMap) {
        this(CTColor.Factory.newInstance(), indexedColorMap);
    }

    public XSSFColor(java.awt.Color color, IndexedColorMap indexedColorMap) {
        this(indexedColorMap);
        setColor(color);
    }

    public XSSFColor(byte[] bArr, IndexedColorMap indexedColorMap) {
        this(CTColor.Factory.newInstance(), indexedColorMap);
        this.ctColor.setRgb(bArr);
    }

    public XSSFColor(byte[] bArr) {
        this(bArr, (IndexedColorMap) null);
    }

    public XSSFColor(IndexedColors indexedColors, IndexedColorMap indexedColorMap) {
        this(CTColor.Factory.newInstance(), indexedColorMap);
        this.ctColor.setIndexed(indexedColors.index);
    }
}

package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Color;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFBorderFormatting implements BorderFormatting {
    CTBorder _border;
    IndexedColorMap _colorMap;

    public XSSFBorderFormatting(CTBorder cTBorder, IndexedColorMap indexedColorMap) {
        this._border = cTBorder;
        this._colorMap = indexedColorMap;
    }

    private BorderStyle getBorderStyle(CTBorderPr cTBorderPr) {
        if (cTBorderPr == null) {
            return BorderStyle.NONE;
        }
        STBorderStyle.Enum style = cTBorderPr.getStyle();
        return style == null ? BorderStyle.NONE : BorderStyle.valueOf((short) (style.intValue() - 1));
    }

    private XSSFColor getColor(CTBorderPr cTBorderPr) {
        if (cTBorderPr == null) {
            return null;
        }
        return XSSFColor.from(cTBorderPr.getColor(), this._colorMap);
    }

    private short getIndexedColor(XSSFColor xSSFColor) {
        if (xSSFColor == null) {
            return (short) 0;
        }
        return xSSFColor.getIndexed();
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderBottom() {
        return getBorderStyle(this._border.getBottom());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderDiagonal() {
        return getBorderStyle(this._border.getDiagonal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderHorizontal() {
        return getBorderStyle(this._border.getHorizontal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderLeft() {
        return getBorderStyle(this._border.getLeft());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderRight() {
        return getBorderStyle(this._border.getRight());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderTop() {
        return getBorderStyle(this._border.getTop());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public BorderStyle getBorderVertical() {
        return getBorderStyle(this._border.getVertical());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getBottomBorderColor() {
        return getIndexedColor(getBottomBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getDiagonalBorderColor() {
        return getIndexedColor(getDiagonalBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getHorizontalBorderColor() {
        return getIndexedColor(getHorizontalBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getLeftBorderColor() {
        return getIndexedColor(getLeftBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getRightBorderColor() {
        return getIndexedColor(getRightBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getTopBorderColor() {
        return getIndexedColor(getTopBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public short getVerticalBorderColor() {
        return getIndexedColor(getVerticalBorderColorColor());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderBottom(BorderStyle borderStyle) {
        CTBorderPr bottom = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetBottom();
        } else {
            bottom.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderDiagonal(BorderStyle borderStyle) {
        CTBorderPr diagonal = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetDiagonal();
        } else {
            diagonal.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderHorizontal(BorderStyle borderStyle) {
        CTBorderPr horizontal = this._border.isSetHorizontal() ? this._border.getHorizontal() : this._border.addNewHorizontal();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetHorizontal();
        } else {
            horizontal.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderLeft(BorderStyle borderStyle) {
        CTBorderPr left = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetLeft();
        } else {
            left.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderRight(BorderStyle borderStyle) {
        CTBorderPr right = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetRight();
        } else {
            right.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderTop(BorderStyle borderStyle) {
        CTBorderPr top = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetTop();
        } else {
            top.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBorderVertical(BorderStyle borderStyle) {
        CTBorderPr vertical = this._border.isSetVertical() ? this._border.getVertical() : this._border.addNewVertical();
        if (borderStyle == BorderStyle.NONE) {
            this._border.unsetVertical();
        } else {
            vertical.setStyle(STBorderStyle.Enum.forInt(borderStyle.getCode() + 1));
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setBottomBorderColor((CTColor) null);
        } else {
            setBottomBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setDiagonalBorderColor((CTColor) null);
        } else {
            setDiagonalBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setHorizontalBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setHorizontalBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setLeftBorderColor((CTColor) null);
        } else {
            setLeftBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setRightBorderColor((CTColor) null);
        } else {
            setRightBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setTopBorderColor((CTColor) null);
        } else {
            setTopBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setVerticalBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setVerticalBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getBottomBorderColorColor() {
        return getColor(this._border.getBottom());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getDiagonalBorderColorColor() {
        return getColor(this._border.getDiagonal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getHorizontalBorderColorColor() {
        return getColor(this._border.getHorizontal());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getLeftBorderColorColor() {
        return getColor(this._border.getLeft());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getRightBorderColorColor() {
        return getColor(this._border.getRight());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getTopBorderColorColor() {
        return getColor(this._border.getTop());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public XSSFColor getVerticalBorderColorColor() {
        return getColor(this._border.getVertical());
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setBottomBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setBottomBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setDiagonalBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setDiagonalBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setHorizontalBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setBottomBorderColor((CTColor) null);
        } else {
            setHorizontalBorderColor(xSSFColor.getCTColor());
        }
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setLeftBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setLeftBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setRightBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setRightBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setTopBorderColor(short s6) {
        CTColor cTColorNewInstance = CTColor.Factory.newInstance();
        cTColorNewInstance.setIndexed(s6);
        setTopBorderColor(cTColorNewInstance);
    }

    @Override // org.apache.poi.ss.usermodel.BorderFormatting
    public void setVerticalBorderColor(Color color) {
        XSSFColor xSSFColor = XSSFColor.toXSSFColor(color);
        if (xSSFColor == null) {
            setBottomBorderColor((CTColor) null);
        } else {
            setVerticalBorderColor(xSSFColor.getCTColor());
        }
    }

    public void setBottomBorderColor(CTColor cTColor) {
        CTBorderPr bottom = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
        if (cTColor == null) {
            bottom.unsetColor();
        } else {
            bottom.setColor(cTColor);
        }
    }

    public void setDiagonalBorderColor(CTColor cTColor) {
        CTBorderPr diagonal = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
        if (cTColor == null) {
            diagonal.unsetColor();
        } else {
            diagonal.setColor(cTColor);
        }
    }

    public void setHorizontalBorderColor(CTColor cTColor) {
        CTBorderPr horizontal = this._border.isSetHorizontal() ? this._border.getHorizontal() : this._border.addNewHorizontal();
        if (cTColor == null) {
            horizontal.unsetColor();
        } else {
            horizontal.setColor(cTColor);
        }
    }

    public void setLeftBorderColor(CTColor cTColor) {
        CTBorderPr left = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
        if (cTColor == null) {
            left.unsetColor();
        } else {
            left.setColor(cTColor);
        }
    }

    public void setRightBorderColor(CTColor cTColor) {
        CTBorderPr right = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
        if (cTColor == null) {
            right.unsetColor();
        } else {
            right.setColor(cTColor);
        }
    }

    public void setTopBorderColor(CTColor cTColor) {
        CTBorderPr top = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
        if (cTColor == null) {
            top.unsetColor();
        } else {
            top.setColor(cTColor);
        }
    }

    public void setVerticalBorderColor(CTColor cTColor) {
        CTBorderPr vertical = this._border.isSetVertical() ? this._border.getVertical() : this._border.addNewVertical();
        if (cTColor == null) {
            vertical.unsetColor();
        } else {
            vertical.setColor(cTColor);
        }
    }
}

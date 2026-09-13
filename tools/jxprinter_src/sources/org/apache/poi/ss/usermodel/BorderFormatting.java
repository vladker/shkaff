package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface BorderFormatting {
    BorderStyle getBorderBottom();

    BorderStyle getBorderDiagonal();

    BorderStyle getBorderHorizontal();

    BorderStyle getBorderLeft();

    BorderStyle getBorderRight();

    BorderStyle getBorderTop();

    BorderStyle getBorderVertical();

    short getBottomBorderColor();

    Color getBottomBorderColorColor();

    short getDiagonalBorderColor();

    Color getDiagonalBorderColorColor();

    short getHorizontalBorderColor();

    Color getHorizontalBorderColorColor();

    short getLeftBorderColor();

    Color getLeftBorderColorColor();

    short getRightBorderColor();

    Color getRightBorderColorColor();

    short getTopBorderColor();

    Color getTopBorderColorColor();

    short getVerticalBorderColor();

    Color getVerticalBorderColorColor();

    void setBorderBottom(BorderStyle borderStyle);

    void setBorderDiagonal(BorderStyle borderStyle);

    void setBorderHorizontal(BorderStyle borderStyle);

    void setBorderLeft(BorderStyle borderStyle);

    void setBorderRight(BorderStyle borderStyle);

    void setBorderTop(BorderStyle borderStyle);

    void setBorderVertical(BorderStyle borderStyle);

    void setBottomBorderColor(Color color);

    void setBottomBorderColor(short s6);

    void setDiagonalBorderColor(Color color);

    void setDiagonalBorderColor(short s6);

    void setHorizontalBorderColor(Color color);

    void setHorizontalBorderColor(short s6);

    void setLeftBorderColor(Color color);

    void setLeftBorderColor(short s6);

    void setRightBorderColor(Color color);

    void setRightBorderColor(short s6);

    void setTopBorderColor(Color color);

    void setTopBorderColor(short s6);

    void setVerticalBorderColor(Color color);

    void setVerticalBorderColor(short s6);
}

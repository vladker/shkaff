package org.apache.poi.ss.usermodel;

import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CellStyle {
    void cloneStyleFrom(CellStyle cellStyle);

    HorizontalAlignment getAlignment();

    BorderStyle getBorderBottom();

    BorderStyle getBorderLeft();

    BorderStyle getBorderRight();

    BorderStyle getBorderTop();

    short getBottomBorderColor();

    short getDataFormat();

    String getDataFormatString();

    short getFillBackgroundColor();

    Color getFillBackgroundColorColor();

    short getFillForegroundColor();

    Color getFillForegroundColorColor();

    FillPatternType getFillPattern();

    int getFontIndex();

    @Removal(version = "6.0.0")
    @Deprecated
    int getFontIndexAsInt();

    boolean getHidden();

    short getIndention();

    short getIndex();

    short getLeftBorderColor();

    boolean getLocked();

    boolean getQuotePrefixed();

    short getRightBorderColor();

    short getRotation();

    boolean getShrinkToFit();

    short getTopBorderColor();

    VerticalAlignment getVerticalAlignment();

    boolean getWrapText();

    void setAlignment(HorizontalAlignment horizontalAlignment);

    void setBorderBottom(BorderStyle borderStyle);

    void setBorderLeft(BorderStyle borderStyle);

    void setBorderRight(BorderStyle borderStyle);

    void setBorderTop(BorderStyle borderStyle);

    void setBottomBorderColor(short s6);

    void setDataFormat(short s6);

    void setFillBackgroundColor(Color color);

    void setFillBackgroundColor(short s6);

    void setFillForegroundColor(Color color);

    void setFillForegroundColor(short s6);

    void setFillPattern(FillPatternType fillPatternType);

    void setFont(Font font);

    void setHidden(boolean z6);

    void setIndention(short s6);

    void setLeftBorderColor(short s6);

    void setLocked(boolean z6);

    void setQuotePrefixed(boolean z6);

    void setRightBorderColor(short s6);

    void setRotation(short s6);

    void setShrinkToFit(boolean z6);

    void setTopBorderColor(short s6);

    void setVerticalAlignment(VerticalAlignment verticalAlignment);

    void setWrapText(boolean z6);
}

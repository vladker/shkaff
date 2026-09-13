package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FontFormatting {
    short getEscapementType();

    Color getFontColor();

    short getFontColorIndex();

    int getFontHeight();

    short getUnderlineType();

    boolean isBold();

    boolean isItalic();

    boolean isStruckout();

    void resetFontStyle();

    void setEscapementType(short s6);

    void setFontColor(Color color);

    void setFontColorIndex(short s6);

    void setFontHeight(int i5);

    void setFontStyle(boolean z6, boolean z7);

    void setUnderlineType(short s6);
}

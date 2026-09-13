package org.apache.poi.wp.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CharacterRun {
    int getCharacterSpacing();

    String getFontName();

    int getFontSize();

    Double getFontSizeAsDouble();

    int getKerning();

    boolean isBold();

    boolean isCapitalized();

    boolean isDoubleStrikeThrough();

    boolean isEmbossed();

    boolean isHighlighted();

    boolean isImprinted();

    boolean isItalic();

    boolean isShadowed();

    boolean isSmallCaps();

    boolean isStrikeThrough();

    void setBold(boolean z6);

    void setCapitalized(boolean z6);

    void setCharacterSpacing(int i5);

    void setDoubleStrikethrough(boolean z6);

    void setEmbossed(boolean z6);

    void setFontSize(double d);

    void setFontSize(int i5);

    void setImprinted(boolean z6);

    void setItalic(boolean z6);

    void setKerning(int i5);

    void setShadow(boolean z6);

    void setSmallCaps(boolean z6);

    void setStrikeThrough(boolean z6);

    String text();
}

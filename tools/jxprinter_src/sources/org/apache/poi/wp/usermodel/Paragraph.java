package org.apache.poi.wp.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Paragraph {
    int getFirstLineIndent();

    int getFontAlignment();

    int getIndentFromLeft();

    int getIndentFromRight();

    boolean isWordWrapped();

    void setFirstLineIndent(int i5);

    void setFontAlignment(int i5);

    void setIndentFromLeft(int i5);

    void setIndentFromRight(int i5);

    void setWordWrapped(boolean z6);
}

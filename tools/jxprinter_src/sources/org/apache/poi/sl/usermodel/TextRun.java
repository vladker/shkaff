package org.apache.poi.sl.usermodel;

import java.awt.Color;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface TextRun {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum FieldType {
        SLIDE_NUMBER,
        DATE_TIME
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TextCap {
        NONE,
        SMALL,
        ALL
    }

    Hyperlink<?, ?> createHyperlink();

    @Internal
    FieldType getFieldType();

    PaintStyle getFontColor();

    String getFontFamily();

    String getFontFamily(FontGroup fontGroup);

    FontInfo getFontInfo(FontGroup fontGroup);

    Double getFontSize();

    Hyperlink<?, ?> getHyperlink();

    TextParagraph<?, ?, ?> getParagraph();

    byte getPitchAndFamily();

    String getRawText();

    TextCap getTextCap();

    boolean isBold();

    boolean isItalic();

    boolean isStrikethrough();

    boolean isSubscript();

    boolean isSuperscript();

    boolean isUnderlined();

    void setBold(boolean z6);

    void setFontColor(Color color);

    void setFontColor(PaintStyle paintStyle);

    void setFontFamily(String str);

    void setFontFamily(String str, FontGroup fontGroup);

    void setFontInfo(FontInfo fontInfo, FontGroup fontGroup);

    void setFontSize(Double d);

    void setItalic(boolean z6);

    void setStrikethrough(boolean z6);

    void setText(String str);

    void setUnderlined(boolean z6);
}

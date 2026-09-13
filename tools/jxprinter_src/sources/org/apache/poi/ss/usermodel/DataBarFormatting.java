package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface DataBarFormatting {
    Color getColor();

    ConditionalFormattingThreshold getMaxThreshold();

    ConditionalFormattingThreshold getMinThreshold();

    int getWidthMax();

    int getWidthMin();

    boolean isIconOnly();

    boolean isLeftToRight();

    void setColor(Color color);

    void setIconOnly(boolean z6);

    void setLeftToRight(boolean z6);

    void setWidthMax(int i5);

    void setWidthMin(int i5);
}

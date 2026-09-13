package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RichTextString {
    void applyFont(int i5, int i6, Font font);

    void applyFont(int i5, int i6, short s6);

    void applyFont(Font font);

    void applyFont(short s6);

    void clearFormatting();

    int getIndexOfFormattingRun(int i5);

    String getString();

    int length();

    int numFormattingRuns();
}

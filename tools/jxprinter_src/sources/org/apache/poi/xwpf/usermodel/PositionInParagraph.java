package org.apache.poi.xwpf.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PositionInParagraph {
    private int posChar;
    private int posRun;
    private int posText;

    public PositionInParagraph() {
    }

    public int getChar() {
        return this.posChar;
    }

    public int getRun() {
        return this.posRun;
    }

    public int getText() {
        return this.posText;
    }

    public void setChar(int i5) {
        this.posChar = i5;
    }

    public void setRun(int i5) {
        this.posRun = i5;
    }

    public void setText(int i5) {
        this.posText = i5;
    }

    public PositionInParagraph(int i5, int i6, int i7) {
        this.posRun = i5;
        this.posChar = i7;
        this.posText = i6;
    }
}

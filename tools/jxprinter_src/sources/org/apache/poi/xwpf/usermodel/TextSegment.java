package org.apache.poi.xwpf.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TextSegment {
    private PositionInParagraph beginPos;
    private PositionInParagraph endPos;

    public TextSegment() {
        this.beginPos = new PositionInParagraph();
        this.endPos = new PositionInParagraph();
    }

    public int getBeginChar() {
        return this.beginPos.getChar();
    }

    public PositionInParagraph getBeginPos() {
        return this.beginPos;
    }

    public int getBeginRun() {
        return this.beginPos.getRun();
    }

    public int getBeginText() {
        return this.beginPos.getText();
    }

    public int getEndChar() {
        return this.endPos.getChar();
    }

    public PositionInParagraph getEndPos() {
        return this.endPos;
    }

    public int getEndRun() {
        return this.endPos.getRun();
    }

    public int getEndText() {
        return this.endPos.getText();
    }

    public void setBeginChar(int i5) {
        this.beginPos.setChar(i5);
    }

    public void setBeginRun(int i5) {
        this.beginPos.setRun(i5);
    }

    public void setBeginText(int i5) {
        this.beginPos.setText(i5);
    }

    public void setEndChar(int i5) {
        this.endPos.setChar(i5);
    }

    public void setEndRun(int i5) {
        this.endPos.setRun(i5);
    }

    public void setEndText(int i5) {
        this.endPos.setText(i5);
    }

    public TextSegment(int i5, int i6, int i7, int i8, int i9, int i10) {
        PositionInParagraph positionInParagraph = new PositionInParagraph(i5, i7, i9);
        PositionInParagraph positionInParagraph2 = new PositionInParagraph(i6, i8, i10);
        this.beginPos = positionInParagraph;
        this.endPos = positionInParagraph2;
    }

    public TextSegment(PositionInParagraph positionInParagraph, PositionInParagraph positionInParagraph2) {
        this.beginPos = positionInParagraph;
        this.endPos = positionInParagraph2;
    }
}

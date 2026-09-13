package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XWPFParagraphDecorator {
    protected XWPFParagraphDecorator nextDecorator;
    protected XWPFParagraph paragraph;

    public XWPFParagraphDecorator(XWPFParagraph xWPFParagraph) {
        this(xWPFParagraph, null);
    }

    public String getText() {
        XWPFParagraphDecorator xWPFParagraphDecorator = this.nextDecorator;
        return xWPFParagraphDecorator != null ? xWPFParagraphDecorator.getText() : this.paragraph.getText();
    }

    public XWPFParagraphDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator) {
        this.paragraph = xWPFParagraph;
        this.nextDecorator = xWPFParagraphDecorator;
    }
}

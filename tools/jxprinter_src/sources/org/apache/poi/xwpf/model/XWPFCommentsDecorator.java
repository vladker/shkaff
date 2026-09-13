package org.apache.poi.xwpf.model;

import org.apache.poi.xwpf.usermodel.XWPFComment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFCommentsDecorator extends XWPFParagraphDecorator {
    private StringBuilder commentText;

    public XWPFCommentsDecorator(XWPFParagraphDecorator xWPFParagraphDecorator) {
        this(xWPFParagraphDecorator.paragraph, xWPFParagraphDecorator);
    }

    public String getCommentText() {
        return this.commentText.toString();
    }

    @Override // org.apache.poi.xwpf.model.XWPFParagraphDecorator
    public String getText() {
        return super.getText() + ((Object) this.commentText);
    }

    public XWPFCommentsDecorator(XWPFParagraph xWPFParagraph, XWPFParagraphDecorator xWPFParagraphDecorator) {
        super(xWPFParagraph, xWPFParagraphDecorator);
        this.commentText = new StringBuilder(64);
        for (CTMarkupRange cTMarkupRange : xWPFParagraph.getCTP().getCommentRangeStartArray()) {
            XWPFComment commentByID = xWPFParagraph.getDocument().getCommentByID(cTMarkupRange.getId().toString());
            if (commentByID != null) {
                StringBuilder sb = this.commentText;
                sb.append("\tComment by ");
                sb.append(commentByID.getAuthor());
                sb.append(": ");
                sb.append(commentByID.getText());
            }
        }
    }
}

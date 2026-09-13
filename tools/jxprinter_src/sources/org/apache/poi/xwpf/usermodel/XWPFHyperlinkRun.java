package org.apache.poi.xwpf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFHyperlinkRun extends XWPFRun {
    private CTHyperlink hyperlink;

    public XWPFHyperlinkRun(CTHyperlink cTHyperlink, CTR ctr, IRunBody iRunBody) {
        super(ctr, iRunBody);
        this.hyperlink = cTHyperlink;
    }

    public String getAnchor() {
        return this.hyperlink.getAnchor();
    }

    @Internal
    public CTHyperlink getCTHyperlink() {
        return this.hyperlink;
    }

    public XWPFHyperlink getHyperlink(XWPFDocument xWPFDocument) {
        String hyperlinkId = getHyperlinkId();
        if (hyperlinkId == null) {
            return null;
        }
        return xWPFDocument.getHyperlinkByID(hyperlinkId);
    }

    public String getHyperlinkId() {
        return this.hyperlink.getId();
    }

    public void setHyperlinkId(String str) {
        this.hyperlink.setId(str);
    }
}

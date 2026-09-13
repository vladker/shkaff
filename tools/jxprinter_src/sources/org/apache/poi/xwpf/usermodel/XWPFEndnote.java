package org.apache.poi.xwpf.usermodel;

import java.util.Iterator;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFEndnote extends XWPFAbstractFootnoteEndnote {
    public XWPFEndnote() {
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFAbstractFootnoteEndnote
    public void ensureFootnoteRef(XWPFParagraph xWPFParagraph) {
        XWPFRun xWPFRunCreateRun = !xWPFParagraph.runsIsEmpty() ? xWPFParagraph.getRuns().get(0) : null;
        if (xWPFRunCreateRun == null) {
            xWPFRunCreateRun = xWPFParagraph.createRun();
        }
        CTR ctr = xWPFRunCreateRun.getCTR();
        Iterator<CTFtnEdnRef> it = ctr.getEndnoteReferenceList().iterator();
        while (it.hasNext()) {
            if (getId().equals(it.next().getId())) {
                return;
            }
        }
        ctr.addNewRPr().addNewRStyle().setVal("FootnoteReference");
        ctr.addNewEndnoteRef();
    }

    @Internal
    public XWPFEndnote(XWPFDocument xWPFDocument, CTFtnEdn cTFtnEdn) {
        super(xWPFDocument, cTFtnEdn);
    }

    @Internal
    public XWPFEndnote(CTFtnEdn cTFtnEdn, XWPFAbstractFootnotesEndnotes xWPFAbstractFootnotesEndnotes) {
        super(cTFtnEdn, xWPFAbstractFootnotesEndnotes);
    }
}

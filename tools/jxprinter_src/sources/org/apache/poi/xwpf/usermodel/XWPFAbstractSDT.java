package org.apache.poi.xwpf.usermodel;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XWPFAbstractSDT implements ISDTContents {
    private final IBody part;
    private final String tag;
    private final String title;

    public XWPFAbstractSDT(CTSdtPr cTSdtPr, IBody iBody) {
        String val = "";
        this.title = (cTSdtPr == null || !cTSdtPr.isSetAlias()) ? "" : cTSdtPr.getAlias().getVal();
        if (cTSdtPr != null && cTSdtPr.isSetTag()) {
            val = cTSdtPr.getTag().getVal();
        }
        this.tag = val;
        this.part = iBody;
    }

    public IBody getBody() {
        return null;
    }

    public abstract ISDTContent getContent();

    public XWPFDocument getDocument() {
        return this.part.getXWPFDocument();
    }

    public BodyElementType getElementType() {
        return BodyElementType.CONTENTCONTROL;
    }

    public POIXMLDocumentPart getPart() {
        return this.part.getPart();
    }

    public BodyType getPartType() {
        return BodyType.CONTENTCONTROL;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }
}

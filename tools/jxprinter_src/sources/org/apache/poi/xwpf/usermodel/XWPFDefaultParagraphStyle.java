package org.apache.poi.xwpf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFDefaultParagraphStyle {
    private final CTPPrGeneral ppr;

    public XWPFDefaultParagraphStyle(CTPPrGeneral cTPPrGeneral) {
        this.ppr = cTPPrGeneral;
    }

    public CTPPrGeneral getPPr() {
        return this.ppr;
    }

    public int getSpacingAfter() {
        if (this.ppr.isSetSpacing()) {
            return (int) Units.toDXA(POIXMLUnits.parseLength(this.ppr.getSpacing().xgetAfter()));
        }
        return -1;
    }
}

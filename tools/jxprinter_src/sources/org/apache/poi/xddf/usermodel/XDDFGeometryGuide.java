package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFGeometryGuide {
    private CTGeomGuide guide;

    @Internal
    public XDDFGeometryGuide(CTGeomGuide cTGeomGuide) {
        this.guide = cTGeomGuide;
    }

    public String getFormula() {
        return this.guide.getFmla();
    }

    public String getName() {
        return this.guide.getName();
    }

    @Internal
    public CTGeomGuide getXmlObject() {
        return this.guide;
    }

    public void setFormula(String str) {
        this.guide.setFmla(str);
    }

    public void setName(String str) {
        this.guide.setName(str);
    }
}

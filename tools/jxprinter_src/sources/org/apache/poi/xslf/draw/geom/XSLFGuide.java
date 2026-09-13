package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.GuideIf;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFGuide implements GuideIf {
    final CTGeomGuide guide;

    public XSLFGuide(CTGeomGuide cTGeomGuide) {
        this.guide = cTGeomGuide;
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public String getFmla() {
        return this.guide.getFmla();
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public String getName() {
        return this.guide.getName();
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public void setFmla(String str) {
        this.guide.setFmla(str);
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public void setName(String str) {
        this.guide.setName(str);
    }
}

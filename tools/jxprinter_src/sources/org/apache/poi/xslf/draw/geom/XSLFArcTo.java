package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.ArcToCommandIf;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFArcTo implements ArcToCommandIf {
    private final CTPath2DArcTo arc;

    public XSLFArcTo(CTPath2DArcTo cTPath2DArcTo) {
        this.arc = cTPath2DArcTo;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getHR() {
        return this.arc.xgetHR().getStringValue();
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getStAng() {
        return this.arc.xgetStAng().getStringValue();
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getSwAng() {
        return this.arc.xgetSwAng().getStringValue();
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getWR() {
        return this.arc.xgetHR().getStringValue();
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setHR(String str) {
        this.arc.setHR(str);
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setStAng(String str) {
        this.arc.setStAng(str);
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setSwAng(String str) {
        this.arc.setSwAng(str);
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setWR(String str) {
        this.arc.setWR(str);
    }
}

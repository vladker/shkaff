package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.AdjustPointIf;
import org.apache.poi.sl.draw.geom.MoveToCommandIf;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFMoveTo implements MoveToCommandIf {
    private final CTPath2DMoveTo moveTo;

    public XSLFMoveTo(CTPath2DMoveTo cTPath2DMoveTo) {
        this.moveTo = cTPath2DMoveTo;
    }

    @Override // org.apache.poi.sl.draw.geom.MoveToCommandIf
    public void setPt(AdjustPointIf adjustPointIf) {
        CTAdjPoint2D pt = this.moveTo.getPt();
        if (pt == null) {
            pt = this.moveTo.addNewPt();
        }
        pt.setX(adjustPointIf.getX());
        pt.setY(adjustPointIf.getY());
    }

    @Override // org.apache.poi.sl.draw.geom.MoveToCommandIf
    public XSLFAdjustPoint getPt() {
        return new XSLFAdjustPoint(this.moveTo.getPt());
    }
}

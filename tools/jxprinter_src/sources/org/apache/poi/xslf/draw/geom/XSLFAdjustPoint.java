package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.AdjustPointIf;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFAdjustPoint implements AdjustPointIf {
    private final CTAdjPoint2D pnt;

    public XSLFAdjustPoint(CTAdjPoint2D cTAdjPoint2D) {
        this.pnt = cTAdjPoint2D;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public String getX() {
        return this.pnt.xgetX().getStringValue();
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public String getY() {
        return this.pnt.xgetY().getStringValue();
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public boolean isSetX() {
        return this.pnt.xgetX() != null;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public boolean isSetY() {
        return this.pnt.xgetY() != null;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public void setX(String str) {
        this.pnt.setX(str);
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public void setY(String str) {
        this.pnt.setY(str);
    }
}

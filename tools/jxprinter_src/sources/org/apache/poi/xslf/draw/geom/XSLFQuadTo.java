package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.AdjustPointIf;
import org.apache.poi.sl.draw.geom.QuadToCommandIf;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFQuadTo implements QuadToCommandIf {
    private final CTPath2DQuadBezierTo bezier;

    public XSLFQuadTo(CTPath2DQuadBezierTo cTPath2DQuadBezierTo) {
        this.bezier = cTPath2DQuadBezierTo;
    }

    @Override // org.apache.poi.sl.draw.geom.QuadToCommandIf
    public AdjustPointIf getPt1() {
        return new XSLFAdjustPoint(this.bezier.getPtArray(0));
    }

    @Override // org.apache.poi.sl.draw.geom.QuadToCommandIf
    public AdjustPointIf getPt2() {
        return new XSLFAdjustPoint(this.bezier.getPtArray(1));
    }

    @Override // org.apache.poi.sl.draw.geom.QuadToCommandIf
    public void setPt1(AdjustPointIf adjustPointIf) {
    }

    @Override // org.apache.poi.sl.draw.geom.QuadToCommandIf
    public void setPt2(AdjustPointIf adjustPointIf) {
    }
}

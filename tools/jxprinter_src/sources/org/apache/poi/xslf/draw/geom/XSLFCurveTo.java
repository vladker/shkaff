package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.AdjustPointIf;
import org.apache.poi.sl.draw.geom.CurveToCommandIf;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFCurveTo implements CurveToCommandIf {
    private final CTPath2DCubicBezierTo bezier;

    public XSLFCurveTo(CTPath2DCubicBezierTo cTPath2DCubicBezierTo) {
        this.bezier = cTPath2DCubicBezierTo;
    }

    private CTAdjPoint2D getOrCreate(int i5) {
        for (int iSizeOfPtArray = (i5 + 1) - this.bezier.sizeOfPtArray(); iSizeOfPtArray > 0; iSizeOfPtArray--) {
            this.bezier.addNewPt();
        }
        return this.bezier.getPtArray(i5);
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public void setPt1(AdjustPointIf adjustPointIf) {
        CTAdjPoint2D orCreate = getOrCreate(0);
        orCreate.setX(adjustPointIf.getX());
        orCreate.setY(adjustPointIf.getY());
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public void setPt2(AdjustPointIf adjustPointIf) {
        CTAdjPoint2D orCreate = getOrCreate(1);
        orCreate.setX(adjustPointIf.getX());
        orCreate.setY(adjustPointIf.getY());
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public void setPt3(AdjustPointIf adjustPointIf) {
        CTAdjPoint2D orCreate = getOrCreate(2);
        orCreate.setX(adjustPointIf.getX());
        orCreate.setY(adjustPointIf.getY());
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public XSLFAdjustPoint getPt1() {
        return new XSLFAdjustPoint(this.bezier.getPtArray(0));
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public XSLFAdjustPoint getPt2() {
        return new XSLFAdjustPoint(this.bezier.getPtArray(1));
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public XSLFAdjustPoint getPt3() {
        return new XSLFAdjustPoint(this.bezier.getPtArray(2));
    }
}

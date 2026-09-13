package org.apache.poi.xslf.draw.geom;

import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFCustomGeometry {
    public static CustomGeometry convertCustomGeometry(CTCustomGeometry2D cTCustomGeometry2D) {
        CustomGeometry customGeometry = new CustomGeometry();
        if (cTCustomGeometry2D.isSetAhLst()) {
            CTAdjustHandleList ahLst = cTCustomGeometry2D.getAhLst();
            for (CTXYAdjustHandle cTXYAdjustHandle : ahLst.getAhXYArray()) {
                customGeometry.addAdjustHandle(new XSLFXYAdjustHandle(cTXYAdjustHandle));
            }
            for (CTPolarAdjustHandle cTPolarAdjustHandle : ahLst.getAhPolarArray()) {
                customGeometry.addAdjustHandle(new XSLFPolarAdjustHandle(cTPolarAdjustHandle));
            }
        }
        if (cTCustomGeometry2D.isSetAvLst()) {
            for (CTGeomGuide cTGeomGuide : cTCustomGeometry2D.getAvLst().getGdArray()) {
                customGeometry.addAdjustGuide(new XSLFAdjustValue(cTGeomGuide));
            }
        }
        if (cTCustomGeometry2D.isSetGdLst()) {
            for (CTGeomGuide cTGeomGuide2 : cTCustomGeometry2D.getGdLst().getGdArray()) {
                customGeometry.addGeomGuide(new XSLFGuide(cTGeomGuide2));
            }
        }
        if (cTCustomGeometry2D.isSetRect()) {
            CTGeomRect rect = cTCustomGeometry2D.getRect();
            customGeometry.setTextBounds(rect.xgetL().getStringValue(), rect.xgetT().getStringValue(), rect.xgetR().getStringValue(), rect.xgetB().getStringValue());
        }
        if (cTCustomGeometry2D.isSetCxnLst()) {
            for (CTConnectionSite cTConnectionSite : cTCustomGeometry2D.getCxnLst().getCxnArray()) {
                customGeometry.addConnectionSite(new XSLFConnectionSite(cTConnectionSite));
            }
        }
        CTPath2DList pathLst = cTCustomGeometry2D.getPathLst();
        if (pathLst != null) {
            for (CTPath2D cTPath2D : pathLst.getPathArray()) {
                customGeometry.addPath(new XSLFPath(cTPath2D));
            }
        }
        return customGeometry;
    }
}

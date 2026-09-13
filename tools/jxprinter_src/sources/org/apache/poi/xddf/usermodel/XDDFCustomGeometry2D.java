package org.apache.poi.xddf.usermodel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.k;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFCustomGeometry2D {
    private CTCustomGeometry2D geometry;

    public XDDFCustomGeometry2D(CTCustomGeometry2D cTCustomGeometry2D) {
        this.geometry = cTCustomGeometry2D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFGeometryGuide lambda$getAdjustValues$2(CTGeomGuide cTGeomGuide) {
        return new XDDFGeometryGuide(cTGeomGuide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFConnectionSite lambda$getConnectionSites$3(CTConnectionSite cTConnectionSite) {
        return new XDDFConnectionSite(cTConnectionSite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFGeometryGuide lambda$getGuides$4(CTGeomGuide cTGeomGuide) {
        return new XDDFGeometryGuide(cTGeomGuide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFPath lambda$getPaths$5(CTPath2D cTPath2D) {
        return new XDDFPath(cTPath2D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFAdjustHandlePolar lambda$getPolarAdjustHandles$0(CTPolarAdjustHandle cTPolarAdjustHandle) {
        return new XDDFAdjustHandlePolar(cTPolarAdjustHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFAdjustHandleXY lambda$getXYAdjustHandles$1(CTXYAdjustHandle cTXYAdjustHandle) {
        return new XDDFAdjustHandleXY(cTXYAdjustHandle);
    }

    public XDDFGeometryGuide addAdjustValue() {
        if (!this.geometry.isSetAvLst()) {
            this.geometry.addNewAvLst();
        }
        return new XDDFGeometryGuide(this.geometry.getAvLst().addNewGd());
    }

    public XDDFConnectionSite addConnectionSite() {
        if (!this.geometry.isSetCxnLst()) {
            this.geometry.addNewCxnLst();
        }
        return new XDDFConnectionSite(this.geometry.getCxnLst().addNewCxn());
    }

    public XDDFGeometryGuide addGuide() {
        if (!this.geometry.isSetGdLst()) {
            this.geometry.addNewGdLst();
        }
        return new XDDFGeometryGuide(this.geometry.getGdLst().addNewGd());
    }

    public XDDFPath addNewPath() {
        return new XDDFPath(this.geometry.getPathLst().addNewPath());
    }

    public XDDFAdjustHandlePolar addPolarAdjustHandle() {
        if (!this.geometry.isSetAhLst()) {
            this.geometry.addNewAhLst();
        }
        return new XDDFAdjustHandlePolar(this.geometry.getAhLst().addNewAhPolar());
    }

    public XDDFAdjustHandleXY addXYAdjustHandle() {
        if (!this.geometry.isSetAhLst()) {
            this.geometry.addNewAhLst();
        }
        return new XDDFAdjustHandleXY(this.geometry.getAhLst().addNewAhXY());
    }

    public XDDFGeometryGuide getAdjustValue(int i5) {
        if (this.geometry.isSetAvLst()) {
            return new XDDFGeometryGuide(this.geometry.getAvLst().getGdArray(i5));
        }
        return null;
    }

    public List<XDDFGeometryGuide> getAdjustValues() {
        return this.geometry.isSetAvLst() ? Collections.unmodifiableList((List) this.geometry.getAvLst().getGdList().stream().map(new k(2)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public XDDFConnectionSite getConnectionSite(int i5) {
        if (this.geometry.isSetCxnLst()) {
            return new XDDFConnectionSite(this.geometry.getCxnLst().getCxnArray(i5));
        }
        return null;
    }

    public List<XDDFConnectionSite> getConnectionSites() {
        return this.geometry.isSetCxnLst() ? Collections.unmodifiableList((List) this.geometry.getCxnLst().getCxnList().stream().map(new k(6)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public XDDFGeometryGuide getGuide(int i5) {
        if (this.geometry.isSetGdLst()) {
            return new XDDFGeometryGuide(this.geometry.getGdLst().getGdArray(i5));
        }
        return null;
    }

    public List<XDDFGeometryGuide> getGuides() {
        return this.geometry.isSetGdLst() ? Collections.unmodifiableList((List) this.geometry.getGdLst().getGdList().stream().map(new k(7)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public XDDFPath getPath(int i5) {
        return new XDDFPath(this.geometry.getPathLst().getPathArray(i5));
    }

    public List<XDDFPath> getPaths() {
        return Collections.unmodifiableList((List) this.geometry.getPathLst().getPathList().stream().map(new k(5)).collect(Collectors.toList()));
    }

    public XDDFAdjustHandlePolar getPolarAdjustHandle(int i5) {
        if (this.geometry.isSetAhLst()) {
            return new XDDFAdjustHandlePolar(this.geometry.getAhLst().getAhPolarArray(i5));
        }
        return null;
    }

    public List<XDDFAdjustHandlePolar> getPolarAdjustHandles() {
        return this.geometry.isSetAhLst() ? Collections.unmodifiableList((List) this.geometry.getAhLst().getAhPolarList().stream().map(new k(3)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public XDDFGeometryRectangle getRectangle() {
        if (this.geometry.isSetRect()) {
            return new XDDFGeometryRectangle(this.geometry.getRect());
        }
        return null;
    }

    public XDDFAdjustHandleXY getXYAdjustHandle(int i5) {
        if (this.geometry.isSetAhLst()) {
            return new XDDFAdjustHandleXY(this.geometry.getAhLst().getAhXYArray(i5));
        }
        return null;
    }

    public List<XDDFAdjustHandleXY> getXYAdjustHandles() {
        return this.geometry.isSetAhLst() ? Collections.unmodifiableList((List) this.geometry.getAhLst().getAhXYList().stream().map(new k(4)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    @Internal
    public CTCustomGeometry2D getXmlObject() {
        return this.geometry;
    }

    public XDDFGeometryGuide insertAdjustValue(int i5) {
        if (!this.geometry.isSetAvLst()) {
            this.geometry.addNewAvLst();
        }
        return new XDDFGeometryGuide(this.geometry.getAvLst().insertNewGd(i5));
    }

    public XDDFConnectionSite insertConnectionSite(int i5) {
        if (!this.geometry.isSetCxnLst()) {
            this.geometry.addNewCxnLst();
        }
        return new XDDFConnectionSite(this.geometry.getCxnLst().insertNewCxn(i5));
    }

    public XDDFGeometryGuide insertGuide(int i5) {
        if (!this.geometry.isSetGdLst()) {
            this.geometry.addNewGdLst();
        }
        return new XDDFGeometryGuide(this.geometry.getGdLst().insertNewGd(i5));
    }

    public XDDFPath insertNewPath(int i5) {
        return new XDDFPath(this.geometry.getPathLst().insertNewPath(i5));
    }

    public XDDFAdjustHandlePolar insertPolarAdjustHandle(int i5) {
        if (!this.geometry.isSetAhLst()) {
            this.geometry.addNewAhLst();
        }
        return new XDDFAdjustHandlePolar(this.geometry.getAhLst().insertNewAhPolar(i5));
    }

    public XDDFAdjustHandleXY insertXYAdjustHandle(int i5) {
        if (!this.geometry.isSetAhLst()) {
            this.geometry.addNewAhLst();
        }
        return new XDDFAdjustHandleXY(this.geometry.getAhLst().insertNewAhXY(i5));
    }

    public void removeAdjustValue(int i5) {
        if (this.geometry.isSetAvLst()) {
            this.geometry.getAvLst().removeGd(i5);
        }
    }

    public void removeConnectionSite(int i5) {
        if (this.geometry.isSetCxnLst()) {
            this.geometry.getCxnLst().removeCxn(i5);
        }
    }

    public void removeGuide(int i5) {
        if (this.geometry.isSetGdLst()) {
            this.geometry.getGdLst().removeGd(i5);
        }
    }

    public void removePath(int i5) {
        this.geometry.getPathLst().removePath(i5);
    }

    public void removePolarAdjustHandle(int i5) {
        if (this.geometry.isSetAhLst()) {
            this.geometry.getAhLst().removeAhPolar(i5);
        }
    }

    public void removeXYAdjustHandle(int i5) {
        if (this.geometry.isSetAhLst()) {
            this.geometry.getAhLst().removeAhXY(i5);
        }
    }

    public void setRectangle(XDDFGeometryRectangle xDDFGeometryRectangle) {
        if (xDDFGeometryRectangle != null) {
            this.geometry.setRect(xDDFGeometryRectangle.getXmlObject());
        } else if (this.geometry.isSetRect()) {
            this.geometry.unsetRect();
        }
    }
}

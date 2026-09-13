package org.apache.poi.xddf.usermodel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.k;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPresetGeometry2D {
    private CTPresetGeometry2D geometry;

    public XDDFPresetGeometry2D(CTPresetGeometry2D cTPresetGeometry2D) {
        this.geometry = cTPresetGeometry2D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFGeometryGuide lambda$getAdjustValues$0(CTGeomGuide cTGeomGuide) {
        return new XDDFGeometryGuide(cTGeomGuide);
    }

    public XDDFGeometryGuide addAdjustValue() {
        if (!this.geometry.isSetAvLst()) {
            this.geometry.addNewAvLst();
        }
        return new XDDFGeometryGuide(this.geometry.getAvLst().addNewGd());
    }

    public XDDFGeometryGuide getAdjustValue(int i5) {
        if (this.geometry.isSetAvLst()) {
            return new XDDFGeometryGuide(this.geometry.getAvLst().getGdArray(i5));
        }
        return null;
    }

    public List<XDDFGeometryGuide> getAdjustValues() {
        return this.geometry.isSetAvLst() ? Collections.unmodifiableList((List) this.geometry.getAvLst().getGdList().stream().map(new k(10)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public PresetGeometry getGeometry() {
        return PresetGeometry.valueOf(this.geometry.getPrst());
    }

    @Internal
    public CTPresetGeometry2D getXmlObject() {
        return this.geometry;
    }

    public XDDFGeometryGuide insertAdjustValue(int i5) {
        if (!this.geometry.isSetAvLst()) {
            this.geometry.addNewAvLst();
        }
        return new XDDFGeometryGuide(this.geometry.getAvLst().insertNewGd(i5));
    }

    public void removeAdjustValue(int i5) {
        if (this.geometry.isSetAvLst()) {
            this.geometry.getAvLst().removeGd(i5);
        }
    }

    public void setGeometry(PresetGeometry presetGeometry) {
        this.geometry.setPrst(presetGeometry.underlying);
    }
}

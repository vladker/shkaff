package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBulletSizePoints implements XDDFBulletSize {
    private CTTextBulletSizePoint points;

    public XDDFBulletSizePoints(double d) {
        this(CTTextBulletSizePoint.Factory.newInstance());
        setPoints(d);
    }

    public double getPoints() {
        return ((double) this.points.getVal()) * 0.01d;
    }

    @Internal
    public CTTextBulletSizePoint getXmlObject() {
        return this.points;
    }

    public void setPoints(double d) {
        this.points.setVal(Math.toIntExact(Math.round(d * 100.0d)));
    }

    @Internal
    public XDDFBulletSizePoints(CTTextBulletSizePoint cTTextBulletSizePoint) {
        this.points = cTTextBulletSizePoint;
    }
}

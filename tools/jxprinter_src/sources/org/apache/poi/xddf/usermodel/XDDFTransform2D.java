package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTransform2D {
    private CTTransform2D transform;

    public XDDFTransform2D(CTTransform2D cTTransform2D) {
        this.transform = cTTransform2D;
    }

    public XDDFPositiveSize2D getExtension() {
        if (this.transform.isSetExt()) {
            return new XDDFPositiveSize2D(this.transform.getExt());
        }
        return null;
    }

    public Boolean getFlipHorizontal() {
        if (this.transform.isSetFlipH()) {
            return Boolean.valueOf(this.transform.getFlipH());
        }
        return null;
    }

    public Boolean getFlipVertical() {
        if (this.transform.isSetFlipV()) {
            return Boolean.valueOf(this.transform.getFlipV());
        }
        return null;
    }

    public XDDFPoint2D getOffset() {
        if (this.transform.isSetOff()) {
            return new XDDFPoint2D(this.transform.getOff());
        }
        return null;
    }

    public Double getRotation() {
        if (this.transform.isSetRot()) {
            return Double.valueOf(Angles.attributeToDegrees(this.transform.getRot()));
        }
        return null;
    }

    @Internal
    public CTTransform2D getXmlObject() {
        return this.transform;
    }

    public void setExtension(XDDFPositiveSize2D xDDFPositiveSize2D) {
        if (xDDFPositiveSize2D == null) {
            if (this.transform.isSetExt()) {
                this.transform.unsetExt();
            }
        } else {
            CTPositiveSize2D ext = this.transform.isSetExt() ? this.transform.getExt() : this.transform.addNewExt();
            ext.setCx(xDDFPositiveSize2D.getX());
            ext.setCy(xDDFPositiveSize2D.getY());
        }
    }

    public void setFlipHorizontal(Boolean bool) {
        if (bool != null) {
            this.transform.setFlipH(bool.booleanValue());
        } else if (this.transform.isSetFlipH()) {
            this.transform.unsetFlipH();
        }
    }

    public void setFlipVertical(Boolean bool) {
        if (bool != null) {
            this.transform.setFlipV(bool.booleanValue());
        } else if (this.transform.isSetFlipV()) {
            this.transform.unsetFlipV();
        }
    }

    public void setOffset(XDDFPoint2D xDDFPoint2D) {
        if (xDDFPoint2D == null) {
            if (this.transform.isSetOff()) {
                this.transform.unsetOff();
            }
        } else {
            CTPoint2D off = this.transform.isSetOff() ? this.transform.getOff() : this.transform.addNewOff();
            off.setX(Long.valueOf(xDDFPoint2D.getX()));
            off.setY(Long.valueOf(xDDFPoint2D.getY()));
        }
    }

    public void setRotation(Double d) {
        if (d != null) {
            this.transform.setRot(Angles.degreesToAttribute(d.doubleValue()));
        } else if (this.transform.isSetRot()) {
            this.transform.unsetRot();
        }
    }
}

package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLinearShadeProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFLinearShadeProperties {
    private CTLinearShadeProperties props;

    public XDDFLinearShadeProperties(CTLinearShadeProperties cTLinearShadeProperties) {
        this.props = cTLinearShadeProperties;
    }

    public Double getAngle() {
        if (this.props.isSetAng()) {
            return Double.valueOf(Angles.attributeToDegrees(this.props.getAng()));
        }
        return null;
    }

    @Internal
    public CTLinearShadeProperties getXmlObject() {
        return this.props;
    }

    public Boolean isScaled() {
        return this.props.isSetScaled() ? Boolean.valueOf(this.props.getScaled()) : Boolean.FALSE;
    }

    public void setAngle(Double d) {
        if (d == null) {
            if (this.props.isSetAng()) {
                this.props.unsetAng();
            }
        } else {
            if (d.doubleValue() < 0.0d || 360.0d <= d.doubleValue()) {
                throw new IllegalArgumentException("angle must be in the range [0, 360).");
            }
            this.props.setAng(Angles.degreesToAttribute(d.doubleValue()));
        }
    }

    public void setScaled(Boolean bool) {
        if (bool != null) {
            this.props.setScaled(bool.booleanValue());
        } else if (this.props.isSetScaled()) {
            this.props.unsetScaled();
        }
    }
}

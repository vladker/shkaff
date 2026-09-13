package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFFillProperties;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFDataPoint {
    private final CTDPt point;

    @Internal
    public XDDFDataPoint(CTDPt cTDPt) {
        this.point = cTDPt;
    }

    private CTMarker getMarker() {
        return this.point.isSetMarker() ? this.point.getMarker() : this.point.addNewMarker();
    }

    public Long getExplosion() {
        if (this.point.isSetExplosion()) {
            return Long.valueOf(this.point.getExplosion().getVal());
        }
        return null;
    }

    public long getIndex() {
        return this.point.getIdx().getVal();
    }

    public boolean getInvertIfNegative() {
        if (this.point.isSetInvertIfNegative()) {
            return this.point.getInvertIfNegative().getVal();
        }
        return false;
    }

    public XDDFShapeProperties getShapeProperties() {
        if (this.point.isSetSpPr()) {
            return new XDDFShapeProperties(this.point.getSpPr());
        }
        return null;
    }

    public void setExplosion(Long l6) {
        if (l6 == null) {
            if (this.point.isSetExplosion()) {
                this.point.unsetExplosion();
            }
        } else if (this.point.isSetExplosion()) {
            this.point.getExplosion().setVal(l6.longValue());
        } else {
            this.point.addNewExplosion().setVal(l6.longValue());
        }
    }

    public void setFillProperties(XDDFFillProperties xDDFFillProperties) {
        XDDFShapeProperties shapeProperties = getShapeProperties();
        if (shapeProperties == null) {
            shapeProperties = new XDDFShapeProperties();
        }
        shapeProperties.setFillProperties(xDDFFillProperties);
        setShapeProperties(shapeProperties);
    }

    public void setInvertIfNegative(boolean z6) {
        if (this.point.isSetInvertIfNegative()) {
            this.point.getInvertIfNegative().setVal(z6);
        } else {
            this.point.addNewInvertIfNegative().setVal(z6);
        }
    }

    public void setLineProperties(XDDFLineProperties xDDFLineProperties) {
        XDDFShapeProperties shapeProperties = getShapeProperties();
        if (shapeProperties == null) {
            shapeProperties = new XDDFShapeProperties();
        }
        shapeProperties.setLineProperties(xDDFLineProperties);
        setShapeProperties(shapeProperties);
    }

    public void setMarkerSize(short s6) {
        if (s6 < 2 || 72 < s6) {
            throw new IllegalArgumentException("Minimum inclusive: 2; Maximum inclusive: 72");
        }
        CTMarker marker = getMarker();
        if (marker.isSetSize()) {
            marker.getSize().setVal(s6);
        } else {
            marker.addNewSize().setVal(s6);
        }
    }

    public void setMarkerStyle(MarkerStyle markerStyle) {
        CTMarker marker = getMarker();
        if (marker.isSetSymbol()) {
            marker.getSymbol().setVal(markerStyle.underlying);
        } else {
            marker.addNewSymbol().setVal(markerStyle.underlying);
        }
    }

    public void setShapeProperties(XDDFShapeProperties xDDFShapeProperties) {
        if (xDDFShapeProperties == null) {
            if (this.point.isSetSpPr()) {
                this.point.unsetSpPr();
            }
        } else if (this.point.isSetSpPr()) {
            this.point.setSpPr(xDDFShapeProperties.getXmlObject());
        } else {
            this.point.addNewSpPr().set(xDDFShapeProperties.getXmlObject());
        }
    }
}

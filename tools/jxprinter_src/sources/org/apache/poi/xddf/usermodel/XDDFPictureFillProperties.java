package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPictureFillProperties implements XDDFFillProperties {
    private CTBlipFillProperties props;

    public XDDFPictureFillProperties() {
        this(CTBlipFillProperties.Factory.newInstance());
    }

    public Long getDpi() {
        if (this.props.isSetDpi()) {
            return Long.valueOf(this.props.getDpi());
        }
        return null;
    }

    public XDDFPicture getPicture() {
        if (this.props.isSetBlip()) {
            return new XDDFPicture(this.props.getBlip());
        }
        return null;
    }

    public XDDFRelativeRectangle getSourceRectangle() {
        if (this.props.isSetSrcRect()) {
            return new XDDFRelativeRectangle(this.props.getSrcRect());
        }
        return null;
    }

    public XDDFStretchInfoProperties getStetchInfoProperties() {
        if (this.props.isSetStretch()) {
            return new XDDFStretchInfoProperties(this.props.getStretch());
        }
        return null;
    }

    public XDDFTileInfoProperties getTileInfoProperties() {
        if (this.props.isSetTile()) {
            return new XDDFTileInfoProperties(this.props.getTile());
        }
        return null;
    }

    @Internal
    public CTBlipFillProperties getXmlObject() {
        return this.props;
    }

    public Boolean isRotatingWithShape() {
        return this.props.isSetRotWithShape() ? Boolean.valueOf(this.props.getRotWithShape()) : Boolean.FALSE;
    }

    public void setDpi(Long l6) {
        if (l6 != null) {
            this.props.setDpi(l6.longValue());
        } else if (this.props.isSetDpi()) {
            this.props.unsetDpi();
        }
    }

    public void setPicture(XDDFPicture xDDFPicture) {
        if (xDDFPicture == null) {
            this.props.unsetBlip();
        } else {
            this.props.setBlip(xDDFPicture.getXmlObject());
        }
    }

    public void setRotatingWithShape(Boolean bool) {
        if (bool != null) {
            this.props.setRotWithShape(bool.booleanValue());
        } else if (this.props.isSetRotWithShape()) {
            this.props.unsetRotWithShape();
        }
    }

    public void setSourceRectangle(XDDFRelativeRectangle xDDFRelativeRectangle) {
        if (xDDFRelativeRectangle != null) {
            this.props.setSrcRect(xDDFRelativeRectangle.getXmlObject());
        } else if (this.props.isSetSrcRect()) {
            this.props.unsetSrcRect();
        }
    }

    public void setStretchInfoProperties(XDDFStretchInfoProperties xDDFStretchInfoProperties) {
        if (xDDFStretchInfoProperties != null) {
            this.props.setStretch(xDDFStretchInfoProperties.getXmlObject());
        } else if (this.props.isSetStretch()) {
            this.props.unsetStretch();
        }
    }

    public void setTileInfoProperties(XDDFTileInfoProperties xDDFTileInfoProperties) {
        if (xDDFTileInfoProperties != null) {
            this.props.setTile(xDDFTileInfoProperties.getXmlObject());
        } else if (this.props.isSetTile()) {
            this.props.unsetTile();
        }
    }

    public XDDFPictureFillProperties(CTBlipFillProperties cTBlipFillProperties) {
        this.props = cTBlipFillProperties;
    }
}

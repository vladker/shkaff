package org.apache.poi.xddf.usermodel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.k;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFGradientFillProperties implements XDDFFillProperties {
    private CTGradientFillProperties props;

    public XDDFGradientFillProperties() {
        this(CTGradientFillProperties.Factory.newInstance());
    }

    public XDDFGradientStop addGradientStop() {
        if (!this.props.isSetGsLst()) {
            this.props.addNewGsLst();
        }
        return new XDDFGradientStop(this.props.getGsLst().addNewGs());
    }

    public int countGradientStops() {
        if (this.props.isSetGsLst()) {
            return this.props.getGsLst().sizeOfGsArray();
        }
        return 0;
    }

    public XDDFGradientStop getGradientStop(int i5) {
        if (this.props.isSetGsLst()) {
            return new XDDFGradientStop(this.props.getGsLst().getGsArray(i5));
        }
        return null;
    }

    public List<XDDFGradientStop> getGradientStops() {
        return this.props.isSetGsLst() ? Collections.unmodifiableList((List) this.props.getGsLst().getGsList().stream().map(new k(8)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public XDDFLinearShadeProperties getLinearShadeProperties() {
        if (this.props.isSetLin()) {
            return new XDDFLinearShadeProperties(this.props.getLin());
        }
        return null;
    }

    public XDDFPathShadeProperties getPathShadeProperties() {
        if (this.props.isSetPath()) {
            return new XDDFPathShadeProperties(this.props.getPath());
        }
        return null;
    }

    public TileFlipMode getTileFlipMode() {
        if (this.props.isSetFlip()) {
            return TileFlipMode.valueOf(this.props.getFlip());
        }
        return null;
    }

    public XDDFRelativeRectangle getTileRectangle() {
        if (this.props.isSetTileRect()) {
            return new XDDFRelativeRectangle(this.props.getTileRect());
        }
        return null;
    }

    @Internal
    public CTGradientFillProperties getXmlObject() {
        return this.props;
    }

    public XDDFGradientStop insertGradientStop(int i5) {
        if (!this.props.isSetGsLst()) {
            this.props.addNewGsLst();
        }
        return new XDDFGradientStop(this.props.getGsLst().insertNewGs(i5));
    }

    public Boolean isRotatingWithShape() {
        return this.props.isSetRotWithShape() ? Boolean.valueOf(this.props.getRotWithShape()) : Boolean.FALSE;
    }

    public void removeGradientStop(int i5) {
        if (this.props.isSetGsLst()) {
            this.props.getGsLst().removeGs(i5);
        }
    }

    public void setLinearShadeProperties(XDDFLinearShadeProperties xDDFLinearShadeProperties) {
        if (xDDFLinearShadeProperties != null) {
            this.props.setLin(xDDFLinearShadeProperties.getXmlObject());
        } else if (this.props.isSetLin()) {
            this.props.unsetLin();
        }
    }

    public void setPathShadeProperties(XDDFPathShadeProperties xDDFPathShadeProperties) {
        if (xDDFPathShadeProperties != null) {
            this.props.setPath(xDDFPathShadeProperties.getXmlObject());
        } else if (this.props.isSetPath()) {
            this.props.unsetPath();
        }
    }

    public void setRotatingWithShape(Boolean bool) {
        if (bool != null) {
            this.props.setRotWithShape(bool.booleanValue());
        } else if (this.props.isSetRotWithShape()) {
            this.props.unsetRotWithShape();
        }
    }

    public void setTileFlipMode(TileFlipMode tileFlipMode) {
        if (tileFlipMode != null) {
            this.props.setFlip(tileFlipMode.underlying);
        } else if (this.props.isSetFlip()) {
            this.props.unsetFlip();
        }
    }

    public void setTileRectangle(XDDFRelativeRectangle xDDFRelativeRectangle) {
        if (xDDFRelativeRectangle != null) {
            this.props.setTileRect(xDDFRelativeRectangle.getXmlObject());
        } else if (this.props.isSetTileRect()) {
            this.props.unsetTileRect();
        }
    }

    public XDDFGradientFillProperties(CTGradientFillProperties cTGradientFillProperties) {
        this.props = cTGradientFillProperties;
    }
}

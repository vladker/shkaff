package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTileInfoProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTileInfoProperties {
    private CTTileInfoProperties props;

    public XDDFTileInfoProperties(CTTileInfoProperties cTTileInfoProperties) {
        this.props = cTTileInfoProperties;
    }

    public TileFlipMode getFlipMode() {
        if (this.props.isSetFlip()) {
            return TileFlipMode.valueOf(this.props.getFlip());
        }
        return null;
    }

    public Integer getSx() {
        if (this.props.isSetSx()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.props.xgetSx()));
        }
        return null;
    }

    public Integer getSy() {
        if (this.props.isSetSy()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.props.xgetSy()));
        }
        return null;
    }

    public Long getTx() {
        if (this.props.isSetTx()) {
            return Long.valueOf(POIXMLUnits.parseLength(this.props.xgetTx()));
        }
        return null;
    }

    public Long getTy() {
        if (this.props.isSetTy()) {
            return Long.valueOf(POIXMLUnits.parseLength(this.props.xgetTy()));
        }
        return null;
    }

    @Internal
    public CTTileInfoProperties getXmlObject() {
        return this.props;
    }

    public void setAlignment(RectangleAlignment rectangleAlignment) {
        if (rectangleAlignment != null) {
            this.props.setAlgn(rectangleAlignment.underlying);
        } else if (this.props.isSetAlgn()) {
            this.props.unsetAlgn();
        }
    }

    public void setFlipMode(TileFlipMode tileFlipMode) {
        if (tileFlipMode != null) {
            this.props.setFlip(tileFlipMode.underlying);
        } else if (this.props.isSetFlip()) {
            this.props.unsetFlip();
        }
    }

    public void setSx(Integer num) {
        if (num != null) {
            this.props.setSx(num);
        } else if (this.props.isSetSx()) {
            this.props.unsetSx();
        }
    }

    public void setSy(Integer num) {
        if (num != null) {
            this.props.setSy(num);
        } else if (this.props.isSetSy()) {
            this.props.unsetSy();
        }
    }

    public void setTx(Long l6) {
        if (l6 != null) {
            this.props.setTx(l6);
        } else if (this.props.isSetTx()) {
            this.props.unsetTx();
        }
    }

    public void setTy(Long l6) {
        if (l6 != null) {
            this.props.setTy(l6);
        } else if (this.props.isSetTy()) {
            this.props.unsetTy();
        }
    }
}

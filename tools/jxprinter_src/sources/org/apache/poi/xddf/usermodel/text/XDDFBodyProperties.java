package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.XDDFExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBodyProperties {
    private CTTextBodyProperties props;

    @Internal
    public XDDFBodyProperties(CTTextBodyProperties cTTextBodyProperties) {
        this.props = cTTextBodyProperties;
    }

    public AnchorType getAnchoring() {
        if (this.props.isSetAnchor()) {
            return AnchorType.valueOf(this.props.getAnchor());
        }
        return null;
    }

    public XDDFAutoFit getAutoFit() {
        if (this.props.isSetNoAutofit()) {
            return new XDDFNoAutoFit(this.props.getNoAutofit());
        }
        if (this.props.isSetNormAutofit()) {
            return new XDDFNormalAutoFit(this.props.getNormAutofit());
        }
        return this.props.isSetSpAutoFit() ? new XDDFShapeAutoFit(this.props.getSpAutoFit()) : new XDDFNormalAutoFit();
    }

    public Double getBottomInset() {
        if (this.props.isSetBIns()) {
            return Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(this.props.xgetBIns())));
        }
        return null;
    }

    public XDDFExtensionList getExtensionList() {
        if (this.props.isSetExtLst()) {
            return new XDDFExtensionList(this.props.getExtLst());
        }
        return null;
    }

    public Double getLeftInset() {
        if (this.props.isSetLIns()) {
            return Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(this.props.xgetLIns())));
        }
        return null;
    }

    public Double getRightInset() {
        if (this.props.isSetRIns()) {
            return Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(this.props.xgetRIns())));
        }
        return null;
    }

    public Double getTopInset() {
        if (this.props.isSetTIns()) {
            return Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(this.props.xgetTIns())));
        }
        return null;
    }

    @Internal
    public CTTextBodyProperties getXmlObject() {
        return this.props;
    }

    public Boolean hasParagraphSpacing() {
        if (this.props.isSetSpcFirstLastPara()) {
            return Boolean.valueOf(this.props.getSpcFirstLastPara());
        }
        return null;
    }

    public Boolean isAnchorCentered() {
        return this.props.isSetAnchorCtr() ? Boolean.valueOf(this.props.getAnchorCtr()) : Boolean.FALSE;
    }

    public Boolean isRightToLeft() {
        return this.props.isSetRtlCol() ? Boolean.valueOf(this.props.getRtlCol()) : Boolean.FALSE;
    }

    public void setAnchorCentered(Boolean bool) {
        if (bool != null) {
            this.props.setAnchorCtr(bool.booleanValue());
        } else if (this.props.isSetAnchorCtr()) {
            this.props.unsetAnchorCtr();
        }
    }

    public void setAnchoring(AnchorType anchorType) {
        if (anchorType != null) {
            this.props.setAnchor(anchorType.underlying);
        } else if (this.props.isSetAnchor()) {
            this.props.unsetAnchor();
        }
    }

    public void setAutoFit(XDDFAutoFit xDDFAutoFit) {
        if (this.props.isSetNoAutofit()) {
            this.props.unsetNoAutofit();
        }
        if (this.props.isSetNormAutofit()) {
            this.props.unsetNormAutofit();
        }
        if (this.props.isSetSpAutoFit()) {
            this.props.unsetSpAutoFit();
        }
        if (xDDFAutoFit instanceof XDDFNoAutoFit) {
            this.props.setNoAutofit(((XDDFNoAutoFit) xDDFAutoFit).getXmlObject());
        } else if (xDDFAutoFit instanceof XDDFNormalAutoFit) {
            this.props.setNormAutofit(((XDDFNormalAutoFit) xDDFAutoFit).getXmlObject());
        } else if (xDDFAutoFit instanceof XDDFShapeAutoFit) {
            this.props.setSpAutoFit(((XDDFShapeAutoFit) xDDFAutoFit).getXmlObject());
        }
    }

    public void setBottomInset(Double d) {
        if (d != null && !Double.isNaN(d.doubleValue())) {
            this.props.setBIns(Integer.valueOf(Units.toEMU(d.doubleValue())));
        } else if (this.props.isSetBIns()) {
            this.props.unsetBIns();
        }
    }

    public void setExtensionList(XDDFExtensionList xDDFExtensionList) {
        if (xDDFExtensionList != null) {
            this.props.setExtLst(xDDFExtensionList.getXmlObject());
        } else if (this.props.isSetExtLst()) {
            this.props.unsetExtLst();
        }
    }

    public void setLeftInset(Double d) {
        if (d != null && !Double.isNaN(d.doubleValue())) {
            this.props.setLIns(Integer.valueOf(Units.toEMU(d.doubleValue())));
        } else if (this.props.isSetLIns()) {
            this.props.unsetLIns();
        }
    }

    public void setParagraphSpacing(Boolean bool) {
        if (bool != null) {
            this.props.setSpcFirstLastPara(bool.booleanValue());
        } else if (this.props.isSetSpcFirstLastPara()) {
            this.props.unsetSpcFirstLastPara();
        }
    }

    public void setRightInset(Double d) {
        if (d != null && !Double.isNaN(d.doubleValue())) {
            this.props.setRIns(Integer.valueOf(Units.toEMU(d.doubleValue())));
        } else if (this.props.isSetRIns()) {
            this.props.unsetRIns();
        }
    }

    public void setRightToLeft(Boolean bool) {
        if (bool != null) {
            this.props.setRtlCol(bool.booleanValue());
        } else if (this.props.isSetRtlCol()) {
            this.props.unsetRtlCol();
        }
    }

    public void setTopInset(Double d) {
        if (d != null && !Double.isNaN(d.doubleValue())) {
            this.props.setTIns(Integer.valueOf(Units.toEMU(d.doubleValue())));
        } else if (this.props.isSetTIns()) {
            this.props.unsetTIns();
        }
    }
}

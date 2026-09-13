package org.apache.poi.xddf.usermodel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.util.k;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFLineProperties {
    private CTLineProperties props;

    public XDDFLineProperties() {
        this(CTLineProperties.Factory.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFDashStop lambda$getDashStops$0(CTDashStop cTDashStop) {
        return new XDDFDashStop(cTDashStop);
    }

    public XDDFDashStop addDashStop() {
        if (!this.props.isSetCustDash()) {
            this.props.addNewCustDash();
        }
        return new XDDFDashStop(this.props.getCustDash().addNewDs());
    }

    public int countDashStops() {
        if (this.props.isSetCustDash()) {
            return this.props.getCustDash().sizeOfDsArray();
        }
        return 0;
    }

    public CompoundLine getCompoundLine() {
        if (this.props.isSetCmpd()) {
            return CompoundLine.valueOf(this.props.getCmpd());
        }
        return null;
    }

    public XDDFDashStop getDashStop(int i5) {
        if (this.props.isSetCustDash()) {
            return new XDDFDashStop(this.props.getCustDash().getDsArray(i5));
        }
        return null;
    }

    public List<XDDFDashStop> getDashStops() {
        return this.props.isSetCustDash() ? Collections.unmodifiableList((List) this.props.getCustDash().getDsList().stream().map(new k(9)).collect(Collectors.toList())) : Collections.EMPTY_LIST;
    }

    public XDDFExtensionList getExtensionList() {
        if (this.props.isSetExtLst()) {
            return new XDDFExtensionList(this.props.getExtLst());
        }
        return null;
    }

    public XDDFFillProperties getFillProperties() {
        if (this.props.isSetGradFill()) {
            return new XDDFGradientFillProperties(this.props.getGradFill());
        }
        if (this.props.isSetNoFill()) {
            return new XDDFNoFillProperties(this.props.getNoFill());
        }
        if (this.props.isSetPattFill()) {
            return new XDDFPatternFillProperties(this.props.getPattFill());
        }
        if (this.props.isSetSolidFill()) {
            return new XDDFSolidFillProperties(this.props.getSolidFill());
        }
        return null;
    }

    public XDDFLineEndProperties getHeadEnd() {
        if (this.props.isSetHeadEnd()) {
            return new XDDFLineEndProperties(this.props.getHeadEnd());
        }
        return null;
    }

    public LineCap getLineCap() {
        if (this.props.isSetCap()) {
            return LineCap.valueOf(this.props.getCap());
        }
        return null;
    }

    public XDDFLineJoinProperties getLineJoinProperties() {
        if (this.props.isSetBevel()) {
            return new XDDFLineJoinBevelProperties(this.props.getBevel());
        }
        if (this.props.isSetMiter()) {
            return new XDDFLineJoinMiterProperties(this.props.getMiter());
        }
        if (this.props.isSetRound()) {
            return new XDDFLineJoinRoundProperties(this.props.getRound());
        }
        return null;
    }

    public PenAlignment getPenAlignment() {
        if (this.props.isSetAlgn()) {
            return PenAlignment.valueOf(this.props.getAlgn());
        }
        return null;
    }

    public XDDFPresetLineDash getPresetDash() {
        if (this.props.isSetPrstDash()) {
            return new XDDFPresetLineDash(this.props.getPrstDash());
        }
        return null;
    }

    public XDDFLineEndProperties getTailEnd() {
        if (this.props.isSetTailEnd()) {
            return new XDDFLineEndProperties(this.props.getTailEnd());
        }
        return null;
    }

    public Double getWidth() {
        if (this.props.isSetW()) {
            return Double.valueOf(Units.toPoints(this.props.getW()));
        }
        return null;
    }

    @Internal
    public CTLineProperties getXmlObject() {
        return this.props;
    }

    public XDDFDashStop insertDashStop(int i5) {
        if (!this.props.isSetCustDash()) {
            this.props.addNewCustDash();
        }
        return new XDDFDashStop(this.props.getCustDash().insertNewDs(i5));
    }

    public void removeDashStop(int i5) {
        if (this.props.isSetCustDash()) {
            this.props.getCustDash().removeDs(i5);
        }
    }

    public void setCompoundLine(CompoundLine compoundLine) {
        if (compoundLine != null) {
            this.props.setCmpd(compoundLine.underlying);
        } else if (this.props.isSetCmpd()) {
            this.props.unsetCmpd();
        }
    }

    public void setExtensionList(XDDFExtensionList xDDFExtensionList) {
        if (xDDFExtensionList != null) {
            this.props.setExtLst(xDDFExtensionList.getXmlObject());
        } else if (this.props.isSetExtLst()) {
            this.props.unsetExtLst();
        }
    }

    public void setFillProperties(XDDFFillProperties xDDFFillProperties) {
        if (this.props.isSetGradFill()) {
            this.props.unsetGradFill();
        }
        if (this.props.isSetNoFill()) {
            this.props.unsetNoFill();
        }
        if (this.props.isSetPattFill()) {
            this.props.unsetPattFill();
        }
        if (this.props.isSetSolidFill()) {
            this.props.unsetSolidFill();
        }
        if (xDDFFillProperties == null) {
            return;
        }
        if (xDDFFillProperties instanceof XDDFGradientFillProperties) {
            this.props.setGradFill(((XDDFGradientFillProperties) xDDFFillProperties).getXmlObject());
            return;
        }
        if (xDDFFillProperties instanceof XDDFNoFillProperties) {
            this.props.setNoFill(((XDDFNoFillProperties) xDDFFillProperties).getXmlObject());
        } else if (xDDFFillProperties instanceof XDDFPatternFillProperties) {
            this.props.setPattFill(((XDDFPatternFillProperties) xDDFFillProperties).getXmlObject());
        } else if (xDDFFillProperties instanceof XDDFSolidFillProperties) {
            this.props.setSolidFill(((XDDFSolidFillProperties) xDDFFillProperties).getXmlObject());
        }
    }

    public void setHeadEnd(XDDFLineEndProperties xDDFLineEndProperties) {
        if (xDDFLineEndProperties != null) {
            this.props.setHeadEnd(xDDFLineEndProperties.getXmlObject());
        } else if (this.props.isSetHeadEnd()) {
            this.props.unsetHeadEnd();
        }
    }

    public void setLineCap(LineCap lineCap) {
        if (lineCap != null) {
            this.props.setCap(lineCap.underlying);
        } else if (this.props.isSetCap()) {
            this.props.unsetCap();
        }
    }

    public void setLineJoinProperties(XDDFLineJoinProperties xDDFLineJoinProperties) {
        if (this.props.isSetBevel()) {
            this.props.unsetBevel();
        }
        if (this.props.isSetMiter()) {
            this.props.unsetMiter();
        }
        if (this.props.isSetRound()) {
            this.props.unsetRound();
        }
        if (xDDFLineJoinProperties == null) {
            return;
        }
        if (xDDFLineJoinProperties instanceof XDDFLineJoinBevelProperties) {
            this.props.setBevel(((XDDFLineJoinBevelProperties) xDDFLineJoinProperties).getXmlObject());
        } else if (xDDFLineJoinProperties instanceof XDDFLineJoinMiterProperties) {
            this.props.setMiter(((XDDFLineJoinMiterProperties) xDDFLineJoinProperties).getXmlObject());
        } else if (xDDFLineJoinProperties instanceof XDDFLineJoinRoundProperties) {
            this.props.setRound(((XDDFLineJoinRoundProperties) xDDFLineJoinProperties).getXmlObject());
        }
    }

    public void setPenAlignment(PenAlignment penAlignment) {
        if (penAlignment != null) {
            this.props.setAlgn(penAlignment.underlying);
        } else if (this.props.isSetAlgn()) {
            this.props.unsetAlgn();
        }
    }

    public void setPresetDash(XDDFPresetLineDash xDDFPresetLineDash) {
        if (xDDFPresetLineDash != null) {
            this.props.setPrstDash(xDDFPresetLineDash.getXmlObject());
        } else if (this.props.isSetPrstDash()) {
            this.props.unsetPrstDash();
        }
    }

    public void setTailEnd(XDDFLineEndProperties xDDFLineEndProperties) {
        if (xDDFLineEndProperties != null) {
            this.props.setTailEnd(xDDFLineEndProperties.getXmlObject());
        } else if (this.props.isSetTailEnd()) {
            this.props.unsetTailEnd();
        }
    }

    public void setWidth(Double d) {
        if (d != null) {
            this.props.setW(Units.toEMU(d.doubleValue()));
        } else if (this.props.isSetW()) {
            this.props.unsetW();
        }
    }

    public XDDFLineProperties(XDDFFillProperties xDDFFillProperties) {
        this();
        setFillProperties(xDDFFillProperties);
    }

    @Internal
    public XDDFLineProperties(CTLineProperties cTLineProperties) {
        this.props = cTLineProperties;
    }
}

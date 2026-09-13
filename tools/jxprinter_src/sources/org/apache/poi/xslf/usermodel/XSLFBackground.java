package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.sl.usermodel.Background;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFBackground extends XSLFSimpleShape implements Background<XSLFShape, XSLFTextParagraph> {
    public XSLFBackground(CTBackground cTBackground, XSLFSheet xSLFSheet) {
        super(cTBackground, xSLFSheet);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        Dimension pageSize = getSheet().getSlideShow().getPageSize();
        return new Rectangle2D.Double(0.0d, 0.0d, pageSize.getWidth(), pageSize.getHeight());
    }

    public CTBackgroundProperties getBgPr(boolean z6) {
        CTBackground cTBackground = (CTBackground) getXmlObject();
        if (cTBackground.isSetBgPr() || !z6) {
            return cTBackground.getBgPr();
        }
        if (cTBackground.isSetBgRef()) {
            cTBackground.unsetBgRef();
        }
        return cTBackground.addNewBgPr();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public XmlObject getShapeProperties() {
        CTBackground cTBackground = (CTBackground) getXmlObject();
        if (cTBackground.isSetBgPr()) {
            return cTBackground.getBgPr();
        }
        if (cTBackground.isSetBgRef()) {
            return cTBackground.getBgRef();
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public CTTransform2D getXfrm(boolean z6) {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setFillColor(Color color) {
        CTBackgroundProperties bgPr = getBgPr(true);
        if (bgPr.isSetBlipFill()) {
            bgPr.unsetBlipFill();
        }
        if (bgPr.isSetGradFill()) {
            bgPr.unsetGradFill();
        }
        if (bgPr.isSetGrpFill()) {
            bgPr.unsetGrpFill();
        }
        if (bgPr.isSetPattFill()) {
            bgPr.unsetPattFill();
        }
        if (color != null) {
            if (bgPr.isSetNoFill()) {
                bgPr.unsetNoFill();
            }
            CTSolidColorFillProperties solidFill = bgPr.isSetSolidFill() ? bgPr.getSolidFill() : bgPr.addNewSolidFill();
            new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr(), getSheet()).setColor(color);
            return;
        }
        if (bgPr.isSetSolidFill()) {
            bgPr.unsetSolidFill();
        }
        if (bgPr.isSetNoFill()) {
            return;
        }
        bgPr.addNewNoFill();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        throw new POIXMLException("Can't set a placeholder for a background");
    }
}

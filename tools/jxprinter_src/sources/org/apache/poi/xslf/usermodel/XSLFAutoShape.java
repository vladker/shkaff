package org.apache.poi.xslf.usermodel;

import org.apache.poi.sl.usermodel.AutoShape;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFAutoShape extends XSLFTextShape implements AutoShape<XSLFShape, XSLFTextParagraph> {
    public XSLFAutoShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    public static XSLFAutoShape create(CTShape cTShape, XSLFSheet xSLFSheet) {
        if (cTShape.getSpPr().isSetCustGeom()) {
            return new XSLFFreeformShape(cTShape, xSLFSheet);
        }
        return cTShape.getNvSpPr().getCNvSpPr().isSetTxBox() ? new XSLFTextBox(cTShape, xSLFSheet) : new XSLFAutoShape(cTShape, xSLFSheet);
    }

    public static CTShape prototype(int i5) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("AutoShape " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapeNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        return cTShapeNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public CTTextBody getTextBody(boolean z6) {
        CTShape cTShape = (CTShape) getXmlObject();
        CTTextBody txBody = cTShape.getTxBody();
        if (txBody != null || !z6) {
            return txBody;
        }
        cTShape.setTxBody(new XDDFTextBody(this).getXmlObject());
        return cTShape.getTxBody();
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getShapeName();
    }
}

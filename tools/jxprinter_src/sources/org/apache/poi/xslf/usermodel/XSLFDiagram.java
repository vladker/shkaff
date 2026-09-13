package org.apache.poi.xslf.usermodel;

import com.microsoft.schemas.office.drawing.x2008.diagram.CTShape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.diagram.CTRelIds;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFDiagram extends XSLFGraphicFrame {
    public static final String DRAWINGML_DIAGRAM_URI = "http://schemas.openxmlformats.org/drawingml/2006/diagram";
    private final XSLFDiagramDrawing _drawing;
    private final XSLFDiagramGroupShape _groupShape;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class XSLFDiagramGroupShape extends XSLFGroupShape {
        private XSLFDiagramDrawing diagramDrawing;

        public POIXMLDocumentPart getRelationById(String str) {
            return this.diagramDrawing.getRelationById(str);
        }

        public XSLFDiagramGroupShape(CTGroupShape cTGroupShape, XSLFSheet xSLFSheet) {
            super(cTGroupShape, xSLFSheet);
        }

        private XSLFDiagramGroupShape(CTGroupShape cTGroupShape, XSLFSheet xSLFSheet, XSLFDiagramDrawing xSLFDiagramDrawing) {
            super(cTGroupShape, xSLFSheet);
            this.diagramDrawing = xSLFDiagramDrawing;
        }
    }

    public XSLFDiagram(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
        this._drawing = readDiagramDrawing(cTGraphicalObjectFrame, xSLFSheet);
        this._groupShape = initGroupShape();
    }

    private XSLFDiagramGroupShape convertMsGroupToGroupShape(com.microsoft.schemas.office.drawing.x2008.diagram.CTGroupShape cTGroupShape, XSLFDiagramDrawing xSLFDiagramDrawing) {
        CTGroupShape cTGroupShapeNewInstance = CTGroupShape.Factory.newInstance();
        cTGroupShapeNewInstance.addNewGrpSpPr();
        CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeNewInstance.addNewNvGrpSpPr();
        cTGroupShapeNonVisualAddNewNvGrpSpPr.setCNvPr(cTGroupShape.getNvGrpSpPr().getCNvPr());
        cTGroupShapeNonVisualAddNewNvGrpSpPr.setCNvGrpSpPr(cTGroupShape.getNvGrpSpPr().getCNvGrpSpPr());
        cTGroupShapeNonVisualAddNewNvGrpSpPr.setNvPr(CTApplicationNonVisualDrawingProps.Factory.newInstance());
        Iterator<CTShape> it = cTGroupShape.getSpList().iterator();
        while (it.hasNext()) {
            cTGroupShapeNewInstance.getSpList().addAll(convertShape(it.next()));
        }
        Rectangle2D anchor = super.getAnchor();
        Rectangle2D rectangle2D = new Rectangle2D.Double(0.0d, 0.0d, anchor.getWidth(), anchor.getHeight());
        XSLFDiagramGroupShape xSLFDiagramGroupShape = new XSLFDiagramGroupShape(cTGroupShapeNewInstance, getSheet(), xSLFDiagramDrawing);
        xSLFDiagramGroupShape.setAnchor(anchor);
        xSLFDiagramGroupShape.setInteriorAnchor(rectangle2D);
        xSLFDiagramGroupShape.setRotation(super.getRotation());
        return xSLFDiagramGroupShape;
    }

    private List<org.openxmlformats.schemas.presentationml.x2006.main.CTShape> convertShape(CTShape cTShape) {
        org.openxmlformats.schemas.presentationml.x2006.main.CTShape cTShapeNewInstance = org.openxmlformats.schemas.presentationml.x2006.main.CTShape.Factory.newInstance();
        cTShapeNewInstance.setStyle(cTShape.getStyle());
        cTShapeNewInstance.setSpPr(cTShape.getSpPr());
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.setCNvPr(cTShape.getNvSpPr().getCNvPr());
        cTShapeNonVisualAddNewNvSpPr.setCNvSpPr(cTShape.getNvSpPr().getCNvSpPr());
        cTShapeNonVisualAddNewNvSpPr.setNvPr(CTApplicationNonVisualDrawingProps.Factory.newInstance());
        cTShapeNewInstance.setNvSpPr(cTShapeNonVisualAddNewNvSpPr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cTShapeNewInstance);
        if (hasTextContent(cTShape)) {
            arrayList.add(convertText(cTShape, cTShapeNonVisualAddNewNvSpPr));
        }
        return arrayList;
    }

    private org.openxmlformats.schemas.presentationml.x2006.main.CTShape convertText(CTShape cTShape, CTShapeNonVisual cTShapeNonVisual) {
        org.openxmlformats.schemas.presentationml.x2006.main.CTShape cTShapeNewInstance = org.openxmlformats.schemas.presentationml.x2006.main.CTShape.Factory.newInstance();
        CTShapeProperties cTShapePropertiesAddNewSpPr = cTShapeNewInstance.addNewSpPr();
        cTShapeNewInstance.setTxBody(cTShape.getTxBody());
        cTShapeNewInstance.setStyle(cTShape.getStyle());
        cTShapeNewInstance.setNvSpPr((CTShapeNonVisual) cTShapeNonVisual.copy());
        cTShapeNewInstance.getNvSpPr().getCNvSpPr().setTxBox(true);
        cTShapePropertiesAddNewSpPr.setXfrm(cTShape.getTxXfrm());
        int rot = cTShape.getSpPr().getXfrm().getRot();
        int rot2 = cTShape.getTxXfrm().getRot();
        if (rot2 != 0) {
            cTShapePropertiesAddNewSpPr.getXfrm().setRot(rot + rot2);
        }
        return cTShapeNewInstance;
    }

    private static boolean hasTextContent(CTShape cTShape) {
        if (cTShape.getTxBody() == null || cTShape.getTxXfrm() == null) {
            return false;
        }
        return cTShape.getTxBody().getPList().stream().flatMap(new org.apache.poi.xddf.usermodel.text.f(21)).anyMatch(new org.apache.poi.xddf.usermodel.text.e(20));
    }

    private XSLFDiagramGroupShape initGroupShape() {
        com.microsoft.schemas.office.drawing.x2008.diagram.CTGroupShape spTree;
        XSLFDiagramDrawing diagramDrawing = getDiagramDrawing();
        if (diagramDrawing == null || diagramDrawing.getDrawingDocument() == null || (spTree = diagramDrawing.getDrawingDocument().getDrawing().getSpTree()) == null || spTree.getSpList().isEmpty()) {
            return null;
        }
        return convertMsGroupToGroupShape(spTree, diagramDrawing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$hasTextContent$0(CTTextParagraph cTTextParagraph) {
        return cTTextParagraph.getRList().stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$hasTextContent$1(CTRegularTextRun cTRegularTextRun) {
        return (cTRegularTextRun.getT() == null || cTRegularTextRun.getT().trim().isEmpty()) ? false : true;
    }

    private static XSLFDiagramDrawing readDiagramDrawing(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        POIXMLDocumentPart relationById;
        XmlObject[] xmlObjectArrSelectChildren = cTGraphicalObjectFrame.getGraphic().getGraphicData().selectChildren(new QName(DRAWINGML_DIAGRAM_URI, "relIds"));
        if (xmlObjectArrSelectChildren.length == 0 || (relationById = xSLFSheet.getRelationById(((CTRelIds) xmlObjectArrSelectChildren[0]).getDm())) == null) {
            return null;
        }
        String strReplace = relationById.getPackagePart().getPartName().getName().replace("data", "drawing");
        for (POIXMLDocumentPart.RelationPart relationPart : xSLFSheet.getRelationParts()) {
            if (strReplace.equals(relationPart.getDocumentPart().getPackagePart().getPartName().getName()) && (relationPart.getDocumentPart() instanceof XSLFDiagramDrawing)) {
                return (XSLFDiagramDrawing) relationPart.getDocumentPart();
            }
        }
        return null;
    }

    public XSLFDiagramDrawing getDiagramDrawing() {
        return this._drawing;
    }

    public XSLFDiagramGroupShape getGroupShape() {
        return this._groupShape;
    }
}

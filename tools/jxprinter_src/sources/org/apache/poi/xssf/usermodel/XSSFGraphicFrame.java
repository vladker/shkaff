package org.apache.poi.xssf.usermodel;

import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrameNonVisual;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFGraphicFrame extends XSSFShape {
    private static CTGraphicalObjectFrame prototype;
    private final CTGraphicalObjectFrame graphicFrame;

    public XSSFGraphicFrame(XSSFDrawing xSSFDrawing, CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        this.drawing = xSSFDrawing;
        this.graphicFrame = cTGraphicalObjectFrame;
        CTGraphicalObjectData graphicData = cTGraphicalObjectFrame.getGraphic().getGraphicData();
        if (graphicData != null) {
            NodeList childNodes = graphicData.getDomNode().getChildNodes();
            for (int i5 = 0; i5 < childNodes.getLength(); i5++) {
                Node nodeItem = childNodes.item(i5);
                if (nodeItem.getNodeName().equals("c:chart")) {
                    POIXMLDocumentPart relationById = xSSFDrawing.getRelationById(nodeItem.getAttributes().getNamedItem("r:id").getNodeValue());
                    if (relationById instanceof XSSFChart) {
                        ((XSSFChart) relationById).setGraphicFrame(this);
                    }
                }
            }
        }
    }

    private void appendChartElement(CTGraphicalObjectData cTGraphicalObjectData, String str) {
        String namespaceURI = STRelationshipId.type.getName().getNamespaceURI();
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectData.newCursor();
        try {
            xmlCursorNewCursor.toNextToken();
            xmlCursorNewCursor.beginElement(new QName(XSSFRelation.NS_CHART, "chart", "c"));
            xmlCursorNewCursor.insertAttributeWithValue(new QName(namespaceURI, "id", "r"), str);
            xmlCursorNewCursor.close();
            cTGraphicalObjectData.setUri(XSSFRelation.NS_CHART);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private CTNonVisualDrawingProps getNonVisualProperties() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr();
    }

    public static CTGraphicalObjectFrame prototype() {
        if (prototype == null) {
            CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
            CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(0L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Diagramm 1");
            cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr();
            CTTransform2D cTTransform2DAddNewXfrm = cTGraphicalObjectFrameNewInstance.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            cTPoint2DAddNewOff.setX(0);
            cTPoint2DAddNewOff.setY(0);
            cTGraphicalObjectFrameNewInstance.addNewGraphic();
            prototype = cTGraphicalObjectFrameNewInstance;
        }
        return prototype;
    }

    @Internal
    public CTGraphicalObjectFrame getCTGraphicalObjectFrame() {
        return this.graphicFrame;
    }

    public long getId() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr().getId();
    }

    public String getName() {
        return getNonVisualProperties().getName();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.graphicFrame.getNvGraphicFramePr().getCNvPr().getName();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    public CTShapeProperties getShapeProperties() {
        return null;
    }

    public void setAnchor(XSSFClientAnchor xSSFClientAnchor) {
        this.anchor = xSSFClientAnchor;
    }

    public void setChart(XSSFChart xSSFChart, String str) {
        appendChartElement(this.graphicFrame.getGraphic().addNewGraphicData(), str);
        xSSFChart.setGraphicFrame(this);
    }

    public void setId(long j6) {
        this.graphicFrame.getNvGraphicFramePr().getCNvPr().setId(j6);
    }

    public void setMacro(String str) {
        this.graphicFrame.setMacro(str);
    }

    public void setName(String str) {
        getNonVisualProperties().setName(str);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape, org.apache.poi.ss.usermodel.Shape
    public XSSFClientAnchor getAnchor() {
        return (XSSFClientAnchor) this.anchor;
    }
}

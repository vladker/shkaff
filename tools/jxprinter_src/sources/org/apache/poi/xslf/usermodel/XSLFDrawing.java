package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFDrawing {
    private XSLFSheet _sheet;
    private CTGroupShape _spTree;

    public XSLFDrawing(XSLFSheet xSLFSheet, CTGroupShape cTGroupShape) {
        this._sheet = xSLFSheet;
        this._spTree = cTGroupShape;
        for (XmlObject xmlObject : xSLFSheet.getSpTree().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr")) {
            if (xmlObject instanceof CTNonVisualDrawingProps) {
                xSLFSheet.registerShapeId((int) ((CTNonVisualDrawingProps) xmlObject).getId());
            }
        }
    }

    public void addChart(String str, Rectangle2D rectangle2D) {
        this._spTree.addNewGraphicFrame().set(XSLFChart.prototype(this._sheet.allocateShapeId(), str, rectangle2D));
    }

    public XSLFAutoShape createAutoShape() {
        CTShape cTShapeAddNewSp = this._spTree.addNewSp();
        cTShapeAddNewSp.set(XSLFAutoShape.prototype(this._sheet.allocateShapeId()));
        XSLFAutoShape xSLFAutoShape = new XSLFAutoShape(cTShapeAddNewSp, this._sheet);
        xSLFAutoShape.setAnchor(new Rectangle2D.Double());
        return xSLFAutoShape;
    }

    public XSLFConnectorShape createConnector() {
        CTConnector cTConnectorAddNewCxnSp = this._spTree.addNewCxnSp();
        cTConnectorAddNewCxnSp.set(XSLFConnectorShape.prototype(this._sheet.allocateShapeId()));
        XSLFConnectorShape xSLFConnectorShape = new XSLFConnectorShape(cTConnectorAddNewCxnSp, this._sheet);
        xSLFConnectorShape.setAnchor(new Rectangle2D.Double());
        xSLFConnectorShape.setLineColor(Color.black);
        xSLFConnectorShape.setLineWidth(0.75d);
        return xSLFConnectorShape;
    }

    public XSLFFreeformShape createFreeform() {
        CTShape cTShapeAddNewSp = this._spTree.addNewSp();
        cTShapeAddNewSp.set(XSLFFreeformShape.prototype(this._sheet.allocateShapeId()));
        XSLFFreeformShape xSLFFreeformShape = new XSLFFreeformShape(cTShapeAddNewSp, this._sheet);
        xSLFFreeformShape.setAnchor(new Rectangle2D.Double());
        return xSLFFreeformShape;
    }

    public XSLFGroupShape createGroup() {
        CTGroupShape cTGroupShapeAddNewGrpSp = this._spTree.addNewGrpSp();
        cTGroupShapeAddNewGrpSp.set(XSLFGroupShape.prototype(this._sheet.allocateShapeId()));
        XSLFGroupShape xSLFGroupShape = new XSLFGroupShape(cTGroupShapeAddNewGrpSp, this._sheet);
        xSLFGroupShape.setAnchor(new Rectangle2D.Double());
        return xSLFGroupShape;
    }

    public XSLFObjectShape createOleShape(String str) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameAddNewGraphicFrame = this._spTree.addNewGraphicFrame();
        cTGraphicalObjectFrameAddNewGraphicFrame.set(XSLFObjectShape.prototype(this._sheet.allocateShapeId(), str));
        XSLFObjectShape xSLFObjectShape = new XSLFObjectShape(cTGraphicalObjectFrameAddNewGraphicFrame, this._sheet);
        xSLFObjectShape.setAnchor(new Rectangle2D.Double());
        return xSLFObjectShape;
    }

    public XSLFPictureShape createPicture(String str) {
        CTPicture cTPictureAddNewPic = this._spTree.addNewPic();
        cTPictureAddNewPic.set(XSLFPictureShape.prototype(this._sheet.allocateShapeId(), str));
        XSLFPictureShape xSLFPictureShape = new XSLFPictureShape(cTPictureAddNewPic, this._sheet);
        xSLFPictureShape.setAnchor(new Rectangle2D.Double());
        return xSLFPictureShape;
    }

    public XSLFTable createTable() {
        CTGraphicalObjectFrame cTGraphicalObjectFrameAddNewGraphicFrame = this._spTree.addNewGraphicFrame();
        cTGraphicalObjectFrameAddNewGraphicFrame.set(XSLFTable.prototype(this._sheet.allocateShapeId()));
        XSLFTable xSLFTable = new XSLFTable(cTGraphicalObjectFrameAddNewGraphicFrame, this._sheet);
        xSLFTable.setAnchor(new Rectangle2D.Double());
        return xSLFTable;
    }

    public XSLFTextBox createTextBox() {
        CTShape cTShapeAddNewSp = this._spTree.addNewSp();
        cTShapeAddNewSp.set(XSLFTextBox.prototype(this._sheet.allocateShapeId()));
        XSLFTextBox xSLFTextBox = new XSLFTextBox(cTShapeAddNewSp, this._sheet);
        xSLFTextBox.setAnchor(new Rectangle2D.Double());
        return xSLFTextBox;
    }
}

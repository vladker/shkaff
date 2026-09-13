package org.apache.poi.xslf.usermodel;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.draw.DrawPictureShape;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFGroupShape extends XSLFShape implements XSLFShapeContainer, GroupShape<XSLFShape, XSLFTextParagraph> {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFGroupShape.class);
    private XSLFDrawing _drawing;
    private final CTGroupShapeProperties _grpSpPr;
    private final List<XSLFShape> _shapes;

    public XSLFGroupShape(CTGroupShape cTGroupShape, XSLFSheet xSLFSheet) {
        super(cTGroupShape, xSLFSheet);
        this._shapes = XSLFSheet.buildShapes(cTGroupShape, this);
        this._grpSpPr = cTGroupShape.getGrpSpPr();
    }

    private XSLFDrawing getDrawing() {
        if (this._drawing == null) {
            this._drawing = new XSLFDrawing(getSheet(), (CTGroupShape) getXmlObject());
        }
        return this._drawing;
    }

    private CTGroupTransform2D getSafeXfrm() {
        CTGroupTransform2D xfrm = getXfrm();
        return xfrm == null ? getGrpSpPr().addNewXfrm() : xfrm;
    }

    public static CTGroupShape prototype(int i5) {
        CTGroupShape cTGroupShapeNewInstance = CTGroupShape.Factory.newInstance();
        CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeNewInstance.addNewNvGrpSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Group " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvGrpSpPr();
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewNvPr();
        cTGroupShapeNewInstance.addNewGrpSpPr();
        return cTGroupShapeNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer
    public void clear() {
        ArrayList arrayList = new ArrayList(getShapes());
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            removeShape((XSLFShape) obj);
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void copy(XSLFShape xSLFShape) {
        XSLFShape xSLFShapeCreateTextBox;
        List<XSLFShape> shapes = getShapes();
        List<XSLFShape> shapes2 = ((XSLFGroupShape) xSLFShape).getShapes();
        if (shapes.size() == shapes2.size()) {
            for (int i5 = 0; i5 < shapes.size(); i5++) {
                shapes.get(i5).copy(shapes2.get(i5));
            }
            return;
        }
        clear();
        for (XSLFShape xSLFShape2 : shapes2) {
            if (xSLFShape2 instanceof XSLFTextBox) {
                xSLFShapeCreateTextBox = createTextBox();
            } else if (xSLFShape2 instanceof XSLFFreeformShape) {
                xSLFShapeCreateTextBox = createFreeform();
            } else if (xSLFShape2 instanceof XSLFAutoShape) {
                xSLFShapeCreateTextBox = createAutoShape();
            } else if (xSLFShape2 instanceof XSLFConnectorShape) {
                xSLFShapeCreateTextBox = createConnector();
            } else if (xSLFShape2 instanceof XSLFPictureShape) {
                XSLFPictureData pictureData = ((XSLFPictureShape) xSLFShape2).getPictureData();
                xSLFShapeCreateTextBox = createPicture((PictureData) getSheet().getSlideShow().addPicture(pictureData.getData(), pictureData.getType()));
            } else if (xSLFShape2 instanceof XSLFGroupShape) {
                xSLFShapeCreateTextBox = createGroup();
            } else if (xSLFShape2 instanceof XSLFTable) {
                xSLFShapeCreateTextBox = createTable();
            } else {
                LOG.atWarn().log("copying of class {} not supported.", xSLFShape2.getClass());
            }
            xSLFShapeCreateTextBox.copy(xSLFShape2);
        }
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        CTGroupTransform2D xfrm = getXfrm();
        CTPoint2D off = xfrm.getOff();
        double points = Units.toPoints(POIXMLUnits.parseLength(off.xgetX()));
        double points2 = Units.toPoints(POIXMLUnits.parseLength(off.xgetY()));
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipHorizontal() {
        CTGroupTransform2D xfrm = getXfrm();
        return xfrm != null && xfrm.isSetFlipH() && xfrm.getFlipH();
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipVertical() {
        CTGroupTransform2D xfrm = getXfrm();
        return xfrm != null && xfrm.isSetFlipV() && xfrm.getFlipV();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public CTGroupShapeProperties getGrpSpPr() {
        return this._grpSpPr;
    }

    @Override // org.apache.poi.sl.usermodel.GroupShape
    public Rectangle2D getInteriorAnchor() {
        CTGroupTransform2D xfrm = getXfrm();
        CTPoint2D chOff = xfrm.getChOff();
        double points = Units.toPoints(POIXMLUnits.parseLength(chOff.xgetX()));
        double points2 = Units.toPoints(POIXMLUnits.parseLength(chOff.xgetY()));
        CTPositiveSize2D chExt = xfrm.getChExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(chExt.getCx()), Units.toPoints(chExt.getCy()));
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public double getRotation() {
        CTGroupTransform2D xfrm = getXfrm();
        if (xfrm == null || !xfrm.isSetRot()) {
            return 0.0d;
        }
        return ((double) xfrm.getRot()) / 60000.0d;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<XSLFShape> getShapes() {
        return this._shapes;
    }

    public CTGroupTransform2D getXfrm() {
        return getGrpSpPr().getXfrm();
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFShape> iterator() {
        return this._shapes.iterator();
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTGroupTransform2D safeXfrm = getSafeXfrm();
        CTPoint2D off = safeXfrm.isSetOff() ? safeXfrm.getOff() : safeXfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(Long.valueOf(emu));
        off.setY(Long.valueOf(emu2));
        CTPositiveSize2D ext = safeXfrm.isSetExt() ? safeXfrm.getExt() : safeXfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipHorizontal(boolean z6) {
        getSafeXfrm().setFlipH(z6);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipVertical(boolean z6) {
        getSafeXfrm().setFlipV(z6);
    }

    @Override // org.apache.poi.sl.usermodel.GroupShape
    public void setInteriorAnchor(Rectangle2D rectangle2D) {
        CTGroupTransform2D safeXfrm = getSafeXfrm();
        CTPoint2D chOff = safeXfrm.isSetChOff() ? safeXfrm.getChOff() : safeXfrm.addNewChOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        chOff.setX(Long.valueOf(emu));
        chOff.setY(Long.valueOf(emu2));
        CTPositiveSize2D chExt = safeXfrm.isSetChExt() ? safeXfrm.getChExt() : safeXfrm.addNewChExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        chExt.setCx(emu3);
        chExt.setCy(emu4);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setRotation(double d) {
        getSafeXfrm().setRot((int) (d * 60000.0d));
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public void addShape(XSLFShape xSLFShape) {
        throw new UnsupportedOperationException("Adding a shape from a different container is not supported - create it from scratch with XSLFGroupShape.create* methods");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFAutoShape createAutoShape() {
        XSLFAutoShape xSLFAutoShapeCreateAutoShape = getDrawing().createAutoShape();
        this._shapes.add(xSLFAutoShapeCreateAutoShape);
        xSLFAutoShapeCreateAutoShape.setParent(this);
        return xSLFAutoShapeCreateAutoShape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFConnectorShape createConnector() {
        XSLFConnectorShape xSLFConnectorShapeCreateConnector = getDrawing().createConnector();
        this._shapes.add(xSLFConnectorShapeCreateConnector);
        xSLFConnectorShapeCreateConnector.setParent(this);
        return xSLFConnectorShapeCreateConnector;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFFreeformShape createFreeform() {
        XSLFFreeformShape xSLFFreeformShapeCreateFreeform = getDrawing().createFreeform();
        this._shapes.add(xSLFFreeformShapeCreateFreeform);
        xSLFFreeformShapeCreateFreeform.setParent(this);
        return xSLFFreeformShapeCreateFreeform;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFGroupShape createGroup() {
        XSLFGroupShape xSLFGroupShapeCreateGroup = getDrawing().createGroup();
        this._shapes.add(xSLFGroupShapeCreateGroup);
        xSLFGroupShapeCreateGroup.setParent(this);
        return xSLFGroupShapeCreateGroup;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFObjectShape createOleShape(PictureData pictureData) {
        if (!(pictureData instanceof XSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
        }
        XSLFObjectShape xSLFObjectShapeCreateOleShape = getDrawing().createOleShape(getSheet().addRelation(null, XSLFRelation.IMAGES, (XSLFPictureData) pictureData).getRelationship().getId());
        CTOleObject cTOleObject = xSLFObjectShapeCreateOleShape.getCTOleObject();
        Dimension imageDimension = pictureData.getImageDimension();
        cTOleObject.setImgW(Units.toEMU(imageDimension.getWidth()));
        cTOleObject.setImgH(Units.toEMU(imageDimension.getHeight()));
        getShapes().add(xSLFObjectShapeCreateOleShape);
        xSLFObjectShapeCreateOleShape.setParent(this);
        return xSLFObjectShapeCreateOleShape;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFPictureShape createPicture(PictureData pictureData) {
        if (!(pictureData instanceof XSLFPictureData)) {
            throw new IllegalArgumentException("pictureData needs to be of type XSLFPictureData");
        }
        XSLFPictureShape xSLFPictureShapeCreatePicture = getDrawing().createPicture(getSheet().addRelation(null, XSLFRelation.IMAGES, (XSLFPictureData) pictureData).getRelationship().getId());
        new DrawPictureShape(xSLFPictureShapeCreatePicture).resize();
        this._shapes.add(xSLFPictureShapeCreatePicture);
        xSLFPictureShapeCreatePicture.setParent(this);
        return xSLFPictureShapeCreatePicture;
    }

    public XSLFTable createTable() {
        XSLFTable xSLFTableCreateTable = getDrawing().createTable();
        this._shapes.add(xSLFTableCreateTable);
        xSLFTableCreateTable.setParent(this);
        return xSLFTableCreateTable;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShapeContainer, org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFTextBox createTextBox() {
        XSLFTextBox xSLFTextBoxCreateTextBox = getDrawing().createTextBox();
        this._shapes.add(xSLFTextBoxCreateTextBox);
        xSLFTextBoxCreateTextBox.setParent(this);
        return xSLFTextBoxCreateTextBox;
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public boolean removeShape(XSLFShape xSLFShape) {
        XmlObject xmlObject = xSLFShape.getXmlObject();
        CTGroupShape cTGroupShape = (CTGroupShape) getXmlObject();
        getSheet().deregisterShapeId(xSLFShape.getShapeId());
        if (xmlObject instanceof CTShape) {
            cTGroupShape.getSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGroupShape) {
            XSLFGroupShape xSLFGroupShape = (XSLFGroupShape) xSLFShape;
            new ArrayList(xSLFGroupShape.getShapes()).forEach(new a(xSLFGroupShape, 1));
            cTGroupShape.getGrpSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTConnector) {
            cTGroupShape.getCxnSpList().remove(xmlObject);
        } else if (xmlObject instanceof CTGraphicalObjectFrame) {
            cTGroupShape.getGraphicFrameList().remove(xmlObject);
        } else {
            if (!(xmlObject instanceof CTPicture)) {
                throw new IllegalArgumentException("Unsupported shape: " + xSLFShape);
            }
            XSLFPictureShape xSLFPictureShape = (XSLFPictureShape) xSLFShape;
            XSLFSheet sheet = getSheet();
            if (sheet != null) {
                sheet.removePictureRelation(xSLFPictureShape);
            }
            cTGroupShape.getPicList().remove(xmlObject);
        }
        return this._shapes.remove(xSLFShape);
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public XSLFTable createTable(int i5, int i6) {
        if (i5 >= 1 && i6 >= 1) {
            XSLFTable xSLFTableCreateTable = getDrawing().createTable();
            this._shapes.add(xSLFTableCreateTable);
            xSLFTableCreateTable.setParent(this);
            for (int i7 = 0; i7 < i5; i7++) {
                XSLFTableRow xSLFTableRowAddRow = xSLFTableCreateTable.addRow();
                for (int i8 = 0; i8 < i6; i8++) {
                    xSLFTableRowAddRow.addCell();
                }
            }
            return xSLFTableCreateTable;
        }
        throw new IllegalArgumentException("numRows and numCols must be greater than 0");
    }
}

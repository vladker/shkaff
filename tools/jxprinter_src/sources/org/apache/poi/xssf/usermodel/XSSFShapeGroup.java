package org.apache.poi.xssf.usermodel;

import java.util.Iterator;
import java.util.Spliterator;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.usermodel.ShapeContainer;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFShapeGroup extends XSSFShape implements ShapeContainer<XSSFShape> {
    private static CTGroupShape prototype;
    private CTGroupShape ctGroup;

    public XSSFShapeGroup(XSSFDrawing xSSFDrawing, CTGroupShape cTGroupShape) {
        this.drawing = xSSFDrawing;
        this.ctGroup = cTGroupShape;
    }

    public static CTGroupShape prototype() {
        if (prototype == null) {
            CTGroupShape cTGroupShapeNewInstance = CTGroupShape.Factory.newInstance();
            CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeNewInstance.addNewNvGrpSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(0L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Group 0");
            cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvGrpSpPr();
            CTGroupTransform2D cTGroupTransform2DAddNewXfrm = cTGroupShapeNewInstance.addNewGrpSpPr().addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTGroupTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTGroupTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0);
            cTPoint2DAddNewOff.setY(0);
            CTPositiveSize2D cTPositiveSize2DAddNewChExt = cTGroupTransform2DAddNewXfrm.addNewChExt();
            cTPositiveSize2DAddNewChExt.setCx(0L);
            cTPositiveSize2DAddNewChExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewChOff = cTGroupTransform2DAddNewXfrm.addNewChOff();
            cTPoint2DAddNewChOff.setX(0);
            cTPoint2DAddNewChOff.setY(0);
            prototype = cTGroupShapeNewInstance;
        }
        return prototype;
    }

    public XSSFConnector createConnector(XSSFChildAnchor xSSFChildAnchor) {
        CTConnector cTConnectorAddNewCxnSp = this.ctGroup.addNewCxnSp();
        cTConnectorAddNewCxnSp.set(XSSFConnector.prototype());
        XSSFConnector xSSFConnector = new XSSFConnector(getDrawing(), cTConnectorAddNewCxnSp);
        xSSFConnector.parent = this;
        xSSFConnector.anchor = xSSFChildAnchor;
        xSSFConnector.getCTConnector().getSpPr().setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFConnector;
    }

    public XSSFShapeGroup createGroup(XSSFChildAnchor xSSFChildAnchor) {
        CTGroupShape cTGroupShapeAddNewGrpSp = this.ctGroup.addNewGrpSp();
        cTGroupShapeAddNewGrpSp.set(prototype());
        XSSFShapeGroup xSSFShapeGroup = new XSSFShapeGroup(getDrawing(), cTGroupShapeAddNewGrpSp);
        xSSFShapeGroup.parent = this;
        xSSFShapeGroup.anchor = xSSFChildAnchor;
        CTGroupTransform2D xfrm = xSSFShapeGroup.getCTGroupShape().getGrpSpPr().getXfrm();
        CTTransform2D cTTransform2D = xSSFChildAnchor.getCTTransform2D();
        xfrm.setOff(cTTransform2D.getOff());
        xfrm.setExt(cTTransform2D.getExt());
        xfrm.setChExt(cTTransform2D.getExt());
        xfrm.setFlipH(cTTransform2D.getFlipH());
        xfrm.setFlipV(cTTransform2D.getFlipV());
        return xSSFShapeGroup;
    }

    public XSSFPicture createPicture(XSSFClientAnchor xSSFClientAnchor, int i5) {
        PackageRelationship packageRelationshipAddPictureReference = getDrawing().addPictureReference(i5);
        CTPicture cTPictureAddNewPic = this.ctGroup.addNewPic();
        cTPictureAddNewPic.set(XSSFPicture.prototype());
        XSSFPicture xSSFPicture = new XSSFPicture(getDrawing(), cTPictureAddNewPic);
        xSSFPicture.parent = this;
        xSSFPicture.anchor = xSSFClientAnchor;
        xSSFPicture.setPictureReference(packageRelationshipAddPictureReference);
        return xSSFPicture;
    }

    public XSSFSimpleShape createSimpleShape(XSSFChildAnchor xSSFChildAnchor) {
        CTShape cTShapeAddNewSp = this.ctGroup.addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        XSSFSimpleShape xSSFSimpleShape = new XSSFSimpleShape(getDrawing(), cTShapeAddNewSp);
        xSSFSimpleShape.parent = this;
        xSSFSimpleShape.anchor = xSSFChildAnchor;
        xSSFSimpleShape.setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFSimpleShape;
    }

    public XSSFTextBox createTextbox(XSSFChildAnchor xSSFChildAnchor) {
        CTShape cTShapeAddNewSp = this.ctGroup.addNewSp();
        cTShapeAddNewSp.set(XSSFSimpleShape.prototype());
        XSSFTextBox xSSFTextBox = new XSSFTextBox(getDrawing(), cTShapeAddNewSp);
        xSSFTextBox.parent = this;
        xSSFTextBox.anchor = xSSFChildAnchor;
        xSSFTextBox.setXfrm(xSSFChildAnchor.getCTTransform2D());
        return xSSFTextBox;
    }

    @Internal
    public CTGroupShape getCTGroupShape() {
        return this.ctGroup;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.ctGroup.getNvGrpSpPr().getCNvPr().getName();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    public CTShapeProperties getShapeProperties() {
        throw new IllegalStateException("Not supported for shape group");
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return getDrawing().getShapes(this).iterator();
    }

    public void setCoordinates(int i5, int i6, int i7, int i8) {
        CTGroupTransform2D xfrm = this.ctGroup.getGrpSpPr().getXfrm();
        CTPoint2D off = xfrm.getOff();
        off.setX(Integer.valueOf(i5));
        off.setY(Integer.valueOf(i6));
        CTPositiveSize2D ext = xfrm.getExt();
        long j6 = i7;
        ext.setCx(j6);
        long j7 = i8;
        ext.setCy(j7);
        CTPoint2D chOff = xfrm.getChOff();
        chOff.setX(Integer.valueOf(i5));
        chOff.setY(Integer.valueOf(i6));
        CTPositiveSize2D chExt = xfrm.getChExt();
        chExt.setCx(j6);
        chExt.setCy(j7);
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFShape> spliterator() {
        return getDrawing().getShapes(this).spliterator();
    }
}

package org.apache.poi.xslf.usermodel;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.sl.usermodel.GraphicalFrame;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFGraphicFrame extends XSLFShape implements GraphicalFrame<XSLFShape, XSLFTextParagraph> {
    private static final String DRAWINGML_CHART_URI = "http://schemas.openxmlformats.org/drawingml/2006/chart";
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFGraphicFrame.class);

    public XSLFGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
    }

    private void copyChart(CTGraphicalObjectData cTGraphicalObjectData, XSLFGraphicFrame xSLFGraphicFrame) {
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate;
        XSLFSlide xSLFSlide = (XSLFSlide) getSheet();
        XSLFSheet sheet = xSLFGraphicFrame.getSheet();
        XmlObject[] xmlObjectArrSelectPath = cTGraphicalObjectData.selectPath("declare namespace c='http://schemas.openxmlformats.org/drawingml/2006/chart' c:chart");
        if (xmlObjectArrSelectPath == null || xmlObjectArrSelectPath.length != 1) {
            return;
        }
        try {
            XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
            try {
                QName qName = new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "id");
                XSLFChart xSLFChart = (XSLFChart) sheet.getRelationById(xmlCursorNewCursor.getAttributeText(qName));
                XSLFChart xSLFChartCreateChart = xSLFSlide.getSlideShow().createChart(xSLFSlide);
                xSLFChartCreateChart.importContent(xSLFChart);
                xSLFChartCreateChart.setWorkbook(xSLFChart.getWorkbook());
                xmlCursorNewCursor.setAttributeText(qName, xSLFSlide.getRelationId(xSLFChartCreateChart));
                CTChartSpace cTChartSpace = xSLFChartCreateChart.getCTChartSpace();
                if (cTChartSpace != null && (fillDelegate = XSLFPropertiesDelegate.getFillDelegate(cTChartSpace.getSpPr())) != null && fillDelegate.isSetBlipFill()) {
                    CTBlip blip = fillDelegate.getBlipFill().getBlip();
                    blip.setEmbed(xSLFSlide.getSlideShow().importBlip(blip.getEmbed(), xSLFChart, xSLFChartCreateChart));
                }
                xmlCursorNewCursor.close();
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
        } catch (IOException | InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    private void copyDiagram(CTGraphicalObjectData cTGraphicalObjectData, XSLFGraphicFrame xSLFGraphicFrame) {
        XmlObject[] xmlObjectArrSelectPath = cTGraphicalObjectData.selectPath("declare namespace dgm='http://schemas.openxmlformats.org/drawingml/2006/diagram' $this//dgm:relIds");
        if (xmlObjectArrSelectPath == null || xmlObjectArrSelectPath.length != 1) {
            return;
        }
        XSLFSheet sheet = xSLFGraphicFrame.getSheet();
        try {
            XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
            try {
                PackageRelationship relationship = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "dm")));
                getSheet().importPart(relationship, sheet.getPackagePart().getRelatedPart(relationship));
                PackageRelationship relationship2 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "lo")));
                getSheet().importPart(relationship2, sheet.getPackagePart().getRelatedPart(relationship2));
                PackageRelationship relationship3 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "qs")));
                getSheet().importPart(relationship3, sheet.getPackagePart().getRelatedPart(relationship3));
                PackageRelationship relationship4 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "cs")));
                getSheet().importPart(relationship4, sheet.getPackagePart().getRelatedPart(relationship4));
                xmlCursorNewCursor.close();
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
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public static XSLFGraphicFrame create(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        String uri = getUri(cTGraphicalObjectFrame);
        if (uri == null) {
            uri = "";
        }
        switch (uri) {
            case "http://schemas.openxmlformats.org/presentationml/2006/ole":
                return new XSLFObjectShape(cTGraphicalObjectFrame, xSLFSheet);
            case "http://schemas.openxmlformats.org/drawingml/2006/diagram":
                return new XSLFDiagram(cTGraphicalObjectFrame, xSLFSheet);
            case "http://schemas.openxmlformats.org/drawingml/2006/table":
                return new XSLFTable(cTGraphicalObjectFrame, xSLFSheet);
            default:
                return new XSLFGraphicFrame(cTGraphicalObjectFrame, xSLFSheet);
        }
    }

    private CTGraphicalObjectData getGraphicalData() {
        return ((CTGraphicalObjectFrame) getXmlObject()).getGraphic().getGraphicData();
    }

    private static String getUri(CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        CTGraphicalObjectData graphicData;
        CTGraphicalObject graphic = cTGraphicalObjectFrame.getGraphic();
        if (graphic == null || (graphicData = graphic.getGraphicData()) == null) {
            return null;
        }
        return graphicData.getUri();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        CTGraphicalObjectData graphicalData = getGraphicalData();
        String uri = graphicalData.getUri();
        if (uri.equals(XSLFDiagram.DRAWINGML_DIAGRAM_URI)) {
            copyDiagram(graphicalData, (XSLFGraphicFrame) xSLFShape);
        }
        if (uri.equals("http://schemas.openxmlformats.org/drawingml/2006/chart")) {
            copyChart(graphicalData, (XSLFGraphicFrame) xSLFShape);
        }
    }

    @Override // org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        CTTransform2D xfrm = ((CTGraphicalObjectFrame) getXmlObject()).getXfrm();
        CTPoint2D off = xfrm.getOff();
        double points = Units.toPoints(POIXMLUnits.parseLength(off.xgetX()));
        double points2 = Units.toPoints(POIXMLUnits.parseLength(off.xgetY()));
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    public XSLFChart getChart() {
        String attributeText;
        if (!hasChart()) {
            return null;
        }
        XmlObject[] xmlObjectArrSelectPath = getGraphicalData().selectPath("declare namespace c='http://schemas.openxmlformats.org/drawingml/2006/chart' c:chart");
        if (xmlObjectArrSelectPath == null || xmlObjectArrSelectPath.length != 1) {
            attributeText = null;
        } else {
            XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
            try {
                attributeText = xmlCursorNewCursor.getAttributeText(new QName(PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, "id"));
                xmlCursorNewCursor.close();
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
        if (attributeText == null) {
            return null;
        }
        return (XSLFChart) getSheet().getRelationById(attributeText);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipHorizontal() {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public boolean getFlipVertical() {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public double getRotation() {
        return 0.0d;
    }

    public ShapeType getShapeType() {
        throw new UnsupportedOperationException();
    }

    public boolean hasChart() {
        return getGraphicalData().getUri().equals("http://schemas.openxmlformats.org/drawingml/2006/chart");
    }

    public boolean hasDiagram() {
        return getGraphicalData().getUri().equals(XSLFDiagram.DRAWINGML_DIAGRAM_URI);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTTransform2D xfrm = ((CTGraphicalObjectFrame) getXmlObject()).getXfrm();
        CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(Long.valueOf(emu));
        off.setY(Long.valueOf(emu2));
        CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipHorizontal(boolean z6) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setFlipVertical(boolean z6) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.sl.usermodel.PlaceableShape
    public void setRotation(double d) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.sl.usermodel.GraphicalFrame
    public XSLFPictureShape getFallbackPicture() {
        XmlObject xmlObjectSelectProperty = selectProperty(XmlObject.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main'; declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' .//mc:Fallback/*/p:pic");
        if (xmlObjectSelectProperty == null) {
            return null;
        }
        try {
            CTGroupShape cTGroupShape = CTGroupShape.Factory.parse(xmlObjectSelectProperty.newDomNode());
            if (cTGroupShape.sizeOfPicArray() == 0) {
                return null;
            }
            return new XSLFPictureShape(cTGroupShape.getPicArray(0), getSheet());
        } catch (XmlException e) {
            LOG.atWarn().withThrowable(e).log("Can't parse fallback picture stream of graphical frame");
            return null;
        }
    }
}

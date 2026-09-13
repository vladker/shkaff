package org.apache.poi.xslf.usermodel;

import java.awt.geom.Rectangle2D;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSLFChart extends XDDFChart {
    private static String CHART_URI = "http://schemas.openxmlformats.org/drawingml/2006/chart";

    public XSLFChart() {
    }

    public static CTGraphicalObjectFrame prototype(int i5, String str, Rectangle2D rectangle2D) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Chart " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoGrp(true);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewNvPr();
        CTTransform2D cTTransform2DAddNewXfrm = cTGraphicalObjectFrameNewInstance.addNewXfrm();
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
        cTPoint2DAddNewOff.setX(Integer.valueOf((int) rectangle2D.getX()));
        cTPoint2DAddNewOff.setY(Integer.valueOf((int) rectangle2D.getY()));
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
        cTPositiveSize2DAddNewExt.setCx((int) rectangle2D.getWidth());
        cTPositiveSize2DAddNewExt.setCy((int) rectangle2D.getHeight());
        cTTransform2DAddNewXfrm.setExt(cTPositiveSize2DAddNewExt);
        cTTransform2DAddNewXfrm.setOff(cTPoint2DAddNewOff);
        CTGraphicalObjectData cTGraphicalObjectDataAddNewGraphicData = cTGraphicalObjectFrameNewInstance.addNewGraphic().addNewGraphicData();
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectDataAddNewGraphicData.newCursor();
        try {
            xmlCursorNewCursor.toNextToken();
            xmlCursorNewCursor.beginElement(new QName(CHART_URI, "chart"));
            xmlCursorNewCursor.insertAttributeWithValue("id", PackageRelationshipTypes.CORE_PROPERTIES_ECMA376_NS, str);
            xmlCursorNewCursor.close();
            cTGraphicalObjectDataAddNewGraphicData.setUri(CHART_URI);
            return cTGraphicalObjectFrameNewInstance;
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

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLFactory getChartFactory() {
        return XSLFFactory.getInstance();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartRelation() {
        return XSLFRelation.CHART;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartWorkbookRelation() {
        return XSLFRelation.WORKBOOK;
    }

    public XSLFTextShape getTitleShape() {
        if (!getCTChart().isSetTitle()) {
            getCTChart().addNewTitle();
        }
        final CTTitle title = getCTChart().getTitle();
        XSLFSheet xSLFSheet = null;
        return (title.getTx() == null || !title.getTx().isSetRich()) ? new XSLFTextShape(title, xSLFSheet) { // from class: org.apache.poi.xslf.usermodel.XSLFChart.2
            @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
            public CTTextBody getTextBody(boolean z6) {
                return title.getTxPr();
            }
        } : new XSLFTextShape(title, xSLFSheet) { // from class: org.apache.poi.xslf.usermodel.XSLFChart.1
            @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
            public CTTextBody getTextBody(boolean z6) {
                return title.getTx().getRich();
            }
        };
    }

    public XSLFChart(PackagePart packagePart) {
        super(packagePart);
    }
}

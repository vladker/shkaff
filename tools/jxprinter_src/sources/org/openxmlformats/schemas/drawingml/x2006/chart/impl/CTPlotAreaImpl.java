package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import k5.C1070k0;
import k5.C1074m0;
import k5.n0;
import k5.o0;
import k5.p0;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTArea3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDTable;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLine3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPie3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStockChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTPlotAreaImpl extends XmlComplexContentImpl implements CTPlotArea {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_CHART, "layout"), new QName(XSSFRelation.NS_CHART, "areaChart"), new QName(XSSFRelation.NS_CHART, "area3DChart"), new QName(XSSFRelation.NS_CHART, "lineChart"), new QName(XSSFRelation.NS_CHART, "line3DChart"), new QName(XSSFRelation.NS_CHART, "stockChart"), new QName(XSSFRelation.NS_CHART, "radarChart"), new QName(XSSFRelation.NS_CHART, "scatterChart"), new QName(XSSFRelation.NS_CHART, "pieChart"), new QName(XSSFRelation.NS_CHART, "pie3DChart"), new QName(XSSFRelation.NS_CHART, "doughnutChart"), new QName(XSSFRelation.NS_CHART, "barChart"), new QName(XSSFRelation.NS_CHART, "bar3DChart"), new QName(XSSFRelation.NS_CHART, "ofPieChart"), new QName(XSSFRelation.NS_CHART, "surfaceChart"), new QName(XSSFRelation.NS_CHART, "surface3DChart"), new QName(XSSFRelation.NS_CHART, "bubbleChart"), new QName(XSSFRelation.NS_CHART, "valAx"), new QName(XSSFRelation.NS_CHART, "catAx"), new QName(XSSFRelation.NS_CHART, "dateAx"), new QName(XSSFRelation.NS_CHART, "serAx"), new QName(XSSFRelation.NS_CHART, "dTable"), new QName(XSSFRelation.NS_CHART, "spPr"), new QName(XSSFRelation.NS_CHART, "extLst")};
    private static final long serialVersionUID = 1;

    public CTPlotAreaImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart addNewArea3DChart() {
        CTArea3DChart cTArea3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChart = (CTArea3DChart) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTArea3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart addNewAreaChart() {
        CTAreaChart cTAreaChart;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChart = (CTAreaChart) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAreaChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart addNewBar3DChart() {
        CTBar3DChart cTBar3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChart = (CTBar3DChart) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTBar3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart addNewBarChart() {
        CTBarChart cTBarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChart = (CTBarChart) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart addNewBubbleChart() {
        CTBubbleChart cTBubbleChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChart = (CTBubbleChart) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTBubbleChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx addNewCatAx() {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDTable addNewDTable() {
        CTDTable cTDTableAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDTableAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTDTableAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx addNewDateAx() {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart addNewDoughnutChart() {
        CTDoughnutChart cTDoughnutChart;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChart = (CTDoughnutChart) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTDoughnutChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLayout addNewLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart addNewLine3DChart() {
        CTLine3DChart cTLine3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChart = (CTLine3DChart) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTLine3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart addNewLineChart() {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart addNewOfPieChart() {
        CTOfPieChart cTOfPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChart = (CTOfPieChart) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTOfPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart addNewPie3DChart() {
        CTPie3DChart cTPie3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChart = (CTPie3DChart) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTPie3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart addNewPieChart() {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart addNewRadarChart() {
        CTRadarChart cTRadarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChart = (CTRadarChart) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTRadarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart addNewScatterChart() {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx addNewSerAx() {
        CTSerAx cTSerAx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAx = (CTSerAx) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTSerAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart addNewStockChart() {
        CTStockChart cTStockChartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTStockChartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart addNewSurface3DChart() {
        CTSurface3DChart cTSurface3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChart = (CTSurface3DChart) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTSurface3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart addNewSurfaceChart() {
        CTSurfaceChart cTSurfaceChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChart = (CTSurfaceChart) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTSurfaceChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx addNewValAx() {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart[] getArea3DChartArray() {
        return (CTArea3DChart[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTArea3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTArea3DChart> getArea3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p0(this, 4), new o0(this, 16), new p0(this, 5), new C1074m0(this, 16), new n0(this, 16));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart[] getAreaChartArray() {
        return (CTAreaChart[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTAreaChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTAreaChart> getAreaChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p0(this, 6), new o0(this, 17), new p0(this, 7), new C1074m0(this, 18), new n0(this, 17));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart[] getBar3DChartArray() {
        return (CTBar3DChart[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTBar3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBar3DChart> getBar3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 3), new o0(this, 0), new C1070k0(this, 4), new C1074m0(this, 1), new n0(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart[] getBarChartArray() {
        return (CTBarChart[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTBarChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBarChart> getBarChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 29), new o0(this, 14), new p0(this, 0), new C1074m0(this, 14), new n0(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart[] getBubbleChartArray() {
        return (CTBubbleChart[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTBubbleChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTBubbleChart> getBubbleChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 0), new o0(this, 1), new C1070k0(this, 9), new C1074m0(this, 6), new n0(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx[] getCatAxArray() {
        return (CTCatAx[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTCatAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTCatAx> getCatAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 7), new o0(this, 3), new C1070k0(this, 8), new C1074m0(this, 3), new n0(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDTable getDTable() {
        CTDTable cTDTableFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDTableFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], 0);
            if (cTDTableFind_element_user == null) {
                cTDTableFind_element_user = null;
            }
        }
        return cTDTableFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx[] getDateAxArray() {
        return (CTDateAx[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTDateAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTDateAx> getDateAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 18), new o0(this, 8), new C1070k0(this, 19), new C1074m0(this, 9), new n0(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart[] getDoughnutChartArray() {
        return (CTDoughnutChart[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTDoughnutChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTDoughnutChart> getDoughnutChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 22), new o0(this, 12), new p0(this, 1), new C1074m0(this, 17), new n0(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[23], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLayout getLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTLayout == null) {
                cTLayout = null;
            }
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart[] getLine3DChartArray() {
        return (CTLine3DChart[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTLine3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTLine3DChart> getLine3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 20), new o0(this, 9), new C1070k0(this, 21), new C1074m0(this, 10), new n0(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart[] getLineChartArray() {
        return (CTLineChart[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTLineChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTLineChart> getLineChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 14), new o0(this, 6), new C1070k0(this, 15), new C1074m0(this, 7), new n0(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart[] getOfPieChartArray() {
        return (CTOfPieChart[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTOfPieChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTOfPieChart> getOfPieChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 27), new o0(this, 13), new C1070k0(this, 28), new C1074m0(this, 13), new n0(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart[] getPie3DChartArray() {
        return (CTPie3DChart[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTPie3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTPie3DChart> getPie3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 16), new o0(this, 7), new C1070k0(this, 17), new C1074m0(this, 8), new n0(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart[] getPieChartArray() {
        return (CTPieChart[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTPieChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTPieChart> getPieChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p0(this, 2), new o0(this, 15), new p0(this, 3), new C1074m0(this, 15), new n0(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart[] getRadarChartArray() {
        return (CTRadarChart[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTRadarChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTRadarChart> getRadarChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 12), new o0(this, 5), new C1070k0(this, 13), new C1074m0(this, 5), new n0(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart[] getScatterChartArray() {
        return (CTScatterChart[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTScatterChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTScatterChart> getScatterChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 25), new o0(this, 11), new C1070k0(this, 26), new C1074m0(this, 12), new n0(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx[] getSerAxArray() {
        return (CTSerAx[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTSerAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSerAx> getSerAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new p0(this, 8), new o0(this, 18), new p0(this, 9), new C1074m0(this, 19), new n0(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTShapeProperties getSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().find_element_user(PROPERTY_QNAME[22], 0);
            if (cTShapeProperties == null) {
                cTShapeProperties = null;
            }
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart[] getStockChartArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTStockChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTStockChart> getStockChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 1), new BiConsumer() { // from class: k5.l0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5656a.setStockChartArray(((Integer) obj).intValue(), (CTStockChart) obj2);
                }
            }, new C1070k0(this, 2), new C1074m0(this, 0), new n0(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart[] getSurface3DChartArray() {
        return (CTSurface3DChart[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTSurface3DChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSurface3DChart> getSurface3DChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 23), new o0(this, 10), new C1070k0(this, 24), new C1074m0(this, 11), new n0(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart[] getSurfaceChartArray() {
        return (CTSurfaceChart[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTSurfaceChart[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTSurfaceChart> getSurfaceChartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 10), new o0(this, 4), new C1070k0(this, 11), new C1074m0(this, 4), new n0(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx[] getValAxArray() {
        return (CTValAx[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTValAx[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public List<CTValAx> getValAxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1070k0(this, 5), new o0(this, 2), new C1070k0(this, 6), new C1074m0(this, 2), new n0(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart insertNewArea3DChart(int i5) {
        CTArea3DChart cTArea3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTArea3DChart = (CTArea3DChart) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTArea3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart insertNewAreaChart(int i5) {
        CTAreaChart cTAreaChart;
        synchronized (monitor()) {
            check_orphaned();
            cTAreaChart = (CTAreaChart) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTAreaChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart insertNewBar3DChart(int i5) {
        CTBar3DChart cTBar3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBar3DChart = (CTBar3DChart) get_store().insert_element_user(PROPERTY_QNAME[12], i5);
        }
        return cTBar3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart insertNewBarChart(int i5) {
        CTBarChart cTBarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBarChart = (CTBarChart) get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return cTBarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart insertNewBubbleChart(int i5) {
        CTBubbleChart cTBubbleChart;
        synchronized (monitor()) {
            check_orphaned();
            cTBubbleChart = (CTBubbleChart) get_store().insert_element_user(PROPERTY_QNAME[16], i5);
        }
        return cTBubbleChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx insertNewCatAx(int i5) {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            check_orphaned();
            cTCatAx = (CTCatAx) get_store().insert_element_user(PROPERTY_QNAME[18], i5);
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx insertNewDateAx(int i5) {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            check_orphaned();
            cTDateAx = (CTDateAx) get_store().insert_element_user(PROPERTY_QNAME[19], i5);
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart insertNewDoughnutChart(int i5) {
        CTDoughnutChart cTDoughnutChart;
        synchronized (monitor()) {
            check_orphaned();
            cTDoughnutChart = (CTDoughnutChart) get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return cTDoughnutChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart insertNewLine3DChart(int i5) {
        CTLine3DChart cTLine3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLine3DChart = (CTLine3DChart) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTLine3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart insertNewLineChart(int i5) {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            check_orphaned();
            cTLineChart = (CTLineChart) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart insertNewOfPieChart(int i5) {
        CTOfPieChart cTOfPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTOfPieChart = (CTOfPieChart) get_store().insert_element_user(PROPERTY_QNAME[13], i5);
        }
        return cTOfPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart insertNewPie3DChart(int i5) {
        CTPie3DChart cTPie3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPie3DChart = (CTPie3DChart) get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return cTPie3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart insertNewPieChart(int i5) {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            check_orphaned();
            cTPieChart = (CTPieChart) get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart insertNewRadarChart(int i5) {
        CTRadarChart cTRadarChart;
        synchronized (monitor()) {
            check_orphaned();
            cTRadarChart = (CTRadarChart) get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return cTRadarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart insertNewScatterChart(int i5) {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            check_orphaned();
            cTScatterChart = (CTScatterChart) get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx insertNewSerAx(int i5) {
        CTSerAx cTSerAx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerAx = (CTSerAx) get_store().insert_element_user(PROPERTY_QNAME[20], i5);
        }
        return cTSerAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart insertNewStockChart(int i5) {
        CTStockChart cTStockChartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStockChartInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return cTStockChartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart insertNewSurface3DChart(int i5) {
        CTSurface3DChart cTSurface3DChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface3DChart = (CTSurface3DChart) get_store().insert_element_user(PROPERTY_QNAME[15], i5);
        }
        return cTSurface3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart insertNewSurfaceChart(int i5) {
        CTSurfaceChart cTSurfaceChart;
        synchronized (monitor()) {
            check_orphaned();
            cTSurfaceChart = (CTSurfaceChart) get_store().insert_element_user(PROPERTY_QNAME[14], i5);
        }
        return cTSurfaceChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx insertNewValAx(int i5) {
        CTValAx cTValAx;
        synchronized (monitor()) {
            check_orphaned();
            cTValAx = (CTValAx) get_store().insert_element_user(PROPERTY_QNAME[17], i5);
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetDTable() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[21]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[23]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetLayout() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public boolean isSetSpPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[22]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeArea3DChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeAreaChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBar3DChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBarChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeBubbleChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeCatAx(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeDateAx(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeDoughnutChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeLine3DChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeLineChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeOfPieChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removePie3DChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removePieChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeRadarChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeScatterChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSerAx(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeStockChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSurface3DChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeSurfaceChart(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void removeValAx(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setArea3DChartArray(CTArea3DChart[] cTArea3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTArea3DChartArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setAreaChartArray(CTAreaChart[] cTAreaChartArr) {
        check_orphaned();
        arraySetterHelper(cTAreaChartArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBar3DChartArray(CTBar3DChart[] cTBar3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTBar3DChartArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBarChartArray(CTBarChart[] cTBarChartArr) {
        check_orphaned();
        arraySetterHelper(cTBarChartArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBubbleChartArray(CTBubbleChart[] cTBubbleChartArr) {
        check_orphaned();
        arraySetterHelper(cTBubbleChartArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setCatAxArray(CTCatAx[] cTCatAxArr) {
        check_orphaned();
        arraySetterHelper(cTCatAxArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDTable(CTDTable cTDTable) {
        generatedSetterHelperImpl(cTDTable, PROPERTY_QNAME[21], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDateAxArray(CTDateAx[] cTDateAxArr) {
        check_orphaned();
        arraySetterHelper(cTDateAxArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDoughnutChartArray(CTDoughnutChart[] cTDoughnutChartArr) {
        check_orphaned();
        arraySetterHelper(cTDoughnutChartArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setExtLst(CTExtensionList cTExtensionList) {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[23], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLayout(CTLayout cTLayout) {
        generatedSetterHelperImpl(cTLayout, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLine3DChartArray(CTLine3DChart[] cTLine3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTLine3DChartArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLineChartArray(CTLineChart[] cTLineChartArr) {
        check_orphaned();
        arraySetterHelper(cTLineChartArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setOfPieChartArray(CTOfPieChart[] cTOfPieChartArr) {
        check_orphaned();
        arraySetterHelper(cTOfPieChartArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPie3DChartArray(CTPie3DChart[] cTPie3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTPie3DChartArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPieChartArray(CTPieChart[] cTPieChartArr) {
        check_orphaned();
        arraySetterHelper(cTPieChartArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setRadarChartArray(CTRadarChart[] cTRadarChartArr) {
        check_orphaned();
        arraySetterHelper(cTRadarChartArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setScatterChartArray(CTScatterChart[] cTScatterChartArr) {
        check_orphaned();
        arraySetterHelper(cTScatterChartArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSerAxArray(CTSerAx[] cTSerAxArr) {
        check_orphaned();
        arraySetterHelper(cTSerAxArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[22], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setStockChartArray(CTStockChart[] cTStockChartArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTStockChartArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurface3DChartArray(CTSurface3DChart[] cTSurface3DChartArr) {
        check_orphaned();
        arraySetterHelper(cTSurface3DChartArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurfaceChartArray(CTSurfaceChart[] cTSurfaceChartArr) {
        check_orphaned();
        arraySetterHelper(cTSurfaceChartArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setValAxArray(CTValAx[] cTValAxArr) {
        check_orphaned();
        arraySetterHelper(cTValAxArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfArea3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfAreaChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBar3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBarChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfBubbleChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfCatAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfDateAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfDoughnutChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfLine3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfLineChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfOfPieChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfPie3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfPieChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfRadarChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfScatterChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSerAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfStockChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSurface3DChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfSurfaceChartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public int sizeOfValAxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetDTable() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTArea3DChart getArea3DChartArray(int i5) {
        CTArea3DChart cTArea3DChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTArea3DChart = (CTArea3DChart) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTArea3DChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTArea3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTAreaChart getAreaChartArray(int i5) {
        CTAreaChart cTAreaChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAreaChart = (CTAreaChart) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTAreaChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAreaChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBar3DChart getBar3DChartArray(int i5) {
        CTBar3DChart cTBar3DChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBar3DChart = (CTBar3DChart) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (cTBar3DChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBar3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBarChart getBarChartArray(int i5) {
        CTBarChart cTBarChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBarChart = (CTBarChart) get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (cTBarChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTBubbleChart getBubbleChartArray(int i5) {
        CTBubbleChart cTBubbleChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBubbleChart = (CTBubbleChart) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (cTBubbleChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBubbleChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTCatAx getCatAxArray(int i5) {
        CTCatAx cTCatAx;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCatAx = (CTCatAx) get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (cTCatAx == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCatAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDateAx getDateAxArray(int i5) {
        CTDateAx cTDateAx;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDateAx = (CTDateAx) get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (cTDateAx == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDateAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTDoughnutChart getDoughnutChartArray(int i5) {
        CTDoughnutChart cTDoughnutChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDoughnutChart = (CTDoughnutChart) get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (cTDoughnutChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDoughnutChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLine3DChart getLine3DChartArray(int i5) {
        CTLine3DChart cTLine3DChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLine3DChart = (CTLine3DChart) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTLine3DChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLine3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTLineChart getLineChartArray(int i5) {
        CTLineChart cTLineChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLineChart = (CTLineChart) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTLineChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLineChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTOfPieChart getOfPieChartArray(int i5) {
        CTOfPieChart cTOfPieChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOfPieChart = (CTOfPieChart) get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (cTOfPieChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOfPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPie3DChart getPie3DChartArray(int i5) {
        CTPie3DChart cTPie3DChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPie3DChart = (CTPie3DChart) get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (cTPie3DChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPie3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTPieChart getPieChartArray(int i5) {
        CTPieChart cTPieChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPieChart = (CTPieChart) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (cTPieChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPieChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTRadarChart getRadarChartArray(int i5) {
        CTRadarChart cTRadarChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRadarChart = (CTRadarChart) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (cTRadarChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRadarChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTScatterChart getScatterChartArray(int i5) {
        CTScatterChart cTScatterChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTScatterChart = (CTScatterChart) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTScatterChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTScatterChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSerAx getSerAxArray(int i5) {
        CTSerAx cTSerAx;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSerAx = (CTSerAx) get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (cTSerAx == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSerAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTStockChart getStockChartArray(int i5) {
        CTStockChart cTStockChartFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTStockChartFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (cTStockChartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTStockChartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurface3DChart getSurface3DChartArray(int i5) {
        CTSurface3DChart cTSurface3DChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSurface3DChart = (CTSurface3DChart) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (cTSurface3DChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSurface3DChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTSurfaceChart getSurfaceChartArray(int i5) {
        CTSurfaceChart cTSurfaceChart;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSurfaceChart = (CTSurfaceChart) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (cTSurfaceChart == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSurfaceChart;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public CTValAx getValAxArray(int i5) {
        CTValAx cTValAx;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTValAx = (CTValAx) get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (cTValAx == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTValAx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setArea3DChartArray(int i5, CTArea3DChart cTArea3DChart) {
        generatedSetterHelperImpl(cTArea3DChart, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setAreaChartArray(int i5, CTAreaChart cTAreaChart) {
        generatedSetterHelperImpl(cTAreaChart, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBar3DChartArray(int i5, CTBar3DChart cTBar3DChart) {
        generatedSetterHelperImpl(cTBar3DChart, PROPERTY_QNAME[12], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBarChartArray(int i5, CTBarChart cTBarChart) {
        generatedSetterHelperImpl(cTBarChart, PROPERTY_QNAME[11], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setBubbleChartArray(int i5, CTBubbleChart cTBubbleChart) {
        generatedSetterHelperImpl(cTBubbleChart, PROPERTY_QNAME[16], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setCatAxArray(int i5, CTCatAx cTCatAx) {
        generatedSetterHelperImpl(cTCatAx, PROPERTY_QNAME[18], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDateAxArray(int i5, CTDateAx cTDateAx) {
        generatedSetterHelperImpl(cTDateAx, PROPERTY_QNAME[19], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setDoughnutChartArray(int i5, CTDoughnutChart cTDoughnutChart) {
        generatedSetterHelperImpl(cTDoughnutChart, PROPERTY_QNAME[10], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLine3DChartArray(int i5, CTLine3DChart cTLine3DChart) {
        generatedSetterHelperImpl(cTLine3DChart, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setLineChartArray(int i5, CTLineChart cTLineChart) {
        generatedSetterHelperImpl(cTLineChart, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setOfPieChartArray(int i5, CTOfPieChart cTOfPieChart) {
        generatedSetterHelperImpl(cTOfPieChart, PROPERTY_QNAME[13], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPie3DChartArray(int i5, CTPie3DChart cTPie3DChart) {
        generatedSetterHelperImpl(cTPie3DChart, PROPERTY_QNAME[9], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setPieChartArray(int i5, CTPieChart cTPieChart) {
        generatedSetterHelperImpl(cTPieChart, PROPERTY_QNAME[8], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setRadarChartArray(int i5, CTRadarChart cTRadarChart) {
        generatedSetterHelperImpl(cTRadarChart, PROPERTY_QNAME[6], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setScatterChartArray(int i5, CTScatterChart cTScatterChart) {
        generatedSetterHelperImpl(cTScatterChart, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSerAxArray(int i5, CTSerAx cTSerAx) {
        generatedSetterHelperImpl(cTSerAx, PROPERTY_QNAME[20], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setStockChartArray(int i5, CTStockChart cTStockChart) {
        generatedSetterHelperImpl(cTStockChart, PROPERTY_QNAME[5], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurface3DChartArray(int i5, CTSurface3DChart cTSurface3DChart) {
        generatedSetterHelperImpl(cTSurface3DChart, PROPERTY_QNAME[15], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setSurfaceChartArray(int i5, CTSurfaceChart cTSurfaceChart) {
        generatedSetterHelperImpl(cTSurfaceChart, PROPERTY_QNAME[14], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea
    public void setValAxArray(int i5, CTValAx cTValAx) {
        generatedSetterHelperImpl(cTValAx, PROPERTY_QNAME[17], i5, (short) 2);
    }
}

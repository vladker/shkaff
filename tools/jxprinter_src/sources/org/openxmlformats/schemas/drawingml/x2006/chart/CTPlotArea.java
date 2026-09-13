package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPlotArea extends XmlObject {
    public static final DocumentFactory<CTPlotArea> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPlotArea> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctplotarea106etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTArea3DChart addNewArea3DChart();

    CTAreaChart addNewAreaChart();

    CTBar3DChart addNewBar3DChart();

    CTBarChart addNewBarChart();

    CTBubbleChart addNewBubbleChart();

    CTCatAx addNewCatAx();

    CTDTable addNewDTable();

    CTDateAx addNewDateAx();

    CTDoughnutChart addNewDoughnutChart();

    CTExtensionList addNewExtLst();

    CTLayout addNewLayout();

    CTLine3DChart addNewLine3DChart();

    CTLineChart addNewLineChart();

    CTOfPieChart addNewOfPieChart();

    CTPie3DChart addNewPie3DChart();

    CTPieChart addNewPieChart();

    CTRadarChart addNewRadarChart();

    CTScatterChart addNewScatterChart();

    CTSerAx addNewSerAx();

    CTShapeProperties addNewSpPr();

    CTStockChart addNewStockChart();

    CTSurface3DChart addNewSurface3DChart();

    CTSurfaceChart addNewSurfaceChart();

    CTValAx addNewValAx();

    CTArea3DChart getArea3DChartArray(int i5);

    CTArea3DChart[] getArea3DChartArray();

    List<CTArea3DChart> getArea3DChartList();

    CTAreaChart getAreaChartArray(int i5);

    CTAreaChart[] getAreaChartArray();

    List<CTAreaChart> getAreaChartList();

    CTBar3DChart getBar3DChartArray(int i5);

    CTBar3DChart[] getBar3DChartArray();

    List<CTBar3DChart> getBar3DChartList();

    CTBarChart getBarChartArray(int i5);

    CTBarChart[] getBarChartArray();

    List<CTBarChart> getBarChartList();

    CTBubbleChart getBubbleChartArray(int i5);

    CTBubbleChart[] getBubbleChartArray();

    List<CTBubbleChart> getBubbleChartList();

    CTCatAx getCatAxArray(int i5);

    CTCatAx[] getCatAxArray();

    List<CTCatAx> getCatAxList();

    CTDTable getDTable();

    CTDateAx getDateAxArray(int i5);

    CTDateAx[] getDateAxArray();

    List<CTDateAx> getDateAxList();

    CTDoughnutChart getDoughnutChartArray(int i5);

    CTDoughnutChart[] getDoughnutChartArray();

    List<CTDoughnutChart> getDoughnutChartList();

    CTExtensionList getExtLst();

    CTLayout getLayout();

    CTLine3DChart getLine3DChartArray(int i5);

    CTLine3DChart[] getLine3DChartArray();

    List<CTLine3DChart> getLine3DChartList();

    CTLineChart getLineChartArray(int i5);

    CTLineChart[] getLineChartArray();

    List<CTLineChart> getLineChartList();

    CTOfPieChart getOfPieChartArray(int i5);

    CTOfPieChart[] getOfPieChartArray();

    List<CTOfPieChart> getOfPieChartList();

    CTPie3DChart getPie3DChartArray(int i5);

    CTPie3DChart[] getPie3DChartArray();

    List<CTPie3DChart> getPie3DChartList();

    CTPieChart getPieChartArray(int i5);

    CTPieChart[] getPieChartArray();

    List<CTPieChart> getPieChartList();

    CTRadarChart getRadarChartArray(int i5);

    CTRadarChart[] getRadarChartArray();

    List<CTRadarChart> getRadarChartList();

    CTScatterChart getScatterChartArray(int i5);

    CTScatterChart[] getScatterChartArray();

    List<CTScatterChart> getScatterChartList();

    CTSerAx getSerAxArray(int i5);

    CTSerAx[] getSerAxArray();

    List<CTSerAx> getSerAxList();

    CTShapeProperties getSpPr();

    CTStockChart getStockChartArray(int i5);

    CTStockChart[] getStockChartArray();

    List<CTStockChart> getStockChartList();

    CTSurface3DChart getSurface3DChartArray(int i5);

    CTSurface3DChart[] getSurface3DChartArray();

    List<CTSurface3DChart> getSurface3DChartList();

    CTSurfaceChart getSurfaceChartArray(int i5);

    CTSurfaceChart[] getSurfaceChartArray();

    List<CTSurfaceChart> getSurfaceChartList();

    CTValAx getValAxArray(int i5);

    CTValAx[] getValAxArray();

    List<CTValAx> getValAxList();

    CTArea3DChart insertNewArea3DChart(int i5);

    CTAreaChart insertNewAreaChart(int i5);

    CTBar3DChart insertNewBar3DChart(int i5);

    CTBarChart insertNewBarChart(int i5);

    CTBubbleChart insertNewBubbleChart(int i5);

    CTCatAx insertNewCatAx(int i5);

    CTDateAx insertNewDateAx(int i5);

    CTDoughnutChart insertNewDoughnutChart(int i5);

    CTLine3DChart insertNewLine3DChart(int i5);

    CTLineChart insertNewLineChart(int i5);

    CTOfPieChart insertNewOfPieChart(int i5);

    CTPie3DChart insertNewPie3DChart(int i5);

    CTPieChart insertNewPieChart(int i5);

    CTRadarChart insertNewRadarChart(int i5);

    CTScatterChart insertNewScatterChart(int i5);

    CTSerAx insertNewSerAx(int i5);

    CTStockChart insertNewStockChart(int i5);

    CTSurface3DChart insertNewSurface3DChart(int i5);

    CTSurfaceChart insertNewSurfaceChart(int i5);

    CTValAx insertNewValAx(int i5);

    boolean isSetDTable();

    boolean isSetExtLst();

    boolean isSetLayout();

    boolean isSetSpPr();

    void removeArea3DChart(int i5);

    void removeAreaChart(int i5);

    void removeBar3DChart(int i5);

    void removeBarChart(int i5);

    void removeBubbleChart(int i5);

    void removeCatAx(int i5);

    void removeDateAx(int i5);

    void removeDoughnutChart(int i5);

    void removeLine3DChart(int i5);

    void removeLineChart(int i5);

    void removeOfPieChart(int i5);

    void removePie3DChart(int i5);

    void removePieChart(int i5);

    void removeRadarChart(int i5);

    void removeScatterChart(int i5);

    void removeSerAx(int i5);

    void removeStockChart(int i5);

    void removeSurface3DChart(int i5);

    void removeSurfaceChart(int i5);

    void removeValAx(int i5);

    void setArea3DChartArray(int i5, CTArea3DChart cTArea3DChart);

    void setArea3DChartArray(CTArea3DChart[] cTArea3DChartArr);

    void setAreaChartArray(int i5, CTAreaChart cTAreaChart);

    void setAreaChartArray(CTAreaChart[] cTAreaChartArr);

    void setBar3DChartArray(int i5, CTBar3DChart cTBar3DChart);

    void setBar3DChartArray(CTBar3DChart[] cTBar3DChartArr);

    void setBarChartArray(int i5, CTBarChart cTBarChart);

    void setBarChartArray(CTBarChart[] cTBarChartArr);

    void setBubbleChartArray(int i5, CTBubbleChart cTBubbleChart);

    void setBubbleChartArray(CTBubbleChart[] cTBubbleChartArr);

    void setCatAxArray(int i5, CTCatAx cTCatAx);

    void setCatAxArray(CTCatAx[] cTCatAxArr);

    void setDTable(CTDTable cTDTable);

    void setDateAxArray(int i5, CTDateAx cTDateAx);

    void setDateAxArray(CTDateAx[] cTDateAxArr);

    void setDoughnutChartArray(int i5, CTDoughnutChart cTDoughnutChart);

    void setDoughnutChartArray(CTDoughnutChart[] cTDoughnutChartArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setLayout(CTLayout cTLayout);

    void setLine3DChartArray(int i5, CTLine3DChart cTLine3DChart);

    void setLine3DChartArray(CTLine3DChart[] cTLine3DChartArr);

    void setLineChartArray(int i5, CTLineChart cTLineChart);

    void setLineChartArray(CTLineChart[] cTLineChartArr);

    void setOfPieChartArray(int i5, CTOfPieChart cTOfPieChart);

    void setOfPieChartArray(CTOfPieChart[] cTOfPieChartArr);

    void setPie3DChartArray(int i5, CTPie3DChart cTPie3DChart);

    void setPie3DChartArray(CTPie3DChart[] cTPie3DChartArr);

    void setPieChartArray(int i5, CTPieChart cTPieChart);

    void setPieChartArray(CTPieChart[] cTPieChartArr);

    void setRadarChartArray(int i5, CTRadarChart cTRadarChart);

    void setRadarChartArray(CTRadarChart[] cTRadarChartArr);

    void setScatterChartArray(int i5, CTScatterChart cTScatterChart);

    void setScatterChartArray(CTScatterChart[] cTScatterChartArr);

    void setSerAxArray(int i5, CTSerAx cTSerAx);

    void setSerAxArray(CTSerAx[] cTSerAxArr);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStockChartArray(int i5, CTStockChart cTStockChart);

    void setStockChartArray(CTStockChart[] cTStockChartArr);

    void setSurface3DChartArray(int i5, CTSurface3DChart cTSurface3DChart);

    void setSurface3DChartArray(CTSurface3DChart[] cTSurface3DChartArr);

    void setSurfaceChartArray(int i5, CTSurfaceChart cTSurfaceChart);

    void setSurfaceChartArray(CTSurfaceChart[] cTSurfaceChartArr);

    void setValAxArray(int i5, CTValAx cTValAx);

    void setValAxArray(CTValAx[] cTValAxArr);

    int sizeOfArea3DChartArray();

    int sizeOfAreaChartArray();

    int sizeOfBar3DChartArray();

    int sizeOfBarChartArray();

    int sizeOfBubbleChartArray();

    int sizeOfCatAxArray();

    int sizeOfDateAxArray();

    int sizeOfDoughnutChartArray();

    int sizeOfLine3DChartArray();

    int sizeOfLineChartArray();

    int sizeOfOfPieChartArray();

    int sizeOfPie3DChartArray();

    int sizeOfPieChartArray();

    int sizeOfRadarChartArray();

    int sizeOfScatterChartArray();

    int sizeOfSerAxArray();

    int sizeOfStockChartArray();

    int sizeOfSurface3DChartArray();

    int sizeOfSurfaceChartArray();

    int sizeOfValAxArray();

    void unsetDTable();

    void unsetExtLst();

    void unsetLayout();

    void unsetSpPr();
}

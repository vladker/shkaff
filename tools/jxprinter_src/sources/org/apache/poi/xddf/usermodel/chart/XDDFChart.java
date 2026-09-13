package org.apache.poi.xddf.usermodel.chart;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XDDFChart extends POIXMLDocumentPart implements TextContainer {
    public static final int DEFAULT_HEIGHT = 500000;
    public static final int DEFAULT_WIDTH = 500000;
    public static final int DEFAULT_X = 10;
    public static final int DEFAULT_Y = 10;
    protected List<XDDFChartAxis> axes;
    private int chartIndex;
    protected final CTChartSpace chartSpace;
    private long seriesCount;
    private XSSFWorkbook workbook;

    /* JADX INFO: renamed from: org.apache.poi.xddf.usermodel.chart.XDDFChart$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes;

        static {
            int[] iArr = new int[ChartTypes.values().length];
            $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes = iArr;
            try {
                iArr[ChartTypes.AREA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.AREA3D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.BAR3D.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.DOUGHNUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.LINE3D.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.PIE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.PIE3D.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.RADAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.SCATTER.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.SURFACE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[ChartTypes.SURFACE3D.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public XDDFChart() {
        this.chartIndex = 0;
        this.axes = new ArrayList();
        this.seriesCount = 0L;
        CTChartSpace cTChartSpaceNewInstance = CTChartSpace.Factory.newInstance();
        this.chartSpace = cTChartSpaceNewInstance;
        cTChartSpaceNewInstance.addNewChart().addNewPlotArea();
    }

    private void addAxis(XDDFChartAxis xDDFChartAxis) {
        if (this.axes.size() == 1) {
            XDDFChartAxis xDDFChartAxis2 = this.axes.get(0);
            xDDFChartAxis2.crossAxis(xDDFChartAxis);
            xDDFChartAxis.crossAxis(xDDFChartAxis2);
            AxisCrosses axisCrosses = AxisCrosses.AUTO_ZERO;
            xDDFChartAxis2.setCrosses(axisCrosses);
            xDDFChartAxis.setCrosses(axisCrosses);
        }
        this.axes.add(xDDFChartAxis);
    }

    private PackagePart createWorksheetPart(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory) {
        PackageRelationship packageRelationshipCreateRelationshipInChart = createRelationshipInChart(pOIXMLRelation, pOIXMLFactory, this.chartIndex);
        setExternalId(packageRelationshipCreateRelationshipInChart.getId());
        return getTargetPart(packageRelationshipCreateRelationshipInChart);
    }

    private Map<Long, XDDFChartAxis> getCategoryAxes() {
        CTPlotArea cTPlotArea = getCTPlotArea();
        int iSizeOfCatAxArray = cTPlotArea.sizeOfCatAxArray();
        HashMap map = new HashMap(iSizeOfCatAxArray);
        for (int i5 = 0; i5 < iSizeOfCatAxArray; i5++) {
            CTCatAx catAxArray = cTPlotArea.getCatAxArray(i5);
            map.put(Long.valueOf(catAxArray.getAxId().getVal()), new XDDFCategoryAxis(catAxArray));
        }
        return map;
    }

    private XSSFCell getCell(XSSFRow xSSFRow, int i5) {
        XSSFCell cell = xSSFRow.getCell(i5);
        return cell == null ? xSSFRow.createCell(i5) : cell;
    }

    private XSSFRow getRow(XSSFSheet xSSFSheet, int i5) {
        XSSFRow row = xSSFSheet.getRow(i5);
        return row == null ? xSSFSheet.createRow(i5) : row;
    }

    private XSSFSheet getSheet() {
        try {
            return getWorkbook().getSheetAt(0);
        } catch (IOException | InvalidFormatException unused) {
            return null;
        }
    }

    private Map<Long, XDDFValueAxis> getValueAxes() {
        CTPlotArea cTPlotArea = getCTPlotArea();
        int iSizeOfValAxArray = cTPlotArea.sizeOfValAxArray();
        HashMap map = new HashMap(iSizeOfValAxArray);
        for (int i5 = 0; i5 < iSizeOfValAxArray; i5++) {
            CTValAx valAxArray = cTPlotArea.getValAxArray(i5);
            map.put(Long.valueOf(valAxArray.getAxId().getVal()), new XDDFValueAxis(valAxArray));
        }
        return map;
    }

    private PackagePart getWorksheetPart() {
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            if (POIXMLDocument.PACK_OBJECT_REL_TYPE.equals(relationPart.getRelationship().getRelationshipType())) {
                return getTargetPart(relationPart.getRelationship());
            }
        }
        return null;
    }

    private boolean hasAxes() {
        CTPlotArea cTPlotArea = getCTPlotArea();
        return cTPlotArea.sizeOfSerAxArray() + (cTPlotArea.sizeOfDateAxArray() + (cTPlotArea.sizeOfCatAxArray() + cTPlotArea.sizeOfValAxArray())) > 0;
    }

    private void parseAxes() {
        for (CTCatAx cTCatAx : getCTPlotArea().getCatAxArray()) {
            this.axes.add(new XDDFCategoryAxis(cTCatAx));
        }
        for (CTDateAx cTDateAx : getCTPlotArea().getDateAxArray()) {
            this.axes.add(new XDDFDateAxis(cTDateAx));
        }
        for (CTSerAx cTSerAx : getCTPlotArea().getSerAxArray()) {
            this.axes.add(new XDDFSeriesAxis(cTSerAx));
        }
        for (CTValAx cTValAx : getCTPlotArea().getValAxArray()) {
            this.axes.add(new XDDFValueAxis(cTValAx));
        }
    }

    private void setWorksheetPartCommitted() {
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            if (POIXMLDocument.PACK_OBJECT_REL_TYPE.equals(relationPart.getRelationship().getRelationshipType())) {
                relationPart.getDocumentPart().setCommitted(true);
                return;
            }
        }
    }

    public void clear() {
        this.axes.clear();
        this.seriesCount = 0L;
        XSSFWorkbook xSSFWorkbook = this.workbook;
        if (xSSFWorkbook != null) {
            xSSFWorkbook.removeSheetAt(0);
            this.workbook.createSheet();
        }
        getCTChart().set(CTChart.Factory.newInstance());
        getCTChart().addNewPlotArea();
    }

    public void clearChartSeries() {
        CTPlotArea cTPlotArea = getCTPlotArea();
        for (int iSizeOfAreaChartArray = cTPlotArea.sizeOfAreaChartArray(); iSizeOfAreaChartArray > 0; iSizeOfAreaChartArray--) {
            cTPlotArea.removeAreaChart(iSizeOfAreaChartArray - 1);
        }
        for (int iSizeOfArea3DChartArray = cTPlotArea.sizeOfArea3DChartArray(); iSizeOfArea3DChartArray > 0; iSizeOfArea3DChartArray--) {
            cTPlotArea.removeArea3DChart(iSizeOfArea3DChartArray - 1);
        }
        for (int iSizeOfBarChartArray = cTPlotArea.sizeOfBarChartArray(); iSizeOfBarChartArray > 0; iSizeOfBarChartArray--) {
            cTPlotArea.removeBarChart(iSizeOfBarChartArray - 1);
        }
        for (int iSizeOfBar3DChartArray = cTPlotArea.sizeOfBar3DChartArray(); iSizeOfBar3DChartArray > 0; iSizeOfBar3DChartArray--) {
            cTPlotArea.removeBar3DChart(iSizeOfBar3DChartArray - 1);
        }
        for (int iSizeOfBubbleChartArray = cTPlotArea.sizeOfBubbleChartArray(); iSizeOfBubbleChartArray > 0; iSizeOfBubbleChartArray--) {
            cTPlotArea.removeBubbleChart(iSizeOfBubbleChartArray - 1);
        }
        for (int iSizeOfDoughnutChartArray = cTPlotArea.sizeOfDoughnutChartArray(); iSizeOfDoughnutChartArray > 0; iSizeOfDoughnutChartArray--) {
            cTPlotArea.removeDoughnutChart(iSizeOfDoughnutChartArray - 1);
        }
        for (int iSizeOfLineChartArray = cTPlotArea.sizeOfLineChartArray(); iSizeOfLineChartArray > 0; iSizeOfLineChartArray--) {
            cTPlotArea.removeLineChart(iSizeOfLineChartArray - 1);
        }
        for (int iSizeOfLine3DChartArray = cTPlotArea.sizeOfLine3DChartArray(); iSizeOfLine3DChartArray > 0; iSizeOfLine3DChartArray--) {
            cTPlotArea.removeLine3DChart(iSizeOfLine3DChartArray - 1);
        }
        for (int iSizeOfOfPieChartArray = cTPlotArea.sizeOfOfPieChartArray(); iSizeOfOfPieChartArray > 0; iSizeOfOfPieChartArray--) {
            cTPlotArea.removeOfPieChart(iSizeOfOfPieChartArray - 1);
        }
        for (int iSizeOfPieChartArray = cTPlotArea.sizeOfPieChartArray(); iSizeOfPieChartArray > 0; iSizeOfPieChartArray--) {
            cTPlotArea.removePieChart(iSizeOfPieChartArray - 1);
        }
        for (int iSizeOfPie3DChartArray = cTPlotArea.sizeOfPie3DChartArray(); iSizeOfPie3DChartArray > 0; iSizeOfPie3DChartArray--) {
            cTPlotArea.removePie3DChart(iSizeOfPie3DChartArray - 1);
        }
        for (int iSizeOfRadarChartArray = cTPlotArea.sizeOfRadarChartArray(); iSizeOfRadarChartArray > 0; iSizeOfRadarChartArray--) {
            cTPlotArea.removeRadarChart(iSizeOfRadarChartArray - 1);
        }
        for (int iSizeOfScatterChartArray = cTPlotArea.sizeOfScatterChartArray(); iSizeOfScatterChartArray > 0; iSizeOfScatterChartArray--) {
            cTPlotArea.removeScatterChart(iSizeOfScatterChartArray - 1);
        }
        for (int iSizeOfStockChartArray = cTPlotArea.sizeOfStockChartArray(); iSizeOfStockChartArray > 0; iSizeOfStockChartArray--) {
            cTPlotArea.removeStockChart(iSizeOfStockChartArray - 1);
        }
        for (int iSizeOfSurfaceChartArray = cTPlotArea.sizeOfSurfaceChartArray(); iSizeOfSurfaceChartArray > 0; iSizeOfSurfaceChartArray--) {
            cTPlotArea.removeSurfaceChart(iSizeOfSurfaceChartArray - 1);
        }
        for (int iSizeOfSurface3DChartArray = cTPlotArea.sizeOfSurface3DChartArray(); iSizeOfSurface3DChartArray > 0; iSizeOfSurface3DChartArray--) {
            cTPlotArea.removeSurface3DChart(iSizeOfSurface3DChartArray - 1);
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        XSSFWorkbook xSSFWorkbook = this.workbook;
        if (xSSFWorkbook != null) {
            try {
                saveWorkbook(xSSFWorkbook);
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.chartSpace.save(outputStream, xmlOptions);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public XDDFCategoryAxis createCategoryAxis(AxisPosition axisPosition) {
        XDDFCategoryAxis xDDFCategoryAxis = new XDDFCategoryAxis(getCTPlotArea(), axisPosition);
        addAxis(xDDFCategoryAxis);
        return xDDFCategoryAxis;
    }

    public XDDFChartData createData(ChartTypes chartTypes, XDDFChartAxis xDDFChartAxis, XDDFValueAxis xDDFValueAxis) {
        Map mapSingletonMap;
        Map mapSingletonMap2;
        if (ChartTypes.PIE == chartTypes || ChartTypes.PIE3D == chartTypes || ChartTypes.DOUGHNUT == chartTypes) {
            mapSingletonMap = null;
            mapSingletonMap2 = null;
        } else {
            mapSingletonMap = Collections.singletonMap(Long.valueOf(xDDFChartAxis.getId()), xDDFChartAxis);
            mapSingletonMap2 = Collections.singletonMap(Long.valueOf(xDDFValueAxis.getId()), xDDFValueAxis);
        }
        CTPlotArea cTPlotArea = getCTPlotArea();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xddf$usermodel$chart$ChartTypes[chartTypes.ordinal()]) {
            case 1:
                return new XDDFAreaChartData(this, cTPlotArea.addNewAreaChart(), mapSingletonMap, mapSingletonMap2);
            case 2:
                return new XDDFArea3DChartData(this, cTPlotArea.addNewArea3DChart(), mapSingletonMap, mapSingletonMap2);
            case 3:
                return new XDDFBarChartData(this, cTPlotArea.addNewBarChart(), mapSingletonMap, mapSingletonMap2);
            case 4:
                return new XDDFBar3DChartData(this, cTPlotArea.addNewBar3DChart(), mapSingletonMap, mapSingletonMap2);
            case 5:
                return new XDDFDoughnutChartData(this, cTPlotArea.addNewDoughnutChart());
            case 6:
                return new XDDFLineChartData(this, cTPlotArea.addNewLineChart(), mapSingletonMap, mapSingletonMap2);
            case 7:
                return new XDDFLine3DChartData(this, cTPlotArea.addNewLine3DChart(), mapSingletonMap, mapSingletonMap2);
            case 8:
                return new XDDFPieChartData(this, cTPlotArea.addNewPieChart());
            case 9:
                return new XDDFPie3DChartData(this, cTPlotArea.addNewPie3DChart());
            case 10:
                return new XDDFRadarChartData(this, cTPlotArea.addNewRadarChart(), mapSingletonMap, mapSingletonMap2);
            case 11:
                return new XDDFScatterChartData(this, cTPlotArea.addNewScatterChart(), mapSingletonMap, mapSingletonMap2);
            case 12:
                return new XDDFSurfaceChartData(this, cTPlotArea.addNewSurfaceChart(), mapSingletonMap, mapSingletonMap2);
            case 13:
                return new XDDFSurface3DChartData(this, cTPlotArea.addNewSurface3DChart(), mapSingletonMap, mapSingletonMap2);
            default:
                return null;
        }
    }

    public XDDFDateAxis createDateAxis(AxisPosition axisPosition) {
        XDDFDateAxis xDDFDateAxis = new XDDFDateAxis(getCTPlotArea(), axisPosition);
        addAxis(xDDFDateAxis);
        return xDDFDateAxis;
    }

    public PackageRelationship createRelationshipInChart(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i5) {
        return addRelation(null, pOIXMLRelation, createRelationship(pOIXMLRelation, pOIXMLFactory, i5, true).getDocumentPart()).getRelationship();
    }

    public XDDFSeriesAxis createSeriesAxis(AxisPosition axisPosition) {
        XDDFSeriesAxis xDDFSeriesAxis = new XDDFSeriesAxis(getCTPlotArea(), axisPosition);
        addAxis(xDDFSeriesAxis);
        return xDDFSeriesAxis;
    }

    public XDDFValueAxis createValueAxis(AxisPosition axisPosition) {
        XDDFValueAxis xDDFValueAxis = new XDDFValueAxis(getCTPlotArea(), axisPosition);
        addAxis(xDDFValueAxis);
        return xDDFValueAxis;
    }

    public void deleteLegend() {
        if (getCTChart().isSetLegend()) {
            getCTChart().unsetLegend();
        }
    }

    public void deleteShapeProperties() {
        if (getCTPlotArea().isSetSpPr()) {
            getCTPlotArea().unsetSpPr();
        }
    }

    public void displayBlanksAs(DisplayBlanks displayBlanks) {
        if (displayBlanks == null) {
            if (getCTChart().isSetDispBlanksAs()) {
                getCTChart().unsetDispBlanksAs();
            }
        } else if (getCTChart().isSetDispBlanksAs()) {
            getCTChart().getDispBlanksAs().setVal(displayBlanks.underlying);
        } else {
            getCTChart().addNewDispBlanksAs().setVal(displayBlanks.underlying);
        }
    }

    public void fillSheet(XSSFSheet xSSFSheet, XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<?> xDDFNumericalDataSource) {
        int pointCount = xDDFDataSource.getPointCount();
        int i5 = 0;
        while (i5 < pointCount) {
            int i6 = i5 + 1;
            XSSFRow row = getRow(xSSFSheet, i6);
            Object pointAt = xDDFDataSource.getPointAt(i5);
            if (pointAt != null) {
                getCell(row, xDDFDataSource.getColIndex()).setCellValue(pointAt.toString());
            }
            Number number = (Number) xDDFNumericalDataSource.getPointAt(i5);
            if (number != null) {
                getCell(row, xDDFNumericalDataSource.getColIndex()).setCellValue(number.doubleValue());
            }
            i5 = i6;
        }
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function) {
        return Optional.empty();
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        return Optional.empty();
    }

    public String formatRange(CellRangeAddress cellRangeAddress) {
        XSSFSheet sheet = getSheet();
        if (sheet == null) {
            return null;
        }
        return cellRangeAddress.formatAsString(sheet.getSheetName(), true);
    }

    public List<? extends XDDFChartAxis> getAxes() {
        if (this.axes.isEmpty() && hasAxes()) {
            parseAxes();
        }
        return this.axes;
    }

    @Internal
    public CTChart getCTChart() {
        return this.chartSpace.getChart();
    }

    @Internal
    public CTChartSpace getCTChartSpace() {
        return this.chartSpace;
    }

    @Internal
    public CTPlotArea getCTPlotArea() {
        return getCTChart().getPlotArea();
    }

    public abstract POIXMLFactory getChartFactory();

    public int getChartIndex() {
        return this.chartIndex;
    }

    public abstract POIXMLRelation getChartRelation();

    public List<XDDFChartData> getChartSeries() {
        LinkedList linkedList = new LinkedList();
        CTPlotArea cTPlotArea = getCTPlotArea();
        Map<Long, XDDFChartAxis> categoryAxes = getCategoryAxes();
        Map<Long, XDDFValueAxis> valueAxes = getValueAxes();
        for (int i5 = 0; i5 < cTPlotArea.sizeOfAreaChartArray(); i5++) {
            linkedList.add(new XDDFAreaChartData(this, cTPlotArea.getAreaChartArray(i5), categoryAxes, valueAxes));
        }
        for (int i6 = 0; i6 < cTPlotArea.sizeOfArea3DChartArray(); i6++) {
            linkedList.add(new XDDFArea3DChartData(this, cTPlotArea.getArea3DChartArray(i6), categoryAxes, valueAxes));
        }
        for (int i7 = 0; i7 < cTPlotArea.sizeOfBarChartArray(); i7++) {
            linkedList.add(new XDDFBarChartData(this, cTPlotArea.getBarChartArray(i7), categoryAxes, valueAxes));
        }
        for (int i8 = 0; i8 < cTPlotArea.sizeOfBar3DChartArray(); i8++) {
            linkedList.add(new XDDFBar3DChartData(this, cTPlotArea.getBar3DChartArray(i8), categoryAxes, valueAxes));
        }
        for (int i9 = 0; i9 < cTPlotArea.sizeOfDoughnutChartArray(); i9++) {
            linkedList.add(new XDDFDoughnutChartData(this, cTPlotArea.getDoughnutChartArray(i9)));
        }
        for (int i10 = 0; i10 < cTPlotArea.sizeOfLineChartArray(); i10++) {
            linkedList.add(new XDDFLineChartData(this, cTPlotArea.getLineChartArray(i10), categoryAxes, valueAxes));
        }
        for (int i11 = 0; i11 < cTPlotArea.sizeOfLine3DChartArray(); i11++) {
            linkedList.add(new XDDFLine3DChartData(this, cTPlotArea.getLine3DChartArray(i11), categoryAxes, valueAxes));
        }
        for (int i12 = 0; i12 < cTPlotArea.sizeOfPieChartArray(); i12++) {
            linkedList.add(new XDDFPieChartData(this, cTPlotArea.getPieChartArray(i12)));
        }
        for (int i13 = 0; i13 < cTPlotArea.sizeOfPie3DChartArray(); i13++) {
            linkedList.add(new XDDFPie3DChartData(this, cTPlotArea.getPie3DChartArray(i13)));
        }
        for (int i14 = 0; i14 < cTPlotArea.sizeOfRadarChartArray(); i14++) {
            linkedList.add(new XDDFRadarChartData(this, cTPlotArea.getRadarChartArray(i14), categoryAxes, valueAxes));
        }
        for (int i15 = 0; i15 < cTPlotArea.sizeOfScatterChartArray(); i15++) {
            linkedList.add(new XDDFScatterChartData(this, cTPlotArea.getScatterChartArray(i15), categoryAxes, valueAxes));
        }
        for (int i16 = 0; i16 < cTPlotArea.sizeOfSurfaceChartArray(); i16++) {
            linkedList.add(new XDDFSurfaceChartData(this, cTPlotArea.getSurfaceChartArray(i16), categoryAxes, valueAxes));
        }
        for (int i17 = 0; i17 < cTPlotArea.sizeOfSurface3DChartArray(); i17++) {
            linkedList.add(new XDDFSurface3DChartData(this, cTPlotArea.getSurface3DChartArray(i17), categoryAxes, valueAxes));
        }
        this.seriesCount = linkedList.size();
        return linkedList;
    }

    public abstract POIXMLRelation getChartWorkbookRelation();

    public XDDFTextBody getFormattedTitle() {
        if (getCTChart().isSetTitle()) {
            return new XDDFTitle(this, getCTChart().getTitle()).getBody();
        }
        return null;
    }

    public XDDFChartLegend getOrAddLegend() {
        return new XDDFChartLegend(getCTChart());
    }

    public XDDFManualLayout getOrAddManualLayout() {
        return new XDDFManualLayout(getCTPlotArea());
    }

    public XDDFShapeProperties getOrAddShapeProperties() {
        CTPlotArea cTPlotArea = getCTPlotArea();
        return new XDDFShapeProperties(cTPlotArea.isSetSpPr() ? cTPlotArea.getSpPr() : cTPlotArea.addNewSpPr());
    }

    public XDDFView3D getOrAddView3D() {
        return new XDDFView3D(getCTChart().isSetView3D() ? getCTChart().getView3D() : getCTChart().addNewView3D());
    }

    public XDDFTitle getTitle() {
        if (getCTChart().isSetTitle()) {
            return new XDDFTitle(this, getCTChart().getTitle());
        }
        return null;
    }

    public Boolean getTitleOverlay() {
        if (!getCTChart().isSetTitle()) {
            return null;
        }
        CTTitle title = getCTChart().getTitle();
        if (title.isSetOverlay()) {
            return Boolean.valueOf(title.getOverlay().getVal());
        }
        return null;
    }

    public XSSFWorkbook getWorkbook() throws IOException {
        if (this.workbook == null) {
            try {
                PackagePart worksheetPart = getWorksheetPart();
                if (worksheetPart == null) {
                    XSSFWorkbook xSSFWorkbook = new XSSFWorkbook();
                    this.workbook = xSSFWorkbook;
                    xSSFWorkbook.createSheet();
                } else {
                    InputStream inputStream = worksheetPart.getInputStream();
                    try {
                        this.workbook = new XSSFWorkbook(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
            } catch (NotOfficeXmlFileException unused) {
                XSSFWorkbook xSSFWorkbook2 = new XSSFWorkbook();
                this.workbook = xSSFWorkbook2;
                xSSFWorkbook2.createSheet();
            }
        }
        return this.workbook;
    }

    public void importContent(XDDFChart xDDFChart) {
        getCTChartSpace().set(xDDFChart.getCTChartSpace());
    }

    public long incrementSeriesCount() {
        long j6 = this.seriesCount;
        this.seriesCount = 1 + j6;
        return j6;
    }

    public boolean isPlotOnlyVisibleCells() {
        if (getCTChart().isSetPlotVisOnly()) {
            return getCTChart().getPlotVisOnly().getVal();
        }
        return false;
    }

    public void plot(XDDFChartData xDDFChartData) {
        XSSFSheet sheet = getSheet();
        for (int i5 = 0; i5 < xDDFChartData.getSeriesCount(); i5++) {
            XDDFChartData.Series series = xDDFChartData.getSeries(i5);
            series.plot();
            XDDFDataSource<?> categoryData = series.getCategoryData();
            XDDFNumericalDataSource<? extends Number> valuesData = series.getValuesData();
            if (categoryData != null && !categoryData.isCellRange() && !categoryData.isLiteral() && valuesData != null && !valuesData.isCellRange() && !valuesData.isLiteral()) {
                fillSheet(sheet, categoryData, valuesData);
            }
        }
    }

    public void removeTitle() {
        setAutoTitleDeleted(true);
    }

    public void replaceReferences(XSSFSheet xSSFSheet) {
        XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource;
        Iterator<XDDFChartData> it = getChartSeries().iterator();
        while (it.hasNext()) {
            for (XDDFChartData.Series series : it.next().series) {
                XDDFDataSource<?> xDDFDataSourceFromNumericCellRange = series.categoryData;
                XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSourceFromNumericCellRange = series.valuesData;
                if (xDDFDataSourceFromNumericCellRange != null) {
                    try {
                        if (xDDFDataSourceFromNumericCellRange.isReference()) {
                            String dataRangeReference = series.categoryData.getDataRangeReference();
                            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(dataRangeReference.substring(dataRangeReference.indexOf(33) + 1));
                            xDDFDataSourceFromNumericCellRange = series.categoryData.isNumeric() ? XDDFDataSourcesFactory.fromNumericCellRange(xSSFSheet, cellRangeAddressValueOf) : XDDFDataSourcesFactory.fromStringCellRange(xSSFSheet, cellRangeAddressValueOf);
                            if (xDDFDataSourceFromNumericCellRange.isNumeric()) {
                                ((XDDFNumericalDataSource) xDDFDataSourceFromNumericCellRange).setFormatCode(series.categoryData.getFormatCode());
                            }
                        }
                        xDDFNumericalDataSource = series.valuesData;
                        if (xDDFNumericalDataSource == null && xDDFNumericalDataSource.isReference()) {
                            String dataRangeReference2 = series.valuesData.getDataRangeReference();
                            xDDFNumericalDataSourceFromNumericCellRange = XDDFDataSourcesFactory.fromNumericCellRange(xSSFSheet, CellRangeAddress.valueOf(dataRangeReference2.substring(dataRangeReference2.indexOf(33) + 1)));
                            xDDFNumericalDataSourceFromNumericCellRange.setFormatCode(series.valuesData.getFormatCode());
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    xDDFNumericalDataSource = series.valuesData;
                    if (xDDFNumericalDataSource == null) {
                    }
                }
                series.replaceData(xDDFDataSourceFromNumericCellRange, xDDFNumericalDataSourceFromNumericCellRange);
                series.plot();
            }
        }
    }

    public void saveWorkbook(XSSFWorkbook xSSFWorkbook) throws InvalidFormatException, IOException {
        PackagePart worksheetPart = getWorksheetPart();
        if (worksheetPart == null) {
            POIXMLRelation chartWorkbookRelation = getChartWorkbookRelation();
            POIXMLFactory chartFactory = getChartFactory();
            if (chartWorkbookRelation == null || chartFactory == null) {
                throw new InvalidFormatException("unable to determine chart relations");
            }
            worksheetPart = createWorksheetPart(chartWorkbookRelation, chartFactory);
        }
        OutputStream outputStream = worksheetPart.getOutputStream();
        try {
            setWorksheetPartCommitted();
            xSSFWorkbook.write(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void setAutoTitleDeleted(boolean z6) {
        if (!getCTChart().isSetAutoTitleDeleted()) {
            getCTChart().setAutoTitleDeleted(CTBoolean.Factory.newInstance());
        }
        getCTChart().getAutoTitleDeleted().setVal(z6);
        if (z6 && getCTChart().isSetTitle()) {
            getCTChart().unsetTitle();
        }
    }

    public void setBackWall(int i5) {
        if (!getCTChart().isSetBackWall()) {
            getCTChart().setBackWall(CTSurface.Factory.newInstance());
        }
        getCTChart().getBackWall().getThickness().setVal(Integer.valueOf(i5));
    }

    public void setChartIndex(int i5) {
        this.chartIndex = i5;
    }

    public void setExternalId(String str) {
        CTChartSpace cTChartSpace = getCTChartSpace();
        (cTChartSpace.isSetExternalData() ? cTChartSpace.getExternalData() : cTChartSpace.addNewExternalData()).setId(str);
    }

    public void setFloor(int i5) {
        if (!getCTChart().isSetFloor()) {
            getCTChart().setFloor(CTSurface.Factory.newInstance());
        }
        getCTChart().getFloor().getThickness().setVal(Integer.valueOf(i5));
    }

    public void setPlotOnlyVisibleCells(boolean z6) {
        if (!getCTChart().isSetPlotVisOnly()) {
            getCTChart().setPlotVisOnly(CTBoolean.Factory.newInstance());
        }
        getCTChart().getPlotVisOnly().setVal(z6);
    }

    public CellReference setSheetTitle(String str, int i5) {
        XSSFSheet sheet = getSheet();
        if (sheet == null) {
            return null;
        }
        getCell(getRow(sheet, 0), i5).setCellValue(str);
        return new CellReference(sheet.getSheetName(), 0, i5, true, true);
    }

    public void setSideWall(int i5) {
        if (!getCTChart().isSetSideWall()) {
            getCTChart().setSideWall(CTSurface.Factory.newInstance());
        }
        getCTChart().getSideWall().getThickness().setVal(Integer.valueOf(i5));
    }

    public void setTitleOverlay(boolean z6) {
        if (!getCTChart().isSetTitle()) {
            getCTChart().addNewTitle();
        }
        new XDDFTitle(this, getCTChart().getTitle()).setOverlay(Boolean.valueOf(z6));
    }

    public void setTitleText(String str) {
        if (!getCTChart().isSetTitle()) {
            getCTChart().addNewTitle();
        }
        new XDDFTitle(this, getCTChart().getTitle()).setText(str);
    }

    public void setValueRange(int i5, Double d, Double d6, Double d7, Double d8) {
        XDDFChartAxis xDDFChartAxis = getAxes().get(i5);
        if (xDDFChartAxis == null) {
            return;
        }
        if (d != null) {
            xDDFChartAxis.setMinimum(d.doubleValue());
        }
        if (d6 != null) {
            xDDFChartAxis.setMaximum(d6.doubleValue());
        }
        if (d7 != null) {
            xDDFChartAxis.setMajorUnit(d7.doubleValue());
        }
        if (d8 != null) {
            xDDFChartAxis.setMinorUnit(d8.doubleValue());
        }
    }

    public void setWorkbook(XSSFWorkbook xSSFWorkbook) {
        this.workbook = xSSFWorkbook;
    }

    public XDDFChart(PackagePart packagePart) throws IOException {
        super(packagePart);
        this.chartIndex = 0;
        this.axes = new ArrayList();
        this.seriesCount = 0L;
        InputStream inputStream = packagePart.getInputStream();
        try {
            this.chartSpace = ChartSpaceDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartSpace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}

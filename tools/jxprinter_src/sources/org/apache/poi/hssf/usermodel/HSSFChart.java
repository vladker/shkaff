package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.FooterRecord;
import org.apache.poi.hssf.record.HCenterRecord;
import org.apache.poi.hssf.record.HeaderRecord;
import org.apache.poi.hssf.record.PrintSetupRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.SCLRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.record.VCenterRecord;
import org.apache.poi.hssf.record.chart.AreaFormatRecord;
import org.apache.poi.hssf.record.chart.AreaRecord;
import org.apache.poi.hssf.record.chart.AxisLineFormatRecord;
import org.apache.poi.hssf.record.chart.AxisOptionsRecord;
import org.apache.poi.hssf.record.chart.AxisParentRecord;
import org.apache.poi.hssf.record.chart.AxisRecord;
import org.apache.poi.hssf.record.chart.AxisUsedRecord;
import org.apache.poi.hssf.record.chart.BarRecord;
import org.apache.poi.hssf.record.chart.BeginRecord;
import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;
import org.apache.poi.hssf.record.chart.ChartFormatRecord;
import org.apache.poi.hssf.record.chart.ChartRecord;
import org.apache.poi.hssf.record.chart.ChartTitleFormatRecord;
import org.apache.poi.hssf.record.chart.DataFormatRecord;
import org.apache.poi.hssf.record.chart.DefaultDataLabelTextPropertiesRecord;
import org.apache.poi.hssf.record.chart.EndRecord;
import org.apache.poi.hssf.record.chart.FontBasisRecord;
import org.apache.poi.hssf.record.chart.FontIndexRecord;
import org.apache.poi.hssf.record.chart.FrameRecord;
import org.apache.poi.hssf.record.chart.LegendRecord;
import org.apache.poi.hssf.record.chart.LineFormatRecord;
import org.apache.poi.hssf.record.chart.LinkedDataRecord;
import org.apache.poi.hssf.record.chart.PlotAreaRecord;
import org.apache.poi.hssf.record.chart.PlotGrowthRecord;
import org.apache.poi.hssf.record.chart.SeriesChartGroupIndexRecord;
import org.apache.poi.hssf.record.chart.SeriesIndexRecord;
import org.apache.poi.hssf.record.chart.SeriesRecord;
import org.apache.poi.hssf.record.chart.SeriesTextRecord;
import org.apache.poi.hssf.record.chart.SheetPropertiesRecord;
import org.apache.poi.hssf.record.chart.TextRecord;
import org.apache.poi.hssf.record.chart.TickRecord;
import org.apache.poi.hssf.record.chart.UnitsRecord;
import org.apache.poi.hssf.record.chart.ValueRangeRecord;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFChart {
    private ChartRecord chartRecord;
    private ChartTitleFormatRecord chartTitleFormat;
    private SeriesTextRecord chartTitleText;
    private LegendRecord legendRecord;
    private HSSFSheet sheet;
    private List<ValueRangeRecord> valueRanges = new ArrayList();
    private HSSFChartType type = HSSFChartType.Unknown;
    private List<HSSFSeries> series = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum HSSFChartType {
        Area { // from class: org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType.1
            @Override // org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType
            public short getSid() {
                return AreaRecord.sid;
            }
        },
        Bar { // from class: org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType.2
            @Override // org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType
            public short getSid() {
                return BarRecord.sid;
            }
        },
        Line { // from class: org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType.3
            @Override // org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType
            public short getSid() {
                return (short) 4120;
            }
        },
        Pie { // from class: org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType.4
            @Override // org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType
            public short getSid() {
                return (short) 4121;
            }
        },
        Scatter { // from class: org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType.5
            @Override // org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType
            public short getSid() {
                return (short) 4123;
            }
        },
        Unknown { // from class: org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType.6
            @Override // org.apache.poi.hssf.usermodel.HSSFChart.HSSFChartType
            public short getSid() {
                return (short) 0;
            }
        };

        public abstract short getSid();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class HSSFSeries {
        private LinkedDataRecord dataCategoryLabels;
        private LinkedDataRecord dataName;
        private LinkedDataRecord dataSecondaryCategoryLabels;
        private LinkedDataRecord dataValues;
        private SeriesRecord series;
        private SeriesTextRecord seriesTitleText;

        public HSSFSeries(SeriesRecord seriesRecord) {
            this.series = seriesRecord;
        }

        private CellRangeAddressBase getCellRange(LinkedDataRecord linkedDataRecord) {
            if (linkedDataRecord == null) {
                return null;
            }
            int firstRow = 0;
            int lastRow = 0;
            int firstColumn = 0;
            int lastColumn = 0;
            for (Ptg ptg : linkedDataRecord.getFormulaOfLink()) {
                if (ptg instanceof AreaPtgBase) {
                    AreaPtgBase areaPtgBase = (AreaPtgBase) ptg;
                    firstRow = areaPtgBase.getFirstRow();
                    lastRow = areaPtgBase.getLastRow();
                    firstColumn = areaPtgBase.getFirstColumn();
                    lastColumn = areaPtgBase.getLastColumn();
                }
            }
            return new CellRangeAddress(firstRow, lastRow, firstColumn, lastColumn);
        }

        private Integer setVerticalCellRange(LinkedDataRecord linkedDataRecord, CellRangeAddressBase cellRangeAddressBase) {
            if (linkedDataRecord == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int lastRow = (cellRangeAddressBase.getLastRow() - cellRangeAddressBase.getFirstRow()) + 1;
            int lastColumn = (cellRangeAddressBase.getLastColumn() - cellRangeAddressBase.getFirstColumn()) + 1;
            for (Ptg ptg : linkedDataRecord.getFormulaOfLink()) {
                if (ptg instanceof AreaPtgBase) {
                    AreaPtgBase areaPtgBase = (AreaPtgBase) ptg;
                    areaPtgBase.setFirstRow(cellRangeAddressBase.getFirstRow());
                    areaPtgBase.setLastRow(cellRangeAddressBase.getLastRow());
                    areaPtgBase.setFirstColumn(cellRangeAddressBase.getFirstColumn());
                    areaPtgBase.setLastColumn(cellRangeAddressBase.getLastColumn());
                    arrayList.add(areaPtgBase);
                }
            }
            linkedDataRecord.setFormulaOfLink((Ptg[]) arrayList.toArray(Ptg.EMPTY_PTG_ARRAY));
            return Integer.valueOf(lastRow * lastColumn);
        }

        public CellRangeAddressBase getCategoryLabelsCellRange() {
            return getCellRange(this.dataCategoryLabels);
        }

        public LinkedDataRecord getDataCategoryLabels() {
            return this.dataCategoryLabels;
        }

        public LinkedDataRecord getDataName() {
            return this.dataName;
        }

        public LinkedDataRecord getDataSecondaryCategoryLabels() {
            return this.dataSecondaryCategoryLabels;
        }

        public LinkedDataRecord getDataValues() {
            return this.dataValues;
        }

        public short getNumValues() {
            return this.series.getNumValues();
        }

        public SeriesRecord getSeries() {
            return this.series;
        }

        public String getSeriesTitle() {
            SeriesTextRecord seriesTextRecord = this.seriesTitleText;
            if (seriesTextRecord != null) {
                return seriesTextRecord.getText();
            }
            return null;
        }

        public short getValueType() {
            return this.series.getValuesDataType();
        }

        public CellRangeAddressBase getValuesCellRange() {
            return getCellRange(this.dataValues);
        }

        public void insertData(LinkedDataRecord linkedDataRecord) {
            byte linkType = linkedDataRecord.getLinkType();
            if (linkType == 0) {
                this.dataName = linkedDataRecord;
                return;
            }
            if (linkType == 1) {
                this.dataValues = linkedDataRecord;
                return;
            }
            if (linkType == 2) {
                this.dataCategoryLabels = linkedDataRecord;
            } else if (linkType == 3) {
                this.dataSecondaryCategoryLabels = linkedDataRecord;
            } else {
                throw new IllegalStateException("Invalid link type: " + ((int) linkedDataRecord.getLinkType()));
            }
        }

        public void setCategoryLabelsCellRange(CellRangeAddressBase cellRangeAddressBase) {
            Integer verticalCellRange = setVerticalCellRange(this.dataCategoryLabels, cellRangeAddressBase);
            if (verticalCellRange == null) {
                return;
            }
            this.series.setNumCategories((short) verticalCellRange.intValue());
        }

        public void setSeriesTitle(String str) {
            SeriesTextRecord seriesTextRecord = this.seriesTitleText;
            if (seriesTextRecord == null) {
                throw new IllegalStateException("No series title found to change");
            }
            seriesTextRecord.setText(str);
        }

        public void setSeriesTitleText(SeriesTextRecord seriesTextRecord) {
            this.seriesTitleText = seriesTextRecord;
        }

        public void setValuesCellRange(CellRangeAddressBase cellRangeAddressBase) {
            Integer verticalCellRange = setVerticalCellRange(this.dataValues, cellRangeAddressBase);
            if (verticalCellRange == null) {
                return;
            }
            this.series.setNumValues((short) verticalCellRange.intValue());
        }
    }

    private HSSFChart(HSSFSheet hSSFSheet, ChartRecord chartRecord) {
        this.chartRecord = chartRecord;
        this.sheet = hSSFSheet;
    }

    private TextRecord createAllTextRecord() {
        TextRecord textRecord = new TextRecord();
        textRecord.setHorizontalAlignment((byte) 2);
        textRecord.setVerticalAlignment((byte) 2);
        textRecord.setDisplayMode((short) 1);
        textRecord.setRgbColor(0);
        textRecord.setX(-37);
        textRecord.setY(-60);
        textRecord.setWidth(0);
        textRecord.setHeight(0);
        textRecord.setAutoColor(true);
        textRecord.setShowKey(false);
        textRecord.setShowValue(true);
        textRecord.setVertical(false);
        textRecord.setAutoGeneratedText(true);
        textRecord.setGenerated(true);
        textRecord.setAutoLabelDeleted(false);
        textRecord.setAutoBackground(true);
        textRecord.setRotation((short) 0);
        textRecord.setShowCategoryLabelAsPercentage(false);
        textRecord.setShowValueAsPercentage(false);
        textRecord.setShowBubbleSizes(false);
        textRecord.setShowLabel(false);
        textRecord.setIndexOfColorValue((short) 77);
        textRecord.setDataLabelPlacement((short) 0);
        textRecord.setTextRotation((short) 0);
        return textRecord;
    }

    private AreaFormatRecord createAreaFormatRecord1() {
        AreaFormatRecord areaFormatRecord = new AreaFormatRecord();
        areaFormatRecord.setForegroundColor(16777215);
        areaFormatRecord.setBackgroundColor(0);
        areaFormatRecord.setPattern((short) 1);
        areaFormatRecord.setAutomatic(true);
        areaFormatRecord.setInvert(false);
        areaFormatRecord.setForecolorIndex((short) 78);
        areaFormatRecord.setBackcolorIndex((short) 77);
        return areaFormatRecord;
    }

    private AreaFormatRecord createAreaFormatRecord2() {
        AreaFormatRecord areaFormatRecord = new AreaFormatRecord();
        areaFormatRecord.setForegroundColor(12632256);
        areaFormatRecord.setBackgroundColor(0);
        areaFormatRecord.setPattern((short) 1);
        areaFormatRecord.setAutomatic(false);
        areaFormatRecord.setInvert(false);
        areaFormatRecord.setForecolorIndex((short) 22);
        areaFormatRecord.setBackcolorIndex((short) 79);
        return areaFormatRecord;
    }

    private AxisLineFormatRecord createAxisLineFormatRecord(short s6) {
        AxisLineFormatRecord axisLineFormatRecord = new AxisLineFormatRecord();
        axisLineFormatRecord.setAxisType(s6);
        return axisLineFormatRecord;
    }

    private AxisOptionsRecord createAxisOptionsRecord() {
        AxisOptionsRecord axisOptionsRecord = new AxisOptionsRecord();
        axisOptionsRecord.setMinimumCategory((short) -28644);
        axisOptionsRecord.setMaximumCategory((short) -28715);
        axisOptionsRecord.setMajorUnitValue((short) 2);
        axisOptionsRecord.setMajorUnit((short) 0);
        axisOptionsRecord.setMinorUnitValue((short) 1);
        axisOptionsRecord.setMinorUnit((short) 0);
        axisOptionsRecord.setBaseUnit((short) 0);
        axisOptionsRecord.setCrossingPoint((short) -28644);
        axisOptionsRecord.setDefaultMinimum(true);
        axisOptionsRecord.setDefaultMaximum(true);
        axisOptionsRecord.setDefaultMajor(true);
        axisOptionsRecord.setDefaultMinorUnit(true);
        axisOptionsRecord.setIsDate(true);
        axisOptionsRecord.setDefaultBase(true);
        axisOptionsRecord.setDefaultCross(true);
        axisOptionsRecord.setDefaultDateSettings(true);
        return axisOptionsRecord;
    }

    private AxisParentRecord createAxisParentRecord() {
        AxisParentRecord axisParentRecord = new AxisParentRecord();
        axisParentRecord.setAxisType((short) 0);
        axisParentRecord.setX(Videoio.CAP_PROP_XI_CC_MATRIX_00);
        axisParentRecord.setY(221);
        axisParentRecord.setWidth(2995);
        axisParentRecord.setHeight(2902);
        return axisParentRecord;
    }

    private AxisRecord createAxisRecord(short s6) {
        AxisRecord axisRecord = new AxisRecord();
        axisRecord.setAxisType(s6);
        return axisRecord;
    }

    private void createAxisRecords(List<Record> list) {
        list.add(createAxisParentRecord());
        list.add(createBeginRecord());
        list.add(createAxisRecord((short) 0));
        list.add(createBeginRecord());
        list.add(createCategorySeriesAxisRecord());
        list.add(createAxisOptionsRecord());
        list.add(createTickRecord1());
        list.add(createEndRecord());
        list.add(createAxisRecord((short) 1));
        list.add(createBeginRecord());
        list.add(createValueRangeRecord());
        list.add(createTickRecord2());
        list.add(createAxisLineFormatRecord((short) 1));
        list.add(createLineFormatRecord(false));
        list.add(createEndRecord());
        list.add(createPlotAreaRecord());
        list.add(createFrameRecord2());
        list.add(createBeginRecord());
        list.add(createLineFormatRecord2());
        list.add(createAreaFormatRecord2());
        list.add(createEndRecord());
        list.add(createChartFormatRecord());
        list.add(createBeginRecord());
        list.add(createBarRecord());
        list.add(createLegendRecord());
        list.add(createBeginRecord());
        list.add(createTextRecord());
        list.add(createBeginRecord());
        list.add(createLinkedDataRecord());
        list.add(createEndRecord());
        list.add(createEndRecord());
        list.add(createEndRecord());
        list.add(createEndRecord());
    }

    private AxisUsedRecord createAxisUsedRecord(short s6) {
        AxisUsedRecord axisUsedRecord = new AxisUsedRecord();
        axisUsedRecord.setNumAxis(s6);
        return axisUsedRecord;
    }

    private BOFRecord createBOFRecord() {
        BOFRecord bOFRecord = new BOFRecord();
        bOFRecord.setVersion(600);
        bOFRecord.setType(20);
        bOFRecord.setBuild(7422);
        bOFRecord.setBuildYear(1997);
        bOFRecord.setHistoryBitMask(16585);
        bOFRecord.setRequiredVersion(106);
        return bOFRecord;
    }

    private BarRecord createBarRecord() {
        BarRecord barRecord = new BarRecord();
        barRecord.setBarSpace((short) 0);
        barRecord.setCategorySpace(EscherAggregate.ST_TEXTCIRCLEPOUR);
        barRecord.setHorizontal(false);
        barRecord.setStacked(false);
        barRecord.setDisplayAsPercentage(false);
        barRecord.setShadow(false);
        return barRecord;
    }

    private BeginRecord createBeginRecord() {
        return new BeginRecord();
    }

    private LinkedDataRecord createCategoriesLinkedDataRecord() {
        LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
        linkedDataRecord.setLinkType((byte) 2);
        linkedDataRecord.setReferenceType((byte) 2);
        linkedDataRecord.setCustomNumberFormat(false);
        linkedDataRecord.setIndexNumberFmtRecord((short) 0);
        linkedDataRecord.setFormulaOfLink(new Ptg[]{new Area3DPtg(0, 31, 1, 1, false, false, false, false, 0)});
        return linkedDataRecord;
    }

    private CategorySeriesAxisRecord createCategorySeriesAxisRecord() {
        CategorySeriesAxisRecord categorySeriesAxisRecord = new CategorySeriesAxisRecord();
        categorySeriesAxisRecord.setCrossingPoint((short) 1);
        categorySeriesAxisRecord.setLabelFrequency((short) 1);
        categorySeriesAxisRecord.setTickMarkFrequency((short) 1);
        categorySeriesAxisRecord.setValueAxisCrossing(true);
        categorySeriesAxisRecord.setCrossesFarRight(false);
        categorySeriesAxisRecord.setReversed(false);
        return categorySeriesAxisRecord;
    }

    private ChartFormatRecord createChartFormatRecord() {
        ChartFormatRecord chartFormatRecord = new ChartFormatRecord();
        chartFormatRecord.setXPosition(0);
        chartFormatRecord.setYPosition(0);
        chartFormatRecord.setWidth(0);
        chartFormatRecord.setHeight(0);
        chartFormatRecord.setVaryDisplayPattern(false);
        return chartFormatRecord;
    }

    private ChartRecord createChartRecord(int i5, int i6, int i7, int i8) {
        ChartRecord chartRecord = new ChartRecord();
        chartRecord.setX(i5);
        chartRecord.setY(i6);
        chartRecord.setWidth(i7);
        chartRecord.setHeight(i8);
        return chartRecord;
    }

    private DataFormatRecord createDataFormatRecord() {
        DataFormatRecord dataFormatRecord = new DataFormatRecord();
        dataFormatRecord.setPointNumber((short) -1);
        dataFormatRecord.setSeriesIndex((short) 0);
        dataFormatRecord.setSeriesNumber((short) 0);
        dataFormatRecord.setUseExcel4Colors(false);
        return dataFormatRecord;
    }

    private DefaultDataLabelTextPropertiesRecord createDefaultTextRecord(short s6) {
        DefaultDataLabelTextPropertiesRecord defaultDataLabelTextPropertiesRecord = new DefaultDataLabelTextPropertiesRecord();
        defaultDataLabelTextPropertiesRecord.setCategoryDataType(s6);
        return defaultDataLabelTextPropertiesRecord;
    }

    private DimensionsRecord createDimensionsRecord() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.setFirstRow(0);
        dimensionsRecord.setLastRow(31);
        dimensionsRecord.setFirstCol((short) 0);
        dimensionsRecord.setLastCol((short) 1);
        return dimensionsRecord;
    }

    private LinkedDataRecord createDirectLinkRecord() {
        LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
        linkedDataRecord.setLinkType((byte) 0);
        linkedDataRecord.setReferenceType((byte) 1);
        linkedDataRecord.setCustomNumberFormat(false);
        linkedDataRecord.setIndexNumberFmtRecord((short) 0);
        linkedDataRecord.setFormulaOfLink(null);
        return linkedDataRecord;
    }

    private EndRecord createEndRecord() {
        return new EndRecord();
    }

    private FontBasisRecord createFontBasisRecord1() {
        FontBasisRecord fontBasisRecord = new FontBasisRecord();
        fontBasisRecord.setXBasis((short) 9120);
        fontBasisRecord.setYBasis((short) 5640);
        fontBasisRecord.setHeightBasis(EscherAggregate.ST_ACTIONBUTTONMOVIE);
        fontBasisRecord.setScale((short) 0);
        fontBasisRecord.setIndexToFontTable((short) 5);
        return fontBasisRecord;
    }

    private FontBasisRecord createFontBasisRecord2() {
        FontBasisRecord fontBasisRecordCreateFontBasisRecord1 = createFontBasisRecord1();
        fontBasisRecordCreateFontBasisRecord1.setIndexToFontTable((short) 6);
        return fontBasisRecordCreateFontBasisRecord1;
    }

    private FontIndexRecord createFontIndexRecord(int i5) {
        FontIndexRecord fontIndexRecord = new FontIndexRecord();
        fontIndexRecord.setFontIndex((short) i5);
        return fontIndexRecord;
    }

    private FrameRecord createFrameRecord1() {
        FrameRecord frameRecord = new FrameRecord();
        frameRecord.setBorderType((short) 0);
        frameRecord.setAutoSize(false);
        frameRecord.setAutoPosition(true);
        return frameRecord;
    }

    private FrameRecord createFrameRecord2() {
        FrameRecord frameRecord = new FrameRecord();
        frameRecord.setBorderType((short) 0);
        frameRecord.setAutoSize(true);
        frameRecord.setAutoPosition(true);
        return frameRecord;
    }

    private HCenterRecord createHCenterRecord() {
        HCenterRecord hCenterRecord = new HCenterRecord();
        hCenterRecord.setHCenter(false);
        return hCenterRecord;
    }

    private LegendRecord createLegendRecord() {
        LegendRecord legendRecord = new LegendRecord();
        legendRecord.setXAxisUpperLeft(3542);
        legendRecord.setYAxisUpperLeft(1566);
        legendRecord.setXSize(Videoio.CAP_PROP_XI_SENSOR_TAPS);
        legendRecord.setYSize(213);
        legendRecord.setType((byte) 3);
        legendRecord.setSpacing((byte) 1);
        legendRecord.setAutoPosition(true);
        legendRecord.setAutoSeries(true);
        legendRecord.setAutoXPositioning(true);
        legendRecord.setAutoYPositioning(true);
        legendRecord.setVertical(true);
        legendRecord.setDataTable(false);
        return legendRecord;
    }

    private LineFormatRecord createLineFormatRecord(boolean z6) {
        LineFormatRecord lineFormatRecord = new LineFormatRecord();
        lineFormatRecord.setLineColor(0);
        lineFormatRecord.setLinePattern((short) 0);
        lineFormatRecord.setWeight((short) -1);
        lineFormatRecord.setAuto(true);
        lineFormatRecord.setDrawTicks(z6);
        lineFormatRecord.setColourPaletteIndex((short) 77);
        return lineFormatRecord;
    }

    private LineFormatRecord createLineFormatRecord2() {
        LineFormatRecord lineFormatRecord = new LineFormatRecord();
        lineFormatRecord.setLineColor(8421504);
        lineFormatRecord.setLinePattern((short) 0);
        lineFormatRecord.setWeight((short) 0);
        lineFormatRecord.setAuto(false);
        lineFormatRecord.setDrawTicks(false);
        lineFormatRecord.setUnknown(false);
        lineFormatRecord.setColourPaletteIndex((short) 23);
        return lineFormatRecord;
    }

    private LinkedDataRecord createLinkedDataRecord() {
        LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
        linkedDataRecord.setLinkType((byte) 0);
        linkedDataRecord.setReferenceType((byte) 1);
        linkedDataRecord.setCustomNumberFormat(false);
        linkedDataRecord.setIndexNumberFmtRecord((short) 0);
        linkedDataRecord.setFormulaOfLink(null);
        return linkedDataRecord;
    }

    private UnknownRecord createMSDrawingObjectRecord() {
        return new UnknownRecord(236, new byte[]{15, 0, 2, -16, -64, 0, 0, 0, 16, 0, 8, -16, 8, 0, 0, 0, 2, 0, 0, 0, 2, 4, 0, 0, 15, 0, 3, -16, -88, 0, 0, 0, 15, 0, 4, -16, 40, 0, 0, 0, 1, 0, 9, -16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 10, -16, 8, 0, 0, 0, 0, 4, 0, 0, 5, 0, 0, 0, 15, 0, 4, -16, 112, 0, 0, 0, -110, 12, 10, -16, 8, 0, 0, 0, 2, 4, 0, 0, 0, 10, 0, 0, -109, 0, 11, -16, TarConstants.LF_FIFO, 0, 0, 0, Ascii.DEL, 0, 4, 1, 4, 1, -65, 0, 8, 0, 8, 0, -127, 1, 78, 0, 0, 8, -125, 1, 77, 0, 0, 8, -65, 1, 16, 0, 17, 0, -64, 1, 77, 0, 0, 8, -1, 1, 8, 0, 8, 0, 63, 2, 0, 0, 2, 0, -65, 3, 0, 0, 8, 0, 0, 0, 16, -16, 18, 0, 0, 0, 0, 0, 4, 0, -64, 2, 10, 0, -12, 0, 14, 0, 102, 1, 32, 0, -23, 0, 0, 0, 17, -16, 0, 0, 0, 0});
    }

    private UnknownRecord createOBJRecord() {
        return new UnknownRecord(93, new byte[]{21, 0, 18, 0, 5, 0, 2, 0, 17, 96, 0, 0, 0, 0, -72, 3, -121, 3, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    private PlotAreaRecord createPlotAreaRecord() {
        return new PlotAreaRecord();
    }

    private PlotGrowthRecord createPlotGrowthRecord(int i5, int i6) {
        PlotGrowthRecord plotGrowthRecord = new PlotGrowthRecord();
        plotGrowthRecord.setHorizontalScale(i5);
        plotGrowthRecord.setVerticalScale(i6);
        return plotGrowthRecord;
    }

    private PrintSetupRecord createPrintSetupRecord() {
        PrintSetupRecord printSetupRecord = new PrintSetupRecord();
        printSetupRecord.setPaperSize((short) 0);
        printSetupRecord.setScale((short) 18);
        printSetupRecord.setPageStart((short) 1);
        printSetupRecord.setFitWidth((short) 1);
        printSetupRecord.setFitHeight((short) 1);
        printSetupRecord.setLeftToRight(false);
        printSetupRecord.setLandscape(false);
        printSetupRecord.setValidSettings(true);
        printSetupRecord.setNoColor(false);
        printSetupRecord.setDraft(false);
        printSetupRecord.setNotes(false);
        printSetupRecord.setNoOrientation(false);
        printSetupRecord.setUsePage(false);
        printSetupRecord.setHResolution((short) 0);
        printSetupRecord.setVResolution((short) 0);
        printSetupRecord.setHeaderMargin(0.5d);
        printSetupRecord.setFooterMargin(0.5d);
        printSetupRecord.setCopies((short) 15);
        return printSetupRecord;
    }

    private SCLRecord createSCLRecord(short s6, short s7) {
        SCLRecord sCLRecord = new SCLRecord();
        sCLRecord.setDenominator(s7);
        sCLRecord.setNumerator(s6);
        return sCLRecord;
    }

    private SeriesIndexRecord createSeriesIndexRecord(int i5) {
        SeriesIndexRecord seriesIndexRecord = new SeriesIndexRecord();
        seriesIndexRecord.setIndex((short) i5);
        return seriesIndexRecord;
    }

    private SeriesRecord createSeriesRecord() {
        SeriesRecord seriesRecord = new SeriesRecord();
        seriesRecord.setCategoryDataType((short) 1);
        seriesRecord.setValuesDataType((short) 1);
        seriesRecord.setNumCategories((short) 32);
        seriesRecord.setNumValues((short) 31);
        seriesRecord.setBubbleSeriesType((short) 1);
        seriesRecord.setNumBubbleValues((short) 0);
        return seriesRecord;
    }

    private SeriesChartGroupIndexRecord createSeriesToChartGroupRecord() {
        return new SeriesChartGroupIndexRecord();
    }

    private SheetPropertiesRecord createSheetPropsRecord() {
        SheetPropertiesRecord sheetPropertiesRecord = new SheetPropertiesRecord();
        sheetPropertiesRecord.setChartTypeManuallyFormatted(false);
        sheetPropertiesRecord.setPlotVisibleOnly(true);
        sheetPropertiesRecord.setDoNotSizeWithWindow(false);
        sheetPropertiesRecord.setDefaultPlotDimensions(true);
        sheetPropertiesRecord.setAutoPlotArea(false);
        return sheetPropertiesRecord;
    }

    private TextRecord createTextRecord() {
        TextRecord textRecord = new TextRecord();
        textRecord.setHorizontalAlignment((byte) 2);
        textRecord.setVerticalAlignment((byte) 2);
        textRecord.setDisplayMode((short) 1);
        textRecord.setRgbColor(0);
        textRecord.setX(-37);
        textRecord.setY(-60);
        textRecord.setWidth(0);
        textRecord.setHeight(0);
        textRecord.setAutoColor(true);
        textRecord.setShowKey(false);
        textRecord.setShowValue(false);
        textRecord.setVertical(false);
        textRecord.setAutoGeneratedText(true);
        textRecord.setGenerated(true);
        textRecord.setAutoLabelDeleted(false);
        textRecord.setAutoBackground(true);
        textRecord.setRotation((short) 0);
        textRecord.setShowCategoryLabelAsPercentage(false);
        textRecord.setShowValueAsPercentage(false);
        textRecord.setShowBubbleSizes(false);
        textRecord.setShowLabel(false);
        textRecord.setIndexOfColorValue((short) 77);
        textRecord.setDataLabelPlacement((short) 0);
        textRecord.setTextRotation((short) 0);
        return textRecord;
    }

    private TickRecord createTickRecord1() {
        TickRecord tickRecord = new TickRecord();
        tickRecord.setMajorTickType((byte) 2);
        tickRecord.setMinorTickType((byte) 0);
        tickRecord.setLabelPosition((byte) 3);
        tickRecord.setBackground((byte) 1);
        tickRecord.setLabelColorRgb(0);
        tickRecord.setZero1(0);
        tickRecord.setZero2(0);
        tickRecord.setZero3((short) 45);
        tickRecord.setAutorotate(true);
        tickRecord.setAutoTextBackground(true);
        tickRecord.setRotation((short) 0);
        tickRecord.setAutorotate(true);
        tickRecord.setTickColor((short) 77);
        return tickRecord;
    }

    private TickRecord createTickRecord2() {
        TickRecord tickRecordCreateTickRecord1 = createTickRecord1();
        tickRecordCreateTickRecord1.setZero3((short) 0);
        return tickRecordCreateTickRecord1;
    }

    private LinkedDataRecord createTitleLinkedDataRecord() {
        LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
        linkedDataRecord.setLinkType((byte) 0);
        linkedDataRecord.setReferenceType((byte) 1);
        linkedDataRecord.setCustomNumberFormat(false);
        linkedDataRecord.setIndexNumberFmtRecord((short) 0);
        linkedDataRecord.setFormulaOfLink(null);
        return linkedDataRecord;
    }

    private UnitsRecord createUnitsRecord() {
        UnitsRecord unitsRecord = new UnitsRecord();
        unitsRecord.setUnits((short) 0);
        return unitsRecord;
    }

    private TextRecord createUnknownTextRecord() {
        TextRecord textRecord = new TextRecord();
        textRecord.setHorizontalAlignment((byte) 2);
        textRecord.setVerticalAlignment((byte) 2);
        textRecord.setDisplayMode((short) 1);
        textRecord.setRgbColor(0);
        textRecord.setX(-37);
        textRecord.setY(-60);
        textRecord.setWidth(0);
        textRecord.setHeight(0);
        textRecord.setAutoColor(true);
        textRecord.setShowKey(false);
        textRecord.setShowValue(false);
        textRecord.setVertical(false);
        textRecord.setAutoGeneratedText(true);
        textRecord.setGenerated(true);
        textRecord.setAutoLabelDeleted(false);
        textRecord.setAutoBackground(true);
        textRecord.setRotation((short) 0);
        textRecord.setShowCategoryLabelAsPercentage(false);
        textRecord.setShowValueAsPercentage(false);
        textRecord.setShowBubbleSizes(false);
        textRecord.setShowLabel(false);
        textRecord.setIndexOfColorValue((short) 77);
        textRecord.setDataLabelPlacement((short) 11088);
        textRecord.setTextRotation((short) 0);
        return textRecord;
    }

    private VCenterRecord createVCenterRecord() {
        VCenterRecord vCenterRecord = new VCenterRecord();
        vCenterRecord.setVCenter(false);
        return vCenterRecord;
    }

    private ValueRangeRecord createValueRangeRecord() {
        ValueRangeRecord valueRangeRecord = new ValueRangeRecord();
        valueRangeRecord.setMinimumAxisValue(0.0d);
        valueRangeRecord.setMaximumAxisValue(0.0d);
        valueRangeRecord.setMajorIncrement(0.0d);
        valueRangeRecord.setMinorIncrement(0.0d);
        valueRangeRecord.setCategoryAxisCross(0.0d);
        valueRangeRecord.setAutomaticMinimum(true);
        valueRangeRecord.setAutomaticMaximum(true);
        valueRangeRecord.setAutomaticMajor(true);
        valueRangeRecord.setAutomaticMinor(true);
        valueRangeRecord.setAutomaticCategoryCrossing(true);
        valueRangeRecord.setLogarithmicScale(false);
        valueRangeRecord.setValuesInReverse(false);
        valueRangeRecord.setCrossCategoryAxisAtMaximum(false);
        valueRangeRecord.setReserved(true);
        return valueRangeRecord;
    }

    private LinkedDataRecord createValuesLinkedDataRecord() {
        LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
        linkedDataRecord.setLinkType((byte) 1);
        linkedDataRecord.setReferenceType((byte) 2);
        linkedDataRecord.setCustomNumberFormat(false);
        linkedDataRecord.setIndexNumberFmtRecord((short) 0);
        linkedDataRecord.setFormulaOfLink(new Ptg[]{new Area3DPtg(0, 31, 0, 0, false, false, false, false, 0)});
        return linkedDataRecord;
    }

    public static HSSFChart[] getSheetCharts(HSSFSheet hSSFSheet) {
        ArrayList arrayList = new ArrayList();
        Iterator<RecordBase> it = hSSFSheet.getSheet().getRecords().iterator();
        HSSFSeries hSSFSeries = null;
        HSSFChart hSSFChart = null;
        while (true) {
            if (!it.hasNext()) {
                return (HSSFChart[]) arrayList.toArray(new HSSFChart[0]);
            }
            RecordBase next = it.next();
            if (next instanceof ChartRecord) {
                hSSFChart = new HSSFChart(hSSFSheet, (ChartRecord) next);
                arrayList.add(hSSFChart);
                hSSFSeries = null;
            } else if (next instanceof LinkedDataRecord) {
                LinkedDataRecord linkedDataRecord = (LinkedDataRecord) next;
                if (hSSFSeries != null) {
                    hSSFSeries.insertData(linkedDataRecord);
                }
            }
            if (hSSFChart != null) {
                if (next instanceof LegendRecord) {
                    hSSFChart.legendRecord = (LegendRecord) next;
                } else if (next instanceof SeriesRecord) {
                    hSSFSeries = new HSSFSeries((SeriesRecord) next);
                    hSSFChart.series.add(hSSFSeries);
                } else if (next instanceof ChartTitleFormatRecord) {
                    hSSFChart.chartTitleFormat = (ChartTitleFormatRecord) next;
                } else if (next instanceof SeriesTextRecord) {
                    SeriesTextRecord seriesTextRecord = (SeriesTextRecord) next;
                    if (hSSFChart.legendRecord != null || hSSFChart.series.isEmpty()) {
                        hSSFChart.chartTitleText = seriesTextRecord;
                    } else {
                        ((HSSFSeries) AbstractC0157z.f(1, hSSFChart.series)).seriesTitleText = seriesTextRecord;
                    }
                } else if (next instanceof ValueRangeRecord) {
                    hSSFChart.valueRanges.add((ValueRangeRecord) next);
                } else if (next instanceof Record) {
                    Record record = (Record) next;
                    for (HSSFChartType hSSFChartType : HSSFChartType.values()) {
                        if (hSSFChartType != HSSFChartType.Unknown && record.getSid() == hSSFChartType.getSid()) {
                            hSSFChart.type = hSSFChartType;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void createBarChart(HSSFWorkbook hSSFWorkbook, HSSFSheet hSSFSheet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createMSDrawingObjectRecord());
        arrayList.add(createOBJRecord());
        arrayList.add(createBOFRecord());
        arrayList.add(new HeaderRecord(""));
        arrayList.add(new FooterRecord(""));
        arrayList.add(createHCenterRecord());
        arrayList.add(createVCenterRecord());
        arrayList.add(createPrintSetupRecord());
        arrayList.add(createFontBasisRecord1());
        arrayList.add(createFontBasisRecord2());
        arrayList.add(new ProtectRecord(false));
        arrayList.add(createUnitsRecord());
        arrayList.add(createChartRecord(0, 0, 30434904, 19031616));
        arrayList.add(createBeginRecord());
        arrayList.add(createSCLRecord((short) 1, (short) 1));
        arrayList.add(createPlotGrowthRecord(65536, 65536));
        arrayList.add(createFrameRecord1());
        arrayList.add(createBeginRecord());
        arrayList.add(createLineFormatRecord(true));
        arrayList.add(createAreaFormatRecord1());
        arrayList.add(createEndRecord());
        arrayList.add(createSeriesRecord());
        arrayList.add(createBeginRecord());
        arrayList.add(createTitleLinkedDataRecord());
        arrayList.add(createValuesLinkedDataRecord());
        arrayList.add(createCategoriesLinkedDataRecord());
        arrayList.add(createDataFormatRecord());
        arrayList.add(createSeriesToChartGroupRecord());
        arrayList.add(createEndRecord());
        arrayList.add(createSheetPropsRecord());
        arrayList.add(createDefaultTextRecord((short) 2));
        arrayList.add(createAllTextRecord());
        arrayList.add(createBeginRecord());
        arrayList.add(createFontIndexRecord(5));
        arrayList.add(createDirectLinkRecord());
        arrayList.add(createEndRecord());
        arrayList.add(createDefaultTextRecord((short) 3));
        arrayList.add(createUnknownTextRecord());
        arrayList.add(createBeginRecord());
        arrayList.add(createFontIndexRecord(6));
        arrayList.add(createDirectLinkRecord());
        arrayList.add(createEndRecord());
        arrayList.add(createAxisUsedRecord((short) 1));
        createAxisRecords(arrayList);
        arrayList.add(createEndRecord());
        arrayList.add(createDimensionsRecord());
        arrayList.add(createSeriesIndexRecord(2));
        arrayList.add(createSeriesIndexRecord(1));
        arrayList.add(createSeriesIndexRecord(3));
        arrayList.add(EOFRecord.instance);
        hSSFSheet.insertChartRecords(arrayList);
        hSSFWorkbook.insertChartRecord();
    }

    public HSSFSeries createSeries() {
        Object objCopy;
        SeriesTextRecord seriesTextRecordCopy;
        LinkedDataRecord linkedDataRecordCopy;
        SeriesRecord seriesRecordCopy;
        HSSFSeries hSSFSeries;
        EndRecord endRecord;
        BeginRecord beginRecord;
        ArrayList arrayList = new ArrayList();
        List<RecordBase> records = this.sheet.getSheet().getRecords();
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        int i10 = 0;
        boolean z6 = false;
        int i11 = 0;
        for (RecordBase recordBase : records) {
            i9++;
            if (recordBase instanceof BeginRecord) {
                i10++;
            } else if (recordBase instanceof EndRecord) {
                i10--;
                if (i5 == i10) {
                    if (z6) {
                        i5 = -1;
                        i7 = i9;
                    } else {
                        arrayList.add(recordBase);
                        i5 = -1;
                        i7 = i9;
                        z6 = true;
                    }
                }
                if (i8 == i10) {
                    break;
                }
            }
            if (recordBase instanceof ChartRecord) {
                if (recordBase == this.chartRecord) {
                    i6 = i9;
                    i8 = i10;
                }
            } else if ((recordBase instanceof SeriesRecord) && i6 != -1) {
                i11++;
                i5 = i10;
            }
            if (i5 != -1 && !z6) {
                arrayList.add(recordBase);
            }
        }
        if (i7 == -1) {
            return null;
        }
        int i12 = i7 + 1;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        HSSFSeries hSSFSeries2 = null;
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            RecordBase recordBase2 = (RecordBase) obj;
            if (recordBase2 instanceof BeginRecord) {
                beginRecord = new BeginRecord();
            } else if (recordBase2 instanceof EndRecord) {
                endRecord = new EndRecord();
            } else if (recordBase2 instanceof SeriesRecord) {
                seriesRecordCopy = ((SeriesRecord) recordBase2).copy();
                hSSFSeries = new HSSFSeries(seriesRecordCopy);
            } else if (recordBase2 instanceof LinkedDataRecord) {
                linkedDataRecordCopy = ((LinkedDataRecord) recordBase2).copy();
                if (hSSFSeries2 != null) {
                    hSSFSeries2 = hSSFSeries2;
                    objCopy = linkedDataRecordCopy;
                    hSSFSeries2.insertData(linkedDataRecordCopy);
                    hSSFSeries2 = hSSFSeries2;
                    objCopy = linkedDataRecordCopy;
                }
            } else if (recordBase2 instanceof DataFormatRecord) {
                DataFormatRecord dataFormatRecordCopy = ((DataFormatRecord) recordBase2).copy();
                short s6 = (short) i11;
                dataFormatRecordCopy.setSeriesIndex(s6);
                dataFormatRecordCopy.setSeriesNumber(s6);
                hSSFSeries2 = hSSFSeries2;
                objCopy = dataFormatRecordCopy;
            } else if (recordBase2 instanceof SeriesTextRecord) {
                seriesTextRecordCopy = ((SeriesTextRecord) recordBase2).copy();
                if (hSSFSeries2 != null) {
                    hSSFSeries2 = hSSFSeries2;
                    objCopy = seriesTextRecordCopy;
                    hSSFSeries2.setSeriesTitleText(seriesTextRecordCopy);
                    hSSFSeries2 = hSSFSeries2;
                    objCopy = seriesTextRecordCopy;
                }
            } else if (recordBase2 instanceof Record) {
                hSSFSeries2 = hSSFSeries2;
                objCopy = ((Record) recordBase2).copy();
            } else {
                objCopy = null;
                hSSFSeries2 = hSSFSeries2;
            }
            if (objCopy != null) {
                hSSFSeries2 = hSSFSeries;
                objCopy = seriesRecordCopy;
                hSSFSeries2 = hSSFSeries2;
                objCopy = endRecord;
                hSSFSeries2 = hSSFSeries2;
                objCopy = beginRecord;
                arrayList2.add(objCopy);
            } else {
                hSSFSeries2 = hSSFSeries;
                objCopy = seriesRecordCopy;
                hSSFSeries2 = hSSFSeries2;
                objCopy = endRecord;
                hSSFSeries2 = hSSFSeries2;
                objCopy = beginRecord;
            }
        }
        if (hSSFSeries2 == null) {
            return null;
        }
        int size2 = arrayList2.size();
        int i14 = 0;
        while (i14 < size2) {
            Object obj2 = arrayList2.get(i14);
            i14++;
            records.add(i12, (RecordBase) obj2);
            i12++;
        }
        return hSSFSeries2;
    }

    public int getChartHeight() {
        return this.chartRecord.getHeight();
    }

    public String getChartTitle() {
        SeriesTextRecord seriesTextRecord = this.chartTitleText;
        if (seriesTextRecord != null) {
            return seriesTextRecord.getText();
        }
        return null;
    }

    public int getChartWidth() {
        return this.chartRecord.getWidth();
    }

    public int getChartX() {
        return this.chartRecord.getX();
    }

    public int getChartY() {
        return this.chartRecord.getY();
    }

    public HSSFSeries[] getSeries() {
        return (HSSFSeries[]) this.series.toArray(new HSSFSeries[0]);
    }

    public HSSFChartType getType() {
        return this.type;
    }

    public boolean removeSeries(HSSFSeries hSSFSeries) {
        Iterator<RecordBase> it = this.sheet.getSheet().getRecords().iterator();
        int i5 = 0;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (it.hasNext()) {
            RecordBase next = it.next();
            if (next instanceof BeginRecord) {
                i5++;
            } else if (next instanceof EndRecord) {
                i5--;
                if (i6 == i5) {
                    if (z6) {
                        it.remove();
                        z6 = false;
                        i6 = -1;
                        z8 = true;
                    } else {
                        i6 = -1;
                    }
                }
                if (i7 == i5) {
                    return z8;
                }
            }
            if (next instanceof ChartRecord) {
                if (next == this.chartRecord) {
                    i7 = i5;
                    z7 = true;
                }
            } else if (next instanceof SeriesRecord) {
                if (z7) {
                    if (hSSFSeries.series == next) {
                        i6 = i5;
                        z6 = true;
                    } else {
                        i8++;
                    }
                }
            } else if ((next instanceof DataFormatRecord) && z7 && !z6) {
                DataFormatRecord dataFormatRecord = (DataFormatRecord) next;
                short s6 = (short) i8;
                dataFormatRecord.setSeriesIndex(s6);
                dataFormatRecord.setSeriesNumber(s6);
            }
            if (z6) {
                it.remove();
            }
        }
        return z8;
    }

    public void setChartHeight(int i5) {
        this.chartRecord.setHeight(i5);
    }

    public void setChartTitle(String str) {
        SeriesTextRecord seriesTextRecord = this.chartTitleText;
        if (seriesTextRecord == null) {
            throw new IllegalStateException("No chart title found to change");
        }
        seriesTextRecord.setText(str);
    }

    public void setChartWidth(int i5) {
        this.chartRecord.setWidth(i5);
    }

    public void setChartX(int i5) {
        this.chartRecord.setX(i5);
    }

    public void setChartY(int i5) {
        this.chartRecord.setY(i5);
    }

    public void setValueRange(int i5, Double d, Double d6, Double d7, Double d8) {
        ValueRangeRecord valueRangeRecord = this.valueRanges.get(i5);
        if (valueRangeRecord == null) {
            return;
        }
        if (d != null) {
            valueRangeRecord.setAutomaticMinimum(d.isNaN());
            valueRangeRecord.setMinimumAxisValue(d.doubleValue());
        }
        if (d6 != null) {
            valueRangeRecord.setAutomaticMaximum(d6.isNaN());
            valueRangeRecord.setMaximumAxisValue(d6.doubleValue());
        }
        if (d7 != null) {
            valueRangeRecord.setAutomaticMajor(d7.isNaN());
            valueRangeRecord.setMajorIncrement(d7.doubleValue());
        }
        if (d8 != null) {
            valueRangeRecord.setAutomaticMinor(d8.isNaN());
            valueRangeRecord.setMinorIncrement(d8.doubleValue());
        }
    }
}

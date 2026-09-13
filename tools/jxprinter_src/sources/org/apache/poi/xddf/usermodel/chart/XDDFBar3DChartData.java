package org.apache.poi.xddf.usermodel.chart;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBar3DChartData extends XDDFChartData {
    private CTBar3DChart chart;

    @Internal
    public XDDFBar3DChartData(XDDFChart xDDFChart, CTBar3DChart cTBar3DChart, Map<Long, XDDFChartAxis> map, Map<Long, XDDFValueAxis> map2) {
        super(xDDFChart);
        this.chart = cTBar3DChart;
        if (cTBar3DChart.getBarDir() == null) {
            cTBar3DChart.addNewBarDir().setVal(BarDirection.BAR.underlying);
        }
        for (CTBarSer cTBarSer : cTBar3DChart.getSerList()) {
            this.series.add(new Series(cTBarSer, cTBarSer.getCat(), cTBarSer.getVal()));
        }
        defineAxes(map, map2);
    }

    private void defineAxes(Map<Long, XDDFChartAxis> map, Map<Long, XDDFValueAxis> map2) {
        if (this.chart.sizeOfAxIdArray() == 0) {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                this.chart.addNewAxId().setVal(it.next().longValue());
            }
            Iterator<Long> it2 = map2.keySet().iterator();
            while (it2.hasNext()) {
                this.chart.addNewAxId().setVal(it2.next().longValue());
            }
        }
        defineAxes(this.chart.getAxIdArray(), map, map2);
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData
    public XDDFChartData.Series addSeries(XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource) {
        long jIncrementSeriesCount = this.parent.incrementSeriesCount();
        CTBarSer cTBarSerAddNewSer = this.chart.addNewSer();
        cTBarSerAddNewSer.addNewTx();
        cTBarSerAddNewSer.addNewCat();
        cTBarSerAddNewSer.addNewVal();
        cTBarSerAddNewSer.addNewIdx().setVal(jIncrementSeriesCount);
        cTBarSerAddNewSer.addNewOrder().setVal(jIncrementSeriesCount);
        Series series = new Series(cTBarSerAddNewSer, xDDFDataSource, xDDFNumericalDataSource);
        this.series.add(series);
        return series;
    }

    public BarDirection getBarDirection() {
        return BarDirection.valueOf(this.chart.getBarDir().getVal());
    }

    public BarGrouping getBarGrouping() {
        if (this.chart.isSetGrouping()) {
            return BarGrouping.valueOf(this.chart.getGrouping().getVal());
        }
        return null;
    }

    public Integer getGapDepth() {
        if (this.chart.isSetGapDepth()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.chart.getGapDepth().xgetVal()) / 1000);
        }
        return null;
    }

    public Integer getGapWidth() {
        if (this.chart.isSetGapWidth()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.chart.getGapWidth().xgetVal()) / 1000);
        }
        return null;
    }

    public Shape getShape() {
        if (this.chart.isSetShape()) {
            return Shape.valueOf(this.chart.getShape().getVal());
        }
        return null;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData
    @Internal
    public void removeCTSeries(int i5) {
        this.chart.removeSer(i5);
    }

    public void setBarDirection(BarDirection barDirection) {
        this.chart.getBarDir().setVal(barDirection.underlying);
    }

    public void setBarGrouping(BarGrouping barGrouping) {
        if (barGrouping == null) {
            if (this.chart.isSetGrouping()) {
                this.chart.unsetGrouping();
            }
        } else if (this.chart.isSetGrouping()) {
            this.chart.getGrouping().setVal(barGrouping.underlying);
        } else {
            this.chart.addNewGrouping().setVal(barGrouping.underlying);
        }
    }

    public void setGapDepth(Integer num) {
        if (num == null) {
            if (this.chart.isSetGapDepth()) {
                this.chart.unsetGapDepth();
            }
        } else if (this.chart.isSetGapDepth()) {
            this.chart.getGapDepth().setVal(num);
        } else {
            this.chart.addNewGapDepth().setVal(num);
        }
    }

    public void setGapWidth(Integer num) {
        if (num == null) {
            if (this.chart.isSetGapWidth()) {
                this.chart.unsetGapWidth();
            }
        } else if (this.chart.isSetGapWidth()) {
            this.chart.getGapWidth().setVal(num);
        } else {
            this.chart.addNewGapWidth().setVal(num);
        }
    }

    public void setShape(Shape shape) {
        if (shape == null) {
            if (this.chart.isSetShape()) {
                this.chart.unsetShape();
            }
        } else if (this.chart.isSetShape()) {
            this.chart.getShape().setVal(shape.underlying);
        } else {
            this.chart.addNewShape().setVal(shape.underlying);
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData
    public void setVaryColors(Boolean bool) {
        if (bool == null) {
            if (this.chart.isSetVaryColors()) {
                this.chart.unsetVaryColors();
            }
        } else if (this.chart.isSetVaryColors()) {
            this.chart.getVaryColors().setVal(bool.booleanValue());
        } else {
            this.chart.addNewVaryColors().setVal(bool.booleanValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Series extends XDDFChartData.Series {
        private CTBarSer series;

        public Series(CTBarSer cTBarSer, XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource) {
            super(xDDFDataSource, xDDFNumericalDataSource);
            this.series = cTBarSer;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public CTAxDataSource getAxDS() {
            return this.series.getCat();
        }

        public CTBarSer getCTBarSer() {
            return this.series;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public List<CTDPt> getDPtList() {
            return this.series.getDPtList();
        }

        public XDDFErrorBars getErrorBars() {
            if (this.series.isSetErrBars()) {
                return new XDDFErrorBars(this.series.getErrBars());
            }
            return null;
        }

        public boolean getInvertIfNegative() {
            if (this.series.isSetInvertIfNegative()) {
                return this.series.getInvertIfNegative().getVal();
            }
            return false;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public CTNumDataSource getNumDS() {
            return this.series.getVal();
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public CTSerTx getSeriesText() {
            return this.series.isSetTx() ? this.series.getTx() : this.series.addNewTx();
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public XDDFShapeProperties getShapeProperties() {
            if (this.series.isSetSpPr()) {
                return new XDDFShapeProperties(this.series.getSpPr());
            }
            return null;
        }

        public boolean hasErrorBars() {
            return this.series.isSetErrBars();
        }

        public void setErrorBars(XDDFErrorBars xDDFErrorBars) {
            if (xDDFErrorBars == null) {
                if (this.series.isSetErrBars()) {
                    this.series.unsetErrBars();
                }
            } else if (this.series.isSetErrBars()) {
                this.series.getErrBars().set(xDDFErrorBars.getXmlObject());
            } else {
                this.series.addNewErrBars().set(xDDFErrorBars.getXmlObject());
            }
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public void setIndex(long j6) {
            this.series.getIdx().setVal(j6);
        }

        public void setInvertIfNegative(boolean z6) {
            if (this.series.isSetInvertIfNegative()) {
                this.series.getInvertIfNegative().setVal(z6);
            } else {
                this.series.addNewInvertIfNegative().setVal(z6);
            }
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public void setOrder(long j6) {
            this.series.getOrder().setVal(j6);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public void setShapeProperties(XDDFShapeProperties xDDFShapeProperties) {
            if (xDDFShapeProperties == null) {
                if (this.series.isSetSpPr()) {
                    this.series.unsetSpPr();
                }
            } else if (this.series.isSetSpPr()) {
                this.series.setSpPr(xDDFShapeProperties.getXmlObject());
            } else {
                this.series.addNewSpPr().set(xDDFShapeProperties.getXmlObject());
            }
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public void setShowLeaderLines(boolean z6) {
            if (!this.series.isSetDLbls()) {
                this.series.addNewDLbls();
            }
            if (this.series.getDLbls().isSetShowLeaderLines()) {
                this.series.getDLbls().getShowLeaderLines().setVal(z6);
            } else {
                this.series.getDLbls().addNewShowLeaderLines().setVal(z6);
            }
        }

        public Series(CTBarSer cTBarSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
            super(XDDFDataSourcesFactory.fromDataSource(cTAxDataSource), XDDFDataSourcesFactory.fromDataSource(cTNumDataSource));
            this.series = cTBarSer;
        }
    }
}

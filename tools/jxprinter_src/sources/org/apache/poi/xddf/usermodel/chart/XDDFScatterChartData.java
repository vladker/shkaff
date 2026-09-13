package org.apache.poi.xddf.usermodel.chart;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterStyle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFScatterChartData extends XDDFChartData {
    private CTScatterChart chart;

    @Internal
    public XDDFScatterChartData(XDDFChart xDDFChart, CTScatterChart cTScatterChart, Map<Long, XDDFChartAxis> map, Map<Long, XDDFValueAxis> map2) {
        super(xDDFChart);
        this.chart = cTScatterChart;
        for (CTScatterSer cTScatterSer : cTScatterChart.getSerList()) {
            this.series.add(new Series(cTScatterSer, cTScatterSer.getXVal(), cTScatterSer.getYVal()));
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
        CTScatterSer cTScatterSerAddNewSer = this.chart.addNewSer();
        cTScatterSerAddNewSer.addNewXVal();
        cTScatterSerAddNewSer.addNewYVal();
        cTScatterSerAddNewSer.addNewIdx().setVal(jIncrementSeriesCount);
        cTScatterSerAddNewSer.addNewOrder().setVal(jIncrementSeriesCount);
        Series series = new Series(cTScatterSerAddNewSer, xDDFDataSource, xDDFNumericalDataSource);
        series.setMarkerStyle(MarkerStyle.NONE);
        this.series.add(series);
        return series;
    }

    public ScatterStyle getStyle() {
        CTScatterStyle scatterStyle = this.chart.getScatterStyle();
        if (scatterStyle == null) {
            scatterStyle = this.chart.addNewScatterStyle();
            scatterStyle.setVal(ScatterStyle.LINE_MARKER.underlying);
        }
        return ScatterStyle.valueOf(scatterStyle.getVal());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData
    @Internal
    public void removeCTSeries(int i5) {
        this.chart.removeSer(i5);
    }

    public void setStyle(ScatterStyle scatterStyle) {
        CTScatterStyle scatterStyle2 = this.chart.getScatterStyle();
        if (scatterStyle2 == null) {
            scatterStyle2 = this.chart.addNewScatterStyle();
        }
        scatterStyle2.setVal(scatterStyle.underlying);
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
        private CTScatterSer series;

        public Series(CTScatterSer cTScatterSer, XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<?> xDDFNumericalDataSource) {
            super(xDDFDataSource, xDDFNumericalDataSource);
            this.series = cTScatterSer;
        }

        private CTMarker getMarker() {
            return this.series.isSetMarker() ? this.series.getMarker() : this.series.addNewMarker();
        }

        public XDDFErrorBars addNewErrorBars() {
            return new XDDFErrorBars(this.series.addNewErrBars());
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public CTAxDataSource getAxDS() {
            return this.series.getXVal();
        }

        public CTScatterSer getCTScatterSer() {
            return this.series;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public List<CTDPt> getDPtList() {
            return this.series.getDPtList();
        }

        public XDDFErrorBars getErrorBars(int i5) {
            return new XDDFErrorBars(this.series.getErrBarsArray(i5));
        }

        public int getErrorBarsCount() {
            return this.series.sizeOfErrBarsArray();
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public CTNumDataSource getNumDS() {
            return this.series.getYVal();
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

        public XDDFErrorBars insertNewErrorBars(int i5) {
            return new XDDFErrorBars(this.series.insertNewErrBars(i5));
        }

        public Boolean isSmooth() {
            return this.series.isSetSmooth() ? Boolean.valueOf(this.series.getSmooth().getVal()) : Boolean.FALSE;
        }

        public void removeErrorBars(int i5) {
            this.series.removeErrBars(i5);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public void setIndex(long j6) {
            this.series.getIdx().setVal(j6);
        }

        public void setMarkerSize(short s6) {
            if (s6 < 2 || 72 < s6) {
                throw new IllegalArgumentException("Minimum inclusive: 2; Maximum inclusive: 72");
            }
            CTMarker marker = getMarker();
            if (marker.isSetSize()) {
                marker.getSize().setVal(s6);
            } else {
                marker.addNewSize().setVal(s6);
            }
        }

        public void setMarkerStyle(MarkerStyle markerStyle) {
            CTMarker marker = getMarker();
            if (marker.isSetSymbol()) {
                marker.getSymbol().setVal(markerStyle.underlying);
            } else {
                marker.addNewSymbol().setVal(markerStyle.underlying);
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

        public void setSmooth(Boolean bool) {
            if (bool == null) {
                if (this.series.isSetSmooth()) {
                    this.series.unsetSmooth();
                }
            } else if (this.series.isSetSmooth()) {
                this.series.getSmooth().setVal(bool.booleanValue());
            } else {
                this.series.addNewSmooth().setVal(bool.booleanValue());
            }
        }

        public Series(CTScatterSer cTScatterSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
            super(XDDFDataSourcesFactory.fromDataSource(cTAxDataSource), XDDFDataSourcesFactory.fromDataSource(cTNumDataSource));
            this.series = cTScatterSer;
        }
    }
}

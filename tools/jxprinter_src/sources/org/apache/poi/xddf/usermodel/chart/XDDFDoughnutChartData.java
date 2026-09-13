package org.apache.poi.xddf.usermodel.chart;

import java.util.List;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFDoughnutChartData extends XDDFChartData {
    private CTDoughnutChart chart;

    @Internal
    public XDDFDoughnutChartData(XDDFChart xDDFChart, CTDoughnutChart cTDoughnutChart) {
        super(xDDFChart);
        this.chart = cTDoughnutChart;
        for (CTPieSer cTPieSer : cTDoughnutChart.getSerList()) {
            this.series.add(new Series(cTPieSer, cTPieSer.getCat(), cTPieSer.getVal()));
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData
    public XDDFChartData.Series addSeries(XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource) {
        long jIncrementSeriesCount = this.parent.incrementSeriesCount();
        CTPieSer cTPieSerAddNewSer = this.chart.addNewSer();
        cTPieSerAddNewSer.addNewCat();
        cTPieSerAddNewSer.addNewVal();
        cTPieSerAddNewSer.addNewIdx().setVal(jIncrementSeriesCount);
        cTPieSerAddNewSer.addNewOrder().setVal(jIncrementSeriesCount);
        Series series = new Series(cTPieSerAddNewSer, xDDFDataSource, xDDFNumericalDataSource);
        this.series.add(series);
        return series;
    }

    public Integer getFirstSliceAngle() {
        if (this.chart.isSetFirstSliceAng()) {
            return Integer.valueOf(this.chart.getFirstSliceAng().getVal());
        }
        return null;
    }

    public Integer getHoleSize() {
        if (this.chart.isSetHoleSize()) {
            return Integer.valueOf(POIXMLUnits.parsePercent(this.chart.getHoleSize().xgetVal()));
        }
        return null;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData
    @Internal
    public void removeCTSeries(int i5) {
        this.chart.removeSer(i5);
    }

    public void setFirstSliceAngle(Integer num) {
        if (num == null) {
            if (this.chart.isSetFirstSliceAng()) {
                this.chart.unsetFirstSliceAng();
            }
        } else {
            if (num.intValue() < 0 || 360 < num.intValue()) {
                throw new IllegalArgumentException("Value of angle must be between 0 and 360, both inclusive.");
            }
            if (this.chart.isSetFirstSliceAng()) {
                this.chart.getFirstSliceAng().setVal(num.intValue());
            } else {
                this.chart.addNewFirstSliceAng().setVal(num.intValue());
            }
        }
    }

    public void setHoleSize(Integer num) {
        if (num == null) {
            if (this.chart.isSetHoleSize()) {
                this.chart.unsetHoleSize();
            }
        } else {
            if (num.intValue() < 10 || num.intValue() > 90) {
                throw new IllegalArgumentException("Value of holeSize must be between 10 and 90, both inclusive.");
            }
            if (this.chart.isSetHoleSize()) {
                this.chart.getHoleSize().setVal(num);
            } else {
                this.chart.addNewHoleSize().setVal(num);
            }
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
        private CTPieSer series;

        public Series(CTPieSer cTPieSer, XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource) {
            super(xDDFDataSource, xDDFNumericalDataSource);
            this.series = cTPieSer;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public CTAxDataSource getAxDS() {
            return this.series.getCat();
        }

        public CTPieSer getCTPieSer() {
            return this.series;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public List<CTDPt> getDPtList() {
            return this.series.getDPtList();
        }

        public Long getExplosion() {
            if (this.series.isSetExplosion()) {
                return Long.valueOf(this.series.getExplosion().getVal());
            }
            return null;
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

        public void setExplosion(Long l6) {
            if (l6 == null) {
                if (this.series.isSetExplosion()) {
                    this.series.unsetExplosion();
                }
            } else if (this.series.isSetExplosion()) {
                this.series.getExplosion().setVal(l6.longValue());
            } else {
                this.series.addNewExplosion().setVal(l6.longValue());
            }
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartData.Series
        public void setIndex(long j6) {
            this.series.getIdx().setVal(j6);
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

        public Series(CTPieSer cTPieSer, CTAxDataSource cTAxDataSource, CTNumDataSource cTNumDataSource) {
            super(XDDFDataSourcesFactory.fromDataSource(cTAxDataSource), XDDFDataSourcesFactory.fromDataSource(cTNumDataSource));
            this.series = cTPieSer;
        }
    }
}

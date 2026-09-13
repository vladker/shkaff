package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.text.XDDFRunProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFSeriesAxis extends XDDFChartAxis {
    private CTSerAx ctSerAx;

    public XDDFSeriesAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        initializeAxis(cTPlotArea, axisPosition);
    }

    private void initializeAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        long nextAxId = getNextAxId(cTPlotArea);
        CTSerAx cTSerAxAddNewSerAx = cTPlotArea.addNewSerAx();
        this.ctSerAx = cTSerAxAddNewSerAx;
        cTSerAxAddNewSerAx.addNewAxId().setVal(nextAxId);
        this.ctSerAx.addNewAxPos();
        this.ctSerAx.addNewScaling();
        this.ctSerAx.addNewCrosses();
        this.ctSerAx.addNewCrossAx();
        this.ctSerAx.addNewTickLblPos();
        this.ctSerAx.addNewDelete();
        this.ctSerAx.addNewMajorTickMark();
        this.ctSerAx.addNewMinorTickMark();
        setPosition(axisPosition);
        setOrientation(AxisOrientation.MIN_MAX);
        setCrosses(AxisCrosses.AUTO_ZERO);
        setVisible(true);
        setMajorTickMark(AxisTickMark.CROSS);
        setMinorTickMark(AxisTickMark.NONE);
        setTickLabelPosition(AxisTickLabelPosition.NEXT_TO);
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void crossAxis(XDDFChartAxis xDDFChartAxis) {
        this.ctSerAx.getCrossAx().setVal(xDDFChartAxis.getId());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTUnsignedInt getCTAxId() {
        return this.ctSerAx.getAxId();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTAxPos getCTAxPos() {
        return this.ctSerAx.getAxPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTCrosses getCTCrosses() {
        CTCrosses crosses = this.ctSerAx.getCrosses();
        return crosses == null ? this.ctSerAx.addNewCrosses() : crosses;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTNumFmt getCTNumFmt() {
        return this.ctSerAx.isSetNumFmt() ? this.ctSerAx.getNumFmt() : this.ctSerAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTScaling getCTScaling() {
        return this.ctSerAx.getScaling();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickLblPos getCTTickLblPos() {
        return this.ctSerAx.getTickLblPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTBoolean getDelete() {
        return this.ctSerAx.getDelete();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMajorCTTickMark() {
        return this.ctSerAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMajorUnit() {
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMinorCTTickMark() {
        return this.ctSerAx.getMinorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMinorUnit() {
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMajorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctSerAx.isSetMajorGridlines() ? this.ctSerAx.getMajorGridlines() : this.ctSerAx.addNewMajorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMinorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctSerAx.isSetMinorGridlines() ? this.ctSerAx.getMinorGridlines() : this.ctSerAx.addNewMinorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.HasShapeProperties
    public XDDFShapeProperties getOrAddShapeProperties() {
        return new XDDFShapeProperties(this.ctSerAx.isSetSpPr() ? this.ctSerAx.getSpPr() : this.ctSerAx.addNewSpPr());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFRunProperties getOrAddTextProperties() {
        return new XDDFRunProperties(getOrAddTextProperties(this.ctSerAx.isSetTxPr() ? this.ctSerAx.getTxPr() : this.ctSerAx.addNewTxPr()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean hasNumberFormat() {
        return this.ctSerAx.isSetNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMajorUnit() {
        return false;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMinorUnit() {
        return false;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setTitle(String str) {
        if (!this.ctSerAx.isSetTitle()) {
            this.ctSerAx.addNewTitle();
        }
        XDDFTitle xDDFTitle = new XDDFTitle(null, this.ctSerAx.getTitle());
        xDDFTitle.setOverlay(Boolean.FALSE);
        xDDFTitle.setText(str);
    }

    public XDDFSeriesAxis(CTSerAx cTSerAx) {
        this.ctSerAx = cTSerAx;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMajorUnit(double d) {
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMinorUnit(double d) {
    }
}

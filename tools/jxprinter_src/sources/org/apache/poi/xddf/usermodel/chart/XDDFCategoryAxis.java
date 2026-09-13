package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.text.XDDFRunProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFCategoryAxis extends XDDFChartAxis {
    private CTCatAx ctCatAx;

    public XDDFCategoryAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        initializeAxis(cTPlotArea, axisPosition);
    }

    private void initializeAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        long nextAxId = getNextAxId(cTPlotArea);
        CTCatAx cTCatAxAddNewCatAx = cTPlotArea.addNewCatAx();
        this.ctCatAx = cTCatAxAddNewCatAx;
        cTCatAxAddNewCatAx.addNewAxId().setVal(nextAxId);
        this.ctCatAx.addNewAuto().setVal(false);
        this.ctCatAx.addNewAxPos();
        this.ctCatAx.addNewScaling();
        this.ctCatAx.addNewCrosses();
        this.ctCatAx.addNewCrossAx();
        this.ctCatAx.addNewTickLblPos();
        this.ctCatAx.addNewDelete();
        this.ctCatAx.addNewMajorTickMark();
        this.ctCatAx.addNewMinorTickMark();
        this.ctCatAx.addNewNumFmt().setSourceLinked(true);
        this.ctCatAx.getNumFmt().setFormatCode("");
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
        this.ctCatAx.getCrossAx().setVal(xDDFChartAxis.getId());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTUnsignedInt getCTAxId() {
        return this.ctCatAx.getAxId();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTAxPos getCTAxPos() {
        return this.ctCatAx.getAxPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTCrosses getCTCrosses() {
        CTCrosses crosses = this.ctCatAx.getCrosses();
        return crosses == null ? this.ctCatAx.addNewCrosses() : crosses;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTNumFmt getCTNumFmt() {
        return this.ctCatAx.isSetNumFmt() ? this.ctCatAx.getNumFmt() : this.ctCatAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTScaling getCTScaling() {
        return this.ctCatAx.getScaling();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickLblPos getCTTickLblPos() {
        return this.ctCatAx.getTickLblPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTBoolean getDelete() {
        return this.ctCatAx.getDelete();
    }

    public AxisLabelAlignment getLabelAlignment() {
        return AxisLabelAlignment.valueOf(this.ctCatAx.getLblAlgn().getVal());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMajorCTTickMark() {
        return this.ctCatAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMajorUnit() {
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMinorCTTickMark() {
        return this.ctCatAx.getMinorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMinorUnit() {
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMajorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctCatAx.isSetMajorGridlines() ? this.ctCatAx.getMajorGridlines() : this.ctCatAx.addNewMajorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMinorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctCatAx.isSetMinorGridlines() ? this.ctCatAx.getMinorGridlines() : this.ctCatAx.addNewMinorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.HasShapeProperties
    public XDDFShapeProperties getOrAddShapeProperties() {
        return new XDDFShapeProperties(this.ctCatAx.isSetSpPr() ? this.ctCatAx.getSpPr() : this.ctCatAx.addNewSpPr());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFRunProperties getOrAddTextProperties() {
        return new XDDFRunProperties(getOrAddTextProperties(this.ctCatAx.isSetTxPr() ? this.ctCatAx.getTxPr() : this.ctCatAx.addNewTxPr()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean hasNumberFormat() {
        return this.ctCatAx.isSetNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMajorUnit() {
        return false;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMinorUnit() {
        return false;
    }

    public void setLabelAlignment(AxisLabelAlignment axisLabelAlignment) {
        this.ctCatAx.getLblAlgn().setVal(axisLabelAlignment.underlying);
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setTitle(String str) {
        if (!this.ctCatAx.isSetTitle()) {
            this.ctCatAx.addNewTitle();
        }
        XDDFTitle xDDFTitle = new XDDFTitle(null, this.ctCatAx.getTitle());
        xDDFTitle.setOverlay(Boolean.FALSE);
        xDDFTitle.setText(str);
    }

    public XDDFCategoryAxis(CTCatAx cTCatAx) {
        this.ctCatAx = cTCatAx;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMajorUnit(double d) {
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMinorUnit(double d) {
    }
}

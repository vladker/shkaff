package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.text.XDDFRunProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFValueAxis extends XDDFChartAxis {
    private CTValAx ctValAx;

    public XDDFValueAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        initializeAxis(cTPlotArea, axisPosition);
    }

    private void initializeAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        long nextAxId = getNextAxId(cTPlotArea);
        CTValAx cTValAxAddNewValAx = cTPlotArea.addNewValAx();
        this.ctValAx = cTValAxAddNewValAx;
        cTValAxAddNewValAx.addNewAxId().setVal(nextAxId);
        this.ctValAx.addNewAxPos();
        this.ctValAx.addNewScaling();
        this.ctValAx.addNewCrossBetween();
        this.ctValAx.addNewCrosses();
        this.ctValAx.addNewCrossAx();
        this.ctValAx.addNewTickLblPos();
        this.ctValAx.addNewDelete();
        this.ctValAx.addNewMajorTickMark();
        this.ctValAx.addNewMinorTickMark();
        setPosition(axisPosition);
        setOrientation(AxisOrientation.MIN_MAX);
        setCrossBetween(AxisCrossBetween.MIDPOINT_CATEGORY);
        setCrosses(AxisCrosses.AUTO_ZERO);
        setVisible(true);
        setMajorTickMark(AxisTickMark.CROSS);
        setMinorTickMark(AxisTickMark.NONE);
        setTickLabelPosition(AxisTickLabelPosition.NEXT_TO);
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void crossAxis(XDDFChartAxis xDDFChartAxis) {
        this.ctValAx.getCrossAx().setVal(xDDFChartAxis.getId());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTUnsignedInt getCTAxId() {
        return this.ctValAx.getAxId();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTAxPos getCTAxPos() {
        return this.ctValAx.getAxPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTCrosses getCTCrosses() {
        CTCrosses crosses = this.ctValAx.getCrosses();
        return crosses == null ? this.ctValAx.addNewCrosses() : crosses;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTNumFmt getCTNumFmt() {
        return this.ctValAx.isSetNumFmt() ? this.ctValAx.getNumFmt() : this.ctValAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTScaling getCTScaling() {
        return this.ctValAx.getScaling();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickLblPos getCTTickLblPos() {
        return this.ctValAx.getTickLblPos();
    }

    public AxisCrossBetween getCrossBetween() {
        return AxisCrossBetween.valueOf(this.ctValAx.getCrossBetween().getVal());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTBoolean getDelete() {
        return this.ctValAx.getDelete();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMajorCTTickMark() {
        return this.ctValAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMajorUnit() {
        if (this.ctValAx.isSetMajorUnit()) {
            return this.ctValAx.getMajorUnit().getVal();
        }
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMinorCTTickMark() {
        return this.ctValAx.getMinorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMinorUnit() {
        if (this.ctValAx.isSetMinorUnit()) {
            return this.ctValAx.getMinorUnit().getVal();
        }
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMajorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctValAx.isSetMajorGridlines() ? this.ctValAx.getMajorGridlines() : this.ctValAx.addNewMajorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMinorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctValAx.isSetMinorGridlines() ? this.ctValAx.getMinorGridlines() : this.ctValAx.addNewMinorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.HasShapeProperties
    public XDDFShapeProperties getOrAddShapeProperties() {
        return new XDDFShapeProperties(this.ctValAx.isSetSpPr() ? this.ctValAx.getSpPr() : this.ctValAx.addNewSpPr());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFRunProperties getOrAddTextProperties() {
        return new XDDFRunProperties(getOrAddTextProperties(this.ctValAx.isSetTxPr() ? this.ctValAx.getTxPr() : this.ctValAx.addNewTxPr()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean hasNumberFormat() {
        return this.ctValAx.isSetNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMajorUnit() {
        return this.ctValAx.isSetMajorUnit();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMinorUnit() {
        return this.ctValAx.isSetMinorUnit();
    }

    public void setCrossBetween(AxisCrossBetween axisCrossBetween) {
        this.ctValAx.getCrossBetween().setVal(axisCrossBetween.underlying);
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMajorUnit(double d) {
        if (Double.isNaN(d)) {
            if (this.ctValAx.isSetMajorUnit()) {
                this.ctValAx.unsetMajorUnit();
            }
        } else if (this.ctValAx.isSetMajorUnit()) {
            this.ctValAx.getMajorUnit().setVal(d);
        } else {
            this.ctValAx.addNewMajorUnit().setVal(d);
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMinorUnit(double d) {
        if (Double.isNaN(d)) {
            if (this.ctValAx.isSetMinorUnit()) {
                this.ctValAx.unsetMinorUnit();
            }
        } else if (this.ctValAx.isSetMinorUnit()) {
            this.ctValAx.getMinorUnit().setVal(d);
        } else {
            this.ctValAx.addNewMinorUnit().setVal(d);
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setTitle(String str) {
        if (!this.ctValAx.isSetTitle()) {
            this.ctValAx.addNewTitle();
        }
        XDDFTitle xDDFTitle = new XDDFTitle(null, this.ctValAx.getTitle());
        xDDFTitle.setOverlay(Boolean.FALSE);
        xDDFTitle.setText(str);
    }

    public XDDFValueAxis(CTValAx cTValAx) {
        this.ctValAx = cTValAx;
    }
}

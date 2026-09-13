package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.text.XDDFRunProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFDateAxis extends XDDFChartAxis {
    private CTDateAx ctDateAx;

    public XDDFDateAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        initializeAxis(cTPlotArea, axisPosition);
    }

    private void initializeAxis(CTPlotArea cTPlotArea, AxisPosition axisPosition) {
        long nextAxId = getNextAxId(cTPlotArea);
        CTDateAx cTDateAxAddNewDateAx = cTPlotArea.addNewDateAx();
        this.ctDateAx = cTDateAxAddNewDateAx;
        cTDateAxAddNewDateAx.addNewAxId().setVal(nextAxId);
        this.ctDateAx.addNewAuto().setVal(false);
        this.ctDateAx.addNewAxPos();
        this.ctDateAx.addNewScaling();
        this.ctDateAx.addNewCrosses();
        this.ctDateAx.addNewCrossAx();
        this.ctDateAx.addNewTickLblPos();
        this.ctDateAx.addNewDelete();
        this.ctDateAx.addNewMajorTickMark();
        this.ctDateAx.addNewMinorTickMark();
        this.ctDateAx.addNewNumFmt().setSourceLinked(true);
        this.ctDateAx.getNumFmt().setFormatCode("");
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
        this.ctDateAx.getCrossAx().setVal(xDDFChartAxis.getId());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTUnsignedInt getCTAxId() {
        return this.ctDateAx.getAxId();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTAxPos getCTAxPos() {
        return this.ctDateAx.getAxPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTCrosses getCTCrosses() {
        CTCrosses crosses = this.ctDateAx.getCrosses();
        return crosses == null ? this.ctDateAx.addNewCrosses() : crosses;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTNumFmt getCTNumFmt() {
        return this.ctDateAx.isSetNumFmt() ? this.ctDateAx.getNumFmt() : this.ctDateAx.addNewNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTScaling getCTScaling() {
        return this.ctDateAx.getScaling();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickLblPos getCTTickLblPos() {
        return this.ctDateAx.getTickLblPos();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTBoolean getDelete() {
        return this.ctDateAx.getDelete();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMajorCTTickMark() {
        return this.ctDateAx.getMajorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMajorUnit() {
        if (this.ctDateAx.isSetMajorUnit()) {
            return this.ctDateAx.getMajorUnit().getVal();
        }
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public CTTickMark getMinorCTTickMark() {
        return this.ctDateAx.getMinorTickMark();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public double getMinorUnit() {
        if (this.ctDateAx.isSetMinorUnit()) {
            return this.ctDateAx.getMinorUnit().getVal();
        }
        return Double.NaN;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMajorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctDateAx.isSetMajorGridlines() ? this.ctDateAx.getMajorGridlines() : this.ctDateAx.addNewMajorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFShapeProperties getOrAddMinorGridProperties() {
        return new XDDFShapeProperties(getOrAddLinesProperties(this.ctDateAx.isSetMinorGridlines() ? this.ctDateAx.getMinorGridlines() : this.ctDateAx.addNewMinorGridlines()));
    }

    @Override // org.apache.poi.xddf.usermodel.HasShapeProperties
    public XDDFShapeProperties getOrAddShapeProperties() {
        return new XDDFShapeProperties(this.ctDateAx.isSetSpPr() ? this.ctDateAx.getSpPr() : this.ctDateAx.addNewSpPr());
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public XDDFRunProperties getOrAddTextProperties() {
        return new XDDFRunProperties(getOrAddTextProperties(this.ctDateAx.isSetTxPr() ? this.ctDateAx.getTxPr() : this.ctDateAx.addNewTxPr()));
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean hasNumberFormat() {
        return this.ctDateAx.isSetNumFmt();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMajorUnit() {
        return this.ctDateAx.isSetMajorUnit();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public boolean isSetMinorUnit() {
        return this.ctDateAx.isSetMinorUnit();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMajorUnit(double d) {
        if (Double.isNaN(d)) {
            if (this.ctDateAx.isSetMajorUnit()) {
                this.ctDateAx.unsetMajorUnit();
            }
        } else if (this.ctDateAx.isSetMajorUnit()) {
            this.ctDateAx.getMajorUnit().setVal(d);
        } else {
            this.ctDateAx.addNewMajorUnit().setVal(d);
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setMinorUnit(double d) {
        if (Double.isNaN(d)) {
            if (this.ctDateAx.isSetMinorUnit()) {
                this.ctDateAx.unsetMinorUnit();
            }
        } else if (this.ctDateAx.isSetMinorUnit()) {
            this.ctDateAx.getMinorUnit().setVal(d);
        } else {
            this.ctDateAx.addNewMinorUnit().setVal(d);
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChartAxis
    public void setTitle(String str) {
        if (!this.ctDateAx.isSetTitle()) {
            this.ctDateAx.addNewTitle();
        }
        XDDFTitle xDDFTitle = new XDDFTitle(null, this.ctDateAx.getTitle());
        xDDFTitle.setOverlay(Boolean.FALSE);
        xDDFTitle.setText(str);
    }

    public XDDFDateAxis(CTDateAx cTDateAx) {
        this.ctDateAx = cTDateAx;
    }
}

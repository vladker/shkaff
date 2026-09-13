package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.xddf.usermodel.HasShapeProperties;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.poi.xddf.usermodel.text.XDDFRunProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XDDFChartAxis implements HasShapeProperties {
    private static final double MAX_LOG_BASE = 1000.0d;
    private static final double MIN_LOG_BASE = 2.0d;

    public abstract void crossAxis(XDDFChartAxis xDDFChartAxis);

    public abstract CTUnsignedInt getCTAxId();

    public abstract CTAxPos getCTAxPos();

    public abstract CTCrosses getCTCrosses();

    public abstract CTNumFmt getCTNumFmt();

    public abstract CTScaling getCTScaling();

    public abstract CTTickLblPos getCTTickLblPos();

    public AxisCrosses getCrosses() {
        return AxisCrosses.valueOf(getCTCrosses().getVal());
    }

    public abstract CTBoolean getDelete();

    public long getId() {
        return getCTAxId().getVal();
    }

    public double getLogBase() {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetLogBase()) {
            return cTScaling.getLogBase().getVal();
        }
        return Double.NaN;
    }

    public abstract CTTickMark getMajorCTTickMark();

    public AxisTickMark getMajorTickMark() {
        return AxisTickMark.valueOf(getMajorCTTickMark().getVal());
    }

    public abstract double getMajorUnit();

    public double getMaximum() {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetMax()) {
            return cTScaling.getMax().getVal();
        }
        return Double.NaN;
    }

    public double getMinimum() {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetMin()) {
            return cTScaling.getMin().getVal();
        }
        return Double.NaN;
    }

    public abstract CTTickMark getMinorCTTickMark();

    public AxisTickMark getMinorTickMark() {
        return AxisTickMark.valueOf(getMinorCTTickMark().getVal());
    }

    public abstract double getMinorUnit();

    public long getNextAxId(CTPlotArea cTPlotArea) {
        return ((long) cTPlotArea.sizeOfValAxArray()) + ((long) cTPlotArea.sizeOfCatAxArray()) + ((long) cTPlotArea.sizeOfDateAxArray()) + ((long) cTPlotArea.sizeOfSerAxArray());
    }

    public String getNumberFormat() {
        return getCTNumFmt().getFormatCode();
    }

    public CTShapeProperties getOrAddLinesProperties(CTChartLines cTChartLines) {
        return cTChartLines.isSetSpPr() ? cTChartLines.getSpPr() : cTChartLines.addNewSpPr();
    }

    public abstract XDDFShapeProperties getOrAddMajorGridProperties();

    public abstract XDDFShapeProperties getOrAddMinorGridProperties();

    public abstract XDDFRunProperties getOrAddTextProperties();

    public CTTextCharacterProperties getOrAddTextProperties(CTTextBody cTTextBody) {
        if (cTTextBody.getBodyPr() == null) {
            cTTextBody.addNewBodyPr();
        }
        CTTextParagraph pArray = cTTextBody.sizeOfPArray() > 0 ? cTTextBody.getPArray(0) : cTTextBody.addNewP();
        CTTextParagraphProperties pPr = pArray.isSetPPr() ? pArray.getPPr() : pArray.addNewPPr();
        return pPr.isSetDefRPr() ? pPr.getDefRPr() : pPr.addNewDefRPr();
    }

    public AxisOrientation getOrientation() {
        return AxisOrientation.valueOf(getCTScaling().getOrientation().getVal());
    }

    public AxisPosition getPosition() {
        return AxisPosition.valueOf(getCTAxPos().getVal());
    }

    public AxisTickLabelPosition getTickLabelPosition() {
        return AxisTickLabelPosition.valueOf(getCTTickLblPos().getVal());
    }

    public abstract boolean hasNumberFormat();

    public boolean isSetLogBase() {
        return getCTScaling().isSetLogBase();
    }

    public abstract boolean isSetMajorUnit();

    public boolean isSetMaximum() {
        return getCTScaling().isSetMax();
    }

    public boolean isSetMinimum() {
        return getCTScaling().isSetMin();
    }

    public abstract boolean isSetMinorUnit();

    public boolean isVisible() {
        return !getDelete().getVal();
    }

    public void setCrosses(AxisCrosses axisCrosses) {
        getCTCrosses().setVal(axisCrosses.underlying);
    }

    public void setLogBase(double d) {
        if (d < MIN_LOG_BASE || MAX_LOG_BASE < d) {
            throw new IllegalArgumentException("Axis log base must be between 2 and 1000 (inclusive), got: " + d);
        }
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetLogBase()) {
            cTScaling.getLogBase().setVal(d);
        } else {
            cTScaling.addNewLogBase().setVal(d);
        }
    }

    public void setMajorTickMark(AxisTickMark axisTickMark) {
        getMajorCTTickMark().setVal(axisTickMark.underlying);
    }

    public abstract void setMajorUnit(double d);

    public void setMaximum(double d) {
        CTScaling cTScaling = getCTScaling();
        if (Double.isNaN(d)) {
            if (cTScaling.isSetMax()) {
                cTScaling.unsetMax();
            }
        } else if (cTScaling.isSetMax()) {
            cTScaling.getMax().setVal(d);
        } else {
            cTScaling.addNewMax().setVal(d);
        }
    }

    public void setMinimum(double d) {
        CTScaling cTScaling = getCTScaling();
        if (Double.isNaN(d)) {
            if (cTScaling.isSetMin()) {
                cTScaling.unsetMin();
            }
        } else if (cTScaling.isSetMin()) {
            cTScaling.getMin().setVal(d);
        } else {
            cTScaling.addNewMin().setVal(d);
        }
    }

    public void setMinorTickMark(AxisTickMark axisTickMark) {
        getMinorCTTickMark().setVal(axisTickMark.underlying);
    }

    public abstract void setMinorUnit(double d);

    public void setNumberFormat(String str) {
        getCTNumFmt().setFormatCode(str);
        getCTNumFmt().setSourceLinked(true);
    }

    public void setOrientation(AxisOrientation axisOrientation) {
        CTScaling cTScaling = getCTScaling();
        if (cTScaling.isSetOrientation()) {
            cTScaling.getOrientation().setVal(axisOrientation.underlying);
        } else {
            cTScaling.addNewOrientation().setVal(axisOrientation.underlying);
        }
    }

    public void setPosition(AxisPosition axisPosition) {
        getCTAxPos().setVal(axisPosition.underlying);
    }

    public void setTickLabelPosition(AxisTickLabelPosition axisTickLabelPosition) {
        getCTTickLblPos().setVal(axisTickLabelPosition.underlying);
    }

    public abstract void setTitle(String str);

    public void setVisible(boolean z6) {
        getDelete().setVal(!z6);
    }
}

package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XDDFManualLayout {
    private static final LayoutMode defaultLayoutMode = LayoutMode.EDGE;
    private static final LayoutTarget defaultLayoutTarget = LayoutTarget.INNER;
    private CTManualLayout layout;

    public XDDFManualLayout(CTLayout cTLayout) {
        initializeLayout(cTLayout);
    }

    private void initializeLayout(CTLayout cTLayout) {
        if (cTLayout.isSetManualLayout()) {
            this.layout = cTLayout.getManualLayout();
        } else {
            this.layout = cTLayout.addNewManualLayout();
        }
    }

    public XDDFChartExtensionList getExtensionList() {
        if (this.layout.isSetExtLst()) {
            return new XDDFChartExtensionList(this.layout.getExtLst());
        }
        return null;
    }

    public LayoutMode getHeightMode() {
        return !this.layout.isSetHMode() ? defaultLayoutMode : LayoutMode.valueOf(this.layout.getHMode().getVal());
    }

    public double getHeightRatio() {
        if (this.layout.isSetH()) {
            return this.layout.getH().getVal();
        }
        return 0.0d;
    }

    public LayoutTarget getTarget() {
        return !this.layout.isSetLayoutTarget() ? defaultLayoutTarget : LayoutTarget.valueOf(this.layout.getLayoutTarget().getVal());
    }

    public LayoutMode getWidthMode() {
        return !this.layout.isSetWMode() ? defaultLayoutMode : LayoutMode.valueOf(this.layout.getWMode().getVal());
    }

    public double getWidthRatio() {
        if (this.layout.isSetW()) {
            return this.layout.getW().getVal();
        }
        return 0.0d;
    }

    public double getX() {
        if (this.layout.isSetX()) {
            return this.layout.getX().getVal();
        }
        return 0.0d;
    }

    public LayoutMode getXMode() {
        return !this.layout.isSetXMode() ? defaultLayoutMode : LayoutMode.valueOf(this.layout.getXMode().getVal());
    }

    @Internal
    public CTManualLayout getXmlObject() {
        return this.layout;
    }

    public double getY() {
        if (this.layout.isSetY()) {
            return this.layout.getY().getVal();
        }
        return 0.0d;
    }

    public LayoutMode getYMode() {
        return !this.layout.isSetYMode() ? defaultLayoutMode : LayoutMode.valueOf(this.layout.getYMode().getVal());
    }

    public void setExtensionList(XDDFChartExtensionList xDDFChartExtensionList) {
        if (xDDFChartExtensionList != null) {
            this.layout.setExtLst(xDDFChartExtensionList.getXmlObject());
        } else if (this.layout.isSetExtLst()) {
            this.layout.unsetExtLst();
        }
    }

    public void setHeightMode(LayoutMode layoutMode) {
        if (!this.layout.isSetHMode()) {
            this.layout.addNewHMode();
        }
        this.layout.getHMode().setVal(layoutMode.underlying);
    }

    public void setHeightRatio(double d) {
        if (!this.layout.isSetH()) {
            this.layout.addNewH();
        }
        this.layout.getH().setVal(d);
    }

    public void setTarget(LayoutTarget layoutTarget) {
        if (!this.layout.isSetLayoutTarget()) {
            this.layout.addNewLayoutTarget();
        }
        this.layout.getLayoutTarget().setVal(layoutTarget.underlying);
    }

    public void setWidthMode(LayoutMode layoutMode) {
        if (!this.layout.isSetWMode()) {
            this.layout.addNewWMode();
        }
        this.layout.getWMode().setVal(layoutMode.underlying);
    }

    public void setWidthRatio(double d) {
        if (!this.layout.isSetW()) {
            this.layout.addNewW();
        }
        this.layout.getW().setVal(d);
    }

    public void setX(double d) {
        if (!this.layout.isSetX()) {
            this.layout.addNewX();
        }
        this.layout.getX().setVal(d);
    }

    public void setXMode(LayoutMode layoutMode) {
        if (!this.layout.isSetXMode()) {
            this.layout.addNewXMode();
        }
        this.layout.getXMode().setVal(layoutMode.underlying);
    }

    public void setY(double d) {
        if (!this.layout.isSetY()) {
            this.layout.addNewY();
        }
        this.layout.getY().setVal(d);
    }

    public void setYMode(LayoutMode layoutMode) {
        if (!this.layout.isSetYMode()) {
            this.layout.addNewYMode();
        }
        this.layout.getYMode().setVal(layoutMode.underlying);
    }

    public XDDFManualLayout(CTPlotArea cTPlotArea) {
        initializeLayout(cTPlotArea.isSetLayout() ? cTPlotArea.getLayout() : cTPlotArea.addNewLayout());
    }
}

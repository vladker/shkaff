package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFLayout {
    private CTLayout layout;

    public XDDFLayout() {
        this(CTLayout.Factory.newInstance());
    }

    public XDDFChartExtensionList getExtensionList() {
        if (this.layout.isSetExtLst()) {
            return new XDDFChartExtensionList(this.layout.getExtLst());
        }
        return null;
    }

    public XDDFManualLayout getManualLayout() {
        if (this.layout.isSetManualLayout()) {
            return new XDDFManualLayout(this.layout);
        }
        return null;
    }

    @Internal
    public CTLayout getXmlObject() {
        return this.layout;
    }

    public void setExtensionList(XDDFChartExtensionList xDDFChartExtensionList) {
        if (xDDFChartExtensionList != null) {
            this.layout.setExtLst(xDDFChartExtensionList.getXmlObject());
        } else if (this.layout.isSetExtLst()) {
            this.layout.unsetExtLst();
        }
    }

    public void setManualLayout(XDDFManualLayout xDDFManualLayout) {
        if (xDDFManualLayout != null) {
            this.layout.setManualLayout(xDDFManualLayout.getXmlObject());
        } else if (this.layout.isSetManualLayout()) {
            this.layout.unsetManualLayout();
        }
    }

    @Internal
    public XDDFLayout(CTLayout cTLayout) {
        this.layout = cTLayout;
    }
}

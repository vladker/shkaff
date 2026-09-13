package org.apache.poi.xddf.usermodel.chart;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.poi.util.Internal;
import org.apache.poi.util.k;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XDDFChartLegend implements TextContainer {
    private CTLegend legend;

    public XDDFChartLegend(CTChart cTChart) {
        this.legend = cTChart.isSetLegend() ? cTChart.getLegend() : cTChart.addNewLegend();
        setDefaults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFLegendEntry lambda$getEntries$0(CTLegendEntry cTLegendEntry) {
        return new XDDFLegendEntry(cTLegendEntry);
    }

    private void setDefaults() {
        if (!this.legend.isSetOverlay()) {
            this.legend.addNewOverlay();
        }
        this.legend.getOverlay().setVal(false);
    }

    public XDDFLegendEntry addEntry() {
        return new XDDFLegendEntry(this.legend.addNewLegendEntry());
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function) {
        return Optional.empty();
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        return Optional.empty();
    }

    public List<XDDFLegendEntry> getEntries() {
        return (List) this.legend.getLegendEntryList().stream().map(new k(11)).collect(Collectors.toList());
    }

    public XDDFLegendEntry getEntry(int i5) {
        return new XDDFLegendEntry(this.legend.getLegendEntryArray(i5));
    }

    public XDDFChartExtensionList getExtensionList() {
        if (this.legend.isSetExtLst()) {
            return new XDDFChartExtensionList(this.legend.getExtLst());
        }
        return null;
    }

    public XDDFLayout getLayout() {
        if (this.legend.isSetLayout()) {
            return new XDDFLayout(this.legend.getLayout());
        }
        return null;
    }

    public XDDFManualLayout getOrAddManualLayout() {
        if (!this.legend.isSetLayout()) {
            this.legend.addNewLayout();
        }
        return new XDDFManualLayout(this.legend.getLayout());
    }

    public LegendPosition getPosition() {
        return this.legend.isSetLegendPos() ? LegendPosition.valueOf(this.legend.getLegendPos().getVal()) : LegendPosition.RIGHT;
    }

    @Internal
    public CTShapeProperties getShapeProperties() {
        if (this.legend.isSetSpPr()) {
            return this.legend.getSpPr();
        }
        return null;
    }

    public XDDFTextBody getTextBody() {
        if (this.legend.isSetTxPr()) {
            return new XDDFTextBody(this, this.legend.getTxPr());
        }
        return null;
    }

    @Internal
    public CTLegend getXmlObject() {
        return this.legend;
    }

    public boolean isOverlay() {
        return this.legend.getOverlay().getVal();
    }

    public void setExtensionList(XDDFChartExtensionList xDDFChartExtensionList) {
        if (xDDFChartExtensionList != null) {
            this.legend.setExtLst(xDDFChartExtensionList.getXmlObject());
        } else if (this.legend.isSetExtLst()) {
            this.legend.unsetExtLst();
        }
    }

    public void setLayout(XDDFLayout xDDFLayout) {
        if (xDDFLayout != null) {
            this.legend.setLayout(xDDFLayout.getXmlObject());
        } else if (this.legend.isSetLayout()) {
            this.legend.unsetLayout();
        }
    }

    public void setOverlay(boolean z6) {
        this.legend.getOverlay().setVal(z6);
    }

    public void setPosition(LegendPosition legendPosition) {
        if (!this.legend.isSetLegendPos()) {
            this.legend.addNewLegendPos();
        }
        this.legend.getLegendPos().setVal(legendPosition.underlying);
    }

    @Internal
    public void setShapeProperties(CTShapeProperties cTShapeProperties) {
        if (cTShapeProperties != null) {
            this.legend.setSpPr(cTShapeProperties);
        } else if (this.legend.isSetSpPr()) {
            this.legend.unsetSpPr();
        }
    }

    public void setTextBody(XDDFTextBody xDDFTextBody) {
        if (xDDFTextBody != null) {
            this.legend.setTxPr(xDDFTextBody.getXmlObject());
        } else if (this.legend.isSetTxPr()) {
            this.legend.unsetTxPr();
        }
    }
}

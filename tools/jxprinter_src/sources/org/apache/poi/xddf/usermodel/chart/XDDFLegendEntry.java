package org.apache.poi.xddf.usermodel.chart;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFLegendEntry implements TextContainer {
    private CTLegendEntry entry;

    @Internal
    public XDDFLegendEntry(CTLegendEntry cTLegendEntry) {
        this.entry = cTLegendEntry;
        if (cTLegendEntry.getIdx() == null) {
            cTLegendEntry.addNewIdx().setVal(0L);
        }
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function) {
        return Optional.empty();
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        return Optional.empty();
    }

    public boolean getDelete() {
        if (this.entry.isSetDelete()) {
            return this.entry.getDelete().getVal();
        }
        return false;
    }

    public XDDFChartExtensionList getExtensionList() {
        if (this.entry.isSetExtLst()) {
            return new XDDFChartExtensionList(this.entry.getExtLst());
        }
        return null;
    }

    public long getIndex() {
        return this.entry.getIdx().getVal();
    }

    public XDDFTextBody getTextBody() {
        if (this.entry.isSetTxPr()) {
            return new XDDFTextBody(this, this.entry.getTxPr());
        }
        return null;
    }

    @Internal
    public CTLegendEntry getXmlObject() {
        return this.entry;
    }

    public void setDelete(Boolean bool) {
        if (bool == null) {
            if (this.entry.isSetDelete()) {
                this.entry.unsetDelete();
            }
        } else if (this.entry.isSetDelete()) {
            this.entry.getDelete().setVal(bool.booleanValue());
        } else {
            this.entry.addNewDelete().setVal(bool.booleanValue());
        }
    }

    public void setExtensionList(XDDFChartExtensionList xDDFChartExtensionList) {
        if (xDDFChartExtensionList != null) {
            this.entry.setExtLst(xDDFChartExtensionList.getXmlObject());
        } else if (this.entry.isSetExtLst()) {
            this.entry.unsetExtLst();
        }
    }

    public void setIndex(long j6) {
        this.entry.getIdx().setVal(j6);
    }

    public void setTextBody(XDDFTextBody xDDFTextBody) {
        if (xDDFTextBody != null) {
            this.entry.setTxPr(xDDFTextBody.getXmlObject());
        } else if (this.entry.isSetTxPr()) {
            this.entry.unsetTxPr();
        }
    }
}

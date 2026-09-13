package org.apache.poi.xssf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFHeaderFooterProperties {
    private final CTHeaderFooter headerFooter;

    public XSSFHeaderFooterProperties(CTHeaderFooter cTHeaderFooter) {
        this.headerFooter = cTHeaderFooter;
    }

    public boolean getAlignWithMargins() {
        return getHeaderFooter().isSetAlignWithMargins() && getHeaderFooter().getAlignWithMargins();
    }

    public boolean getDifferentFirst() {
        return getHeaderFooter().isSetDifferentFirst() && getHeaderFooter().getDifferentFirst();
    }

    public boolean getDifferentOddEven() {
        return getHeaderFooter().isSetDifferentOddEven() && getHeaderFooter().getDifferentOddEven();
    }

    @Internal
    public CTHeaderFooter getHeaderFooter() {
        return this.headerFooter;
    }

    public boolean getScaleWithDoc() {
        return getHeaderFooter().isSetScaleWithDoc() && getHeaderFooter().getScaleWithDoc();
    }

    public void removeAlignWithMargins() {
        if (getHeaderFooter().isSetAlignWithMargins()) {
            getHeaderFooter().unsetAlignWithMargins();
        }
    }

    public void removeDifferentFirst() {
        if (getHeaderFooter().isSetDifferentFirst()) {
            getHeaderFooter().unsetDifferentFirst();
        }
    }

    public void removeDifferentOddEven() {
        if (getHeaderFooter().isSetDifferentOddEven()) {
            getHeaderFooter().unsetDifferentOddEven();
        }
    }

    public void removeScaleWithDoc() {
        if (getHeaderFooter().isSetScaleWithDoc()) {
            getHeaderFooter().unsetScaleWithDoc();
        }
    }

    public void setAlignWithMargins(boolean z6) {
        getHeaderFooter().setAlignWithMargins(z6);
    }

    public void setDifferentFirst(boolean z6) {
        getHeaderFooter().setDifferentFirst(z6);
    }

    public void setDifferentOddEven(boolean z6) {
        getHeaderFooter().setDifferentOddEven(z6);
    }

    public void setScaleWithDoc(boolean z6) {
        getHeaderFooter().setScaleWithDoc(z6);
    }
}

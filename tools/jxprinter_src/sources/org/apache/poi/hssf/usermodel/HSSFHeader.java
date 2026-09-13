package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.HeaderRecord;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.ss.usermodel.Header;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFHeader extends HeaderFooter implements Header {
    private final PageSettingsBlock _psb;

    public HSSFHeader(PageSettingsBlock pageSettingsBlock) {
        this._psb = pageSettingsBlock;
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    public String getRawText() {
        HeaderRecord header = this._psb.getHeader();
        return header == null ? "" : header.getText();
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    public void setHeaderFooterText(String str) {
        HeaderRecord header = this._psb.getHeader();
        if (header != null) {
            header.setText(str);
        } else {
            this._psb.setHeader(new HeaderRecord(str));
        }
    }
}

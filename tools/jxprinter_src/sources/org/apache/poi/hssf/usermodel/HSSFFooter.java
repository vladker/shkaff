package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.FooterRecord;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.ss.usermodel.Footer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFFooter extends HeaderFooter implements Footer {
    private final PageSettingsBlock _psb;

    public HSSFFooter(PageSettingsBlock pageSettingsBlock) {
        this._psb = pageSettingsBlock;
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    public String getRawText() {
        FooterRecord footer = this._psb.getFooter();
        return footer == null ? "" : footer.getText();
    }

    @Override // org.apache.poi.hssf.usermodel.HeaderFooter
    public void setHeaderFooterText(String str) {
        FooterRecord footer = this._psb.getFooter();
        if (footer != null) {
            footer.setText(str);
        } else {
            this._psb.setFooter(new FooterRecord(str));
        }
    }
}

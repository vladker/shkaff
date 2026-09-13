package org.apache.poi.xssf.binary;

import org.apache.logging.log4j.util.Chars;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSSFBHeaderFooter {
    private static final HeaderFooterHelper HEADER_FOOTER_HELPER = new HeaderFooterHelper();
    private final String headerFooterTypeLabel;
    private final boolean isHeader;
    private String rawString;

    public XSSFBHeaderFooter(String str, boolean z6) {
        this.headerFooterTypeLabel = str;
        this.isHeader = z6;
    }

    public String getHeaderFooterTypeLabel() {
        return this.headerFooterTypeLabel;
    }

    public String getRawString() {
        return this.rawString;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();
        HeaderFooterHelper headerFooterHelper = HEADER_FOOTER_HELPER;
        String leftSection = headerFooterHelper.getLeftSection(this.rawString);
        String centerSection = headerFooterHelper.getCenterSection(this.rawString);
        String rightSection = headerFooterHelper.getRightSection(this.rawString);
        if (leftSection != null && leftSection.length() > 0) {
            sb.append(leftSection);
        }
        if (centerSection != null && centerSection.length() > 0) {
            if (sb.length() > 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(centerSection);
        }
        if (rightSection != null && rightSection.length() > 0) {
            if (sb.length() > 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(rightSection);
        }
        return sb.toString();
    }

    public boolean isHeader() {
        return this.isHeader;
    }

    public void setRawString(String str) {
        this.rawString = str;
    }
}

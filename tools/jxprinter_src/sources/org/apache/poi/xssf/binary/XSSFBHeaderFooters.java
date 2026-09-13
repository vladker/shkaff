package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSSFBHeaderFooters {
    private XSSFBHeaderFooter footer;
    private XSSFBHeaderFooter footerEven;
    private XSSFBHeaderFooter footerFirst;
    private XSSFBHeaderFooter header;
    private XSSFBHeaderFooter headerEven;
    private XSSFBHeaderFooter headerFirst;

    public static XSSFBHeaderFooters parse(byte[] bArr) {
        XSSFBHeaderFooters xSSFBHeaderFooters = new XSSFBHeaderFooters();
        xSSFBHeaderFooters.header = new XSSFBHeaderFooter("header", true);
        xSSFBHeaderFooters.footer = new XSSFBHeaderFooter("footer", false);
        xSSFBHeaderFooters.headerEven = new XSSFBHeaderFooter("evenHeader", true);
        xSSFBHeaderFooters.footerEven = new XSSFBHeaderFooter("evenFooter", false);
        xSSFBHeaderFooters.headerFirst = new XSSFBHeaderFooter("firstHeader", true);
        xSSFBHeaderFooters.footerFirst = new XSSFBHeaderFooter("firstFooter", false);
        int headerFooter = readHeaderFooter(bArr, 2, xSSFBHeaderFooters.header) + 2;
        int headerFooter2 = headerFooter + readHeaderFooter(bArr, headerFooter, xSSFBHeaderFooters.footer);
        int headerFooter3 = headerFooter2 + readHeaderFooter(bArr, headerFooter2, xSSFBHeaderFooters.headerEven);
        int headerFooter4 = headerFooter3 + readHeaderFooter(bArr, headerFooter3, xSSFBHeaderFooters.footerEven);
        readHeaderFooter(bArr, headerFooter4 + readHeaderFooter(bArr, headerFooter4, xSSFBHeaderFooters.headerFirst), xSSFBHeaderFooters.footerFirst);
        return xSSFBHeaderFooters;
    }

    private static int readHeaderFooter(byte[] bArr, int i5, XSSFBHeaderFooter xSSFBHeaderFooter) {
        if (i5 + 4 >= bArr.length) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int xLNullableWideString = XSSFBUtils.readXLNullableWideString(bArr, i5, sb);
        xSSFBHeaderFooter.setRawString(sb.toString());
        return xLNullableWideString;
    }

    public XSSFBHeaderFooter getFooter() {
        return this.footer;
    }

    public XSSFBHeaderFooter getFooterEven() {
        return this.footerEven;
    }

    public XSSFBHeaderFooter getFooterFirst() {
        return this.footerFirst;
    }

    public XSSFBHeaderFooter getHeader() {
        return this.header;
    }

    public XSSFBHeaderFooter getHeaderEven() {
        return this.headerEven;
    }

    public XSSFBHeaderFooter getHeaderFirst() {
        return this.headerFirst;
    }
}

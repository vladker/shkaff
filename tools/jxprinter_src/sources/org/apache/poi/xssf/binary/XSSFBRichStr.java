package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSSFBRichStr {
    private final String phoneticString;
    private final String string;

    public XSSFBRichStr(String str, String str2) {
        this.string = str;
        this.phoneticString = str2;
    }

    public static XSSFBRichStr build(byte[] bArr, int i5) {
        byte b = bArr[i5];
        StringBuilder sb = new StringBuilder();
        XSSFBUtils.readXLWideString(bArr, i5 + 1, sb);
        return new XSSFBRichStr(sb.toString(), "");
    }

    public String getString() {
        return this.string;
    }
}

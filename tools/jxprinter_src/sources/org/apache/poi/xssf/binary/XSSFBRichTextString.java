package org.apache.poi.xssf.binary;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.util.Internal;
import org.apache.poi.util.NotImplemented;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSSFBRichTextString extends XSSFRichTextString {
    private final String string;

    public XSSFBRichTextString(String str) {
        this.string = str;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public void applyFont(int i5, int i6, Font font) {
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public int getIndexOfFormattingRun(int i5) {
        return 0;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        return this.string;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    public int length() {
        return this.string.length();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public int numFormattingRuns() {
        return 0;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public void applyFont(int i5, int i6, short s6) {
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public void applyFont(Font font) {
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public void applyFont(short s6) {
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFRichTextString, org.apache.poi.ss.usermodel.RichTextString
    @NotImplemented
    public void clearFormatting() {
    }
}

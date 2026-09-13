package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class HeaderFooter implements org.apache.poi.ss.usermodel.HeaderFooter {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum MarkupTag {
        SHEET_NAME_FIELD("&A", false),
        DATE_FIELD(HeaderFooterHelper.HeaderFooterEntity_Date, false),
        FILE_FIELD(HeaderFooterHelper.HeaderFooterEntity_File, false),
        FULL_FILE_FIELD("&Z", false),
        PAGE_FIELD("&P", false),
        TIME_FIELD(HeaderFooterHelper.HeaderFooterEntity_Time, false),
        NUM_PAGES_FIELD("&N", false),
        PICTURE_FIELD("&G", false),
        BOLD_FIELD("&B", true),
        ITALIC_FIELD("&I", true),
        STRIKETHROUGH_FIELD("&S", true),
        SUBSCRIPT_FIELD("&Y", true),
        SUPERSCRIPT_FIELD("&X", true),
        UNDERLINE_FIELD("&U", true),
        DOUBLE_UNDERLINE_FIELD("&E", true);

        private final boolean _occursInPairs;
        private final String _representation;

        MarkupTag(String str, boolean z6) {
            this._representation = str;
            this._occursInPairs = z6;
        }

        public String getRepresentation() {
            return this._representation;
        }

        public boolean occursPairs() {
            return this._occursInPairs;
        }
    }

    public static String date() {
        return MarkupTag.DATE_FIELD.getRepresentation();
    }

    public static String endBold() {
        return MarkupTag.BOLD_FIELD.getRepresentation();
    }

    public static String endDoubleUnderline() {
        return MarkupTag.DOUBLE_UNDERLINE_FIELD.getRepresentation();
    }

    public static String endUnderline() {
        return MarkupTag.UNDERLINE_FIELD.getRepresentation();
    }

    public static String file() {
        return MarkupTag.FILE_FIELD.getRepresentation();
    }

    public static String font(String str, String str2) {
        return androidx.collection.a.p("&\"", str, ",", str2, "\"");
    }

    public static String fontSize(short s6) {
        return AbstractC0157z.k(s6, "&");
    }

    public static String numPages() {
        return MarkupTag.NUM_PAGES_FIELD.getRepresentation();
    }

    public static String page() {
        return MarkupTag.PAGE_FIELD.getRepresentation();
    }

    private String[] splitParts() {
        String rawText = getRawText();
        String strSubstring = "";
        String strSubstring2 = "";
        String strSubstring3 = strSubstring2;
        while (rawText.length() > 1) {
            if (rawText.charAt(0) == '&') {
                int length = rawText.length();
                char cCharAt = rawText.charAt(1);
                if (cCharAt == 'C') {
                    if (rawText.contains("&L")) {
                        length = Math.min(length, rawText.indexOf("&L"));
                    }
                    if (rawText.contains("&R")) {
                        length = Math.min(length, rawText.indexOf("&R"));
                    }
                    strSubstring2 = rawText.substring(2, length);
                    rawText = rawText.substring(length);
                } else if (cCharAt == 'L') {
                    if (rawText.contains("&C")) {
                        length = Math.min(length, rawText.indexOf("&C"));
                    }
                    if (rawText.contains("&R")) {
                        length = Math.min(length, rawText.indexOf("&R"));
                    }
                    strSubstring = rawText.substring(2, length);
                    rawText = rawText.substring(length);
                } else if (cCharAt == 'R') {
                    if (rawText.contains("&C")) {
                        length = Math.min(length, rawText.indexOf("&C"));
                    }
                    if (rawText.contains("&L")) {
                        length = Math.min(length, rawText.indexOf("&L"));
                    }
                    strSubstring3 = rawText.substring(2, length);
                    rawText = rawText.substring(length);
                }
            }
            return new String[]{strSubstring, rawText, strSubstring3};
        }
        rawText = strSubstring2;
        return new String[]{strSubstring, rawText, strSubstring3};
    }

    public static String startBold() {
        return MarkupTag.BOLD_FIELD.getRepresentation();
    }

    public static String startDoubleUnderline() {
        return MarkupTag.DOUBLE_UNDERLINE_FIELD.getRepresentation();
    }

    public static String startUnderline() {
        return MarkupTag.UNDERLINE_FIELD.getRepresentation();
    }

    public static String stripFields(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        for (MarkupTag markupTag : MarkupTag.values()) {
            String representation = markupTag.getRepresentation();
            while (true) {
                int iIndexOf = str.indexOf(representation);
                if (iIndexOf >= 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(0, iIndexOf));
                    str = androidx.exifinterface.media.a.j(str, representation.length() + iIndexOf, sb);
                }
            }
        }
        return str.replaceAll("&\\d+", "").replaceAll("&\".*?,.*?\"", "").replaceAll("&K[\\dA-F]{6}", "").replaceAll("&K[\\d]{2}[+][\\d]{3}", "").replaceAll("&&", "&");
    }

    public static String tab() {
        return MarkupTag.SHEET_NAME_FIELD.getRepresentation();
    }

    public static String time() {
        return MarkupTag.TIME_FIELD.getRepresentation();
    }

    private void updateHeaderFooterText(String[] strArr) {
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        if (str2.length() < 1 && str.length() < 1 && str3.length() < 1) {
            setHeaderFooterText("");
            return;
        }
        StringBuilder sbU = androidx.exifinterface.media.a.u(64, "&C", str2, "&L", str);
        sbU.append("&R");
        sbU.append(str3);
        setHeaderFooterText(sbU.toString());
    }

    private void updatePart(int i5, String str) {
        String[] strArrSplitParts = splitParts();
        if (str == null) {
            str = "";
        }
        strArrSplitParts[i5] = str;
        updateHeaderFooterText(strArrSplitParts);
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final String getCenter() {
        return splitParts()[1];
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final String getLeft() {
        return splitParts()[0];
    }

    public abstract String getRawText();

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final String getRight() {
        return splitParts()[2];
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final void setCenter(String str) {
        updatePart(1, str);
    }

    public abstract void setHeaderFooterText(String str);

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final void setLeft(String str) {
        updatePart(0, str);
    }

    @Override // org.apache.poi.ss.usermodel.HeaderFooter
    public final void setRight(String str) {
        updatePart(2, str);
    }
}

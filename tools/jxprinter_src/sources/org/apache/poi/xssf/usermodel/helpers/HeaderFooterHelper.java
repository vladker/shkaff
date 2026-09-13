package org.apache.poi.xssf.usermodel.helpers;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HeaderFooterHelper {
    private static final String HeaderFooterEntity_C = "&C";
    public static final String HeaderFooterEntity_Date = "&D";
    public static final String HeaderFooterEntity_File = "&F";
    private static final String HeaderFooterEntity_L = "&L";
    private static final String HeaderFooterEntity_R = "&R";
    public static final String HeaderFooterEntity_Time = "&T";

    private String[] getParts(String str) {
        int iIndexOf;
        int iIndexOf2;
        String[] strArr = {"", "", ""};
        if (str != null) {
            while (true) {
                int iIndexOf3 = str.indexOf(HeaderFooterEntity_L);
                if (iIndexOf3 <= -2 || (iIndexOf = str.indexOf(HeaderFooterEntity_C)) <= -2 || (iIndexOf2 = str.indexOf(HeaderFooterEntity_R)) <= -2 || (iIndexOf3 <= -1 && iIndexOf <= -1 && iIndexOf2 <= -1)) {
                    break;
                }
                if (iIndexOf2 > iIndexOf && iIndexOf2 > iIndexOf3) {
                    strArr[2] = str.substring(iIndexOf2 + 2);
                    str = str.substring(0, iIndexOf2);
                } else if (iIndexOf <= iIndexOf2 || iIndexOf <= iIndexOf3) {
                    strArr[0] = str.substring(iIndexOf3 + 2);
                    str = str.substring(0, iIndexOf3);
                } else {
                    strArr[1] = str.substring(iIndexOf + 2);
                    str = str.substring(0, iIndexOf);
                }
            }
        }
        return strArr;
    }

    private String joinParts(String[] strArr) {
        return joinParts(strArr[0], strArr[1], strArr[2]);
    }

    public String getCenterSection(String str) {
        return getParts(str)[1];
    }

    public String getLeftSection(String str) {
        return getParts(str)[0];
    }

    public String getRightSection(String str) {
        return getParts(str)[2];
    }

    public String setCenterSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[1] = str2;
        return joinParts(parts);
    }

    public String setLeftSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[0] = str2;
        return joinParts(parts);
    }

    public String setRightSection(String str, String str2) {
        String[] parts = getParts(str);
        parts[2] = str2;
        return joinParts(parts);
    }

    private String joinParts(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(64);
        if (str2.length() > 0) {
            sb.append(HeaderFooterEntity_C);
            sb.append(str2);
        }
        if (str.length() > 0) {
            sb.append(HeaderFooterEntity_L);
            sb.append(str);
        }
        if (str3.length() > 0) {
            sb.append(HeaderFooterEntity_R);
            sb.append(str3);
        }
        return sb.toString();
    }
}

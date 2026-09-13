package com.appdev.standard.page.printerlabel.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BarcodeUtil {
    public static String getEAN13Content(String str) {
        if (str.length() == 13) {
            return str;
        }
        if (str.length() != 12) {
            return "1234567891231";
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 <= str.length(); i7++) {
            try {
                int i8 = Integer.parseInt(String.valueOf(str.charAt(i7 - 1)));
                if (i7 % 2 == 0) {
                    i5 += i8;
                } else {
                    i6 += i8;
                }
            } catch (Exception unused) {
            }
        }
        return str + (10 - ((((i5 * 3) + i6) % 10) % 10));
    }

    public static String getEAN8Content(String str) {
        if (str.length() == 8) {
            return str;
        }
        if (str.length() != 7) {
            return "12345678";
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 <= str.length(); i7++) {
            try {
                int i8 = Integer.parseInt(String.valueOf(str.charAt(i7 - 1)));
                if (i7 % 2 == 0) {
                    i5 += i8;
                } else {
                    i6 += i8;
                }
            } catch (Exception unused) {
            }
        }
        return str + (10 - ((((i5 * 3) + i6) % 10) % 10));
    }

    public static String getUPCAContent(String str) {
        if (str.length() == 12) {
            return str;
        }
        if (str.length() != 11) {
            return "111111111117";
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 <= str.length(); i7++) {
            try {
                int i8 = Integer.parseInt(String.valueOf(str.charAt(i7 - 1)));
                if (i7 % 2 != 0) {
                    i5 += i8;
                } else {
                    i6 += i8;
                }
            } catch (Exception unused) {
            }
        }
        return str + ((10 - (((i5 * 3) + i6) % 10)) % 10);
    }

    public static String getUPCEContent(String str) {
        if (str.length() == 8 && (str.startsWith("0") || str.startsWith("1"))) {
            return str;
        }
        if (str.length() != 6 && str.length() != 7) {
            return "01234565";
        }
        int i5 = 0;
        if (str.length() == 6) {
            str = "0".concat(str);
        } else if (str.length() == 7 && !str.startsWith("0") && !str.startsWith("1")) {
            str = "0" + str.substring(0, 6);
        }
        int i6 = 0;
        for (int i7 = 1; i7 <= str.length(); i7++) {
            try {
                int i8 = Integer.parseInt(String.valueOf(str.charAt(i7 - 1)));
                if (i7 % 2 != 0) {
                    i5 += i8;
                } else {
                    i6 += i8;
                }
            } catch (Exception unused) {
            }
        }
        return str + ((10 - (((i5 * 3) + i6) % 10)) % 10);
    }
}

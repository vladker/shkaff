package org.apache.poi.xdgf.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Util {
    public static int countLines(String str) {
        int iIndexOf = 0;
        int i5 = 1;
        while (true) {
            iIndexOf = str.indexOf(10, iIndexOf) + 1;
            if (iIndexOf == 0) {
                return i5;
            }
            i5++;
        }
    }

    public static String sanitizeFilename(String str) {
        return str.replaceAll("[:\\\\/*\"?|<>]", "_");
    }
}

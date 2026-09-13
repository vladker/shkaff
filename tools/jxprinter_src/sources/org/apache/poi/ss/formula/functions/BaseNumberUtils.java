package org.apache.poi.ss.formula.functions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BaseNumberUtils {
    public static double convertToDecimal(String str, int i5, int i6) {
        long j6;
        int i7;
        if (str == null || str.length() == 0) {
            return 0.0d;
        }
        long length = str.length();
        long j7 = i6;
        if (length > j7) {
            throw new IllegalArgumentException();
        }
        boolean z6 = true;
        long j8 = 0;
        double d = 0.0d;
        for (char c : str.toCharArray()) {
            if ('0' > c || c > '9') {
                if ('A' <= c && c <= 'Z') {
                    i7 = c - 'A';
                } else if ('a' > c || c > 'z') {
                    j6 = i5;
                } else {
                    i7 = c - 'a';
                }
                j6 = 10 + ((long) i7);
            } else {
                j6 = ((long) c) - 48;
            }
            if (j6 >= i5) {
                throw new IllegalArgumentException("character not allowed");
            }
            if (z6) {
                z6 = false;
                j8 = j6;
            }
            d = (d * ((double) i5)) + j6;
        }
        return (z6 || length != j7 || j8 < ((long) (i5 / 2))) ? d : getTwoComplement(i5, i6, d) * (-1.0d);
    }

    private static double getTwoComplement(double d, double d6, double d7) {
        return Math.pow(d, d6) - d7;
    }
}

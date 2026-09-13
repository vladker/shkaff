package org.apache.xmlbeans.impl.common;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Levenshtein {
    public static int distance(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int i5 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length + 1, length2 + 1);
        for (int i6 = 0; i6 <= length; i6++) {
            iArr[i6][0] = i6;
        }
        for (int i7 = 0; i7 <= length2; i7++) {
            iArr[0][i7] = i7;
        }
        int i8 = 1;
        while (i8 <= length) {
            int i9 = i8 - 1;
            char cCharAt = str.charAt(i9);
            int i10 = 1;
            while (i10 <= length2) {
                int i11 = i10 - 1;
                int i12 = cCharAt == str2.charAt(i11) ? i5 : 1;
                int[] iArr2 = iArr[i8];
                int[] iArr3 = iArr[i9];
                iArr2[i10] = minimum(iArr3[i10] + 1, iArr2[i11] + 1, iArr3[i11] + i12);
                i10++;
                i5 = 0;
            }
            i8++;
            i5 = 0;
        }
        return iArr[length][length2];
    }

    private static int minimum(int i5, int i6, int i7) {
        if (i6 < i5) {
            i5 = i6;
        }
        return i7 < i5 ? i7 : i5;
    }
}

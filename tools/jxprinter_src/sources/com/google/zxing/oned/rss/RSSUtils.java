package com.google.zxing.oned.rss;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RSSUtils {
    private RSSUtils() {
    }

    private static int combins(int i5, int i6) {
        int i7 = i5 - i6;
        if (i7 > i6) {
            i7 = i6;
            i6 = i7;
        }
        int i8 = 1;
        int i9 = 1;
        while (i5 > i6) {
            i8 *= i5;
            if (i9 <= i7) {
                i8 /= i9;
                i9++;
            }
            i5--;
        }
        while (i9 <= i7) {
            i8 /= i9;
            i9++;
        }
        return i8;
    }

    public static int getRSSvalue(int[] iArr, int i5, boolean z6) {
        boolean z7;
        int[] iArr2 = iArr;
        int i6 = 0;
        for (int i7 : iArr2) {
            i6 += i7;
        }
        int length = iArr2.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int i11 = length - 1;
            if (i8 >= i11) {
                return i9;
            }
            int i12 = 1 << i8;
            i10 |= i12;
            int i13 = 1;
            while (i13 < iArr2[i8]) {
                int i14 = i6 - i13;
                int i15 = length - i8;
                int i16 = i15 - 2;
                int iCombins = combins(i14 - 1, i16);
                if (z6 && i10 == 0) {
                    int i17 = i15 - 1;
                    if (i14 - i17 >= i17) {
                        iCombins -= combins(i14 - i15, i16);
                    }
                }
                boolean z8 = true;
                if (i15 - 1 > 1) {
                    int i18 = i14 - i16;
                    int iCombins2 = 0;
                    while (i18 > i5) {
                        iCombins2 += combins((i14 - i18) - 1, i15 - 3);
                        i18--;
                        z8 = z8;
                    }
                    z7 = z8;
                    iCombins -= (i11 - i8) * iCombins2;
                } else {
                    z7 = true;
                    if (i14 > i5) {
                        iCombins--;
                    }
                }
                i9 += iCombins;
                i13++;
                i10 &= ~i12;
                iArr2 = iArr;
            }
            i6 -= i13;
            i8++;
            iArr2 = iArr;
        }
    }
}

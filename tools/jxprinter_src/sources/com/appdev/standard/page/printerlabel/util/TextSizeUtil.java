package com.appdev.standard.page.printerlabel.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TextSizeUtil {
    private float[] values = {5.0f, 5.5f, 6.5f, 7.5f, 8.0f, 9.0f, 10.0f, 10.5f, 11.0f, 12.0f, 14.0f, 16.0f, 18.0f, 20.0f, 22.0f, 26.0f, 28.0f, 36.0f, 48.0f, 56.0f, 72.0f};

    public float enlarge(float f6) {
        int i5 = 0;
        while (true) {
            float[] fArr = this.values;
            if (i5 > fArr.length - 1) {
                return fArr[fArr.length - 1];
            }
            float f7 = fArr[i5];
            if (f7 == f6) {
                return i5 != fArr.length + (-1) ? fArr[i5 + 1] : f7;
            }
            i5++;
        }
    }

    public float reduce(float f6) {
        int i5 = 0;
        while (true) {
            float[] fArr = this.values;
            if (i5 > fArr.length - 1) {
                return fArr[0];
            }
            if (fArr[i5] == f6) {
                return i5 != 0 ? fArr[i5 - 1] : fArr[0];
            }
            i5++;
        }
    }
}

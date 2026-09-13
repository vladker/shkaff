package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0038 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:55:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x007d A[SYNTHETIC] */
    public static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        boolean z6 = true;
        for (int i5 = 0; i5 < fArr.length && z6; i5 += 2) {
            int i6 = (int) fArr[i5];
            int i7 = i5 + 1;
            int i8 = (int) fArr[i7];
            if (i6 < -1 || i6 > width || i8 < -1 || i8 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i6 == -1) {
                fArr[i5] = 0.0f;
            } else {
                if (i6 == width) {
                    fArr[i5] = width - 1;
                } else {
                    z6 = false;
                }
                if (i8 == -1) {
                    fArr[i7] = 0.0f;
                } else {
                    if (i8 == height) {
                        fArr[i7] = height - 1;
                    }
                }
                z6 = true;
            }
            z6 = true;
            if (i8 == -1) {
                fArr[i7] = 0.0f;
            } else {
                if (i8 == height) {
                    fArr[i7] = height - 1;
                }
            }
            z6 = true;
        }
        boolean z7 = true;
        for (int length = fArr.length - 2; length >= 0 && z7; length -= 2) {
            int i9 = (int) fArr[length];
            int i10 = length + 1;
            int i11 = (int) fArr[i10];
            if (i9 < -1 || i9 > width || i11 < -1 || i11 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i9 == -1) {
                fArr[length] = 0.0f;
            } else {
                if (i9 == width) {
                    fArr[length] = width - 1;
                } else {
                    z7 = false;
                }
                if (i11 == -1) {
                    fArr[i10] = 0.0f;
                } else {
                    if (i11 == height) {
                        fArr[i10] = height - 1;
                    }
                }
                z7 = true;
            }
            z7 = true;
            if (i11 == -1) {
                fArr[i10] = 0.0f;
            } else {
                if (i11 == height) {
                    fArr[i10] = height - 1;
                }
            }
            z7 = true;
        }
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i5, int i6, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21);

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i5, int i6, PerspectiveTransform perspectiveTransform);
}

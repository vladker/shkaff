package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultGridSampler extends GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i5, int i6, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21) {
        return sampleGrid(bitMatrix, i5, i6, PerspectiveTransform.quadrilateralToQuadrilateral(f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, f20, f21));
    }

    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i5, int i6, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i5 > 0 && i6 > 0) {
            BitMatrix bitMatrix2 = new BitMatrix(i5, i6);
            int i7 = i5 * 2;
            float[] fArr = new float[i7];
            for (int i8 = 0; i8 < i6; i8++) {
                float f6 = i8 + 0.5f;
                for (int i9 = 0; i9 < i7; i9 += 2) {
                    fArr[i9] = (i9 / 2) + 0.5f;
                    fArr[i9 + 1] = f6;
                }
                perspectiveTransform.transformPoints(fArr);
                GridSampler.checkAndNudgePoints(bitMatrix, fArr);
                for (int i10 = 0; i10 < i7; i10 += 2) {
                    try {
                        if (bitMatrix.get((int) fArr[i10], (int) fArr[i10 + 1])) {
                            bitMatrix2.set(i10 / 2, i8);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
            }
            return bitMatrix2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}

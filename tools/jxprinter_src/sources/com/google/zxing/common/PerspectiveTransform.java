package com.google.zxing.common;

import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.a11 = f6;
        this.a12 = f9;
        this.a13 = f12;
        this.a21 = f7;
        this.a22 = f10;
        this.a23 = f13;
        this.a31 = f8;
        this.a32 = f11;
        this.a33 = f14;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21) {
        return squareToQuadrilateral(f14, f15, f16, f17, f18, f19, f20, f21).times(quadrilateralToSquare(f6, f7, f8, f9, f10, f11, f12, f13));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        return squareToQuadrilateral(f6, f7, f8, f9, f10, f11, f12, f13).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14 = ((f6 - f8) + f10) - f12;
        float f15 = ((f7 - f9) + f11) - f13;
        if (f14 == 0.0f && f15 == 0.0f) {
            return new PerspectiveTransform(f8 - f6, f10 - f8, f6, f9 - f7, f11 - f9, f7, 0.0f, 0.0f, 1.0f);
        }
        float f16 = f8 - f10;
        float f17 = f12 - f10;
        float f18 = f9 - f11;
        float f19 = f13 - f11;
        float f20 = (f16 * f19) - (f17 * f18);
        float fB = a.b(f17, f15, f19 * f14, f20);
        float fB2 = a.b(f14, f18, f16 * f15, f20);
        return new PerspectiveTransform((fB * f8) + (f8 - f6), (fB2 * f12) + (f12 - f6), f6, (fB * f9) + (f9 - f7), (fB2 * f13) + (f13 - f7), f7, fB, fB2, 1.0f);
    }

    public PerspectiveTransform buildAdjoint() {
        float f6 = this.a22;
        float f7 = this.a33;
        float f8 = this.a23;
        float f9 = this.a32;
        float f10 = (f6 * f7) - (f8 * f9);
        float f11 = this.a31;
        float f12 = this.a21;
        float f13 = (f8 * f11) - (f12 * f7);
        float f14 = (f12 * f9) - (f6 * f11);
        float f15 = this.a13;
        float f16 = this.a12;
        float f17 = (f15 * f9) - (f16 * f7);
        float f18 = this.a11;
        return new PerspectiveTransform(f10, f13, f14, f17, (f7 * f18) - (f15 * f11), (f11 * f16) - (f9 * f18), (f16 * f8) - (f15 * f6), (f15 * f12) - (f8 * f18), (f18 * f6) - (f16 * f12));
    }

    public PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        float f6 = this.a11;
        float f7 = perspectiveTransform.a11;
        float f8 = this.a21;
        float f9 = perspectiveTransform.a12;
        float f10 = this.a31;
        float f11 = perspectiveTransform.a13;
        float f12 = (f10 * f11) + (f8 * f9) + (f6 * f7);
        float f13 = perspectiveTransform.a21;
        float f14 = perspectiveTransform.a22;
        float f15 = perspectiveTransform.a23;
        float f16 = (f10 * f15) + (f8 * f14) + (f6 * f13);
        float f17 = perspectiveTransform.a31;
        float f18 = perspectiveTransform.a32;
        float f19 = perspectiveTransform.a33;
        float f20 = f10 * f19;
        float f21 = f20 + (f8 * f18) + (f6 * f17);
        float f22 = this.a12;
        float f23 = this.a22;
        float f24 = this.a32;
        float f25 = (f24 * f11) + (f23 * f9) + (f22 * f7);
        float f26 = (f24 * f15) + (f23 * f14) + (f22 * f13);
        float f27 = f24 * f19;
        float f28 = f27 + (f23 * f18) + (f22 * f17);
        float f29 = this.a13;
        float f30 = this.a23;
        float f31 = (f9 * f30) + (f7 * f29);
        float f32 = this.a33;
        return new PerspectiveTransform(f12, f16, f21, f25, f26, f28, (f11 * f32) + f31, (f15 * f32) + (f14 * f30) + (f13 * f29), (f32 * f19) + (f30 * f18) + (f29 * f17));
    }

    public void transformPoints(float[] fArr) {
        int length = fArr.length;
        float f6 = this.a11;
        float f7 = this.a12;
        float f8 = this.a13;
        float f9 = this.a21;
        float f10 = this.a22;
        float f11 = this.a23;
        float f12 = this.a31;
        float f13 = this.a32;
        float f14 = this.a33;
        for (int i5 = 0; i5 < length; i5 += 2) {
            float f15 = fArr[i5];
            int i6 = i5 + 1;
            float f16 = fArr[i6];
            float f17 = (f11 * f16) + (f8 * f15) + f14;
            fArr[i5] = (((f9 * f16) + (f6 * f15)) + f12) / f17;
            fArr[i6] = (((f16 * f10) + (f15 * f7)) + f13) / f17;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            float f6 = fArr[i5];
            float f7 = fArr2[i5];
            float f8 = (this.a23 * f7) + (this.a13 * f6) + this.a33;
            fArr[i5] = (((this.a21 * f7) + (this.a11 * f6)) + this.a31) / f8;
            fArr2[i5] = (((this.a22 * f7) + (this.a12 * f6)) + this.a32) / f8;
        }
    }
}

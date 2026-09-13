package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class VelocityMatrix {
    private static String sTag = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f6, float f7, int i5, int i6, float[] fArr) {
        float f8 = fArr[0];
        float f9 = fArr[1];
        float f10 = (f6 - 0.5f) * 2.0f;
        float f11 = (f7 - 0.5f) * 2.0f;
        float f12 = f8 + this.mDTranslateX;
        float f13 = f9 + this.mDTranslateY;
        float f14 = (this.mDScaleX * f10) + f12;
        float f15 = (this.mDScaleY * f11) + f13;
        float radians = (float) Math.toRadians(this.mRotate);
        float radians2 = (float) Math.toRadians(this.mDRotate);
        double d = radians;
        double d6 = i6 * f11;
        float fSin = (((float) ((Math.sin(d) * ((double) ((-i5) * f10))) - (Math.cos(d) * d6))) * radians2) + f14;
        float fCos = (radians2 * ((float) ((Math.cos(d) * ((double) (i5 * f10))) - (Math.sin(d) * d6)))) + f15;
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f6) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f6);
            this.mRotate = splineSet.get(f6);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f6) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f6);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f6);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f6) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f6);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f6);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f6) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f6);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f6) {
        if (keyCycleOscillator != null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f6);
        }
        if (keyCycleOscillator2 != null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f6);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f6) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f6);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f6);
        }
    }
}

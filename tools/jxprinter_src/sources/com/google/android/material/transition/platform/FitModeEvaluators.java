package com.google.android.material.transition.platform;

import A3.AbstractC0157z;
import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f6, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f6;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
            float fLerp = TransitionUtils.lerp(f9, f11, f7, f8, f6, true);
            float f13 = fLerp / f9;
            float f14 = fLerp / f11;
            return new FitModeResult(f13, f14, fLerp, f10 * f13, fLerp, f12 * f14);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f6, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f6;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
            float fLerp = TransitionUtils.lerp(f10, f12, f7, f8, f6, true);
            float f13 = fLerp / f10;
            float f14 = fLerp / f12;
            return new FitModeResult(f13, f14, f9 * f13, fLerp, f11 * f14, fLerp);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i5, boolean z6, RectF rectF, RectF rectF2) {
        if (i5 == 0) {
            return shouldAutoFitToWidth(z6, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i5 == 1) {
            return WIDTH;
        }
        if (i5 == 2) {
            return HEIGHT;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid fit mode: "));
    }

    private static boolean shouldAutoFitToWidth(boolean z6, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f6 = (fHeight2 * fWidth) / fWidth2;
        float f7 = (fWidth2 * fHeight) / fWidth;
        if (z6) {
            return f6 >= fHeight;
        }
        return f7 >= fHeight2;
    }
}

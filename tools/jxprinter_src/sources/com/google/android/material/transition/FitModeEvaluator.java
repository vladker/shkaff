package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f6, FitModeResult fitModeResult);

    FitModeResult evaluate(float f6, float f7, float f8, float f9, float f10, float f11, float f12);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}

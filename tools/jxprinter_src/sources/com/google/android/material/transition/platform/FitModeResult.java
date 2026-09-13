package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float f6, float f7, float f8, float f9, float f10, float f11) {
        this.startScale = f6;
        this.endScale = f7;
        this.currentStartWidth = f8;
        this.currentStartHeight = f9;
        this.currentEndWidth = f10;
        this.currentEndHeight = f11;
    }
}

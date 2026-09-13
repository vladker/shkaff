package com.google.android.material.transition;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i5, int i6, boolean z6) {
        this.startAlpha = i5;
        this.endAlpha = i6;
        this.endOnTop = z6;
    }

    public static FadeModeResult endOnTop(int i5, int i6) {
        return new FadeModeResult(i5, i6, true);
    }

    public static FadeModeResult startOnTop(int i5, int i6) {
        return new FadeModeResult(i5, i6, false);
    }
}

package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public TonalPalette f3321a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public TonalPalette f3322a2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public TonalPalette f3323a3;
    public TonalPalette error;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public TonalPalette f3324n1;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public TonalPalette f3325n2;

    private CorePalette(int i5, boolean z6) {
        Hct hctFromInt = Hct.fromInt(i5);
        double hue = hctFromInt.getHue();
        double chroma = hctFromInt.getChroma();
        if (z6) {
            this.f3321a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f3322a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f3323a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f3324n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f3325n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f3321a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f3322a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f3323a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f3324n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f3325n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static CorePalette contentOf(int i5) {
        return new CorePalette(i5, true);
    }

    public static CorePalette of(int i5) {
        return new CorePalette(i5, false);
    }
}

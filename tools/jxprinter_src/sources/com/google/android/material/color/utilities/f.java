package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3337a;
    public final /* synthetic */ MaterialDynamicColors b;

    public /* synthetic */ f(MaterialDynamicColors materialDynamicColors, int i5) {
        this.f3337a = i5;
        this.b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3337a) {
            case 0:
                return this.b.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
            case 1:
                return this.b.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
            case 2:
                return this.b.lambda$onTertiary$84((DynamicScheme) obj);
            case 3:
                return this.b.lambda$onError$96((DynamicScheme) obj);
            case 4:
                return this.b.lambda$onPrimaryContainer$62((DynamicScheme) obj);
            case 5:
                return this.b.lambda$onPrimaryContainer$63((DynamicScheme) obj);
            case 6:
                return this.b.lambda$secondaryFixedDim$122((DynamicScheme) obj);
            case 7:
                return this.b.lambda$primaryFixed$105((DynamicScheme) obj);
            case 8:
                return this.b.lambda$primaryFixedDim$108((DynamicScheme) obj);
            case 9:
                return this.b.lambda$tertiaryContainer$87((DynamicScheme) obj);
            default:
                return this.b.highestSurface((DynamicScheme) obj);
        }
    }
}

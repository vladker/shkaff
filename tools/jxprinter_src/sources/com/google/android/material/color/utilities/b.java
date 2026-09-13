package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3333a;
    public final /* synthetic */ MaterialDynamicColors b;

    public /* synthetic */ b(MaterialDynamicColors materialDynamicColors, int i5) {
        this.f3333a = i5;
        this.b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3333a) {
            case 0:
                return this.b.lambda$onSecondary$72((DynamicScheme) obj);
            case 1:
                return this.b.lambda$secondary$69((DynamicScheme) obj);
            case 2:
                return this.b.lambda$onSecondaryFixed$125((DynamicScheme) obj);
            case 3:
                return this.b.lambda$onSecondaryFixed$126((DynamicScheme) obj);
            case 4:
                return this.b.lambda$inverseOnSurface$41((DynamicScheme) obj);
            case 5:
                return this.b.lambda$onTertiaryContainer$89((DynamicScheme) obj);
            case 6:
                return this.b.lambda$onTertiaryContainer$90((DynamicScheme) obj);
            case 7:
                return this.b.lambda$onSecondaryContainer$77((DynamicScheme) obj);
            case 8:
                return this.b.lambda$onSecondaryContainer$78((DynamicScheme) obj);
            case 9:
                return this.b.lambda$onPrimaryFixed$111((DynamicScheme) obj);
            case 10:
                return this.b.lambda$onPrimaryFixed$112((DynamicScheme) obj);
            case 11:
                return this.b.lambda$error$93((DynamicScheme) obj);
            case 12:
                return this.b.lambda$onErrorContainer$102((DynamicScheme) obj);
            case 13:
                return this.b.lambda$errorContainer$99((DynamicScheme) obj);
            case 14:
                return this.b.lambda$tertiaryFixed$133((DynamicScheme) obj);
            case 15:
                return this.b.lambda$primary$54((DynamicScheme) obj);
            case 16:
                return this.b.lambda$onSecondaryFixedVariant$129((DynamicScheme) obj);
            case 17:
                return this.b.lambda$onSecondaryFixedVariant$130((DynamicScheme) obj);
            case 18:
                return this.b.lambda$tertiary$81((DynamicScheme) obj);
            case 19:
                return this.b.lambda$onTertiaryFixedVariant$143((DynamicScheme) obj);
            case 20:
                return this.b.lambda$onTertiaryFixedVariant$144((DynamicScheme) obj);
            case 21:
                return this.b.lambda$secondaryContainer$75((DynamicScheme) obj);
            case 22:
                return this.b.lambda$onTertiaryFixed$139((DynamicScheme) obj);
            case 23:
                return this.b.lambda$onTertiaryFixed$140((DynamicScheme) obj);
            case 24:
                return this.b.lambda$primaryContainer$60((DynamicScheme) obj);
            case 25:
                return this.b.lambda$onBackground$14((DynamicScheme) obj);
            case 26:
                return this.b.lambda$onPrimary$57((DynamicScheme) obj);
            case 27:
                return this.b.lambda$inversePrimary$66((DynamicScheme) obj);
            case 28:
                return this.b.lambda$secondaryFixed$119((DynamicScheme) obj);
            default:
                return this.b.lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
        }
    }
}

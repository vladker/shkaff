package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3336a;

    public /* synthetic */ e(int i5) {
        this.f3336a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f3336a) {
            case 0:
                return MaterialDynamicColors.lambda$surfaceBright$20(dynamicScheme);
            case 1:
                return dynamicScheme.primaryPalette;
            case 2:
                return MaterialDynamicColors.lambda$onPrimary$56(dynamicScheme);
            case 3:
                return dynamicScheme.primaryPalette;
            case 4:
                return MaterialDynamicColors.lambda$inversePrimary$65(dynamicScheme);
            case 5:
                return MaterialDynamicColors.lambda$onTertiary$83(dynamicScheme);
            case 6:
                return dynamicScheme.secondaryPalette;
            case 7:
                return MaterialDynamicColors.lambda$secondaryFixed$118(dynamicScheme);
            case 8:
                return dynamicScheme.primaryPalette;
            case 9:
                return MaterialDynamicColors.lambda$onPrimaryFixedVariant$114(dynamicScheme);
            case 10:
                return dynamicScheme.tertiaryPalette;
            case 11:
                return MaterialDynamicColors.lambda$tertiaryFixedDim$135(dynamicScheme);
            case 12:
                return dynamicScheme.errorPalette;
            case 13:
                return MaterialDynamicColors.lambda$onError$95(dynamicScheme);
            case 14:
                return dynamicScheme.neutralPalette;
            case 15:
                return MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157(dynamicScheme);
            case 16:
                return dynamicScheme.primaryPalette;
            case 17:
                return dynamicScheme.secondaryPalette;
            case 18:
                return MaterialDynamicColors.lambda$secondaryFixedDim$121(dynamicScheme);
            case 19:
                return dynamicScheme.neutralPalette;
            case 20:
                return dynamicScheme.neutralVariantPalette;
            case 21:
                return MaterialDynamicColors.lambda$surfaceVariant$34(dynamicScheme);
            case 22:
                return dynamicScheme.neutralVariantPalette;
            case 23:
                return MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$9(dynamicScheme);
            case 24:
                return dynamicScheme.neutralPalette;
            case 25:
                return MaterialDynamicColors.lambda$textHintInverse$161(dynamicScheme);
            case 26:
                return dynamicScheme.neutralPalette;
            case 27:
                return MaterialDynamicColors.lambda$shadow$47(dynamicScheme);
            case 28:
                return dynamicScheme.neutralPalette;
            default:
                return MaterialDynamicColors.lambda$onSurface$32(dynamicScheme);
        }
    }
}

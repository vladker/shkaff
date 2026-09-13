package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3334a;

    public /* synthetic */ c(int i5) {
        this.f3334a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f3334a) {
            case 0:
                return MaterialDynamicColors.lambda$textPrimaryInverse$153(dynamicScheme);
            case 1:
                return dynamicScheme.neutralPalette;
            case 2:
                return MaterialDynamicColors.lambda$surfaceContainer$26(dynamicScheme);
            case 3:
                return dynamicScheme.neutralVariantPalette;
            case 4:
                return MaterialDynamicColors.lambda$onSurfaceVariant$36(dynamicScheme);
            case 5:
                return dynamicScheme.neutralPalette;
            case 6:
                return MaterialDynamicColors.lambda$inverseSurface$38(dynamicScheme);
            case 7:
                return MaterialDynamicColors.lambda$surfaceDim$18(dynamicScheme);
            case 8:
                return dynamicScheme.errorPalette;
            case 9:
                return MaterialDynamicColors.lambda$onErrorContainer$101(dynamicScheme);
            case 10:
                return dynamicScheme.neutralVariantPalette;
            case 11:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverse$155(dynamicScheme);
            case 12:
                return dynamicScheme.errorPalette;
            case 13:
                return MaterialDynamicColors.lambda$errorContainer$98(dynamicScheme);
            case 14:
                return dynamicScheme.tertiaryPalette;
            case 15:
                return MaterialDynamicColors.lambda$tertiaryFixed$132(dynamicScheme);
            case 16:
                return dynamicScheme.neutralVariantPalette;
            case 17:
                return dynamicScheme.primaryPalette;
            case 18:
                return MaterialDynamicColors.lambda$primary$53(dynamicScheme);
            case 19:
                return dynamicScheme.neutralPalette;
            case 20:
                return MaterialDynamicColors.lambda$scrim$49(dynamicScheme);
            case 21:
                return dynamicScheme.secondaryPalette;
            case 22:
                return MaterialDynamicColors.lambda$onSecondaryFixedVariant$128(dynamicScheme);
            case 23:
                return MaterialDynamicColors.lambda$controlNormal$148(dynamicScheme);
            case 24:
                return dynamicScheme.tertiaryPalette;
            case 25:
                return MaterialDynamicColors.lambda$tertiary$80(dynamicScheme);
            case 26:
                return dynamicScheme.primaryPalette;
            case 27:
                return MaterialDynamicColors.lambda$controlActivated$146(dynamicScheme);
            case 28:
                return dynamicScheme.primaryPalette;
            default:
                return MaterialDynamicColors.lambda$primaryPaletteKeyColor$1(dynamicScheme);
        }
    }
}

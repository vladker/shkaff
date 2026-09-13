package com.google.android.material.color.utilities;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3335a;

    public /* synthetic */ d(int i5) {
        this.f3335a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f3335a) {
            case 0:
                return MaterialDynamicColors.lambda$surface$16(dynamicScheme);
            case 1:
                return dynamicScheme.tertiaryPalette;
            case 2:
                return MaterialDynamicColors.lambda$onTertiaryFixedVariant$142(dynamicScheme);
            case 3:
                return dynamicScheme.secondaryPalette;
            case 4:
                return MaterialDynamicColors.lambda$secondaryPaletteKeyColor$3(dynamicScheme);
            case 5:
                return dynamicScheme.neutralPalette;
            case 6:
                return MaterialDynamicColors.lambda$surfaceContainerLow$24(dynamicScheme);
            case 7:
                return dynamicScheme.secondaryPalette;
            case 8:
                return MaterialDynamicColors.lambda$secondaryContainer$74(dynamicScheme);
            case 9:
                return dynamicScheme.neutralPalette;
            case 10:
                return dynamicScheme.tertiaryPalette;
            case 11:
                return MaterialDynamicColors.lambda$onTertiaryFixed$138(dynamicScheme);
            case 12:
                return dynamicScheme.tertiaryPalette;
            case 13:
                return MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5(dynamicScheme);
            case 14:
                return dynamicScheme.neutralPalette;
            case 15:
                return MaterialDynamicColors.lambda$controlHighlight$150(dynamicScheme);
            case 16:
                return MaterialDynamicColors.lambda$controlHighlight$151(dynamicScheme);
            case 17:
                return MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159(dynamicScheme);
            case 18:
                return dynamicScheme.primaryPalette;
            case 19:
                return MaterialDynamicColors.lambda$primaryContainer$59(dynamicScheme);
            case 20:
                return dynamicScheme.neutralPalette;
            case 21:
                return MaterialDynamicColors.lambda$background$11(dynamicScheme);
            case 22:
                return dynamicScheme.neutralPalette;
            case 23:
                return MaterialDynamicColors.lambda$surfaceContainerHigh$28(dynamicScheme);
            case 24:
                return dynamicScheme.neutralPalette;
            case 25:
                return MaterialDynamicColors.lambda$onBackground$13(dynamicScheme);
            case 26:
                return dynamicScheme.tertiaryPalette;
            case 27:
                return dynamicScheme.neutralVariantPalette;
            case 28:
                return MaterialDynamicColors.lambda$outlineVariant$45(dynamicScheme);
            default:
                return dynamicScheme.neutralPalette;
        }
    }
}

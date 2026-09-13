package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UncontainedCarouselStrategy() {
    }

    private float calculateMediumChildSize(float f6, float f7, float f8) {
        float fMax = Math.max(1.5f * f8, f6);
        float f9 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f7;
        if (fMax > f9) {
            fMax = Math.max(f9, f8 * 1.2f);
        }
        return Math.min(f7, fMax);
    }

    private KeylineState createCenterAlignedKeylineState(float f6, float f7, float f8, int i5, float f9, float f10, float f11) {
        float fMin = Math.min(f10, f8);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, f8, f7);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f9, f8, f7);
        float f12 = f9 / 2.0f;
        float f13 = (f11 + 0.0f) - f12;
        float f14 = f13 + f12;
        float f15 = fMin / 2.0f;
        float f16 = (i5 * f8) + f14;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f8, f6).addAnchorKeyline((f13 - f12) - f15, childMaskPercentage, fMin).addKeyline(f13, childMaskPercentage2, f9, false).addKeylineRange((f8 / 2.0f) + f14, 0.0f, f8, i5, true);
        builderAddKeylineRange.addKeyline(f12 + f16, childMaskPercentage2, f9, false);
        builderAddKeylineRange.addAnchorKeyline(f16 + f9 + f15, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f6, float f7, float f8, int i5, float f9, int i6, float f10) {
        float fMin = Math.min(f10, f8);
        float fMax = Math.max(fMin, 0.5f * f9);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMax, f8, f6);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(fMin, f8, f6);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f9, f8, f6);
        float f11 = (i5 * f8) + 0.0f;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f8, f7).addAnchorKeyline(0.0f - (fMax / 2.0f), childMaskPercentage, fMax).addKeylineRange(f8 / 2.0f, 0.0f, f8, i5, true);
        if (i6 > 0) {
            float f12 = (f9 / 2.0f) + f11;
            f11 += f9;
            builderAddKeylineRange.addKeyline(f12, childMaskPercentage3, f9, false);
        }
        builderAddKeylineRange.addAnchorKeyline((CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f) + f11, childMaskPercentage2, fMin);
        return builderAddKeylineRange.build();
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean isContained() {
        return false;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f7 = measuredHeight;
        float f8 = f6;
        float f9 = f7 + f8;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f8;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f8;
        int iMax = Math.max(1, (int) Math.floor(containerWidth / f9));
        float f10 = containerWidth - (iMax * f9);
        if (carousel.getCarouselAlignment() == 1) {
            float f11 = f10 / 2.0f;
            return createCenterAlignedKeylineState(containerWidth, f8, f9, iMax, Math.max(Math.min(3.0f * f11, f9), getSmallItemSizeMin() + f8), extraSmallSize2, f11);
        }
        int i5 = 1;
        if (f10 <= 0.0f) {
            i5 = 0;
        }
        return createLeftAlignedKeylineState(view.getContext(), f8, containerWidth, f9, iMax, calculateMediumChildSize(extraSmallSize, f9, f10), i5, extraSmallSize2);
    }
}

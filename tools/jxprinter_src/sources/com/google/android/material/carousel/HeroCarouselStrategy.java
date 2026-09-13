package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f6;
        float fMax = Math.max(getSmallItemSizeMax() + f6, smallItemSizeMin);
        float f7 = containerHeight;
        float fMin = Math.min(measuredWidth + f6, f7);
        float fClamp = MathUtils.clamp((measuredWidth / 3.0f) + f6, smallItemSizeMin + f6, fMax + f6);
        float f8 = (fMin + fClamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        int i5 = 0;
        int[] iArr2 = f7 < 2.0f * smallItemSizeMin ? new int[]{0} : iArr;
        int iMax = (int) Math.max(1.0d, Math.floor(androidx.collection.a.b(fMax, CarouselStrategyHelper.maxValue(iArr), f7, fMin)));
        int iCeil = (((int) Math.ceil(f7 / fMin)) - iMax) + 1;
        int[] iArr3 = new int[iCeil];
        for (int i6 = 0; i6 < iCeil; i6++) {
            iArr3[i6] = iMax + i6;
        }
        int i7 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        Arrangement arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f7, fClamp, smallItemSizeMin, fMax, i7 != 0 ? CarouselStrategy.doubleCounts(iArr2) : iArr2, f8, i7 != 0 ? CarouselStrategy.doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, fMin, iArr3);
        this.keylineCount = arrangementFindLowestCostArrangement.getItemCount();
        if (arrangementFindLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            arrangementFindLowestCostArrangement = Arrangement.findLowestCostArrangement(f7, fClamp, smallItemSizeMin, fMax, iArr2, f8, MEDIUM_COUNTS, fMin, iArr3);
        } else {
            i5 = i7;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f6, f7, arrangementFindLowestCostArrangement, i5);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i5) {
        if (carousel.getCarouselAlignment() == 1) {
            return (i5 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i5 >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
        }
        return false;
    }
}

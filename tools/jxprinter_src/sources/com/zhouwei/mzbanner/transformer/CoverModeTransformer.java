package com.zhouwei.mzbanner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CoverModeTransformer implements ViewPager.PageTransformer {
    private int mCoverWidth;
    private ViewPager mViewPager;
    private float reduceX = 0.0f;
    private float itemWidth = 0.0f;
    private float offsetPosition = 0.0f;
    private float mScaleMax = 1.0f;
    private float mScaleMin = 0.9f;

    public CoverModeTransformer(ViewPager viewPager) {
        this.mViewPager = viewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f6) {
        if (this.offsetPosition == 0.0f) {
            float paddingLeft = this.mViewPager.getPaddingLeft();
            this.offsetPosition = paddingLeft / ((this.mViewPager.getMeasuredWidth() - paddingLeft) - this.mViewPager.getPaddingRight());
        }
        float f7 = f6 - this.offsetPosition;
        if (this.itemWidth == 0.0f) {
            float width = view.getWidth();
            this.itemWidth = width;
            this.reduceX = (((2.0f - this.mScaleMax) - this.mScaleMin) * width) / 2.0f;
        }
        if (f7 <= -1.0f) {
            view.setTranslationX(this.reduceX + this.mCoverWidth);
            view.setScaleX(this.mScaleMin);
            view.setScaleY(this.mScaleMin);
            return;
        }
        double d = f7;
        if (d > 1.0d) {
            view.setScaleX(this.mScaleMin);
            view.setScaleY(this.mScaleMin);
            view.setTranslationX((-this.reduceX) - this.mCoverWidth);
            return;
        }
        float fAbs = Math.abs(1.0f - Math.abs(f7)) * (this.mScaleMax - this.mScaleMin);
        float f8 = (-this.reduceX) * f7;
        if (d <= -0.5d) {
            view.setTranslationX(((Math.abs(Math.abs(f7) - 0.5f) * this.mCoverWidth) / 0.5f) + f8);
        } else if (f7 > 0.0f && d >= 0.5d) {
            view.setTranslationX(f8 - ((Math.abs(Math.abs(f7) - 0.5f) * this.mCoverWidth) / 0.5f));
        } else {
            view.setTranslationX(f8);
        }
        view.setScaleX(this.mScaleMin + fAbs);
        view.setScaleY(fAbs + this.mScaleMin);
    }
}

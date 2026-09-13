package com.zhouwei.mzbanner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ScaleYTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f6) {
        if (f6 < -1.0f) {
            view.setScaleY(MIN_SCALE);
        } else if (f6 <= 1.0f) {
            view.setScaleY(Math.max(MIN_SCALE, 1.0f - Math.abs(f6)));
        } else {
            view.setScaleY(MIN_SCALE);
        }
    }
}

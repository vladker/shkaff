package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i5, float f6, int i6) {
        if (this.mPageTransformer == null) {
            return;
        }
        float f7 = -f6;
        for (int i7 = 0; i7 < this.mLayoutManager.getChildCount(); i7++) {
            View childAt = this.mLayoutManager.getChildAt(i7);
            if (childAt == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException(a.m("LayoutManager returned a null child at pos ", i7, this.mLayoutManager.getChildCount(), PackagingURIHelper.FORWARD_SLASH_STRING, " while transforming pages"));
            }
            this.mPageTransformer.transformPage(childAt, (this.mLayoutManager.getPosition(childAt) - i5) + f7);
        }
    }

    public void setPageTransformer(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i5) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i5) {
    }
}

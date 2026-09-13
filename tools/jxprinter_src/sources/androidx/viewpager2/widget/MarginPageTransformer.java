package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int i5) {
        Preconditions.checkArgumentNonnegative(i5, "Margin must be non-negative");
        this.mMarginPx = i5;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        ViewPager2 viewPager2RequireViewPager = requireViewPager(view);
        float f7 = this.mMarginPx * f6;
        if (viewPager2RequireViewPager.getOrientation() != 0) {
            view.setTranslationY(f7);
            return;
        }
        if (viewPager2RequireViewPager.isRtl()) {
            f7 = -f7;
        }
        view.setTranslationX(f7);
    }
}

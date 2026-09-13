package N2;

import A3.AbstractC0157z;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f499a = Resources.getSystem().getDisplayMetrics().density;
    public static final float b;
    public static final float c;

    static {
        float fE = 1.0f / e(1.0f);
        b = fE;
        c = 1.0f - (e(1.0f) * fE);
    }

    public static int a(float f6) {
        return (int) ((f6 * f499a) + 0.5f);
    }

    public static boolean b(View view) {
        if (view instanceof I2.a) {
            return false;
        }
        return c(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static boolean c(View view) {
        if (view instanceof I2.a) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static boolean canLoadMore(@NonNull View view, PointF pointF, boolean z6) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !c(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(K2.a.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zCanLoadMore = canLoadMore(childAt, pointF, z6);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zCanLoadMore;
                }
            }
        }
        return z6 || view.canScrollVertically(-1);
    }

    public static boolean canRefresh(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(K2.a.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zCanRefresh = canRefresh(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zCanRefresh;
            }
        }
        return true;
    }

    public static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i5 = layoutParams.height;
        view.measure(childMeasureSpec, i5 > 0 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static float e(float f6) {
        float f7 = f6 * 8.0f;
        return f7 < 1.0f ? f7 - (1.0f - ((float) Math.exp(-f7))) : AbstractC0157z.a(1.0f, (float) Math.exp(1.0f - f7), 0.63212055f, 0.36787945f);
    }

    public static boolean isTransformedTouchPointInView(@NonNull View view, @NonNull View view2, float f6, float f7, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f6, f7};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f6;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f8 = fArr[0];
        boolean z6 = f8 >= 0.0f && scrollY >= 0.0f && f8 < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z6 && pointF != null) {
            pointF.set(fArr[0] - f6, fArr[1] - f7);
        }
        return z6;
    }

    public static void scrollListBy(@NonNull AbsListView absListView, int i5) {
        absListView.scrollListBy(i5);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        float fE = e(f6) * b;
        return fE > 0.0f ? fE + c : fE;
    }
}

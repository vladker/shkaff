package O2;

import H2.k;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements I2.b, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f551a;
    public final View b;
    public View c;
    public View d;
    public View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f552f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f553g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f554h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final M2.a f555i;

    public a(@NonNull View view) {
        M2.a aVar = new M2.a();
        aVar.f470a = true;
        this.f555i = aVar;
        this.c = view;
        this.b = view;
        this.f551a = view;
    }

    public static View c(View view, PointF pointF, View view2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (N2.b.isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && N2.b.b(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewC = c(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewC;
                }
            }
        }
        return view2;
    }

    public final boolean a() {
        if (!this.f554h) {
            return false;
        }
        View view = this.f551a;
        M2.a aVar = this.f555i;
        return N2.b.canLoadMore(view, (PointF) aVar.b, aVar.f470a);
    }

    public final boolean b() {
        return this.f553g && N2.b.canRefresh(this.f551a, (PointF) this.f555i.b);
    }

    public final void d(int i5, int i6, int i7) {
        boolean z6;
        View viewFindViewById;
        View viewFindViewById2;
        boolean z7 = true;
        View view = this.b;
        if (i6 == -1 || (viewFindViewById2 = view.findViewById(i6)) == null) {
            z6 = false;
        } else if (i5 > 0) {
            viewFindViewById2.setTranslationY(i5);
            z6 = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z6 = false;
        }
        if (i7 == -1 || (viewFindViewById = view.findViewById(i7)) == null) {
            z7 = z6;
        } else if (i5 < 0) {
            viewFindViewById.setTranslationY(i5);
        } else {
            if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
            z7 = z6;
        }
        if (z7) {
            view.setTranslationY(0.0f);
        } else {
            view.setTranslationY(i5);
        }
        View view2 = this.d;
        if (view2 != null) {
            view2.setTranslationY(Math.max(0, i5));
        }
        View view3 = this.e;
        if (view3 != null) {
            view3.setTranslationY(Math.min(0, i5));
        }
    }

    public final a e(int i5) {
        View view = this.c;
        if (view == null || i5 == 0) {
            return null;
        }
        if ((i5 >= 0 || !view.canScrollVertically(1)) && (i5 <= 0 || !this.c.canScrollVertically(-1))) {
            return null;
        }
        this.f552f = i5;
        return this;
    }

    public final void f(k kVar, View view, View view2) {
        View view3 = this.f551a;
        boolean zIsInEditMode = view3.isInEditMode();
        View view4 = null;
        while (true) {
            if (view4 != null && (!(view4 instanceof NestedScrollingParent) || (view4 instanceof NestedScrollingChild))) {
                break;
            }
            boolean z6 = view4 == null;
            LinkedList linkedList = new LinkedList();
            linkedList.add(view3);
            View view5 = null;
            while (linkedList.size() > 0 && view5 == null) {
                View view6 = (View) linkedList.poll();
                if (view6 != null) {
                    if ((z6 || view6 != view3) && N2.b.b(view6)) {
                        view5 = view6;
                    } else if (view6 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view6;
                        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                            linkedList.add(viewGroup.getChildAt(i5));
                        }
                    }
                }
            }
            if (view5 != null) {
                view3 = view5;
            }
            if (view3 == view4) {
                break;
            }
            if (!zIsInEditMode) {
                try {
                    if (view3 instanceof CoordinatorLayout) {
                        ((SmartRefreshLayout) kVar.getRefreshLayout()).setNestedScrollingEnabled(false);
                        ViewGroup viewGroup2 = (ViewGroup) view3;
                        for (int childCount = viewGroup2.getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = viewGroup2.getChildAt(childCount);
                            if (childAt instanceof AppBarLayout) {
                                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new N2.a(this));
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            view4 = view3;
        }
        if (view4 != null) {
            this.c = view4;
        }
        if (view == null && view2 == null) {
            return;
        }
        this.d = view;
        this.e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f551a.getContext());
        int iIndexOfChild = kVar.getRefreshLayout().getLayout().indexOfChild(this.f551a);
        kVar.getRefreshLayout().getLayout().removeView(this.f551a);
        frameLayout.addView(this.f551a, 0, new ViewGroup.LayoutParams(-1, -1));
        kVar.getRefreshLayout().getLayout().addView(frameLayout, iIndexOfChild, this.f551a.getLayoutParams());
        this.f551a = frameLayout;
        if (view != null) {
            view.setTag(K2.a.srl_tag, "fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup3.indexOfChild(view);
            viewGroup3.removeView(view);
            layoutParams.height = N2.b.d(view);
            viewGroup3.addView(new Space(this.f551a.getContext()), iIndexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag(K2.a.srl_tag, "fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup4.indexOfChild(view2);
            viewGroup4.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = N2.b.d(view2);
            viewGroup4.addView(new Space(this.f551a.getContext()), iIndexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    @Override // I2.b
    @NonNull
    public View getScrollableView() {
        return this.c;
    }

    @Override // I2.b
    @NonNull
    public View getView() {
        return this.f551a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f552f) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                N2.b.scrollListBy((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f552f = iIntValue;
    }
}

package H2;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f301a;
    public float b;
    public long c = 0;
    public long d = AnimationUtils.currentAnimationTimeMillis();
    public final /* synthetic */ SmartRefreshLayout e;

    public i(SmartRefreshLayout smartRefreshLayout, float f6) {
        this.e = smartRefreshLayout;
        this.b = f6;
        this.f301a = smartRefreshLayout.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.e;
        k kVar = smartRefreshLayout.f3723X0;
        if (smartRefreshLayout.j1 != this || smartRefreshLayout.f3724Y0.f375f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        long j6 = jCurrentAnimationTimeMillis - this.d;
        float fPow = (float) (Math.pow(0.98f, (jCurrentAnimationTimeMillis - this.c) / (1000.0f / 10)) * ((double) this.b));
        this.b = fPow;
        float f6 = ((j6 * 1.0f) / 1000.0f) * fPow;
        if (Math.abs(f6) <= 1.0f) {
            smartRefreshLayout.j1 = null;
            return;
        }
        this.d = jCurrentAnimationTimeMillis;
        int i5 = (int) (this.f301a + f6);
        this.f301a = i5;
        if (smartRefreshLayout.b * i5 > 0) {
            kVar.b(i5, true);
            smartRefreshLayout.f3722W0.postDelayed(this, 10);
            return;
        }
        smartRefreshLayout.j1 = null;
        kVar.b(0, true);
        View scrollableView = smartRefreshLayout.f3720U0.getScrollableView();
        int i6 = (int) (-this.b);
        float f7 = N2.b.f499a;
        if (scrollableView instanceof ScrollView) {
            ((ScrollView) scrollableView).fling(i6);
        } else if (scrollableView instanceof AbsListView) {
            ((AbsListView) scrollableView).fling(i6);
        } else if (scrollableView instanceof WebView) {
            ((WebView) scrollableView).flingScroll(0, i6);
        } else if (scrollableView instanceof NestedScrollView) {
            ((NestedScrollView) scrollableView).fling(i6);
        } else if (scrollableView instanceof RecyclerView) {
            ((RecyclerView) scrollableView).fling(0, i6);
        }
        if (!smartRefreshLayout.g1 || f6 <= 0.0f) {
            return;
        }
        smartRefreshLayout.g1 = false;
    }
}

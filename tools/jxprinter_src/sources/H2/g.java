package H2;

import android.animation.ValueAnimator;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f298a;
    public final /* synthetic */ float b;
    public final /* synthetic */ SmartRefreshLayout c;

    public g(float f6, int i5, SmartRefreshLayout smartRefreshLayout) {
        this.c = smartRefreshLayout;
        this.f298a = i5;
        this.b = f6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.c;
        if (smartRefreshLayout.f3725Z0 != J2.b.Refreshing) {
            return;
        }
        ValueAnimator valueAnimator = smartRefreshLayout.f3736k1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            smartRefreshLayout.f3736k1.cancel();
            smartRefreshLayout.f3736k1 = null;
        }
        smartRefreshLayout.f3733j = smartRefreshLayout.getMeasuredWidth() / 2.0f;
        smartRefreshLayout.f3723X0.setState(J2.b.PullDownToRefresh);
        int i5 = smartRefreshLayout.f3702H0;
        float f6 = i5 == 0 ? smartRefreshLayout.f3714P0 : i5;
        float f7 = this.b;
        if (f7 < 10.0f) {
            f7 *= f6;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(smartRefreshLayout.b, (int) f7);
        smartRefreshLayout.f3736k1 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.f298a);
        smartRefreshLayout.f3736k1.setInterpolator(new N2.b());
        smartRefreshLayout.f3736k1.addUpdateListener(new b(this, 1));
        smartRefreshLayout.f3736k1.addListener(new C5.e(this, 3));
        smartRefreshLayout.f3736k1.start();
    }
}

package H2;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f295a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ SmartRefreshLayout e;

    public d(SmartRefreshLayout smartRefreshLayout, int i5, Boolean bool, boolean z6) {
        this.e = smartRefreshLayout;
        this.b = i5;
        this.c = bool;
        this.d = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.e;
        int i5 = smartRefreshLayout.f3729f;
        k kVar = smartRefreshLayout.f3723X0;
        int i6 = this.f295a;
        if (i6 == 0) {
            J2.b bVar = smartRefreshLayout.f3724Y0;
            J2.b bVar2 = J2.b.None;
            Boolean bool = this.c;
            if (bVar == bVar2 && smartRefreshLayout.f3725Z0 == J2.b.Refreshing) {
                smartRefreshLayout.f3725Z0 = bVar2;
            } else {
                ValueAnimator valueAnimator = smartRefreshLayout.f3736k1;
                if (valueAnimator != null && bVar.f374a && (bVar.d || bVar == J2.b.RefreshReleased)) {
                    valueAnimator.setDuration(0L);
                    smartRefreshLayout.f3736k1.cancel();
                    smartRefreshLayout.f3736k1 = null;
                    if (kVar.a(0) == null) {
                        smartRefreshLayout.p(bVar2);
                    } else {
                        smartRefreshLayout.p(J2.b.PullDownCanceled);
                    }
                } else if (bVar == J2.b.Refreshing && smartRefreshLayout.f3718S0 != null && smartRefreshLayout.f3720U0 != null) {
                    this.f295a = i6 + 1;
                    smartRefreshLayout.f3722W0.postDelayed(this, this.b);
                    smartRefreshLayout.p(J2.b.RefreshFinish);
                    if (bool == Boolean.FALSE) {
                        smartRefreshLayout.r(false);
                    }
                }
            }
            if (bool == Boolean.TRUE) {
                smartRefreshLayout.r(true);
                return;
            }
            return;
        }
        int iOnFinish = smartRefreshLayout.f3718S0.onFinish(smartRefreshLayout, this.d);
        if (iOnFinish < Integer.MAX_VALUE) {
            if (smartRefreshLayout.f3739n || smartRefreshLayout.f3696D0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (smartRefreshLayout.f3739n) {
                    float f6 = smartRefreshLayout.f3734k;
                    smartRefreshLayout.f3732i = f6;
                    smartRefreshLayout.d = 0;
                    smartRefreshLayout.f3739n = false;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout.f3733j, (f6 + smartRefreshLayout.b) - (smartRefreshLayout.f3726a * 2), 0));
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout.f3733j, smartRefreshLayout.f3734k + smartRefreshLayout.b, 0));
                }
                if (smartRefreshLayout.f3696D0) {
                    smartRefreshLayout.f3694C0 = 0;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout.f3733j, smartRefreshLayout.f3734k, 0));
                    smartRefreshLayout.f3696D0 = false;
                    smartRefreshLayout.d = 0;
                }
            }
            int i7 = smartRefreshLayout.b;
            if (i7 <= 0) {
                if (i7 < 0) {
                    smartRefreshLayout.g(0, iOnFinish, smartRefreshLayout.f3763z, i5);
                    return;
                } else {
                    kVar.b(0, false);
                    kVar.setState(J2.b.None);
                    return;
                }
            }
            ValueAnimator valueAnimatorG = smartRefreshLayout.g(0, iOnFinish, smartRefreshLayout.f3763z, i5);
            O2.a aVarE = smartRefreshLayout.f3746q0 ? smartRefreshLayout.f3720U0.e(smartRefreshLayout.b) : null;
            if (valueAnimatorG == null || aVarE == null) {
                return;
            }
            valueAnimatorG.addUpdateListener(aVarE);
        }
    }
}

package H2;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.MotionEvent;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f297a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ SmartRefreshLayout d;

    public f(int i5, SmartRefreshLayout smartRefreshLayout, boolean z6) {
        this.d = smartRefreshLayout;
        this.b = i5;
        this.c = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.d;
        Handler handler = smartRefreshLayout.f3722W0;
        int i5 = this.f297a;
        boolean z6 = this.c;
        if (i5 != 0) {
            int iOnFinish = smartRefreshLayout.f3719T0.onFinish(smartRefreshLayout, true);
            if (iOnFinish < Integer.MAX_VALUE) {
                boolean z7 = z6 && smartRefreshLayout.f3707K && smartRefreshLayout.b < 0 && smartRefreshLayout.f3720U0.a();
                int i6 = smartRefreshLayout.b;
                int iMax = i6 - (z7 ? Math.max(i6, -smartRefreshLayout.f3706J0) : 0);
                if (smartRefreshLayout.f3739n || smartRefreshLayout.f3696D0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (smartRefreshLayout.f3739n) {
                        float f6 = smartRefreshLayout.f3734k;
                        smartRefreshLayout.f3732i = f6;
                        smartRefreshLayout.d = smartRefreshLayout.b - iMax;
                        smartRefreshLayout.f3739n = false;
                        float f7 = smartRefreshLayout.f3705J ? iMax : 0;
                        super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout.f3733j, f6 + f7 + (smartRefreshLayout.f3726a * 2), 0));
                        super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout.f3733j, smartRefreshLayout.f3734k + f7, 0));
                    }
                    if (smartRefreshLayout.f3696D0) {
                        smartRefreshLayout.f3694C0 = 0;
                        super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout.f3733j, smartRefreshLayout.f3734k, 0));
                        smartRefreshLayout.f3696D0 = false;
                        smartRefreshLayout.d = 0;
                    }
                }
                handler.postDelayed(new e(this, iMax, 0), smartRefreshLayout.b < 0 ? iOnFinish : 0L);
                return;
            }
            return;
        }
        J2.b bVar = smartRefreshLayout.f3724Y0;
        J2.b bVar2 = J2.b.None;
        if (bVar == bVar2 && smartRefreshLayout.f3725Z0 == J2.b.Loading) {
            smartRefreshLayout.f3725Z0 = bVar2;
        } else {
            ValueAnimator valueAnimator = smartRefreshLayout.f3736k1;
            if (valueAnimator != null && ((bVar.d || bVar == J2.b.LoadReleased) && bVar.b)) {
                valueAnimator.setDuration(0L);
                smartRefreshLayout.f3736k1.cancel();
                smartRefreshLayout.f3736k1 = null;
                if (smartRefreshLayout.f3723X0.a(0) == null) {
                    smartRefreshLayout.p(bVar2);
                } else {
                    smartRefreshLayout.p(J2.b.PullUpCanceled);
                }
            } else if (bVar == J2.b.Loading && smartRefreshLayout.f3719T0 != null && smartRefreshLayout.f3720U0 != null) {
                this.f297a = i5 + 1;
                handler.postDelayed(this, this.b);
                smartRefreshLayout.p(J2.b.LoadFinish);
                return;
            }
        }
        if (z6) {
            smartRefreshLayout.r(true);
        }
    }
}

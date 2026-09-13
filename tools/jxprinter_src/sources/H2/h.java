package H2;

import android.os.Handler;
import android.view.animation.AnimationUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final int b;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f300f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f299a = 0;
    public float d = 0.0f;
    public long c = AnimationUtils.currentAnimationTimeMillis();

    public h(float f6, int i5, SmartRefreshLayout smartRefreshLayout) {
        this.f300f = smartRefreshLayout;
        this.e = f6;
        this.b = i5;
        Handler handler = smartRefreshLayout.f3722W0;
        k kVar = smartRefreshLayout.f3723X0;
        handler.postDelayed(this, 10);
        if (f6 > 0.0f) {
            kVar.setState(J2.b.PullDownToRefresh);
        } else {
            kVar.setState(J2.b.PullUpToLoad);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        SmartRefreshLayout smartRefreshLayout = this.f300f;
        k kVar = smartRefreshLayout.f3723X0;
        if (smartRefreshLayout.j1 != this || smartRefreshLayout.f3724Y0.f375f) {
            return;
        }
        int iAbs = Math.abs(smartRefreshLayout.b);
        int i5 = this.b;
        if (iAbs < Math.abs(i5)) {
            double d = this.e;
            int i6 = this.f299a + 1;
            this.f299a = i6;
            this.e = (float) (Math.pow(0.949999988079071d, i6 * 2) * d);
        } else if (i5 != 0) {
            double d6 = this.e;
            int i7 = this.f299a + 1;
            this.f299a = i7;
            this.e = (float) (Math.pow(0.44999998807907104d, i7 * 2) * d6);
        } else {
            double d7 = this.e;
            int i8 = this.f299a + 1;
            this.f299a = i8;
            this.e = (float) (Math.pow(0.8500000238418579d, i8 * 2) * d7);
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float f6 = this.e * (((jCurrentAnimationTimeMillis - this.c) * 1.0f) / 1000.0f);
        if (Math.abs(f6) >= 1.0f) {
            this.c = jCurrentAnimationTimeMillis;
            float f7 = this.d + f6;
            this.d = f7;
            smartRefreshLayout.o(f7);
            smartRefreshLayout.f3722W0.postDelayed(this, 10);
            return;
        }
        J2.b bVar = smartRefreshLayout.f3725Z0;
        boolean z6 = bVar.d;
        if (z6 && bVar.f374a) {
            kVar.setState(J2.b.PullDownCanceled);
        } else if (z6 && bVar.b) {
            kVar.setState(J2.b.PullUpCanceled);
        }
        smartRefreshLayout.j1 = null;
        if (Math.abs(smartRefreshLayout.b) >= Math.abs(i5)) {
            smartRefreshLayout.g(i5, 0, smartRefreshLayout.f3763z, Math.min(Math.max((int) (Math.abs(smartRefreshLayout.b - i5) / N2.b.f499a), 30), 100) * 10);
        }
    }
}

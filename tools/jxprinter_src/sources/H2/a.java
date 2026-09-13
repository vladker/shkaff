package H2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ SmartRefreshLayout c;

    public /* synthetic */ a(int i5, SmartRefreshLayout smartRefreshLayout, boolean z6) {
        this.f292a = i5;
        this.c = smartRefreshLayout;
        this.b = z6;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f292a) {
            case 0:
                if (animator == null || animator.getDuration() != 0) {
                    this.c.setStateDirectLoading(this.b);
                }
                break;
            default:
                if (animator == null || animator.getDuration() != 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout = this.c;
                    smartRefreshLayout.f3727a1 = jCurrentTimeMillis;
                    smartRefreshLayout.p(J2.b.Refreshing);
                    L2.e eVar = smartRefreshLayout.f3691A0;
                    if (eVar == null) {
                        smartRefreshLayout.l(3000, true, Boolean.FALSE);
                    } else if (this.b) {
                        eVar.onRefresh(smartRefreshLayout);
                    }
                    I2.d dVar = smartRefreshLayout.f3718S0;
                    if (dVar != null) {
                        float f6 = smartRefreshLayout.f3712N0;
                        if (f6 < 10.0f) {
                            f6 *= smartRefreshLayout.f3702H0;
                        }
                        dVar.onStartAnimator(smartRefreshLayout, smartRefreshLayout.f3702H0, (int) f6);
                    }
                }
                break;
        }
    }
}

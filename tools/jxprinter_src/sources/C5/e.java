package C5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f143a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i5) {
        this.f143a = i5;
        this.b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        J2.b bVar;
        J2.b bVar2;
        switch (this.f143a) {
            case 0:
                super.onAnimationEnd(animator);
                ((f) this.b).e.setVisibility(8);
                break;
            case 1:
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.b;
                    smartRefreshLayout.f3736k1 = null;
                    if (smartRefreshLayout.b != 0 || (bVar = smartRefreshLayout.f3724Y0) == (bVar2 = J2.b.None) || bVar.e || bVar.d) {
                        J2.b bVar3 = smartRefreshLayout.f3724Y0;
                        if (bVar3 != smartRefreshLayout.f3725Z0) {
                            smartRefreshLayout.setViceState(bVar3);
                        }
                    } else {
                        smartRefreshLayout.p(bVar2);
                    }
                }
                break;
            case 2:
                H2.f fVar = (H2.f) ((H2.e) this.b).c;
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout2 = fVar.d;
                    smartRefreshLayout2.g1 = false;
                    if (fVar.c) {
                        smartRefreshLayout2.r(true);
                    }
                    SmartRefreshLayout smartRefreshLayout3 = fVar.d;
                    if (smartRefreshLayout3.f3724Y0 == J2.b.LoadFinish) {
                        smartRefreshLayout3.p(J2.b.None);
                    }
                }
                break;
            default:
                H2.k kVar = ((H2.g) this.b).c.f3723X0;
                SmartRefreshLayout smartRefreshLayout4 = kVar.f303a;
                if (animator == null || animator.getDuration() != 0) {
                    smartRefreshLayout4.f3736k1 = null;
                    if (smartRefreshLayout4.f3718S0 == null) {
                        kVar.setState(J2.b.None);
                    } else {
                        J2.b bVar4 = smartRefreshLayout4.f3724Y0;
                        J2.b bVar5 = J2.b.ReleaseToRefresh;
                        if (bVar4 != bVar5) {
                            kVar.setState(bVar5);
                        }
                        smartRefreshLayout4.setStateRefreshing(true);
                    }
                }
                break;
        }
    }
}

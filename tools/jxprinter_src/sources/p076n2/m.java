package p076n2;

import android.view.animation.Animation;
import com.library.base.view.refreshlayout.RefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class m implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RefreshLayout f6257a;

    public m(RefreshLayout refreshLayout) {
        this.f6257a = refreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int[] iArr = RefreshLayout.f3571J;
        RefreshLayout refreshLayout = this.f6257a;
        refreshLayout.getClass();
        k kVar = new k(refreshLayout);
        refreshLayout.f3594u = kVar;
        kVar.setDuration(100L);
        a aVar = refreshLayout.f3588o;
        aVar.f6218a = null;
        aVar.clearAnimation();
        refreshLayout.f3588o.startAnimation(refreshLayout.f3594u);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

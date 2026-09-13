package H2;

import android.animation.ValueAnimator;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f293a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i5) {
        this.f293a = i5;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f293a) {
            case 0:
                ((SmartRefreshLayout) this.b).f3723X0.b(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
                break;
            default:
                SmartRefreshLayout smartRefreshLayout = ((g) this.b).c;
                if (smartRefreshLayout.f3736k1 != null && smartRefreshLayout.f3718S0 != null) {
                    smartRefreshLayout.f3723X0.b(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                    break;
                }
                break;
        }
    }
}

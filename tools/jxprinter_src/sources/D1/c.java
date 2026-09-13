package D1;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class c implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f165a;
    public final float b;
    public final /* synthetic */ d c;

    public c(d dVar, float f6, float f7) {
        this.c = dVar;
        this.f165a = f6;
        this.b = f7;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        d dVar = this.c;
        dVar.f166a.n();
        dVar.a();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        d dVar = this.c;
        dVar.f166a.n();
        dVar.f166a.p();
        dVar.a();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.f166a.s(new PointF(this.f165a, this.b), ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}

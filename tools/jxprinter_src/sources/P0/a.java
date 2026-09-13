package P0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f558a;

    public a() {
        this(0);
    }

    @Override // P0.b
    public Animator[] animators(View view) {
        E.g(view, "view");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", this.f558a, 1.0f);
        E.b(animator, "animator");
        animator.setDuration(300L);
        animator.setInterpolator(new LinearInterpolator());
        return new Animator[]{animator};
    }

    public a(float f6) {
        this.f558a = f6;
    }

    public /* synthetic */ a(int i5) {
        this(0.0f);
    }
}

package P0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f559a;

    public c() {
        this(0);
    }

    @Override // P0.b
    public Animator[] animators(View view) {
        E.g(view, "view");
        float f6 = this.f559a;
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", f6, 1.0f);
        E.b(scaleX, "scaleX");
        scaleX.setDuration(300L);
        scaleX.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", f6, 1.0f);
        E.b(scaleY, "scaleY");
        scaleY.setDuration(300L);
        scaleY.setInterpolator(new DecelerateInterpolator());
        return new Animator[]{scaleX, scaleY};
    }

    public c(float f6) {
        this.f559a = f6;
    }

    public /* synthetic */ c(int i5) {
        this(0.5f);
    }
}

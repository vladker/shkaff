package P0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements b {
    @Override // P0.b
    public Animator[] animators(View view) {
        E.g(view, "view");
        View rootView = view.getRootView();
        E.b(rootView, "view.rootView");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", rootView.getWidth(), 0.0f);
        E.b(animator, "animator");
        animator.setDuration(400L);
        animator.setInterpolator(new DecelerateInterpolator(1.8f));
        return new Animator[]{animator};
    }
}

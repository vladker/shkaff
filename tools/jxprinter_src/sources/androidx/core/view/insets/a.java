package androidx.core.view.insets;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1027a;
    public final /* synthetic */ Protection b;

    public /* synthetic */ a(Protection protection, int i5) {
        this.f1027a = i5;
        this.b = protection;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1027a) {
            case 0:
                this.b.lambda$animateInsetsAmount$1(valueAnimator);
                break;
            default:
                this.b.lambda$animateAlpha$0(valueAnimator);
                break;
        }
    }
}

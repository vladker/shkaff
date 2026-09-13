package p076n2;

import android.view.animation.AccelerateDecelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends AccelerateDecelerateInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6224a;

    @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        switch (this.f6224a) {
            case 0:
                return super.getInterpolation(Math.max(0.0f, (f6 - 0.5f) * 2.0f));
            default:
                return super.getInterpolation(Math.min(1.0f, f6 * 2.0f));
        }
    }
}

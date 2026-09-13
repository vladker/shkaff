package p101r4;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        return Math.abs(1.0f - f6);
    }
}

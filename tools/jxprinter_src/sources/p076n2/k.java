package p076n2;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.library.base.view.refreshlayout.RefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class k extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RefreshLayout f6255a;

    public k(RefreshLayout refreshLayout) {
        this.f6255a = refreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f6, Transformation transformation) {
        this.f6255a.setAnimationProgress(1.0f - f6);
    }
}

package p076n2;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.library.base.view.refreshlayout.RefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class j extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RefreshLayout f6254a;

    public j(RefreshLayout refreshLayout) {
        this.f6254a = refreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f6, Transformation transformation) {
        this.f6254a.setAnimationProgress(f6);
    }
}

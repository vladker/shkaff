package p076n2;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.library.base.view.refreshlayout.RefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class l extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6256a;
    public final /* synthetic */ int b;
    public final /* synthetic */ RefreshLayout c;

    public l(RefreshLayout refreshLayout, int i5, int i6) {
        this.c = refreshLayout;
        this.f6256a = i5;
        this.b = i6;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f6, Transformation transformation) {
        i iVar = this.c.f3592s;
        int i5 = this.f6256a;
        iVar.b.f6241u = (int) (((this.b - i5) * f6) + i5);
    }
}

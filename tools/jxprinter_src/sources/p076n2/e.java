package p076n2;

import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6222a;
    public final /* synthetic */ i b;

    public e(i iVar, h hVar) {
        this.b = iVar;
        this.f6222a = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        h hVar = this.f6222a;
        hVar.f6232l = hVar.e;
        float f6 = hVar.f6226f;
        hVar.f6233m = f6;
        hVar.f6234n = hVar.f6227g;
        hVar.f6231k = (hVar.f6231k + 1) % hVar.f6230j.length;
        hVar.e = f6;
        hVar.a();
        i iVar = this.b;
        iVar.f6250g = (iVar.f6250g + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        this.b.f6250g = 0.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
    }
}

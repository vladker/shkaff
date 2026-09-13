package p076n2;

import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6220a;
    public final /* synthetic */ i b;

    public c(i iVar, h hVar) {
        this.b = iVar;
        this.f6220a = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        h hVar = this.f6220a;
        hVar.f6231k = (hVar.f6231k + 1) % hVar.f6230j.length;
        hVar.f6232l = hVar.e;
        hVar.f6233m = hVar.f6226f;
        hVar.f6234n = hVar.f6227g;
        if (hVar.f6235o) {
            hVar.f6235o = false;
            hVar.a();
        }
        i iVar = this.b;
        iVar.e.startAnimation(iVar.f6249f);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

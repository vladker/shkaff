package p076n2;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6221a;
    public final /* synthetic */ i b;

    public d(i iVar, h hVar) {
        this.b = iVar;
        this.f6221a = hVar;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f6, Transformation transformation) {
        h hVar = this.f6221a;
        float radians = (float) Math.toRadians(((double) hVar.f6228h) / (hVar.f6238r * 6.283185307179586d));
        float f7 = hVar.f6233m;
        float f8 = hVar.f6232l;
        float f9 = hVar.f6234n;
        hVar.f6226f = (i.f6246m.getInterpolation(f6) * (0.8f - radians)) + f7;
        hVar.a();
        hVar.e = (i.f6245l.getInterpolation(f6) * 0.8f) + f8;
        hVar.a();
        hVar.f6227g = (0.25f * f6) + f9;
        hVar.a();
        i iVar = this.b;
        iVar.c = ((iVar.f6250g / 5.0f) * 720.0f) + (f6 * 144.0f);
        iVar.invalidateSelf();
    }
}

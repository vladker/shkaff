package p076n2;

import A3.AbstractC0157z;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class b extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6219a;

    public b(i iVar, h hVar) {
        this.f6219a = hVar;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f6, Transformation transformation) {
        h hVar = this.f6219a;
        float fFloor = (float) (Math.floor(hVar.f6234n / 0.8f) + 1.0d);
        float f7 = hVar.f6232l;
        hVar.e = AbstractC0157z.a(hVar.f6233m, f7, f6, f7);
        hVar.a();
        float f8 = hVar.f6234n;
        hVar.f6227g = AbstractC0157z.a(fFloor, f8, f6, f8);
        hVar.a();
        float f9 = 1.0f - f6;
        if (f9 != hVar.f6237q) {
            hVar.f6237q = f9;
            hVar.a();
        }
    }
}

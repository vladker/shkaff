package p058k2;

import A3.AbstractC0157z;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5476a;
    public final float b;
    public final long c = System.currentTimeMillis();
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f5477f;

    public e(k kVar, float f6, float f7, float f8, float f9) {
        this.f5477f = kVar;
        this.f5476a = f8;
        this.b = f9;
        this.d = f6;
        this.e = f7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar = this.f5477f;
        ImageView imageViewH = kVar.h();
        if (imageViewH == null) {
            return;
        }
        float interpolation = k.f5480z.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / kVar.f5481a));
        float f6 = this.d;
        kVar.l(AbstractC0157z.a(this.e, f6, interpolation, f6) / kVar.k(), this.f5476a, this.b);
        if (interpolation < 1.0f) {
            a.b(imageViewH, this);
        }
    }
}

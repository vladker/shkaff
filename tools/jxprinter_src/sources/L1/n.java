package L1;

import A3.AbstractC0157z;
import com.soundcloud.android.crop.CropImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f422a;
    public final long b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f424g;

    public n(CropImageView cropImageView, long j6, float f6, float f7, float f8, float f9) {
        this.f422a = 1;
        this.f424g = cropImageView;
        this.b = j6;
        this.c = f6;
        this.d = f7;
        this.e = f8;
        this.f423f = f9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f422a) {
            case 0:
                float fCurrentTimeMillis = (System.currentTimeMillis() - this.b) * 1.0f;
                p pVar = (p) this.f424g;
                float interpolation = pVar.f426a.getInterpolation(Math.min(1.0f, fCurrentTimeMillis / pVar.b));
                float f6 = this.e;
                pVar.f444w.i(AbstractC0157z.a(this.f423f, f6, interpolation, f6) / pVar.d(), this.c, this.d);
                if (interpolation < 1.0f) {
                    a.a(pVar.f429h, this);
                }
                break;
            default:
                float fMin = Math.min(300.0f, System.currentTimeMillis() - this.b);
                float f7 = (this.d * fMin) + this.c;
                CropImageView cropImageView = (CropImageView) this.f424g;
                cropImageView.f(f7, this.e, this.f423f);
                if (fMin < 300.0f) {
                    cropImageView.f609j.post(this);
                }
                break;
        }
    }

    public n(p pVar, float f6, float f7, float f8, float f9) {
        this.f422a = 0;
        this.f424g = pVar;
        this.c = f8;
        this.d = f9;
        this.b = System.currentTimeMillis();
        this.e = f6;
        this.f423f = f7;
    }
}

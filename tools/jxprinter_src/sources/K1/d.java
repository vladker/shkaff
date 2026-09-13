package K1;

import com.shockwave.pdfium.util.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f389a;
    public final Size b;
    public final Q2.a c;
    public final Q2.a d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f391g;

    public d(b bVar, Size size, Size size2, Size size3, boolean z6) {
        int i5 = size3.b;
        int i6 = size3.f3766a;
        this.f389a = bVar;
        this.b = size3;
        this.f391g = z6;
        int i7 = c.f388a[bVar.ordinal()];
        if (i7 == 1) {
            Q2.a aVarB = b(size2, i5);
            this.d = aVarB;
            float f6 = aVarB.b / size2.b;
            this.f390f = f6;
            this.c = b(size, size.b * f6);
            return;
        }
        if (i7 != 2) {
            Q2.a aVarC = c(size, i6);
            this.c = aVarC;
            float f7 = aVarC.f575a / size.f3766a;
            this.e = f7;
            this.d = c(size2, size2.f3766a * f7);
            return;
        }
        float f8 = i5;
        Q2.a aVarA = a(size, i6, f8);
        float f9 = size.f3766a;
        Q2.a aVarA2 = a(size2, size2.f3766a * (aVarA.f575a / f9), f8);
        this.d = aVarA2;
        float f10 = aVarA2.b / size2.b;
        this.f390f = f10;
        Q2.a aVarA3 = a(size, i6, size.b * f10);
        this.c = aVarA3;
        this.e = aVarA3.f575a / f9;
    }

    public static Q2.a a(Size size, float f6, float f7) {
        float f8 = size.f3766a / size.b;
        float fFloor = (float) Math.floor(f6 / f8);
        if (fFloor > f7) {
            f6 = (float) Math.floor(f8 * f7);
        } else {
            f7 = fFloor;
        }
        return new Q2.a(f6, f7);
    }

    public static Q2.a b(Size size, float f6) {
        return new Q2.a((float) Math.floor(f6 / (size.b / size.f3766a)), f6);
    }

    public static Q2.a c(Size size, float f6) {
        return new Q2.a(f6, (float) Math.floor(f6 / (size.f3766a / size.b)));
    }
}

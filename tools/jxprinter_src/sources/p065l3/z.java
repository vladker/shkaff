package p065l3;

import io.reactivex.B;
import io.reactivex.I;
import p027e3.o;
import p067m.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5896a;
    public final B b;
    public final o c;
    public final int d;
    public final int e;

    public /* synthetic */ z(B b, o oVar, int i5, int i6, int i7) {
        this.f5896a = i7;
        this.b = b;
        this.c = oVar;
        this.d = i5;
        this.e = i6;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        switch (this.f5896a) {
            case 0:
                B b = this.b;
                o oVar = this.c;
                if (!h.d(b, oVar, i5)) {
                    b.subscribe(new y(i5, oVar, this.e, this.d));
                }
                break;
            default:
                B b6 = this.b;
                o oVar2 = this.c;
                if (!h.e(b6, oVar2, i5)) {
                    b6.subscribe(new B(i5, oVar2, this.e, this.d));
                }
                break;
        }
    }
}

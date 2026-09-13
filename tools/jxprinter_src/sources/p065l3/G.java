package p065l3;

import io.reactivex.B;
import io.reactivex.I;
import p027e3.o;
import p067m.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5809a;
    public final B b;
    public final o c;
    public final boolean d;

    public /* synthetic */ G(B b, o oVar, boolean z6, int i5) {
        this.f5809a = i5;
        this.b = b;
        this.c = oVar;
        this.d = z6;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        switch (this.f5809a) {
            case 0:
                B b = this.b;
                o oVar = this.c;
                if (!h.d(b, oVar, i5)) {
                    b.subscribe(new F(i5, oVar, this.d));
                }
                break;
            default:
                B b6 = this.b;
                o oVar2 = this.c;
                if (!h.e(b6, oVar2, i5)) {
                    b6.subscribe(new I(i5, oVar2, this.d));
                }
                break;
        }
    }
}

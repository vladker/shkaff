package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.B;
import io.reactivex.I;
import p027e3.o;
import p065l3.t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5527a;
    public final AbstractC0985s b;
    public final o c;

    public /* synthetic */ O(AbstractC0985s abstractC0985s, o oVar, int i5) {
        this.f5527a = i5;
        this.b = abstractC0985s;
        this.c = oVar;
    }

    @Override // io.reactivex.B
    public final void b(I i5) {
        switch (this.f5527a) {
            case 0:
                this.b.subscribe(new N(i5, this.c));
                break;
            default:
                t tVar = new t(i5, this.c);
                i5.onSubscribe(tVar);
                this.b.subscribe(tVar);
                break;
        }
    }
}

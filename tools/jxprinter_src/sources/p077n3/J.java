package p077n3;

import io.reactivex.N;
import io.reactivex.O;
import io.reactivex.S;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6269a;
    public final O b;
    public final N c;

    public /* synthetic */ J(O o6, N n6, int i5) {
        this.f6269a = i5;
        this.b = o6;
        this.c = n6;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6269a) {
            case 0:
                this.b.subscribe(new I(s6, this.c));
                break;
            case 1:
                L l6 = new L(this.b, s6);
                s6.onSubscribe(l6);
                c cVarScheduleDirect = this.c.scheduleDirect(l6);
                h hVar = l6.b;
                hVar.getClass();
                d.c(hVar, cVarScheduleDirect);
                break;
            default:
                this.b.subscribe(new W(s6, this.c));
                break;
        }
    }
}

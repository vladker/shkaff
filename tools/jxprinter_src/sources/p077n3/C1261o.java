package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import p065l3.s;

/* JADX INFO: renamed from: n3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1261o extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6303a;
    public final O b;

    public /* synthetic */ C1261o(O o6, int i5) {
        this.f6303a = i5;
        this.b = o6;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6303a) {
            case 0:
                C1260n c1260n = new C1260n();
                c1260n.b = s6;
                this.b.subscribe(c1260n);
                break;
            case 1:
                this.b.subscribe(new C1260n(s6, 1));
                break;
            default:
                this.b.subscribe(new s(s6));
                break;
        }
    }
}

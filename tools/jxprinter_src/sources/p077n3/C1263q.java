package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import p027e3.a;
import p048i3.t;
import p059k3.G;

/* JADX INFO: renamed from: n3.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1263q extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6305a;
    public final O b;
    public final a c;

    public /* synthetic */ C1263q(O o6, a aVar, int i5) {
        this.f6305a = i5;
        this.b = o6;
        this.c = aVar;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6305a) {
            case 0:
                this.b.subscribe(new G(s6, this.c, 3));
                break;
            case 1:
                this.b.subscribe(new r(s6, this.c));
                break;
            case 2:
                this.b.subscribe(new C1264s(s6, this.c));
                break;
            default:
                this.b.subscribe(new t(this, s6, 8));
                break;
        }
    }
}

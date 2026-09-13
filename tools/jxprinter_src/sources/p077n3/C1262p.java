package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import p027e3.g;
import p048i3.t;
import p059k3.G;

/* JADX INFO: renamed from: n3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1262p extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6304a;
    public final O b;
    public final g c;

    public /* synthetic */ C1262p(O o6, g gVar, int i5) {
        this.f6304a = i5;
        this.b = o6;
        this.c = gVar;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6304a) {
            case 0:
                this.b.subscribe(new G(s6, this.c, 2));
                break;
            case 1:
                this.b.subscribe(new t(this, s6, 5));
                break;
            case 2:
                this.b.subscribe(new C1265t(s6, this.c));
                break;
            default:
                this.b.subscribe(new t(this, s6, 7));
                break;
        }
    }
}

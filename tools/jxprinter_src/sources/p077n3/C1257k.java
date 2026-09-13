package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import t5.b;

/* JADX INFO: renamed from: n3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1257k extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6299a;
    public final O b;
    public final b c;

    public /* synthetic */ C1257k(O o6, b bVar, int i5) {
        this.f6299a = i5;
        this.b = o6;
        this.c = bVar;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        switch (this.f6299a) {
            case 0:
                this.c.subscribe(new C1256j(this.b, s6));
                break;
            default:
                M m6 = new M(s6);
                s6.onSubscribe(m6);
                this.c.subscribe(m6.b);
                this.b.subscribe(m6);
                break;
        }
    }
}

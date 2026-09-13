package p077n3;

import Q0.b;
import io.reactivex.S;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: renamed from: n3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1252f implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f6294a;
    public final S b;
    public final /* synthetic */ C1253g c;

    public C1252f(C1253g c1253g, h hVar, S s6) {
        this.c = c1253g;
        this.f6294a = hVar;
        this.b = s6;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        C1253g c1253g = this.c;
        d.c(this.f6294a, c1253g.d.scheduleDirect(new b(this, 23, th, false), c1253g.e ? c1253g.b : 0L, c1253g.c));
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        h hVar = this.f6294a;
        hVar.getClass();
        d.c(hVar, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        C1253g c1253g = this.c;
        d.c(this.f6294a, c1253g.d.scheduleDirect(new b(this, 24, obj, false), c1253g.b, c1253g.c));
    }
}

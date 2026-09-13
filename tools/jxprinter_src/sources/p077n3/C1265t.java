package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import p011b3.c;
import p017c3.d;
import p027e3.g;
import p033f3.e;

/* JADX INFO: renamed from: n3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1265t implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6308a;
    public final g b;
    public boolean c;

    public C1265t(S s6, g gVar) {
        this.f6308a = s6;
        this.b = gVar;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        if (this.c) {
            a.onError(th);
        } else {
            this.f6308a.onError(th);
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        S s6 = this.f6308a;
        try {
            this.b.accept(cVar);
            s6.onSubscribe(cVar);
        } catch (Throwable th) {
            d.throwIfFatal(th);
            this.c = true;
            cVar.dispose();
            e.f(th, s6);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        if (this.c) {
            return;
        }
        this.f6308a.onSuccess(obj);
    }
}

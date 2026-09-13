package p065l3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: l3.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1158i extends AtomicReference implements S {
    private static final long serialVersionUID = -3051469169682093892L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1159j f5843a;

    public C1158i(C1159j c1159j) {
        this.f5843a = c1159j;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        C1159j c1159j = this.f5843a;
        c cVar = c1159j.e;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (c1159j.f5847h != 3) {
            c1159j.f5848i.cancel();
        }
        c1159j.f5854o = 0;
        c1159j.a();
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        d.c(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        C1159j c1159j = this.f5843a;
        c1159j.f5853n = obj;
        c1159j.f5854o = 2;
        c1159j.a();
    }
}

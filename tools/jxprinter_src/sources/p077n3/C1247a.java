package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicBoolean;
import p011b3.b;
import p011b3.c;

/* JADX INFO: renamed from: n3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1247a implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6284a;
    public final S b;
    public final AtomicBoolean c;
    public c d;

    public C1247a(S s6, b bVar, AtomicBoolean atomicBoolean) {
        this.b = s6;
        this.f6284a = bVar;
        this.c = atomicBoolean;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        if (!this.c.compareAndSet(false, true)) {
            a.onError(th);
            return;
        }
        c cVar = this.d;
        b bVar = this.f6284a;
        bVar.delete(cVar);
        bVar.dispose();
        this.b.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        this.d = cVar;
        this.f6284a.add(cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        if (this.c.compareAndSet(false, true)) {
            c cVar = this.d;
            b bVar = this.f6284a;
            bVar.delete(cVar);
            bVar.dispose();
            this.b.onSuccess(obj);
        }
    }
}

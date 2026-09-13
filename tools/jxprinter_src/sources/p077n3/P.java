package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import io.reactivex.plugins.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P extends AtomicReference implements S, Runnable, c {
    private static final long serialVersionUID = 37497744973048446L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6275a;
    public final AtomicReference b = new AtomicReference();
    public final O c;
    public V d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeUnit f6276f;

    public P(S s6, V v6, long j6, TimeUnit timeUnit) {
        this.f6275a = s6;
        this.d = v6;
        this.e = j6;
        this.f6276f = timeUnit;
        if (v6 != null) {
            this.c = new O(s6);
        } else {
            this.c = null;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        d.a(this.b);
        O o6 = this.c;
        if (o6 != null) {
            d.a(o6);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        c cVar = (c) get();
        d dVar = d.f3969a;
        if (cVar == dVar || !compareAndSet(cVar, dVar)) {
            a.onError(th);
        } else {
            d.a(this.b);
            this.f6275a.onError(th);
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        c cVar = (c) get();
        d dVar = d.f3969a;
        if (cVar == dVar || !compareAndSet(cVar, dVar)) {
            return;
        }
        d.a(this.b);
        this.f6275a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = (c) get();
        d dVar = d.f3969a;
        if (cVar == dVar || !compareAndSet(cVar, dVar)) {
            return;
        }
        if (cVar != null) {
            cVar.dispose();
        }
        V v6 = this.d;
        if (v6 == null) {
            this.f6275a.onError(new TimeoutException(g.c(this.e, this.f6276f)));
        } else {
            this.d = null;
            ((O) v6).subscribe(this.c);
        }
    }
}

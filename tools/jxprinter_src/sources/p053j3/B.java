package p053j3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p011b3.c;
import p100r3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends AtomicInteger implements InterfaceC0984q, c {
    private static final long serialVersionUID = -2108443387387077490L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5404a;
    public final int b;
    public final boolean c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f5405f;
    public final b e = new b();
    public final p100r3.c d = new p100r3.c();

    public B(InterfaceC0679f interfaceC0679f, int i5, boolean z6) {
        this.f5404a = interfaceC0679f;
        this.b = i5;
        this.c = z6;
        lazySet(1);
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5405f.cancel();
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.b;
    }

    @Override // t5.c
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            p100r3.c cVar = this.d;
            Throwable th = (Throwable) cVar.get();
            InterfaceC0679f interfaceC0679f = this.f5404a;
            if (th == null) {
                interfaceC0679f.onComplete();
            } else {
                cVar.getClass();
                interfaceC0679f.onError(g.b(cVar));
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        boolean z6 = this.c;
        InterfaceC0679f interfaceC0679f = this.f5404a;
        p100r3.c cVar = this.d;
        if (z6) {
            cVar.getClass();
            if (!g.a(cVar, th)) {
                a.onError(th);
                return;
            } else {
                if (decrementAndGet() == 0) {
                    cVar.getClass();
                    interfaceC0679f.onError(g.b(cVar));
                    return;
                }
                return;
            }
        }
        this.e.dispose();
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
        } else if (getAndSet(0) > 0) {
            cVar.getClass();
            interfaceC0679f.onError(g.b(cVar));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        getAndIncrement();
        A a6 = new A(this);
        this.e.add(a6);
        ((AbstractC0676c) ((InterfaceC0682i) obj)).subscribe(a6);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.f5405f, dVar)) {
            this.f5405f = dVar;
            this.f5404a.onSubscribe(this);
            int i5 = this.b;
            if (i5 == Integer.MAX_VALUE) {
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                dVar.request(i5);
            }
        }
    }
}

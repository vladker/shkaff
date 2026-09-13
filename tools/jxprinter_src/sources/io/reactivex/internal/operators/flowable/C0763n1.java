package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.n1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0763n1 extends AtomicInteger implements InterfaceC0984q, p011b3.c {
    private static final long serialVersionUID = 8443155186132538303L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f4709a;
    public final p027e3.o c;
    public final boolean d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t5.d f4711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4712h;
    public final p100r3.c b = new p100r3.c();
    public final p011b3.b e = new p011b3.b();

    public C0763n1(InterfaceC0679f interfaceC0679f, p027e3.o oVar, boolean z6, int i5) {
        this.f4709a = interfaceC0679f;
        this.c = oVar;
        this.d = z6;
        this.f4710f = i5;
        lazySet(1);
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f4712h = true;
        this.f4711g.cancel();
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.b;
    }

    @Override // t5.c
    public final void onComplete() {
        if (decrementAndGet() != 0) {
            if (this.f4710f != Integer.MAX_VALUE) {
                this.f4711g.request(1L);
                return;
            }
            return;
        }
        p100r3.c cVar = this.b;
        cVar.getClass();
        Throwable thB = p100r3.g.b(cVar);
        InterfaceC0679f interfaceC0679f = this.f4709a;
        if (thB != null) {
            interfaceC0679f.onError(thB);
        } else {
            interfaceC0679f.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.b;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        boolean z6 = this.d;
        InterfaceC0679f interfaceC0679f = this.f4709a;
        if (!z6) {
            dispose();
            if (getAndSet(0) > 0) {
                cVar.getClass();
                interfaceC0679f.onError(p100r3.g.b(cVar));
                return;
            }
            return;
        }
        if (decrementAndGet() == 0) {
            cVar.getClass();
            interfaceC0679f.onError(p100r3.g.b(cVar));
        } else if (this.f4710f != Integer.MAX_VALUE) {
            this.f4711g.request(1L);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        try {
            Object objApply = this.c.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            getAndIncrement();
            C0757m1 c0757m1 = new C0757m1(this);
            if (this.f4712h || !this.e.add(c0757m1)) {
                return;
            }
            ((AbstractC0676c) interfaceC0682i).subscribe(c0757m1);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4711g.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4711g, dVar)) {
            this.f4711g = dVar;
            this.f4709a.onSubscribe(this);
            int i5 = this.f4710f;
            if (i5 == Integer.MAX_VALUE) {
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                dVar.request(i5);
            }
        }
    }
}

package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.k1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0745k1 extends p094q3.a implements InterfaceC0984q {
    private static final long serialVersionUID = 8443155186132538303L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4686a;
    public final p027e3.o c;
    public final boolean d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t5.d f4688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4689h;
    public final p100r3.c b = new p100r3.c();
    public final p011b3.b e = new p011b3.b();

    public C0745k1(int i5, p027e3.o oVar, t5.c cVar, boolean z6) {
        this.f4686a = cVar;
        this.c = oVar;
        this.d = z6;
        this.f4687f = i5;
        lazySet(1);
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        this.f4689h = true;
        this.f4688g.cancel();
        this.e.dispose();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // t5.c
    public final void onComplete() {
        if (decrementAndGet() != 0) {
            if (this.f4687f != Integer.MAX_VALUE) {
                this.f4688g.request(1L);
                return;
            }
            return;
        }
        p100r3.c cVar = this.b;
        cVar.getClass();
        Throwable thB = p100r3.g.b(cVar);
        t5.c cVar2 = this.f4686a;
        if (thB != null) {
            cVar2.onError(thB);
        } else {
            cVar2.onComplete();
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
        t5.c cVar2 = this.f4686a;
        if (!z6) {
            cancel();
            if (getAndSet(0) > 0) {
                cVar.getClass();
                cVar2.onError(p100r3.g.b(cVar));
                return;
            }
            return;
        }
        if (decrementAndGet() == 0) {
            cVar.getClass();
            cVar2.onError(p100r3.g.b(cVar));
        } else if (this.f4687f != Integer.MAX_VALUE) {
            this.f4688g.request(1L);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        try {
            Object objApply = this.c.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            getAndIncrement();
            C0739j1 c0739j1 = new C0739j1(this);
            if (this.f4689h || !this.e.add(c0739j1)) {
                return;
            }
            ((AbstractC0676c) interfaceC0682i).subscribe(c0739j1);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4688g.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4688g, dVar)) {
            this.f4688g = dVar;
            this.f4686a.onSubscribe(this);
            int i5 = this.f4687f;
            if (i5 == Integer.MAX_VALUE) {
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                dVar.request(i5);
            }
        }
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        return null;
    }

    @Override // p043h3.j
    public final void clear() {
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}

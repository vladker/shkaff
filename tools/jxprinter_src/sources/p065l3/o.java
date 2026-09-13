package p065l3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p039g3.A;
import p100r3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends AtomicInteger implements InterfaceC0984q, d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final n f5862k = new n(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5863a;
    public final p027e3.o b;
    public final boolean c;
    public final p100r3.c d = new p100r3.c();
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f5864f = new AtomicReference();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f5865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5868j;

    public o(c cVar, p027e3.o oVar, boolean z6) {
        this.f5863a = cVar;
        this.b = oVar;
        this.c = z6;
    }

    public final void a() {
        AtomicReference atomicReference = this.f5864f;
        n nVar = f5862k;
        n nVar2 = (n) atomicReference.getAndSet(nVar);
        if (nVar2 == null || nVar2 == nVar) {
            return;
        }
        p033f3.d.a(nVar2);
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        c cVar = this.f5863a;
        p100r3.c cVar2 = this.d;
        AtomicReference atomicReference = this.f5864f;
        AtomicLong atomicLong = this.e;
        long j6 = this.f5868j;
        int iAddAndGet = 1;
        while (!this.f5867i) {
            if (cVar2.get() != null && !this.c) {
                cVar.onError(g.b(cVar2));
                return;
            }
            boolean z6 = this.f5866h;
            n nVar = (n) atomicReference.get();
            boolean z7 = nVar == null;
            if (z6 && z7) {
                Throwable thB = g.b(cVar2);
                if (thB != null) {
                    cVar.onError(thB);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            if (z7 || nVar.b == null || j6 == atomicLong.get()) {
                this.f5868j = j6;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                while (!atomicReference.compareAndSet(nVar, null) && atomicReference.get() == nVar) {
                }
                cVar.onNext(nVar.b);
                j6++;
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        this.f5867i = true;
        this.f5865g.cancel();
        a();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5866h = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (!this.c) {
            a();
        }
        this.f5866h = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        n nVar = f5862k;
        AtomicReference atomicReference = this.f5864f;
        n nVar2 = (n) atomicReference.get();
        if (nVar2 != null) {
            p033f3.d.a(nVar2);
        }
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null MaybeSource");
            y yVar = (y) objApply;
            n nVar3 = new n(this);
            while (true) {
                n nVar4 = (n) atomicReference.get();
                if (nVar4 == nVar) {
                    return;
                }
                do {
                    if (atomicReference.compareAndSet(nVar4, nVar3)) {
                        ((AbstractC0985s) yVar).subscribe(nVar3);
                        return;
                    }
                } while (atomicReference.get() == nVar4);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5865g.cancel();
            atomicReference.getAndSet(nVar);
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.f5865g, dVar)) {
            this.f5865g = dVar;
            this.f5863a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.e, j6);
        b();
    }
}

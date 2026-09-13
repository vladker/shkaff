package p065l3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.O;
import io.reactivex.V;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p027e3.o;
import p039g3.A;
import p100r3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends AtomicInteger implements InterfaceC0984q, d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final q f5870k = new q(null);
    private static final long serialVersionUID = -5402190102429853762L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5871a;
    public final o b;
    public final boolean c;
    public final p100r3.c d = new p100r3.c();
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f5872f = new AtomicReference();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f5873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f5875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5876j;

    public r(c cVar, o oVar, boolean z6) {
        this.f5871a = cVar;
        this.b = oVar;
        this.c = z6;
    }

    public final void a() {
        AtomicReference atomicReference = this.f5872f;
        q qVar = f5870k;
        q qVar2 = (q) atomicReference.getAndSet(qVar);
        if (qVar2 == null || qVar2 == qVar) {
            return;
        }
        p033f3.d.a(qVar2);
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        c cVar = this.f5871a;
        p100r3.c cVar2 = this.d;
        AtomicReference atomicReference = this.f5872f;
        AtomicLong atomicLong = this.e;
        long j6 = this.f5876j;
        int iAddAndGet = 1;
        while (!this.f5875i) {
            if (cVar2.get() != null && !this.c) {
                cVar.onError(g.b(cVar2));
                return;
            }
            boolean z6 = this.f5874h;
            q qVar = (q) atomicReference.get();
            boolean z7 = qVar == null;
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
            if (z7 || qVar.b == null || j6 == atomicLong.get()) {
                this.f5876j = j6;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                while (!atomicReference.compareAndSet(qVar, null) && atomicReference.get() == qVar) {
                }
                cVar.onNext(qVar.b);
                j6++;
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        this.f5875i = true;
        this.f5873g.cancel();
        a();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5874h = true;
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
        this.f5874h = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        q qVar = f5870k;
        AtomicReference atomicReference = this.f5872f;
        q qVar2 = (q) atomicReference.get();
        if (qVar2 != null) {
            p033f3.d.a(qVar2);
        }
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null SingleSource");
            V v6 = (V) objApply;
            q qVar3 = new q(this);
            while (true) {
                q qVar4 = (q) atomicReference.get();
                if (qVar4 == qVar) {
                    return;
                }
                do {
                    if (atomicReference.compareAndSet(qVar4, qVar3)) {
                        ((O) v6).subscribe(qVar3);
                        return;
                    }
                } while (atomicReference.get() == qVar4);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5873g.cancel();
            atomicReference.getAndSet(qVar);
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.f5873g, dVar)) {
            this.f5873g = dVar;
            this.f5871a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        p122v2.a.a(this.e, j6);
        b();
    }
}

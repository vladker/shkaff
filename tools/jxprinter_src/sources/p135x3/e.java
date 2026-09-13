package p135x3;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import p100r3.p;
import p112t3.a;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends a implements InterfaceC0984q, d {
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f8958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f8959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f8960h;

    public e(long j6, int i5) {
        if (j6 < 0) {
            throw new IllegalArgumentException("Negative initial request not allowed");
        }
        this.e = d.f8957a;
        this.f8959g = new AtomicReference();
        this.f8960h = new AtomicLong(j6);
    }

    @Override // t5.d
    public final void cancel() {
        if (this.f8958f) {
            return;
        }
        this.f8958f = true;
        g.a(this.f8959g);
    }

    @Override // p011b3.c
    public final void dispose() {
        cancel();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f8958f;
    }

    @Override // t5.c
    public final void onComplete() {
        CountDownLatch countDownLatch = this.f8658a;
        if (!this.d) {
            this.d = true;
            if (this.f8959g.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.e.getClass();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        CountDownLatch countDownLatch = this.f8658a;
        boolean z6 = this.d;
        p pVar = this.c;
        if (!z6) {
            this.d = true;
            if (this.f8959g.get() == null) {
                pVar.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            pVar.add(th);
            if (th == null) {
                pVar.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.e.getClass();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        boolean z6 = this.d;
        p pVar = this.c;
        if (!z6) {
            this.d = true;
            if (this.f8959g.get() == null) {
                pVar.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        this.b.add(obj);
        if (obj == null) {
            pVar.add(new NullPointerException("onNext received a null value"));
        }
        this.e.getClass();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        AtomicReference atomicReference;
        Thread.currentThread();
        p pVar = this.c;
        if (dVar == null) {
            pVar.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        do {
            atomicReference = this.f8959g;
            if (atomicReference.compareAndSet(null, dVar)) {
                this.e.getClass();
                long andSet = this.f8960h.getAndSet(0L);
                if (andSet != 0) {
                    dVar.request(andSet);
                    return;
                }
                return;
            }
        } while (atomicReference.get() == null);
        dVar.cancel();
        if (atomicReference.get() != g.f7849a) {
            pVar.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + dVar));
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        g.b(this.f8959g, this.f8960h, j6);
    }
}

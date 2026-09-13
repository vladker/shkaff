package p112t3;

import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p100r3.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends a implements I, InterfaceC0988v, S, InterfaceC0679f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f8665f = new AtomicReference();
    public final f e = f.f8664a;

    @Override // p011b3.c
    public final void dispose() {
        d.a(this.f8665f);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) this.f8665f.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        CountDownLatch countDownLatch = this.f8658a;
        if (!this.d) {
            this.d = true;
            if (this.f8665f.get() == null) {
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

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        CountDownLatch countDownLatch = this.f8658a;
        boolean z6 = this.d;
        p pVar = this.c;
        if (!z6) {
            this.d = true;
            if (this.f8665f.get() == null) {
                pVar.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            if (th == null) {
                pVar.add(new NullPointerException("onError received a null Throwable"));
            } else {
                pVar.add(th);
            }
            this.e.getClass();
        } finally {
            countDownLatch.countDown();
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        boolean z6 = this.d;
        p pVar = this.c;
        if (!z6) {
            this.d = true;
            if (this.f8665f.get() == null) {
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

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        AtomicReference atomicReference;
        Thread.currentThread();
        p pVar = this.c;
        if (cVar == null) {
            pVar.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        do {
            atomicReference = this.f8665f;
            if (atomicReference.compareAndSet(null, cVar)) {
                this.e.getClass();
                return;
            }
        } while (atomicReference.get() == null);
        cVar.dispose();
        if (atomicReference.get() != d.f3969a) {
            pVar.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + cVar));
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        onNext(obj);
        onComplete();
    }
}

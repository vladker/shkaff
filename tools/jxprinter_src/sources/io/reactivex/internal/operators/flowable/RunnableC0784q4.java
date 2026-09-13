package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0784q4 extends AtomicReference implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4744a;
    public final io.reactivex.M b;
    public final AtomicReference c = new AtomicReference();
    public final AtomicLong d = new AtomicLong();
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.b f4745f;

    public RunnableC0784q4(t5.c cVar, io.reactivex.M m6, t5.b bVar, boolean z6) {
        this.f4744a = cVar;
        this.b = m6;
        this.f4745f = bVar;
        this.e = !z6;
    }

    public final void a(long j6, t5.d dVar) {
        if (this.e || Thread.currentThread() == get()) {
            dVar.request(j6);
        } else {
            this.b.schedule(new RunnableC0778p4(j6, dVar));
        }
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.c);
        this.b.dispose();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4744a.onComplete();
        this.b.dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4744a.onError(th);
        this.b.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4744a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this.c, dVar)) {
            long andSet = this.d.getAndSet(0L);
            if (andSet != 0) {
                a(andSet, dVar);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            AtomicReference atomicReference = this.c;
            t5.d dVar = (t5.d) atomicReference.get();
            if (dVar != null) {
                a(j6, dVar);
                return;
            }
            AtomicLong atomicLong = this.d;
            p122v2.a.a(atomicLong, j6);
            t5.d dVar2 = (t5.d) atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, dVar2);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        lazySet(Thread.currentThread());
        t5.b bVar = this.f4745f;
        this.f4745f = null;
        bVar.subscribe(this);
    }
}

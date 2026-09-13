package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0783q3 extends AtomicBoolean implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -7419642935409022375L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4743a;
    public final C0788r3 b;
    public final RunnableC0777p3 c;
    public t5.d d;

    public C0783q3(t5.c cVar, C0788r3 c0788r3, RunnableC0777p3 runnableC0777p3) {
        this.f4743a = cVar;
        this.b = c0788r3;
        this.c = runnableC0777p3;
    }

    @Override // t5.d
    public final void cancel() {
        this.d.cancel();
        if (compareAndSet(false, true)) {
            C0788r3 c0788r3 = this.b;
            RunnableC0777p3 runnableC0777p3 = this.c;
            synchronized (c0788r3) {
                try {
                    RunnableC0777p3 runnableC0777p4 = c0788r3.f4759g;
                    if (runnableC0777p4 != null && runnableC0777p4 == runnableC0777p3) {
                        long j6 = runnableC0777p3.c - 1;
                        runnableC0777p3.c = j6;
                        if (j6 == 0 && runnableC0777p3.d) {
                            if (c0788r3.d == 0) {
                                c0788r3.i(runnableC0777p3);
                                return;
                            }
                            p033f3.h hVar = new p033f3.h();
                            runnableC0777p3.b = hVar;
                            p033f3.d.c(hVar, c0788r3.f4758f.scheduleDirect(runnableC0777p3, c0788r3.d, c0788r3.e));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (compareAndSet(false, true)) {
            this.b.g(this.c);
            this.f4743a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (!compareAndSet(false, true)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.b.g(this.c);
            this.f4743a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4743a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.d, dVar)) {
            this.d = dVar;
            this.f4743a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.d.request(j6);
    }
}

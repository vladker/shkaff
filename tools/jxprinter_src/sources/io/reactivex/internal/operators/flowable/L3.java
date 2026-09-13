package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L3 extends AtomicInteger implements InterfaceC0984q {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4350a;
    public final p094q3.f b;
    public final t5.b c;
    public final p027e3.d d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4351f;

    public L3(t5.c cVar, p027e3.d dVar, p094q3.f fVar, t5.b bVar) {
        this.f4350a = cVar;
        this.b = fVar;
        this.c = bVar;
        this.d = dVar;
    }

    public final void a() {
        if (getAndIncrement() == 0) {
            int iAddAndGet = 1;
            while (!this.b.f7847g) {
                long j6 = this.f4351f;
                if (j6 != 0) {
                    this.f4351f = 0L;
                    this.b.d(j6);
                }
                this.c.subscribe(this);
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4350a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        t5.c cVar = this.f4350a;
        try {
            p027e3.d dVar = this.d;
            int i5 = this.e + 1;
            this.e = i5;
            Integer numValueOf = Integer.valueOf(i5);
            ((V1.b) dVar).getClass();
            if (p039g3.A.a(numValueOf, th)) {
                a();
            } else {
                cVar.onError(th);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            cVar.onError(new p017c3.c(th, th2));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4351f++;
        this.f4350a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        this.b.e(dVar);
    }
}

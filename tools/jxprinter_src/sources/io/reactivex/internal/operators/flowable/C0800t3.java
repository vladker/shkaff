package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.t3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0800t3 extends AtomicInteger implements InterfaceC0984q {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4778a;
    public final p094q3.f b;
    public final t5.b c;
    public final p027e3.e d;
    public long e;

    public C0800t3(t5.c cVar, p027e3.e eVar, p094q3.f fVar, t5.b bVar) {
        this.f4778a = cVar;
        this.b = fVar;
        this.c = bVar;
        this.d = eVar;
    }

    public final void a() {
        if (getAndIncrement() == 0) {
            int iAddAndGet = 1;
            while (!this.b.f7847g) {
                long j6 = this.e;
                if (j6 != 0) {
                    this.e = 0L;
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
        try {
            if (((C0802u) this.d).f4792j) {
                this.f4778a.onComplete();
            } else {
                a();
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4778a.onError(th);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4778a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.e++;
        this.f4778a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        this.b.e(dVar);
    }
}

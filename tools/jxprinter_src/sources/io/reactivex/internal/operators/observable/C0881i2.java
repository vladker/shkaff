package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.flowable.C0802u;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.i2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0881i2 extends AtomicInteger implements io.reactivex.I {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5203a;
    public final p033f3.h b;
    public final io.reactivex.G c;
    public final p027e3.e d;

    public C0881i2(io.reactivex.I i5, p027e3.e eVar, p033f3.h hVar, io.reactivex.G g6) {
        this.f5203a = i5;
        this.b = hVar;
        this.c = g6;
        this.d = eVar;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        try {
            if (((C0802u) this.d).f4792j) {
                this.f5203a.onComplete();
            } else if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                do {
                    this.c.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5203a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5203a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5203a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.h hVar = this.b;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }
}

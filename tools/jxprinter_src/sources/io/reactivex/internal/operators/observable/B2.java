package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B2 extends AtomicInteger implements io.reactivex.I {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4876a;
    public final p033f3.h b;
    public final io.reactivex.G c;
    public final p027e3.q d;
    public long e;

    public B2(io.reactivex.I i5, long j6, p027e3.q qVar, p033f3.h hVar, io.reactivex.G g6) {
        this.f4876a = i5;
        this.b = hVar;
        this.c = g6;
        this.d = qVar;
        this.e = j6;
    }

    public final void a() {
        if (getAndIncrement() == 0) {
            int iAddAndGet = 1;
            while (!this.b.e()) {
                this.c.subscribe(this);
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f4876a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        long j6 = this.e;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            this.e = j6 - 1;
        }
        io.reactivex.I i5 = this.f4876a;
        if (j6 == 0) {
            i5.onError(th);
            return;
        }
        try {
            if (this.d.test(th)) {
                a();
            } else {
                i5.onError(th);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            i5.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f4876a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.h hVar = this.b;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }
}

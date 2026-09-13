package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0871g2 extends AtomicInteger implements io.reactivex.I {
    private static final long serialVersionUID = -7098360935104053232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5193a;
    public final p033f3.h b;
    public final io.reactivex.G c;
    public long d;

    public C0871g2(io.reactivex.I i5, long j6, p033f3.h hVar, io.reactivex.G g6) {
        this.f5193a = i5;
        this.b = hVar;
        this.c = g6;
        this.d = j6;
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
        long j6 = this.d;
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            this.d = j6 - 1;
        }
        if (j6 != 0) {
            a();
        } else {
            this.f5193a.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5193a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5193a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.h hVar = this.b;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }
}

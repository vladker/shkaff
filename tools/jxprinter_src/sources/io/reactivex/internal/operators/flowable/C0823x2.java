package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.x2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0823x2 extends AtomicLong implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 2288246011222124525L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4822a;
    public long b;
    public t5.d c;

    public C0823x2(t5.c cVar, long j6) {
        this.f4822a = cVar;
        this.b = j6;
        lazySet(j6);
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.b > 0) {
            this.b = 0L;
            this.f4822a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.b <= 0) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.b = 0L;
            this.f4822a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long j6 = this.b;
        if (j6 > 0) {
            long j7 = j6 - 1;
            this.b = j7;
            t5.c cVar = this.f4822a;
            cVar.onNext(obj);
            if (j7 == 0) {
                this.c.cancel();
                cVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            long j6 = this.b;
            t5.c cVar = this.f4822a;
            if (j6 == 0) {
                dVar.cancel();
                p094q3.d.a(cVar);
            } else {
                this.c = dVar;
                cVar.onSubscribe(this);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        long j7;
        long j8;
        if (p094q3.g.f(j6)) {
            do {
                j7 = get();
                if (j7 == 0) {
                    return;
                } else {
                    j8 = j7 <= j6 ? j7 : j6;
                }
            } while (!compareAndSet(j7, j7 - j8));
            this.c.request(j8);
        }
    }
}

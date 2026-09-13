package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I2 extends K2 {
    private static final long serialVersionUID = -3029755663834015785L;
    public final AtomicInteger e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4964f;

    public I2(p112t3.e eVar, io.reactivex.G g6) {
        super(eVar, g6);
        this.e = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.observable.K2
    public final void a() {
        this.f4964f = true;
        if (this.e.getAndIncrement() == 0) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f5000a.onNext(andSet);
            }
            this.f5000a.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.observable.K2
    public final void b() {
        this.f4964f = true;
        if (this.e.getAndIncrement() == 0) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.f5000a.onNext(andSet);
            }
            this.f5000a.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.observable.K2
    public final void c() {
        if (this.e.getAndIncrement() == 0) {
            do {
                boolean z6 = this.f4964f;
                Object andSet = getAndSet(null);
                if (andSet != null) {
                    this.f5000a.onNext(andSet);
                }
                if (z6) {
                    this.f5000a.onComplete();
                    return;
                }
            } while (this.e.decrementAndGet() != 0);
        }
    }
}

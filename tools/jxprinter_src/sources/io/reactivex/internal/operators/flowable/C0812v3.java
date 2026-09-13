package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.v3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0812v3 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 2827772011130406689L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.b f4810a;
    public final AtomicReference b = new AtomicReference();
    public final AtomicLong c = new AtomicLong();
    public AbstractC0818w3 d;

    public C0812v3(t5.b bVar) {
        this.f4810a = bVar;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.b);
    }

    @Override // t5.c
    public final void onComplete() {
        this.d.cancel();
        this.d.f4817i.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.d.cancel();
        this.d.f4817i.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (getAndIncrement() == 0) {
            while (this.b.get() != p094q3.g.f7849a) {
                this.f4810a.subscribe(this.d);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.b, this.c, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.b, this.c, j6);
    }
}

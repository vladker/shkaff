package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I0 extends AtomicLong implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 2259811067697317255L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4281a;
    public final AbstractC0979l b;
    public final H0 c = new H0(this);
    public final AtomicReference d = new AtomicReference();

    public I0(AbstractC0979l abstractC0979l, t5.c cVar) {
        this.f4281a = cVar;
        this.b = abstractC0979l;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.c);
        p094q3.g.a(this.d);
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4281a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4281a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4281a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.d, this, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p094q3.g.b(this.d, this, j6);
        }
    }
}

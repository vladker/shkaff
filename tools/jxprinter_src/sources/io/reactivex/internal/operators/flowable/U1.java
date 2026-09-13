package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U1 implements InterfaceC0984q, p043h3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4464a;
    public t5.d b;

    public U1(t5.c cVar) {
        this.f4464a = cVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 2;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.cancel();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4464a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4464a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.b, dVar)) {
            this.b = dVar;
            this.f4464a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        return null;
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p043h3.j
    public final void clear() {
    }

    @Override // t5.c
    public final void onNext(Object obj) {
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}

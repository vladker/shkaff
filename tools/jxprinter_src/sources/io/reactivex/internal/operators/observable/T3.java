package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T3 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3 f5114a;
    public final p083o3.d b;
    public volatile boolean c;
    public Throwable d;
    public final AtomicReference e = new AtomicReference();

    public T3(S3 s6, int i5) {
        this.f5114a = s6;
        this.b = new p083o3.d(i5);
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.c = true;
        this.f5114a.b();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.d = th;
        this.c = true;
        this.f5114a.b();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.b.offer(obj);
        this.f5114a.b();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.e, cVar);
    }
}

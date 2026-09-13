package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0891k2 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 802743776666017014L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5223a;
    public final p129w3.d d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final io.reactivex.G f5225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5226h;
    public final AtomicInteger b = new AtomicInteger();
    public final p100r3.c c = new p100r3.c();
    public final C0886j2 e = new C0886j2(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f5224f = new AtomicReference();

    public C0891k2(io.reactivex.I i5, p129w3.d dVar, io.reactivex.G g6) {
        this.f5223a = i5;
        this.d = dVar;
        this.f5225g = g6;
    }

    public final void a() {
        if (this.b.getAndIncrement() == 0) {
            while (!e()) {
                if (!this.f5226h) {
                    this.f5226h = true;
                    this.f5225g.subscribe(this);
                }
                if (this.b.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.f5224f);
        p033f3.d.a(this.e);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.f5224f.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p033f3.d.c(this.f5224f, null);
        this.f5226h = false;
        this.d.onNext(0);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.e);
        com.android.billingclient.api.v1.h(this.f5223a, th, this, this.c);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        com.android.billingclient.api.v1.j(this.f5223a, obj, this, this.c);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.f5224f, cVar);
    }
}

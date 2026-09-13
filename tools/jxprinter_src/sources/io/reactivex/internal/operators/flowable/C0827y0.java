package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0827y0 extends p135x3.a {
    public final C0833z0 b;
    public final long c;
    public final Object d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4842f = new AtomicBoolean();

    public C0827y0(C0833z0 c0833z0, long j6, Object obj) {
        this.b = c0833z0;
        this.c = j6;
        this.d = obj;
    }

    public final void a() {
        if (this.f4842f.compareAndSet(false, true)) {
            C0833z0 c0833z0 = this.b;
            long j6 = this.c;
            Object obj = this.d;
            if (j6 == c0833z0.e) {
                if (c0833z0.get() != 0) {
                    c0833z0.f4848a.onNext(obj);
                    p122v2.a.e(c0833z0, 1L);
                } else {
                    c0833z0.cancel();
                    c0833z0.f4848a.onError(new p017c3.e("Could not deliver value due to lack of requests"));
                }
            }
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.e = true;
            this.b.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        this.e = true;
        dispose();
        a();
    }
}

package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B0 extends AtomicReference implements Runnable, p011b3.c {
    private static final long serialVersionUID = 6812032969491025141L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4180a;
    public final long b;
    public final C0 c;
    public final AtomicBoolean d = new AtomicBoolean();

    public B0(Object obj, long j6, C0 c6) {
        this.f4180a = obj;
        this.b = j6;
        this.c = c6;
    }

    public final void a() {
        if (this.d.compareAndSet(false, true)) {
            C0 c6 = this.c;
            long j6 = this.b;
            Object obj = this.f4180a;
            if (j6 == c6.f4196g) {
                if (c6.get() == 0) {
                    c6.cancel();
                    c6.f4194a.onError(new p017c3.e("Could not deliver value due to lack of requests"));
                } else {
                    c6.f4194a.onNext(obj);
                    p122v2.a.e(c6, 1L);
                    p033f3.d.a(this);
                }
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p033f3.d.f3969a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}

package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N4 extends AtomicReference implements t5.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4381a;
    public volatile boolean b;

    public N4(t5.c cVar) {
        this.f4381a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        p033f3.d.a(this);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            this.b = true;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        p033f3.e eVar = p033f3.e.f3970a;
        if (get() != p033f3.d.f3969a) {
            if (!this.b) {
                lazySet(eVar);
                this.f4381a.onError(new p017c3.e("Can't deliver value due to lack of requests"));
            } else {
                this.f4381a.onNext(0L);
                lazySet(eVar);
                this.f4381a.onComplete();
            }
        }
    }
}

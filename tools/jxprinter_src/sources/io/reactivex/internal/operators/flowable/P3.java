package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P3 extends R3 {
    private static final long serialVersionUID = -3029755663834015785L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f4413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4414g;

    public P3(p135x3.c cVar, t5.b bVar) {
        super(cVar, bVar);
        this.f4413f = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.flowable.R3
    public final void a() {
        this.f4414g = true;
        if (this.f4413f.getAndIncrement() == 0) {
            c();
            this.f4422a.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.R3
    public final void b() {
        this.f4414g = true;
        if (this.f4413f.getAndIncrement() == 0) {
            c();
            this.f4422a.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.R3
    public final void d() {
        if (this.f4413f.getAndIncrement() == 0) {
            do {
                boolean z6 = this.f4414g;
                c();
                if (z6) {
                    this.f4422a.onComplete();
                    return;
                }
            } while (this.f4413f.decrementAndGet() != 0);
        }
    }
}

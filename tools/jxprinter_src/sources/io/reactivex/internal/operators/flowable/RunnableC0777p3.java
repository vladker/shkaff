package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.p3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0777p3 extends AtomicReference implements Runnable, p027e3.g {
    private static final long serialVersionUID = -4552101107598366241L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0788r3 f4728a;
    public p033f3.h b;
    public long c;
    public boolean d;
    public boolean e;

    public RunnableC0777p3(C0788r3 c0788r3) {
        this.f4728a = c0788r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4728a.i(this);
    }

    @Override // p027e3.g
    public void accept(p011b3.c cVar) {
        p033f3.d.c(this, cVar);
        synchronized (this.f4728a) {
            try {
                if (this.e) {
                    ((p033f3.g) this.f4728a.b).a(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

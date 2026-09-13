package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0856d2 extends AtomicReference implements Runnable, p027e3.g {
    private static final long serialVersionUID = -4552101107598366241L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0866f2 f5174a;
    public p033f3.h b;
    public long c;
    public boolean d;
    public boolean e;

    public RunnableC0856d2(C0866f2 c0866f2) {
        this.f5174a = c0866f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5174a.f(this);
    }

    @Override // p027e3.g
    public void accept(p011b3.c cVar) {
        p033f3.d.c(this, cVar);
        synchronized (this.f5174a) {
            try {
                if (this.e) {
                    ((p033f3.g) this.f5174a.f5186a).a(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

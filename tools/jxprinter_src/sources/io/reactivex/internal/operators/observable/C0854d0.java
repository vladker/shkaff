package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0854d0 extends p112t3.c {
    public final C0859e0 b;
    public final long c;
    public final Object d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f5164f = new AtomicBoolean();

    public C0854d0(C0859e0 c0859e0, long j6, Object obj) {
        this.b = c0859e0;
        this.c = j6;
        this.d = obj;
    }

    public final void a() {
        if (this.f5164f.compareAndSet(false, true)) {
            C0859e0 c0859e0 = this.b;
            long j6 = this.c;
            Object obj = this.d;
            if (j6 == c0859e0.e) {
                c0859e0.f5176a.onNext(obj);
            }
        }
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        a();
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.e = true;
            this.b.onError(th);
        }
    }

    @Override // p112t3.c, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        this.e = true;
        dispose();
        a();
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0773p extends AtomicReference implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -1185974347409665484L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0767o f4724a;
    public final int b;
    public final t5.c c;
    public boolean d;
    public final AtomicLong e = new AtomicLong();

    public C0773p(C0767o c0767o, int i5, t5.c cVar) {
        this.f4724a = c0767o;
        this.b = i5;
        this.c = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this);
    }

    @Override // t5.c
    public final void onComplete() {
        boolean z6 = this.d;
        t5.c cVar = this.c;
        if (z6) {
            cVar.onComplete();
        } else if (!this.f4724a.a(this.b)) {
            ((t5.d) get()).cancel();
        } else {
            this.d = true;
            cVar.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        boolean z6 = this.d;
        t5.c cVar = this.c;
        if (z6) {
            cVar.onError(th);
        } else if (this.f4724a.a(this.b)) {
            this.d = true;
            cVar.onError(th);
        } else {
            ((t5.d) get()).cancel();
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        boolean z6 = this.d;
        t5.c cVar = this.c;
        if (z6) {
            cVar.onNext(obj);
        } else if (!this.f4724a.a(this.b)) {
            ((t5.d) get()).cancel();
        } else {
            this.d = true;
            cVar.onNext(obj);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this, this.e, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this, this.e, j6);
    }
}

package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.N;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: j3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC1005p extends AtomicReference implements InterfaceC0679f, Runnable, c {
    private static final long serialVersionUID = 465972761105851022L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5448a;
    public final long b;
    public final TimeUnit c;
    public final N d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f5449f;

    public RunnableC1005p(InterfaceC0679f interfaceC0679f, long j6, TimeUnit timeUnit, N n6, boolean z6) {
        this.f5448a = interfaceC0679f;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        d.c(this, this.d.scheduleDirect(this, this.b, this.c));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5449f = th;
        d.c(this, this.d.scheduleDirect(this, this.e ? this.b : 0L, this.c));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5448a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f5449f;
        this.f5449f = null;
        InterfaceC0679f interfaceC0679f = this.f5448a;
        if (th != null) {
            interfaceC0679f.onError(th);
        } else {
            interfaceC0679f.onComplete();
        }
    }
}

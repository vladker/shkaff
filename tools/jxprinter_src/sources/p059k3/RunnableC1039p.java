package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.N;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: k3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC1039p extends AtomicReference implements InterfaceC0988v, c, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5574a;
    public final long b;
    public final TimeUnit c;
    public final N d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Throwable f5575f;

    public RunnableC1039p(InterfaceC0988v interfaceC0988v, long j6, TimeUnit timeUnit, N n6) {
        this.f5574a = interfaceC0988v;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        d.c(this, this.d.scheduleDirect(this, this.b, this.c));
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5575f = th;
        d.c(this, this.d.scheduleDirect(this, this.b, this.c));
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5574a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.e = obj;
        d.c(this, this.d.scheduleDirect(this, this.b, this.c));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f5575f;
        InterfaceC0988v interfaceC0988v = this.f5574a;
        if (th != null) {
            interfaceC0988v.onError(th);
            return;
        }
        Object obj = this.e;
        if (obj != null) {
            interfaceC0988v.onSuccess(obj);
        } else {
            interfaceC0988v.onComplete();
        }
    }
}

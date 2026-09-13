package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0 extends AtomicLong implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -9102637559663639004L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p135x3.c f4194a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public B0 f4195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f4196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4197h;

    public C0(p135x3.c cVar, long j6, TimeUnit timeUnit, io.reactivex.M m6) {
        this.f4194a = cVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
    }

    @Override // t5.d
    public final void cancel() {
        this.e.cancel();
        this.d.dispose();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4197h) {
            return;
        }
        this.f4197h = true;
        B0 b1 = this.f4195f;
        if (b1 != null) {
            p033f3.d.a(b1);
        }
        if (b1 != null) {
            b1.a();
        }
        this.f4194a.onComplete();
        this.d.dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4197h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4197h = true;
        B0 b1 = this.f4195f;
        if (b1 != null) {
            p033f3.d.a(b1);
        }
        this.f4194a.onError(th);
        this.d.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4197h) {
            return;
        }
        long j6 = this.f4196g + 1;
        this.f4196g = j6;
        B0 b1 = this.f4195f;
        if (b1 != null) {
            p033f3.d.a(b1);
        }
        B0 b6 = new B0(obj, j6, this);
        this.f4195f = b6;
        p033f3.d.c(b6, this.d.schedule(b6, this.b, this.c));
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f4194a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this, j6);
        }
    }
}

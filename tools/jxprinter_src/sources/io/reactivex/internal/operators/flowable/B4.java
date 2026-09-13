package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B4 extends AtomicLong implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p135x3.c f4184a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p033f3.h f4185f = new p033f3.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4187h;

    public B4(p135x3.c cVar, long j6, TimeUnit timeUnit, io.reactivex.M m6) {
        this.f4184a = cVar;
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
        if (this.f4187h) {
            return;
        }
        this.f4187h = true;
        this.f4184a.onComplete();
        this.d.dispose();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4187h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4187h = true;
        this.f4184a.onError(th);
        this.d.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4187h || this.f4186g) {
            return;
        }
        this.f4186g = true;
        if (get() == 0) {
            this.f4187h = true;
            cancel();
            this.f4184a.onError(new p017c3.e("Could not deliver value due to lack of requests"));
            return;
        }
        this.f4184a.onNext(obj);
        p122v2.a.e(this, 1L);
        p011b3.c cVar = (p011b3.c) this.f4185f.get();
        if (cVar != null) {
            cVar.dispose();
        }
        p033f3.h hVar = this.f4185f;
        p011b3.c cVarSchedule = this.d.schedule(this, this.b, this.c);
        hVar.getClass();
        p033f3.d.c(hVar, cVarSchedule);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f4184a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this, j6);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4186g = false;
    }
}

package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S2 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 163080509307634843L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4425a;
    public t5.d b;
    public volatile boolean c;
    public Throwable d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f4426f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference f4427g = new AtomicReference();

    public S2(t5.c cVar) {
        this.f4425a = cVar;
    }

    public final boolean a(boolean z6, boolean z7, t5.c cVar, AtomicReference atomicReference) {
        if (this.e) {
            atomicReference.lazySet(null);
            return true;
        }
        if (!z6) {
            return false;
        }
        Throwable th = this.d;
        if (th != null) {
            atomicReference.lazySet(null);
            cVar.onError(th);
            return true;
        }
        if (!z7) {
            return false;
        }
        cVar.onComplete();
        return true;
    }

    public final void b() {
        if (getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4425a;
        AtomicLong atomicLong = this.f4426f;
        AtomicReference atomicReference = this.f4427g;
        int iAddAndGet = 1;
        do {
            long j6 = 0;
            while (true) {
                if (j6 == atomicLong.get()) {
                    break;
                }
                boolean z6 = this.c;
                Object andSet = atomicReference.getAndSet(null);
                boolean z7 = andSet == null;
                if (a(z6, z7, cVar, atomicReference)) {
                    return;
                }
                if (z7) {
                    break;
                }
                cVar.onNext(andSet);
                j6++;
            }
            if (j6 == atomicLong.get()) {
                if (a(this.c, atomicReference.get() == null, cVar, atomicReference)) {
                    return;
                }
            }
            if (j6 != 0) {
                p122v2.a.e(atomicLong, j6);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // t5.d
    public final void cancel() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.cancel();
        if (getAndIncrement() == 0) {
            this.f4427g.lazySet(null);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.c = true;
        b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.d = th;
        this.c = true;
        b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4427g.lazySet(obj);
        b();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.b, dVar)) {
            this.b = dVar;
            this.f4425a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4426f, j6);
            b();
        }
    }
}

package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.u4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0807u4 extends AtomicBoolean implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -5636543848937116287L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4804a;
    public final long b;
    public boolean c;
    public t5.d d;
    public long e;

    public C0807u4(t5.c cVar, long j6) {
        this.f4804a = cVar;
        this.b = j6;
        this.e = j6;
    }

    @Override // t5.d
    public final void cancel() {
        this.d.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f4804a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.c) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.c = true;
        this.d.cancel();
        this.f4804a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.c) {
            return;
        }
        long j6 = this.e;
        long j7 = j6 - 1;
        this.e = j7;
        if (j6 > 0) {
            boolean z6 = j7 == 0;
            this.f4804a.onNext(obj);
            if (z6) {
                this.d.cancel();
                onComplete();
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.d, dVar)) {
            this.d = dVar;
            long j6 = this.b;
            t5.c cVar = this.f4804a;
            if (j6 != 0) {
                cVar.onSubscribe(this);
                return;
            }
            dVar.cancel();
            this.c = true;
            p094q3.d.a(cVar);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            if (get() || !compareAndSet(false, true) || j6 < this.b) {
                this.d.request(j6);
            } else {
                this.d.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }
}

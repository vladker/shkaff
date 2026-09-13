package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R2 extends AtomicLong implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -3176480756392482682L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4421a;
    public t5.d b;
    public boolean c;

    public R2(t5.c cVar) {
        this.f4421a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f4421a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.c) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.c = true;
            this.f4421a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.c) {
            return;
        }
        if (get() == 0) {
            onError(new p017c3.e("could not emit value due to lack of requests"));
        } else {
            this.f4421a.onNext(obj);
            p122v2.a.e(this, 1L);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.b, dVar)) {
            this.b = dVar;
            this.f4421a.onSubscribe(this);
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

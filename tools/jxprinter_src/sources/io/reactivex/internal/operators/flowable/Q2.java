package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q2 extends AtomicLong implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -6246093802440953054L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4417a;
    public final p027e3.g b;
    public t5.d c;
    public boolean d;

    public Q2(t5.c cVar, p027e3.g gVar) {
        this.f4417a = cVar;
        this.b = gVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f4417a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.d = true;
            this.f4417a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        if (get() != 0) {
            this.f4417a.onNext(obj);
            p122v2.a.e(this, 1L);
            return;
        }
        try {
            this.b.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4417a.onSubscribe(this);
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

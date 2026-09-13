package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z0 implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f4530a;
    public final long b;
    public t5.d c;
    public long d;
    public boolean e;

    public Z0(InterfaceC0988v interfaceC0988v, long j6) {
        this.f4530a = interfaceC0988v;
        this.b = j6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.cancel();
        this.c = p094q3.g.f7849a;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c == p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        this.c = p094q3.g.f7849a;
        if (this.e) {
            return;
        }
        this.e = true;
        this.f4530a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.e = true;
        this.c = p094q3.g.f7849a;
        this.f4530a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        long j6 = this.d;
        if (j6 != this.b) {
            this.d = j6 + 1;
            return;
        }
        this.e = true;
        this.c.cancel();
        this.c = p094q3.g.f7849a;
        this.f4530a.onSuccess(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4530a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}

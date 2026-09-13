package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0762n0 implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.S f4708a;
    public t5.d b;
    public long c;

    public C0762n0(io.reactivex.S s6) {
        this.f4708a = s6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.b.cancel();
        this.b = p094q3.g.f7849a;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b == p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        this.b = p094q3.g.f7849a;
        this.f4708a.onSuccess(Long.valueOf(this.c));
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.b = p094q3.g.f7849a;
        this.f4708a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.c++;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.b, dVar)) {
            this.b = dVar;
            this.f4708a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}

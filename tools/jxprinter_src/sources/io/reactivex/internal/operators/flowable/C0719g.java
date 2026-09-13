package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0719g implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t5.d f4627a;
    public volatile Object b;

    @Override // t5.c
    public final void onComplete() {
        this.b = p100r3.n.f7968a;
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.b = new p100r3.l(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.b = obj;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        t5.d dVar2 = this.f4627a;
        p039g3.A.b(dVar, "next is null");
        if (dVar2 == null) {
            this.f4627a = dVar;
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        } else {
            dVar.cancel();
            if (dVar2 != p094q3.g.f7849a) {
                p002a.d.b(C0719g.class);
            }
        }
    }
}

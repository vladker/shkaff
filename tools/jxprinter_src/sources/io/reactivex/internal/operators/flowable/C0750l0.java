package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0750l0 extends p094q3.c implements InterfaceC0984q {
    private static final long serialVersionUID = 4973004223787171406L;
    public t5.d c;
    public long d;

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        e(Long.valueOf(this.d));
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f7842a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.d++;
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f7842a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}

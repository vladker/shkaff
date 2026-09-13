package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.S;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5458a;

    public y(InterfaceC0679f interfaceC0679f) {
        this.f5458a = interfaceC0679f;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f5458a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        this.f5458a.onSubscribe(cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f5458a.onComplete();
    }
}

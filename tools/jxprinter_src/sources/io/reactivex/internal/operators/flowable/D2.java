package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D2 extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = -2935427570954647017L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E2 f4210a;

    public D2(E2 e6) {
        this.f4210a = e6;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        E2 e6 = this.f4210a;
        e6.f4215g = true;
        if (e6.f4214f) {
            com.android.billingclient.api.v1.g(e6.f4213a, e6, e6.d);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        E2 e6 = this.f4210a;
        p094q3.g.a(e6.b);
        com.android.billingclient.api.v1.i(e6.f4213a, th, e6, e6.d);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}

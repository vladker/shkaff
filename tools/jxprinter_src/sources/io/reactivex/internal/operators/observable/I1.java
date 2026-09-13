package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I1 extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = -2935427570954647017L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J1 f4963a;

    public I1(J1 j1) {
        this.f4963a = j1;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        J1 j1 = this.f4963a;
        j1.f4986f = true;
        if (j1.e) {
            com.android.billingclient.api.v1.f(j1.f4985a, j1, j1.d);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        J1 j1 = this.f4963a;
        p033f3.d.a(j1.b);
        com.android.billingclient.api.v1.h(j1.f4985a, th, j1, j1.d);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}

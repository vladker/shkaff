package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.z4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0837z4 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -3592821756711087922L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A4 f4853a;

    public C0837z4(A4 a6) {
        this.f4853a = a6;
    }

    @Override // t5.c
    public final void onComplete() {
        A4 a6 = this.f4853a;
        p094q3.g.a(a6.c);
        com.android.billingclient.api.v1.g(a6.f4179a, a6, a6.d);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        A4 a6 = this.f4853a;
        p094q3.g.a(a6.c);
        com.android.billingclient.api.v1.i(a6.f4179a, th, a6, a6.d);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        p094q3.g.a(this);
        onComplete();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}

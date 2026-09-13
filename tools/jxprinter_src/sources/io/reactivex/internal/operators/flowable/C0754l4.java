package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.l4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0754l4 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -5592042965931999169L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0760m4 f4696a;

    public C0754l4(C0760m4 c0760m4) {
        this.f4696a = c0760m4;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4696a.f4705f = true;
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        C0760m4 c0760m4 = this.f4696a;
        p094q3.g.a(c0760m4.b);
        com.android.billingclient.api.v1.i(c0760m4.f4704a, th, c0760m4, c0760m4.e);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4696a.f4705f = true;
        ((t5.d) get()).cancel();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}

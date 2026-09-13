package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S3 implements InterfaceC0984q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4428a;
    public final AtomicReference b;

    public /* synthetic */ S3(AtomicReference atomicReference, int i5) {
        this.f4428a = i5;
        this.b = atomicReference;
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4428a) {
            case 0:
                R3 r6 = (R3) this.b;
                r6.e.cancel();
                r6.b();
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4428a) {
            case 0:
                R3 r6 = (R3) this.b;
                r6.e.cancel();
                r6.f4422a.onError(th);
                break;
            default:
                j5 j5Var = (j5) this.b;
                p094q3.g.a(j5Var.c);
                j5Var.f4685a.onError(th);
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4428a) {
            case 0:
                ((R3) this.b).d();
                break;
            default:
                ((j5) this.b).lazySet(obj);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4428a) {
            case 0:
                p094q3.g.d(((R3) this.b).d, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
                break;
            default:
                if (p094q3.g.e(((j5) this.b).e, dVar)) {
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
        }
    }

    private final void a() {
    }
}

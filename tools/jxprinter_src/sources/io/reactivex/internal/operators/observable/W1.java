package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W1 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5126a;
    public final io.reactivex.I b;
    public final AtomicReference c;

    public /* synthetic */ W1(io.reactivex.I i5, AtomicReference atomicReference, int i6) {
        this.f5126a = i6;
        this.b = i5;
        this.c = atomicReference;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5126a) {
            case 0:
                ((p129w3.b) this.b).onComplete();
                break;
            default:
                this.b.onComplete();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5126a) {
            case 0:
                ((p129w3.b) this.b).onError(th);
                break;
            default:
                this.b.onError(th);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5126a) {
            case 0:
                ((p129w3.b) this.b).onNext(obj);
                break;
            default:
                this.b.onNext(obj);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5126a) {
            case 0:
                p033f3.d.f((X1) this.c, cVar);
                break;
            default:
                p033f3.d.c(this.c, cVar);
                break;
        }
    }
}

package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G2 extends H2 {
    private static final long serialVersionUID = -7139995637533111443L;

    @Override // io.reactivex.internal.operators.observable.H2
    public final void a() {
        this.f4956a.onComplete();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            this.f4956a.onNext(andSet);
        }
    }
}

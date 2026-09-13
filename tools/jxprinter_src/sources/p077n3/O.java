package p077n3;

import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends AtomicReference implements S {
    private static final long serialVersionUID = 2071387740092105509L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6274a;

    public O(S s6) {
        this.f6274a = s6;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6274a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f6274a.onSuccess(obj);
    }
}

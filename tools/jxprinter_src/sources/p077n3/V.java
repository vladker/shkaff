package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import p011b3.c;
import p033f3.d;
import p048i3.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V extends k implements S {
    private static final long serialVersionUID = 3786543492451018833L;
    public c c;

    @Override // p048i3.k, p011b3.c
    public final void dispose() {
        super.dispose();
        this.c.dispose();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        if ((get() & 54) != 0) {
            a.onError(th);
        } else {
            lazySet(2);
            this.f4053a.onError(th);
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f4053a.onSubscribe(this);
        }
    }
}

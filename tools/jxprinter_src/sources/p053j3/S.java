package p053j3;

import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import p033f3.d;
import p048i3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends c implements InterfaceC0679f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f5423a;
    public p011b3.c b;

    public S(I i5) {
        this.f5423a = i5;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 2;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.b.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5423a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5423a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        if (d.g(this.b, cVar)) {
            this.b = cVar;
            this.f5423a.onSubscribe(this);
        }
    }

    @Override // p048i3.c, p043h3.e, p043h3.f, p043h3.j
    public Void poll() {
        return null;
    }

    @Override // p043h3.j
    public final void clear() {
    }
}

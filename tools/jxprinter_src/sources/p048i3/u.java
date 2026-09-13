package p048i3;

import io.reactivex.InterfaceC0679f;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements InterfaceC0679f, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4063a;
    public p011b3.c b;

    public u(c cVar) {
        this.f4063a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.dispose();
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f4063a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f4063a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.b, cVar)) {
            this.b = cVar;
            this.f4063a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}

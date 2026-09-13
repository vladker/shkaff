package p059k3;

import io.reactivex.InterfaceC0988v;
import p033f3.d;
import p094q3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E0 extends c implements InterfaceC0988v {
    private static final long serialVersionUID = 7603343402964826922L;
    public p011b3.c c;

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.c.dispose();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f7842a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f7842a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f7842a.onSubscribe(this);
        }
    }
}

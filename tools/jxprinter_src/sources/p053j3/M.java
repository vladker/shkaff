package p053j3;

import io.reactivex.InterfaceC0679f;
import p011b3.b;
import p011b3.c;
import p045i.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M implements InterfaceC0679f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f5418a;

    public M(a aVar) {
        this.f5418a = aVar;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        a aVar = this.f5418a;
        ((b) aVar.c).dispose();
        ((InterfaceC0679f) aVar.d).onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        a aVar = this.f5418a;
        ((b) aVar.c).dispose();
        ((InterfaceC0679f) aVar.d).onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        ((b) this.f5418a.c).add(cVar);
    }
}

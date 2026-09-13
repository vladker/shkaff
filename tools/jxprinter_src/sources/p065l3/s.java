package p065l3;

import io.reactivex.A;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements S, InterfaceC0988v, InterfaceC0679f, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f5877a;
    public c b;

    public s(S s6) {
        this.f5877a = s6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.b.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5877a.onSuccess(A.createOnComplete());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f5877a.onSuccess(A.createOnError(th));
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.g(this.b, cVar)) {
            this.b = cVar;
            this.f5877a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f5877a.onSuccess(A.createOnNext(obj));
    }
}

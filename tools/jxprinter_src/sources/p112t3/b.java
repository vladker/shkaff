package p112t3;

import io.reactivex.I;
import p011b3.c;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8659a;

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        c cVar2 = this.f8659a;
        Class<?> cls = getClass();
        A.b(cVar, "next is null");
        if (cVar2 == null) {
            this.f8659a = cVar;
            return;
        }
        cVar.dispose();
        if (cVar2 != d.f3969a) {
            p002a.d.b(cls);
        }
    }
}

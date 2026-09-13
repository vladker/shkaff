package p077n3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: renamed from: n3.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1268w extends AtomicReference implements S, InterfaceC0679f, c {
    private static final long serialVersionUID = -2177128922851101253L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f6311a;
    public final o b;

    public C1268w(InterfaceC0679f interfaceC0679f, o oVar) {
        this.f6311a = interfaceC0679f;
        this.b = oVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f6311a.onComplete();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6311a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.c(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            if (e()) {
                return;
            }
            ((AbstractC0676c) interfaceC0682i).subscribe(this);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            onError(th);
        }
    }
}

package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = 5018523762564524046L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5414a;
    public final o b;
    public boolean c;

    public I(InterfaceC0679f interfaceC0679f, o oVar) {
        this.f5414a = interfaceC0679f;
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
        this.f5414a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        boolean z6 = this.c;
        InterfaceC0679f interfaceC0679f = this.f5414a;
        if (z6) {
            interfaceC0679f.onError(th);
            return;
        }
        this.c = true;
        try {
            Object objApply = this.b.apply(th);
            A.b(objApply, "The errorMapper returned a null CompletableSource");
            ((AbstractC0676c) ((InterfaceC0682i) objApply)).subscribe(this);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            interfaceC0679f.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.c(this, cVar);
    }
}

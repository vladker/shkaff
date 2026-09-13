package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = 4375739915521278546L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5532a;
    public final o b;
    public c c;

    public V(InterfaceC0988v interfaceC0988v, o oVar) {
        this.f5532a = interfaceC0988v;
        this.b = oVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        this.c.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5532a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5532a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5532a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null MaybeSource");
            y yVar = (y) objApply;
            if (e()) {
                return;
            }
            ((AbstractC0985s) yVar).subscribe(new P(this, 1));
        } catch (Exception e) {
            p017c3.d.throwIfFatal(e);
            this.f5532a.onError(e);
        }
    }
}

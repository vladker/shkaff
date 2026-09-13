package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I implements InterfaceC0988v, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5514a = 1;
    public final Object b;
    public Object c;

    public I(InterfaceC0679f interfaceC0679f) {
        this.b = interfaceC0679f;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5514a) {
            case 0:
                d.a((H) this.c);
                break;
            default:
                ((c) this.c).dispose();
                this.c = d.f3969a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5514a) {
            case 0:
                return d.b((c) ((H) this.c).get());
            default:
                return ((c) this.c).e();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5514a) {
            case 0:
                ((H) this.c).f5512a.onComplete();
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0679f) this.b).onComplete();
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5514a) {
            case 0:
                ((H) this.c).f5512a.onError(th);
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0679f) this.b).onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5514a) {
            case 0:
                H h6 = (H) this.c;
                if (d.f(h6, cVar)) {
                    h6.f5512a.onSubscribe(this);
                }
                break;
            default:
                if (d.g((c) this.c, cVar)) {
                    this.c = cVar;
                    ((InterfaceC0679f) this.b).onSubscribe(this);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5514a) {
            case 0:
                H h6 = (H) this.c;
                try {
                    Object objApply = ((o) this.b).apply(obj);
                    A.b(objApply, "The mapper returned a null MaybeSource");
                    y yVar = (y) objApply;
                    if (d.c(h6, null)) {
                        h6.c = obj;
                        ((AbstractC0985s) yVar).subscribe(h6);
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    h6.f5512a.onError(th);
                    return;
                }
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0679f) this.b).onComplete();
                break;
        }
    }

    public I(InterfaceC0988v interfaceC0988v, o oVar, p027e3.c cVar) {
        this.c = new H(interfaceC0988v, cVar);
        this.b = oVar;
    }
}

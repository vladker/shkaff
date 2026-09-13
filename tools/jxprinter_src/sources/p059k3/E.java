package p059k3;

import io.reactivex.InterfaceC0988v;
import p011b3.c;
import p027e3.q;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E implements InterfaceC0988v, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5509a;
    public final InterfaceC0988v b;
    public final q c;
    public c d;

    public /* synthetic */ E(InterfaceC0988v interfaceC0988v, q qVar, int i5) {
        this.f5509a = i5;
        this.b = interfaceC0988v;
        this.c = qVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5509a) {
            case 0:
                c cVar = this.d;
                this.d = d.f3969a;
                cVar.dispose();
                break;
            default:
                this.d.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5509a) {
            case 0:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5509a) {
            case 0:
                this.b.onComplete();
                break;
            default:
                this.b.onComplete();
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5509a) {
            case 0:
                this.b.onError(th);
                break;
            default:
                InterfaceC0988v interfaceC0988v = this.b;
                try {
                    if (!this.c.test(th)) {
                        interfaceC0988v.onError(th);
                    } else {
                        interfaceC0988v.onComplete();
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    interfaceC0988v.onError(new p017c3.c(th, th2));
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5509a) {
            case 0:
                if (d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5509a) {
            case 0:
                InterfaceC0988v interfaceC0988v = this.b;
                try {
                    if (!this.c.test(obj)) {
                        interfaceC0988v.onComplete();
                    } else {
                        interfaceC0988v.onSuccess(obj);
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    interfaceC0988v.onError(th);
                    return;
                }
                break;
            default:
                this.b.onSuccess(obj);
                break;
        }
    }
}

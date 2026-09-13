package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import p011b3.c;
import p027e3.a;
import p027e3.g;
import p027e3.o;
import p027e3.q;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements S, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5510a;
    public final Object b;
    public c c;
    public final Object d;

    public /* synthetic */ G(Object obj, Object obj2, int i5) {
        this.f5510a = i5;
        this.b = obj;
        this.d = obj2;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5510a) {
            case 0:
                c cVar = this.c;
                this.c = d.f3969a;
                cVar.dispose();
                break;
            case 1:
                this.c.dispose();
                break;
            case 2:
                this.c.dispose();
                break;
            default:
                this.c.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5510a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return this.c.e();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        switch (this.f5510a) {
            case 0:
                ((InterfaceC0988v) this.b).onError(th);
                break;
            case 1:
                ((InterfaceC0988v) this.b).onError(th);
                break;
            case 2:
                ((S) this.b).onError(th);
                break;
            default:
                ((S) this.b).onError(th);
                try {
                    ((a) this.d).run();
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    io.reactivex.plugins.a.onError(th2);
                }
                break;
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        switch (this.f5510a) {
            case 0:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((InterfaceC0988v) this.b).onSubscribe(this);
                }
                break;
            case 1:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((InterfaceC0988v) this.b).onSubscribe(this);
                }
                break;
            case 2:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((S) this.b).onSubscribe(this);
                }
                break;
            default:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((S) this.b).onSubscribe(this);
                }
                break;
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        switch (this.f5510a) {
            case 0:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.b;
                try {
                    if (!((q) this.d).test(obj)) {
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
            case 1:
                InterfaceC0988v interfaceC0988v2 = (InterfaceC0988v) this.b;
                try {
                    Object objApply = ((o) this.d).apply(obj);
                    A.b(objApply, "The selector returned a null Notification");
                    io.reactivex.A a6 = (io.reactivex.A) objApply;
                    if (a6.a()) {
                        interfaceC0988v2.onSuccess(a6.getValue());
                    } else if (a6.f4169a != null) {
                        interfaceC0988v2.onError(a6.getError());
                    } else {
                        interfaceC0988v2.onComplete();
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    interfaceC0988v2.onError(th2);
                    return;
                }
                break;
            case 2:
                ((S) this.b).onSuccess(obj);
                try {
                    ((g) this.d).accept(obj);
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    io.reactivex.plugins.a.onError(th3);
                    return;
                }
                break;
            default:
                ((S) this.b).onSuccess(obj);
                try {
                    ((a) this.d).run();
                } catch (Throwable th4) {
                    p017c3.d.throwIfFatal(th4);
                    io.reactivex.plugins.a.onError(th4);
                }
                break;
        }
    }
}

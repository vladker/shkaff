package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import p011b3.c;
import p017c3.d;
import p033f3.e;
import p094q3.g;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements InterfaceC0988v, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5578a;
    public c b;
    public final Object c;
    public final Object d;

    public /* synthetic */ r(int i5, InterfaceC0988v interfaceC0988v, Object obj) {
        this.f5578a = i5;
        this.c = interfaceC0988v;
        this.d = obj;
    }

    public void a() {
        try {
            ((o0) this.d).f5572f.run();
        } catch (Throwable th) {
            d.throwIfFatal(th);
            a.onError(th);
        }
    }

    public void b(Throwable th) {
        try {
            ((o0) this.d).d.accept(th);
        } catch (Throwable th2) {
            d.throwIfFatal(th2);
            th = new p017c3.c(th, th2);
        }
        this.b = p033f3.d.f3969a;
        ((InterfaceC0988v) this.c).onError(th);
        a();
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5578a) {
            case 0:
                this.b.dispose();
                this.b = p033f3.d.f3969a;
                g.a((C1041s) this.c);
                break;
            case 1:
                this.b.dispose();
                break;
            case 2:
                this.b.dispose();
                this.b = p033f3.d.f3969a;
                break;
            default:
                try {
                    ((o0) this.d).f5573g.run();
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    a.onError(th);
                }
                this.b.dispose();
                this.b = p033f3.d.f3969a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5578a) {
            case 0:
                return ((C1041s) this.c).get() == g.f7849a;
            case 1:
                return this.b.e();
            case 2:
                return this.b.e();
            default:
                return this.b.e();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5578a) {
            case 0:
                this.b = p033f3.d.f3969a;
                ((b) this.d).subscribe((C1041s) this.c);
                break;
            case 1:
                ((InterfaceC0988v) this.c).onComplete();
                break;
            case 2:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.c;
                this.b = p033f3.d.f3969a;
                try {
                    ((p027e3.b) this.d).accept(null, null);
                    interfaceC0988v.onComplete();
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0988v.onError(th);
                    return;
                }
                break;
            default:
                c cVar = this.b;
                p033f3.d dVar = p033f3.d.f3969a;
                if (cVar != dVar) {
                    try {
                        ((o0) this.d).e.run();
                        this.b = dVar;
                        ((InterfaceC0988v) this.c).onComplete();
                        a();
                    } catch (Throwable th2) {
                        d.throwIfFatal(th2);
                        b(th2);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5578a) {
            case 0:
                this.b = p033f3.d.f3969a;
                C1041s c1041s = (C1041s) this.c;
                c1041s.c = th;
                ((b) this.d).subscribe(c1041s);
                break;
            case 1:
                ((InterfaceC0988v) this.c).onError(th);
                break;
            case 2:
                this.b = p033f3.d.f3969a;
                try {
                    ((p027e3.b) this.d).accept(null, th);
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    th = new p017c3.c(th, th2);
                }
                ((InterfaceC0988v) this.c).onError(th);
                break;
            default:
                if (this.b != p033f3.d.f3969a) {
                    b(th);
                } else {
                    a.onError(th);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5578a) {
            case 0:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((C1041s) this.c).f5579a.onSubscribe(this);
                }
                break;
            case 1:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((InterfaceC0988v) this.c).onSubscribe(this);
                }
                break;
            case 2:
                if (p033f3.d.g(this.b, cVar)) {
                    this.b = cVar;
                    ((InterfaceC0988v) this.c).onSubscribe(this);
                }
                break;
            default:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.c;
                if (p033f3.d.g(this.b, cVar)) {
                    try {
                        ((o0) this.d).b.accept(cVar);
                        this.b = cVar;
                        interfaceC0988v.onSubscribe(this);
                    } catch (Throwable th) {
                        d.throwIfFatal(th);
                        cVar.dispose();
                        this.b = p033f3.d.f3969a;
                        interfaceC0988v.onSubscribe(e.f3970a);
                        interfaceC0988v.onError(th);
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5578a) {
            case 0:
                this.b = p033f3.d.f3969a;
                C1041s c1041s = (C1041s) this.c;
                c1041s.b = obj;
                ((b) this.d).subscribe(c1041s);
                break;
            case 1:
                ((InterfaceC0988v) this.c).onSuccess(obj);
                try {
                    ((p027e3.g) this.d).accept(obj);
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    a.onError(th);
                    return;
                }
                break;
            case 2:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.c;
                this.b = p033f3.d.f3969a;
                try {
                    ((p027e3.b) this.d).accept(obj, null);
                    interfaceC0988v.onSuccess(obj);
                } catch (Throwable th2) {
                    d.throwIfFatal(th2);
                    interfaceC0988v.onError(th2);
                    return;
                }
                break;
            default:
                c cVar = this.b;
                p033f3.d dVar = p033f3.d.f3969a;
                if (cVar != dVar) {
                    try {
                        ((o0) this.d).c.accept(obj);
                        this.b = dVar;
                        ((InterfaceC0988v) this.c).onSuccess(obj);
                        a();
                    } catch (Throwable th3) {
                        d.throwIfFatal(th3);
                        b(th3);
                    }
                    break;
                }
                break;
        }
    }

    public r(InterfaceC0988v interfaceC0988v, b bVar) {
        this.f5578a = 0;
        this.c = new C1041s(interfaceC0988v);
        this.d = bVar;
    }
}

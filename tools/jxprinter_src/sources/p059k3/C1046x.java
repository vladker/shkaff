package p059k3;

import io.reactivex.InterfaceC0988v;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: k3.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1046x implements InterfaceC0988v, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5588a;
    public InterfaceC0988v b;
    public c c;

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5588a) {
            case 0:
                this.b = null;
                this.c.dispose();
                this.c = d.f3969a;
                break;
            case 1:
                this.c.dispose();
                this.c = d.f3969a;
                break;
            case 2:
                this.c.dispose();
                this.c = d.f3969a;
                break;
            default:
                this.c.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5588a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return this.c.e();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5588a) {
            case 0:
                this.c = d.f3969a;
                InterfaceC0988v interfaceC0988v = this.b;
                if (interfaceC0988v != null) {
                    this.b = null;
                    interfaceC0988v.onComplete();
                }
                break;
            case 1:
                this.b.onComplete();
                break;
            case 2:
                this.c = d.f3969a;
                this.b.onComplete();
                break;
            default:
                this.b.onSuccess(Boolean.TRUE);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5588a) {
            case 0:
                this.c = d.f3969a;
                InterfaceC0988v interfaceC0988v = this.b;
                if (interfaceC0988v != null) {
                    this.b = null;
                    interfaceC0988v.onError(th);
                }
                break;
            case 1:
                this.b.onError(th);
                break;
            case 2:
                this.c = d.f3969a;
                this.b.onError(th);
                break;
            default:
                this.b.onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5588a) {
            case 0:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 1:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 2:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5588a) {
            case 0:
                this.c = d.f3969a;
                InterfaceC0988v interfaceC0988v = this.b;
                if (interfaceC0988v != null) {
                    this.b = null;
                    interfaceC0988v.onSuccess(obj);
                }
                break;
            case 1:
                this.b.onSuccess(obj);
                break;
            case 2:
                this.c = d.f3969a;
                this.b.onComplete();
                break;
            default:
                this.b.onSuccess(Boolean.FALSE);
                break;
        }
    }

    public /* synthetic */ C1046x(InterfaceC0988v interfaceC0988v, int i5) {
        this.f5588a = i5;
        this.b = interfaceC0988v;
    }
}

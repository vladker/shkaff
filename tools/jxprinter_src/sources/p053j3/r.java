package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0988v;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements InterfaceC0679f, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5451a;
    public Object b;
    public c c;

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5451a) {
            case 0:
                this.b = null;
                this.c.dispose();
                this.c = d.f3969a;
                break;
            case 1:
                this.c.dispose();
                this.c = d.f3969a;
                break;
            default:
                this.c.dispose();
                this.c = d.f3969a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5451a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.c.e();
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5451a) {
            case 0:
                this.c = d.f3969a;
                InterfaceC0679f interfaceC0679f = (InterfaceC0679f) this.b;
                if (interfaceC0679f != null) {
                    this.b = null;
                    interfaceC0679f.onComplete();
                }
                break;
            case 1:
                ((InterfaceC0679f) this.b).onComplete();
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0988v) this.b).onComplete();
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        switch (this.f5451a) {
            case 0:
                this.c = d.f3969a;
                InterfaceC0679f interfaceC0679f = (InterfaceC0679f) this.b;
                if (interfaceC0679f != null) {
                    this.b = null;
                    interfaceC0679f.onError(th);
                }
                break;
            case 1:
                ((InterfaceC0679f) this.b).onError(th);
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0988v) this.b).onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        switch (this.f5451a) {
            case 0:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((InterfaceC0679f) this.b).onSubscribe(this);
                }
                break;
            case 1:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((InterfaceC0679f) this.b).onSubscribe(this);
                }
                break;
            default:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((InterfaceC0988v) this.b).onSubscribe(this);
                }
                break;
        }
    }

    public /* synthetic */ r(Object obj, int i5) {
        this.f5451a = i5;
        this.b = obj;
    }
}

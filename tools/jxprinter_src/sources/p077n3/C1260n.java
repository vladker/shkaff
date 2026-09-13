package p077n3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: n3.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1260n implements S, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6302a;
    public Object b;
    public c c;

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f6302a) {
            case 0:
                this.b = null;
                this.c.dispose();
                this.c = d.f3969a;
                break;
            case 1:
                this.c.dispose();
                break;
            default:
                this.c.dispose();
                this.c = d.f3969a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f6302a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.c.e();
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        switch (this.f6302a) {
            case 0:
                this.c = d.f3969a;
                S s6 = (S) this.b;
                if (s6 != null) {
                    this.b = null;
                    s6.onError(th);
                }
                break;
            case 1:
                ((S) this.b).onError(th);
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0988v) this.b).onError(th);
                break;
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        switch (this.f6302a) {
            case 0:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((S) this.b).onSubscribe(this);
                }
                break;
            case 1:
                if (d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((S) this.b).onSubscribe(this);
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

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        switch (this.f6302a) {
            case 0:
                this.c = d.f3969a;
                S s6 = (S) this.b;
                if (s6 != null) {
                    this.b = null;
                    s6.onSuccess(obj);
                }
                break;
            case 1:
                ((S) this.b).onSuccess(obj);
                break;
            default:
                this.c = d.f3969a;
                ((InterfaceC0988v) this.b).onSuccess(obj);
                break;
        }
    }

    public /* synthetic */ C1260n(Object obj, int i5) {
        this.f6302a = i5;
        this.b = obj;
    }
}

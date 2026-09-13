package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: k3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1032l implements InterfaceC0988v, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5567a;
    public final S b;
    public c c;

    public /* synthetic */ C1032l(S s6, int i5) {
        this.f5567a = i5;
        this.b = s6;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5567a) {
            case 0:
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
        switch (this.f5567a) {
            case 0:
                break;
        }
        return this.c.e();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5567a) {
            case 0:
                this.c = d.f3969a;
                this.b.onSuccess(0L);
                break;
            default:
                this.c = d.f3969a;
                this.b.onSuccess(Boolean.TRUE);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5567a) {
            case 0:
                this.c = d.f3969a;
                this.b.onError(th);
                break;
            default:
                this.c = d.f3969a;
                this.b.onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5567a) {
            case 0:
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
        switch (this.f5567a) {
            case 0:
                this.c = d.f3969a;
                this.b.onSuccess(1L);
                break;
            default:
                this.c = d.f3969a;
                this.b.onSuccess(Boolean.FALSE);
                break;
        }
    }
}

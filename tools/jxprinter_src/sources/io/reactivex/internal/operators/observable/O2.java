package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O2 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5060a = 0;
    public final p083o3.d b;
    public final int c;
    public volatile boolean d;
    public Throwable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f5061f;

    public O2(N2 n6, int i5, int i6) {
        this.f5061f = n6;
        this.c = i5;
        this.b = new p083o3.d(i6);
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5060a) {
            case 0:
                this.d = true;
                ((N2) this.f5061f).a();
                break;
            default:
                this.d = true;
                ((P2) this.f5061f).a();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5060a) {
            case 0:
                this.e = th;
                this.d = true;
                ((N2) this.f5061f).a();
                break;
            default:
                this.e = th;
                this.d = true;
                ((P2) this.f5061f).a();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5060a) {
            case 0:
                this.b.offer(obj);
                ((N2) this.f5061f).a();
                break;
            default:
                this.b.offer(obj);
                ((P2) this.f5061f).a();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5060a) {
            case 0:
                N2 n6 = (N2) this.f5061f;
                n6.c.a(this.c, cVar);
                break;
            default:
                P2 p6 = (P2) this.f5061f;
                p6.c.a(this.c, cVar);
                break;
        }
    }

    public O2(P2 p6, int i5, int i6) {
        this.f5061f = p6;
        this.c = i5;
        this.b = new p083o3.d(i6);
    }
}

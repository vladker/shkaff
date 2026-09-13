package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.s4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0795s4 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 3837284832786408377L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0801t4 f4764a;
    public final long b;
    public final int c;
    public volatile p043h3.j d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4765f;

    public C0795s4(C0801t4 c0801t4, long j6, int i5) {
        this.f4764a = c0801t4;
        this.b = j6;
        this.c = i5;
    }

    @Override // t5.c
    public final void onComplete() {
        C0801t4 c0801t4 = this.f4764a;
        if (this.b == c0801t4.f4786k) {
            this.e = true;
            c0801t4.b();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        C0801t4 c0801t4 = this.f4764a;
        if (this.b == c0801t4.f4786k) {
            p100r3.c cVar = c0801t4.f4781f;
            cVar.getClass();
            if (p100r3.g.a(cVar, th)) {
                if (!c0801t4.d) {
                    c0801t4.f4783h.cancel();
                }
                this.e = true;
                c0801t4.b();
                return;
            }
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        C0801t4 c0801t4 = this.f4764a;
        if (this.b == c0801t4.f4786k) {
            if (this.f4765f != 0 || this.d.offer(obj)) {
                c0801t4.b();
            } else {
                onError(new p017c3.e("Queue full?!"));
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this, dVar)) {
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f4765f = iC;
                    this.d = gVar;
                    this.e = true;
                    this.f4764a.b();
                    return;
                }
                if (iC == 2) {
                    this.f4765f = iC;
                    this.d = gVar;
                    dVar.request(this.c);
                    return;
                }
            }
            this.d = new p083o3.c(this.c);
            dVar.request(this.c);
        }
    }
}

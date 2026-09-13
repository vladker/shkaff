package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p5 extends AtomicReference implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -4627193790118206028L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o5 f4730a;
    public final int b;
    public final int c;
    public p043h3.j d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4732g;

    public p5(o5 o5Var, int i5) {
        this.f4730a = o5Var;
        this.b = i5;
        this.c = i5 - (i5 >> 2);
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this);
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4731f = true;
        this.f4730a.b();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        o5 o5Var = this.f4730a;
        p100r3.c cVar = o5Var.e;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4731f = true;
            o5Var.b();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4732g != 2) {
            this.d.offer(obj);
        }
        this.f4730a.b();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this, dVar)) {
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f4732g = iC;
                    this.d = gVar;
                    this.f4731f = true;
                    this.f4730a.b();
                    return;
                }
                if (iC == 2) {
                    this.f4732g = iC;
                    this.d = gVar;
                    dVar.request(this.b);
                    return;
                }
            }
            this.d = new p083o3.c(this.b);
            dVar.request(this.b);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (this.f4732g != 1) {
            long j7 = this.e + j6;
            if (j7 < this.c) {
                this.e = j7;
            } else {
                this.e = 0L;
                ((t5.d) get()).request(j7);
            }
        }
    }
}

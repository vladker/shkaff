package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class V extends AtomicInteger implements InterfaceC0984q, Z, t5.d {
    private static final long serialVersionUID = -3511336836796789179L;
    public final p027e3.o b;
    public final int c;
    public final int d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p043h3.j f4472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f4473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4474i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4477l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y f4470a = new Y(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p100r3.c f4475j = new p100r3.c();

    public V(p027e3.o oVar, int i5) {
        this.b = oVar;
        this.c = i5;
        this.d = i5 - (i5 >> 2);
    }

    public abstract void c();

    public abstract void d();

    @Override // t5.c
    public final void onComplete() {
        this.f4473h = true;
        c();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4477l == 2 || this.f4472g.offer(obj)) {
            c();
        } else {
            this.e.cancel();
            onError(new IllegalStateException("Queue full?!"));
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(7);
                if (iC == 1) {
                    this.f4477l = iC;
                    this.f4472g = gVar;
                    this.f4473h = true;
                    d();
                    c();
                    return;
                }
                if (iC == 2) {
                    this.f4477l = iC;
                    this.f4472g = gVar;
                    d();
                    dVar.request(this.c);
                    return;
                }
            }
            this.f4472g = new p083o3.c(this.c);
            d();
            dVar.request(this.c);
        }
    }
}

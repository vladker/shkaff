package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.a4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0688a4 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 4804128302091633067L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f4552a;
    public final int b;
    public final int c;
    public long d;
    public volatile p043h3.j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4554g;

    /* JADX WARN: Multi-variable type inference failed */
    public C0688a4(Z3 z6, int i5) {
        this.f4552a = (AtomicInteger) z6;
        this.c = i5 - (i5 >> 2);
        this.b = i5;
    }

    public final void a() {
        if (this.f4554g != 1) {
            long j6 = this.d + 1;
            if (j6 < this.c) {
                this.d = j6;
            } else {
                this.d = 0L;
                ((t5.d) get()).request(j6);
            }
        }
    }

    public final void clear() {
        p043h3.j jVar = this.e;
        if (jVar != null) {
            jVar.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.internal.operators.flowable.Z3, java.util.concurrent.atomic.AtomicInteger] */
    @Override // t5.c
    public final void onComplete() {
        this.f4553f = true;
        this.f4552a.f();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.reactivex.internal.operators.flowable.Z3, java.util.concurrent.atomic.AtomicInteger] */
    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4552a.a(th);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [io.reactivex.internal.operators.flowable.Z3, java.util.concurrent.atomic.AtomicInteger] */
    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4554g != 0 || this.e.offer(obj)) {
            this.f4552a.f();
        } else {
            onError(new p017c3.e());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [io.reactivex.internal.operators.flowable.Z3, java.util.concurrent.atomic.AtomicInteger] */
    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this, dVar)) {
            if (dVar instanceof p043h3.g) {
                p043h3.g gVar = (p043h3.g) dVar;
                int iC = gVar.c(3);
                if (iC == 1) {
                    this.f4554g = iC;
                    this.e = gVar;
                    this.f4553f = true;
                    this.f4552a.f();
                    return;
                }
                if (iC == 2) {
                    this.f4554g = iC;
                    this.e = gVar;
                    dVar.request(this.b);
                    return;
                }
            }
            this.e = new p083o3.c(this.b);
            dVar.request(this.b);
        }
    }
}

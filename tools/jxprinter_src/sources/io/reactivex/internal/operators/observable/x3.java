package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x3 extends AtomicInteger implements io.reactivex.I, p011b3.c, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5308a;
    public final long b;
    public final int c;
    public long d;
    public p011b3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p129w3.f f5309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5310g;

    public x3(io.reactivex.I i5, long j6, int i6) {
        this.f5308a = i5;
        this.b = j6;
        this.c = i6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5310g = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5310g;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p129w3.f fVar = this.f5309f;
        if (fVar != null) {
            this.f5309f = null;
            fVar.onComplete();
        }
        this.f5308a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p129w3.f fVar = this.f5309f;
        if (fVar != null) {
            this.f5309f = null;
            fVar.onError(th);
        }
        this.f5308a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        p129w3.f fVarCreate = this.f5309f;
        if (fVarCreate == null && !this.f5310g) {
            fVarCreate = p129w3.f.create(this.c, this);
            this.f5309f = fVarCreate;
            this.f5308a.onNext(fVarCreate);
        }
        if (fVarCreate != null) {
            fVarCreate.onNext(obj);
            long j6 = this.d + 1;
            this.d = j6;
            if (j6 >= this.b) {
                this.d = 0L;
                this.f5309f = null;
                fVarCreate.onComplete();
                if (this.f5310g) {
                    this.e.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5308a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5310g) {
            this.e.dispose();
        }
    }
}

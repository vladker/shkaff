package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T2 extends p094q3.f implements InterfaceC0984q {
    private static final long serialVersionUID = 4063763155303814625L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t5.c f4441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p027e3.o f4442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4446n;

    public T2(t5.c cVar, p027e3.o oVar, boolean z6) {
        super(false);
        this.f4441i = cVar;
        this.f4442j = oVar;
        this.f4443k = z6;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4445m) {
            return;
        }
        this.f4445m = true;
        this.f4444l = true;
        this.f4441i.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        boolean z6 = this.f4444l;
        t5.c cVar = this.f4441i;
        if (z6) {
            if (this.f4445m) {
                io.reactivex.plugins.a.onError(th);
                return;
            } else {
                cVar.onError(th);
                return;
            }
        }
        this.f4444l = true;
        if (this.f4443k && !(th instanceof Exception)) {
            cVar.onError(th);
            return;
        }
        try {
            Object objApply = this.f4442j.apply(th);
            p039g3.A.b(objApply, "The nextSupplier returned a null Publisher");
            t5.b bVar = (t5.b) objApply;
            long j6 = this.f4446n;
            if (j6 != 0) {
                d(j6);
            }
            bVar.subscribe(this);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            cVar.onError(new p017c3.c(th, th2));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4445m) {
            return;
        }
        if (!this.f4444l) {
            this.f4446n++;
        }
        this.f4441i.onNext(obj);
    }
}

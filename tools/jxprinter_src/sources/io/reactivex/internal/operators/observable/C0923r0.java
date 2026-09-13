package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.r0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0923r0 extends p048i3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f5265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f5266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5267h;

    public C0923r0(io.reactivex.I i5, p027e3.o oVar, p027e3.d dVar) {
        super(i5);
        this.f5265f = oVar;
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        int i5 = this.e;
        io.reactivex.I i6 = this.f4046a;
        if (i5 != 0) {
            i6.onNext(obj);
            return;
        }
        try {
            Object objApply = this.f5265f.apply(obj);
            if (this.f5267h) {
                boolean zA = p039g3.A.a(this.f5266g, objApply);
                this.f5266g = objApply;
                if (zA) {
                    return;
                }
            } else {
                this.f5267h = true;
                this.f5266g = objApply;
            }
            i6.onNext(obj);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p048i3.a, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        while (true) {
            Object objPoll = this.c.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f5265f.apply(objPoll);
            if (!this.f5267h) {
                this.f5267h = true;
                this.f5266g = objApply;
                return objPoll;
            }
            if (!p039g3.A.a(this.f5266g, objApply)) {
                this.f5266g = objApply;
                return objPoll;
            }
            this.f5266g = objApply;
        }
    }
}

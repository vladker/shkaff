package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G1 extends p048i3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f4943f;

    public G1(io.reactivex.I i5, p027e3.o oVar) {
        super(i5);
        this.f4943f = oVar;
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        int i5 = this.e;
        io.reactivex.I i6 = this.f4046a;
        if (i5 != 0) {
            i6.onNext(null);
            return;
        }
        try {
            Object objApply = this.f4943f.apply(obj);
            p039g3.A.b(objApply, "The mapper function returned a null value.");
            i6.onNext(objApply);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p048i3.a, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.c.poll();
        if (objPoll == null) {
            return null;
        }
        Object objApply = this.f4943f.apply(objPoll);
        p039g3.A.b(objApply, "The mapper function returned a null value.");
        return objApply;
    }
}

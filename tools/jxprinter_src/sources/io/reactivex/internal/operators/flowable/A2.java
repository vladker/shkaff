package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A2 extends p088p3.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f4177f;

    public A2(t5.c cVar, p027e3.o oVar) {
        super(cVar);
        this.f4177f = oVar;
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        int i5 = this.e;
        t5.c cVar = this.f7736a;
        if (i5 != 0) {
            cVar.onNext(null);
            return;
        }
        try {
            Object objApply = this.f4177f.apply(obj);
            p039g3.A.b(objApply, "The mapper function returned a null value.");
            cVar.onNext(objApply);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p088p3.b, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.c.poll();
        if (objPoll == null) {
            return null;
        }
        Object objApply = this.f4177f.apply(objPoll);
        p039g3.A.b(objApply, "The mapper function returned a null value.");
        return objApply;
    }
}

package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.z2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0835z2 extends p088p3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f4850f;

    public C0835z2(p043h3.a aVar, p027e3.o oVar) {
        super(aVar);
        this.f4850f = oVar;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        try {
            Object objApply = this.f4850f.apply(obj);
            p039g3.A.b(objApply, "The mapper function returned a null value.");
            return this.f7735a.h(objApply);
        } catch (Throwable th) {
            a(th);
            return true;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        int i5 = this.e;
        p043h3.a aVar = this.f7735a;
        if (i5 != 0) {
            aVar.onNext(null);
            return;
        }
        try {
            Object objApply = this.f4850f.apply(obj);
            p039g3.A.b(objApply, "The mapper function returned a null value.");
            aVar.onNext(objApply);
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p088p3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.c.poll();
        if (objPoll == null) {
            return null;
        }
        Object objApply = this.f4850f.apply(objPoll);
        p039g3.A.b(objApply, "The mapper function returned a null value.");
        return objApply;
    }
}

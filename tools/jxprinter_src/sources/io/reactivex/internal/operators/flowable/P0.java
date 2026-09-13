package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P0 extends p088p3.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.g f4396f;

    public P0(t5.c cVar, p027e3.g gVar) {
        super(cVar);
        this.f4396f = gVar;
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        this.f7736a.onNext(obj);
        if (this.e == 0) {
            try {
                this.f4396f.accept(obj);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    @Override // p088p3.b, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.c.poll();
        if (objPoll != null) {
            this.f4396f.accept(objPoll);
        }
        return objPoll;
    }
}

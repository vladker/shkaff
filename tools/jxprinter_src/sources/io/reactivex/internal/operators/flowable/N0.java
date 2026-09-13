package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N0 extends p088p3.b implements p043h3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f4363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.d f4364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f4365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4366i;

    public N0(t5.c cVar, p027e3.o oVar, p027e3.d dVar) {
        super(cVar);
        this.f4363f = oVar;
        this.f4364g = dVar;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        int i5 = this.e;
        t5.c cVar = this.f7736a;
        if (i5 != 0) {
            cVar.onNext(obj);
            return true;
        }
        try {
            Object objApply = this.f4363f.apply(obj);
            if (this.f4366i) {
                p027e3.d dVar = this.f4364g;
                Object obj2 = this.f4365h;
                ((V1.b) dVar).getClass();
                boolean zA = p039g3.A.a(obj2, objApply);
                this.f4365h = objApply;
                if (zA) {
                    return false;
                }
            } else {
                this.f4366i = true;
                this.f4365h = objApply;
            }
            cVar.onNext(obj);
            return true;
        } catch (Throwable th) {
            a(th);
            return true;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (h(obj)) {
            return;
        }
        this.b.request(1L);
    }

    @Override // p088p3.b, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        while (true) {
            Object objPoll = this.c.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f4363f.apply(objPoll);
            if (!this.f4366i) {
                this.f4366i = true;
                this.f4365h = objApply;
                return objPoll;
            }
            Object obj = this.f4365h;
            ((V1.b) this.f4364g).getClass();
            if (!p039g3.A.a(obj, objApply)) {
                this.f4365h = objApply;
                return objPoll;
            }
            this.f4365h = objApply;
            if (this.e != 1) {
                this.b.request(1L);
            }
        }
    }
}

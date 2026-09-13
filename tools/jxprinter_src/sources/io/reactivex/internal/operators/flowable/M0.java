package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M0 extends p088p3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f4354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.d f4355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f4356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4357i;

    public M0(p043h3.a aVar, p027e3.o oVar, p027e3.d dVar) {
        super(aVar);
        this.f4354f = oVar;
        this.f4355g = dVar;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        int i5 = this.e;
        p043h3.a aVar = this.f7735a;
        if (i5 != 0) {
            return aVar.h(obj);
        }
        try {
            Object objApply = this.f4354f.apply(obj);
            if (this.f4357i) {
                p027e3.d dVar = this.f4355g;
                Object obj2 = this.f4356h;
                ((V1.b) dVar).getClass();
                boolean zA = p039g3.A.a(obj2, objApply);
                this.f4356h = objApply;
                if (zA) {
                    return false;
                }
            } else {
                this.f4357i = true;
                this.f4356h = objApply;
            }
            aVar.onNext(obj);
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

    @Override // p088p3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        while (true) {
            Object objPoll = this.c.poll();
            if (objPoll == null) {
                return null;
            }
            Object objApply = this.f4354f.apply(objPoll);
            if (!this.f4357i) {
                this.f4357i = true;
                this.f4356h = objApply;
                return objPoll;
            }
            Object obj = this.f4356h;
            ((V1.b) this.f4355g).getClass();
            if (!p039g3.A.a(obj, objApply)) {
                this.f4356h = objApply;
                return objPoll;
            }
            this.f4356h = objApply;
            if (this.e != 1) {
                this.b.request(1L);
            }
        }
    }
}

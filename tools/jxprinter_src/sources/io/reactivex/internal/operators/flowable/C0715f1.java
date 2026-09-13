package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.f1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0715f1 extends p088p3.b implements p043h3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.q f4615f;

    public C0715f1(t5.c cVar, p027e3.q qVar) {
        super(cVar);
        this.f4615f = qVar;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        int i5 = this.e;
        t5.c cVar = this.f7736a;
        if (i5 != 0) {
            cVar.onNext(null);
            return true;
        }
        try {
            boolean zTest = this.f4615f.test(obj);
            if (zTest) {
                cVar.onNext(obj);
            }
            return zTest;
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
        p043h3.g gVar = this.c;
        while (true) {
            Object objPoll = gVar.poll();
            if (objPoll == null) {
                return null;
            }
            if (this.f4615f.test(objPoll)) {
                return objPoll;
            }
            if (this.e == 2) {
                gVar.request(1L);
            }
        }
    }
}

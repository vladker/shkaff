package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.e1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0709e1 extends p088p3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.q f4597f;

    public C0709e1(p043h3.a aVar, p027e3.q qVar) {
        super(aVar);
        this.f4597f = qVar;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        int i5 = this.e;
        p043h3.a aVar = this.f7735a;
        if (i5 != 0) {
            return aVar.h(null);
        }
        try {
            return this.f4597f.test(obj) && aVar.h(obj);
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
        p043h3.g gVar = this.c;
        while (true) {
            Object objPoll = gVar.poll();
            if (objPoll == null) {
                return null;
            }
            if (this.f4597f.test(objPoll)) {
                return objPoll;
            }
            if (this.e == 2) {
                gVar.request(1L);
            }
        }
    }
}

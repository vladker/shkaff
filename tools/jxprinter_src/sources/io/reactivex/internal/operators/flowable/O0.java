package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O0 extends p088p3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.g f4391f;

    public O0(p043h3.a aVar, p027e3.g gVar) {
        super(aVar);
        this.f4391f = gVar;
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        boolean zH = this.f7735a.h(obj);
        try {
            this.f4391f.accept(obj);
            return zH;
        } catch (Throwable th) {
            a(th);
            return zH;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f7735a.onNext(obj);
        if (this.e == 0) {
            try {
                this.f4391f.accept(obj);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    @Override // p088p3.a, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.c.poll();
        if (objPoll != null) {
            this.f4391f.accept(objPoll);
        }
        return objPoll;
    }
}

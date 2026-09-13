package io.reactivex.internal.operators.flowable;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L0 extends p088p3.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Collection f4333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.o f4334g;

    public L0(t5.c cVar, p027e3.o oVar, Collection collection) {
        super(cVar);
        this.f4334g = oVar;
        this.f4333f = collection;
    }

    @Override // p088p3.b, p043h3.j
    public final void clear() {
        this.f4333f.clear();
        super.clear();
    }

    @Override // p088p3.b, t5.c
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f4333f.clear();
        this.f7736a.onComplete();
    }

    @Override // p088p3.b, t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        this.f4333f.clear();
        this.f7736a.onError(th);
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
            Object objApply = this.f4334g.apply(obj);
            p039g3.A.b(objApply, "The keySelector returned a null key");
            if (this.f4333f.add(objApply)) {
                cVar.onNext(obj);
            } else {
                this.b.request(1L);
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p088p3.b, p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll;
        while (true) {
            objPoll = this.c.poll();
            if (objPoll == null) {
                break;
            }
            Object objApply = this.f4334g.apply(objPoll);
            p039g3.A.b(objApply, "The keySelector returned a null key");
            if (this.f4333f.add(objApply)) {
                break;
            }
            if (this.e == 2) {
                this.b.request(1L);
            }
        }
        return objPoll;
    }
}

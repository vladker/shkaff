package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D0 extends p048i3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.q f4897f;

    public D0(io.reactivex.I i5, p027e3.q qVar) {
        super(i5);
        this.f4897f = qVar;
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onNext(Object obj) {
        int i5 = this.e;
        io.reactivex.I i6 = this.f4046a;
        if (i5 != 0) {
            i6.onNext(null);
            return;
        }
        try {
            if (this.f4897f.test(obj)) {
                i6.onNext(obj);
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p048i3.a, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll;
        do {
            objPoll = this.c.poll();
            if (objPoll == null) {
                break;
            }
        } while (!this.f4897f.test(objPoll));
        return objPoll;
    }
}

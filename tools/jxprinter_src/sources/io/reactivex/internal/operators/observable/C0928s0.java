package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0928s0 extends p048i3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.g f5277f;

    public C0928s0(io.reactivex.I i5, p027e3.g gVar) {
        super(i5);
        this.f5277f = gVar;
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onNext(Object obj) {
        this.f4046a.onNext(obj);
        if (this.e == 0) {
            try {
                this.f5277f.accept(obj);
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    @Override // p048i3.a, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.c.poll();
        if (objPoll != null) {
            this.f5277f.accept(objPoll);
        }
        return objPoll;
    }
}

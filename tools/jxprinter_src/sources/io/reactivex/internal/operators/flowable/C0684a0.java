package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0684a0 implements t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4541a;
    public final Object b;
    public boolean c;

    public C0684a0(Object obj, t5.c cVar) {
        this.b = obj;
        this.f4541a = cVar;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (j6 <= 0 || this.c) {
            return;
        }
        this.c = true;
        Object obj = this.b;
        t5.c cVar = this.f4541a;
        cVar.onNext(obj);
        cVar.onComplete();
    }

    @Override // t5.d
    public final void cancel() {
    }
}

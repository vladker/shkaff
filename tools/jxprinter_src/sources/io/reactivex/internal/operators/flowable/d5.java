package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4595a;
    public final e5 b;

    public d5(long j6, e5 e5Var) {
        this.f4595a = j6;
        this.b = e5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e5 e5Var = this.b;
        if (e5Var.e) {
            e5Var.f4611s = true;
            e5Var.dispose();
        } else {
            e5Var.d.offer(this);
        }
        if (e5Var.p()) {
            e5Var.u();
        }
    }
}

package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4958a;
    public final I3 b;

    public H3(long j6, I3 i5) {
        this.f4958a = j6;
        this.b = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        I3 i5 = this.b;
        if (i5.d) {
            i5.f4976r = true;
            i5.h();
        } else {
            i5.c.offer(this);
        }
        if (i5.c()) {
            i5.i();
        }
    }
}

package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.observable.InterfaceC0926r3;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.p4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0778p4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4729a = 1;
    public final long b;
    public final Object c;

    public RunnableC0778p4(long j6, t5.d dVar) {
        this.c = dVar;
        this.b = j6;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [io.reactivex.internal.operators.flowable.L4, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r0v5, types: [io.reactivex.internal.operators.observable.r3, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4729a) {
            case 0:
                ((t5.d) this.c).request(this.b);
                break;
            case 1:
                ((Number) this.c).b(this.b);
                break;
            default:
                this.c.b(this.b);
                break;
        }
    }

    public RunnableC0778p4(long j6, InterfaceC0926r3 interfaceC0926r3) {
        this.b = j6;
        this.c = interfaceC0926r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC0778p4(long j6, L4 l6) {
        this.b = j6;
        this.c = (Number) l6;
    }
}

package p007a4;

import p147z3.Q;

/* JADX INFO: renamed from: a4.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0290m0 extends AbstractRunnableC0294o0 {
    public final /* synthetic */ AbstractC0298q0 b;
    private final InterfaceC0285k cont;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0290m0(AbstractC0298q0 abstractC0298q0, long j6, InterfaceC0285k interfaceC0285k) {
        super(j6);
        this.b = abstractC0298q0;
        this.cont = interfaceC0285k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.cont.resumeUndispatched(this.b, Q.INSTANCE);
    }

    @Override // p007a4.AbstractRunnableC0294o0
    public String toString() {
        return super.toString() + this.cont;
    }
}

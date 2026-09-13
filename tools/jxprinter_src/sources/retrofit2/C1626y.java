package retrofit2;

import okhttp3.InterfaceC1352e;

/* JADX INFO: renamed from: retrofit2.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1626y extends A {
    public final /* synthetic */ int d;
    public final InterfaceC1615m e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1626y(q0 q0Var, InterfaceC1352e interfaceC1352e, InterfaceC1621t interfaceC1621t, InterfaceC1615m interfaceC1615m, int i5) {
        super(q0Var, interfaceC1352e, interfaceC1621t);
        this.d = i5;
        this.e = interfaceC1615m;
    }

    @Override // retrofit2.A
    public final Object adapt(InterfaceC1613k interfaceC1613k, Object[] objArr) {
        switch (this.d) {
            case 0:
                return this.e.c(interfaceC1613k);
            default:
                InterfaceC1613k interfaceC1613k2 = (InterfaceC1613k) this.e.c(interfaceC1613k);
                E3.g gVar = (E3.g) objArr[objArr.length - 1];
                try {
                    return J.awaitResponse(interfaceC1613k2, gVar);
                } catch (Exception e) {
                    return J.suspendAndThrow(e, gVar);
                }
        }
    }
}

package retrofit2;

import okhttp3.InterfaceC1352e;

/* JADX INFO: renamed from: retrofit2.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1627z extends A {
    public final InterfaceC1615m d;
    public final boolean e;

    public C1627z(q0 q0Var, InterfaceC1352e interfaceC1352e, InterfaceC1621t interfaceC1621t, InterfaceC1615m interfaceC1615m, boolean z6) {
        super(q0Var, interfaceC1352e, interfaceC1621t);
        this.d = interfaceC1615m;
        this.e = z6;
    }

    @Override // retrofit2.A
    public final Object adapt(InterfaceC1613k interfaceC1613k, Object[] objArr) {
        InterfaceC1613k interfaceC1613k2 = (InterfaceC1613k) this.d.c(interfaceC1613k);
        E3.g gVar = (E3.g) objArr[objArr.length - 1];
        try {
            return this.e ? J.awaitUnit(interfaceC1613k2, gVar) : J.await(interfaceC1613k2, gVar);
        } catch (LinkageError e) {
            throw e;
        } catch (ThreadDeath e6) {
            throw e6;
        } catch (VirtualMachineError e7) {
            throw e7;
        } catch (Throwable th) {
            return J.suspendAndThrow(th, gVar);
        }
    }
}

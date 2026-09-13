package p023d4;

import E3.g;
import E3.q;
import java.util.List;
import kotlinx.coroutines.flow.internal.B;
import p007a4.H0;
import p018c4.EnumC0368b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X1 implements n2, InterfaceC0582e, B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n2 f3841a;
    private final H0 job;

    public X1(n2 n2Var, H0 h1) {
        this.f3841a = n2Var;
        this.job = h1;
    }

    @Override // p023d4.n2, p023d4.Z1, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, g<?> gVar) {
        return this.f3841a.collect(interfaceC0615p, gVar);
    }

    @Override // kotlinx.coroutines.flow.internal.B
    public InterfaceC0612o fuse(q qVar, int i5, EnumC0368b enumC0368b) {
        return q2.fuseStateFlow(this, qVar, i5, enumC0368b);
    }

    @Override // p023d4.n2, p023d4.Z1
    public List<Object> getReplayCache() {
        return this.f3841a.getReplayCache();
    }

    @Override // p023d4.n2
    public final Object getValue() {
        return this.f3841a.getValue();
    }
}

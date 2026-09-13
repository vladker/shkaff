package p023d4;

import E3.g;
import F3.i;
import O3.l;
import O3.p;
import kotlin.jvm.internal.T;
import kotlinx.coroutines.flow.internal.E;
import p147z3.Q;

/* JADX INFO: renamed from: d4.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0606m implements InterfaceC0612o {
    public final p areEquivalent;
    public final l keySelector;
    private final InterfaceC0612o upstream;

    public C0606m(InterfaceC0612o interfaceC0612o, l lVar, p pVar) {
        this.upstream = interfaceC0612o;
        this.keySelector = lVar;
        this.areEquivalent = pVar;
    }

    @Override // p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
        T t6 = new T();
        t6.f5689a = E.NULL;
        Object objCollect = this.upstream.collect(new C0603l(this, t6, interfaceC0615p), gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }
}

package p023d4;

import O3.q;
import O3.r;
import O3.s;
import O3.t;
import O3.u;
import kotlin.jvm.internal.E;
import kotlinx.coroutines.flow.internal.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class T1 {
    public static final <T1, T2, R> InterfaceC0612o combine(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, q qVar) {
        return AbstractC0618q.flowCombine(interfaceC0612o, interfaceC0612o2, qVar);
    }

    public static final <T1, T2, R> InterfaceC0612o combineTransform(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, r rVar) {
        return AbstractC0618q.flow(new P1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2}, null, rVar, 1));
    }

    private static final <T, R> InterfaceC0612o combineTransformUnsafe$FlowKt__ZipKt(InterfaceC0612o[] interfaceC0612oArr, q qVar) {
        E.l();
        throw null;
    }

    public static final <T1, T2, R> InterfaceC0612o flowCombine(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, q qVar) {
        return new O1(interfaceC0612o, interfaceC0612o2, qVar, 0);
    }

    public static final <T1, T2, R> InterfaceC0612o flowCombineTransform(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, r rVar) {
        return AbstractC0618q.flow(new P1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2}, null, rVar, 0));
    }

    public static final <T1, T2, R> InterfaceC0612o zip(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, q qVar) {
        return w.zipImpl(interfaceC0612o, interfaceC0612o2, qVar);
    }

    public static final <T1, T2, T3, R> InterfaceC0612o combine(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, r rVar) {
        return new B0(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2, interfaceC0612o3}, rVar, 2);
    }

    public static final <T1, T2, T3, R> InterfaceC0612o combineTransform(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, s sVar) {
        return AbstractC0618q.flow(new R1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2, interfaceC0612o3}, null, 0));
    }

    public static final <T1, T2, T3, T4, R> InterfaceC0612o combine(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, InterfaceC0612o interfaceC0612o4, s sVar) {
        return new N1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2, interfaceC0612o3, interfaceC0612o4}, 0);
    }

    public static final <T1, T2, T3, T4, R> InterfaceC0612o combineTransform(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, InterfaceC0612o interfaceC0612o4, t tVar) {
        return AbstractC0618q.flow(new R1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2, interfaceC0612o3, interfaceC0612o4}, null, 1));
    }

    public static final <T1, T2, T3, T4, T5, R> InterfaceC0612o combine(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, InterfaceC0612o interfaceC0612o4, InterfaceC0612o interfaceC0612o5, t tVar) {
        return new N1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2, interfaceC0612o3, interfaceC0612o4, interfaceC0612o5}, 1);
    }

    public static final <T1, T2, T3, T4, T5, R> InterfaceC0612o combineTransform(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0612o interfaceC0612o3, InterfaceC0612o interfaceC0612o4, InterfaceC0612o interfaceC0612o5, u uVar) {
        return AbstractC0618q.flow(new R1(new InterfaceC0612o[]{interfaceC0612o, interfaceC0612o2, interfaceC0612o3, interfaceC0612o4, interfaceC0612o5}, null, 2));
    }

    public static final <T, R> InterfaceC0612o combineTransform(InterfaceC0612o[] interfaceC0612oArr, q qVar) {
        E.l();
        throw null;
    }

    public static final <T, R> InterfaceC0612o combineTransform(Iterable<? extends InterfaceC0612o> iterable, q qVar) {
        E.l();
        throw null;
    }
}

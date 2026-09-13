package p023d4;

import E3.g;
import O3.p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t2 implements InterfaceC0615p {
    private final p action;
    private final InterfaceC0615p collector;

    public t2(InterfaceC0615p interfaceC0615p, p pVar) {
        this.collector = interfaceC0615p;
        this.action = pVar;
    }

    @Override // p023d4.InterfaceC0615p
    public Object emit(Object obj, g<? super Q> gVar) {
        return this.collector.emit(obj, gVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (((p023d4.t2) r7).onSubscription(r0) == r1) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [G3.d] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onSubscription(E3.g<? super p147z3.Q> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof p023d4.s2
            if (r0 == 0) goto L13
            r0 = r7
            d4.s2 r0 = (p023d4.s2) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            d4.s2 r0 = new d4.s2
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            p147z3.v.throwOnFailure(r7)
            goto L75
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            kotlinx.coroutines.flow.internal.F r2 = r0.b
            d4.t2 r4 = r0.f3911a
            p147z3.v.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L3c
            goto L5c
        L3c:
            r7 = move-exception
            goto L7b
        L3e:
            p147z3.v.throwOnFailure(r7)
            kotlinx.coroutines.flow.internal.F r2 = new kotlinx.coroutines.flow.internal.F
            d4.p r7 = r6.collector
            E3.q r5 = r0.getContext()
            r2.<init>(r7, r5)
            O3.p r7 = r6.action     // Catch: java.lang.Throwable -> L3c
            r0.f3911a = r6     // Catch: java.lang.Throwable -> L3c
            r0.b = r2     // Catch: java.lang.Throwable -> L3c
            r0.e = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L3c
            if (r7 != r1) goto L5b
            goto L74
        L5b:
            r4 = r6
        L5c:
            r2.releaseIntercepted()
            d4.p r7 = r4.collector
            boolean r2 = r7 instanceof p023d4.t2
            if (r2 == 0) goto L78
            d4.t2 r7 = (p023d4.t2) r7
            r2 = 0
            r0.f3911a = r2
            r0.b = r2
            r0.e = r3
            java.lang.Object r7 = r7.onSubscription(r0)
            if (r7 != r1) goto L75
        L74:
            return r1
        L75:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        L78:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        L7b:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.t2.onSubscription(E3.g):java.lang.Object");
    }
}

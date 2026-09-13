package p023d4;

import E3.g;
import F3.i;
import kotlinx.coroutines.flow.internal.AbstractC1118g;
import p007a4.M;
import p018c4.B0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class F {
    /* JADX WARN: Code duplicated, block: B:26:0x0068  */
    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x0075 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0030, B:24:0x0056, B:28:0x006d, B:30:0x0075, B:20:0x0048, B:23:0x0052), top: B:44:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x008e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        if (r2.emit(r9, r0) == r1) goto L32;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0089 -> B:14:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(p023d4.InterfaceC0615p r6, p018c4.B0 r7, boolean r8, E3.g r9) {
        /*
            boolean r0 = r9 instanceof p023d4.E
            if (r0 == 0) goto L13
            r0 = r9
            d4.E r0 = (p023d4.E) r0
            int r1 = r0.f3792f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3792f = r1
            goto L18
        L13:
            d4.E r0 = new d4.E
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.e
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.f3792f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            boolean r8 = r0.d
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            d4.p r2 = r0.f3791a
            p147z3.v.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L36
        L33:
            r9 = r6
            r6 = r2
            goto L56
        L36:
            r6 = move-exception
            goto L95
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            boolean r8 = r0.d
            c4.z r6 = r0.c
            c4.B0 r7 = r0.b
            d4.p r2 = r0.f3791a
            p147z3.v.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L36
            goto L6d
        L4c:
            p147z3.v.throwOnFailure(r9)
            p023d4.AbstractC0618q.ensureActive(r6)
            c4.z r9 = r7.iterator()     // Catch: java.lang.Throwable -> L36
        L56:
            r0.f3791a = r6     // Catch: java.lang.Throwable -> L36
            r0.b = r7     // Catch: java.lang.Throwable -> L36
            r0.c = r9     // Catch: java.lang.Throwable -> L36
            r0.d = r8     // Catch: java.lang.Throwable -> L36
            r0.f3792f = r4     // Catch: java.lang.Throwable -> L36
            c4.e r9 = (p018c4.C0374e) r9     // Catch: java.lang.Throwable -> L36
            java.lang.Object r2 = r9.hasNext(r0)     // Catch: java.lang.Throwable -> L36
            if (r2 != r1) goto L69
            goto L8b
        L69:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L6d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L36
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r9 == 0) goto L8c
            c4.e r6 = (p018c4.C0374e) r6     // Catch: java.lang.Throwable -> L36
            java.lang.Object r9 = r6.a()     // Catch: java.lang.Throwable -> L36
            r0.f3791a = r2     // Catch: java.lang.Throwable -> L36
            r0.b = r7     // Catch: java.lang.Throwable -> L36
            r0.c = r6     // Catch: java.lang.Throwable -> L36
            r0.d = r8     // Catch: java.lang.Throwable -> L36
            r0.f3792f = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L36
            if (r9 != r1) goto L33
        L8b:
            return r1
        L8c:
            if (r8 == 0) goto L92
            r6 = 0
            p018c4.F.cancelConsumed(r7, r6)
        L92:
            z3.Q r6 = p147z3.Q.INSTANCE
            return r6
        L95:
            throw r6     // Catch: java.lang.Throwable -> L96
        L96:
            r9 = move-exception
            if (r8 == 0) goto L9c
            p018c4.F.cancelConsumed(r7, r6)
        L9c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.F.a(d4.p, c4.B0, boolean, E3.g):java.lang.Object");
    }

    public static final <T> InterfaceC0612o consumeAsFlow(B0 b1) {
        return new C0594i(b1, true);
    }

    public static final <T> Object emitAll(InterfaceC0615p interfaceC0615p, B0 b1, g<? super Q> gVar) {
        Object objA = a(interfaceC0615p, b1, true, gVar);
        return objA == i.getCOROUTINE_SUSPENDED() ? objA : Q.INSTANCE;
    }

    public static final <T> B0 produceIn(InterfaceC0612o interfaceC0612o, M m6) {
        return AbstractC1118g.asChannelFlow(interfaceC0612o).produceImpl(m6);
    }

    public static final <T> InterfaceC0612o receiveAsFlow(B0 b1) {
        return new C0594i(b1, false);
    }
}

package p023d4;

import E3.g;
import G3.m;
import O3.q;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l2 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3888a;
    public /* synthetic */ InterfaceC0615p b;
    public /* synthetic */ int c;
    public final /* synthetic */ m2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(m2 m2Var, g gVar) {
        super(3, gVar);
        this.d = m2Var;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        l2 l2Var = new l2(this.d, (g) obj3);
        l2Var.b = (InterfaceC0615p) obj;
        l2Var.c = iIntValue;
        return l2Var.invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x006f A[PHI: r0
  0x006f: PHI (r0v5 d4.p) = (r0v4 d4.p), (r0v8 d4.p) binds: [B:28:0x006c, B:13:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x007a A[PHI: r0
  0x007a: PHI (r0v6 d4.p) = (r0v4 d4.p), (r0v5 d4.p), (r0v9 d4.p) binds: [B:26:0x0060, B:31:0x0077, B:12:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r12.emit(r0, r11) == r3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        if (r0.emit(r12, r11) == r3) goto L35;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            d4.m2 r0 = r11.d
            long r1 = r0.b
            java.lang.Object r3 = F3.i.getCOROUTINE_SUSPENDED()
            int r4 = r11.f3888a
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r4 == 0) goto L3a
            if (r4 == r9) goto L36
            if (r4 == r8) goto L30
            if (r4 == r7) goto L2a
            if (r4 == r6) goto L24
            if (r4 != r5) goto L1c
            goto L36
        L1c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L24:
            d4.p r0 = r11.b
            p147z3.v.throwOnFailure(r12)
            goto L7a
        L2a:
            d4.p r0 = r11.b
            p147z3.v.throwOnFailure(r12)
            goto L6f
        L30:
            d4.p r0 = r11.b
            p147z3.v.throwOnFailure(r12)
            goto L5c
        L36:
            p147z3.v.throwOnFailure(r12)
            goto L88
        L3a:
            p147z3.v.throwOnFailure(r12)
            d4.p r12 = r11.b
            int r4 = r11.c
            if (r4 <= 0) goto L4e
            d4.e2 r0 = p023d4.e2.f3867a
            r11.f3888a = r9
            java.lang.Object r12 = r12.emit(r0, r11)
            if (r12 != r3) goto L88
            goto L87
        L4e:
            long r9 = r0.f3891a
            r11.b = r12
            r11.f3888a = r8
            java.lang.Object r0 = p007a4.AbstractC0261a0.delay(r9, r11)
            if (r0 != r3) goto L5b
            goto L87
        L5b:
            r0 = r12
        L5c:
            r8 = 0
            int r12 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r12 <= 0) goto L7a
            d4.e2 r12 = p023d4.e2.b
            r11.b = r0
            r11.f3888a = r7
            java.lang.Object r12 = r0.emit(r12, r11)
            if (r12 != r3) goto L6f
            goto L87
        L6f:
            r11.b = r0
            r11.f3888a = r6
            java.lang.Object r12 = p007a4.AbstractC0261a0.delay(r1, r11)
            if (r12 != r3) goto L7a
            goto L87
        L7a:
            d4.e2 r12 = p023d4.e2.c
            r1 = 0
            r11.b = r1
            r11.f3888a = r5
            java.lang.Object r12 = r0.emit(r12, r11)
            if (r12 != r3) goto L88
        L87:
            return r3
        L88:
            z3.Q r12 = p147z3.Q.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.l2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

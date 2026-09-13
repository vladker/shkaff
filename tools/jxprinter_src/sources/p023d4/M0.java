package p023d4;

import kotlin.jvm.internal.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M0 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f3814a;
    public final /* synthetic */ int b;
    public final /* synthetic */ InterfaceC0615p c;
    public final /* synthetic */ Object d;

    public M0(Q q6, int i5, InterfaceC0615p interfaceC0615p, Object obj) {
        this.f3814a = q6;
        this.b = i5;
        this.c = interfaceC0615p;
        this.d = obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r5.emit(r7, r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (p023d4.S0.a(r5, r7, r6.d, r0) == r1) goto L25;
     */
    @Override // p023d4.InterfaceC0615p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(java.lang.Object r7, E3.g r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof p023d4.L0
            if (r0 == 0) goto L13
            r0 = r8
            d4.L0 r0 = (p023d4.L0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            d4.L0 r0 = new d4.L0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f3812a
            java.lang.Object r1 = F3.i.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            p147z3.v.throwOnFailure(r8)
            goto L5f
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            p147z3.v.throwOnFailure(r8)
            goto L51
        L38:
            p147z3.v.throwOnFailure(r8)
            kotlin.jvm.internal.Q r8 = r6.f3814a
            int r2 = r8.f5687a
            int r2 = r2 + r4
            r8.f5687a = r2
            int r8 = r6.b
            d4.p r5 = r6.c
            if (r2 >= r8) goto L54
            r0.c = r4
            java.lang.Object r7 = r5.emit(r7, r0)
            if (r7 != r1) goto L51
            goto L5e
        L51:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        L54:
            r0.c = r3
            java.lang.Object r8 = r6.d
            java.lang.Object r7 = p023d4.S0.a(r5, r7, r8, r0)
            if (r7 != r1) goto L5f
        L5e:
            return r1
        L5f:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.M0.emit(java.lang.Object, E3.g):java.lang.Object");
    }
}

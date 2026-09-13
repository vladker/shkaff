package W3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f824a;
    public /* synthetic */ Object b;
    public final /* synthetic */ InterfaceC0233q c;
    public final /* synthetic */ O3.a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(InterfaceC0233q interfaceC0233q, O3.a aVar, E3.g gVar) {
        super(2, gVar);
        this.c = interfaceC0233q;
        this.d = aVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        x xVar = new x(this.c, this.d, gVar);
        xVar.b = obj;
        return xVar;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((x) create((AbstractC0234s) obj, (E3.g) obj2)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r6.yieldAll(r1, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r6.yieldAll(r1, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        return r0;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r5.f824a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            p147z3.v.throwOnFailure(r6)
            goto L48
        L1b:
            p147z3.v.throwOnFailure(r6)
            java.lang.Object r6 = r5.b
            W3.s r6 = (W3.AbstractC0234s) r6
            W3.q r1 = r5.c
            java.util.Iterator r1 = r1.iterator()
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L37
            r5.f824a = r3
            java.lang.Object r6 = r6.yieldAll(r1, r5)
            if (r6 != r0) goto L48
            goto L47
        L37:
            O3.a r1 = r5.d
            java.lang.Object r1 = r1.invoke()
            W3.q r1 = (W3.InterfaceC0233q) r1
            r5.f824a = r2
            java.lang.Object r6 = r6.yieldAll(r1, r5)
            if (r6 != r0) goto L48
        L47:
            return r0
        L48:
            z3.Q r6 = p147z3.Q.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.x.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

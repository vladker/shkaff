package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f799a;
    public Iterator b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0233q f800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ O3.p f801g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(Object obj, InterfaceC0233q interfaceC0233q, O3.p pVar, E3.g gVar) {
        super(2, gVar);
        this.e = obj;
        this.f800f = interfaceC0233q;
        this.f801g = pVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        I i5 = new I(this.e, this.f800f, this.f801g, gVar);
        i5.d = obj;
        return i5;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((I) create((AbstractC0234s) obj, (E3.g) obj2)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0066 A[LOOP:0: B:14:0x0047->B:19:0x0066, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r1.yield(r2, r6) == r0) goto L18;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r6.c
            java.lang.Object r2 = r6.e
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2c
            if (r1 == r4) goto L24
            if (r1 != r3) goto L1c
            java.util.Iterator r1 = r6.b
            java.lang.Object r2 = r6.f799a
            java.lang.Object r4 = r6.d
            W3.s r4 = (W3.AbstractC0234s) r4
            p147z3.v.throwOnFailure(r7)
            goto L47
        L1c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L24:
            java.lang.Object r1 = r6.d
            W3.s r1 = (W3.AbstractC0234s) r1
            p147z3.v.throwOnFailure(r7)
            goto L3f
        L2c:
            p147z3.v.throwOnFailure(r7)
            java.lang.Object r7 = r6.d
            r1 = r7
            W3.s r1 = (W3.AbstractC0234s) r1
            r6.d = r1
            r6.c = r4
            java.lang.Object r7 = r1.yield(r2, r6)
            if (r7 != r0) goto L3f
            goto L65
        L3f:
            W3.q r7 = r6.f800f
            java.util.Iterator r7 = r7.iterator()
            r4 = r1
            r1 = r7
        L47:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L68
            java.lang.Object r7 = r1.next()
            O3.p r5 = r6.f801g
            java.lang.Object r7 = r5.invoke(r2, r7)
            r6.d = r4
            r6.f799a = r7
            r6.b = r1
            r6.c = r3
            java.lang.Object r2 = r4.yield(r7, r6)
            if (r2 != r0) goto L66
        L65:
            return r0
        L66:
            r2 = r7
            goto L47
        L68:
            z3.Q r7 = p147z3.Q.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.I.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

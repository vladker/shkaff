package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f802a;
    public Iterator b;
    public int c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0233q f804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ O3.q f805h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(Object obj, InterfaceC0233q interfaceC0233q, O3.q qVar, E3.g gVar) {
        super(2, gVar);
        this.f803f = obj;
        this.f804g = interfaceC0233q;
        this.f805h = qVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        J j6 = new J(this.f803f, this.f804g, this.f805h, gVar);
        j6.e = obj;
        return j6;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((J) create((AbstractC0234s) obj, (E3.g) obj2)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0054  */
    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:22:0x007a A[LOOP:0: B:14:0x004e->B:22:0x007a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r1.yield(r2, r8) == r0) goto L21;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r8.d
            java.lang.Object r2 = r8.f803f
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L30
            if (r1 == r4) goto L28
            if (r1 != r3) goto L20
            int r1 = r8.c
            java.util.Iterator r2 = r8.b
            java.lang.Object r4 = r8.f802a
            java.lang.Object r5 = r8.e
            W3.s r5 = (W3.AbstractC0234s) r5
            p147z3.v.throwOnFailure(r9)
            r9 = r4
            r4 = r1
            goto L4e
        L20:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L28:
            java.lang.Object r1 = r8.e
            W3.s r1 = (W3.AbstractC0234s) r1
            p147z3.v.throwOnFailure(r9)
            goto L43
        L30:
            p147z3.v.throwOnFailure(r9)
            java.lang.Object r9 = r8.e
            r1 = r9
            W3.s r1 = (W3.AbstractC0234s) r1
            r8.e = r1
            r8.d = r4
            java.lang.Object r9 = r1.yield(r2, r8)
            if (r9 != r0) goto L43
            goto L79
        L43:
            W3.q r9 = r8.f804g
            java.util.Iterator r9 = r9.iterator()
            r4 = 0
            r5 = r2
            r2 = r9
            r9 = r5
            r5 = r1
        L4e:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L7c
            java.lang.Object r1 = r2.next()
            int r6 = r4 + 1
            if (r4 >= 0) goto L5f
            A3.I.throwIndexOverflow()
        L5f:
            java.lang.Integer r4 = G3.b.boxInt(r4)
            O3.q r7 = r8.f805h
            java.lang.Object r9 = r7.invoke(r4, r9, r1)
            r8.e = r5
            r8.f802a = r9
            r8.b = r2
            r8.c = r6
            r8.d = r3
            java.lang.Object r1 = r5.yield(r9, r8)
            if (r1 != r0) goto L7a
        L79:
            return r0
        L7a:
            r4 = r6
            goto L4e
        L7c:
            z3.Q r9 = p147z3.Q.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.J.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package S2;

import p007a4.M;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f657a;
    public final /* synthetic */ A b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ O3.l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f658f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(A a6, long j6, long j7, O3.l lVar, String str, E3.g gVar) {
        super(2, gVar);
        this.b = a6;
        this.c = j6;
        this.d = j7;
        this.e = lVar;
        this.f658f = str;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        return new u(this.b, this.c, this.d, this.e, this.f658f, gVar);
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((u) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0079  */
    /* JADX WARN: Code duplicated, block: B:25:0x007a A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:13:0x002b, B:25:0x007a, B:14:0x002f, B:22:0x0062, B:17:0x0036, B:19:0x0040, B:28:0x008b), top: B:33:0x0013 }] */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        if (S2.A.c(r9, r1, r2, r10, r19) == r7) goto L27;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            r19 = this;
            r6 = r19
            long r0 = r6.c
            java.lang.String r2 = "Can't start request with id "
            java.lang.Object r7 = F3.i.getCOROUTINE_SUSPENDED()
            int r3 = r6.f657a
            r4 = 3
            r5 = 2
            O3.l r8 = r6.e
            S2.A r9 = r6.b
            r10 = 1
            if (r3 == 0) goto L33
            if (r3 == r10) goto L2f
            if (r3 == r5) goto L2b
            if (r3 != r4) goto L23
            p147z3.v.throwOnFailure(r20)     // Catch: java.lang.Exception -> L20
            goto Lc0
        L20:
            r0 = move-exception
            goto Lb1
        L23:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2b:
            p147z3.v.throwOnFailure(r20)     // Catch: java.lang.Exception -> L20
            goto L7a
        L2f:
            p147z3.v.throwOnFailure(r20)     // Catch: java.lang.Exception -> L20
            goto L62
        L33:
            p147z3.v.throwOnFailure(r20)
            U2.e r3 = S2.A.a(r9)     // Catch: java.lang.Exception -> L20
            boolean r3 = r3.a(r0)     // Catch: java.lang.Exception -> L20
            if (r3 != 0) goto L8b
            U2.e r2 = S2.A.a(r9)     // Catch: java.lang.Exception -> L20
            U2.f r11 = new U2.f     // Catch: java.lang.Exception -> L20
            long r12 = r6.d     // Catch: java.lang.Exception -> L20
            i4.b r15 = p049i4.i.Mutex(r10)     // Catch: java.lang.Exception -> L20
            r3 = 0
            i4.b r16 = p049i4.i.Mutex(r3)     // Catch: java.lang.Exception -> L20
            r18 = 0
            r17 = 0
            r14 = 0
            r11.<init>(r12, r14, r15, r16, r17, r18)     // Catch: java.lang.Exception -> L20
            r6.f657a = r10     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = r2.registerRequest(r0, r11, r6)     // Catch: java.lang.Exception -> L20
            if (r0 != r7) goto L62
            goto L8a
        L62:
            z3.Q r0 = p147z3.Q.INSTANCE     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = p147z3.u.m1361constructorimpl(r0)     // Catch: java.lang.Exception -> L20
            z3.u r0 = p147z3.u.a(r0)     // Catch: java.lang.Exception -> L20
            r8.invoke(r0)     // Catch: java.lang.Exception -> L20
            long r0 = r6.d     // Catch: java.lang.Exception -> L20
            r6.f657a = r5     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = S2.A.d(r9, r0, r6)     // Catch: java.lang.Exception -> L20
            if (r0 != r7) goto L7a
            goto L8a
        L7a:
            java.lang.String r1 = r6.f658f     // Catch: java.lang.Exception -> L20
            long r2 = r6.c     // Catch: java.lang.Exception -> L20
            long r10 = r6.d     // Catch: java.lang.Exception -> L20
            r6.f657a = r4     // Catch: java.lang.Exception -> L20
            r0 = r9
            r4 = r10
            java.lang.Object r0 = S2.A.c(r0, r1, r2, r4, r6)     // Catch: java.lang.Exception -> L20
            if (r0 != r7) goto Lc0
        L8a:
            return r7
        L8b:
            java.lang.Exception r3 = new java.lang.Exception     // Catch: java.lang.Exception -> L20
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L20
            r4.<init>(r2)     // Catch: java.lang.Exception -> L20
            r4.append(r0)     // Catch: java.lang.Exception -> L20
            java.lang.String r0 = " because it already exists"
            r4.append(r0)     // Catch: java.lang.Exception -> L20
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Exception -> L20
            r3.<init>(r0)     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = p147z3.v.createFailure(r3)     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = p147z3.u.m1361constructorimpl(r0)     // Catch: java.lang.Exception -> L20
            z3.u r0 = p147z3.u.a(r0)     // Catch: java.lang.Exception -> L20
            r8.invoke(r0)     // Catch: java.lang.Exception -> L20
            goto Lc0
        Lb1:
            java.lang.Object r0 = p147z3.v.createFailure(r0)
            java.lang.Object r0 = p147z3.u.m1361constructorimpl(r0)
            z3.u r0 = p147z3.u.a(r0)
            r8.invoke(r0)
        Lc0:
            z3.Q r0 = p147z3.Q.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.u.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package S2;

import p007a4.M;
import p018c4.x0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f642a = 1;
    public int b;
    public final /* synthetic */ long c;
    public /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(long j6, E3.g gVar) {
        super(2, gVar);
        this.c = j6;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f642a) {
            case 0:
                return new m((A) this.d, this.c, gVar);
            default:
                m mVar = new m(this.c, gVar);
                mVar.d = obj;
                return mVar;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f642a) {
            case 0:
                return ((m) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((m) create((x0) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0044 A[PHI: r1
  0x0044: PHI (r1v5 c4.x0) = (r1v4 c4.x0), (r1v6 c4.x0), (r1v8 c4.x0) binds: [B:15:0x0041, B:21:0x005d, B:13:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x0055 A[PHI: r1
  0x0055: PHI (r1v6 c4.x0) = (r1v5 c4.x0), (r1v10 c4.x0) binds: [B:18:0x0052, B:12:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005d -> B:17:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.f642a
            switch(r0) {
                case 0: goto L60;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r7.b
            long r2 = r7.c
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L31
            if (r1 == r6) goto L29
            if (r1 == r5) goto L21
            if (r1 != r4) goto L19
            goto L29
        L19:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L21:
            java.lang.Object r1 = r7.d
            c4.x0 r1 = (p018c4.x0) r1
            p147z3.v.throwOnFailure(r8)
            goto L55
        L29:
            java.lang.Object r1 = r7.d
            c4.x0 r1 = (p018c4.x0) r1
            p147z3.v.throwOnFailure(r8)
            goto L44
        L31:
            p147z3.v.throwOnFailure(r8)
            java.lang.Object r8 = r7.d
            r1 = r8
            c4.x0 r1 = (p018c4.x0) r1
            r7.d = r1
            r7.b = r6
            java.lang.Object r8 = p007a4.AbstractC0261a0.delay(r2, r7)
            if (r8 != r0) goto L44
            goto L5f
        L44:
            c4.D0 r8 = r1.getChannel()
            z3.Q r6 = p147z3.Q.INSTANCE
            r7.d = r1
            r7.b = r5
            java.lang.Object r8 = r8.send(r6, r7)
            if (r8 != r0) goto L55
            goto L5f
        L55:
            r7.d = r1
            r7.b = r4
            java.lang.Object r8 = p007a4.AbstractC0261a0.delay(r2, r7)
            if (r8 != r0) goto L44
        L5f:
            return r0
        L60:
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r7.b
            r2 = 1
            if (r1 == 0) goto L77
            if (r1 != r2) goto L6f
            p147z3.v.throwOnFailure(r8)
            goto L8d
        L6f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L77:
            p147z3.v.throwOnFailure(r8)
            java.lang.Object r8 = r7.d
            S2.A r8 = (S2.A) r8
            U2.e r8 = S2.A.a(r8)
            r7.b = r2
            long r1 = r7.c
            java.lang.Object r8 = r8.deleteRequest(r1, r7)
            if (r8 != r0) goto L8d
            goto La7
        L8d:
            U2.f r8 = (U2.f) r8
            if (r8 == 0) goto L9a
            i4.b r0 = r8.getNextChunkLock()
            if (r0 == 0) goto L9a
            T2.a.tryUnlock(r0)
        L9a:
            if (r8 == 0) goto La5
            i4.b r8 = r8.getChunkResultLock()
            if (r8 == 0) goto La5
            T2.a.tryUnlock(r8)
        La5:
            z3.Q r0 = p147z3.Q.INSTANCE
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(A a6, long j6, E3.g gVar) {
        super(2, gVar);
        this.d = a6;
        this.c = j6;
    }
}

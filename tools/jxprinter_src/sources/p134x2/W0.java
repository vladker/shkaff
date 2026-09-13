package p134x2;

import E3.g;
import G3.m;
import O3.p;
import p007a4.M;
import p018c4.InterfaceC0395z;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0395z f8886a;
    public S0.a b;
    public int c;
    public final /* synthetic */ S0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W0(S0 s6, g gVar) {
        super(2, gVar);
        this.d = s6;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new W0(this.d, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super Q> gVar) {
        return ((W0) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0054 A[PHI: r1 r12
  0x0054: PHI (r1v2 c4.z) = (r1v6 c4.z), (r1v12 c4.z) binds: [B:14:0x0051, B:11:0x0033] A[DONT_GENERATE, DONT_INLINE]
  0x0054: PHI (r12v5 java.lang.Object) = (r12v15 java.lang.Object), (r12v0 java.lang.Object) binds: [B:14:0x0051, B:11:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:20:0x006a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0092 A[PHI: r1 r7
  0x0092: PHI (r1v1 x2.S0$a) = (r1v4 x2.S0$a), (r1v4 x2.S0$a), (r1v13 x2.S0$a) binds: [B:19:0x0068, B:21:0x008f, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE]
  0x0092: PHI (r7v0 c4.z) = (r7v8 c4.z), (r7v9 c4.z), (r7v10 c4.z) binds: [B:19:0x0068, B:21:0x008f, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x00e6  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
    
        if (r12 == r0) goto L25;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x006a, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a8 -> B:26:0x00ab). Please report as a decompilation issue!!! */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.W0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

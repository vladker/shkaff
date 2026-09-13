package p134x2;

import E3.g;
import G3.m;
import O3.p;
import kotlin.jvm.internal.Q;
import p007a4.M;
import p049i4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Q f8847a;
    public b b;
    public int c;
    public final /* synthetic */ Q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Q q6, g gVar) {
        super(2, gVar);
        this.d = q6;
    }

    @Override // G3.a
    public final g<p147z3.Q> create(Object obj, g<?> gVar) {
        return new C(this.d, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super p147z3.Q> gVar) {
        return ((C) create(m6, gVar)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    /* JADX WARN: Code duplicated, block: B:23:0x005e A[PHI: r1
  0x005e: PHI (r1v4 kotlin.jvm.internal.Q) = (r1v6 kotlin.jvm.internal.Q), (r1v10 kotlin.jvm.internal.Q) binds: [B:21:0x005a, B:15:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:29:0x0079 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0016, B:27:0x0073, B:29:0x0079, B:31:0x0086, B:34:0x0091, B:36:0x0097, B:37:0x009d), top: B:48:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0086 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0016, B:27:0x0073, B:29:0x0079, B:31:0x0086, B:34:0x0091, B:36:0x0097, B:37:0x009d), top: B:48:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0097 A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0016, B:27:0x0073, B:29:0x0079, B:31:0x0086, B:34:0x0091, B:36:0x0097, B:37:0x009d), top: B:48:0x0016 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009d A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0016, B:27:0x0073, B:29:0x0079, B:31:0x0086, B:34:0x0091, B:36:0x0097, B:37:0x009d), top: B:48:0x0016 }] */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        if (r13.k(r7, false, true, r12) == r0) goto L39;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x009d, please report this as an issue */
    /* JADX WARN: Path cross not found for [B:29:0x0079, B:34:0x0091], limit reached: 45 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d7 -> B:40:0x00da). Please report as a decompilation issue!!! */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p134x2.C.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

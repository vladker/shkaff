package p023d4;

import E3.g;
import G3.m;
import O3.l;
import O3.q;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.T;
import p007a4.M;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f3843a;
    public S b;
    public int c;
    public /* synthetic */ Object d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l f3844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o f3845g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(l lVar, InterfaceC0612o interfaceC0612o, g gVar) {
        super(3, gVar);
        this.f3844f = lVar;
        this.f3845g = interfaceC0612o;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Z z6 = new Z(this.f3844f, this.f3845g, (g) obj3);
        z6.d = (M) obj;
        z6.e = (InterfaceC0615p) obj2;
        return z6.invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0064  */
    /* JADX WARN: Code duplicated, block: B:18:0x0068  */
    /* JADX WARN: Code duplicated, block: B:21:0x007d  */
    /* JADX WARN: Code duplicated, block: B:22:0x007f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0083  */
    /* JADX WARN: Code duplicated, block: B:29:0x0097 A[PHI: r1 r5 r6 r7
  0x0097: PHI (r1v3 kotlin.jvm.internal.S) = (r1v5 kotlin.jvm.internal.S), (r1v7 kotlin.jvm.internal.S), (r1v7 kotlin.jvm.internal.S) binds: [B:28:0x0095, B:15:0x0062, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]
  0x0097: PHI (r5v2 kotlin.jvm.internal.T) = (r5v4 kotlin.jvm.internal.T), (r5v5 kotlin.jvm.internal.T), (r5v5 kotlin.jvm.internal.T) binds: [B:28:0x0095, B:15:0x0062, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]
  0x0097: PHI (r6v3 c4.B0) = (r6v5 c4.B0), (r6v6 c4.B0), (r6v6 c4.B0) binds: [B:28:0x0095, B:15:0x0062, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]
  0x0097: PHI (r7v2 d4.p) = (r7v4 d4.p), (r7v5 d4.p), (r7v5 d4.p) binds: [B:28:0x0095, B:15:0x0062, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x009c  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        if (r7.emit(r14, r13) == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d6, code lost:
    
        if (r7.doSelect(r13) == r0) goto L37;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d6 -> B:7:0x001c). Please report as a decompilation issue!!! */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.Z.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

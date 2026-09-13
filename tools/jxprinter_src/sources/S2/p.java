package S2;

import kotlin.jvm.internal.T;
import p007a4.M;
import p018c4.B;
import p018c4.B0;
import p018c4.x0;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p023d4.U1;
import p023d4.e2;
import p023d4.h2;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f645a;
    public int b;
    public Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f646f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(h2 h2Var, InterfaceC0612o interfaceC0612o, U1 u6, Object obj, E3.g gVar) {
        super(2, gVar);
        this.f645a = 4;
        this.c = h2Var;
        this.d = interfaceC0612o;
        this.e = u6;
        this.f646f = obj;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f645a) {
            case 0:
                return new p((A) this.d, (String) this.e, (O3.l) this.f646f, gVar, 0);
            case 1:
                p pVar = new p((B0) this.e, (O3.p) this.f646f, gVar, 1);
                pVar.d = obj;
                return pVar;
            case 2:
                p pVar2 = new p((T) this.e, (InterfaceC0615p) this.f646f, gVar, 2);
                pVar2.d = obj;
                return pVar2;
            case 3:
                p pVar3 = new p((InterfaceC0612o) this.d, (U1) this.e, this.f646f, gVar, 3);
                pVar3.c = obj;
                return pVar3;
            default:
                return new p((h2) this.c, (InterfaceC0612o) this.d, (U1) this.e, this.f646f, gVar);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f645a) {
            case 0:
                return ((p) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 1:
                return ((p) create((x0) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 2:
                return ((p) create(B.b(((B) obj).c()), (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 3:
                return ((p) create((e2) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((p) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x01a5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [O3.p, S2.o] */
    /* JADX WARN: Type inference failed for: r0v2, types: [O3.l] */
    /* JADX WARN: Type inference failed for: r0v4, types: [O3.l] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Serializable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01c8 -> B:93:0x018e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.p.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, Object obj2, E3.g gVar, int i5) {
        super(2, gVar);
        this.f645a = i5;
        this.e = obj;
        this.f646f = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj, Object obj2, Object obj3, E3.g gVar, int i5) {
        super(2, gVar);
        this.f645a = i5;
        this.d = obj;
        this.e = obj2;
        this.f646f = obj3;
    }
}

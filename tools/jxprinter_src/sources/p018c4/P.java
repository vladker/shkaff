package p018c4;

import E3.g;
import G3.m;
import O3.p;
import O3.q;
import p007a4.InterfaceC0310x;
import p007a4.M;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1111a = 0;
    public int b;
    public final /* synthetic */ Object c;
    public Object d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1114h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(B0 b1, p pVar, g gVar) {
        super(2, gVar);
        this.c = b1;
        this.f1114h = pVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1111a) {
            case 0:
                P p6 = new P((B0) this.c, (p) this.f1114h, gVar);
                p6.f1113g = obj;
                return p6;
            case 1:
                return new P((B0) this.c, (InterfaceC0615p) this.f1112f, (q) this.f1113g, this.d, (InterfaceC0310x) this.f1114h, gVar);
            default:
                P p7 = new P((InterfaceC0612o) this.f1112f, (InterfaceC0612o) this.f1113g, (InterfaceC0615p) this.c, (q) this.f1114h, gVar);
                p7.d = obj;
                return p7;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1111a) {
            case 0:
                return ((P) create((x0) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            case 1:
                return ((P) create((Q) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((P) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:84:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:90:0x01f8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [c4.B0] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x01e5 -> B:75:0x01a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01f8 -> B:91:0x01fa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.P.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(B0 b1, InterfaceC0615p interfaceC0615p, q qVar, Object obj, InterfaceC0310x interfaceC0310x, g gVar) {
        super(2, gVar);
        this.c = b1;
        this.f1112f = interfaceC0615p;
        this.f1113g = qVar;
        this.d = obj;
        this.f1114h = interfaceC0310x;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, InterfaceC0615p interfaceC0615p, q qVar, g gVar) {
        super(2, gVar);
        this.f1112f = interfaceC0612o;
        this.f1113g = interfaceC0612o2;
        this.c = interfaceC0615p;
        this.f1114h = qVar;
    }
}

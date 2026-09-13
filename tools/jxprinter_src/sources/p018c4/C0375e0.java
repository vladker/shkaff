package p018c4;

import E3.g;
import E3.q;
import G3.m;
import O3.p;
import p007a4.InterfaceC0310x;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: renamed from: c4.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0375e0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1144a = 0;
    public int b;
    public /* synthetic */ Object c;
    public B0 d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f1147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f1148i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0375e0(B0 b1, p pVar, g gVar) {
        super(2, gVar);
        this.f1146g = b1;
        this.f1145f = pVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1144a) {
            case 0:
                C0375e0 c0375e0 = new C0375e0((B0) this.f1146g, (p) this.f1145f, gVar);
                c0375e0.c = obj;
                return c0375e0;
            default:
                return new C0375e0((InterfaceC0612o) this.e, (q) this.f1145f, this.c, this.d, (InterfaceC0615p) this.f1146g, (O3.q) this.f1147h, (InterfaceC0310x) this.f1148i, gVar);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1144a) {
            case 0:
                return ((C0375e0) create((x0) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((C0375e0) create((Q) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #1 {all -> 0x0074, blocks: (B:21:0x006c, B:37:0x00c2, B:41:0x00db, B:43:0x00e3, B:33:0x00aa, B:36:0x00be), top: B:59:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:50:0x0114  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0114 -> B:37:0x00c2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.C0375e0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0375e0(InterfaceC0612o interfaceC0612o, q qVar, Object obj, B0 b1, InterfaceC0615p interfaceC0615p, O3.q qVar2, InterfaceC0310x interfaceC0310x, g gVar) {
        super(2, gVar);
        this.e = interfaceC0612o;
        this.f1145f = qVar;
        this.c = obj;
        this.d = b1;
        this.f1146g = interfaceC0615p;
        this.f1147h = qVar2;
        this.f1148i = interfaceC0310x;
    }
}

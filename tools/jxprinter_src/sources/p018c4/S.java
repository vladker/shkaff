package p018c4;

import E3.g;
import G3.m;
import O3.p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1118a;
    public InterfaceC0395z b;
    public Object c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ B0 f1119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p f1120g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ S(B0 b1, p pVar, g gVar, int i5) {
        super(2, gVar);
        this.f1118a = i5;
        this.f1119f = b1;
        this.f1120g = pVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1118a) {
            case 0:
                S s6 = new S(this.f1119f, this.f1120g, gVar, 0);
                s6.e = obj;
                return s6;
            case 1:
                S s7 = new S(this.f1119f, this.f1120g, gVar, 1);
                s7.e = obj;
                return s7;
            default:
                S s8 = new S(this.f1119f, this.f1120g, gVar, 2);
                s8.e = obj;
                return s8;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        x0 x0Var = (x0) obj;
        g gVar = (g) obj2;
        switch (this.f1118a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((S) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0213  */
    /* JADX WARN: Code duplicated, block: B:104:0x0226  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:85:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:98:0x020a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x0223 -> B:69:0x015e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009a -> B:15:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x01d5 -> B:86:0x01da). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.S.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

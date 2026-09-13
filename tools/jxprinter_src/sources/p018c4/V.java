package p018c4;

import E3.g;
import G3.m;
import O3.p;
import O3.q;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1125a;
    public InterfaceC0395z b;
    public int c;
    public int d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ B0 f1126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f1127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f1128h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ V(B0 b1, q qVar, g gVar, int i5) {
        super(2, gVar);
        this.f1125a = i5;
        this.f1126f = b1;
        this.f1127g = qVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1125a) {
            case 0:
                V v6 = new V(this.f1126f, this.f1127g, gVar, 0);
                v6.f1128h = obj;
                return v6;
            default:
                V v7 = new V(this.f1126f, this.f1127g, gVar, 1);
                v7.e = obj;
                return v7;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        x0 x0Var = (x0) obj;
        g gVar = (g) obj2;
        switch (this.f1125a) {
            case 0:
                break;
        }
        return ((V) create(x0Var, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x012a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0149  */
    /* JADX WARN: Code duplicated, block: B:54:0x0157  */
    /* JADX WARN: Code duplicated, block: B:57:0x0168  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ac -> B:15:0x0058). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.V.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

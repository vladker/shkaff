package p018c4;

import E3.g;
import G3.m;
import O3.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Q extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1115a;
    public InterfaceC0395z b;
    public int c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ B0 f1117g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Q(int i5, B0 b1, g gVar, int i6) {
        super(2, gVar);
        this.f1115a = i6;
        this.f1116f = i5;
        this.f1117g = b1;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1115a) {
            case 0:
                Q q6 = new Q(this.f1116f, this.f1117g, gVar, 0);
                q6.e = obj;
                return q6;
            default:
                Q q7 = new Q(this.f1116f, this.f1117g, gVar, 1);
                q7.e = obj;
                return q7;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        x0 x0Var = (x0) obj;
        g gVar = (g) obj2;
        switch (this.f1115a) {
            case 0:
                break;
        }
        return ((Q) create(x0Var, gVar)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:61:0x011b  */
    /* JADX WARN: Code duplicated, block: B:64:0x0126  */
    /* JADX WARN: Code duplicated, block: B:67:0x0139  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0078 -> B:9:0x001e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00f3 -> B:52:0x00f6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0136 -> B:40:0x00b3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.Q.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package M3;

import A3.C0144l;
import W3.AbstractC0234s;
import java.nio.file.Path;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f478a;
    public C0144l b;
    public d c;
    public l d;
    public o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f482i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(o oVar, E3.g gVar, int i5) {
        super(2, gVar);
        this.f478a = i5;
        this.f482i = oVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f478a) {
            case 0:
                n nVar = new n(this.f482i, gVar, 0);
                nVar.f481h = obj;
                return nVar;
            default:
                n nVar2 = new n(this.f482i, gVar, 1);
                nVar2.f481h = obj;
                return nVar2;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        AbstractC0234s abstractC0234s = (AbstractC0234s) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f478a) {
            case 0:
                break;
        }
        return ((n) create(abstractC0234s, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:103:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:104:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:107:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:128:0x029c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x030b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0271  */
    /* JADX WARN: Code duplicated, block: B:88:0x0281  */
    /* JADX WARN: Code duplicated, block: B:93:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:95:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:98:0x02be  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M3.n.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

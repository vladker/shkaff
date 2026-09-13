package W3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f806a;
    public Iterator b;
    public Object c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0233q f807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ O3.p f808g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ K(InterfaceC0233q interfaceC0233q, O3.p pVar, E3.g gVar, int i5) {
        super(2, gVar);
        this.f806a = i5;
        this.f807f = interfaceC0233q;
        this.f808g = pVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f806a) {
            case 0:
                K k6 = new K(this.f807f, this.f808g, gVar, 0);
                k6.e = obj;
                return k6;
            default:
                K k7 = new K(this.f807f, this.f808g, gVar, 1);
                k7.e = obj;
                return k7;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        AbstractC0234s abstractC0234s = (AbstractC0234s) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f806a) {
            case 0:
                break;
        }
        return ((K) create(abstractC0234s, gVar)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005e -> B:8:0x001b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.K.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

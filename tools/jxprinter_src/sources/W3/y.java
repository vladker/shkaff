package W3;

import p007a4.X0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f825a = 1;
    public int b;
    public /* synthetic */ Object c;
    public Object d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f826f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(E3.g gVar, X0 x6) {
        super(2, gVar);
        this.f826f = x6;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f825a) {
            case 0:
                y yVar = new y((InterfaceC0233q) this.e, (S3.f) this.f826f, gVar);
                yVar.c = obj;
                return yVar;
            default:
                y yVar2 = new y(gVar, (X0) this.f826f);
                yVar2.c = obj;
                return yVar2;
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        AbstractC0234s abstractC0234s = (AbstractC0234s) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f825a) {
            case 0:
                break;
        }
        return ((y) create(abstractC0234s, gVar)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0072 -> B:29:0x0088). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:29:0x0088). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(InterfaceC0233q interfaceC0233q, S3.f fVar, E3.g gVar) {
        super(2, gVar);
        this.e = interfaceC0233q;
        this.f826f = fVar;
    }
}

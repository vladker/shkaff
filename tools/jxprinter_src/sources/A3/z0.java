package A3;

import W3.AbstractC0234s;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z0 extends G3.l implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f55a;
    public Iterator b;
    public int c;
    public int d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f56f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f57g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Iterator f58h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f59i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f60j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(int i5, int i6, Iterator it, boolean z6, boolean z7, E3.g gVar) {
        super(2, gVar);
        this.f56f = i5;
        this.f57g = i6;
        this.f58h = it;
        this.f59i = z6;
        this.f60j = z7;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        z0 z0Var = new z0(this.f56f, this.f57g, this.f58h, this.f59i, this.f60j, gVar);
        z0Var.e = obj;
        return z0Var;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((z0) create((AbstractC0234s) obj, (E3.g) obj2)).invokeSuspend(p147z3.Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0081  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a5 A[EDGE_INSN: B:33:0x00a5->B:34:0x00a6 BREAK  A[LOOP:1: B:23:0x007b->B:91:0x007b]] */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0120  */
    /* JADX WARN: Code duplicated, block: B:68:0x0122  */
    /* JADX WARN: Code duplicated, block: B:73:0x013a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0140  */
    /* JADX WARN: Code duplicated, block: B:87:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x008a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x007b A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a5 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x010f -> B:61:0x0112). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0133 -> B:72:0x0136). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:88:0x008a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A3.z0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package p018c4;

import E3.g;
import G3.m;
import O3.p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0395z f1177a;
    public p b;
    public B0 c;
    public InterfaceC0395z d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ B0 f1180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ B0 f1181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ p f1182j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(B0 b1, B0 b6, p pVar, g gVar) {
        super(2, gVar);
        this.f1180h = b1;
        this.f1181i = b6;
        this.f1182j = pVar;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        o0 o0Var = new o0(this.f1180h, this.f1181i, this.f1182j, gVar);
        o0Var.f1179g = obj;
        return o0Var;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((o0) create((x0) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0088  */
    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:31:0x0096 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:8:0x001e, B:25:0x0071, B:29:0x008e, B:31:0x0096, B:20:0x0057, B:23:0x006a), top: B:49:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c1 A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #2 {all -> 0x0047, blocks: (B:35:0x00b9, B:37:0x00c1, B:15:0x003c), top: B:53:0x003c }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00e1 -> B:41:0x00e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e9 -> B:25:0x0071). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.o0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

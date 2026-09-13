package kotlinx.coroutines.flow.internal;

import p018c4.InterfaceC0391v;
import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0391v f5714a;
    public byte[] b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o[] f5716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ O3.a f5717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ O3.q f5718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0615p f5719j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(InterfaceC0615p interfaceC0615p, InterfaceC0612o[] interfaceC0612oArr, O3.a aVar, O3.q qVar, E3.g gVar) {
        super(2, gVar);
        this.f5716g = interfaceC0612oArr;
        this.f5717h = aVar;
        this.f5718i = qVar;
        this.f5719j = interfaceC0615p;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        s sVar = new s(this.f5719j, this.f5716g, this.f5717h, this.f5718i, gVar);
        sVar.f5715f = obj;
        return sVar;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((s) create((p007a4.M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ba A[LOOP:0: B:28:0x00ba->B:50:?, LOOP_START, PHI: r6 r8
  0x00ba: PHI (r6v3 int) = (r6v2 int), (r6v4 int) binds: [B:25:0x00b5, B:50:?] A[DONT_GENERATE, DONT_INLINE]
  0x00ba: PHI (r8v4 A3.b0) = (r8v3 A3.b0), (r8v15 A3.b0) binds: [B:25:0x00b5, B:50:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:38:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:44:0x011e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0122  */
    /* JADX WARN: Code duplicated, block: B:48:0x00db A[EDGE_INSN: B:48:0x00db->B:35:0x00db BREAK  A[LOOP:0: B:28:0x00ba->B:50:?], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x011e -> B:45:0x011f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.s.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

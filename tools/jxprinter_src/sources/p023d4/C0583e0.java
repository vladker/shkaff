package p023d4;

import E3.g;
import G3.m;
import O3.q;
import p007a4.M;
import p147z3.Q;

/* JADX INFO: renamed from: d4.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0583e0 extends m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3864a;
    public int b;
    public /* synthetic */ Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o f3865f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0583e0(long j6, InterfaceC0612o interfaceC0612o, g gVar) {
        super(3, gVar);
        this.e = j6;
        this.f3865f = interfaceC0612o;
    }

    @Override // O3.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C0583e0 c0583e0 = new C0583e0(this.e, this.f3865f, (g) obj3);
        c0583e0.c = (M) obj;
        c0583e0.d = (InterfaceC0615p) obj2;
        return c0583e0.invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:16:0x0081  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0076 -> B:14:0x0079). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r10.b
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            long r3 = r10.f3864a
            java.lang.Object r1 = r10.d
            c4.B0 r1 = (p018c4.B0) r1
            java.lang.Object r5 = r10.c
            d4.p r5 = (p023d4.InterfaceC0615p) r5
            p147z3.v.throwOnFailure(r11)
            goto L79
        L19:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L21:
            p147z3.v.throwOnFailure(r11)
            java.lang.Object r11 = r10.c
            a4.M r11 = (p007a4.M) r11
            java.lang.Object r1 = r10.d
            d4.p r1 = (p023d4.InterfaceC0615p) r1
            Y3.a r3 = Y3.b.Companion
            r3.getClass()
            r3 = 0
            long r5 = r10.e
            int r3 = Y3.b.c(r5, r3)
            if (r3 <= 0) goto L84
            r3 = 0
            c4.b r4 = p018c4.EnumC0368b.f1135a
            d4.o r7 = r10.f3865f
            d4.o r3 = p023d4.AbstractC0618q.buffer(r7, r3, r4)
            c4.B0 r11 = p023d4.AbstractC0618q.produceIn(r3, r11)
            r3 = r5
            r5 = r1
            r1 = r11
        L4b:
            h4.m r11 = new h4.m
            E3.q r6 = r10.getContext()
            r11.<init>(r6)
            h4.h r6 = r1.getOnReceiveCatching()
            d4.c0 r7 = new d4.c0
            r8 = 0
            r9 = 0
            r7.<init>(r5, r9, r8)
            r11.invoke(r6, r7)
            d4.d0 r6 = new d4.d0
            r6.<init>(r3, r9)
            p044h4.c.m1037onTimeout8Mi8wO0(r11, r3, r6)
            r10.c = r5
            r10.d = r1
            r10.f3864a = r3
            r10.b = r2
            java.lang.Object r11 = r11.doSelect(r10)
            if (r11 != r0) goto L79
            return r0
        L79:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L4b
            z3.Q r11 = p147z3.Q.INSTANCE
            return r11
        L84:
            a4.u1 r11 = new a4.u1
            java.lang.String r0 = "Timed out immediately"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p023d4.C0583e0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

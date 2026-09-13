package p018c4;

import E3.g;
import G3.m;
import O3.p;
import java.util.concurrent.atomic.AtomicInteger;
import p007a4.M;
import p023d4.InterfaceC0612o;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1174a = 0;
    public int b;
    public int c;
    public Object d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ B0 f1175f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(B0 b1, g gVar) {
        super(2, gVar);
        this.f1175f = b1;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        switch (this.f1174a) {
            case 0:
                n0 n0Var = new n0(this.f1175f, gVar);
                n0Var.e = obj;
                return n0Var;
            default:
                return new n0((InterfaceC0612o[]) this.d, this.c, (AtomicInteger) this.e, (InterfaceC0391v) this.f1175f, gVar);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1174a) {
            case 0:
                return ((n0) create((x0) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((n0) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d5 -> B:31:0x0074). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // G3.a
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p018c4.n0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(InterfaceC0612o[] interfaceC0612oArr, int i5, AtomicInteger atomicInteger, InterfaceC0391v interfaceC0391v, g gVar) {
        super(2, gVar);
        this.d = interfaceC0612oArr;
        this.c = i5;
        this.e = atomicInteger;
        this.f1175f = interfaceC0391v;
    }
}

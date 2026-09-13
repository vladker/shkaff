package p146z2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Exception f9118a;
    public /* synthetic */ Object b;
    public final /* synthetic */ j c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar, g gVar) {
        super(gVar);
        this.c = jVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        Object objM1124connectInnerIoAF18A = this.c.m1124connectInnerIoAF18A(this);
        return objM1124connectInnerIoAF18A == i.getCOROUTINE_SUSPENDED() ? objM1124connectInnerIoAF18A : u.a(objM1124connectInnerIoAF18A);
    }
}

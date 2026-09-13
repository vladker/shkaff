package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public X f8879a;
    public /* synthetic */ Object b;
    public final /* synthetic */ X c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(X x6, g gVar) {
        super(gVar);
        this.c = x6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        Object objM1121connectIoAF18A = this.c.m1121connectIoAF18A(this);
        return objM1121connectIoAF18A == i.getCOROUTINE_SUSPENDED() ? objM1121connectIoAF18A : u.a(objM1121connectIoAF18A);
    }
}

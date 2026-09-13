package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8876a;
    public final /* synthetic */ X b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(X x6, g gVar) {
        super(gVar);
        this.b = x6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f8876a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objM1120closeIoAF18A = this.b.m1120closeIoAF18A(this);
        return objM1120closeIoAF18A == i.getCOROUTINE_SUSPENDED() ? objM1120closeIoAF18A : u.a(objM1120closeIoAF18A);
    }
}

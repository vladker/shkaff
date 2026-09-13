package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S0 f8882a;
    public /* synthetic */ Object b;
    public final /* synthetic */ S0 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U0(S0 s6, g gVar) {
        super(gVar);
        this.c = s6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        Object objM1117connectIoAF18A = this.c.m1117connectIoAF18A(this);
        return objM1117connectIoAF18A == i.getCOROUTINE_SUSPENDED() ? objM1117connectIoAF18A : u.a(objM1117connectIoAF18A);
    }
}

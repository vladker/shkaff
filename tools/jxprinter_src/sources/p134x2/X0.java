package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p007a4.InterfaceC0304u;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0304u f8887a;
    public /* synthetic */ Object b;
    public final /* synthetic */ S0 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X0(S0 s6, g gVar) {
        super(gVar);
        this.c = s6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        Object objM1118send0E7RQCE = this.c.m1118send0E7RQCE(null, null, this);
        return objM1118send0E7RQCE == i.getCOROUTINE_SUSPENDED() ? objM1118send0E7RQCE : u.a(objM1118send0E7RQCE);
    }
}

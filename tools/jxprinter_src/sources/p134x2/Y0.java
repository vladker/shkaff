package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8888a;
    public S0.a b;
    public /* synthetic */ Object c;
    public final /* synthetic */ S0 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y0(S0 s6, g gVar) {
        super(gVar);
        this.d = s6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        Object objM1119sendWithRespBWLJW6A = this.d.m1119sendWithRespBWLJW6A(null, 0, null, this);
        return objM1119sendWithRespBWLJW6A == i.getCOROUTINE_SUSPENDED() ? objM1119sendWithRespBWLJW6A : u.a(objM1119sendWithRespBWLJW6A);
    }
}

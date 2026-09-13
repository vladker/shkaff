package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: renamed from: x2.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1850c0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public K0 f8894a;
    public S0 b;
    public /* synthetic */ Object c;
    public final /* synthetic */ K0 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1850c0(K0 k6, g gVar) {
        super(gVar);
        this.d = k6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        Object objM1098connect0E7RQCE = this.d.m1098connect0E7RQCE(null, null, this);
        return objM1098connect0E7RQCE == i.getCOROUTINE_SUSPENDED() ? objM1098connect0E7RQCE : u.a(objM1098connect0E7RQCE);
    }
}

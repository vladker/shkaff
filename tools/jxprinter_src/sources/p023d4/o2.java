package p023d4;

import E3.g;
import G3.d;
import p007a4.H0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o2 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p2 f3897a;
    public InterfaceC0615p b;
    public r2 c;
    public H0 d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p2 f3899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3900h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o2(p2 p2Var, g gVar) {
        super(gVar);
        this.f3899g = p2Var;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f3898f = obj;
        this.f3900h |= Integer.MIN_VALUE;
        return this.f3899g.collect(null, this);
    }
}

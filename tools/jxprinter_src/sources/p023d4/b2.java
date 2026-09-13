package p023d4;

import E3.g;
import G3.d;
import p007a4.H0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b2 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a2 f3856a;
    public InterfaceC0615p b;
    public d2 c;
    public H0 d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a2 f3857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3858g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(a2 a2Var, g gVar) {
        super(gVar);
        this.f3857f = a2Var;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f3858g |= Integer.MIN_VALUE;
        return a2.f(this.f3857f, null, this);
    }
}

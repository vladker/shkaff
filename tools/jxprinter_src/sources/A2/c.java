package A2;

import F3.i;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f24a;
    public final /* synthetic */ g b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, E3.g gVar2) {
        super(gVar2);
        this.b = gVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f24a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objMo0closeIoAF18A = this.b.mo0closeIoAF18A(this);
        return objMo0closeIoAF18A == i.getCOROUTINE_SUSPENDED() ? objMo0closeIoAF18A : u.a(objMo0closeIoAF18A);
    }
}

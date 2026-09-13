package A2;

import F3.i;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f26a;
    public final /* synthetic */ g b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, E3.g gVar2) {
        super(gVar2);
        this.b = gVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f26a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objMo1connectIoAF18A = this.b.mo1connectIoAF18A(this);
        return objMo1connectIoAF18A == i.getCOROUTINE_SUSPENDED() ? objMo1connectIoAF18A : u.a(objMo1connectIoAF18A);
    }
}

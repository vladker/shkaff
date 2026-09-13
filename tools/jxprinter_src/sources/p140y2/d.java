package p140y2;

import E3.g;
import F3.i;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f9034a;
    public /* synthetic */ Object b;
    public final /* synthetic */ e c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, g gVar) {
        super(gVar);
        this.c = eVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        Object objMo1connectIoAF18A = this.c.mo1connectIoAF18A(this);
        return objMo1connectIoAF18A == i.getCOROUTINE_SUSPENDED() ? objMo1connectIoAF18A : u.a(objMo1connectIoAF18A);
    }
}

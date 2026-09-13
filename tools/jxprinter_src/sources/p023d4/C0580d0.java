package p023d4;

import E3.g;
import F3.i;
import G3.m;
import O3.l;
import Y3.b;
import p007a4.u1;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: renamed from: d4.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0580d0 extends m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3862a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0580d0(long j6, g gVar) {
        super(1, gVar);
        this.f3862a = j6;
    }

    @Override // G3.a
    public final g create(g gVar) {
        return new C0580d0(this.f3862a, gVar);
    }

    @Override // O3.l
    public final Object invoke(Object obj) throws Throwable {
        ((C0580d0) create((g) obj)).invokeSuspend(Q.INSTANCE);
        throw null;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        throw new u1("Timed out waiting for " + ((Object) b.m921toStringimpl(this.f3862a)));
    }
}

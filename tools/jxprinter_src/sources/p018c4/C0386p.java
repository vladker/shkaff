package p018c4;

import E3.g;
import F3.i;
import G3.d;

/* JADX INFO: renamed from: c4.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0386p extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1183a;
    public final /* synthetic */ C0376f b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0386p(C0376f c0376f, g gVar) {
        super(gVar);
        this.b = c0376f;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f1183a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objW = C0376f.w(this.b, this);
        return objW == i.getCOROUTINE_SUSPENDED() ? objW : B.b(objW);
    }
}

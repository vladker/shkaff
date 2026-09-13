package p018c4;

import F3.i;
import G3.d;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: renamed from: c4.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0387q extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f1184a;
    public final /* synthetic */ C0376f b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0387q(C0376f c0376f, d dVar) {
        super(dVar);
        this.b = c0376f;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f1184a = obj;
        this.c |= Integer.MIN_VALUE;
        AtomicLongFieldUpdater atomicLongFieldUpdater = C0376f.b;
        Object objX = this.b.x(null, 0, 0L, this);
        return objX == i.getCOROUTINE_SUSPENDED() ? objX : B.b(objX);
    }
}

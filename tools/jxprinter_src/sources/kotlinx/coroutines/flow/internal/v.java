package kotlinx.coroutines.flow.internal;

import p023d4.X;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5723a;
    public final /* synthetic */ X b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(X x6, E3.g gVar) {
        super(gVar);
        this.b = x6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f5723a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}

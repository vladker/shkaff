package kotlinx.coroutines.flow.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5713a;
    public final /* synthetic */ p023d4.H b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(p023d4.H h6, E3.g gVar) {
        super(gVar);
        this.b = h6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f5713a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.emit(null, this);
    }
}

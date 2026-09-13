package S2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public A f666a;
    public long b;
    public /* synthetic */ Object c;
    public final /* synthetic */ A d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(A a6, G3.d dVar) {
        super(dVar);
        this.d = a6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return A.d(this.d, 0L, this);
    }
}

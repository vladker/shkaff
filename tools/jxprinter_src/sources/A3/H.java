package A3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ O3.l f32a;
    public final /* synthetic */ Comparable b;

    public H(O3.l lVar, Comparable comparable) {
        this.f32a = lVar;
        this.b = comparable;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        return Integer.valueOf(D3.g.compareValues((Comparable) this.f32a.invoke(obj), this.b));
    }
}

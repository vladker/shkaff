package X3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f845a;

    public I(int i5) {
        this.f845a = i5;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        K k6 = (K) ((InterfaceC0244j) ((Enum) obj));
        return Boolean.valueOf((k6.b & this.f845a) == k6.f849a);
    }
}

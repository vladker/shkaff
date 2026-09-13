package A3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class S implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f34a;
    public final /* synthetic */ int b;

    public /* synthetic */ S(int i5, int i6) {
        this.f34a = i6;
        this.b = i5;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        int i5 = this.f34a;
        ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.b + '.');
            default:
                throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.b + '.');
        }
    }
}

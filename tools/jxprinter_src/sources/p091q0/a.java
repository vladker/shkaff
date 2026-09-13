package p091q0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements W0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7837a;
    public final int b;

    public a(int i5, int i6) {
        this.f7837a = i5;
        this.b = i6;
    }

    @Override // W0.a
    public final Object getItem(int i5) {
        if (i5 < 0 || i5 >= h()) {
            return 0;
        }
        return Integer.valueOf(this.f7837a + i5);
    }

    @Override // W0.a
    public final int h() {
        return (this.b - this.f7837a) + 1;
    }
}

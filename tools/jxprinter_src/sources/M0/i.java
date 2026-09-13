package M0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f467a;

    @Override // M0.j
    public final void a() {
        if (this.f467a) {
            throw new IllegalStateException("Already released");
        }
    }
}

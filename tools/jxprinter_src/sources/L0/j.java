package L0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f404a;
    public volatile Object b;

    public j(k kVar) {
        this.f404a = kVar;
    }

    @Override // L0.k
    public Object get() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = q.checkNotNull(((k) this.f404a).get());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }

    public j(int i5, int i6) {
        switch (i6) {
            case 2:
                this.f404a = new Object[i5];
                break;
            default:
                this.f404a = new Object[i5];
                break;
        }
    }
}

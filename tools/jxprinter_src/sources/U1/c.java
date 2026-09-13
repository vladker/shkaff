package U1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f708a;
    public final int b;

    public c(String str, int i5) {
        this.f708a = str;
        this.b = i5;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "(" + this.b + ") " + this.f708a;
    }
}

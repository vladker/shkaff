package S4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f698a;
    public final m b;
    public volatile boolean c = true;

    public p(Object obj, m mVar) {
        this.f698a = obj;
        this.b = mVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f698a == pVar.f698a && this.b.equals(pVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.f694f.hashCode() + this.f698a.hashCode();
    }
}

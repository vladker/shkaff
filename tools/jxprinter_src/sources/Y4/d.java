package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends e {
    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        for (int i5 = 0; i5 < this.b; i5++) {
            if (((p) this.f882a.get(i5)).a(mVar, mVar2)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return W4.b.f(this.f882a, ", ");
    }
}

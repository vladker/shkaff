package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class u extends w {
    public final a b;

    public u(p pVar) {
        this.f893a = pVar;
        this.b = new a(pVar);
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        for (int i5 = 0; i5 < mVar2.d.size(); i5++) {
            org.jsoup.nodes.s sVar = (org.jsoup.nodes.s) mVar2.n().get(i5);
            if ((sVar instanceof org.jsoup.nodes.m) && this.b.find(mVar2, (org.jsoup.nodes.m) sVar) != null) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return String.format(":has(%s)", this.f893a);
    }
}

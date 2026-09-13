package Y4;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f887a;
    public final /* synthetic */ int b;

    public k(int i5, int i6) {
        this.b = i6;
        this.f887a = i5;
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        switch (this.b) {
            case 0:
                return mVar2.H() == this.f887a;
            case 1:
                return mVar2.H() > this.f887a;
            default:
                return mVar != mVar2 && mVar2.H() < this.f887a;
        }
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return String.format(":eq(%d)", Integer.valueOf(this.f887a));
            case 1:
                return String.format(":gt(%d)", Integer.valueOf(this.f887a));
            default:
                return String.format(":lt(%d)", Integer.valueOf(this.f887a));
        }
    }
}

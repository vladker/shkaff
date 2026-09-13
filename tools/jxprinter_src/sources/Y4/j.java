package Y4;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f886a;
    public Pattern b;

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        String str = this.f886a;
        return mVar2.o(str) && this.b.matcher(mVar2.f(str)).find();
    }

    public final String toString() {
        return androidx.collection.a.p("[", this.f886a, "~=", this.b.toString(), "]");
    }
}

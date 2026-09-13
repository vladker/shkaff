package Y4;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f889a;
    public final Pattern b;

    public /* synthetic */ o(Pattern pattern, int i5) {
        this.f889a = i5;
        this.b = pattern;
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        switch (this.f889a) {
            case 0:
                return this.b.matcher(mVar2.S()).find();
            default:
                return this.b.matcher(mVar2.O()).find();
        }
    }

    public final String toString() {
        switch (this.f889a) {
            case 0:
                return ":matches(" + this.b + ")";
            default:
                return ":matchesOwn(" + this.b + ")";
        }
    }
}

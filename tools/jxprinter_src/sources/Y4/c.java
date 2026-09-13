package Y4;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends e {
    public c(List list) {
        this.f882a.addAll(list);
        this.b = this.f882a.size();
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        for (int i5 = this.b - 1; i5 >= 0; i5--) {
            if (!((p) this.f882a.get(i5)).a(mVar, mVar2)) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return W4.b.f(this.f882a, "");
    }

    public c(p... pVarArr) {
        this(Arrays.asList(pVarArr));
    }
}

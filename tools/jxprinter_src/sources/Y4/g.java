package Y4;

import androidx.webkit.ProxyConfig;
import java.util.ArrayList;
import java.util.Collections;
import org.jsoup.parser.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f883a;

    public /* synthetic */ g(int i5) {
        this.f883a = i5;
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        switch (this.f883a) {
            case 0:
                return true;
            case 1:
                for (org.jsoup.nodes.s sVar : mVar2.k()) {
                    if (!(sVar instanceof org.jsoup.nodes.e) && !(sVar instanceof org.jsoup.nodes.v) && !(sVar instanceof org.jsoup.nodes.j)) {
                        return false;
                    }
                }
                return true;
            case 2:
                org.jsoup.nodes.m mVarParent = mVar2.parent();
                return (mVarParent == null || (mVarParent instanceof org.jsoup.nodes.i) || mVar2.H() != 0) ? false : true;
            case 3:
                org.jsoup.nodes.m mVarParent2 = mVar2.parent();
                return (mVarParent2 == null || (mVarParent2 instanceof org.jsoup.nodes.i) || mVar2.H() != mVarParent2.D().size() - 1) ? false : true;
            case 4:
                org.jsoup.nodes.m mVarParent3 = mVar2.parent();
                return (mVarParent3 == null || (mVarParent3 instanceof org.jsoup.nodes.i) || !mVar2.R().isEmpty()) ? false : true;
            case 5:
                org.jsoup.nodes.m mVarParent4 = mVar2.parent();
                if (mVarParent4 == null || (mVarParent4 instanceof org.jsoup.nodes.i)) {
                    return false;
                }
                f fVarD = mVarParent4.D();
                int size = fVarD.size();
                int i5 = 0;
                int i6 = 0;
                while (i6 < size) {
                    Object obj = fVarD.get(i6);
                    i6++;
                    if (((org.jsoup.nodes.m) obj).c.equals(mVar2.c)) {
                        i5++;
                    }
                }
                return i5 == 1;
            case 6:
                if (mVar instanceof org.jsoup.nodes.i) {
                    mVar = (org.jsoup.nodes.m) mVar.C().get(0);
                }
                return mVar2 == mVar;
            case 7:
                if (mVar2 instanceof org.jsoup.nodes.t) {
                    return true;
                }
                ArrayList arrayList = new ArrayList();
                for (org.jsoup.nodes.s sVar2 : mVar2.d) {
                    if (sVar2 instanceof org.jsoup.nodes.u) {
                        arrayList.add((org.jsoup.nodes.u) sVar2);
                    }
                }
                for (org.jsoup.nodes.s sVar3 : Collections.unmodifiableList(arrayList)) {
                    org.jsoup.nodes.t tVar = new org.jsoup.nodes.t(F.a(mVar2.c.f7552a), mVar2.i(), mVar2.h());
                    sVar3.w(tVar);
                    tVar.z(sVar3);
                }
                return false;
            default:
                return mVar == mVar2;
        }
    }

    public String toString() {
        switch (this.f883a) {
            case 0:
                return ProxyConfig.MATCH_ALL_SCHEMES;
            case 1:
                return ":empty";
            case 2:
                return ":first-child";
            case 3:
                return ":last-child";
            case 4:
                return ":only-child";
            case 5:
                return ":only-of-type";
            case 6:
                return ":root";
            case 7:
                return ":matchText";
            default:
                return super.toString();
        }
    }
}

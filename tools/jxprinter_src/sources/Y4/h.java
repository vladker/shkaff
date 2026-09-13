package Y4;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f884a;
    public final String b;

    public /* synthetic */ h(String str, int i5, boolean z6) {
        this.f884a = i5;
        this.b = str;
    }

    @Override // Y4.p
    public final boolean a(org.jsoup.nodes.m mVar, org.jsoup.nodes.m mVar2) {
        switch (this.f884a) {
            case 0:
                return mVar2.o(this.b);
            case 1:
                org.jsoup.nodes.c cVarH = mVar2.h();
                cVarH.getClass();
                ArrayList arrayList = new ArrayList(cVarH.f7467a);
                for (int i5 = 0; i5 < cVarH.f7467a; i5++) {
                    if (!org.jsoup.nodes.c.l(cVarH.b[i5])) {
                        arrayList.add(new org.jsoup.nodes.a(cVarH.b[i5], cVarH.c[i5], cVarH));
                    }
                }
                Iterator it = Collections.unmodifiableList(arrayList).iterator();
                while (it.hasNext()) {
                    if (p051j0.i.i(((org.jsoup.nodes.a) it.next()).f7465a).startsWith(this.b)) {
                        return true;
                    }
                }
                return false;
            case 2:
                return mVar2.I(this.b);
            case 3:
                return p051j0.i.i(mVar2.F()).contains(this.b);
            case 4:
                return p051j0.i.i(mVar2.O()).contains(this.b);
            case 5:
                return p051j0.i.i(mVar2.S()).contains(this.b);
            case 6:
                return this.b.equals(mVar2.K());
            case 7:
                return mVar2.c.b.equals(this.b);
            default:
                return mVar2.c.b.endsWith(this.b);
        }
    }

    public final String toString() {
        switch (this.f884a) {
            case 0:
                return AbstractC0157z.o("[", this.b, "]");
            case 1:
                return AbstractC0157z.o("[^", this.b, "]");
            case 2:
                return AbstractC0157z.n(Consts.DOT, this.b);
            case 3:
                return AbstractC0157z.o(":containsData(", this.b, ")");
            case 4:
                return AbstractC0157z.o(":containsOwn(", this.b, ")");
            case 5:
                return AbstractC0157z.o(":contains(", this.b, ")");
            case 6:
                return AbstractC0157z.n("#", this.b);
            case 7:
                return this.b;
            default:
                return this.b;
        }
    }

    public h(String str, int i5) {
        this.f884a = i5;
        switch (i5) {
            case 3:
                this.b = p051j0.i.i(str);
                break;
            case 4:
                StringBuilder sbB = W4.b.b();
                W4.b.a(sbB, str, false);
                this.b = p051j0.i.i(W4.b.g(sbB));
                break;
            case 5:
                StringBuilder sbB2 = W4.b.b();
                W4.b.a(sbB2, str, false);
                this.b = p051j0.i.i(W4.b.g(sbB2));
                break;
            default:
                V4.h.notEmpty(str);
                this.b = p051j0.i.i(str);
                break;
        }
    }
}

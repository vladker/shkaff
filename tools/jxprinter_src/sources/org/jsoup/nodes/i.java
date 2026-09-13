package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import org.jsoup.parser.E;
import org.jsoup.parser.F;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends m {
    private U4.f connection;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f7471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public E f7472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7473i;

    public i(String str) {
        V4.h.notNull("#root");
        HashMap map = F.f7545j;
        F f6 = (F) map.get("#root");
        if (f6 == null) {
            String strI = p051j0.i.i("#root");
            V4.h.notEmpty(strI);
            f6 = (F) map.get(p051j0.i.i(strI));
            if (f6 == null) {
                f6 = new F(strI);
                f6.c = false;
            }
        }
        super(f6, str);
        this.f7471g = new h();
        this.f7473i = 1;
        this.f7472h = E.a();
    }

    public static i W(String str) {
        V4.h.notNull(str);
        i iVar = new i(str);
        iVar.f7472h = iVar.f7472h;
        m mVarA = iVar.A("html");
        mVarA.A("head");
        mVarA.A("body");
        return iVar;
    }

    @Override // org.jsoup.nodes.m
    /* JADX INFO: renamed from: E */
    public final m clone() {
        i iVar = (i) super.clone();
        iVar.f7471g = this.f7471g.clone();
        return iVar;
    }

    public final m T() {
        m mVarX = X();
        for (m mVar : mVarX.C()) {
            if ("body".equals(mVar.c.b) || "frameset".equals(mVar.c.b)) {
                return mVar;
            }
        }
        return mVarX.A("body");
    }

    public final void U(Charset charset) {
        m mVar;
        h hVar = this.f7471g;
        hVar.b = charset;
        g gVar = hVar.f7470f;
        int i5 = 0;
        if (gVar == g.f7468a) {
            m mVarSelectFirst = selectFirst("meta[charset]");
            if (mVarSelectFirst != null) {
                mVarSelectFirst.g("charset", this.f7471g.b.displayName());
            } else {
                m mVarX = X();
                Iterator it = mVarX.C().iterator();
                do {
                    if (!it.hasNext()) {
                        mVar = new m(F.e("head", AbstractC1282k.e(mVarX).c), mVarX.i());
                        V4.h.notNull(mVar);
                        mVarX.e(0, mVar);
                        break;
                    }
                    mVar = (m) it.next();
                } while (!mVar.c.b.equals("head"));
                mVar.A("meta").g("charset", this.f7471g.b.displayName());
            }
            Y4.f fVarQ = Q("meta[name=charset]");
            int size = fVarQ.size();
            while (i5 < size) {
                Object obj = fVarQ.get(i5);
                i5++;
                ((m) obj).u();
            }
            return;
        }
        if (gVar == g.b) {
            s sVar = (s) n().get(0);
            if (!(sVar instanceof v)) {
                v vVar = new v("xml", false);
                vVar.g("version", "1.0");
                vVar.g("encoding", this.f7471g.b.displayName());
                V4.h.notNull(vVar);
                e(0, vVar);
                return;
            }
            v vVar2 = (v) sVar;
            if (vVar2.z().equals("xml")) {
                vVar2.g("encoding", this.f7471g.b.displayName());
                if (vVar2.o("version")) {
                    vVar2.g("version", "1.0");
                    return;
                }
                return;
            }
            v vVar3 = new v("xml", false);
            vVar3.g("version", "1.0");
            vVar3.g("encoding", this.f7471g.b.displayName());
            V4.h.notNull(vVar3);
            e(0, vVar3);
        }
    }

    public final void V(V4.g gVar) {
        V4.h.notNull(gVar);
        this.connection = gVar;
    }

    public final m X() {
        for (m mVar : C()) {
            if (mVar.c.b.equals("html")) {
                return mVar;
            }
        }
        return A("html");
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.s
    /* JADX INFO: renamed from: clone */
    public Object l() {
        i iVar = (i) super.clone();
        iVar.f7471g = this.f7471g.clone();
        return iVar;
    }

    public j documentType() {
        for (s sVar : this.d) {
            if (sVar instanceof j) {
                return (j) sVar;
            }
            if (!(sVar instanceof r)) {
                return null;
            }
        }
        return null;
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.s
    public final s l() {
        i iVar = (i) super.clone();
        iVar.f7471g = this.f7471g.clone();
        return iVar;
    }

    @Override // org.jsoup.nodes.m, org.jsoup.nodes.s
    public final String r() {
        return "#document";
    }

    @Override // org.jsoup.nodes.s
    public final String s() {
        return J();
    }
}

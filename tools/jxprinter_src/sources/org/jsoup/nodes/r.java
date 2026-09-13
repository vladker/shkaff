package org.jsoup.nodes;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r extends s {
    public Object c;

    public final void A() {
        Object obj = this.c;
        if (obj instanceof c) {
            return;
        }
        c cVar = new c();
        this.c = cVar;
        if (obj != null) {
            cVar.put(r(), (String) obj);
        }
    }

    @Override // org.jsoup.nodes.s
    public final String a(String str) {
        A();
        return super.a(str);
    }

    @Override // org.jsoup.nodes.s
    public final s doClone(s sVar) {
        r rVar = (r) super.doClone(sVar);
        Object obj = this.c;
        if (obj instanceof c) {
            rVar.c = ((c) obj).clone();
        }
        return rVar;
    }

    @Override // org.jsoup.nodes.s
    public final String f(String str) {
        V4.h.notNull(str);
        if (this.c instanceof c) {
            return super.f(str);
        }
        return str.equals(r()) ? (String) this.c : "";
    }

    @Override // org.jsoup.nodes.s
    public final void g(String str, String str2) {
        if (!(this.c instanceof c) && str.equals(r())) {
            this.c = str2;
        } else {
            A();
            super.g(str, str2);
        }
    }

    @Override // org.jsoup.nodes.s
    public final c h() {
        A();
        return (c) this.c;
    }

    @Override // org.jsoup.nodes.s
    public final String i() {
        return q() ? parent().i() : "";
    }

    @Override // org.jsoup.nodes.s
    public final int j() {
        return 0;
    }

    @Override // org.jsoup.nodes.s
    public final List n() {
        return s.b;
    }

    @Override // org.jsoup.nodes.s
    public final boolean o(String str) {
        A();
        return super.o("version");
    }

    @Override // org.jsoup.nodes.s
    public final boolean p() {
        return this.c instanceof c;
    }

    public final String z() {
        return f(r());
    }

    @Override // org.jsoup.nodes.s
    public final s m() {
        return this;
    }
}
